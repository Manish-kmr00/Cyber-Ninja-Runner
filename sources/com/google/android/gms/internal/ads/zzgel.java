package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgel {
    public static final /* synthetic */ int zza = 0;
    private static final zzgkw zzb = zzb();

    public static zzgdc zza() throws GeneralSecurityException {
        if (zzgkp.zzb()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant AeadConfigurationV0 in FIPS mode");
        }
        return zzb;
    }

    private static zzgkw zzb() {
        try {
            zzgnb zzgnbVarZza = zzgne.zza();
            zzges.zzd(zzgnbVarZza);
            zzgnbVarZza.zza(zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgee
                @Override // com.google.android.gms.internal.ads.zzgmy
                public final Object zza(zzgdh zzgdhVar) {
                    return zzguu.zzb((zzgev) zzgdhVar);
                }
            }, zzgev.class, zzgcy.class));
            zzgnbVarZza.zza(zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgef
                @Override // com.google.android.gms.internal.ads.zzgmy
                public final Object zza(zzgdh zzgdhVar) {
                    return zzgur.zzb((zzgfr) zzgdhVar);
                }
            }, zzgfr.class, zzgcy.class));
            zzgnbVarZza.zza(zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgeg
                @Override // com.google.android.gms.internal.ads.zzgmy
                public final Object zza(zzgdh zzgdhVar) {
                    return zzgkn.zzb((zzggc) zzgdhVar);
                }
            }, zzggc.class, zzgcy.class));
            zzgnbVarZza.zza(zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgeh
                @Override // com.google.android.gms.internal.ads.zzgmy
                public final Object zza(zzgdh zzgdhVar) {
                    return zzguq.zzb((zzgfh) zzgdhVar);
                }
            }, zzgfh.class, zzgcy.class));
            zzgnbVarZza.zza(zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgei
                @Override // com.google.android.gms.internal.ads.zzgmy
                public final Object zza(zzgdh zzgdhVar) {
                    zzggl zzgglVar = (zzggl) zzgdhVar;
                    int i = zzgel.zza;
                    return zzgjl.zze() ? zzgjl.zzb(zzgglVar) : zzgut.zzb(zzgglVar);
                }
            }, zzggl.class, zzgcy.class));
            zzgnbVarZza.zza(zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgej
                @Override // com.google.android.gms.internal.ads.zzgmy
                public final Object zza(zzgdh zzgdhVar) {
                    zzgih zzgihVar = (zzgih) zzgdhVar;
                    int i = zzgel.zza;
                    return zzgkg.zzc() ? zzgkg.zzb(zzgihVar) : zzgvr.zzb(zzgihVar);
                }
            }, zzgih.class, zzgcy.class));
            zzgnbVarZza.zza(zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgek
                @Override // com.google.android.gms.internal.ads.zzgmy
                public final Object zza(zzgdh zzgdhVar) {
                    return zzgka.zzb((zzgib) zzgdhVar);
                }
            }, zzgib.class, zzgcy.class));
            return zzgkw.zzd(zzgnbVarZza.zzc());
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
