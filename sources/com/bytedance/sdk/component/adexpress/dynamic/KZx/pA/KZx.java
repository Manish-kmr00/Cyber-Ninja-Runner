package com.bytedance.sdk.component.adexpress.dynamic.KZx.pA;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public class KZx implements View.OnTouchListener {
    private boolean Bzk;
    private com.bytedance.sdk.component.adexpress.dynamic.KZx.omh JG;
    private float KZx;
    private boolean ML;
    private float Og;
    private int SD;
    private float ZZv;
    private boolean omh;
    private float pA;

    public KZx(com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar) {
        this(omhVar, 5);
    }

    public KZx(com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar, int i) {
        this.SD = 5;
        this.omh = true;
        this.JG = omhVar;
        if (i > 0) {
            this.SD = i;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar;
        com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar2;
        com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar3;
        if (this.Bzk) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.pA = motionEvent.getX();
            this.Og = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.ZZv = motionEvent.getX();
                this.KZx = motionEvent.getY();
                if (Math.abs(this.ZZv - this.pA) > 10.0f) {
                    this.ML = true;
                }
                if (Math.abs(this.ZZv - this.pA) > 8.0f || Math.abs(this.KZx - this.Og) > 8.0f) {
                    this.omh = false;
                }
                int iOg = com.bytedance.sdk.component.adexpress.ZZv.omh.Og(com.bytedance.sdk.component.adexpress.ZZv.pA(), Math.abs(this.ZZv - this.pA));
                if (this.ZZv > this.pA && iOg > this.SD && (omhVar3 = this.JG) != null) {
                    omhVar3.pA();
                    this.Bzk = true;
                }
            }
        } else {
            if (!this.ML && !this.omh) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int iOg2 = com.bytedance.sdk.component.adexpress.ZZv.omh.Og(com.bytedance.sdk.component.adexpress.ZZv.pA(), Math.abs(this.ZZv - this.pA));
            if (this.ZZv > this.pA && iOg2 > this.SD && (omhVar2 = this.JG) != null) {
                omhVar2.pA();
                this.Bzk = true;
            }
            float fAbs = Math.abs(x - this.pA);
            float fAbs2 = Math.abs(y - this.Og);
            if ((fAbs < 8.0f || fAbs2 < 8.0f) && (omhVar = this.JG) != null) {
                omhVar.Og();
                this.Bzk = true;
            }
        }
        return true;
    }
}
