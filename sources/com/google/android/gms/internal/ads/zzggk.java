package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzggk extends zzgen {
    private final int zza;
    private final zzggi zzb;

    /* synthetic */ zzggk(int i, zzggi zzggiVar, zzggj zzggjVar) {
        this.zza = i;
        this.zzb = zzggiVar;
    }

    public static zzggh zzc() {
        return new zzggh(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzggk)) {
            return false;
        }
        zzggk zzggkVar = (zzggk) obj;
        return zzggkVar.zza == this.zza && zzggkVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzggk.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        return "AesGcmSiv Parameters (variant: " + String.valueOf(this.zzb) + ", " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zza() {
        return this.zzb != zzggi.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzggi zzd() {
        return this.zzb;
    }
}
