package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgoi extends zzgpc {
    private final int zza;
    private final int zzb;
    private final zzgog zzc;

    /* synthetic */ zzgoi(int i, int i2, zzgog zzgogVar, zzgoh zzgohVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgogVar;
    }

    public static zzgof zze() {
        return new zzgof(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgoi)) {
            return false;
        }
        zzgoi zzgoiVar = (zzgoi) obj;
        return zzgoiVar.zza == this.zza && zzgoiVar.zzd() == zzd() && zzgoiVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return Objects.hash(zzgoi.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc);
    }

    public final String toString() {
        return "AES-CMAC Parameters (variant: " + String.valueOf(this.zzc) + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zza() {
        return this.zzc != zzgog.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzgog zzgogVar = this.zzc;
        if (zzgogVar == zzgog.zzd) {
            return this.zzb;
        }
        if (zzgogVar == zzgog.zza || zzgogVar == zzgog.zzb || zzgogVar == zzgog.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgog zzf() {
        return this.zzc;
    }
}
