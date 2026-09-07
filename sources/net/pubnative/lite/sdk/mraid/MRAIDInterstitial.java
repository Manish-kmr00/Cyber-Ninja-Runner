package net.pubnative.lite.sdk.mraid;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes5.dex */
public class MRAIDInterstitial extends MRAIDView {
    private Boolean isCreatedByFeedbackForm;

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

    public MRAIDInterstitial(Context context, String str, String str2, Boolean bool, Boolean bool2, String[] strArr, MRAIDViewListener mRAIDViewListener, MRAIDNativeFeatureListener mRAIDNativeFeatureListener, ViewGroup viewGroup) {
        super(context, str, str2, bool, strArr, mRAIDViewListener, mRAIDNativeFeatureListener, viewGroup, true, bool2.booleanValue());
        this.isCreatedByFeedbackForm = false;
        this.webView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.webView);
    }

    public void hide() {
        close();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDView
    @Deprecated
    protected void expand(String str, Boolean bool, MRAIDView.OnExpandCreativeFailListener onExpandCreativeFailListener) {
        if (this.state != 0) {
            return;
        }
        super.expand(str, bool, onExpandCreativeFailListener);
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDView
    protected void expandHelper(WebView webView) {
        super.expandHelper(webView);
        this.isLaidOut = true;
        this.state = 1;
        fireStateChangeEvent();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDView
    public void closeFromExpanded() {
        if (this.state == 1) {
            this.state = 4;
            clearView();
            this.handler.post(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDInterstitial$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9643x6cdadb7e();
                }
            });
        }
        super.closeFromExpanded();
    }

    /* JADX INFO: renamed from: lambda$closeFromExpanded$0$net-pubnative-lite-sdk-mraid-MRAIDInterstitial, reason: not valid java name */
    /* synthetic */ void m9643x6cdadb7e() {
        fireStateChangeEvent();
        if (this.listener != null) {
            this.listener.mraidViewClose(this);
        }
    }

    public void show(Activity activity, MRAIDView.OnExpandCreativeFailListener onExpandCreativeFailListener) {
        showAsInterstitial(activity, this.isCreatedByFeedbackForm, onExpandCreativeFailListener);
    }

    public void show(Activity activity, MRAIDView.OnExpandCreativeFailListener onExpandCreativeFailListener, String str) {
        showAsInterstitial(activity, this.isCreatedByFeedbackForm, onExpandCreativeFailListener, str);
    }

    public void showDefaultContentInfoURL(String str) {
        expandContentInfo(str);
    }

    public void markCreativeAdComingFromFeedbackForm() {
        this.isCreatedByFeedbackForm = true;
    }
}
