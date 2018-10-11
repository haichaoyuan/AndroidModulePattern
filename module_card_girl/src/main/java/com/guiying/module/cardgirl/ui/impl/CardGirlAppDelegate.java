package com.guiying.module.cardgirl.ui.impl;

import android.content.Context;
import android.webkit.WebView;

import com.guiying.module.common.base.IApplicationDelegate;

/**
 * Author: hc
 * DATE: 2018/10/11 = 上午11:09
 */
public class CardGirlAppDelegate implements IApplicationDelegate {
    @Override
    public void onCreate() {
        //开启一个 全局 WebView
        System.out.println("CardGirlAppDelegate onCreate");
    }

    static WebView myWebView;
    public static WebView getInstance(Context context){
        if(myWebView == null){
            myWebView = new WebView(context);
        }
        return myWebView;
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }
}
