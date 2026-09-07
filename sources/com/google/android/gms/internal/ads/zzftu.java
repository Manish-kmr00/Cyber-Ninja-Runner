package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzftu implements Serializable {
    zzftu() {
    }

    public static zzftu zzc() {
        return zzfta.zza;
    }

    public static zzftu zzd(Object obj) {
        return obj == null ? zzfta.zza : new zzfub(obj);
    }

    public abstract zzftu zza(zzftl zzftlVar);

    public abstract Object zzb(Object obj);
}
