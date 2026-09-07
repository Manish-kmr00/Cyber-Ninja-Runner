package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfmx extends zzfmt {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final long zze;

    /* synthetic */ zzfmx(String str, boolean z, boolean z2, boolean z3, long j, boolean z4, long j2, zzfmw zzfmwVar) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = j;
        this.zze = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfmt) {
            zzfmt zzfmtVar = (zzfmt) obj;
            if (this.zza.equals(zzfmtVar.zzd()) && this.zzb == zzfmtVar.zzh() && this.zzc == zzfmtVar.zzg()) {
                zzfmtVar.zzf();
                if (this.zzd == zzfmtVar.zzb()) {
                    zzfmtVar.zze();
                    if (this.zze == zzfmtVar.zza()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ (true != this.zzc ? 1237 : 1231)) * 1000003) ^ 1237) * 1000003) ^ ((int) this.zzd)) * 1000003) ^ 1237) * 1000003) ^ ((int) this.zze);
    }

    public final String toString() {
        return "AdShield2Options{clientVersion=" + this.zza + ", shouldGetAdvertisingId=" + this.zzb + ", isGooglePlayServicesAvailable=" + this.zzc + ", enableQuerySignalsTimeout=false, querySignalsTimeoutMs=" + this.zzd + ", enableQuerySignalsCache=false, querySignalsCacheTtlSeconds=" + this.zze + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfmt
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfmt
    public final long zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfmt
    public final String zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfmt
    public final boolean zze() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfmt
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfmt
    public final boolean zzg() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfmt
    public final boolean zzh() {
        return this.zzb;
    }
}
