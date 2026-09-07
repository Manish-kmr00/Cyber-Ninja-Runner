package net.pubnative.lite.sdk.mraid;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class MRAIDBanner extends MRAIDView {
    @Override // net.pubnative.lite.sdk.mraid.MRAIDView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.C, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public MRAIDBanner(Context context, String str, String str2, Boolean bool, Boolean bool2, String[] strArr, MRAIDViewListener mRAIDViewListener, MRAIDNativeFeatureListener mRAIDNativeFeatureListener, ViewGroup viewGroup) {
        super(context, str, str2, bool, strArr, mRAIDViewListener, mRAIDNativeFeatureListener, viewGroup, false, bool2.booleanValue());
        if (this.webView != null) {
            this.webView.setBackgroundColor(0);
            addView(this.webView, new FrameLayout.LayoutParams(-1, -1));
        } else if (mRAIDViewListener != null) {
            mRAIDViewListener.mraidViewError(this);
        }
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDView
    public boolean onBackPressed() {
        return this.state != 1 && super.onBackPressed();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDView
    @Deprecated
    protected void expand(String str, Boolean bool, MRAIDView.OnExpandCreativeFailListener onExpandCreativeFailListener) {
        if (this.state == 1 || this.state == 3) {
            super.expand(str, bool, onExpandCreativeFailListener);
        }
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDView
    protected void expandHelper(WebView webView) {
        this.state = 2;
        super.expandHelper(webView);
        fireStateChangeEvent();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDView
    protected void onLayoutCompleted() {
        if (this.state == 0 && this.isPageFinished) {
            this.state = 1;
            fireStateChangeEvent();
            fireReadyEvent();
            setViewable(getVisibility());
        }
    }
}
