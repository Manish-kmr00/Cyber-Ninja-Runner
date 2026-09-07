package com.google.android.gms.internal.ads;

import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfc implements zzau {
    public final long zza;
    public final long zzb;
    public final long zzc;

    public zzfc(long j, long j2, long j3) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfc)) {
            return false;
        }
        zzfc zzfcVar = (zzfc) obj;
        return this.zza == zzfcVar.zza && this.zzb == zzfcVar.zzb && this.zzc == zzfcVar.zzc;
    }

    public final int hashCode() {
        long j = this.zza;
        long j2 = this.zzb;
        return ((((((int) (j ^ (j >>> 32))) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.zza + ", modification time=" + this.zzb + ", timescale=" + this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzau
    public final /* synthetic */ void zza(zzar zzarVar) {
    }
}
