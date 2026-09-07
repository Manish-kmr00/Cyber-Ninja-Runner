package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzctl implements zzcya, zzddo {
    private final Context zza;
    private final zzfbp zzb;
    private final VersionInfoParcel zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzdti zze;
    private final zzfgq zzf;
    private final zzdud zzg;

    public zzctl(Context context, zzfbp zzfbpVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.util.zzg zzgVar, zzdti zzdtiVar, zzfgq zzfgqVar, zzdud zzdudVar) {
        this.zza = context;
        this.zzb = zzfbpVar;
        this.zzc = versionInfoParcel;
        this.zzd = zzgVar;
        this.zze = zzdtiVar;
        this.zzf = zzfgqVar;
        this.zzg = zzdudVar;
    }

    private final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzei)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzd;
            Context context = this.zza;
            VersionInfoParcel versionInfoParcel = this.zzc;
            zzfbp zzfbpVar = this.zzb;
            zzfgq zzfgqVar = this.zzf;
            zzdud zzdudVar = this.zzg;
            com.google.android.gms.ads.internal.zzv.zza().zze(context, versionInfoParcel, zzfbpVar.zzf, zzgVar.zzg(), zzfgqVar, zzdudVar.zzq());
        }
        this.zze.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdl(zzbuy zzbuyVar) {
        zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdm(zzfbg zzfbgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzddo
    public final void zze(com.google.android.gms.ads.nonagon.signalgeneration.zzbk zzbkVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzej)).booleanValue()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddo
    public final void zzf(String str) {
    }
}
