package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public class zzsy extends zzhl {
    public final int zza;

    public zzsy(Throwable th, zzsz zzszVar) {
        super("Decoder failed: ".concat(String.valueOf(zzszVar == null ? null : zzszVar.zza)), th);
        boolean z = th instanceof MediaCodec.CodecException;
        if (z) {
            ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        int i = zzeu.zza;
        this.zza = z ? ((MediaCodec.CodecException) th).getErrorCode() : 0;
    }
}
