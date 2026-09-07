package com.bytedance.sdk.component.adexpress.dynamic.KZx.pA;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.KZx.Bzk;

/* JADX INFO: loaded from: classes14.dex */
public class Og implements View.OnTouchListener {
    private com.bytedance.sdk.component.adexpress.dynamic.KZx.omh JG;
    private long KZx;
    private Bzk ML;
    private float Og;
    private boolean ZZv;
    private float pA;

    public Og(Bzk bzk, com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar) {
        this.ML = bzk;
        this.JG = omhVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.KZx = System.currentTimeMillis();
            this.pA = motionEvent.getX();
            this.Og = motionEvent.getY();
            this.ML.ML();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.pA) >= com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), 10.0f) || Math.abs(y - this.Og) >= com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), 10.0f)) {
                    this.ZZv = true;
                    this.ML.JG();
                }
            }
        } else {
            if (this.ZZv) {
                return false;
            }
            if (System.currentTimeMillis() - this.KZx >= 1500) {
                com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar = this.JG;
                if (omhVar != null) {
                    omhVar.pA();
                }
            } else {
                this.ML.JG();
            }
        }
        return true;
    }
}
