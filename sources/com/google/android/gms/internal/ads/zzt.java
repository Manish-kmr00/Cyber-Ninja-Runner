package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzt {
    private final SparseBooleanArray zza = new SparseBooleanArray();
    private boolean zzb;

    public final zzt zza(int i) {
        zzdc.zzf(!this.zzb);
        this.zza.append(i, true);
        return this;
    }

    public final zzv zzb() {
        zzdc.zzf(!this.zzb);
        this.zzb = true;
        return new zzv(this.zza, null);
    }
}
