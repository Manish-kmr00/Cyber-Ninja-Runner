package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class BSW extends omh {
    private long Og;
    private long pA;

    @Override // com.bytedance.sdk.openadsdk.core.widget.omh, com.bytedance.sdk.openadsdk.core.ML.SD, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.omh, com.bytedance.sdk.openadsdk.core.ML.SD, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.omh
    protected boolean pA() {
        return false;
    }

    public BSW(Context context) {
        super(context);
        setVisibility(8);
        setClickable(true);
    }

    public void KZx() {
        setVisibility(8);
        if (this.pA != 0) {
            this.Og = SystemClock.elapsedRealtime();
        }
    }

    public void Og(com.bytedance.sdk.openadsdk.core.model.yFO yfo, int i) {
        if (isShown()) {
            return;
        }
        Og();
        setVisibility(0);
        this.pA = SystemClock.elapsedRealtime();
        pA(yfo, i);
    }

    public boolean ZZv() {
        return this.pA > 0 && this.Og > 0;
    }

    public long getDisplayDuration() {
        if (this.pA == 0) {
            return 0L;
        }
        if (this.Og == 0) {
            this.Og = SystemClock.elapsedRealtime();
        }
        return this.Og - this.pA;
    }
}
