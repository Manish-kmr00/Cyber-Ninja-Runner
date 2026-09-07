package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcsi implements zzdaq, zzcwq {
    private final Clock zza;
    private final zzcsk zzb;
    private final zzfbp zzc;
    private final String zzd;

    zzcsi(Clock clock, zzcsk zzcskVar, zzfbp zzfbpVar, String str) {
        this.zza = clock;
        this.zzb = zzcskVar;
        this.zzc = zzfbpVar;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdaq
    public final void zza() {
        this.zzb.zze(this.zzd, this.zza.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzt() {
        Clock clock = this.zza;
        this.zzb.zzd(this.zzc.zzf, this.zzd, clock.elapsedRealtime());
    }
}
