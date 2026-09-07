package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzmh {
    public final long zza;
    public final zzbl zzb;
    public final int zzc;
    public final zzuy zzd;
    public final long zze;
    public final zzbl zzf;
    public final int zzg;
    public final zzuy zzh;
    public final long zzi;
    public final long zzj;

    public zzmh(long j, zzbl zzblVar, int i, zzuy zzuyVar, long j2, zzbl zzblVar2, int i2, zzuy zzuyVar2, long j3, long j4) {
        this.zza = j;
        this.zzb = zzblVar;
        this.zzc = i;
        this.zzd = zzuyVar;
        this.zze = j2;
        this.zzf = zzblVar2;
        this.zzg = i2;
        this.zzh = zzuyVar2;
        this.zzi = j3;
        this.zzj = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmh zzmhVar = (zzmh) obj;
            if (this.zza == zzmhVar.zza && this.zzc == zzmhVar.zzc && this.zze == zzmhVar.zze && this.zzg == zzmhVar.zzg && this.zzi == zzmhVar.zzi && this.zzj == zzmhVar.zzj && Objects.equals(this.zzb, zzmhVar.zzb) && Objects.equals(this.zzd, zzmhVar.zzd) && Objects.equals(this.zzf, zzmhVar.zzf) && Objects.equals(this.zzh, zzmhVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj));
    }
}
