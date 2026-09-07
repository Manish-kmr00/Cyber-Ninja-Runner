package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzpi {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;

    public final zzpi zza(boolean z) {
        this.zza = true;
        return this;
    }

    public final zzpi zzb(boolean z) {
        this.zzb = z;
        return this;
    }

    public final zzpi zzc(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzpk zzd() {
        if (this.zza || !(this.zzb || this.zzc)) {
            return new zzpk(this, null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }
}
