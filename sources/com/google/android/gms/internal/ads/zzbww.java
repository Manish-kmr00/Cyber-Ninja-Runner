package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbww extends zzbwj {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzbwx zzb;

    public zzbww(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzbwx zzbwxVar) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzbwxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zze(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zzeVar.zzb());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zzg() {
        zzbwx zzbwxVar;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback == null || (zzbwxVar = this.zzb) == null) {
            return;
        }
        rewardedInterstitialAdLoadCallback.onAdLoaded(zzbwxVar);
    }
}
