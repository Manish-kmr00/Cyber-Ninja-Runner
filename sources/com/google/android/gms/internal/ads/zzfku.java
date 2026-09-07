package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfku {
    private final zzfmi zza;
    private final String zzb;
    private final zzfkc zzc;
    private final String zzd = "Ad overlay";

    public zzfku(View view, zzfkc zzfkcVar, String str) {
        this.zza = new zzfmi(view);
        this.zzb = view.getClass().getCanonicalName();
        this.zzc = zzfkcVar;
    }

    public final zzfkc zza() {
        return this.zzc;
    }

    public final zzfmi zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zzb;
    }
}
