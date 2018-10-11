package com.guiying.module.cardgirl.ui.impl.ui.impl;

import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewParent;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guiying.module.cardgirl.R;
import com.guiying.module.cardgirl.ui.impl.CardGirlAppDelegate;
import com.guiying.module.cardgirl.ui.impl.presenter.IMyWebPresenter;
import com.guiying.module.cardgirl.ui.impl.ui.IMyWebView;
import com.guiying.module.common.base.BaseActionBarActivity;

import static android.webkit.WebSettings.LOAD_DEFAULT;

/**
 * Desc: 测试 WebView 的 MyWebActivity
 * Company: XueHai
 *
 * @author hc
 */
@Route(path = "/card_girl/webview")
public class MyWebActivity extends BaseActionBarActivity implements IMyWebView {

    private WebView mWebView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web);
        frameLayout = findViewById(R.id.web_container);
        initWebView();
    }

    private void initWebView() {
        mWebView = CardGirlAppDelegate.getInstance(this.getApplicationContext());
        ViewParent parent = mWebView.getParent();
        if (parent != null && parent instanceof FrameLayout) {
            FrameLayout parentLayout = (FrameLayout) parent;
            parentLayout.removeAllViews();
        }

        frameLayout.addView(mWebView);
        mWebView.loadUrl("file:///android_asset/ppt/5281a115ce50f8fd676e56b295aee5e4/index.html");
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setCacheMode(LOAD_DEFAULT);//离线使用缓存
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //同时有https和http  算mixed content
            //webview 5.0默认不支持mixed content
            mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }


        });
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }
        });
        mWebView.setOnLongClickListener(v -> true);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        frameLayout.removeAllViews();
    }

    @Override
    protected int setTitleId() {
        return R.string.card_girls_activity_title;
    }

    @Override
    public void setPresenter(IMyWebPresenter presenter) {

    }
}
