package com.bytedance.sdk.openadsdk.core.Og;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.settings.WV;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes5.dex */
public abstract class KZx implements View.OnClickListener, View.OnTouchListener {
    protected static int IG = 8;
    private static float KZx;
    private static long ML;
    private static float Og;
    private static float ZZv;
    private static float pA;
    protected View rB;
    protected float Sd = -1.0f;
    protected float TX = -1.0f;
    protected float BF = -1.0f;
    protected float WQf = -1.0f;
    protected long TV = -1;
    protected long du = -1;
    protected int eG = -1;
    protected int roi = -1024;
    protected int Mc = -1;
    protected boolean lT = true;
    public SparseArray<pA> xy = new SparseArray<>();
    private int JG = 0;
    private int SD = 0;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/Og/KZx;->onClick(Landroid/view/View;)V");
        CreativeInfoManager.onViewClicked(h.u, view);
        safedk_KZx_onClick_e6fe71baaee6bb5667f0f2f5ff70168c(view);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/Og/KZx;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
        return safedk_KZx_onTouch_cfb641fc847bbee16835dc940c3675bc(view, motionEvent);
    }

    protected abstract void pA(View view, float f, float f2, float f3, float f4, SparseArray<pA> sparseArray, boolean z);

    static {
        if (aBv.pA() != null) {
            IG = aBv.Og();
        }
        pA = 0.0f;
        Og = 0.0f;
        KZx = 0.0f;
        ZZv = 0.0f;
        ML = 0L;
    }

    public void safedk_KZx_onClick_e6fe71baaee6bb5667f0f2f5ff70168c(View p0) {
        if (WV.pA()) {
            pA(p0, this.Sd, this.TX, this.BF, this.WQf, this.xy, this.lT);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0072  */
    public boolean safedk_KZx_onTouch_cfb641fc847bbee16835dc940c3675bc(View p0, MotionEvent p1) {
        int i;
        this.roi = p1.getDeviceId();
        this.eG = p1.getToolType(0);
        this.Mc = p1.getSource();
        int actionMasked = p1.getActionMasked();
        int i2 = 1;
        if (actionMasked != 0) {
            int i3 = 3;
            if (actionMasked == 1) {
                this.BF = p1.getRawX();
                this.WQf = p1.getRawY();
                this.du = System.currentTimeMillis();
                if (Math.abs(this.BF - this.JG) >= IG || Math.abs(this.WQf - this.SD) >= IG) {
                    this.lT = false;
                }
                Point point = new Point((int) this.BF, (int) this.WQf);
                if (p0 != null && !Og.KZx(p0) && pA((View) p0.getParent(), point)) {
                    return true;
                }
            } else if (actionMasked != 2) {
                i3 = actionMasked != 3 ? -1 : 4;
            } else {
                KZx += Math.abs(p1.getX() - pA);
                ZZv += Math.abs(p1.getY() - Og);
                pA = p1.getX();
                Og = p1.getY();
                if (System.currentTimeMillis() - ML > 200) {
                    float f = KZx;
                    int i4 = IG;
                    if (f <= i4 && ZZv <= i4) {
                        i2 = 2;
                    }
                } else {
                    i2 = 2;
                }
                this.BF = p1.getRawX();
                this.WQf = p1.getRawY();
                if (Math.abs(this.BF - this.JG) >= IG || Math.abs(this.WQf - this.SD) >= IG) {
                    this.lT = false;
                }
                i = i2;
            }
            i = i3;
        } else {
            this.JG = (int) p1.getRawX();
            this.SD = (int) p1.getRawY();
            this.Sd = p1.getRawX();
            this.TX = p1.getRawY();
            this.TV = System.currentTimeMillis();
            this.eG = p1.getToolType(0);
            this.roi = p1.getDeviceId();
            this.Mc = p1.getSource();
            ML = System.currentTimeMillis();
            this.lT = true;
            this.rB = p0;
            com.bytedance.sdk.openadsdk.core.Bzk.KZx.pA(p1);
            i = 0;
        }
        this.xy.put(p1.getActionMasked(), new pA(i, p1.getSize(), p1.getPressure(), System.currentTimeMillis()));
        return false;
    }

    private boolean pA(View view, Point point) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (Og.KZx(childAt)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    return view.isShown() && point.x >= iArr[0] && point.x <= iArr[0] + childAt.getWidth() && point.y >= iArr[1] && point.y <= iArr[1] + childAt.getHeight();
                }
                if (pA(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class pA {
        public double KZx;
        public double Og;
        public long ZZv;
        public int pA;

        public pA(int i, double d, double d2, long j) {
            this.pA = i;
            this.Og = d;
            this.KZx = d2;
            this.ZZv = j;
        }
    }

    public boolean SD() {
        return this.lT;
    }
}
