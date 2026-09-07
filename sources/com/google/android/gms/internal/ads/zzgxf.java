package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzgxf {
    static final zzgxf zza = new zzgxf(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc;
    private static volatile zzgxf zzd;
    private final Map zze;

    zzgxf() {
        this.zze = new HashMap();
    }

    public static zzgxf zza() {
        int i = zzgzq.zza;
        return zza;
    }

    public static zzgxf zzb() {
        zzgxf zzgxfVar = zzd;
        if (zzgxfVar != null) {
            return zzgxfVar;
        }
        synchronized (zzgxf.class) {
            zzgxf zzgxfVar2 = zzd;
            if (zzgxfVar2 != null) {
                return zzgxfVar2;
            }
            int i = zzgzq.zza;
            zzgxf zzgxfVarZzb = zzgxn.zzb(zzgxf.class);
            zzd = zzgxfVarZzb;
            return zzgxfVarZzb;
        }
    }

    public final zzgxt zzc(zzgzg zzgzgVar, int i) {
        return (zzgxt) this.zze.get(new zzgxe(zzgzgVar, i));
    }

    zzgxf(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
