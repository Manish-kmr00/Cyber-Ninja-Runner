package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzghq {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvs zzb;
    private static final zzgmr zzc;
    private static final zzgmn zzd;
    private static final zzglf zze;
    private static final zzglb zzf;

    static {
        zzgvs zzgvsVarZzb = zzgnx.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzb = zzgvsVarZzb;
        zzc = zzgmr.zzb(new zzgmp() { // from class: com.google.android.gms.internal.ads.zzghm
            @Override // com.google.android.gms.internal.ads.zzgmp
            public final zzgnp zza(zzgdv zzgdvVar) {
                return zzghq.zzd((zzghl) zzgdvVar);
            }
        }, zzghl.class, zzgnm.class);
        zzd = zzgmn.zzb(new zzgml() { // from class: com.google.android.gms.internal.ads.zzghn
            @Override // com.google.android.gms.internal.ads.zzgml
            public final zzgdv zza(zzgnp zzgnpVar) {
                return zzghq.zzb((zzgnm) zzgnpVar);
            }
        }, zzgvsVarZzb, zzgnm.class);
        zze = zzglf.zzb(new zzgld() { // from class: com.google.android.gms.internal.ads.zzgho
            @Override // com.google.android.gms.internal.ads.zzgld
            public final zzgnp zza(zzgdh zzgdhVar, zzgdz zzgdzVar) {
                return zzghq.zzc((zzghg) zzgdhVar, zzgdzVar);
            }
        }, zzghg.class, zzgnl.class);
        zzf = zzglb.zzb(new zzgkz() { // from class: com.google.android.gms.internal.ads.zzghp
            @Override // com.google.android.gms.internal.ads.zzgkz
            public final zzgdh zza(zzgnp zzgnpVar, zzgdz zzgdzVar) {
                return zzghq.zza((zzgnl) zzgnpVar, zzgdzVar);
            }
        }, zzgvsVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzghg zza(zzgnl zzgnlVar, zzgdz zzgdzVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            zzgtp zzgtpVarZzd = zzgtp.zzd(zzgnlVar.zze(), zzgxf.zza());
            if (zzgtpVarZzd.zza() == 0) {
                return zzghg.zzc(zzf(zzgtpVarZzd.zzf(), zzgnlVar.zzc()), zzgnlVar.zzf());
            }
            throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + String.valueOf(zzgtpVarZzd));
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
        }
    }

    public static /* synthetic */ zzghl zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            return zzf(zzgts.zzf(zzgnmVar.zzc().zzh(), zzgxf.zza()), zzgnmVar.zzc().zzg());
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzghg zzghgVar, zzgdz zzgdzVar) {
        zzgtn zzgtnVarZzb = zzgtp.zzb();
        zzgtnVarZzb.zza(zzg(zzghgVar.zzd()));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzgtp) zzgtnVarZzb.zzbr()).zzaN(), zzgsn.REMOTE, zzh(zzghgVar.zzd().zzc()), zzghgVar.zze());
    }

    public static /* synthetic */ zzgnm zzd(zzghl zzghlVar) {
        zzgsr zzgsrVarZza = zzgst.zza();
        zzgsrVarZza.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzgsrVarZza.zzc(zzg(zzghlVar).zzaN());
        zzgsrVarZza.zza(zzh(zzghlVar.zzc()));
        return zzgnm.zzb((zzgst) zzgsrVarZza.zzbr());
    }

    public static void zze(zzgmi zzgmiVar) throws GeneralSecurityException {
        zzgmiVar.zzi(zzc);
        zzgmiVar.zzh(zzd);
        zzgmiVar.zzg(zze);
        zzgmiVar.zzf(zzf);
    }

    private static zzghl zzf(zzgts zzgtsVar, zzgtt zzgttVar) throws GeneralSecurityException {
        zzghi zzghiVar;
        zzghj zzghjVar;
        zzgsr zzgsrVarZza = zzgst.zza();
        zzgsrVarZza.zzb(zzgtsVar.zza().zzi());
        zzgsrVarZza.zzc(zzgtsVar.zza().zzh());
        zzgsrVarZza.zza(zzgtt.RAW);
        zzgdv zzgdvVarZza = zzgeb.zza(((zzgst) zzgsrVarZza.zzbr()).zzaV());
        if (zzgdvVarZza instanceof zzgfz) {
            zzghiVar = zzghi.zza;
        } else if (zzgdvVarZza instanceof zzggq) {
            zzghiVar = zzghi.zzc;
        } else if (zzgdvVarZza instanceof zzgin) {
            zzghiVar = zzghi.zzb;
        } else if (zzgdvVarZza instanceof zzgfe) {
            zzghiVar = zzghi.zzd;
        } else if (zzgdvVarZza instanceof zzgfo) {
            zzghiVar = zzghi.zze;
        } else {
            if (!(zzgdvVarZza instanceof zzggk)) {
                throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zzgdvVarZza.toString()));
            }
            zzghiVar = zzghi.zzf;
        }
        zzghh zzghhVar = new zzghh(null);
        int iOrdinal = zzgttVar.ordinal();
        if (iOrdinal == 1) {
            zzghjVar = zzghj.zza;
        } else {
            if (iOrdinal != 3) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgttVar.zza());
            }
            zzghjVar = zzghj.zzb;
        }
        zzghhVar.zzd(zzghjVar);
        zzghhVar.zzc(zzgtsVar.zzg());
        zzghhVar.zza((zzgen) zzgdvVarZza);
        zzghhVar.zzb(zzghiVar);
        return zzghhVar.zze();
    }

    private static zzgts zzg(zzghl zzghlVar) throws GeneralSecurityException {
        try {
            zzgst zzgstVarZzf = zzgst.zzf(zzgeb.zzb(zzghlVar.zzb()), zzgxf.zza());
            zzgtq zzgtqVarZzb = zzgts.zzb();
            zzgtqVarZzb.zzb(zzghlVar.zzd());
            zzgtqVarZzb.zza(zzgstVarZzf);
            return (zzgts) zzgtqVarZzb.zzbr();
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzgtt zzh(zzghj zzghjVar) throws GeneralSecurityException {
        if (zzghj.zza.equals(zzghjVar)) {
            return zzgtt.TINK;
        }
        if (zzghj.zzb.equals(zzghjVar)) {
            return zzgtt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzghjVar))));
    }
}
