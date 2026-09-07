package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgqa {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvs zzb;
    private static final zzgkt zzc;
    private static final zzgkt zzd;
    private static final zzgmr zze;
    private static final zzgmn zzf;
    private static final zzglf zzg;
    private static final zzglb zzh;

    static {
        zzgvs zzgvsVarZzb = zzgnx.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzgvsVarZzb;
        zzgkr zzgkrVarZza = zzgkt.zza();
        zzgkrVarZza.zza(zzgtt.RAW, zzgox.zzd);
        zzgkrVarZza.zza(zzgtt.TINK, zzgox.zza);
        zzgkrVarZza.zza(zzgtt.LEGACY, zzgox.zzc);
        zzgkrVarZza.zza(zzgtt.CRUNCHY, zzgox.zzb);
        zzc = zzgkrVarZza.zzb();
        zzgkr zzgkrVarZza2 = zzgkt.zza();
        zzgkrVarZza2.zza(zzgsc.SHA1, zzgow.zza);
        zzgkrVarZza2.zza(zzgsc.SHA224, zzgow.zzb);
        zzgkrVarZza2.zza(zzgsc.SHA256, zzgow.zzc);
        zzgkrVarZza2.zza(zzgsc.SHA384, zzgow.zzd);
        zzgkrVarZza2.zza(zzgsc.SHA512, zzgow.zze);
        zzd = zzgkrVarZza2.zzb();
        zze = zzgmr.zzb(new zzgmp() { // from class: com.google.android.gms.internal.ads.zzgpw
            @Override // com.google.android.gms.internal.ads.zzgmp
            public final zzgnp zza(zzgdv zzgdvVar) {
                return zzgqa.zzb((zzgoz) zzgdvVar);
            }
        }, zzgoz.class, zzgnm.class);
        zzf = zzgmn.zzb(new zzgml() { // from class: com.google.android.gms.internal.ads.zzgpx
            @Override // com.google.android.gms.internal.ads.zzgml
            public final zzgdv zza(zzgnp zzgnpVar) {
                return zzgqa.zzd((zzgnm) zzgnpVar);
            }
        }, zzgvsVarZzb, zzgnm.class);
        zzg = zzglf.zzb(new zzgld() { // from class: com.google.android.gms.internal.ads.zzgpy
            @Override // com.google.android.gms.internal.ads.zzgld
            public final zzgnp zza(zzgdh zzgdhVar, zzgdz zzgdzVar) {
                return zzgqa.zza((zzgop) zzgdhVar, zzgdzVar);
            }
        }, zzgop.class, zzgnl.class);
        zzh = zzglb.zzb(new zzgkz() { // from class: com.google.android.gms.internal.ads.zzgpz
            @Override // com.google.android.gms.internal.ads.zzgkz
            public final zzgdh zza(zzgnp zzgnpVar, zzgdz zzgdzVar) {
                return zzgqa.zzc((zzgnl) zzgnpVar, zzgdzVar);
            }
        }, zzgvsVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzgnl zza(zzgop zzgopVar, zzgdz zzgdzVar) {
        zzgsd zzgsdVarZzb = zzgsf.zzb();
        zzgsdVarZzb.zzb(zzf(zzgopVar.zzc()));
        byte[] bArrZzd = zzgopVar.zze().zzd(zzgdzVar);
        zzgsdVarZzb.zza(zzgwn.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzgsf) zzgsdVarZzb.zzbr()).zzaN(), zzgsn.SYMMETRIC, (zzgtt) zzc.zzb(zzgopVar.zzc().zzg()), zzgopVar.zzf());
    }

    public static /* synthetic */ zzgnm zzb(zzgoz zzgozVar) {
        zzgsr zzgsrVarZza = zzgst.zza();
        zzgsrVarZza.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzgsg zzgsgVarZzc = zzgsi.zzc();
        zzgsgVarZzc.zzb(zzf(zzgozVar));
        zzgsgVarZzc.zza(zzgozVar.zzc());
        zzgsrVarZza.zzc(((zzgsi) zzgsgVarZzc.zzbr()).zzaN());
        zzgsrVarZza.zza((zzgtt) zzc.zzb(zzgozVar.zzg()));
        return zzgnm.zzb((zzgst) zzgsrVarZza.zzbr());
    }

    public static /* synthetic */ zzgop zzc(zzgnl zzgnlVar, zzgdz zzgdzVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzgsf zzgsfVarZzf = zzgsf.zzf(zzgnlVar.zze(), zzgxf.zza());
            if (zzgsfVarZzf.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgov zzgovVarZze = zzgoz.zze();
            zzgovVarZze.zzb(zzgsfVarZzf.zzh().zzd());
            zzgovVarZze.zzc(zzgsfVarZzf.zzg().zza());
            zzgovVarZze.zza((zzgow) zzd.zzc(zzgsfVarZzf.zzg().zzb()));
            zzgovVarZze.zzd((zzgox) zzc.zzc(zzgnlVar.zzc()));
            zzgoz zzgozVarZze = zzgovVarZze.zze();
            zzgon zzgonVarZzb = zzgop.zzb();
            zzgonVarZzb.zzc(zzgozVarZze);
            zzgonVarZzb.zzb(zzgvt.zzb(zzgsfVarZzf.zzh().zzA(), zzgdzVar));
            zzgonVarZzb.zza(zzgnlVar.zzf());
            return zzgonVarZzb.zzd();
        } catch (zzgyk | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    public static /* synthetic */ zzgoz zzd(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgsi zzgsiVarZzg = zzgsi.zzg(zzgnmVar.zzc().zzh(), zzgxf.zza());
            if (zzgsiVarZzg.zzb() != 0) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzgsiVarZzg.zzb());
            }
            zzgov zzgovVarZze = zzgoz.zze();
            zzgovVarZze.zzb(zzgsiVarZzg.zza());
            zzgovVarZze.zzc(zzgsiVarZzg.zzh().zza());
            zzgovVarZze.zza((zzgow) zzd.zzc(zzgsiVarZzg.zzh().zzb()));
            zzgovVarZze.zzd((zzgox) zzc.zzc(zzgnmVar.zzc().zzg()));
            return zzgovVarZze.zze();
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
        }
    }

    public static void zze(zzgmi zzgmiVar) throws GeneralSecurityException {
        zzgmiVar.zzi(zze);
        zzgmiVar.zzh(zzf);
        zzgmiVar.zzg(zzg);
        zzgmiVar.zzf(zzh);
    }

    private static zzgsl zzf(zzgoz zzgozVar) throws GeneralSecurityException {
        zzgsj zzgsjVarZzc = zzgsl.zzc();
        zzgsjVarZzc.zzb(zzgozVar.zzb());
        zzgsjVarZzc.zza((zzgsc) zzd.zzb(zzgozVar.zzf()));
        return (zzgsl) zzgsjVarZzc.zzbr();
    }
}
