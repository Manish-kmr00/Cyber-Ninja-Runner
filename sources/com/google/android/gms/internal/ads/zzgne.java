package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgne {
    private final Map zza;
    private final Map zzb;

    /* synthetic */ zzgne(zzgnb zzgnbVar, zzgnd zzgndVar) {
        this.zza = new HashMap(zzgnbVar.zza);
        this.zzb = new HashMap(zzgnbVar.zzb);
    }

    public static zzgnb zza() {
        return new zzgnb(null);
    }

    public final Class zzb(Class cls) throws GeneralSecurityException {
        Map map = this.zzb;
        if (map.containsKey(cls)) {
            return ((zzgnk) map.get(cls)).zza();
        }
        throw new GeneralSecurityException("No input primitive class for " + cls.toString() + " available");
    }

    public final Object zzc(zzgdh zzgdhVar, Class cls) throws GeneralSecurityException {
        zzgnc zzgncVar = new zzgnc(zzgdhVar.getClass(), cls, null);
        Map map = this.zza;
        if (map.containsKey(zzgncVar)) {
            return ((zzgna) map.get(zzgncVar)).zza(zzgdhVar);
        }
        throw new GeneralSecurityException("No PrimitiveConstructor for " + zzgncVar.toString() + " available, see https://developers.google.com/tink/faq/registration_errors");
    }

    public final Object zzf(zzgnj zzgnjVar, zzglq zzglqVar, zzgdl zzgdlVar, Class cls) throws GeneralSecurityException {
        Map map = this.zzb;
        if (!map.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
        }
        zzgnk zzgnkVar = (zzgnk) map.get(cls);
        if (zzgnjVar.zzc().equals(zzgnkVar.zza()) && zzgnkVar.zza().equals(zzgnjVar.zzc())) {
            return zzgnkVar.zze(zzgnjVar.zza(), zzglqVar, zzgdlVar);
        }
        throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
    }
}
