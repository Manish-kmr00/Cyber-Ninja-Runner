package com.bytedance.adsdk.ugeno.ML;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class KZx {
    float BSW;
    int Bzk;
    int DX;
    int JG;
    int ML;
    int SD;
    float SGo;
    int WV;
    int Wx;
    boolean XT;
    boolean aBv;
    int oX;
    int omh;
    int pA = Integer.MAX_VALUE;
    int Og = Integer.MAX_VALUE;
    int KZx = Integer.MIN_VALUE;
    int ZZv = Integer.MIN_VALUE;
    List<Integer> Sn = new ArrayList();

    KZx() {
    }

    public int pA() {
        return this.SD;
    }

    public int Og() {
        return this.omh - this.Bzk;
    }

    void pA(View view, int i, int i2, int i3, int i4) {
        Og og = (Og) view.getLayoutParams();
        this.pA = Math.min(this.pA, (view.getLeft() - og.Wx()) - i);
        this.Og = Math.min(this.Og, (view.getTop() - og.Sn()) - i2);
        this.KZx = Math.max(this.KZx, view.getRight() + og.DX() + i3);
        this.ZZv = Math.max(this.ZZv, view.getBottom() + og.oX() + i4);
    }
}
