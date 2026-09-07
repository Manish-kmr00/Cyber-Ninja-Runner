package com.bytedance.sdk.openadsdk.ZZv.pA;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.aBv;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes13.dex */
public class ZZv {
    public static AtomicInteger pA = new AtomicInteger(0);
    public static final AtomicBoolean Og = new AtomicBoolean(false);

    public static void pA(Context context, boolean z) {
        if (Og.compareAndSet(false, true)) {
            com.bytedance.sdk.component.JG.pA.Og.pA(new com.bytedance.sdk.component.JG.pA.pA.C0188pA().pA(new SGo()).Og(com.bytedance.sdk.component.JG.pA.ZZv.Og.pA.KZx()).KZx(com.bytedance.sdk.component.JG.pA.ZZv.Og.pA.ML()).pA(com.bytedance.sdk.component.JG.pA.ZZv.Og.pA.ZZv()).pA(z).pA(new BSW()).pA(omh.pA).Og(aBv.ZZv().Sn()).pA(aBv.ZZv().DX()).pA(aBv.ZZv().Wo()).pA(), context);
            Og();
        }
    }

    public static void pA(com.bytedance.sdk.openadsdk.ZZv.pA pAVar) {
        com.bytedance.sdk.component.JG.pA.ZZv.pA.pA pAVar2 = new com.bytedance.sdk.component.JG.pA.ZZv.pA.pA(pAVar.ZZv(), pAVar);
        pAVar2.Og(pAVar.ML() ? (byte) 1 : (byte) 2);
        pAVar2.pA((byte) 0);
        if (com.bytedance.sdk.component.JG.pA.Og.Og()) {
            pA(aBv.pA(), com.bytedance.sdk.openadsdk.multipro.Og.KZx());
        }
        com.bytedance.sdk.component.JG.pA.Og.pA(pAVar2);
    }

    public static com.bytedance.sdk.openadsdk.Sn.KZx.Og pA() {
        return WV.pA;
    }

    public static void pA(final List<String> list, final int i, final String str) {
        if (list == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(new com.bytedance.sdk.component.omh.omh("track") { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.component.JG.pA.Og.Og()) {
                    ZZv.pA(aBv.pA(), com.bytedance.sdk.openadsdk.multipro.Og.KZx());
                }
                com.bytedance.sdk.component.JG.pA.Og.pA(com.bytedance.sdk.openadsdk.core.WV.pA(aBv.pA()), list, true, i, str);
            }
        });
    }

    public static void pA(String str) {
        pA(str, false);
    }

    public static void pA(String str, boolean z) {
        if (com.bytedance.sdk.component.JG.pA.Og.Og()) {
            pA(aBv.pA(), com.bytedance.sdk.openadsdk.multipro.Og.KZx());
        }
        com.bytedance.sdk.component.JG.pA.Og.pA(str, z);
    }

    public static void Og() {
        com.bytedance.sdk.component.JG.pA.Og.KZx();
    }

    public static void KZx() {
        try {
            com.bytedance.sdk.component.JG.pA.Og.ZZv();
            com.bytedance.sdk.component.JG.pA.Og.ML();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("AdLogSwitchUtils", th.getMessage());
        }
    }
}
