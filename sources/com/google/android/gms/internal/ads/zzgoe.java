package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgoe {
    private static final zzglx zza = new zzglx() { // from class: com.google.android.gms.internal.ads.zzgob
        @Override // com.google.android.gms.internal.ads.zzglx
        public final zzgdh zza(zzgdv zzgdvVar, Integer num) {
            return zzgoe.zzb((zzgoi) zzgdvVar, num);
        }
    };
    private static final zzgna zzb = zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgoc
        @Override // com.google.android.gms.internal.ads.zzgmy
        public final Object zza(zzgdh zzgdhVar) {
            return zzgoe.zzc((zzgoa) zzgdhVar);
        }
    }, zzgoa.class, zzgoj.class);
    private static final zzgna zzc = zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgod
        @Override // com.google.android.gms.internal.ads.zzgmy
        public final Object zza(zzgdh zzgdhVar) {
            return zzgoe.zza((zzgoa) zzgdhVar);
        }
    }, zzgoa.class, zzgdu.class);
    private static final zzgdi zzd = zzgli.zzd("type.googleapis.com/google.crypto.tink.AesCmacKey", zzgdu.class, zzgsn.SYMMETRIC, zzgqf.zzh());

    public static /* synthetic */ zzgdu zza(zzgoa zzgoaVar) throws GeneralSecurityException {
        zze(zzgoaVar.zzc());
        return zzgvp.zza(zzgoaVar);
    }

    public static /* synthetic */ zzgoa zzb(zzgoi zzgoiVar, Integer num) throws GeneralSecurityException {
        zze(zzgoiVar);
        zzgny zzgnyVar = new zzgny(null);
        zzgnyVar.zzc(zzgoiVar);
        zzgnyVar.zza(zzgvt.zzc(zzgoiVar.zzc()));
        zzgnyVar.zzb(num);
        return zzgnyVar.zzd();
    }

    public static /* synthetic */ zzgoj zzc(zzgoa zzgoaVar) throws GeneralSecurityException {
        zze(zzgoaVar.zzc());
        return new zzgpu(zzgoaVar);
    }

    public static void zzd(boolean z) throws GeneralSecurityException {
        if (!zzgko.zza(1)) {
            throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
        }
        int i = zzgps.zza;
        zzgps.zze(zzgmi.zzc());
        zzgly.zzb().zzc(zza, zzgoi.class);
        zzgmf.zza().zzc(zzb);
        zzgmf.zza().zzc(zzc);
        zzgme zzgmeVarZzb = zzgme.zzb();
        HashMap map = new HashMap();
        map.put("AES_CMAC", zzgpn.zzc);
        map.put("AES256_CMAC", zzgpn.zzc);
        zzgof zzgofVar = new zzgof(null);
        zzgofVar.zza(32);
        zzgofVar.zzb(16);
        zzgofVar.zzc(zzgog.zzd);
        map.put("AES256_CMAC_RAW", zzgofVar.zzd());
        zzgmeVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgkx.zzc().zzd(zzd, true);
    }

    private static void zze(zzgoi zzgoiVar) throws GeneralSecurityException {
        if (zzgoiVar.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
