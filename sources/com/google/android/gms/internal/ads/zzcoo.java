package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcoo implements zzhey {
    private final zzcog zza;
    private final zzhfh zzb;
    private final zzhfh zzc;
    private final zzhfh zzd;
    private final zzhfh zze;

    public zzcoo(zzcog zzcogVar, zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4) {
        this.zza = zzcogVar;
        this.zzb = zzhfhVar;
        this.zzc = zzhfhVar2;
        this.zzd = zzhfhVar3;
        this.zze = zzhfhVar4;
    }

    public static zzdcu zza(zzcog zzcogVar, final Context context, final VersionInfoParcel versionInfoParcel, final zzfau zzfauVar, final zzfbp zzfbpVar) {
        return new zzdcu(new zzcwq() { // from class: com.google.android.gms.internal.ads.zzcoe
            @Override // com.google.android.gms.internal.ads.zzcwq
            public final void zzt() {
                com.google.android.gms.ads.internal.util.zzay zzayVarZzt = com.google.android.gms.ads.internal.zzv.zzt();
                Context context2 = context;
                zzfbp zzfbpVar2 = zzfbpVar;
                zzayVarZzt.zzn(context2, versionInfoParcel.afmaVersion, zzfauVar.zzC.toString(), zzfbpVar2.zzf);
            }
        }, zzbzk.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zza(this.zza, (Context) this.zzb.zzb(), ((zzchg) this.zzc).zza(), ((zzcqx) this.zzd).zza(), ((zzcut) this.zze).zza());
    }
}
