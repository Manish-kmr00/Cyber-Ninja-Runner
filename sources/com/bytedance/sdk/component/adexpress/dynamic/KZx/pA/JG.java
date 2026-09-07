package com.bytedance.sdk.component.adexpress.dynamic.KZx.pA;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public class JG implements View.OnTouchListener {
    private static int KZx = 10;
    private com.bytedance.sdk.component.adexpress.dynamic.KZx.omh ML;
    private float Og;
    private boolean ZZv;
    private float pA;

    public JG(com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar) {
        this.ML = omhVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.pA = motionEvent.getX();
            this.Og = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.pA) >= KZx || Math.abs(y - this.Og) >= KZx) {
                    this.ZZv = true;
                }
            } else if (action == 3) {
                this.ZZv = false;
            }
        } else {
            if (this.ZZv) {
                this.ZZv = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.pA) >= KZx || Math.abs(y2 - this.Og) >= KZx) {
                this.ZZv = false;
            } else {
                com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar = this.ML;
                if (omhVar != null) {
                    omhVar.pA();
                }
            }
        }
        return true;
    }
}
