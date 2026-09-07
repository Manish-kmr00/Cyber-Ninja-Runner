package com.bytedance.adsdk.ugeno.core.Og;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.SD.omh;
import com.bytedance.adsdk.ugeno.core.SGo;
import com.bytedance.adsdk.ugeno.core.WV;

/* JADX INFO: loaded from: classes4.dex */
public class ZZv {
    private String JG;
    private SGo ML;
    private Context SD;
    private SGo ZZv;
    private boolean omh;
    private float pA = Float.MIN_VALUE;
    private float Og = Float.MIN_VALUE;
    private int KZx = 0;

    public ZZv(Context context, SGo sGo, boolean z) {
        this.SD = context;
        this.ZZv = sGo;
        this.omh = z;
        Og();
    }

    public ZZv(Context context, SGo sGo, SGo sGo2, boolean z) {
        this.SD = context;
        this.ZZv = sGo;
        this.ML = sGo2;
        this.omh = z;
        Og();
    }

    private void Og() {
        SGo sGo = this.ZZv;
        if (sGo == null) {
            return;
        }
        this.KZx = sGo.KZx().optInt("slideThreshold");
        this.JG = this.ZZv.KZx().optString("slideDirection");
    }

    public void pA() {
        this.pA = Float.MIN_VALUE;
        this.Og = Float.MIN_VALUE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007a  */
    /* JADX WARN: Code duplicated, block: B:31:0x007c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0086  */
    /* JADX WARN: Code duplicated, block: B:35:0x0090  */
    /* JADX WARN: Code duplicated, block: B:36:0x0092  */
    /* JADX WARN: Code duplicated, block: B:39:0x009d  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c8  */
    public boolean pA(WV wv, com.bytedance.adsdk.ugeno.Og.KZx kZx, MotionEvent motionEvent) {
        float x;
        float y;
        int iOg;
        int iOg2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.pA = motionEvent.getX();
            this.Og = motionEvent.getY();
        } else if (action == 1) {
            x = motionEvent.getX();
            y = motionEvent.getY();
            if (!this.omh && Math.abs(x - this.pA) <= 10.0f && Math.abs(y - this.Og) <= 10.0f && wv != null) {
                pA();
                wv.pA(this.ML, kZx, kZx);
                return true;
            }
            if (this.KZx != 0 && wv != null) {
                pA();
                wv.pA(this.ZZv, kZx, kZx);
                return true;
            }
            iOg = omh.Og(this.SD, x - this.pA);
            iOg2 = omh.Og(this.SD, y - this.Og);
            if (TextUtils.equals(this.JG, "up")) {
                iOg = -iOg2;
            } else if (!TextUtils.equals(this.JG, "down")) {
                iOg = iOg2;
            } else if (TextUtils.equals(this.JG, "left")) {
                iOg = -iOg;
            } else if (!TextUtils.equals(this.JG, "right")) {
                iOg = (int) Math.abs(Math.sqrt(Math.pow(iOg, 2.0d) + Math.pow(iOg2, 2.0d)));
            }
            if (iOg >= this.KZx) {
                pA();
                return false;
            }
            if (wv != null) {
                pA();
                wv.pA(this.ZZv, kZx, kZx);
                return true;
            }
            pA();
        } else if (action == 3) {
            if (this.pA == Float.MIN_VALUE || this.Og == Float.MIN_VALUE) {
                return false;
            }
            x = motionEvent.getX();
            y = motionEvent.getY();
            if (!this.omh) {
            }
            if (this.KZx != 0) {
            }
            iOg = omh.Og(this.SD, x - this.pA);
            iOg2 = omh.Og(this.SD, y - this.Og);
            if (TextUtils.equals(this.JG, "up")) {
                iOg = -iOg2;
            } else if (!TextUtils.equals(this.JG, "down")) {
                iOg = iOg2;
            } else if (TextUtils.equals(this.JG, "left")) {
                iOg = -iOg;
            } else if (!TextUtils.equals(this.JG, "right")) {
                iOg = (int) Math.abs(Math.sqrt(Math.pow(iOg, 2.0d) + Math.pow(iOg2, 2.0d)));
            }
            if (iOg >= this.KZx) {
                pA();
                return false;
            }
            if (wv != null) {
                pA();
                wv.pA(this.ZZv, kZx, kZx);
                return true;
            }
            pA();
        }
        return true;
    }
}
