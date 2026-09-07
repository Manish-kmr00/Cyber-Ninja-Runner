package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zztv implements zzsw {
    private final MediaCodec zza;
    private final zzss zzb;

    /* synthetic */ zztv(MediaCodec mediaCodec, zzss zzssVar, zztu zztuVar) {
        this.zza = mediaCodec;
        this.zzb = zzssVar;
        if (zzeu.zza < 35 || zzssVar == null) {
            return;
        }
        zzssVar.zza(mediaCodec);
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final int zza() {
        return this.zza.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.zza.dequeueOutputBuffer(bufferInfo, 0L);
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final MediaFormat zzc() {
        return this.zza.getOutputFormat();
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final ByteBuffer zzf(int i) {
        return this.zza.getInputBuffer(i);
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final ByteBuffer zzg(int i) {
        return this.zza.getOutputBuffer(i);
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzi() {
        this.zza.detachOutputSurface();
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzj() {
        this.zza.flush();
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzk(int i, int i2, int i3, long j, int i4) {
        this.zza.queueInputBuffer(i, 0, i3, j, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzl(int i, int i2, zzhk zzhkVar, long j, int i3) {
        this.zza.queueSecureInputBuffer(i, 0, zzhkVar.zza(), j, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzm() {
        zzss zzssVar;
        try {
            if (zzeu.zza >= 30 && zzeu.zza < 33) {
                this.zza.stop();
            }
            if (zzeu.zza >= 35 && this.zzb != null) {
            }
        } finally {
            if (zzeu.zza >= 35 && (zzssVar = this.zzb) != null) {
                zzssVar.zzc(this.zza);
            }
            this.zza.release();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzn(int i, long j) {
        this.zza.releaseOutputBuffer(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzo(int i, boolean z) {
        this.zza.releaseOutputBuffer(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzp(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzq(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzr(int i) {
        this.zza.setVideoScalingMode(i);
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final /* synthetic */ boolean zzs(zzsv zzsvVar) {
        return false;
    }
}
