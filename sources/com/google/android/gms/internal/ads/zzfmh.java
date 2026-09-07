package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfmh extends zzfmc {
    public zzfmh(zzflv zzflvVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzflvVar, hashSet, jSONObject, j);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        zzflv zzflvVar = this.zzd;
        JSONObject jSONObject = this.zzb;
        if (zzfln.zzg(jSONObject, zzflvVar.zza())) {
            return null;
        }
        zzflvVar.zze(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfmd, android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfmd
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzfkr zzfkrVarZza;
        if (!TextUtils.isEmpty(str) && (zzfkrVarZza = zzfkr.zza()) != null) {
            for (zzfjz zzfjzVar : zzfkrVarZza.zzc()) {
                if (this.zza.contains(zzfjzVar.zzh())) {
                    zzfjzVar.zzg().zzh(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
