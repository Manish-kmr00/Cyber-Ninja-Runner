package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzehf implements zzech {
    private final zzeij zza;
    private final zzdou zzb;

    zzehf(zzeij zzeijVar, zzdou zzdouVar) {
        this.zza = zzeijVar;
        this.zzb = zzdouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzech
    public final zzeci zza(String str, JSONObject jSONObject) throws zzfbw {
        zzbqx zzbqxVarZzb;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbQ)).booleanValue()) {
            try {
                zzbqxVarZzb = this.zzb.zzb(str);
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Coundn't create RTB adapter: ", e);
                zzbqxVarZzb = null;
            }
        } else {
            zzbqxVarZzb = this.zza.zza(str);
        }
        if (zzbqxVarZzb == null) {
            return null;
        }
        return new zzeci(zzbqxVarZzb, new zzedw(), str);
    }
}
