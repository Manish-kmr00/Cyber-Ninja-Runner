package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzgvt {
    private final zzgvs zza;

    private zzgvt(zzgvs zzgvsVar) {
        this.zza = zzgvsVar;
    }

    public static zzgvt zzb(byte[] bArr, zzgdz zzgdzVar) {
        return new zzgvt(zzgvs.zzb(bArr));
    }

    public static zzgvt zzc(int i) {
        return new zzgvt(zzgvs.zzb(zzgno.zzb(i)));
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final byte[] zzd(zzgdz zzgdzVar) {
        return this.zza.zzd();
    }
}
