package com.bykv.vk.openvk.pA.pA.Og.pA.Og;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class KZx {
    public static final ConcurrentHashMap<String, Og> pA = new ConcurrentHashMap<>();

    public static synchronized void pA(Context context, com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA interfaceC0159pA) {
        if (kZx == null) {
            return;
        }
        ConcurrentHashMap<String, Og> concurrentHashMap = pA;
        Og og = concurrentHashMap.get(kZx.Sn());
        if (og == null) {
            og = new Og(context, kZx);
            concurrentHashMap.put(kZx.Sn(), og);
            new Object[]{"preloadVideo:  cache size = ", Integer.valueOf(kZx.KZx()), kZx.Sn()};
        }
        og.pA(interfaceC0159pA);
        new Object[]{"preloadVideo:  cache size = ", Integer.valueOf(kZx.KZx()), kZx.Sn()};
    }

    public static synchronized void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        Og ogRemove = pA.remove(kZx.Sn());
        if (ogRemove != null) {
            ogRemove.pA(true);
        }
        new Object[]{"removePreload:  cache size = ", Integer.valueOf(kZx.KZx()), kZx.Sn()};
    }
}
