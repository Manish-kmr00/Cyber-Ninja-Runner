package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzblc implements zzgaz {
    final /* synthetic */ zzbku zza;

    zzblc(zzblg zzblgVar, zzbku zzbkuVar) {
        this.zza = zzbkuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgaz
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzbzp zzbzpVar = new zzbzp();
        ((zzbla) obj).zze(this.zza, new zzblb(this, zzbzpVar));
        return zzbzpVar;
    }
}
