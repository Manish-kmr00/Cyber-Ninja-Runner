package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdnq implements zzhey {
    private final zzhfh zza;

    public zzdnq(zzhfh zzhfhVar) {
        this.zza = zzhfhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbbn.zza.EnumC0270zza enumC0270zza = ((zzcut) this.zza).zza().zzo.zza == 3 ? zzbbn.zza.EnumC0270zza.REWARDED_INTERSTITIAL : zzbbn.zza.EnumC0270zza.REWARD_BASED_VIDEO_AD;
        zzhfg.zzb(enumC0270zza);
        return enumC0270zza;
    }
}
