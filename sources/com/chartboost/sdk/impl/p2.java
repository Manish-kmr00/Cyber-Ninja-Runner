package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/impl/p2;", "Landroid/webkit/WebView;", "Landroid/webkit/WebChromeClient;", "client", "", "setWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "a", "()V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public class p2 extends WebView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private void safedk_webview_p2_webviewSetWebChromeClient_125764fdd2f003b0a7114b2bd8a34776(WebChromeClient p1) {
        Logger.d("ChartboostNetwork|SafeDK: Partial-Network> Lcom/chartboost/sdk/impl/p2;->safedk_webview_p2_webviewSetWebChromeClient_125764fdd2f003b0a7114b2bd8a34776(Landroid/webkit/WebChromeClient;)V");
        boolean z = SafeDK.getInstance() != null && SafeDK.getInstance().p();
        Logger.d("SafeDKNetwork", "webviewSetWebChromeClient invoked, WebView address : " + this + ", WebChromeClient = " + p1 + ", SDK_PACKAGE_NAME = " + com.safedk.android.utils.h.c);
        if (z) {
            BrandSafetyUtils.a(com.safedk.android.utils.h.c, this, p1);
        }
        super.setWebChromeClient(p1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.c, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient client) {
        safedk_webview_p2_webviewSetWebChromeClient_125764fdd2f003b0a7114b2bd8a34776(client);
        a();
    }

    public final void a() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowContentAccess(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
    }
}
