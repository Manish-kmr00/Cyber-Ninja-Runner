package com.bytedance.sdk.component.JG.pA;

import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
public class omh {
    private static volatile com.bytedance.sdk.component.JG.pA.ML.pA SGo;
    private static omh Wx;
    private volatile com.bytedance.sdk.component.JG.pA.Og.KZx BSW;
    private volatile ML Bzk;
    private long DX;
    private volatile com.bytedance.sdk.component.JG.pA.ZZv.Og.pA JG;
    private volatile com.bytedance.sdk.component.JG.pA.ZZv.Og.pA KZx;
    private volatile com.bytedance.sdk.component.JG.pA.ZZv.Og.pA ML;
    private volatile com.bytedance.sdk.component.JG.pA.ZZv.Og.pA Og;
    private volatile com.bytedance.sdk.component.JG.pA.pA.ML SD;
    private final AtomicBoolean Sn = new AtomicBoolean(false);
    private volatile Map<Integer, com.bytedance.sdk.component.JG.pA.Og.KZx> WV;
    private volatile com.bytedance.sdk.component.JG.pA.ZZv.Og.pA ZZv;
    private volatile boolean omh;
    private volatile Context pA;

    public boolean pA() {
        return this.Sn.get();
    }

    public void pA(boolean z) {
        this.Sn.set(z);
    }

    public boolean Og() {
        return this.omh;
    }

    public void Og(boolean z) {
        this.omh = z;
    }

    public Map<Integer, com.bytedance.sdk.component.JG.pA.Og.KZx> KZx() {
        return this.WV;
    }

    public com.bytedance.sdk.component.JG.pA.pA.ML ZZv() {
        return this.SD;
    }

    public static com.bytedance.sdk.component.JG.pA.ML.pA ML() {
        if (SGo == null) {
            synchronized (omh.class) {
                if (SGo == null) {
                    SGo = new com.bytedance.sdk.component.JG.pA.ML.Og();
                }
            }
        }
        return SGo;
    }

    public void pA(com.bytedance.sdk.component.JG.pA.pA.ML ml) {
        this.SD = ml;
    }

    public Context JG() {
        return this.pA;
    }

    public void pA(Context context) {
        this.pA = context;
    }

    private omh() {
    }

    public static synchronized omh SD() {
        if (Wx == null) {
            Wx = new omh();
        }
        return Wx;
    }

    public void pA(com.bytedance.sdk.component.JG.pA.Og.KZx kZx) {
        this.BSW = kZx;
    }

    public com.bytedance.sdk.component.JG.pA.Og.KZx omh() {
        return this.BSW;
    }

    public void Bzk() {
        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og();
    }

    public com.bytedance.sdk.component.JG.pA.ZZv.Og.pA SGo() {
        return this.JG;
    }

    public void pA(com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar) {
        this.JG = pAVar;
    }

    public void BSW() {
        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx();
    }

    public void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar) {
        if (pAVar == null) {
            return;
        }
        pAVar.pA(System.currentTimeMillis());
        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.pA(pAVar, pAVar.ZZv());
    }

    public void pA(String str, boolean z) {
        com.bytedance.sdk.component.JG.pA.JG.pA.pA().pA(str, z);
    }

    public void pA(String str, List<String> list, boolean z, Map<String, String> map, int i, String str2) {
        com.bytedance.sdk.component.JG.pA.JG.pA.pA().pA(str, list, z, map, i, str2);
    }

    public void Og(com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar) {
        this.Og = pAVar;
    }

    public com.bytedance.sdk.component.JG.pA.ZZv.Og.pA WV() {
        return this.Og;
    }

    public void KZx(com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar) {
        this.KZx = pAVar;
    }

    public com.bytedance.sdk.component.JG.pA.ZZv.Og.pA Wx() {
        return this.KZx;
    }

    public void ZZv(com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar) {
        this.ZZv = pAVar;
    }

    public com.bytedance.sdk.component.JG.pA.ZZv.Og.pA Sn() {
        return this.ZZv;
    }

    public com.bytedance.sdk.component.JG.pA.ZZv.Og.pA DX() {
        return this.ML;
    }

    public void ML(com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar) {
        this.ML = pAVar;
    }

    public void pA(ML ml) {
        this.Bzk = ml;
    }

    public ML oX() {
        return this.Bzk;
    }

    public void pA(long j) {
        this.DX = j;
    }

    public long aBv() {
        return this.DX * 86400000;
    }
}
