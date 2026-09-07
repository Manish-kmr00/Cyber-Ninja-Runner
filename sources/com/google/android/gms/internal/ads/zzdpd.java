package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdpd implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;
    private final zzhfh zzd;
    private final zzhfh zze;

    public zzdpd(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4, zzhfh zzhfhVar5) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
        this.zzd = zzhfhVar4;
        this.zze = zzhfhVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzcgs) this.zza).zza();
        final String strZzb = ((zzdwb) this.zzb).zzb();
        VersionInfoParcel versionInfoParcelZza = ((zzchg) this.zzc).zza();
        final zzbbn.zza.EnumC0270zza enumC0270zza = (zzbbn.zza.EnumC0270zza) this.zzd.zzb();
        final String str = (String) this.zze.zzb();
        zzbbg zzbbgVar = new zzbbg(new zzbbm(contextZza));
        zzbbn.zzar.zza zzaVarZzd = zzbbn.zzar.zzd();
        zzaVarZzd.zzg(versionInfoParcelZza.buddyApkVersion);
        zzaVarZzd.zzi(versionInfoParcelZza.clientJarVersion);
        zzaVarZzd.zzh(true != versionInfoParcelZza.isClientJar ? 2 : 0);
        final zzbbn.zzar zzarVarZzbr = zzaVarZzd.zzbr();
        zzbbgVar.zzb(new zzbbf() { // from class: com.google.android.gms.internal.ads.zzdpc
            @Override // com.google.android.gms.internal.ads.zzbbf
            public final void zza(zzbbn.zzt.zza zzaVar) {
                zzbbn.zza.zzb zzbVarZzbM = zzaVar.zze().zzbM();
                zzbVarZzbM.zzH(enumC0270zza);
                zzaVar.zzG(zzbVarZzbM);
                zzbbn.zzm.zza zzaVarZzbM = zzaVar.zzg().zzbM();
                zzaVarZzbM.zzm(strZzb);
                zzaVarZzbM.zzw(zzarVarZzbr);
                zzaVar.zzK(zzaVarZzbM);
                zzaVar.zzO(str);
            }
        });
        return zzbbgVar;
    }
}
