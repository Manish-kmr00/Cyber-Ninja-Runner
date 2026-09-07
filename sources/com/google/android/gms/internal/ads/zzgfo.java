package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgfo extends zzgen {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzgfm zzd;

    /* synthetic */ zzgfo(int i, int i2, int i3, zzgfm zzgfmVar, zzgfn zzgfnVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzd = zzgfmVar;
    }

    public static zzgfl zzd() {
        return new zzgfl(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgfo)) {
            return false;
        }
        zzgfo zzgfoVar = (zzgfo) obj;
        if (zzgfoVar.zza == this.zza && zzgfoVar.zzb == this.zzb) {
            int i = zzgfoVar.zzc;
            if (zzgfoVar.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzgfo.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd);
    }

    public final String toString() {
        return "AesEax Parameters (variant: " + String.valueOf(this.zzd) + ", " + this.zzb + "-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zza() {
        return this.zzd != zzgfm.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzgfm zze() {
        return this.zzd;
    }
}
