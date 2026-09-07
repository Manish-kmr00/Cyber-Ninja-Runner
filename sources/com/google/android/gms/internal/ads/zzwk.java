package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzwk implements zzyy {
    public long zza;
    public long zzb;
    public zzyx zzc;
    public zzwk zzd;

    public zzwk(long j, int i) {
        zze(j, 65536);
    }

    public final int zza(long j) {
        long j2 = j - this.zza;
        int i = this.zzc.zzb;
        return (int) j2;
    }

    public final zzwk zzb() {
        this.zzc = null;
        zzwk zzwkVar = this.zzd;
        this.zzd = null;
        return zzwkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyy
    public final zzyy zzd() {
        zzwk zzwkVar = this.zzd;
        if (zzwkVar == null || zzwkVar.zzc == null) {
            return null;
        }
        return zzwkVar;
    }

    public final void zze(long j, int i) {
        zzdc.zzf(this.zzc == null);
        this.zza = j;
        this.zzb = j + PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
    }

    @Override // com.google.android.gms.internal.ads.zzyy
    public final zzyx zzc() {
        zzyx zzyxVar = this.zzc;
        zzyxVar.getClass();
        return zzyxVar;
    }
}
