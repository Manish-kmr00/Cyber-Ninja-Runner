package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public abstract class zzfmc extends zzfmd {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfmc(zzflv zzflvVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzflvVar);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j;
    }
}
