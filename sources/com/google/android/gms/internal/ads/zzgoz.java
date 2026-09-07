package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgoz extends zzgpc {
    private final int zza;
    private final int zzb;
    private final zzgox zzc;
    private final zzgow zzd;

    /* synthetic */ zzgoz(int i, int i2, zzgox zzgoxVar, zzgow zzgowVar, zzgoy zzgoyVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgoxVar;
        this.zzd = zzgowVar;
    }

    public static zzgov zze() {
        return new zzgov(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgoz)) {
            return false;
        }
        zzgoz zzgozVar = (zzgoz) obj;
        return zzgozVar.zza == this.zza && zzgozVar.zzd() == zzd() && zzgozVar.zzc == this.zzc && zzgozVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzgoz.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        zzgow zzgowVar = this.zzd;
        return "HMAC Parameters (variant: " + String.valueOf(this.zzc) + ", hashType: " + String.valueOf(zzgowVar) + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zza() {
        return this.zzc != zzgox.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzgox zzgoxVar = this.zzc;
        if (zzgoxVar == zzgox.zzd) {
            return this.zzb;
        }
        if (zzgoxVar == zzgox.zza || zzgoxVar == zzgox.zzb || zzgoxVar == zzgox.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgow zzf() {
        return this.zzd;
    }

    public final zzgox zzg() {
        return this.zzc;
    }
}
