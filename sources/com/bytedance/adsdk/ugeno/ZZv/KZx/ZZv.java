package com.bytedance.adsdk.ugeno.ZZv.KZx;

import android.content.Context;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes11.dex */
public class ZZv extends pA {
    private boolean BSW;
    private float Bzk;
    private float SGo;

    public ZZv(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.ZZv.KZx.pA
    public boolean pA(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        return pA(this.Og, (MotionEvent) objArr[0]);
    }

    public boolean pA(com.bytedance.adsdk.ugeno.Og.KZx kZx, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Bzk = motionEvent.getRawX();
            this.SGo = motionEvent.getRawY();
        } else if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (Math.abs(rawX - this.Bzk) >= 15.0f || Math.abs(rawY - this.SGo) >= 15.0f) {
                    this.BSW = true;
                }
            } else if (action == 3) {
                this.BSW = false;
            }
        } else {
            if (this.BSW) {
                this.BSW = false;
                this.Bzk = 0.0f;
                this.SGo = 0.0f;
                return false;
            }
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            if (Math.abs(rawX2 - this.Bzk) >= 15.0f || Math.abs(rawY2 - this.SGo) >= 15.0f) {
                this.BSW = false;
            } else if (this.pA != null) {
                this.pA.pA(kZx, this.JG, this.KZx.Og());
                this.Bzk = 0.0f;
                this.SGo = 0.0f;
                return true;
            }
        }
        return true;
    }
}
