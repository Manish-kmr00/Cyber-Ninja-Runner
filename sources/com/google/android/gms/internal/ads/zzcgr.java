package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcgr implements zzhey {
    private final zzhfh zza;

    public zzcgr(zzhfh zzhfhVar) {
        this.zza = zzhfhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        ApplicationInfo applicationInfo = ((zzcgs) this.zza).zza().getApplicationInfo();
        zzhfg.zzb(applicationInfo);
        return applicationInfo;
    }
}
