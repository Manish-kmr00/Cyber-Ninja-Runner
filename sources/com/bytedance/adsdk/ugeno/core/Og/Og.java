package com.bytedance.adsdk.ugeno.core.Og;

import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.core.SGo;
import com.bytedance.adsdk.ugeno.core.WV;

/* JADX INFO: loaded from: classes2.dex */
public class Og {
    private SGo KZx;
    private boolean ML;
    private float Og;
    private Context ZZv;
    private float pA;

    public Og(Context context, SGo sGo) {
        this.ZZv = context;
        this.KZx = sGo;
    }

    public boolean pA(WV wv, com.bytedance.adsdk.ugeno.Og.KZx kZx, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.pA = motionEvent.getX();
            this.Og = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.pA) >= 15.0f || Math.abs(y - this.Og) >= 15.0f) {
                    this.ML = true;
                }
            } else if (action == 3) {
                this.ML = false;
            }
        } else {
            if (this.ML) {
                this.ML = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.pA) >= 15.0f || Math.abs(y2 - this.Og) >= 15.0f) {
                this.ML = false;
            } else if (wv != null) {
                wv.pA(this.KZx, kZx, kZx);
                return true;
            }
        }
        return true;
    }
}
