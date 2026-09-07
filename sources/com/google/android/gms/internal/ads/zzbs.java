package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbs {
    public final int zza;
    private final zzbm zzb;
    private final boolean zzc;
    private final int[] zzd;
    private final boolean[] zze;

    static {
        int i = zzeu.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public zzbs(zzbm zzbmVar, boolean z, int[] iArr, boolean[] zArr) {
        int i = zzbmVar.zza;
        this.zza = i;
        zzdc.zzd(i == iArr.length && i == zArr.length);
        this.zzb = zzbmVar;
        this.zzc = z && i > 1;
        this.zzd = (int[]) iArr.clone();
        this.zze = (boolean[]) zArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbs zzbsVar = (zzbs) obj;
            if (this.zzc == zzbsVar.zzc && this.zzb.equals(zzbsVar.zzb) && Arrays.equals(this.zzd, zzbsVar.zzd) && Arrays.equals(this.zze, zzbsVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.zzb.hashCode() * 31) + (this.zzc ? 1 : 0)) * 31) + Arrays.hashCode(this.zzd)) * 31) + Arrays.hashCode(this.zze);
    }

    public final int zza() {
        return this.zzb.zzc;
    }

    public final zzz zzb(int i) {
        return this.zzb.zzb(i);
    }

    public final boolean zzc() {
        for (boolean z : this.zze) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzd(int i) {
        return this.zze[i];
    }
}
