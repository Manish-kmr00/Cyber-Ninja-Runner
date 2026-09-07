package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgly {
    public static final /* synthetic */ int zza = 0;
    private static final zzglx zzb = new zzglx() { // from class: com.google.android.gms.internal.ads.zzglw
        @Override // com.google.android.gms.internal.ads.zzglx
        public final zzgdh zza(zzgdv zzgdvVar, Integer num) throws GeneralSecurityException {
            int i = zzgly.zza;
            zzgst zzgstVarZzc = ((zzgln) zzgdvVar).zzb().zzc();
            zzgdi zzgdiVarZzb = zzgkx.zzc().zzb(zzgstVarZzc.zzi());
            if (!zzgkx.zzc().zze(zzgstVarZzc.zzi())) {
                throw new GeneralSecurityException("Creating new keys is not allowed.");
            }
            zzgsp zzgspVarZza = zzgdiVarZzb.zza(zzgstVarZzc.zzh());
            return new zzglm(zzgnl.zza(zzgspVarZza.zzg(), zzgspVarZza.zzf(), zzgspVarZza.zzb(), zzgstVarZzc.zzg(), num), zzgdg.zza());
        }
    };
    private static final zzgly zzc = zze();
    private final Map zzd = new HashMap();

    public static zzgly zzb() {
        return zzc;
    }

    private final synchronized zzgdh zzd(zzgdv zzgdvVar, @Nullable Integer num) throws GeneralSecurityException {
        zzglx zzglxVar;
        zzglxVar = (zzglx) this.zzd.get(zzgdvVar.getClass());
        if (zzglxVar == null) {
            throw new GeneralSecurityException("Cannot create a new key for parameters " + zzgdvVar.toString() + ": no key creator for this class was registered.");
        }
        return zzglxVar.zza(zzgdvVar, num);
    }

    private static zzgly zze() {
        zzgly zzglyVar = new zzgly();
        try {
            zzglyVar.zzc(zzb, zzgln.class);
            return zzglyVar;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("unexpected error.", e);
        }
    }

    public final zzgdh zza(zzgdv zzgdvVar, @Nullable Integer num) throws GeneralSecurityException {
        return zzd(zzgdvVar, num);
    }

    public final synchronized void zzc(zzglx zzglxVar, Class cls) throws GeneralSecurityException {
        Map map = this.zzd;
        zzglx zzglxVar2 = (zzglx) map.get(cls);
        if (zzglxVar2 != null && !zzglxVar2.equals(zzglxVar)) {
            throw new GeneralSecurityException("Different key creator for parameters class " + cls.toString() + " already inserted");
        }
        map.put(cls, zzglxVar);
    }
}
