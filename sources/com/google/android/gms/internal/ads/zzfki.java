package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfki {
    private final String zza;
    private final String zzb;

    private zzfki(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public static zzfki zza(String str, String str2) {
        zzflr.zzb(str, "Name is null or empty");
        zzflr.zzb(str2, "Version is null or empty");
        return new zzfki(str, str2);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
