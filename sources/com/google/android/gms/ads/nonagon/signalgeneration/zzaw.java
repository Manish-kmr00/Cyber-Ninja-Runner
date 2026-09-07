package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzddr;
import com.google.android.gms.internal.ads.zzgbo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzaw implements zzgbo {
    final /* synthetic */ zzddr zza;

    zzaw(zzddr zzddrVar) {
        this.zza = zzddrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        this.zza.zzb(th.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* synthetic */ void zzb(Object obj) {
        this.zza.zza((zzbk) obj);
    }
}
