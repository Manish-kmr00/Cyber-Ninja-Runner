package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzchg implements zzhey {
    private final zzcgo zza;

    public zzchg(zzcgo zzcgoVar) {
        this.zza = zzcgoVar;
    }

    public static VersionInfoParcel zzc(zzcgo zzcgoVar) {
        VersionInfoParcel versionInfoParcelZze = zzcgoVar.zze();
        zzhfg.zzb(versionInfoParcelZze);
        return versionInfoParcelZze;
    }

    public final VersionInfoParcel zza() {
        return zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
