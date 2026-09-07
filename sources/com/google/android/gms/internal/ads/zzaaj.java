package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzaaj {
    private final Context zza;
    private boolean zzb;
    private zzti zzc = zzti.zza;
    private final zzsu zzd;
    private Handler zze;
    private zzabs zzf;

    public zzaaj(Context context) {
        this.zza = context;
        this.zzd = new zzso(context, null, null);
    }

    public final zzaaj zze(Handler handler) {
        this.zze = handler;
        return this;
    }

    public final zzaaj zzf(zzabs zzabsVar) {
        this.zzf = zzabsVar;
        return this;
    }

    public final zzaaj zzg(zzti zztiVar) {
        this.zzc = zztiVar;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0010  */
    public final zzaal zzh() {
        boolean z;
        zzdc.zzf(!this.zzb);
        Handler handler = this.zze;
        if (handler == null && this.zzf == null) {
            z = true;
        } else {
            z = false;
            if (handler != null && this.zzf != null) {
                z = true;
            }
        }
        zzdc.zzf(z);
        this.zzb = true;
        return new zzaal(this);
    }
}
