package com.bytedance.sdk.openadsdk.core.Og;

import android.util.SparseArray;
import android.view.MotionEvent;
import com.bytedance.sdk.openadsdk.core.aBv;

/* JADX INFO: loaded from: classes9.dex */
public class JG {
    private static float DX = 0.0f;
    public static int SGo = 8;
    private static float Sn;
    private static float Wx;
    private static long aBv;
    private static float oX;
    public float pA = -1.0f;
    public float Og = -1.0f;
    public float KZx = -1.0f;
    public float ZZv = -1.0f;
    public long ML = -1;
    public long JG = -1;
    public int SD = -1;
    public int omh = -1024;
    public int Bzk = -1;
    public boolean BSW = true;
    public SparseArray<KZx.pA> WV = new SparseArray<>();
    private int XT = 0;
    private int yFO = 0;

    static {
        if (aBv.pA() != null) {
            SGo = aBv.Og();
        }
        Wx = 0.0f;
        Sn = 0.0f;
        DX = 0.0f;
        oX = 0.0f;
        aBv = 0L;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0072  */
    public void pA(MotionEvent motionEvent) {
        int i;
        this.omh = motionEvent.getDeviceId();
        int i2 = 0;
        this.SD = motionEvent.getToolType(0);
        this.Bzk = motionEvent.getSource();
        int actionMasked = motionEvent.getActionMasked();
        int i3 = 1;
        if (actionMasked == 0) {
            this.XT = (int) motionEvent.getRawX();
            this.yFO = (int) motionEvent.getRawY();
            this.pA = motionEvent.getRawX();
            this.Og = motionEvent.getRawY();
            this.ML = System.currentTimeMillis();
            this.SD = motionEvent.getToolType(0);
            this.omh = motionEvent.getDeviceId();
            this.Bzk = motionEvent.getSource();
            aBv = System.currentTimeMillis();
            this.BSW = true;
        } else {
            if (actionMasked == 1) {
                this.KZx = motionEvent.getRawX();
                this.ZZv = motionEvent.getRawY();
                this.JG = System.currentTimeMillis();
                if (Math.abs(this.KZx - this.XT) >= SGo || Math.abs(this.ZZv - this.yFO) >= SGo) {
                    this.BSW = false;
                }
                i = 3;
            } else if (actionMasked != 2) {
                i2 = actionMasked != 3 ? -1 : 4;
            } else {
                DX += Math.abs(motionEvent.getX() - Wx);
                oX += Math.abs(motionEvent.getY() - Sn);
                Wx = motionEvent.getX();
                Sn = motionEvent.getY();
                if (System.currentTimeMillis() - aBv > 200) {
                    float f = DX;
                    int i4 = SGo;
                    if (f <= i4 && oX <= i4) {
                        i3 = 2;
                    }
                } else {
                    i3 = 2;
                }
                this.KZx = motionEvent.getRawX();
                this.ZZv = motionEvent.getRawY();
                if (Math.abs(this.KZx - this.XT) >= SGo || Math.abs(this.ZZv - this.yFO) >= SGo) {
                    this.BSW = false;
                }
                i = i3;
            }
            this.WV.put(motionEvent.getActionMasked(), new KZx.pA(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        i = i2;
        this.WV.put(motionEvent.getActionMasked(), new KZx.pA(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
    }
}
