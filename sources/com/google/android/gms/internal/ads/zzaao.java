package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzaao extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzaam zzd;
    private boolean zze;

    /* synthetic */ zzaao(zzaam zzaamVar, SurfaceTexture surfaceTexture, boolean z, zzaan zzaanVar) {
        super(surfaceTexture);
        this.zzd = zzaamVar;
        this.zza = z;
    }

    public static zzaao zza(Context context, boolean z) {
        boolean z2 = true;
        if (z && !zzb(context)) {
            z2 = false;
        }
        zzdc.zzf(z2);
        return new zzaam().zza(z ? zzb : 0);
    }

    public static synchronized boolean zzb(Context context) {
        int i;
        if (!zzc) {
            if (zzdo.zzb(context)) {
                i = zzdo.zzc() ? 1 : 2;
            } else {
                i = 0;
            }
            zzb = i;
            zzc = true;
        }
        return zzb != 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        zzaam zzaamVar = this.zzd;
        synchronized (zzaamVar) {
            if (!this.zze) {
                zzaamVar.zzb();
                this.zze = true;
            }
        }
    }
}
