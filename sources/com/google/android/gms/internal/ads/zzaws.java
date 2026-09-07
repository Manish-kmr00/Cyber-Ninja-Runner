package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaws extends zzaxo {
    private final long zzh;

    public zzaws(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, long j, int i, int i2) {
        super(zzawbVar, "L8i06sDgb6sVaB+ScHUGdHTAN8wr04xodnQKCwVbFMYOgH4Omnc18MPDEonWn/wv", "HhF1qQiI84tIg0/eB8BMUmrCPWLiUf2p20tCo/SaLzI=", zzarzVar, i, 25);
        this.zzh = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zze.invoke(null, new Object[0])).longValue();
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            zzarzVar.zzr(jLongValue);
            long j = this.zzh;
            if (j != 0) {
                zzarzVar.zzR(jLongValue - j);
                zzarzVar.zzS(j);
            }
        }
    }
}
