package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeen implements zzech {
    private final zzdou zza;

    public zzeen(zzdou zzdouVar) {
        this.zza = zzdouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzech
    public final zzeci zza(String str, JSONObject jSONObject) throws zzfbw {
        return new zzeci(this.zza.zzc(str, jSONObject), new zzedw(), str);
    }
}
