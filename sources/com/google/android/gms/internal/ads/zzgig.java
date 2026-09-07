package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgig extends zzgen {
    private final zzgif zza;
    private final int zzb;

    private zzgig(zzgif zzgifVar, int i) {
        this.zza = zzgifVar;
        this.zzb = i;
    }

    public static zzgig zzd(zzgif zzgifVar, int i) throws GeneralSecurityException {
        if (i < 8 || i > 12) {
            throw new GeneralSecurityException("Salt size must be between 8 and 12 bytes");
        }
        return new zzgig(zzgifVar, i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgig)) {
            return false;
        }
        zzgig zzgigVar = (zzgig) obj;
        return zzgigVar.zza == this.zza && zzgigVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzgig.class, this.zza, Integer.valueOf(this.zzb));
    }

    public final String toString() {
        return "X-AES-GCM Parameters (variant: " + this.zza.toString() + "salt_size_bytes: " + this.zzb + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zza() {
        return this.zza != zzgif.zzb;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzgif zzc() {
        return this.zza;
    }
}
