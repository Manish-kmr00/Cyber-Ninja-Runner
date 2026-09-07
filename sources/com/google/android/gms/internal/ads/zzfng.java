package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfng implements zzfnh {
    private static final zzasu zza;

    static {
        zzarz zzarzVarZza = zzasu.zza();
        zzarzVarZza.zzv(ExifInterface.LONGITUDE_EAST);
        zza = (zzasu) zzarzVarZza.zzbr();
    }

    zzfng() {
    }

    @Override // com.google.android.gms.internal.ads.zzfnh
    public final zzasu zza() {
        return zza;
    }
}
