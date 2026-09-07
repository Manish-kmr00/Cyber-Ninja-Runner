package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhi {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    static /* bridge */ /* synthetic */ void zza(zzhi zzhiVar, int i, int i2) {
        MediaCodec.CryptoInfo.Pattern pattern = zzhiVar.zzb;
        pattern.set(i, i2);
        zzhiVar.zza.setPattern(pattern);
    }
}
