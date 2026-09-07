package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcho implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;

    public zzcho(zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbus zzb() {
        Context contextZza = ((zzcgs) this.zza).zza();
        zzfgq zzfgqVar = (zzfgq) this.zzb.zzb();
        zzboa zzboaVarZzb = com.google.android.gms.ads.internal.zzv.zzg().zzb(contextZza, VersionInfoParcel.forPackage(), zzfgqVar);
        zzbnu zzbnuVar = zzbnx.zza;
        zzbnu zzbnuVar2 = zzbnx.zza;
        zzboaVarZzb.zza("google.afma.request.getAdDictionary", zzbnuVar, zzbnuVar2);
        return new zzbuu(contextZza, com.google.android.gms.ads.internal.zzv.zzg().zzb(contextZza, VersionInfoParcel.forPackage(), zzfgqVar).zza("google.afma.sdkConstants.getSdkConstants", zzbnuVar2, zzbnuVar2), VersionInfoParcel.forPackage());
    }
}
