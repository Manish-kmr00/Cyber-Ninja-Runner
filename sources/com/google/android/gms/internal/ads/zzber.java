package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzber {
    public static final zzbds zza = zzbds.zzb("gads:dynamite_load:fail:sample_rate", 10000);
    public static final zzbds zzb = zzbds.zzd("gads:report_dynamite_crash_in_background_thread", false);
    public static final zzbds zzc = new zzbds("gads:public_beta:traffic_multiplier", "1.0", 4);
    public static final zzbds zzd = new zzbds("gads:sdk_crash_report_class_prefix", "com.google.", 4);
    public static final zzbds zze;
    public static final zzbds zzf;

    static {
        zzbds.zzd("gads:sdk_crash_report_enabled", false);
        zze = zzbds.zzd("gads:sdk_crash_report_full_stacktrace", false);
        zzf = zzbds.zza("gads:trapped_exception_sample_rate", 0.01d);
    }
}
