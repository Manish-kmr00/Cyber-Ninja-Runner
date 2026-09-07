package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxj extends zzaxo {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzaxj(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2) {
        super(zzawbVar, "y9sVnCEW90f5Vx2HqIuVcdDKh+hI2qRq1sCpyHGv3MKSudlm5MGW5X5BN8/9lVwY", "EIfBdErCKLHua1LnSPtD4OKhBX6Yh9pp3IQrjV6gKSc=", zzarzVar, i, 33);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzh == null) {
            synchronized (zzi) {
                if (zzh == null) {
                    zzh = (Long) this.zze.invoke(null, new Object[0]);
                }
            }
        }
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            zzarzVar.zzT(zzh.longValue());
        }
    }
}
