package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzghf {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvs zzb;
    private static final zzgmr zzc;
    private static final zzgmn zzd;
    private static final zzglf zze;
    private static final zzglb zzf;

    static {
        zzgvs zzgvsVarZzb = zzgnx.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzb = zzgvsVarZzb;
        zzc = zzgmr.zzb(new zzgmp() { // from class: com.google.android.gms.internal.ads.zzghb
            @Override // com.google.android.gms.internal.ads.zzgmp
            public final zzgnp zza(zzgdv zzgdvVar) {
                return zzghf.zzd((zzgha) zzgdvVar);
            }
        }, zzgha.class, zzgnm.class);
        zzd = zzgmn.zzb(new zzgml() { // from class: com.google.android.gms.internal.ads.zzghc
            @Override // com.google.android.gms.internal.ads.zzgml
            public final zzgdv zza(zzgnp zzgnpVar) {
                return zzghf.zzb((zzgnm) zzgnpVar);
            }
        }, zzgvsVarZzb, zzgnm.class);
        zze = zzglf.zzb(new zzgld() { // from class: com.google.android.gms.internal.ads.zzghd
            @Override // com.google.android.gms.internal.ads.zzgld
            public final zzgnp zza(zzgdh zzgdhVar, zzgdz zzgdzVar) {
                return zzghf.zzc((zzggy) zzgdhVar, zzgdzVar);
            }
        }, zzggy.class, zzgnl.class);
        zzf = zzglb.zzb(new zzgkz() { // from class: com.google.android.gms.internal.ads.zzghe
            @Override // com.google.android.gms.internal.ads.zzgkz
            public final zzgdh zza(zzgnp zzgnpVar, zzgdz zzgdzVar) {
                return zzghf.zza((zzgnl) zzgnpVar, zzgdzVar);
            }
        }, zzgvsVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzggy zza(zzgnl zzgnlVar, zzgdz zzgdzVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
        try {
            zzgtj zzgtjVarZzd = zzgtj.zzd(zzgnlVar.zze(), zzgxf.zza());
            if (zzgtjVarZzd.zza() == 0) {
                return zzggy.zzc(zzgha.zzc(zzgtjVarZzd.zzf().zzf(), zzf(zzgnlVar.zzc())), zzgnlVar.zzf());
            }
            throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + String.valueOf(zzgtjVarZzd));
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
        }
    }

    public static /* synthetic */ zzgha zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            return zzgha.zzc(zzgtm.zzd(zzgnmVar.zzc().zzh(), zzgxf.zza()).zzf(), zzf(zzgnmVar.zzc().zzg()));
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzggy zzggyVar, zzgdz zzgdzVar) {
        zzgth zzgthVarZzb = zzgtj.zzb();
        zzgtk zzgtkVarZza = zzgtm.zza();
        zzgtkVarZza.zza(zzggyVar.zzd().zzd());
        zzgthVarZzb.zza((zzgtm) zzgtkVarZza.zzbr());
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzgtj) zzgthVarZzb.zzbr()).zzaN(), zzgsn.REMOTE, zzg(zzggyVar.zzd().zzb()), zzggyVar.zze());
    }

    public static /* synthetic */ zzgnm zzd(zzgha zzghaVar) {
        zzgsr zzgsrVarZza = zzgst.zza();
        zzgsrVarZza.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzgtk zzgtkVarZza = zzgtm.zza();
        zzgtkVarZza.zza(zzghaVar.zzd());
        zzgsrVarZza.zzc(((zzgtm) zzgtkVarZza.zzbr()).zzaN());
        zzgsrVarZza.zza(zzg(zzghaVar.zzb()));
        return zzgnm.zzb((zzgst) zzgsrVarZza.zzbr());
    }

    public static void zze(zzgmi zzgmiVar) throws GeneralSecurityException {
        zzgmiVar.zzi(zzc);
        zzgmiVar.zzh(zzd);
        zzgmiVar.zzg(zze);
        zzgmiVar.zzf(zzf);
    }

    private static zzggz zzf(zzgtt zzgttVar) throws GeneralSecurityException {
        int iOrdinal = zzgttVar.ordinal();
        if (iOrdinal == 1) {
            return zzggz.zza;
        }
        if (iOrdinal == 3) {
            return zzggz.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgttVar.zza());
    }

    private static zzgtt zzg(zzggz zzggzVar) throws GeneralSecurityException {
        if (zzggz.zza.equals(zzggzVar)) {
            return zzgtt.TINK;
        }
        if (zzggz.zzb.equals(zzggzVar)) {
            return zzgtt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzggzVar.toString()));
    }
}
