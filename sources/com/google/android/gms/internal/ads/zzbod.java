package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbod implements zzbjy {
    final /* synthetic */ zzboe zza;
    private final zzbng zzb;
    private final zzbzp zzc;

    public zzbod(zzboe zzboeVar, zzbng zzbngVar, zzbzp zzbzpVar) {
        this.zza = zzboeVar;
        this.zzb = zzbngVar;
        this.zzc = zzbzpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final void zza(String str) {
        try {
            if (str == null) {
                this.zzc.zzd(new zzbnp());
            } else {
                this.zzc.zzd(new zzbnp(str));
            }
        } catch (IllegalStateException unused) {
        } finally {
            this.zzb.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final void zzb(JSONObject jSONObject) {
        try {
            try {
                this.zzc.zzc(this.zza.zza.zza(jSONObject));
            } catch (IllegalStateException unused) {
            } catch (JSONException e) {
                this.zzc.zzd(e);
            }
        } finally {
            this.zzb.zzb();
        }
    }
}
