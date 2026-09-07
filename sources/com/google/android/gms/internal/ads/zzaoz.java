package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaoz implements Runnable {
    private final zzapj zza;
    private final zzapp zzb;
    private final Runnable zzc;

    public zzaoz(zzapj zzapjVar, zzapp zzappVar, Runnable runnable) {
        this.zza = zzapjVar;
        this.zzb = zzappVar;
        this.zzc = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzapj zzapjVar = this.zza;
        zzapjVar.zzw();
        zzapp zzappVar = this.zzb;
        if (zzappVar.zzc()) {
            zzapjVar.zzo(zzappVar.zza);
        } else {
            zzapjVar.zzn(zzappVar.zzc);
        }
        if (zzappVar.zzd) {
            zzapjVar.zzm("intermediate-response");
        } else {
            zzapjVar.zzp("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
