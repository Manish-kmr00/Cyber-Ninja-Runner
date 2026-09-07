package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzawy extends zzaxo {
    private final zzavt zzh;

    public zzawy(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2, zzavt zzavtVar) {
        super(zzawbVar, "BC7L/NCOnXWRm7JYe+JuyF6kvlir6BpsAS0Yfubd/KoT9Dq97JPNt3OElb9RFD/3", "5el+rCV4lcaWS1gvt3lCAaH+20tOJyIAJrK3BNimLVE=", zzarzVar, i, 94);
        this.zzh = zzavtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int iIntValue = ((Integer) this.zze.invoke(null, this.zzh.zza())).intValue();
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            zzarzVar.zzab(zzasl.zza(iIntValue));
        }
    }
}
