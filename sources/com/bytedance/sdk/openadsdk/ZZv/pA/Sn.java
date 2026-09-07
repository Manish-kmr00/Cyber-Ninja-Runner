package com.bytedance.sdk.openadsdk.ZZv.pA;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class Sn {
    public static Sn pA = new Sn();
    private final Map<String, pA> KZx = new HashMap();
    private pA Og;
    private volatile boolean ZZv;

    private int Og() {
        pA pAVar = this.Og;
        if (pAVar != null) {
            return pAVar.pA();
        }
        return 3;
    }

    private int KZx() {
        pA pAVar = this.Og;
        if (pAVar != null) {
            return pAVar.Og();
        }
        return 30;
    }

    public void pA(pA pAVar) {
        this.Og = pAVar;
    }

    public void pA(String str, pA pAVar) {
        if (TextUtils.isEmpty(str) || pAVar == null) {
            return;
        }
        this.KZx.put(str, pAVar);
    }

    public int pA(String str) {
        if (!pA()) {
            return 4;
        }
        pA pAVar = this.KZx.get(str);
        if (pAVar == null) {
            return Og();
        }
        return pAVar.pA();
    }

    public int Og(String str) {
        pA pAVar = this.KZx.get(str);
        if (pAVar == null) {
            return KZx();
        }
        return pAVar.Og();
    }

    public boolean pA() {
        return this.ZZv;
    }

    public void pA(boolean z) {
        this.ZZv = z;
    }

    public static class pA {
        private final int Og;
        private final int pA;

        public pA(int i, int i2) {
            this.pA = (i < 0 || i > 5) ? 3 : i;
            this.Og = i2 < 10 ? 30 : i2;
        }

        public int pA() {
            return this.pA;
        }

        public int Og() {
            return this.Og;
        }
    }
}
