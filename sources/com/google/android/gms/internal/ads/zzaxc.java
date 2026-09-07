package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxc extends zzaxo {
    public zzaxc(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2) {
        super(zzawbVar, "eOeeCCDaHEKu0CdXgH37stIhKsViYKbWUfDprJIAztyuoZ35HLkPrqpB3uvB5WOW", "mbdIWlqr/AIx3NpqoEZqhPYOK/hsicHKSTj8PTzGR/g=", zzarzVar, i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzavh zzavhVar = new zzavh((String) this.zze.invoke(null, this.zza.zzb(), Boolean.valueOf(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdc)).booleanValue())));
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            zzarzVar.zzj(zzavhVar.zza);
            zzarzVar.zzA(zzavhVar.zzb);
        }
    }
}
