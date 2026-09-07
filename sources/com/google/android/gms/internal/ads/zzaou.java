package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaou implements Runnable {
    final /* synthetic */ zzapj zza;
    final /* synthetic */ zzaov zzb;

    zzaou(zzaov zzaovVar, zzapj zzapjVar) {
        this.zza = zzapjVar;
        this.zzb = zzaovVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
