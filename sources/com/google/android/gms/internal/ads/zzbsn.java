package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbsn extends zzbhg {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbsn(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zze(zzbhn zzbhnVar) {
        this.zza.onNativeAdLoaded(new zzbsh(zzbhnVar));
    }
}
