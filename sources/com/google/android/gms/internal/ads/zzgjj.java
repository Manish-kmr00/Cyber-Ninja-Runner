package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgjj {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvs zzb;
    private static final zzgmr zzc;
    private static final zzgmn zzd;
    private static final zzglf zze;
    private static final zzglb zzf;

    static {
        zzgvs zzgvsVarZzb = zzgnx.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zzgvsVarZzb;
        zzc = zzgmr.zzb(new zzgmp() { // from class: com.google.android.gms.internal.ads.zzgjf
            @Override // com.google.android.gms.internal.ads.zzgmp
            public final zzgnp zza(zzgdv zzgdvVar) {
                return zzgjj.zzd((zzggk) zzgdvVar);
            }
        }, zzggk.class, zzgnm.class);
        zzd = zzgmn.zzb(new zzgml() { // from class: com.google.android.gms.internal.ads.zzgjg
            @Override // com.google.android.gms.internal.ads.zzgml
            public final zzgdv zza(zzgnp zzgnpVar) {
                return zzgjj.zzb((zzgnm) zzgnpVar);
            }
        }, zzgvsVarZzb, zzgnm.class);
        zze = zzglf.zzb(new zzgld() { // from class: com.google.android.gms.internal.ads.zzgjh
            @Override // com.google.android.gms.internal.ads.zzgld
            public final zzgnp zza(zzgdh zzgdhVar, zzgdz zzgdzVar) {
                return zzgjj.zzc((zzggc) zzgdhVar, zzgdzVar);
            }
        }, zzggc.class, zzgnl.class);
        zzf = zzglb.zzb(new zzgkz() { // from class: com.google.android.gms.internal.ads.zzgji
            @Override // com.google.android.gms.internal.ads.zzgkz
            public final zzgdh zza(zzgnp zzgnpVar, zzgdz zzgdzVar) {
                return zzgjj.zza((zzgnl) zzgnpVar, zzgdzVar);
            }
        }, zzgvsVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzggc zza(zzgnl zzgnlVar, zzgdz zzgdzVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
        try {
            zzgrs zzgrsVarZzd = zzgrs.zzd(zzgnlVar.zze(), zzgxf.zza());
            if (zzgrsVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzggh zzgghVarZzc = zzggk.zzc();
            zzgghVarZzc.zza(zzgrsVarZzd.zzf().zzd());
            zzgghVarZzc.zzb(zzf(zzgnlVar.zzc()));
            zzggk zzggkVarZzc = zzgghVarZzc.zzc();
            zzgga zzggaVarZzc = zzggc.zzc();
            zzggaVarZzc.zzc(zzggkVarZzc);
            zzggaVarZzc.zzb(zzgvt.zzb(zzgrsVarZzd.zzf().zzA(), zzgdzVar));
            zzggaVarZzc.zza(zzgnlVar.zzf());
            return zzggaVarZzc.zzd();
        } catch (zzgyk unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }

    public static /* synthetic */ zzggk zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgrv zzgrvVarZzf = zzgrv.zzf(zzgnmVar.zzc().zzh(), zzgxf.zza());
            if (zzgrvVarZzf.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzggh zzgghVarZzc = zzggk.zzc();
            zzgghVarZzc.zza(zzgrvVarZzf.zza());
            zzgghVarZzc.zzb(zzf(zzgnmVar.zzc().zzg()));
            return zzgghVarZzc.zzc();
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzggc zzggcVar, zzgdz zzgdzVar) {
        zzgrq zzgrqVarZzb = zzgrs.zzb();
        byte[] bArrZzd = zzggcVar.zze().zzd(zzgdzVar);
        zzgrqVarZzb.zza(zzgwn.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzgrs) zzgrqVarZzb.zzbr()).zzaN(), zzgsn.SYMMETRIC, zzg(zzggcVar.zzd().zzd()), zzggcVar.zzf());
    }

    public static /* synthetic */ zzgnm zzd(zzggk zzggkVar) {
        zzgsr zzgsrVarZza = zzgst.zza();
        zzgsrVarZza.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzgrt zzgrtVarZzc = zzgrv.zzc();
        zzgrtVarZzc.zza(zzggkVar.zzb());
        zzgsrVarZza.zzc(((zzgrv) zzgrtVarZzc.zzbr()).zzaN());
        zzgsrVarZza.zza(zzg(zzggkVar.zzd()));
        return zzgnm.zzb((zzgst) zzgsrVarZza.zzbr());
    }

    public static void zze(zzgmi zzgmiVar) throws GeneralSecurityException {
        zzgmiVar.zzi(zzc);
        zzgmiVar.zzh(zzd);
        zzgmiVar.zzg(zze);
        zzgmiVar.zzf(zzf);
    }

    private static zzggi zzf(zzgtt zzgttVar) throws GeneralSecurityException {
        int iOrdinal = zzgttVar.ordinal();
        if (iOrdinal == 1) {
            return zzggi.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzggi.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgttVar.zza());
            }
        }
        return zzggi.zzb;
    }

    private static zzgtt zzg(zzggi zzggiVar) throws GeneralSecurityException {
        if (zzggi.zza.equals(zzggiVar)) {
            return zzgtt.TINK;
        }
        if (zzggi.zzb.equals(zzggiVar)) {
            return zzgtt.CRUNCHY;
        }
        if (zzggi.zzc.equals(zzggiVar)) {
            return zzgtt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzggiVar))));
    }
}
