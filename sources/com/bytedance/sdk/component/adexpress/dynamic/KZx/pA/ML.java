package com.bytedance.sdk.component.adexpress.dynamic.KZx.pA;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public class ML implements View.OnTouchListener {
    private boolean KZx;
    private int ML;
    private float Og;
    private com.bytedance.sdk.component.adexpress.dynamic.KZx.omh ZZv;
    private float pA;

    public ML(com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar, int i) {
        this.ZZv = omhVar;
        this.ML = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.pA = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.Og = y;
                if (Math.abs(y - this.pA) > 10.0f) {
                    this.KZx = true;
                }
            }
        } else {
            if (!this.KZx) {
                return false;
            }
            int iOg = com.bytedance.sdk.component.adexpress.ZZv.omh.Og(com.bytedance.sdk.component.adexpress.ZZv.pA(), Math.abs(this.Og - this.pA));
            if (this.Og - this.pA < 0.0f && iOg > this.ML && (omhVar = this.ZZv) != null) {
                omhVar.pA();
                this.pA = 0.0f;
                this.Og = 0.0f;
                this.KZx = false;
            }
        }
        return true;
    }
}
