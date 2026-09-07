package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgix {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvs zzb;
    private static final zzgmr zzc;
    private static final zzgmn zzd;
    private static final zzglf zze;
    private static final zzglb zzf;

    static {
        zzgvs zzgvsVarZzb = zzgnx.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzgvsVarZzb;
        zzc = zzgmr.zzb(new zzgmp() { // from class: com.google.android.gms.internal.ads.zzgit
            @Override // com.google.android.gms.internal.ads.zzgmp
            public final zzgnp zza(zzgdv zzgdvVar) {
                return zzgix.zzd((zzgfo) zzgdvVar);
            }
        }, zzgfo.class, zzgnm.class);
        zzd = zzgmn.zzb(new zzgml() { // from class: com.google.android.gms.internal.ads.zzgiu
            @Override // com.google.android.gms.internal.ads.zzgml
            public final zzgdv zza(zzgnp zzgnpVar) {
                return zzgix.zzb((zzgnm) zzgnpVar);
            }
        }, zzgvsVarZzb, zzgnm.class);
        zze = zzglf.zzb(new zzgld() { // from class: com.google.android.gms.internal.ads.zzgiv
            @Override // com.google.android.gms.internal.ads.zzgld
            public final zzgnp zza(zzgdh zzgdhVar, zzgdz zzgdzVar) {
                return zzgix.zzc((zzgfh) zzgdhVar, zzgdzVar);
            }
        }, zzgfh.class, zzgnl.class);
        zzf = zzglb.zzb(new zzgkz() { // from class: com.google.android.gms.internal.ads.zzgiw
            @Override // com.google.android.gms.internal.ads.zzgkz
            public final zzgdh zza(zzgnp zzgnpVar, zzgdz zzgdzVar) {
                return zzgix.zza((zzgnl) zzgnpVar, zzgdzVar);
            }
        }, zzgvsVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzgfh zza(zzgnl zzgnlVar, zzgdz zzgdzVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzgrd zzgrdVarZzd = zzgrd.zzd(zzgnlVar.zze(), zzgxf.zza());
            if (zzgrdVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgfl zzgflVarZzd = zzgfo.zzd();
            zzgflVarZzd.zzb(zzgrdVarZzd.zzg().zzd());
            zzgflVarZzd.zza(zzgrdVarZzd.zzf().zza());
            zzgflVarZzd.zzc(16);
            zzgflVarZzd.zzd(zzf(zzgnlVar.zzc()));
            zzgfo zzgfoVarZze = zzgflVarZzd.zze();
            zzgff zzgffVarZzc = zzgfh.zzc();
            zzgffVarZzc.zzc(zzgfoVarZze);
            zzgffVarZzc.zzb(zzgvt.zzb(zzgrdVarZzd.zzg().zzA(), zzgdzVar));
            zzgffVarZzc.zza(zzgnlVar.zzf());
            return zzgffVarZzc.zzd();
        } catch (zzgyk unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }

    public static /* synthetic */ zzgfo zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgrg zzgrgVarZzd = zzgrg.zzd(zzgnmVar.zzc().zzh(), zzgxf.zza());
            zzgfl zzgflVarZzd = zzgfo.zzd();
            zzgflVarZzd.zzb(zzgrgVarZzd.zza());
            zzgflVarZzd.zza(zzgrgVarZzd.zzf().zza());
            zzgflVarZzd.zzc(16);
            zzgflVarZzd.zzd(zzf(zzgnmVar.zzc().zzg()));
            return zzgflVarZzd.zze();
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzgfh zzgfhVar, zzgdz zzgdzVar) {
        zzgrb zzgrbVarZzb = zzgrd.zzb();
        zzgrbVarZzb.zzb(zzg(zzgfhVar.zzd()));
        byte[] bArrZzd = zzgfhVar.zze().zzd(zzgdzVar);
        zzgrbVarZzb.zza(zzgwn.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzgrd) zzgrbVarZzb.zzbr()).zzaN(), zzgsn.SYMMETRIC, zzh(zzgfhVar.zzd().zze()), zzgfhVar.zzf());
    }

    public static /* synthetic */ zzgnm zzd(zzgfo zzgfoVar) {
        zzgsr zzgsrVarZza = zzgst.zza();
        zzgsrVarZza.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzgre zzgreVarZzb = zzgrg.zzb();
        zzgreVarZzb.zzb(zzg(zzgfoVar));
        zzgreVarZzb.zza(zzgfoVar.zzc());
        zzgsrVarZza.zzc(((zzgrg) zzgreVarZzb.zzbr()).zzaN());
        zzgsrVarZza.zza(zzh(zzgfoVar.zze()));
        return zzgnm.zzb((zzgst) zzgsrVarZza.zzbr());
    }

    public static void zze(zzgmi zzgmiVar) throws GeneralSecurityException {
        zzgmiVar.zzi(zzc);
        zzgmiVar.zzh(zzd);
        zzgmiVar.zzg(zze);
        zzgmiVar.zzf(zzf);
    }

    private static zzgfm zzf(zzgtt zzgttVar) throws GeneralSecurityException {
        int iOrdinal = zzgttVar.ordinal();
        if (iOrdinal == 1) {
            return zzgfm.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgfm.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgttVar.zza());
            }
        }
        return zzgfm.zzb;
    }

    private static zzgrj zzg(zzgfo zzgfoVar) throws GeneralSecurityException {
        zzgrh zzgrhVarZzb = zzgrj.zzb();
        zzgrhVarZzb.zza(zzgfoVar.zzb());
        return (zzgrj) zzgrhVarZzb.zzbr();
    }

    private static zzgtt zzh(zzgfm zzgfmVar) throws GeneralSecurityException {
        if (zzgfm.zza.equals(zzgfmVar)) {
            return zzgtt.TINK;
        }
        if (zzgfm.zzb.equals(zzgfmVar)) {
            return zzgtt.CRUNCHY;
        }
        if (zzgfm.zzc.equals(zzgfmVar)) {
            return zzgtt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgfmVar))));
    }
}
