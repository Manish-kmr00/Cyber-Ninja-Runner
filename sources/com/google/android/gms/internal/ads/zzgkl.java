package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgkl {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvs zzb;
    private static final zzgmr zzc;
    private static final zzgmn zzd;
    private static final zzglf zze;
    private static final zzglb zzf;

    static {
        zzgvs zzgvsVarZzb = zzgnx.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zzgvsVarZzb;
        zzc = zzgmr.zzb(new zzgmp() { // from class: com.google.android.gms.internal.ads.zzgkh
            @Override // com.google.android.gms.internal.ads.zzgmp
            public final zzgnp zza(zzgdv zzgdvVar) {
                return zzgkl.zzd((zzgin) zzgdvVar);
            }
        }, zzgin.class, zzgnm.class);
        zzd = zzgmn.zzb(new zzgml() { // from class: com.google.android.gms.internal.ads.zzgki
            @Override // com.google.android.gms.internal.ads.zzgml
            public final zzgdv zza(zzgnp zzgnpVar) {
                return zzgkl.zzb((zzgnm) zzgnpVar);
            }
        }, zzgvsVarZzb, zzgnm.class);
        zze = zzglf.zzb(new zzgld() { // from class: com.google.android.gms.internal.ads.zzgkj
            @Override // com.google.android.gms.internal.ads.zzgld
            public final zzgnp zza(zzgdh zzgdhVar, zzgdz zzgdzVar) {
                return zzgkl.zzc((zzgih) zzgdhVar, zzgdzVar);
            }
        }, zzgih.class, zzgnl.class);
        zzf = zzglb.zzb(new zzgkz() { // from class: com.google.android.gms.internal.ads.zzgkk
            @Override // com.google.android.gms.internal.ads.zzgkz
            public final zzgdh zza(zzgnp zzgnpVar, zzgdz zzgdzVar) {
                return zzgkl.zza((zzgnl) zzgnpVar, zzgdzVar);
            }
        }, zzgvsVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzgih zza(zzgnl zzgnlVar, zzgdz zzgdzVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzgui zzguiVarZzd = zzgui.zzd(zzgnlVar.zze(), zzgxf.zza());
            if (zzguiVarZzd.zza() == 0) {
                return zzgih.zzc(zzf(zzgnlVar.zzc()), zzgvt.zzb(zzguiVarZzd.zzf().zzA(), zzgdzVar), zzgnlVar.zzf());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzgyk unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    public static /* synthetic */ zzgin zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            if (zzgul.zzd(zzgnmVar.zzc().zzh(), zzgxf.zza()).zza() == 0) {
                return zzgin.zzc(zzf(zzgnmVar.zzc().zzg()));
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzgyk e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzgih zzgihVar, zzgdz zzgdzVar) {
        zzgug zzgugVarZzb = zzgui.zzb();
        byte[] bArrZzd = zzgihVar.zze().zzd(zzgdzVar);
        zzgugVarZzb.zza(zzgwn.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzgui) zzgugVarZzb.zzbr()).zzaN(), zzgsn.SYMMETRIC, zzg(zzgihVar.zzd().zzb()), zzgihVar.zzf());
    }

    public static /* synthetic */ zzgnm zzd(zzgin zzginVar) {
        zzgsr zzgsrVarZza = zzgst.zza();
        zzgsrVarZza.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzgsrVarZza.zzc(zzgul.zzc().zzaN());
        zzgsrVarZza.zza(zzg(zzginVar.zzb()));
        return zzgnm.zzb((zzgst) zzgsrVarZza.zzbr());
    }

    public static void zze(zzgmi zzgmiVar) throws GeneralSecurityException {
        zzgmiVar.zzi(zzc);
        zzgmiVar.zzh(zzd);
        zzgmiVar.zzg(zze);
        zzgmiVar.zzf(zzf);
    }

    private static zzgim zzf(zzgtt zzgttVar) throws GeneralSecurityException {
        int iOrdinal = zzgttVar.ordinal();
        if (iOrdinal == 1) {
            return zzgim.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgim.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgttVar.zza());
            }
        }
        return zzgim.zzb;
    }

    private static zzgtt zzg(zzgim zzgimVar) throws GeneralSecurityException {
        if (zzgim.zza.equals(zzgimVar)) {
            return zzgtt.TINK;
        }
        if (zzgim.zzb.equals(zzgimVar)) {
            return zzgtt.CRUNCHY;
        }
        if (zzgim.zzc.equals(zzgimVar)) {
            return zzgtt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgimVar.toString()));
    }
}
