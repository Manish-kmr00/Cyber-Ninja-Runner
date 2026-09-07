package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcky implements zzcko {
    private final zzdud zza;

    zzcky(zzdud zzdudVar) {
        this.zza = zzdudVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcko
    public final void zza(JSONObject jSONObject) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzjo)).booleanValue()) {
            this.zza.zzn(jSONObject);
        }
    }
}
