package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxd extends zzaxo {
    public zzaxd(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2) {
        super(zzawbVar, "4FdiBUPFa1CQITk8QYb/KC5CZQJZFUk4AUePTkKoIhV1OCu9c96sc0zaEo3W45kz", "CTOO7vS2eGX5K3ZMmh7m+q2y1+wvLadBs0NzJgxSeMo=", zzarzVar, i, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        try {
            boolean zBooleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
            zzarz zzarzVar = this.zzd;
            int i = 1;
            if (true == zBooleanValue) {
                i = 2;
            }
            zzarzVar.zzac(i);
        } catch (InvocationTargetException unused) {
            this.zzd.zzac(3);
        }
    }
}
