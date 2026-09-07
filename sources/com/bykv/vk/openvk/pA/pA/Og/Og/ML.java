package com.bykv.vk.openvk.pA.pA.Og.Og;

import android.content.Context;
import android.util.Log;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class ML {
    private static volatile Context BSW;
    public static volatile Integer Bzk;
    static volatile boolean JG;
    static volatile com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx Og;
    private static volatile com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx SGo;
    public static volatile boolean ZZv;
    static volatile com.bykv.vk.openvk.pA.pA.Og.Og.pA.Og pA;
    public static final boolean KZx = com.bytedance.sdk.component.utils.WV.ZZv();
    static volatile boolean ML = true;
    static volatile int SD = 0;
    public static volatile int omh = 3;

    public static Context pA() {
        return BSW;
    }

    public static void pA(boolean z) {
        ML = z;
    }

    public static void Og(boolean z) {
        JG = z;
    }

    public static void pA(int i) {
        SD = i;
    }

    public static void pA(com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx kZx, Context context) {
        if (kZx == null || context == null) {
            throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
        }
        BSW = context.getApplicationContext();
        if (Og != null) {
            return;
        }
        if (pA != null) {
            throw null;
        }
        Og = kZx;
        SGo = com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx.pA(context);
        Og.pA(new com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx.pA() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.ML.1
            @Override // com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx.pA
            public void pA(String str) {
                if (ML.KZx) {
                    Log.i("TAG_PROXY_DiskLruCache", "new cache created: ".concat(String.valueOf(str)));
                }
            }

            @Override // com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx.pA
            public void pA(Set<String> set) {
                ML.SGo.pA(set, 0);
                if (ML.KZx) {
                    Log.i("TAG_PROXY_DiskLruCache", "cache file removed, ".concat(String.valueOf(set)));
                }
            }
        });
        JG jgPA = JG.pA();
        jgPA.pA(kZx);
        jgPA.pA(SGo);
        ZZv zZvKZx = ZZv.KZx();
        zZvKZx.pA(kZx);
        zZvKZx.pA(SGo);
    }

    public static com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx Og() {
        return Og;
    }

    public static com.bykv.vk.openvk.pA.pA.Og.Og.pA.Og KZx() {
        return pA;
    }
}
