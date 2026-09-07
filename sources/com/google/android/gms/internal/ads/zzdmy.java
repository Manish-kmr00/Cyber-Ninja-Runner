package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdmy {
    private final zzcva zza;
    private final zzcwj zzb;
    private final zzcww zzc;
    private final zzcxi zzd;
    private final zzczz zze;
    private final zzdda zzf;
    private final zzdre zzg;
    private final zzfio zzh;
    private final zzeat zzi;
    private final zzclx zzj;

    zzdmy(zzcva zzcvaVar, zzcwj zzcwjVar, zzcww zzcwwVar, zzcxi zzcxiVar, zzczz zzczzVar, zzdda zzddaVar, zzdre zzdreVar, zzfio zzfioVar, zzeat zzeatVar, zzclx zzclxVar) {
        this.zza = zzcvaVar;
        this.zzb = zzcwjVar;
        this.zzc = zzcwwVar;
        this.zzd = zzcxiVar;
        this.zze = zzczzVar;
        this.zzf = zzddaVar;
        this.zzg = zzdreVar;
        this.zzh = zzfioVar;
        this.zzi = zzeatVar;
        this.zzj = zzclxVar;
    }

    public final void zza(zzdmz zzdmzVar, zzcel zzcelVar) {
        zzdmw zzdmwVar = zzdmzVar.zza;
        final zzcwj zzcwjVar = this.zzb;
        Objects.requireNonNull(zzcwjVar);
        zzdmwVar.zzi(this.zza, this.zzc, this.zzd, this.zze, new com.google.android.gms.ads.internal.overlay.zzac() { // from class: com.google.android.gms.internal.ads.zzdmx
            @Override // com.google.android.gms.ads.internal.overlay.zzac
            public final void zzg() {
                zzcwjVar.zzb();
            }
        }, this.zzf);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkl)).booleanValue() || zzcelVar == null || zzcelVar.zzN() == null) {
            return;
        }
        zzcgd zzcgdVarZzN = zzcelVar.zzN();
        zzclx zzclxVar = this.zzj;
        zzeat zzeatVar = this.zzi;
        zzcgdVarZzN.zzK(zzclxVar, zzeatVar, this.zzh);
        zzcgdVarZzN.zzM(zzclxVar, zzeatVar, this.zzg);
    }
}
