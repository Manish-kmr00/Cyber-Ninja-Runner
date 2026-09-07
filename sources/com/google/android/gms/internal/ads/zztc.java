package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zztc extends Exception {
    public final String zza;
    public final boolean zzb;
    public final zzsz zzc;
    public final String zzd;

    public zztc(zzz zzzVar, Throwable th, boolean z, int i) {
        this("Decoder init failed: [" + i + "], " + zzzVar.toString(), th, zzzVar.zzo, false, null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_" + Math.abs(i), null);
    }

    static /* bridge */ /* synthetic */ zztc zza(zztc zztcVar, zztc zztcVar2) {
        return new zztc(zztcVar.getMessage(), zztcVar.getCause(), zztcVar.zza, false, zztcVar.zzc, zztcVar.zzd, zztcVar2);
    }

    public zztc(zzz zzzVar, Throwable th, boolean z, zzsz zzszVar) {
        this("Decoder init failed: " + zzszVar.zza + ", " + zzzVar.toString(), th, zzzVar.zzo, false, zzszVar, th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null, null);
    }

    private zztc(String str, Throwable th, String str2, boolean z, zzsz zzszVar, String str3, zztc zztcVar) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzszVar;
        this.zzd = str3;
    }
}
