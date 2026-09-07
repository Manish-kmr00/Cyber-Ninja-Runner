package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzma {
    public static final zzma zza;
    public static final zzma zzb;
    public final long zzc;
    public final long zzd;

    static {
        zzma zzmaVar = new zzma(0L, 0L);
        zza = zzmaVar;
        new zzma(Long.MAX_VALUE, Long.MAX_VALUE);
        new zzma(Long.MAX_VALUE, 0L);
        new zzma(0L, Long.MAX_VALUE);
        zzb = zzmaVar;
    }

    public zzma(long j, long j2) {
        zzdc.zzd(j >= 0);
        zzdc.zzd(j2 >= 0);
        this.zzc = j;
        this.zzd = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzma zzmaVar = (zzma) obj;
            if (this.zzc == zzmaVar.zzc && this.zzd == zzmaVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzc) * 31) + ((int) this.zzd);
    }
}
