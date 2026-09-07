package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdmw extends zzdmg implements zzddc {
    private zzddc zza;

    @Override // com.google.android.gms.internal.ads.zzddc
    public final synchronized void zzdd() {
        zzddc zzddcVar = this.zza;
        if (zzddcVar != null) {
            zzddcVar.zzdd();
        }
    }

    protected final synchronized void zzi(com.google.android.gms.ads.internal.client.zza zzaVar, zzbhz zzbhzVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzbib zzbibVar, com.google.android.gms.ads.internal.overlay.zzac zzacVar, zzddc zzddcVar) {
        super.zzh(zzaVar, zzbhzVar, zzrVar, zzbibVar, zzacVar);
        this.zza = zzddcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzddc
    public final synchronized void zzu() {
        zzddc zzddcVar = this.zza;
        if (zzddcVar != null) {
            zzddcVar.zzu();
        }
    }
}
