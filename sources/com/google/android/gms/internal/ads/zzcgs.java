package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcgs implements zzhey {
    private final zzcgo zza;

    public zzcgs(zzcgo zzcgoVar) {
        this.zza = zzcgoVar;
    }

    public static Context zzc(zzcgo zzcgoVar) {
        Context contextZzb = zzcgoVar.zzb();
        zzhfg.zzb(contextZzb);
        return contextZzb;
    }

    public final Context zza() {
        return zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
