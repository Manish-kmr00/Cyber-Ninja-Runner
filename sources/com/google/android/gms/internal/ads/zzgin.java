package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgin extends zzgen {
    private final zzgim zza;

    private zzgin(zzgim zzgimVar) {
        this.zza = zzgimVar;
    }

    public static zzgin zzc(zzgim zzgimVar) {
        return new zzgin(zzgimVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgin) && ((zzgin) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzgin.class, this.zza);
    }

    public final String toString() {
        return "XChaCha20Poly1305 Parameters (variant: " + this.zza.toString() + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zza() {
        return this.zza != zzgim.zzc;
    }

    public final zzgim zzb() {
        return this.zza;
    }
}
