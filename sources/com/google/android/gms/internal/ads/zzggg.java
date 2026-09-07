package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzggg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgna zzb = zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzggd
        @Override // com.google.android.gms.internal.ads.zzgmy
        public final Object zza(zzgdh zzgdhVar) {
            return zzgkn.zzb((zzggc) zzgdhVar);
        }
    }, zzggc.class, zzgcy.class);
    private static final zzglx zzc = new zzglx() { // from class: com.google.android.gms.internal.ads.zzgge
        @Override // com.google.android.gms.internal.ads.zzglx
        public final zzgdh zza(zzgdv zzgdvVar, Integer num) {
            zzggk zzggkVar = (zzggk) zzgdvVar;
            int i = zzggg.zza;
            zzgga zzggaVar = new zzgga(null);
            zzggaVar.zzc(zzggkVar);
            zzggaVar.zza(num);
            zzggaVar.zzb(zzgvt.zzc(zzggkVar.zzb()));
            return zzggaVar.zzd();
        }
    };
    private static final zzglz zzd = new zzglz() { // from class: com.google.android.gms.internal.ads.zzggf
    };
    private static final zzgdi zze = zzgli.zzd("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzgcy.class, zzgsn.SYMMETRIC, zzgrs.zzg());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzgko.zza(1)) {
            throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
        }
        int i = zzgjj.zza;
        zzgjj.zze(zzgmi.zzc());
        if (zzb()) {
            zzgmf.zza().zzc(zzb);
            zzgme zzgmeVarZzb = zzgme.zzb();
            HashMap map = new HashMap();
            zzggh zzgghVar = new zzggh(null);
            zzgghVar.zza(16);
            zzggi zzggiVar = zzggi.zza;
            zzgghVar.zzb(zzggiVar);
            map.put("AES128_GCM_SIV", zzgghVar.zzc());
            zzggh zzgghVar2 = new zzggh(null);
            zzgghVar2.zza(16);
            zzggi zzggiVar2 = zzggi.zzc;
            zzgghVar2.zzb(zzggiVar2);
            map.put("AES128_GCM_SIV_RAW", zzgghVar2.zzc());
            zzggh zzgghVar3 = new zzggh(null);
            zzgghVar3.zza(32);
            zzgghVar3.zzb(zzggiVar);
            map.put("AES256_GCM_SIV", zzgghVar3.zzc());
            zzggh zzgghVar4 = new zzggh(null);
            zzgghVar4.zza(32);
            zzgghVar4.zzb(zzggiVar2);
            map.put("AES256_GCM_SIV_RAW", zzgghVar4.zzc());
            zzgmeVarZzb.zzd(Collections.unmodifiableMap(map));
            zzgma.zza().zzb(zzd, zzggk.class);
            zzgly.zzb().zzc(zzc, zzggk.class);
            zzgkx.zzc().zzd(zze, true);
        }
    }

    private static boolean zzb() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }
}
