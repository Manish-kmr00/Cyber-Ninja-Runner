package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzej extends zzbc {
    final /* synthetic */ zzek zza;

    zzej(zzek zzekVar) {
        this.zza = zzekVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbc, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        zzek zzekVar = this.zza;
        zzekVar.zze.zzb(zzekVar.zzi());
        super.onAdFailedToLoad(loadAdError);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbc, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        zzek zzekVar = this.zza;
        zzekVar.zze.zzb(zzekVar.zzi());
        super.onAdLoaded();
    }
}
