package net.pubnative.lite.sdk.utils.browser;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.VerveNetworkBridge;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class BaseWebView extends WebView {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String DEFAULT_MIME_TYPE = "text/html";

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.C, this, me);
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

    private void init() {
        initWebViewSettings();
    }

    public void loadHtml(String str) {
        if (str != null) {
            VerveNetworkBridge.webviewLoadDataWithBaseURL(this, null, str, "text/html", "UTF-8", null);
        }
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
