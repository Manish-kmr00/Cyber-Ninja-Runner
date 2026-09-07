package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdgq implements zzhey {
    private final zzdgo zza;

    public zzdgq(zzdgo zzdgoVar) {
        this.zza = zzdgoVar;
    }

    public static JSONObject zza(zzdgo zzdgoVar) {
        JSONObject jSONObjectZzb = zzdgoVar.zzb();
        zzhfg.zzb(jSONObjectZzb);
        return jSONObjectZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* synthetic */ Object zzb() {
        return zza(this.zza);
    }

    public final JSONObject zzc() {
        return zza(this.zza);
    }
}
