package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgur implements zzgcy {
    private final SecretKey zza;
    private final byte[] zzb;

    private zzgur(byte[] bArr, zzgvs zzgvsVar) throws GeneralSecurityException {
        if (!zzgko.zza(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zza = zzgiz.zzc(bArr);
        this.zzb = zzgvsVar.zzd();
    }

    public static zzgcy zzb(zzgfr zzgfrVar) throws GeneralSecurityException {
        return new zzgur(zzgfrVar.zze().zzd(zzgdg.zza()), zzgfrVar.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzgcy
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        byte[] bArr3 = this.zzb;
        int length = bArr.length;
        int length2 = bArr3.length;
        if (length < length2 + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzgnx.zzc(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        AlgorithmParameterSpec algorithmParameterSpecZza = zzgiz.zza(bArr, length2, 12);
        SecretKey secretKey = this.zza;
        Cipher cipherZzb = zzgiz.zzb();
        cipherZzb.init(2, secretKey, algorithmParameterSpecZza);
        if (bArr2 != null && bArr2.length != 0) {
            cipherZzb.updateAAD(bArr2);
        }
        return cipherZzb.doFinal(bArr, length2 + 12, (length - length2) - 12);
    }
}
