package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzza {
    private final Handler zza;
    private final zzzc zzb;
    private boolean zzc;

    public zzza(Handler handler, zzzc zzzcVar) {
        this.zza = handler;
        this.zzb = zzzcVar;
    }

    public final void zzc() {
        this.zzc = true;
    }
}
