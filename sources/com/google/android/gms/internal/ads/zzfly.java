package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfly implements Runnable {
    zzfly() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzfmb.zzc != null) {
            zzfmb.zzc.post(zzfmb.zzd);
            zzfmb.zzc.postDelayed(zzfmb.zze, 200L);
        }
    }
}
