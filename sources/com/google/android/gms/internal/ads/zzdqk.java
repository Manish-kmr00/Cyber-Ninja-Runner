package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.webkit.WebViewFeature;
import com.json.b9;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdqk implements zzcya, zzcwq, zzcvf, zzddo {
    private final zzdqy zza;
    private final zzdrj zzb;
    private final int zzc;

    zzdqk(zzdqy zzdqyVar, zzdrj zzdrjVar, int i) {
        this.zza = zzdqyVar;
        this.zzb = zzdrjVar;
        this.zzc = i;
    }

    private final void zzc(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            long j = bundle.getLong(str);
            if (j >= 0) {
                this.zza.zzd(str, String.valueOf(j));
            }
        }
    }

    private final void zzd(Bundle bundle, zzfww zzfwwVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcq)).booleanValue() || bundle == null) {
            return;
        }
        bundle.putLong(zzdqm.PUBLIC_API_CALLBACK.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        zzdqy zzdqyVar = this.zza;
        zzdqyVar.zzc();
        if (bundle.containsKey("ls")) {
            zzdqyVar.zzd("ls", true != bundle.getBoolean("ls") ? "0" : "1");
        }
        int size = zzfwwVar.size();
        for (int i = 0; i < size; i++) {
            zzdqn zzdqnVar = (zzdqn) zzfwwVar.get(i);
            long j = bundle.getLong(zzdqnVar.zza().zza(), -1L);
            long j2 = bundle.getLong(zzdqnVar.zzb().zza(), -1L);
            if (j > 0 && j2 > 0) {
                zzdqyVar.zzd(zzdqnVar.zzc(), String.valueOf(j2 - j));
            }
        }
        zzc(bundle.getBundle("client_sig_latency_key"));
        zzc(bundle.getBundle("gms_sig_latency_key"));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhz)).booleanValue()) {
            if (bundle.containsKey("sod_h")) {
                zzdqyVar.zzd("sod_h", true == bundle.getBoolean("sod_h") ? "1" : "0");
            }
            if (bundle.containsKey("cmr")) {
                zzdqyVar.zzd("cmr", String.valueOf(bundle.getInt("cmr")));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdl(zzbuy zzbuyVar) {
        this.zza.zzf(zzbuyVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdm(zzfbg zzfbgVar) {
        this.zza.zze(zzfbgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcvf
    public final void zzdz(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzdqy zzdqyVar = this.zza;
        zzdqyVar.zzb().put("action", "ftl");
        zzdqyVar.zzd("ftl", String.valueOf(zzeVar.zza));
        zzdqyVar.zzd("ed", zzeVar.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhh)).booleanValue()) {
            zzdqyVar.zzd("emsg", zzeVar.zzb);
        }
        this.zzb.zzg(zzdqyVar.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzddo
    public final void zze(com.google.android.gms.ads.nonagon.signalgeneration.zzbk zzbkVar) {
        String str;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgT)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhz)).booleanValue()) {
                this.zza.zzb().put("sgw", String.valueOf(this.zzc));
            }
            if (zzbkVar == null) {
                zzdqy zzdqyVar = this.zza;
                zzdqyVar.zzb().put("action", "sgs");
                zzdqyVar.zzb().put("request_id", "-1");
                this.zzb.zzg(zzdqyVar.zzb());
                return;
            }
            zzbuy zzbuyVar = zzbkVar.zzd;
            Bundle bundle = zzbkVar.zze;
            if (zzbuyVar != null) {
                zzd(zzbuyVar.zzm, zzdqn.zza);
            } else if (bundle != null && !bundle.isEmpty()) {
                zzd(bundle, zzdqn.zza);
            }
            try {
                JSONObject jSONObject = new JSONObject(TextUtils.isEmpty(zzbkVar.zzc) ? zzbkVar.zzb : zzbkVar.zzc);
                zzdqy zzdqyVar2 = this.zza;
                zzdqyVar2.zzb().put("action", "sgs");
                Map mapZzb = zzdqyVar2.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzjL)).booleanValue()) {
                    try {
                        str = jSONObject.getJSONObject("extras").getBoolean("accept_3p_cookie") ? "1" : "0";
                    } catch (JSONException e) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Error retrieving JSONObject from the requestJson, ", e);
                        str = "na";
                    }
                } else {
                    str = "na";
                }
                mapZzb.put("tpc", str);
                zzbuy zzbuyVar2 = zzbkVar.zzd;
                if (zzbuyVar2 != null) {
                    this.zza.zzf(zzbuyVar2.zza);
                }
                this.zzb.zzg(this.zza.zzb());
            } catch (JSONException unused) {
                zzdqy zzdqyVar3 = this.zza;
                zzdqyVar3.zzb().put("action", "sgf");
                zzdqyVar3.zzb().put("sgf_reason", "request_invalid");
                this.zzb.zzg(zzdqyVar3.zzb());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddo
    public final void zzf(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgT)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhz)).booleanValue()) {
                this.zza.zzb().put("sgw", String.valueOf(this.zzc));
            }
            zzdqy zzdqyVar = this.zza;
            zzdqyVar.zzb().put("action", "sgf");
            zzdqyVar.zzd("sgf_reason", str);
            this.zzb.zzg(zzdqyVar.zzb());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzt() {
        zzdqy zzdqyVar = this.zza;
        zzdqyVar.zzb().put("action", b9.h.r);
        zzd(zzdqyVar.zza(), zzdqn.zzb);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmH)).booleanValue()) {
            zzdqyVar.zzb().put("mafe", true != WebViewFeature.isFeatureSupported("MUTE_AUDIO") ? "0" : "1");
        }
        this.zzb.zzg(zzdqyVar.zzb());
    }
}
