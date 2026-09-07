package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaun implements zzfns {
    final /* synthetic */ zzfmr zza;

    zzaun(zzfmr zzfmrVar) {
        this.zza = zzfmrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfns
    public final void zza(int i, long j) {
        this.zza.zzd(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfns
    public final void zzb(int i, long j, String str) {
        this.zza.zze(i, System.currentTimeMillis() - j, str);
    }
}
