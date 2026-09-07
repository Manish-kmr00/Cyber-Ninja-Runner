package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzks {
    private long zza;
    private float zzb;
    private long zzc;

    public zzks() {
        this.zza = -9223372036854775807L;
        this.zzb = -3.4028235E38f;
        this.zzc = -9223372036854775807L;
    }

    /* synthetic */ zzks(zzku zzkuVar, zzkt zzktVar) {
        this.zza = zzkuVar.zza;
        this.zzb = zzkuVar.zzb;
        this.zzc = zzkuVar.zzc;
    }

    public final zzks zzd(long j) {
        boolean z = true;
        if (j < 0) {
            if (j == -9223372036854775807L) {
                j = -9223372036854775807L;
            } else {
                z = false;
            }
        }
        zzdc.zzd(z);
        this.zzc = j;
        return this;
    }

    public final zzks zze(long j) {
        this.zza = j;
        return this;
    }

    public final zzks zzf(float f) {
        boolean z = true;
        if (f <= 0.0f && f != -3.4028235E38f) {
            z = false;
        }
        zzdc.zzd(z);
        this.zzb = f;
        return this;
    }

    public final zzku zzg() {
        return new zzku(this, null);
    }
}
