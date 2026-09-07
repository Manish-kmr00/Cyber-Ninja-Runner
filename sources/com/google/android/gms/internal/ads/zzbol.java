package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbol implements zzbjy {
    private final zzbzp zza;

    public zzbol(zzbom zzbomVar, zzbzp zzbzpVar) {
        this.zza = zzbzpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final void zza(String str) {
        try {
            if (str == null) {
                this.zza.zzd(new zzbnp());
            } else {
                this.zza.zzd(new zzbnp(str));
            }
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final void zzb(JSONObject jSONObject) {
        try {
            this.zza.zzc(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zza.zzd(e);
        }
    }
}
