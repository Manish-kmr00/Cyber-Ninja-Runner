package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzawm extends zzaxo {
    public zzawm(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2) {
        super(zzawbVar, "xpgkXeXWn6DmLYTNzE+nC7rUeDShyzkk1EC10M4IEySUDF2z2+kXtLWXs5Obv1SF", "8+kC10mboFZbM6d8hccBgctoWviYbh/HXHbxMx+5ceA=", zzarzVar, i, 89);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        String str = (String) this.zze.invoke(null, new Object[0]);
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            zzarzVar.zzg(str);
        }
    }
}
