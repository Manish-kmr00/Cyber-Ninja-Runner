package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdwy implements zzgbo {
    final /* synthetic */ Context zza;

    zzdwy(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        if (((Boolean) zzbea.zzh.zze()).booleanValue() && (th instanceof com.google.android.gms.ads.internal.util.zzba)) {
            zzbbs.zze(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        if (((Boolean) zzbea.zzj.zze()).booleanValue()) {
            zzbbs.zze(this.zza);
        }
    }
}
