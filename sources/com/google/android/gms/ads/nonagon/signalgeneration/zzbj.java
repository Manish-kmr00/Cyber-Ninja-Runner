package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdwj;
import com.google.android.gms.internal.ads.zzfen;
import com.google.android.gms.internal.ads.zzhey;
import com.google.android.gms.internal.ads.zzhfh;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzbj implements zzhey {
    private final zzhfh zza;

    public zzbj(zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        this.zza = zzhfhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbi zzb() {
        return new zzbi(zzfen.zzc(), ((zzdwj) this.zza).zzb());
    }
}
