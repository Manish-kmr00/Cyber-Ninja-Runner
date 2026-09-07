package com.google.android.gms.internal.ads;

import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeqm implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;

    public zzeqm(zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeqk zzb() {
        return new zzeqk(((zzcgs) this.zza).zza(), (Intent) this.zzb.zzb());
    }
}
