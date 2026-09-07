package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcba {
    private long zzb;
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzT)).longValue());
    private boolean zzc = true;

    zzcba() {
    }

    public final void zza(SurfaceTexture surfaceTexture, final zzcal zzcalVar) {
        if (zzcalVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (!this.zzc) {
            long j = timestamp - this.zzb;
            if (Math.abs(j) < this.zza) {
                return;
            }
        }
        this.zzc = false;
        this.zzb = timestamp;
        zzfqf zzfqfVar = com.google.android.gms.ads.internal.util.zzs.zza;
        Objects.requireNonNull(zzcalVar);
        zzfqfVar.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcaz
            @Override // java.lang.Runnable
            public final void run() {
                zzcalVar.zzk();
            }
        });
    }

    public final void zzb() {
        this.zzc = true;
    }
}
