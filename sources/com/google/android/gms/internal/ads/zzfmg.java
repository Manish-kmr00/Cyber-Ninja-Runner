package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfmg extends zzfmc {
    public zzfmg(zzflv zzflvVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzflvVar, hashSet, jSONObject, j);
    }

    private final void zzc(String str) {
        zzfkr zzfkrVarZza = zzfkr.zza();
        if (zzfkrVarZza != null) {
            for (zzfjz zzfjzVar : zzfkrVarZza.zzc()) {
                if (this.zza.contains(zzfjzVar.zzh())) {
                    zzfjzVar.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfmd, android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfmd
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
