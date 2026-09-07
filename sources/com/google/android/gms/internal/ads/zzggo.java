package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzggo {
    public static final /* synthetic */ int zza = 0;
    private static final zzgna zzb = zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzggm
        @Override // com.google.android.gms.internal.ads.zzgmy
        public final Object zza(zzgdh zzgdhVar) {
            zzggl zzgglVar = (zzggl) zzgdhVar;
            int i = zzggo.zza;
            return zzgjl.zze() ? zzgjl.zzb(zzgglVar) : zzgut.zzb(zzgglVar);
        }
    }, zzggl.class, zzgcy.class);
    private static final zzglx zzc = new zzglx() { // from class: com.google.android.gms.internal.ads.zzggn
        @Override // com.google.android.gms.internal.ads.zzglx
        public final zzgdh zza(zzgdv zzgdvVar, Integer num) {
            int i = zzggo.zza;
            return zzggl.zzc(((zzggq) zzgdvVar).zzb(), zzgvt.zzc(32), num);
        }
    };
    private static final zzgdi zzd = zzgli.zzd("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzgcy.class, zzgsn.SYMMETRIC, zzgry.zzg());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzgko.zza(1)) {
            throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
        }
        int i = zzgjq.zza;
        zzgjq.zze(zzgmi.zzc());
        zzgmf.zza().zzc(zzb);
        zzgly.zzb().zzc(zzc, zzggq.class);
        zzgme zzgmeVarZzb = zzgme.zzb();
        HashMap map = new HashMap();
        map.put("CHACHA20_POLY1305", zzggq.zzc(zzggp.zza));
        map.put("CHACHA20_POLY1305_RAW", zzggq.zzc(zzggp.zzc));
        zzgmeVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgkx.zzc().zzd(zzd, true);
    }
}
