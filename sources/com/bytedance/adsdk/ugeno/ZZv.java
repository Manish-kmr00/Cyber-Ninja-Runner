package com.bytedance.adsdk.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.ZZv.JG;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ZZv {
    private static volatile ZZv pA;
    private com.bytedance.adsdk.ugeno.core.Og.KZx JG;
    private com.bytedance.adsdk.ugeno.core.KZx KZx;
    private com.bytedance.adsdk.ugeno.KZx.pA ML;
    private List<com.bytedance.adsdk.ugeno.core.Og> Og;
    private pA ZZv;

    public static ZZv pA() {
        if (pA == null) {
            synchronized (ZZv.class) {
                if (pA == null) {
                    pA = new ZZv();
                }
            }
        }
        return pA;
    }

    private ZZv() {
    }

    public void pA(Context context, com.bytedance.adsdk.ugeno.core.KZx kZx, pA pAVar) {
        this.KZx = kZx;
        this.ZZv = pAVar;
        ML();
    }

    public pA Og() {
        return this.ZZv;
    }

    private void ML() {
        ArrayList arrayList = new ArrayList();
        this.Og = arrayList;
        com.bytedance.adsdk.ugeno.core.KZx kZx = this.KZx;
        if (kZx != null) {
            arrayList.addAll(kZx.pA());
        }
        com.bytedance.adsdk.ugeno.core.ZZv.pA(this.Og);
    }

    public void pA(com.bytedance.adsdk.ugeno.KZx.pA pAVar) {
        this.ML = pAVar;
    }

    public com.bytedance.adsdk.ugeno.KZx.pA KZx() {
        return this.ML;
    }

    public void pA(com.bytedance.adsdk.ugeno.ZZv.ZZv zZv) {
        ArrayList arrayList = new ArrayList(new com.bytedance.adsdk.ugeno.ZZv.pA().pA());
        if (zZv != null) {
            arrayList.addAll(zZv.pA());
        }
        JG.pA(arrayList);
    }

    public com.bytedance.adsdk.ugeno.core.Og.KZx ZZv() {
        return this.JG;
    }
}
