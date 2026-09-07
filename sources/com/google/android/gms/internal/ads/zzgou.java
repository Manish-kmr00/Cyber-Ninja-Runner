package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgou {
    public static final /* synthetic */ int zza = 0;
    private static final zzgna zzb = zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgoq
        @Override // com.google.android.gms.internal.ads.zzgmy
        public final Object zza(zzgdh zzgdhVar) {
            return new zzgpv((zzgop) zzgdhVar);
        }
    }, zzgop.class, zzgoj.class);
    private static final zzgna zzc = zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgor
        @Override // com.google.android.gms.internal.ads.zzgmy
        public final Object zza(zzgdh zzgdhVar) {
            return zzgvp.zzb((zzgop) zzgdhVar);
        }
    }, zzgop.class, zzgdu.class);
    private static final zzgdi zzd = zzgli.zzd("type.googleapis.com/google.crypto.tink.HmacKey", zzgdu.class, zzgsn.SYMMETRIC, zzgsf.zzi());
    private static final zzglz zze = new zzglz() { // from class: com.google.android.gms.internal.ads.zzgos
    };
    private static final zzglx zzf = new zzglx() { // from class: com.google.android.gms.internal.ads.zzgot
        @Override // com.google.android.gms.internal.ads.zzglx
        public final zzgdh zza(zzgdv zzgdvVar, Integer num) {
            zzgoz zzgozVar = (zzgoz) zzgdvVar;
            int i = zzgou.zza;
            zzgon zzgonVar = new zzgon(null);
            zzgonVar.zzc(zzgozVar);
            zzgonVar.zzb(zzgvt.zzc(zzgozVar.zzc()));
            zzgonVar.zza(num);
            return zzgonVar.zzd();
        }
    };
    private static final int zzg = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzg;
        if (!zzgko.zza(i)) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i2 = zzgqa.zza;
        zzgqa.zze(zzgmi.zzc());
        zzgmf.zza().zzc(zzb);
        zzgmf.zza().zzc(zzc);
        zzgme zzgmeVarZzb = zzgme.zzb();
        HashMap map = new HashMap();
        map.put("HMAC_SHA256_128BITTAG", zzgpn.zza);
        zzgov zzgovVar = new zzgov(null);
        zzgovVar.zzb(32);
        zzgovVar.zzc(16);
        zzgox zzgoxVar = zzgox.zzd;
        zzgovVar.zzd(zzgoxVar);
        zzgow zzgowVar = zzgow.zzc;
        zzgovVar.zza(zzgowVar);
        map.put("HMAC_SHA256_128BITTAG_RAW", zzgovVar.zze());
        zzgov zzgovVar2 = new zzgov(null);
        zzgovVar2.zzb(32);
        zzgovVar2.zzc(32);
        zzgox zzgoxVar2 = zzgox.zza;
        zzgovVar2.zzd(zzgoxVar2);
        zzgovVar2.zza(zzgowVar);
        map.put("HMAC_SHA256_256BITTAG", zzgovVar2.zze());
        zzgov zzgovVar3 = new zzgov(null);
        zzgovVar3.zzb(32);
        zzgovVar3.zzc(32);
        zzgovVar3.zzd(zzgoxVar);
        zzgovVar3.zza(zzgowVar);
        map.put("HMAC_SHA256_256BITTAG_RAW", zzgovVar3.zze());
        zzgov zzgovVar4 = new zzgov(null);
        zzgovVar4.zzb(64);
        zzgovVar4.zzc(16);
        zzgovVar4.zzd(zzgoxVar2);
        zzgow zzgowVar2 = zzgow.zze;
        zzgovVar4.zza(zzgowVar2);
        map.put("HMAC_SHA512_128BITTAG", zzgovVar4.zze());
        zzgov zzgovVar5 = new zzgov(null);
        zzgovVar5.zzb(64);
        zzgovVar5.zzc(16);
        zzgovVar5.zzd(zzgoxVar);
        zzgovVar5.zza(zzgowVar2);
        map.put("HMAC_SHA512_128BITTAG_RAW", zzgovVar5.zze());
        zzgov zzgovVar6 = new zzgov(null);
        zzgovVar6.zzb(64);
        zzgovVar6.zzc(32);
        zzgovVar6.zzd(zzgoxVar2);
        zzgovVar6.zza(zzgowVar2);
        map.put("HMAC_SHA512_256BITTAG", zzgovVar6.zze());
        zzgov zzgovVar7 = new zzgov(null);
        zzgovVar7.zzb(64);
        zzgovVar7.zzc(32);
        zzgovVar7.zzd(zzgoxVar);
        zzgovVar7.zza(zzgowVar2);
        map.put("HMAC_SHA512_256BITTAG_RAW", zzgovVar7.zze());
        map.put("HMAC_SHA512_512BITTAG", zzgpn.zzb);
        zzgov zzgovVar8 = new zzgov(null);
        zzgovVar8.zzb(64);
        zzgovVar8.zzc(64);
        zzgovVar8.zzd(zzgoxVar);
        zzgovVar8.zza(zzgowVar2);
        map.put("HMAC_SHA512_512BITTAG_RAW", zzgovVar8.zze());
        zzgmeVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgly.zzb().zzc(zzf, zzgoz.class);
        zzgma.zza().zzb(zze, zzgoz.class);
        zzgkx.zzc().zzf(zzd, i, true);
    }
}
