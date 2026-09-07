package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbjx implements zzbjy {
    final /* synthetic */ zzbzp zza;

    zzbjx(zzbjz zzbjzVar, zzbzp zzbzpVar) {
        this.zza = zzbzpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final void zza(String str) {
        this.zza.zzd(new zzbnp(str));
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final void zzb(JSONObject jSONObject) {
        this.zza.zzc(jSONObject);
    }
}
