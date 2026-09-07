package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzrc extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzrd zza;

    zzrc(zzrd zzrdVar) {
        this.zza = zzrdVar;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i) {
        audioTrack.equals(this.zza.zza.zzs);
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onPresentationEnded(AudioTrack audioTrack) {
        zzrf zzrfVar = this.zza.zza;
        if (audioTrack.equals(zzrfVar.zzs)) {
            zzrfVar.zzP = true;
        }
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        audioTrack.equals(this.zza.zza.zzs);
    }
}
