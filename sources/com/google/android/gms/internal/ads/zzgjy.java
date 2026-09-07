package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgjy implements zzgcy {
    private final zzgcy zza;
    private final byte[] zzb;

    private zzgjy(zzgcy zzgcyVar, byte[] bArr) {
        this.zza = zzgcyVar;
        int length = bArr.length;
        if (length != 0 && length != 5) {
            throw new IllegalArgumentException("identifier has an invalid length");
        }
        this.zzb = bArr;
    }

    public static zzgcy zzb(zzglm zzglmVar) throws GeneralSecurityException {
        byte[] bArrZzd;
        zzgnl zzgnlVarZzb = zzglmVar.zzb(zzgdg.zza());
        zzgsm zzgsmVarZza = zzgsp.zza();
        zzgsmVarZza.zzb(zzgnlVarZzb.zzg());
        zzgsmVarZza.zzc(zzgnlVarZzb.zze());
        zzgsmVarZza.zza(zzgnlVarZzb.zzb());
        zzgcy zzgcyVar = (zzgcy) zzgdy.zza((zzgsp) zzgsmVarZza.zzbr(), zzgcy.class);
        zzgtt zzgttVarZzc = zzgnlVarZzb.zzc();
        int iOrdinal = zzgttVarZzc.ordinal();
        if (iOrdinal == 1) {
            bArrZzd = zzgmj.zzb(zzglmVar.zzd().intValue()).zzd();
        } else if (iOrdinal == 2) {
            bArrZzd = zzgmj.zza(zzglmVar.zzd().intValue()).zzd();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type ".concat(String.valueOf(String.valueOf(zzgttVarZzc))));
            }
            bArrZzd = zzgmj.zza(zzglmVar.zzd().intValue()).zzd();
        } else {
            bArrZzd = zzgmj.zza.zzd();
        }
        return new zzgjy(zzgcyVar, bArrZzd);
    }

    public static zzgcy zzc(zzgcy zzgcyVar, zzgvs zzgvsVar) {
        return new zzgjy(zzgcyVar, zzgvsVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzgcy
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzgnx.zzc(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
