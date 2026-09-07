package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxh extends zzaxo {
    public zzaxh(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2) {
        super(zzawbVar, "PeyDo95+mLfuhrGfIUF5SEyw72I0JaWQ5NIbW3hL7RkHpj+RwbXsQ6AaPluHpgfK", "CW6/cpaua5hmifse/4IBt1RuitjM/M0goFLV8ytgQ+A=", zzarzVar, i, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            zzavw zzavwVar = new zzavw((String) this.zze.invoke(null, new Object[0]));
            zzarzVar.zzp(zzavwVar.zza.longValue());
            zzarzVar.zzq(zzavwVar.zzb.longValue());
        }
    }
}
