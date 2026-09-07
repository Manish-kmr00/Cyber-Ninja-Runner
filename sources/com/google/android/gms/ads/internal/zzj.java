package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfns;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzj implements zzfns {
    final /* synthetic */ zzk zza;

    zzj(zzk zzkVar) {
        this.zza = zzkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfns
    public final void zza(int i, long j) {
        this.zza.zzj.zzd(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfns
    public final void zzb(int i, long j, String str) {
        this.zza.zzj.zze(i, System.currentTimeMillis() - j, str);
    }
}
