package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgfk {
    public static final /* synthetic */ int zza = 0;
    private static final zzgna zzb = zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgfi
        @Override // com.google.android.gms.internal.ads.zzgmy
        public final Object zza(zzgdh zzgdhVar) {
            return zzguq.zzb((zzgfh) zzgdhVar);
        }
    }, zzgfh.class, zzgcy.class);
    private static final zzgdi zzc = zzgli.zzd("type.googleapis.com/google.crypto.tink.AesEaxKey", zzgcy.class, zzgsn.SYMMETRIC, zzgrd.zzh());
    private static final zzglx zzd = new zzglx() { // from class: com.google.android.gms.internal.ads.zzgfj
        @Override // com.google.android.gms.internal.ads.zzglx
        public final zzgdh zza(zzgdv zzgdvVar, Integer num) throws GeneralSecurityException {
            zzgfo zzgfoVar = (zzgfo) zzgdvVar;
            int i = zzgfk.zza;
            if (zzgfoVar.zzc() == 24) {
                throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
            }
            zzgff zzgffVar = new zzgff(null);
            zzgffVar.zzc(zzgfoVar);
            zzgffVar.zza(num);
            zzgffVar.zzb(zzgvt.zzc(zzgfoVar.zzc()));
            return zzgffVar.zzd();
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzgko.zza(1)) {
            throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
        }
        int i = zzgix.zza;
        zzgix.zze(zzgmi.zzc());
        zzgmf.zza().zzc(zzb);
        zzgme zzgmeVarZzb = zzgme.zzb();
        HashMap map = new HashMap();
        map.put("AES128_EAX", zzgia.zzc);
        zzgfl zzgflVar = new zzgfl(null);
        zzgflVar.zza(16);
        zzgflVar.zzb(16);
        zzgflVar.zzc(16);
        zzgfm zzgfmVar = zzgfm.zzc;
        zzgflVar.zzd(zzgfmVar);
        map.put("AES128_EAX_RAW", zzgflVar.zze());
        map.put("AES256_EAX", zzgia.zzd);
        zzgfl zzgflVar2 = new zzgfl(null);
        zzgflVar2.zza(16);
        zzgflVar2.zzb(32);
        zzgflVar2.zzc(16);
        zzgflVar2.zzd(zzgfmVar);
        map.put("AES256_EAX_RAW", zzgflVar2.zze());
        zzgmeVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgly.zzb().zzc(zzd, zzgfo.class);
        zzgkx.zzc().zzd(zzc, true);
    }
}
