package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzdrj;
import com.google.android.gms.internal.ads.zzfen;
import com.google.android.gms.internal.ads.zzhey;
import com.google.android.gms.internal.ads.zzhfh;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzr implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;

    public zzr(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzo(((zzcgs) this.zza).zza(), (zzdrj) this.zzb.zzb(), zzfen.zzc());
    }
}
