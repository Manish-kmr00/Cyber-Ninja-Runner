package net.pubnative.lite.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes.dex */
public class PNAdView extends HyBidAdView {

    public interface Listener extends HyBidAdView.Listener {
    }

    @Override // net.pubnative.lite.sdk.views.HyBidAdView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.C, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // net.pubnative.lite.sdk.views.HyBidAdView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public PNAdView(Context context) {
        super(context);
    }

    public PNAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PNAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PNAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
