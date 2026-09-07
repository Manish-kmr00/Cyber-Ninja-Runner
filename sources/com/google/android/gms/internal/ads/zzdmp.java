package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdmp {
    private final zzcva zza;
    private final zzcwj zzb;
    private final zzcww zzc;
    private final zzcxi zzd;
    private final zzczz zze;
    private final zzfau zzf;
    private final zzfax zzg;
    private final zzclx zzh;

    public zzdmp(zzcva zzcvaVar, zzcwj zzcwjVar, zzcww zzcwwVar, zzcxi zzcxiVar, zzczz zzczzVar, zzfau zzfauVar, zzfax zzfaxVar, zzclx zzclxVar) {
        this.zza = zzcvaVar;
        this.zzb = zzcwjVar;
        this.zzc = zzcwwVar;
        this.zzd = zzcxiVar;
        this.zze = zzczzVar;
        this.zzf = zzfauVar;
        this.zzg = zzfaxVar;
        this.zzh = zzclxVar;
    }

    public final void zza(zzdmt zzdmtVar) {
        final zzcwj zzcwjVar = this.zzb;
        zzdmg zzdmgVar = zzdmtVar.zza;
        Objects.requireNonNull(zzcwjVar);
        zzdmgVar.zzh(this.zza, this.zzc, this.zzd, this.zze, new com.google.android.gms.ads.internal.overlay.zzac() { // from class: com.google.android.gms.internal.ads.zzdmo
            @Override // com.google.android.gms.ads.internal.overlay.zzac
            public final void zzg() {
                zzcwjVar.zzb();
            }
        });
        zzdmtVar.zzh(this.zzf, this.zzg, this.zzh);
    }
}
