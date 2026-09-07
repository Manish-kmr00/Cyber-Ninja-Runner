package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfkm implements Runnable {
    final /* synthetic */ zzfkn zza;

    zzfkm(zzfkn zzfknVar) {
        this.zza = zzfknVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfkn zzfknVar = this.zza;
        float fZza = zzfkn.zza(zzfknVar);
        if (((Float) zzfknVar.zzc.getAndSet(Float.valueOf(fZza))).floatValue() != fZza) {
            zzfknVar.zzd.zze(fZza);
        }
    }
}
