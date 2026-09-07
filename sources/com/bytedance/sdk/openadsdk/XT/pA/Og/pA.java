package com.bytedance.sdk.openadsdk.XT.pA.Og;

import com.bytedance.sdk.openadsdk.core.aBv;
import com.json.fe;

/* JADX INFO: loaded from: classes14.dex */
public class pA {
    private static volatile pA Og;
    private String pA = "";

    public static pA pA() {
        if (Og == null) {
            synchronized (pA.class) {
                if (Og == null) {
                    Og = new pA();
                }
            }
        }
        return Og;
    }

    private pA() {
    }

    public String Og() {
        if (aBv.ZZv().roi(fe.Q0)) {
            return this.pA;
        }
        return "";
    }

    public void pA(String str) {
        this.pA = str;
    }
}
