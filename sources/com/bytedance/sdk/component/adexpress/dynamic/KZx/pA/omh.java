package com.bytedance.sdk.component.adexpress.dynamic.KZx.pA;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public class omh implements View.OnTouchListener {
    private float JG;
    private final int KZx = 10;
    private float ML;
    private final boolean Og;
    private float SD;
    private float ZZv;
    private final com.bytedance.sdk.component.adexpress.dynamic.KZx.omh pA;

    public omh(com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar, boolean z) {
        this.pA = omhVar;
        this.Og = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar;
        com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.ZZv = motionEvent.getX();
            this.ML = motionEvent.getY();
            new Object[]{"mStartX: ", Float.valueOf(this.ZZv), ", mStartY: " + this.ML};
        } else if (action == 1) {
            this.JG = motionEvent.getX();
            this.SD = motionEvent.getY();
            new Object[]{"mEndX: ", Float.valueOf(this.JG), ", mEndY: " + this.SD};
            if (!this.Og && (omhVar2 = this.pA) != null) {
                omhVar2.pA();
            } else {
                float f = this.JG - this.ZZv;
                float f2 = this.SD - this.ML;
                float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
                new Object[]{"slideDistancePx: ", Float.valueOf(fSqrt)};
                float fOg = com.bytedance.sdk.component.adexpress.ZZv.omh.Og(com.bytedance.sdk.component.adexpress.ZZv.pA(), Math.abs(fSqrt));
                new Object[]{"slideDistanceDp:", Float.valueOf(fOg), " and ", "mSlideThreshold:", 10};
                if (fOg > 10.0f && (omhVar = this.pA) != null) {
                    omhVar.pA();
                }
            }
        }
        return true;
    }
}
