package com.smaato.sdk.core.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.SmaatoNetworkBridge;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes3.dex */
public class BaseWebView extends WebView {
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
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

    public BaseWebView(Context context) {
        super(context.getApplicationContext());
        init();
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context.getApplicationContext(), attributeSet);
        init();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context.getApplicationContext(), attributeSet, i);
        init();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context.getApplicationContext(), attributeSet, i, i2);
        init();
    }

    private void init() {
        initWebViewSettings();
    }

    public void loadHtml(String str) {
        SmaatoNetworkBridge.webviewLoadDataWithBaseURL(this, null, str, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
    }

    private void initWebViewSettings() {
        getSettings().setJavaScriptEnabled(true);
        disableContentAccess();
    }

    private void disableContentAccess() {
        getSettings().setAllowContentAccess(false);
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
    }
}
