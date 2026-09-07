package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdnf implements zzbka {
    private final zzcwj zza;
    private final zzbvw zzb;
    private final String zzc;
    private final String zzd;

    public zzdnf(zzcwj zzcwjVar, zzfau zzfauVar) {
        this.zza = zzcwjVar;
        this.zzb = zzfauVar.zzl;
        this.zzc = zzfauVar.zzj;
        this.zzd = zzfauVar.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzbka
    @ParametersAreNonnullByDefault
    public final void zza(zzbvw zzbvwVar) {
        int i;
        String str;
        zzbvw zzbvwVar2 = this.zzb;
        if (zzbvwVar2 != null) {
            zzbvwVar = zzbvwVar2;
        }
        if (zzbvwVar != null) {
            str = zzbvwVar.zza;
            i = zzbvwVar.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zzd(new zzbvh(str, i), this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbka
    public final void zzb() {
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzbka
    public final void zzc() {
        this.zza.zzf();
    }
}
