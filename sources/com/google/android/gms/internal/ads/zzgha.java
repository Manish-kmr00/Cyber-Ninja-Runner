package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgha extends zzgen {
    private final String zza;
    private final zzggz zzb;

    private zzgha(String str, zzggz zzggzVar) {
        this.zza = str;
        this.zzb = zzggzVar;
    }

    public static zzgha zzc(String str, zzggz zzggzVar) {
        return new zzgha(str, zzggzVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgha)) {
            return false;
        }
        zzgha zzghaVar = (zzgha) obj;
        return zzghaVar.zza.equals(this.zza) && zzghaVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(zzgha.class, this.zza, this.zzb);
    }

    public final String toString() {
        return "LegacyKmsAead Parameters (keyUri: " + this.zza + ", variant: " + this.zzb.toString() + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zza() {
        return this.zzb != zzggz.zzb;
    }

    public final zzggz zzb() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zza;
    }
}
