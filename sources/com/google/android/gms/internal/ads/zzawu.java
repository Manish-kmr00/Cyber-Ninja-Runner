package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzawu extends zzaxo {
    private final zzawc zzh;

    public zzawu(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2, zzawc zzawcVar) {
        super(zzawbVar, "4sDibVZK9eKuFlqXgTpdhhKs2Orw9dH1PELY4zPrs10iomnIsvpd54Iu4NVAy+DZ", "7HL5eN/Pvda4VOei0IPDYI1tAwkOrIcQx+u+McMv8ws=", zzarzVar, i, 85);
        this.zzh = zzawcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        Method method = this.zze;
        zzawc zzawcVar = this.zzh;
        long[] jArr = (long[]) method.invoke(null, Long.valueOf(zzawcVar.zzd()), Long.valueOf(zzawcVar.zzh()), Long.valueOf(zzawcVar.zzb()), Long.valueOf(zzawcVar.zzf()));
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            zzarzVar.zzt(jArr[0]);
            zzarzVar.zzs(jArr[1]);
        }
    }
}
