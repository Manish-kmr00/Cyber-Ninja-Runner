package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgfb {
    public static final zzgfb zza = new zzgfb("SHA1");
    public static final zzgfb zzb = new zzgfb("SHA224");
    public static final zzgfb zzc = new zzgfb("SHA256");
    public static final zzgfb zzd = new zzgfb("SHA384");
    public static final zzgfb zze = new zzgfb("SHA512");
    private final String zzf;

    private zzgfb(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
