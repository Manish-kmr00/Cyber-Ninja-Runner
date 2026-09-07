package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcbf {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final boolean zzi;
    public final boolean zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final long zzm;
    public final long zzn;

    public zzcbf(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zza = zza(jSONObject, "aggressive_media_codec_release", zzbci.zzY);
        this.zzb = zzb(jSONObject, "byte_buffer_precache_limit", zzbci.zzj);
        this.zzc = zzb(jSONObject, "exo_cache_buffer_size", zzbci.zzt);
        this.zzd = zzb(jSONObject, "exo_connect_timeout_millis", zzbci.zzf);
        zzbbz zzbbzVar = zzbci.zze;
        if (jSONObject != null) {
            try {
                jSONObject.getString("exo_player_version");
            } catch (JSONException unused2) {
            }
        }
        this.zze = zzb(jSONObject, "exo_read_timeout_millis", zzbci.zzg);
        this.zzf = zzb(jSONObject, "load_check_interval_bytes", zzbci.zzh);
        this.zzg = zzb(jSONObject, "player_precache_limit", zzbci.zzi);
        this.zzh = zzb(jSONObject, "socket_receive_buffer_size", zzbci.zzk);
        this.zzi = zza(jSONObject, "use_cache_data_source", zzbci.zzew);
        zzb(jSONObject, "min_retry_count", zzbci.zzl);
        this.zzj = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbci.zzn);
        this.zzk = zza(jSONObject, "enable_multiple_video_playback", zzbci.zzcd);
        this.zzl = zza(jSONObject, "use_range_http_data_source", zzbci.zzcf);
        this.zzm = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbci.zzcg);
        this.zzn = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbci.zzch);
    }

    private static final boolean zza(JSONObject jSONObject, String str, zzbbz zzbbzVar) {
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue();
        if (jSONObject == null) {
            return zBooleanValue;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return zBooleanValue;
        }
    }

    private static final int zzb(JSONObject jSONObject, String str, zzbbz zzbbzVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).intValue();
    }

    private static final long zzc(JSONObject jSONObject, String str, zzbbz zzbbzVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getLong(str);
            } catch (JSONException unused) {
            }
        }
        return ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).longValue();
    }
}
