package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfel implements zzhey {
    public static zzfel zza() {
        return zzfek.zza;
    }

    public static zzgcd zzc() {
        zzgcd zzgcdVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfM)).booleanValue()) {
            zzgcdVar = zzbzk.zzc;
        } else {
            zzgcdVar = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfL)).booleanValue() ? zzbzk.zza : zzbzk.zzf;
        }
        zzhfg.zzb(zzgcdVar);
        return zzgcdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* synthetic */ Object zzb() {
        return zzc();
    }
}
