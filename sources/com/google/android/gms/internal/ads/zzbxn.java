package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzbxn {
    private final Clock zza;
    private final zzbxl zzb;

    zzbxn(Clock clock, zzbxl zzbxlVar) {
        this.zza = clock;
        this.zzb = zzbxlVar;
    }

    public static zzbxn zza(Context context) {
        return zzbxx.zzb(context).zza();
    }

    public final void zzb(int i, long j) {
        this.zzb.zza(i, j);
    }

    public final void zzc(com.google.android.gms.ads.internal.client.zzfr zzfrVar) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }
}
