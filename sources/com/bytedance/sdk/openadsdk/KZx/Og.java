package com.bytedance.sdk.openadsdk.KZx;

import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.yFO;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class Og {
    private static volatile Og pA;
    private final yFO<com.bytedance.sdk.openadsdk.ZZv.pA> Og = aBv.KZx();

    private Og() {
    }

    public static Og pA() {
        if (pA == null) {
            synchronized (Og.class) {
                if (pA == null) {
                    pA = new Og();
                }
            }
        }
        return pA;
    }

    public void pA(String str, List<FilterWord> list, String str2) {
        pA(str, list, null, null, str2);
    }

    public void pA(String str, List<FilterWord> list, String str2, String str3, String str4) {
        this.Og.pA(str, list, str2, str3, str4);
    }
}
