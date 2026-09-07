package com.bytedance.sdk.openadsdk.core.settings;

import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class WV {
    private static final AtomicInteger pA = new AtomicInteger(1);

    public static boolean pA() {
        return pA.get() == 1;
    }

    protected static void pA(int i) {
        boolean z = true;
        if (i == 1 || i == 2) {
            try {
                AtomicInteger atomicInteger = pA;
                if (atomicInteger.get() != i) {
                    try {
                        atomicInteger.set(i);
                    } catch (Throwable th) {
                        th = th;
                        com.bytedance.sdk.component.utils.WV.pA("SdkSwitch", th.getMessage());
                    }
                } else {
                    z = false;
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
            if (z) {
                Log.e("SdkSwitch", "switch status changed: " + pA());
                if (pA()) {
                    com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.Og();
                } else {
                    com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.KZx();
                }
            }
        }
    }
}
