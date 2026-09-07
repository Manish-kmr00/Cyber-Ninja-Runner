package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzddo;
import com.google.android.gms.internal.ads.zzdqy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzw implements zzddo {
    private final zzdqy zza;
    private final zzv zzb;
    private final String zzc;
    private final int zzd;

    public zzw(zzdqy zzdqyVar, zzv zzvVar, String str, int i) {
        this.zza = zzdqyVar;
        this.zzb = zzvVar;
        this.zzc = str;
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzddo
    public final void zze(zzbk zzbkVar) {
        String strOptString;
        if (zzbkVar == null || this.zzd == 2) {
            return;
        }
        if (TextUtils.isEmpty(zzbkVar.zzc)) {
            this.zzb.zze(this.zzc, zzbkVar.zzb, this.zza);
            return;
        }
        try {
            strOptString = new JSONObject(zzbkVar.zzc).optString("request_id");
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "RenderSignals.getRequestId");
            strOptString = null;
        }
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        this.zzb.zze(strOptString, zzbkVar.zzc, this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzddo
    public final void zzf(String str) {
    }
}
