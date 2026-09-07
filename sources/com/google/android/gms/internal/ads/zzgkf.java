package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgkf {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvs zzb;
    private static final zzgmr zzc;
    private static final zzgmn zzd;
    private static final zzglf zze;
    private static final zzglb zzf;

    static {
        zzgvs zzgvsVarZzb = zzgnx.zzb("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zzb = zzgvsVarZzb;
        zzc = zzgmr.zzb(new zzgmp() { // from class: com.google.android.gms.internal.ads.zzgkb
            @Override // com.google.android.gms.internal.ads.zzgmp
            public final zzgnp zza(zzgdv zzgdvVar) {
                return zzgkf.zzd((zzgig) zzgdvVar);
            }
        }, zzgig.class, zzgnm.class);
        zzd = zzgmn.zzb(new zzgml() { // from class: com.google.android.gms.internal.ads.zzgkc
            @Override // com.google.android.gms.internal.ads.zzgml
            public final zzgdv zza(zzgnp zzgnpVar) {
                return zzgkf.zzb((zzgnm) zzgnpVar);
            }
        }, zzgvsVarZzb, zzgnm.class);
        zze = zzglf.zzb(new zzgld() { // from class: com.google.android.gms.internal.ads.zzgkd
            @Override // com.google.android.gms.internal.ads.zzgld
            public final zzgnp zza(zzgdh zzgdhVar, zzgdz zzgdzVar) {
                return zzgkf.zzc((zzgib) zzgdhVar, zzgdzVar);
            }
        }, zzgib.class, zzgnl.class);
        zzf = zzglb.zzb(new zzgkz() { // from class: com.google.android.gms.internal.ads.zzgke
            @Override // com.google.android.gms.internal.ads.zzgkz
            public final zzgdh zza(zzgnp zzgnpVar, zzgdz zzgdzVar) {
                return zzgkf.zza((zzgnl) zzgnpVar, zzgdzVar);
            }
        }, zzgvsVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzgib zza(zzgnl zzgnlVar, zzgdz zzgdzVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseKey");
        }
        try {
            zzgtz zzgtzVarZzd = zzgtz.zzd(zzgnlVar.zze(), zzgxf.zza());
            if (zzgtzVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzgtzVarZzd.zzg().zzd() == 32) {
                return zzgib.zzc(zzgig.zzd(zzf(zzgnlVar.zzc()), zzgtzVarZzd.zzf().zza()), zzgvt.zzb(zzgtzVarZzd.zzg().zzA(), zzgdzVar), zzgnlVar.zzf());
            }
            throw new GeneralSecurityException("Only 32 byte key size is accepted");
        } catch (zzgyk unused) {
            throw new GeneralSecurityException("Parsing XAesGcmKey failed");
        }
    }

    public static /* synthetic */ zzgig zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzguc zzgucVarZzd = zzguc.zzd(zzgnmVar.zzc().zzh(), zzgxf.zza());
            if (zzgucVarZzd.zza() == 0) {
                return zzgig.zzd(zzf(zzgnmVar.zzc().zzg()), zzgucVarZzd.zzf().zza());
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing XAesGcmParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzgib zzgibVar, zzgdz zzgdzVar) {
        zzgtx zzgtxVarZzb = zzgtz.zzb();
        byte[] bArrZzd = zzgibVar.zze().zzd(zzgdzVar);
        zzgtxVarZzb.zza(zzgwn.zzv(bArrZzd, 0, bArrZzd.length));
        zzgud zzgudVarZzb = zzguf.zzb();
        zzgudVarZzb.zza(zzgibVar.zzd().zzb());
        zzgtxVarZzb.zzb((zzguf) zzgudVarZzb.zzbr());
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.XAesGcmKey", ((zzgtz) zzgtxVarZzb.zzbr()).zzaN(), zzgsn.SYMMETRIC, zzg(zzgibVar.zzd().zzc()), zzgibVar.zzf());
    }

    public static /* synthetic */ zzgnm zzd(zzgig zzgigVar) {
        zzgsr zzgsrVarZza = zzgst.zza();
        zzgsrVarZza.zzb("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zzgua zzguaVarZzb = zzguc.zzb();
        zzgud zzgudVarZzb = zzguf.zzb();
        zzgudVarZzb.zza(zzgigVar.zzb());
        zzguaVarZzb.zza((zzguf) zzgudVarZzb.zzbr());
        zzgsrVarZza.zzc(((zzguc) zzguaVarZzb.zzbr()).zzaN());
        zzgsrVarZza.zza(zzg(zzgigVar.zzc()));
        return zzgnm.zzb((zzgst) zzgsrVarZza.zzbr());
    }

    public static void zze(zzgmi zzgmiVar) throws GeneralSecurityException {
        zzgmiVar.zzi(zzc);
        zzgmiVar.zzh(zzd);
        zzgmiVar.zzg(zze);
        zzgmiVar.zzf(zzf);
    }

    private static zzgif zzf(zzgtt zzgttVar) throws GeneralSecurityException {
        int iOrdinal = zzgttVar.ordinal();
        if (iOrdinal == 1) {
            return zzgif.zza;
        }
        if (iOrdinal == 3) {
            return zzgif.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgttVar.zza());
    }

    private static zzgtt zzg(zzgif zzgifVar) throws GeneralSecurityException {
        if (Objects.equals(zzgifVar, zzgif.zza)) {
            return zzgtt.TINK;
        }
        if (Objects.equals(zzgifVar, zzgif.zzb)) {
            return zzgtt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgifVar.toString()));
    }
}
