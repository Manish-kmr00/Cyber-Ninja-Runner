package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcgz implements zzhey {
    private final zzhfh zza;

    public zzcgz(zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        this.zza = zzhfhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbP)).booleanValue() ? Collections.singleton(new zzdcu((zzdtk) this.zza.zzb(), zzfen.zzc())) : Collections.emptySet();
        zzhfg.zzb(setSingleton);
        return setSingleton;
    }
}
