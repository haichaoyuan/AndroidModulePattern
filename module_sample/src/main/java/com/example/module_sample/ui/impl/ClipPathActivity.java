package com.example.module_sample.ui.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import com.guiying.module.common.base.BaseActivity;

/**
 * Desc: ClipPath 的 ClipPathActivity
 * Company: XueHai
 *
 * @author hc
 */
public class ClipPathActivity extends BaseActivity {

    public static Bitmap getRoundedShape(Bitmap scaleBitmapImage, float radius, int margin){
        //指定宽高的画布，
        int targetWidth = scaleBitmapImage.getWidth() - margin;
        int targetHeight = scaleBitmapImage.getHeight()- margin;
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(targetBitmap);
        //圆角
        Path  path = new Path();
        path.addRoundRect(new RectF(margin, margin, targetWidth, targetHeight), radius, radius, Path.Direction.CW);
        //核心方法， clipPath,模板
        canvas.clipPath(path);
        canvas.drawBitmap(scaleBitmapImage, new Rect(0, 0, scaleBitmapImage.getWidth(), scaleBitmapImage.getHeight()),
                new Rect(0, 0, targetWidth, targetHeight), null);
        return targetBitmap;
    }

    public static Bitmap getRoundShapeByXfermode(Bitmap bitmap, int roundPx){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect srcRect = new Rect(0, 0, width, height);
        final Rect destRect = new Rect(0, 0, width, height);
        final RectF rectF = new RectF(destRect);
        paint.setAntiAlias(true);//抗锯齿
        paint.setDither(true);//防抖动
        paint.setFilterBitmap(true);
        canvas.drawARGB(0, 0,0,0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        //核心方法，setXfermode
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, srcRect, destRect, paint);
        return output;

    }
}
