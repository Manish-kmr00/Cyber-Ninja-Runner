package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzgw {
    static final zzgw zza = new zzgw(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc;
    private static volatile zzgw zzd;
    private final Map zze;

    zzgw() {
        this.zze = new HashMap();
    }

    public static zzgw zza() {
        zzgw zzgwVar = zzd;
        if (zzgwVar != null) {
            return zzgwVar;
        }
        synchronized (zzgw.class) {
            zzgw zzgwVar2 = zzd;
            if (zzgwVar2 != null) {
                return zzgwVar2;
            }
            int i = zziu.zza;
            zzgw zzgwVarZzb = zzhe.zzb(zzgw.class);
            zzd = zzgwVarZzb;
            return zzgwVarZzb;
        }
    }

    public final zzhj zzb(zzim zzimVar, int i) {
        return (zzhj) this.zze.get(new zzgv(zzimVar, i));
    }

    zzgw(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
