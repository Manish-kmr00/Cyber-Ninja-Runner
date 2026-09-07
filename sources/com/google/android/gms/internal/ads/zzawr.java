package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzawr extends zzaxo {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzawr(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2) {
        super(zzawbVar, "GVtnwWIrGNoPqjL1Fje94meezE8Inh8q0aGs9n0MCbVt8vOhfMkdgAbgJriZr+ZA", "EVd3TNrS3JyklQrlg/g4eG7fxshxeFVbto/4/TJxZiw=", zzarzVar, i, 44);
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
            zzarzVar.zzo(zzh.longValue());
        }
    }
}
