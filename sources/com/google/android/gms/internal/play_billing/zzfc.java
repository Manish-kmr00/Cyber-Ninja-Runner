package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
final class zzfc implements Runnable {

    @CheckForNull
    zzff zza;

    zzfc(zzff zzffVar) {
        this.zza = zzffVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzeu zzeuVar;
        zzff zzffVar = this.zza;
        if (zzffVar == null || (zzeuVar = zzffVar.zzc) == null) {
            return;
        }
        this.zza = null;
        if (zzeuVar.isDone()) {
            zzffVar.zzp(zzeuVar);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzffVar.zzd;
            zzffVar.zzd = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    zzffVar.zzo(new zzfd(str, null));
                    throw th;
                }
            }
            zzffVar.zzo(new zzfd(str + ": " + zzeuVar.toString(), null));
            zzeuVar.cancel(true);
        } catch (Throwable th2) {
            zzeuVar.cancel(true);
            throw th2;
        }
    }
}
