package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcuy implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;

    public zzcuy(zzcux zzcuxVar, zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context context = (Context) this.zza.zzb();
        VersionInfoParcel versionInfoParcelZza = ((zzchg) this.zzb).zza();
        zzfau zzfauVarZza = ((zzcqx) this.zzc).zza();
        zzbxe zzbxeVar = new zzbxe();
        zzbxf zzbxfVar = zzfauVarZza.zzA;
        if (zzbxfVar == null) {
            return null;
        }
        zzfaz zzfazVar = zzfauVarZza.zzs;
        return new zzbxd(context, versionInfoParcelZza, zzbxfVar, zzfazVar == null ? null : zzfazVar.zzb, zzbxeVar);
    }
}
