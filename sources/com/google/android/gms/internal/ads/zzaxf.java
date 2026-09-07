package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxf extends zzaxo {
    private final boolean zzh;

    public zzaxf(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2) {
        super(zzawbVar, "l73pWBOU/qyDPWyApDuwt3A6opU9E+7PquXzxCByw4gixPmt031v7ukW//Ddd+VY", "VAZB0ZL6jYmE0jUHUJ0Om2CbCtDd1BstFFxYH2/l7vw=", zzarzVar, i, 61);
        this.zzh = zzawbVar.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zze.invoke(null, this.zza.zzb(), Boolean.valueOf(this.zzh))).longValue();
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            zzarzVar.zzC(jLongValue);
        }
    }
}
