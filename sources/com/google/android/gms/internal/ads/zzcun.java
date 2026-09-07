package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcun implements zzhey {
    private final zzcul zza;
    private final zzhfh zzb;

    public zzcun(zzcul zzculVar, zzhfh zzhfhVar) {
        this.zza = zzculVar;
        this.zzb = zzhfhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZzb = this.zza.zzb(((zzcgs) this.zzb).zza());
        zzhfg.zzb(contextZzb);
        return contextZzb;
    }
}
