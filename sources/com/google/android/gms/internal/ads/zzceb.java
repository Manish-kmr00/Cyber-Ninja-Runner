package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzceb {
    private final AtomicBoolean zza = new AtomicBoolean(false);

    public zzceb(String str) {
    }

    public final void zza() {
        this.zza.set(false);
    }

    public final void zzb() {
        this.zza.set(true);
    }

    public final void zzc() {
        this.zza.set(false);
    }

    public final boolean zzd() {
        return this.zza.get();
    }
}
