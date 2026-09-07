package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.os.Trace;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzso implements zzsu {
    private final Context zza;

    @Deprecated
    public zzso() {
        this.zza = null;
    }

    public zzso(Context context, zzfuo zzfuoVar, zzfuo zzfuoVar2) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzsu
    public final zzsw zzd(zzst zzstVar) throws Throwable {
        Context context;
        if (zzeu.zza >= 31 || ((context = this.zza) != null && zzeu.zza >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen"))) {
            int iZzb = zzay.zzb(zzstVar.zzc.zzo);
            zzdx.zze("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzeu.zzD(iZzb)));
            return new zzse(iZzb).zzc(zzstVar);
        }
        MediaCodec mediaCodec = null;
        try {
            String str = zzstVar.zza.zza;
            Trace.beginSection("createCodec:".concat(str));
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            Trace.endSection();
            try {
                Trace.beginSection("configureCodec");
                mediaCodecCreateByCodecName.configure(zzstVar.zzb, zzstVar.zzd, (MediaCrypto) null, 0);
                Trace.endSection();
                Trace.beginSection("startCodec");
                mediaCodecCreateByCodecName.start();
                Trace.endSection();
                return new zztv(mediaCodecCreateByCodecName, zzstVar.zzf, null);
            } catch (IOException | RuntimeException e) {
                e = e;
                mediaCodec = mediaCodecCreateByCodecName;
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (RuntimeException e3) {
            e = e3;
        }
    }
}
