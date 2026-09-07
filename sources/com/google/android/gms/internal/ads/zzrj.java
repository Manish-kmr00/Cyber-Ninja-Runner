package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzrj implements zzqc {
    final /* synthetic */ zzrl zza;

    /* synthetic */ zzrj(zzrl zzrlVar, zzrk zzrkVar) {
        this.zza = zzrlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqc
    public final void zza(Exception exc) {
        zzdx.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzn(exc);
    }
}
