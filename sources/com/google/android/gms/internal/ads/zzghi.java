package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzghi {
    public static final zzghi zza = new zzghi("ASSUME_AES_GCM");
    public static final zzghi zzb = new zzghi("ASSUME_XCHACHA20POLY1305");
    public static final zzghi zzc = new zzghi("ASSUME_CHACHA20POLY1305");
    public static final zzghi zzd = new zzghi("ASSUME_AES_CTR_HMAC");
    public static final zzghi zze = new zzghi("ASSUME_AES_EAX");
    public static final zzghi zzf = new zzghi("ASSUME_AES_GCM_SIV");
    private final String zzg;

    private zzghi(String str) {
        this.zzg = str;
    }

    public final String toString() {
        return this.zzg;
    }
}
