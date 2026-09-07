package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgil {
    public static final /* synthetic */ int zza = 0;
    private static final zzgna zzb = zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgii
        @Override // com.google.android.gms.internal.ads.zzgmy
        public final Object zza(zzgdh zzgdhVar) {
            zzgih zzgihVar = (zzgih) zzgdhVar;
            int i = zzgil.zza;
            return zzgkg.zzc() ? zzgkg.zzb(zzgihVar) : zzgvr.zzb(zzgihVar);
        }
    }, zzgih.class, zzgcy.class);
    private static final zzgdi zzc = zzgli.zzd("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzgcy.class, zzgsn.SYMMETRIC, zzgui.zzg());
    private static final zzglz zzd = new zzglz() { // from class: com.google.android.gms.internal.ads.zzgij
    };
    private static final zzglx zze = new zzglx() { // from class: com.google.android.gms.internal.ads.zzgik
        @Override // com.google.android.gms.internal.ads.zzglx
        public final zzgdh zza(zzgdv zzgdvVar, Integer num) {
            int i = zzgil.zza;
            return zzgih.zzc(((zzgin) zzgdvVar).zzb(), zzgvt.zzc(32), num);
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzgko.zza(1)) {
            throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
        }
        int i = zzgkl.zza;
        zzgkl.zze(zzgmi.zzc());
        zzgmf.zza().zzc(zzb);
        zzgme zzgmeVarZzb = zzgme.zzb();
        HashMap map = new HashMap();
        map.put("XCHACHA20_POLY1305", zzgin.zzc(zzgim.zza));
        map.put("XCHACHA20_POLY1305_RAW", zzgin.zzc(zzgim.zzc));
        zzgmeVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgly.zzb().zzc(zze, zzgin.class);
        zzgma.zza().zzb(zzd, zzgin.class);
        zzgkx.zzc().zzd(zzc, true);
    }
}
