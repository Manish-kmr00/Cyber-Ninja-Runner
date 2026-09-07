package com.bytedance.sdk.component.adexpress.dynamic.KZx.pA;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public class ZZv implements View.OnTouchListener {
    private boolean BSW;
    private com.bytedance.sdk.component.adexpress.dynamic.KZx.omh Bzk;
    private float JG;
    private float KZx;
    private boolean ML = true;
    private float Og;
    private float SD;
    private int SGo;
    private float ZZv;
    private boolean omh;
    private float pA;

    public ZZv(com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar, int i, boolean z) {
        this.Bzk = omhVar;
        this.SGo = i;
        this.BSW = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar;
        com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar2;
        com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.pA = motionEvent.getX();
            this.Og = motionEvent.getY();
            this.JG = motionEvent.getY();
            this.ML = true;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.SD = y;
                if (Math.abs(y - this.JG) > 10.0f) {
                    this.omh = true;
                }
                this.ZZv = motionEvent.getX();
                this.KZx = motionEvent.getY();
                if (Math.abs(this.ZZv - this.pA) > 8.0f || Math.abs(this.KZx - this.Og) > 8.0f) {
                    this.ML = false;
                }
            }
        } else {
            if (!this.omh && !this.ML) {
                return false;
            }
            if (!this.BSW && (omhVar3 = this.Bzk) != null) {
                omhVar3.pA();
            } else {
                int iOg = com.bytedance.sdk.component.adexpress.ZZv.omh.Og(com.bytedance.sdk.component.adexpress.ZZv.pA(), Math.abs(this.SD - this.JG));
                if (this.SD - this.JG < 0.0f && iOg > this.SGo && (omhVar2 = this.Bzk) != null) {
                    omhVar2.pA();
                } else if (this.ML && (omhVar = this.Bzk) != null) {
                    omhVar.pA();
                }
            }
        }
        return true;
    }
}
