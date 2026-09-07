package com.bytedance.sdk.component.adexpress.ZZv;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class ZZv {
    public static void pA(com.bytedance.sdk.component.omh.omh omhVar, int i) {
        if (omhVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.pA.pA.KZx KZx = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx();
        ExecutorService executorServiceSn = KZx != null ? KZx.Sn() : null;
        if (executorServiceSn != null) {
            omhVar.setPriority(i);
            executorServiceSn.execute(omhVar);
        } else {
            com.bytedance.sdk.component.omh.JG.pA(omhVar, i);
        }
    }

    public static void Og(com.bytedance.sdk.component.omh.omh omhVar, int i) {
        if (omhVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.pA.pA.KZx KZx = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx();
        ExecutorService executorServiceWx = KZx != null ? KZx.Wx() : null;
        if (executorServiceWx != null) {
            omhVar.setPriority(i);
            executorServiceWx.execute(omhVar);
        } else {
            com.bytedance.sdk.component.omh.JG.pA(omhVar);
        }
    }

    public static ScheduledFuture pA(Runnable runnable, long j, TimeUnit timeUnit) {
        return com.bytedance.sdk.component.omh.JG.JG().schedule(runnable, j, timeUnit);
    }
}
