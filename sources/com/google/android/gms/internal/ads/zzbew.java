package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzbew {
    public static final zzbds zza = zzbds.zzd("gads:trustless_token_for_decagon:enabled", true);
    public static final zzbds zzb;

    static {
        zzbds.zzd("gads:invalidate_token_at_refresh_start", true);
        zzbds.zzd("gms:expose_token_for_gma:enabled", true);
        zzbds.zzd("gads:referesh_rate_limit", false);
        zzb = zzbds.zzb("gads:timeout_for_trustless_token:millis", 2000L);
        zzbds.zzd("gads:token_anonymization:enabled", true);
        zzbds.zzb("gads:cached_token:ttl_millis", 10800000L);
    }
}
