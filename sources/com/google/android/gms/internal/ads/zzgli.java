package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgli implements zzgdi {
    final String zza;
    final Class zzb;
    final zzgsn zzc;

    zzgli(String str, Class cls, zzgsn zzgsnVar, zzgzo zzgzoVar) {
        this.zza = str;
        this.zzb = cls;
        this.zzc = zzgsnVar;
    }

    public static zzgdi zzd(String str, Class cls, zzgsn zzgsnVar, zzgzo zzgzoVar) {
        return new zzgli(str, cls, zzgsnVar, zzgzoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdi
    public final zzgsp zza(zzgwn zzgwnVar) throws GeneralSecurityException {
        zzgsr zzgsrVarZza = zzgst.zza();
        zzgsrVarZza.zzb(this.zza);
        zzgsrVarZza.zzc(zzgwnVar);
        zzgsrVarZza.zza(zzgtt.RAW);
        zzgnl zzgnlVar = (zzgnl) zzgmi.zzc().zzd(zzgly.zzb().zza(zzgmi.zzc().zzb(zzgnm.zza((zzgst) zzgsrVarZza.zzbr())), null), zzgnl.class, zzgdg.zza());
        zzgsm zzgsmVarZza = zzgsp.zza();
        zzgsmVarZza.zzb(zzgnlVar.zzg());
        zzgsmVarZza.zzc(zzgnlVar.zze());
        zzgsmVarZza.zza(zzgnlVar.zzb());
        return (zzgsp) zzgsmVarZza.zzbr();
    }

    @Override // com.google.android.gms.internal.ads.zzgdi
    public final Class zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgdi
    public final Object zzc(zzgwn zzgwnVar) throws GeneralSecurityException {
        return zzgmf.zza().zzb(zzgmi.zzc().zza(zzgnl.zza(this.zza, zzgwnVar, this.zzc, zzgtt.RAW, null), zzgdg.zza()), this.zzb);
    }
}
