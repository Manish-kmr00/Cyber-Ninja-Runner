package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzapu {
    public static final boolean zza = zzapv.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    zzapu() {
    }

    protected final void finalize() throws Throwable {
        if (this.zzc) {
            return;
        }
        zzb("Request on the loose");
        zzapv.zzb("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }

    public final synchronized void zza(String str, long j) {
        if (this.zzc) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.zzb.add(new zzapt(str, j, SystemClock.elapsedRealtime()));
    }

    public final synchronized void zzb(String str) {
        this.zzc = true;
        List<zzapt> list = this.zzb;
        long j = list.size() == 0 ? 0L : ((zzapt) list.get(list.size() - 1)).zzc - ((zzapt) list.get(0)).zzc;
        if (j > 0) {
            long j2 = ((zzapt) list.get(0)).zzc;
            zzapv.zza("(%-4d ms) %s", Long.valueOf(j), str);
            for (zzapt zzaptVar : list) {
                long j3 = zzaptVar.zzc;
                zzapv.zza("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(zzaptVar.zzb), zzaptVar.zza);
                j2 = j3;
            }
        }
    }
}
