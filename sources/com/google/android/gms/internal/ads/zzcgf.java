package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcgf {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzcgf(int i, int i2, int i3) {
        this.zzc = i;
        this.zzb = i2;
        this.zza = i3;
    }

    public static zzcgf zza() {
        return new zzcgf(0, 0, 0);
    }

    public static zzcgf zzb(int i, int i2) {
        return new zzcgf(1, i, i2);
    }

    public static zzcgf zzc(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        if (zzrVar.zzd) {
            return new zzcgf(3, 0, 0);
        }
        if (zzrVar.zzi) {
            return new zzcgf(2, 0, 0);
        }
        return zzrVar.zzh ? new zzcgf(0, 0, 0) : new zzcgf(1, zzrVar.zzf, zzrVar.zzc);
    }

    public static zzcgf zzd() {
        return new zzcgf(5, 0, 0);
    }

    public static zzcgf zze() {
        return new zzcgf(4, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 0;
    }

    public final boolean zzg() {
        return this.zzc == 2;
    }

    public final boolean zzh() {
        return this.zzc == 5;
    }

    public final boolean zzi() {
        return this.zzc == 3;
    }

    public final boolean zzj() {
        return this.zzc == 4;
    }
}
