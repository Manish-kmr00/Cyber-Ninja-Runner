package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcpa implements zzcvw {
    private final zzcel zza;
    private final zzdre zzb;
    private final zzfau zzc;

    zzcpa(zzcel zzcelVar, zzdre zzdreVar, zzfau zzfauVar) {
        this.zza = zzcelVar;
        this.zzb = zzdreVar;
        this.zzc = zzfauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzs() {
        zzcel zzcelVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmU)).booleanValue() || (zzcelVar = this.zza) == null) {
            return;
        }
        String str = true != com.google.android.gms.ads.internal.util.zzac.zza(zzcelVar.zzF()) ? "0" : "1";
        zzdrd zzdrdVarZza = this.zzb.zza();
        zzdrdVarZza.zzb("action", "hcp");
        zzdrdVarZza.zzb("hcp", str);
        zzdrdVarZza.zzc(this.zzc);
        zzdrdVarZza.zzj();
    }
}
