package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzggq extends zzgen {
    private final zzggp zza;

    private zzggq(zzggp zzggpVar) {
        this.zza = zzggpVar;
    }

    public static zzggq zzc(zzggp zzggpVar) {
        return new zzggq(zzggpVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzggq) && ((zzggq) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzggq.class, this.zza);
    }

    public final String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + this.zza.toString() + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zza() {
        return this.zza != zzggp.zzc;
    }

    public final zzggp zzb() {
        return this.zza;
    }
}
