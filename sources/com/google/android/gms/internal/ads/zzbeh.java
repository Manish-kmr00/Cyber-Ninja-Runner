package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzbeh {
    public static final zzbds zza = new zzbds("gads:gma_attestation:click:macro_string", "@click_attok@", 4);
    public static final zzbds zzb = new zzbds("gads:gma_attestation:click:query_param", "attok", 4);
    public static final zzbds zzc = zzbds.zzb("gads:gma_attestation:click:timeout", 2000);
    public static final zzbds zzd = zzbds.zzd("gads:gma_attestation:click:enable", false);
    public static final zzbds zze = zzbds.zzb("gads:gma_attestation:click:enable_dynamite_version", 213806100);
    public static final zzbds zzf = zzbds.zzd("gads:gma_attestation:click:qualification:enable", true);
    public static final zzbds zzg = zzbds.zzd("gads:gma_attestation:image_hash", false);
    public static final zzbds zzh = zzbds.zzd("gads:gma_attestation:impression:enable", true);
    public static final zzbds zzi;

    static {
        zzbds.zzd("gads:gma_attestation:request:enable_javascript", false);
        zzbds.zzd("gads:gma_attestation:request:enable", true);
        zzi = zzbds.zzd("gads:gma_attestation:click:report_error", true);
    }
}
