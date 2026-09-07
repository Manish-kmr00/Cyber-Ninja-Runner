package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgje {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvs zzb;
    private static final zzgmr zzc;
    private static final zzgmn zzd;
    private static final zzglf zze;
    private static final zzglb zzf;

    static {
        zzgvs zzgvsVarZzb = zzgnx.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zzgvsVarZzb;
        zzc = zzgmr.zzb(new zzgmp() { // from class: com.google.android.gms.internal.ads.zzgja
            @Override // com.google.android.gms.internal.ads.zzgmp
            public final zzgnp zza(zzgdv zzgdvVar) {
                return zzgje.zzd((zzgfz) zzgdvVar);
            }
        }, zzgfz.class, zzgnm.class);
        zzd = zzgmn.zzb(new zzgml() { // from class: com.google.android.gms.internal.ads.zzgjb
            @Override // com.google.android.gms.internal.ads.zzgml
            public final zzgdv zza(zzgnp zzgnpVar) {
                return zzgje.zzb((zzgnm) zzgnpVar);
            }
        }, zzgvsVarZzb, zzgnm.class);
        zze = zzglf.zzb(new zzgld() { // from class: com.google.android.gms.internal.ads.zzgjc
            @Override // com.google.android.gms.internal.ads.zzgld
            public final zzgnp zza(zzgdh zzgdhVar, zzgdz zzgdzVar) {
                return zzgje.zzc((zzgfr) zzgdhVar, zzgdzVar);
            }
        }, zzgfr.class, zzgnl.class);
        zzf = zzglb.zzb(new zzgkz() { // from class: com.google.android.gms.internal.ads.zzgjd
            @Override // com.google.android.gms.internal.ads.zzgkz
            public final zzgdh zza(zzgnp zzgnpVar, zzgdz zzgdzVar) {
                return zzgje.zza((zzgnl) zzgnpVar, zzgdzVar);
            }
        }, zzgvsVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzgfr zza(zzgnl zzgnlVar, zzgdz zzgdzVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
        try {
            zzgrm zzgrmVarZzd = zzgrm.zzd(zzgnlVar.zze(), zzgxf.zza());
            if (zzgrmVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgfw zzgfwVarZzc = zzgfz.zzc();
            zzgfwVarZzc.zzb(zzgrmVarZzd.zzf().zzd());
            zzgfwVarZzc.zza(12);
            zzgfwVarZzc.zzc(16);
            zzgfwVarZzc.zzd(zzf(zzgnlVar.zzc()));
            zzgfz zzgfzVarZze = zzgfwVarZzc.zze();
            zzgfp zzgfpVarZzc = zzgfr.zzc();
            zzgfpVarZzc.zzc(zzgfzVarZze);
            zzgfpVarZzc.zzb(zzgvt.zzb(zzgrmVarZzd.zzf().zzA(), zzgdzVar));
            zzgfpVarZzc.zza(zzgnlVar.zzf());
            return zzgfpVarZzc.zzd();
        } catch (zzgyk unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }

    public static /* synthetic */ zzgfz zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgrp zzgrpVarZzf = zzgrp.zzf(zzgnmVar.zzc().zzh(), zzgxf.zza());
            if (zzgrpVarZzf.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzgfw zzgfwVarZzc = zzgfz.zzc();
            zzgfwVarZzc.zzb(zzgrpVarZzf.zza());
            zzgfwVarZzc.zza(12);
            zzgfwVarZzc.zzc(16);
            zzgfwVarZzc.zzd(zzf(zzgnmVar.zzc().zzg()));
            return zzgfwVarZzc.zze();
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzgfr zzgfrVar, zzgdz zzgdzVar) {
        zzgrk zzgrkVarZzb = zzgrm.zzb();
        byte[] bArrZzd = zzgfrVar.zze().zzd(zzgdzVar);
        zzgrkVarZzb.zza(zzgwn.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzgrm) zzgrkVarZzb.zzbr()).zzaN(), zzgsn.SYMMETRIC, zzg(zzgfrVar.zzd().zzd()), zzgfrVar.zzf());
    }

    public static /* synthetic */ zzgnm zzd(zzgfz zzgfzVar) {
        zzgsr zzgsrVarZza = zzgst.zza();
        zzgsrVarZza.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzgrn zzgrnVarZzc = zzgrp.zzc();
        zzgrnVarZzc.zza(zzgfzVar.zzb());
        zzgsrVarZza.zzc(((zzgrp) zzgrnVarZzc.zzbr()).zzaN());
        zzgsrVarZza.zza(zzg(zzgfzVar.zzd()));
        return zzgnm.zzb((zzgst) zzgsrVarZza.zzbr());
    }

    public static void zze(zzgmi zzgmiVar) throws GeneralSecurityException {
        zzgmiVar.zzi(zzc);
        zzgmiVar.zzh(zzd);
        zzgmiVar.zzg(zze);
        zzgmiVar.zzf(zzf);
    }

    private static zzgfx zzf(zzgtt zzgttVar) throws GeneralSecurityException {
        int iOrdinal = zzgttVar.ordinal();
        if (iOrdinal == 1) {
            return zzgfx.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgfx.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgttVar.zza());
            }
        }
        return zzgfx.zzb;
    }

    private static zzgtt zzg(zzgfx zzgfxVar) throws GeneralSecurityException {
        if (zzgfx.zza.equals(zzgfxVar)) {
            return zzgtt.TINK;
        }
        if (zzgfx.zzb.equals(zzgfxVar)) {
            return zzgtt.CRUNCHY;
        }
        if (zzgfx.zzc.equals(zzgfxVar)) {
            return zzgtt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgfxVar))));
    }
}
