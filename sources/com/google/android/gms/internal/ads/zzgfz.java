package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgfz extends zzgen {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzgfx zzd;

    /* synthetic */ zzgfz(int i, int i2, int i3, zzgfx zzgfxVar, zzgfy zzgfyVar) {
        this.zza = i;
        this.zzd = zzgfxVar;
    }

    public static zzgfw zzc() {
        return new zzgfw(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgfz)) {
            return false;
        }
        zzgfz zzgfzVar = (zzgfz) obj;
        if (zzgfzVar.zza == this.zza) {
            int i = zzgfzVar.zzb;
            int i2 = zzgfzVar.zzc;
            if (zzgfzVar.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzgfz.class, Integer.valueOf(this.zza), 12, 16, this.zzd);
    }

    public final String toString() {
        return "AesGcm Parameters (variant: " + String.valueOf(this.zzd) + ", 12-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zza() {
        return this.zzd != zzgfx.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzgfx zzd() {
        return this.zzd;
    }
}
