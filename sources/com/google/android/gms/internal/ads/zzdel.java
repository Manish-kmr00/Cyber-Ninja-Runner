package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdel implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;
    private final zzhfh zzd;

    public zzdel(zzdee zzdeeVar, zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
        this.zzd = zzhfhVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zza.zzb();
        final VersionInfoParcel versionInfoParcelZza = ((zzchg) this.zzb).zza();
        final zzfau zzfauVarZza = ((zzcqx) this.zzc).zza();
        final zzfbp zzfbpVarZza = ((zzcut) this.zzd).zza();
        return new zzdcu(new zzcwq() { // from class: com.google.android.gms.internal.ads.zzdec
            @Override // com.google.android.gms.internal.ads.zzcwq
            public final void zzt() {
                com.google.android.gms.ads.internal.util.zzay zzayVarZzt = com.google.android.gms.ads.internal.zzv.zzt();
                Context context2 = context;
                zzfbp zzfbpVar = zzfbpVarZza;
                zzayVarZzt.zzn(context2, versionInfoParcelZza.afmaVersion, zzfauVarZza.zzC.toString(), zzfbpVar.zzf);
            }
        }, zzbzk.zzg);
    }
}
