package com.pubmatic.sdk.common.view;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.pubmatic.sdk.common.log.POBLog;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class POBWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebViewBackPress f7647a;
    private OnFocusChangedListener b;
    private MutableContextWrapper c;

    public interface OnFocusChangedListener {
        void onFocusChanged(boolean z);
    }

    public interface WebViewBackPress {
        void onBackPress();
    }

    protected POBWebView(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public static POBWebView createInstance(Context context) {
        POBWebView pOBWebView;
        try {
            MutableContextWrapper mutableContextWrapper = new MutableContextWrapper(context);
            pOBWebView = new POBWebView(mutableContextWrapper);
            try {
                pOBWebView.c = mutableContextWrapper;
            } catch (Exception unused) {
                POBLog.error("POBWebView", "Unable to instantiate Web View", new Object[0]);
            }
        } catch (Exception unused2) {
            pOBWebView = null;
        }
        return pOBWebView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (i == 4) {
                WebViewBackPress webViewBackPress = this.f7647a;
                if (webViewBackPress != null) {
                    webViewBackPress.onBackPress();
                    return true;
                }
            } else {
                POBLog.debug("POBWebView", "default case, keyCode:" + i, new Object[0]);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        POBLog.debug("POBWebView", "hasWindowFocus :" + z, new Object[0]);
        OnFocusChangedListener onFocusChangedListener = this.b;
        if (onFocusChangedListener != null) {
            onFocusChangedListener.onFocusChanged(z);
        }
    }

    public void setBaseContext(Context context) {
        MutableContextWrapper mutableContextWrapper = this.c;
        if (mutableContextWrapper != null) {
            mutableContextWrapper.setBaseContext(context);
        }
    }

    public void setOnfocusChangedListener(OnFocusChangedListener onFocusChangedListener) {
        this.b = onFocusChangedListener;
    }

    public void setWebViewBackPress(WebViewBackPress webViewBackPress) {
        this.f7647a = webViewBackPress;
    }
}
