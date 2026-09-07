package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzpk {
    public static final zzpk zza = new zzpi().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    /* synthetic */ zzpk(zzpi zzpiVar, zzpj zzpjVar) {
        this.zzb = zzpiVar.zza;
        this.zzc = zzpiVar.zzb;
        this.zzd = zzpiVar.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzpk zzpkVar = (zzpk) obj;
            if (this.zzb == zzpkVar.zzb && this.zzc == zzpkVar.zzc && this.zzd == zzpkVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        return ((z ? 1 : 0) << 2) + (z2 ? 1 : 0) + (z2 ? 1 : 0) + (this.zzd ? 1 : 0);
    }
}
