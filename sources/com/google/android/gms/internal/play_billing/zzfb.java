package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzfb {
    public static zzev zza(ExecutorService executorService) {
        if (executorService instanceof zzev) {
            return (zzev) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new zzfa((ScheduledExecutorService) executorService) : new zzex(executorService);
    }

    public static zzew zzb(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof zzew ? (zzew) scheduledExecutorService : new zzfa(scheduledExecutorService);
    }
}
