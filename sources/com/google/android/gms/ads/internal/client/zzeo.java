package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.preload.PreloadCallback;
import com.google.android.gms.ads.preload.PreloadConfiguration;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzeo extends zzcd {
    final /* synthetic */ PreloadCallback zza;
    final /* synthetic */ zzet zzb;

    zzeo(zzet zzetVar, PreloadCallback preloadCallback) {
        this.zza = preloadCallback;
        this.zzb = zzetVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final void zze(zzfp zzfpVar) {
        PreloadConfiguration preloadConfigurationZzg = zzet.zzg(this.zzb, zzfpVar);
        if (preloadConfigurationZzg != null) {
            this.zza.onAdsAvailable(preloadConfigurationZzg);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final void zzf(zzfp zzfpVar) {
        PreloadConfiguration preloadConfigurationZzg = zzet.zzg(this.zzb, zzfpVar);
        if (preloadConfigurationZzg != null) {
            this.zza.onAdsExhausted(preloadConfigurationZzg);
        }
    }
}
