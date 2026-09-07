package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgow {
    public static final zzgow zza = new zzgow("SHA1");
    public static final zzgow zzb = new zzgow("SHA224");
    public static final zzgow zzc = new zzgow("SHA256");
    public static final zzgow zzd = new zzgow("SHA384");
    public static final zzgow zze = new zzgow("SHA512");
    private final String zzf;

    private zzgow(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
