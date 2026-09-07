package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgis {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvs zzb;
    private static final zzgmr zzc;
    private static final zzgmn zzd;
    private static final zzglf zze;
    private static final zzglb zzf;

    static {
        zzgvs zzgvsVarZzb = zzgnx.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zzgvsVarZzb;
        zzc = zzgmr.zzb(new zzgmp() { // from class: com.google.android.gms.internal.ads.zzgio
            @Override // com.google.android.gms.internal.ads.zzgmp
            public final zzgnp zza(zzgdv zzgdvVar) {
                return zzgis.zzd((zzgfe) zzgdvVar);
            }
        }, zzgfe.class, zzgnm.class);
        zzd = zzgmn.zzb(new zzgml() { // from class: com.google.android.gms.internal.ads.zzgip
            @Override // com.google.android.gms.internal.ads.zzgml
            public final zzgdv zza(zzgnp zzgnpVar) {
                return zzgis.zzb((zzgnm) zzgnpVar);
            }
        }, zzgvsVarZzb, zzgnm.class);
        zze = zzglf.zzb(new zzgld() { // from class: com.google.android.gms.internal.ads.zzgiq
            @Override // com.google.android.gms.internal.ads.zzgld
            public final zzgnp zza(zzgdh zzgdhVar, zzgdz zzgdzVar) {
                return zzgis.zzc((zzgev) zzgdhVar, zzgdzVar);
            }
        }, zzgev.class, zzgnl.class);
        zzf = zzglb.zzb(new zzgkz() { // from class: com.google.android.gms.internal.ads.zzgir
            @Override // com.google.android.gms.internal.ads.zzgkz
            public final zzgdh zza(zzgnp zzgnpVar, zzgdz zzgdzVar) {
                return zzgis.zza((zzgnl) zzgnpVar, zzgdzVar);
            }
        }, zzgvsVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzgev zza(zzgnl zzgnlVar, zzgdz zzgdzVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
        try {
            zzgqo zzgqoVarZzd = zzgqo.zzd(zzgnlVar.zze(), zzgxf.zza());
            if (zzgqoVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzgqoVarZzd.zzf().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
            }
            if (zzgqoVarZzd.zzg().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
            }
            zzgfa zzgfaVarZzf = zzgfe.zzf();
            zzgfaVarZzf.zza(zzgqoVarZzd.zzf().zzg().zzd());
            zzgfaVarZzf.zzc(zzgqoVarZzd.zzg().zzh().zzd());
            zzgfaVarZzf.zzd(zzgqoVarZzd.zzf().zzf().zza());
            zzgfaVarZzf.zze(zzgqoVarZzd.zzg().zzg().zza());
            zzgfaVarZzf.zzb(zzf(zzgqoVarZzd.zzg().zzg().zzb()));
            zzgfaVarZzf.zzf(zzg(zzgnlVar.zzc()));
            zzgfe zzgfeVarZzg = zzgfaVarZzf.zzg();
            zzget zzgetVarZzc = zzgev.zzc();
            zzgetVarZzc.zzd(zzgfeVarZzg);
            zzgetVarZzc.zza(zzgvt.zzb(zzgqoVarZzd.zzf().zzg().zzA(), zzgdzVar));
            zzgetVarZzc.zzb(zzgvt.zzb(zzgqoVarZzd.zzg().zzh().zzA(), zzgdzVar));
            zzgetVarZzc.zzc(zzgnlVar.zzf());
            return zzgetVarZzc.zze();
        } catch (zzgyk unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
        }
    }

    public static /* synthetic */ zzgfe zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgqr zzgqrVarZzc = zzgqr.zzc(zzgnmVar.zzc().zzh(), zzgxf.zza());
            if (zzgqrVarZzc.zzf().zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgfa zzgfaVarZzf = zzgfe.zzf();
            zzgfaVarZzf.zza(zzgqrVarZzc.zzd().zza());
            zzgfaVarZzf.zzc(zzgqrVarZzc.zzf().zza());
            zzgfaVarZzf.zzd(zzgqrVarZzc.zzd().zzf().zza());
            zzgfaVarZzf.zze(zzgqrVarZzc.zzf().zzh().zza());
            zzgfaVarZzf.zzb(zzf(zzgqrVarZzc.zzf().zzh().zzb()));
            zzgfaVarZzf.zzf(zzg(zzgnmVar.zzc().zzg()));
            return zzgfaVarZzf.zzg();
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzgev zzgevVar, zzgdz zzgdzVar) {
        zzgqm zzgqmVarZzb = zzgqo.zzb();
        zzgqs zzgqsVarZzb = zzgqu.zzb();
        zzgqy zzgqyVarZzb = zzgra.zzb();
        zzgqyVarZzb.zza(zzgevVar.zzd().zzd());
        zzgqsVarZzb.zzb((zzgra) zzgqyVarZzb.zzbr());
        byte[] bArrZzd = zzgevVar.zze().zzd(zzgdzVar);
        zzgqsVarZzb.zza(zzgwn.zzv(bArrZzd, 0, bArrZzd.length));
        zzgqmVarZzb.zza((zzgqu) zzgqsVarZzb.zzbr());
        zzgsd zzgsdVarZzb = zzgsf.zzb();
        zzgsdVarZzb.zzb(zzh(zzgevVar.zzd()));
        byte[] bArrZzd2 = zzgevVar.zzf().zzd(zzgdzVar);
        zzgsdVarZzb.zza(zzgwn.zzv(bArrZzd2, 0, bArrZzd2.length));
        zzgqmVarZzb.zzb((zzgsf) zzgsdVarZzb.zzbr());
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzgqo) zzgqmVarZzb.zzbr()).zzaN(), zzgsn.SYMMETRIC, zzi(zzgevVar.zzd().zzh()), zzgevVar.zzg());
    }

    public static /* synthetic */ zzgnm zzd(zzgfe zzgfeVar) {
        zzgsr zzgsrVarZza = zzgst.zza();
        zzgsrVarZza.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzgqp zzgqpVarZza = zzgqr.zza();
        zzgqv zzgqvVarZzb = zzgqx.zzb();
        zzgqy zzgqyVarZzb = zzgra.zzb();
        zzgqyVarZzb.zza(zzgfeVar.zzd());
        zzgqvVarZzb.zzb((zzgra) zzgqyVarZzb.zzbr());
        zzgqvVarZzb.zza(zzgfeVar.zzb());
        zzgqpVarZza.zza((zzgqx) zzgqvVarZzb.zzbr());
        zzgsg zzgsgVarZzc = zzgsi.zzc();
        zzgsgVarZzc.zzb(zzh(zzgfeVar));
        zzgsgVarZzc.zza(zzgfeVar.zzc());
        zzgqpVarZza.zzb((zzgsi) zzgsgVarZzc.zzbr());
        zzgsrVarZza.zzc(((zzgqr) zzgqpVarZza.zzbr()).zzaN());
        zzgsrVarZza.zza(zzi(zzgfeVar.zzh()));
        return zzgnm.zzb((zzgst) zzgsrVarZza.zzbr());
    }

    public static void zze(zzgmi zzgmiVar) throws GeneralSecurityException {
        zzgmiVar.zzi(zzc);
        zzgmiVar.zzh(zzd);
        zzgmiVar.zzg(zze);
        zzgmiVar.zzf(zzf);
    }

    private static zzgfb zzf(zzgsc zzgscVar) throws GeneralSecurityException {
        int iOrdinal = zzgscVar.ordinal();
        if (iOrdinal == 1) {
            return zzgfb.zza;
        }
        if (iOrdinal == 2) {
            return zzgfb.zzd;
        }
        if (iOrdinal == 3) {
            return zzgfb.zzc;
        }
        if (iOrdinal == 4) {
            return zzgfb.zze;
        }
        if (iOrdinal == 5) {
            return zzgfb.zzb;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + zzgscVar.zza());
    }

    private static zzgfc zzg(zzgtt zzgttVar) throws GeneralSecurityException {
        int iOrdinal = zzgttVar.ordinal();
        if (iOrdinal == 1) {
            return zzgfc.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgfc.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgttVar.zza());
            }
        }
        return zzgfc.zzb;
    }

    private static zzgsl zzh(zzgfe zzgfeVar) throws GeneralSecurityException {
        zzgsc zzgscVar;
        zzgsj zzgsjVarZzc = zzgsl.zzc();
        zzgsjVarZzc.zzb(zzgfeVar.zze());
        zzgfb zzgfbVarZzg = zzgfeVar.zzg();
        if (zzgfb.zza.equals(zzgfbVarZzg)) {
            zzgscVar = zzgsc.SHA1;
        } else if (zzgfb.zzb.equals(zzgfbVarZzg)) {
            zzgscVar = zzgsc.SHA224;
        } else if (zzgfb.zzc.equals(zzgfbVarZzg)) {
            zzgscVar = zzgsc.SHA256;
        } else if (zzgfb.zzd.equals(zzgfbVarZzg)) {
            zzgscVar = zzgsc.SHA384;
        } else {
            if (!zzgfb.zze.equals(zzgfbVarZzg)) {
                throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(String.valueOf(zzgfbVarZzg))));
            }
            zzgscVar = zzgsc.SHA512;
        }
        zzgsjVarZzc.zza(zzgscVar);
        return (zzgsl) zzgsjVarZzc.zzbr();
    }

    private static zzgtt zzi(zzgfc zzgfcVar) throws GeneralSecurityException {
        if (zzgfc.zza.equals(zzgfcVar)) {
            return zzgtt.TINK;
        }
        if (zzgfc.zzb.equals(zzgfcVar)) {
            return zzgtt.CRUNCHY;
        }
        if (zzgfc.zzc.equals(zzgfcVar)) {
            return zzgtt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgfcVar))));
    }
}
