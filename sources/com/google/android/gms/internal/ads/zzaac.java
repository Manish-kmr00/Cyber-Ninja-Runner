package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzaac {
    final /* synthetic */ zzaae zza;
    private zzz zzb;

    /* synthetic */ zzaac(zzaae zzaaeVar, zzaad zzaadVar) {
        this.zza = zzaaeVar;
    }

    public final void zza(zzcd zzcdVar) {
        zzx zzxVar = new zzx();
        zzxVar.zzai(zzcdVar.zzb);
        zzxVar.zzM(zzcdVar.zzc);
        zzxVar.zzad("video/raw");
        this.zzb = zzxVar.zzaj();
    }

    public final void zzb(long j, long j2, boolean z) {
        zzz zzzVarZzaj = this.zzb;
        if (zzzVarZzaj == null) {
            zzzVarZzaj = new zzx().zzaj();
        }
        zzz zzzVar = zzzVarZzaj;
        zzaae zzaaeVar = this.zza;
        zzaaeVar.zzf.zza(j2, j, zzzVar, null);
        ((zzabt) zzaaeVar.zzc.remove()).zzb();
    }
}
