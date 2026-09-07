package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdux extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdva zzb;

    zzdux(zzdva zzdvaVar, String str) {
        this.zza = str;
        this.zzb = zzdvaVar;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.zzm(zzdva.zzl(loadAdError), this.zza);
    }
}
