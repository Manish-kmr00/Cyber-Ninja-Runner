package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgfe extends zzgen {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzgfc zze;
    private final zzgfb zzf;

    /* synthetic */ zzgfe(int i, int i2, int i3, int i4, zzgfc zzgfcVar, zzgfb zzgfbVar, zzgfd zzgfdVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzgfcVar;
        this.zzf = zzgfbVar;
    }

    public static zzgfa zzf() {
        return new zzgfa(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgfe)) {
            return false;
        }
        zzgfe zzgfeVar = (zzgfe) obj;
        return zzgfeVar.zza == this.zza && zzgfeVar.zzb == this.zzb && zzgfeVar.zzc == this.zzc && zzgfeVar.zzd == this.zzd && zzgfeVar.zze == this.zze && zzgfeVar.zzf == this.zzf;
    }

    public final int hashCode() {
        return Objects.hash(zzgfe.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    public final String toString() {
        zzgfb zzgfbVar = this.zzf;
        return "AesCtrHmacAead Parameters (variant: " + String.valueOf(this.zze) + ", hashType: " + String.valueOf(zzgfbVar) + ", " + this.zzc + "-byte IV, and " + this.zzd + "-byte tags, and " + this.zza + "-byte AES key, and " + this.zzb + "-byte HMAC key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zza() {
        return this.zze != zzgfc.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zzgfb zzg() {
        return this.zzf;
    }

    public final zzgfc zzh() {
        return this.zze;
    }
}
