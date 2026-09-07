package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzst {
    public final zzsz zza;
    public final MediaFormat zzb;
    public final zzz zzc;
    public final Surface zzd;
    public final MediaCrypto zze = null;
    public final zzss zzf;

    private zzst(zzsz zzszVar, MediaFormat mediaFormat, zzz zzzVar, Surface surface, MediaCrypto mediaCrypto, zzss zzssVar) {
        this.zza = zzszVar;
        this.zzb = mediaFormat;
        this.zzc = zzzVar;
        this.zzd = surface;
        this.zzf = zzssVar;
    }

    public static zzst zza(zzsz zzszVar, MediaFormat mediaFormat, zzz zzzVar, MediaCrypto mediaCrypto, zzss zzssVar) {
        return new zzst(zzszVar, mediaFormat, zzzVar, null, null, zzssVar);
    }

    public static zzst zzb(zzsz zzszVar, MediaFormat mediaFormat, zzz zzzVar, Surface surface, MediaCrypto mediaCrypto) {
        return new zzst(zzszVar, mediaFormat, zzzVar, surface, null, null);
    }
}
