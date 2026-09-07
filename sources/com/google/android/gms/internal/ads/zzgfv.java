package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgfv {
    public static final /* synthetic */ int zza = 0;
    private static final zzgna zzb = zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgfs
        @Override // com.google.android.gms.internal.ads.zzgmy
        public final Object zza(zzgdh zzgdhVar) {
            return zzgur.zzb((zzgfr) zzgdhVar);
        }
    }, zzgfr.class, zzgcy.class);
    private static final zzgdi zzc = zzgli.zzd("type.googleapis.com/google.crypto.tink.AesGcmKey", zzgcy.class, zzgsn.SYMMETRIC, zzgrm.zzg());
    private static final zzglz zzd = new zzglz() { // from class: com.google.android.gms.internal.ads.zzgft
    };
    private static final zzglx zze = new zzglx() { // from class: com.google.android.gms.internal.ads.zzgfu
        @Override // com.google.android.gms.internal.ads.zzglx
        public final zzgdh zza(zzgdv zzgdvVar, Integer num) throws GeneralSecurityException {
            zzgfz zzgfzVar = (zzgfz) zzgdvVar;
            int i = zzgfv.zza;
            if (zzgfzVar.zzb() == 24) {
                throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
            }
            zzgfp zzgfpVar = new zzgfp(null);
            zzgfpVar.zzc(zzgfzVar);
            zzgfpVar.zza(num);
            zzgfpVar.zzb(zzgvt.zzc(zzgfzVar.zzb()));
            return zzgfpVar.zzd();
        }
    };
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (!zzgko.zza(i)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i2 = zzgje.zza;
        zzgje.zze(zzgmi.zzc());
        zzgmf.zza().zzc(zzb);
        zzgme zzgmeVarZzb = zzgme.zzb();
        HashMap map = new HashMap();
        map.put("AES128_GCM", zzgia.zza);
        zzgfw zzgfwVar = new zzgfw(null);
        zzgfwVar.zza(12);
        zzgfwVar.zzb(16);
        zzgfwVar.zzc(16);
        zzgfx zzgfxVar = zzgfx.zzc;
        zzgfwVar.zzd(zzgfxVar);
        map.put("AES128_GCM_RAW", zzgfwVar.zze());
        map.put("AES256_GCM", zzgia.zzb);
        zzgfw zzgfwVar2 = new zzgfw(null);
        zzgfwVar2.zza(12);
        zzgfwVar2.zzb(32);
        zzgfwVar2.zzc(16);
        zzgfwVar2.zzd(zzgfxVar);
        map.put("AES256_GCM_RAW", zzgfwVar2.zze());
        zzgmeVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgma.zza().zzb(zzd, zzgfz.class);
        zzgly.zzb().zzc(zze, zzgfz.class);
        zzgkx.zzc().zzf(zzc, i, true);
    }
}
