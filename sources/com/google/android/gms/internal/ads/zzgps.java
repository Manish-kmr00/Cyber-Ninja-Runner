package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgps {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvs zzb;
    private static final zzgmr zzc;
    private static final zzgmn zzd;
    private static final zzglf zze;
    private static final zzglb zzf;

    static {
        zzgvs zzgvsVarZzb = zzgnx.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzgvsVarZzb;
        zzc = zzgmr.zzb(new zzgmp() { // from class: com.google.android.gms.internal.ads.zzgpo
            @Override // com.google.android.gms.internal.ads.zzgmp
            public final zzgnp zza(zzgdv zzgdvVar) {
                return zzgps.zzb((zzgoi) zzgdvVar);
            }
        }, zzgoi.class, zzgnm.class);
        zzd = zzgmn.zzb(new zzgml() { // from class: com.google.android.gms.internal.ads.zzgpp
            @Override // com.google.android.gms.internal.ads.zzgml
            public final zzgdv zza(zzgnp zzgnpVar) {
                return zzgps.zzd((zzgnm) zzgnpVar);
            }
        }, zzgvsVarZzb, zzgnm.class);
        zze = zzglf.zzb(new zzgld() { // from class: com.google.android.gms.internal.ads.zzgpq
            @Override // com.google.android.gms.internal.ads.zzgld
            public final zzgnp zza(zzgdh zzgdhVar, zzgdz zzgdzVar) {
                return zzgps.zza((zzgoa) zzgdhVar, zzgdzVar);
            }
        }, zzgoa.class, zzgnl.class);
        zzf = zzglb.zzb(new zzgkz() { // from class: com.google.android.gms.internal.ads.zzgpr
            @Override // com.google.android.gms.internal.ads.zzgkz
            public final zzgdh zza(zzgnp zzgnpVar, zzgdz zzgdzVar) {
                return zzgps.zzc((zzgnl) zzgnpVar, zzgdzVar);
            }
        }, zzgvsVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzgnl zza(zzgoa zzgoaVar, zzgdz zzgdzVar) {
        zzgqd zzgqdVarZzb = zzgqf.zzb();
        zzgqdVarZzb.zzb(zzg(zzgoaVar.zzc()));
        byte[] bArrZzd = zzgoaVar.zze().zzd(zzgdzVar);
        zzgqdVarZzb.zza(zzgwn.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzgqf) zzgqdVarZzb.zzbr()).zzaN(), zzgsn.SYMMETRIC, zzh(zzgoaVar.zzc().zzf()), zzgoaVar.zzf());
    }

    public static /* synthetic */ zzgnm zzb(zzgoi zzgoiVar) {
        zzgsr zzgsrVarZza = zzgst.zza();
        zzgsrVarZza.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzgqg zzgqgVarZzb = zzgqi.zzb();
        zzgqgVarZzb.zzb(zzg(zzgoiVar));
        zzgqgVarZzb.zza(zzgoiVar.zzc());
        zzgsrVarZza.zzc(((zzgqi) zzgqgVarZzb.zzbr()).zzaN());
        zzgsrVarZza.zza(zzh(zzgoiVar.zzf()));
        return zzgnm.zzb((zzgst) zzgsrVarZza.zzbr());
    }

    public static /* synthetic */ zzgoa zzc(zzgnl zzgnlVar, zzgdz zzgdzVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
        try {
            zzgqf zzgqfVarZzd = zzgqf.zzd(zzgnlVar.zze(), zzgxf.zza());
            if (zzgqfVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgof zzgofVarZze = zzgoi.zze();
            zzgofVarZze.zza(zzgqfVarZzd.zzg().zzd());
            zzgofVarZze.zzb(zzgqfVarZzd.zzf().zza());
            zzgofVarZze.zzc(zzf(zzgnlVar.zzc()));
            zzgoi zzgoiVarZzd = zzgofVarZze.zzd();
            zzgny zzgnyVarZzb = zzgoa.zzb();
            zzgnyVarZzb.zzc(zzgoiVarZzd);
            zzgnyVarZzb.zza(zzgvt.zzb(zzgqfVarZzd.zzg().zzA(), zzgdzVar));
            zzgnyVarZzb.zzb(zzgnlVar.zzf());
            return zzgnyVarZzb.zzd();
        } catch (zzgyk | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    public static /* synthetic */ zzgoi zzd(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgqi zzgqiVarZzd = zzgqi.zzd(zzgnmVar.zzc().zzh(), zzgxf.zza());
            zzgof zzgofVarZze = zzgoi.zze();
            zzgofVarZze.zza(zzgqiVarZzd.zza());
            zzgofVarZze.zzb(zzgqiVarZzd.zzf().zza());
            zzgofVarZze.zzc(zzf(zzgnmVar.zzc().zzg()));
            return zzgofVarZze.zzd();
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
        }
    }

    public static void zze(zzgmi zzgmiVar) throws GeneralSecurityException {
        zzgmiVar.zzi(zzc);
        zzgmiVar.zzh(zzd);
        zzgmiVar.zzg(zze);
        zzgmiVar.zzf(zzf);
    }

    private static zzgog zzf(zzgtt zzgttVar) throws GeneralSecurityException {
        int iOrdinal = zzgttVar.ordinal();
        if (iOrdinal == 1) {
            return zzgog.zza;
        }
        if (iOrdinal == 2) {
            return zzgog.zzc;
        }
        if (iOrdinal == 3) {
            return zzgog.zzd;
        }
        if (iOrdinal == 4) {
            return zzgog.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgttVar.zza());
    }

    private static zzgql zzg(zzgoi zzgoiVar) {
        zzgqj zzgqjVarZzb = zzgql.zzb();
        zzgqjVarZzb.zza(zzgoiVar.zzb());
        return (zzgql) zzgqjVarZzb.zzbr();
    }

    private static zzgtt zzh(zzgog zzgogVar) throws GeneralSecurityException {
        if (zzgog.zza.equals(zzgogVar)) {
            return zzgtt.TINK;
        }
        if (zzgog.zzb.equals(zzgogVar)) {
            return zzgtt.CRUNCHY;
        }
        if (zzgog.zzd.equals(zzgogVar)) {
            return zzgtt.RAW;
        }
        if (zzgog.zzc.equals(zzgogVar)) {
            return zzgtt.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgogVar))));
    }
}
