package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzbeg {
    public static final zzbds zza = zzbds.zzd("gads:init:init_on_bg_thread", true);
    public static final zzbds zzb = zzbds.zzd("gads:init:init_on_single_bg_thread", false);
    public static final zzbds zzc = zzbds.zzd("gads:adloader_load_bg_thread", true);
    public static final zzbds zzd = zzbds.zzd("gads:appopen_load_on_bg_thread", true);
    public static final zzbds zze = zzbds.zzd("gads:banner_destroy_bg_thread", false);
    public static final zzbds zzf = zzbds.zzd("gads:banner_load_bg_thread", true);
    public static final zzbds zzg = zzbds.zzd("gads:banner_pause_bg_thread", false);
    public static final zzbds zzh = zzbds.zzd("gads:banner_resume_bg_thread", false);
    public static final zzbds zzi = zzbds.zzd("gads:interstitial_load_on_bg_thread", true);
    public static final zzbds zzj;
    public static final zzbds zzk;

    static {
        zzbds.zzd("gads:persist_flags_on_bg_thread", true);
        zzj = zzbds.zzd("gads:query_info_bg_thread", true);
        zzk = zzbds.zzd("gads:rewarded_load_bg_thread", true);
    }
}
