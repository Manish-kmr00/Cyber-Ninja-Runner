package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzqq {
    public static void zza(AudioTrack audioTrack, zzph zzphVar) {
        audioTrack.setPreferredDevice(zzphVar == null ? null : zzphVar.zza);
    }
}
