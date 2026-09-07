package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzra implements zzqi {
    final /* synthetic */ zzrf zza;

    /* synthetic */ zzra(zzrf zzrfVar, zzre zzreVar) {
        this.zza = zzrfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqi
    public final void zza(long j) {
        zzdx.zzf("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j);
    }

    @Override // com.google.android.gms.internal.ads.zzqi
    public final void zzb(long j) {
        zzrf zzrfVar = this.zza;
        if (zzrfVar.zzo != null) {
            ((zzrj) zzrfVar.zzo).zza.zzc.zzv(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqi
    public final void zzc(long j, long j2, long j3, long j4) {
        zzrf zzrfVar = this.zza;
        zzdx.zzf("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + zzrfVar.zzL() + ", " + zzrfVar.zzM());
    }

    @Override // com.google.android.gms.internal.ads.zzqi
    public final void zzd(long j, long j2, long j3, long j4) {
        zzrf zzrfVar = this.zza;
        zzdx.zzf("DefaultAudioSink", "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + zzrfVar.zzL() + ", " + zzrfVar.zzM());
    }

    @Override // com.google.android.gms.internal.ads.zzqi
    public final void zze(int i, long j) {
        zzrf zzrfVar = this.zza;
        if (zzrfVar.zzo != null) {
            ((zzrj) zzrfVar.zzo).zza.zzc.zzx(i, j, SystemClock.elapsedRealtime() - zzrfVar.zzU);
        }
    }
}
