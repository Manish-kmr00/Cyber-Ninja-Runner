package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzguu implements zzgcy {
    private final zzgvk zza;
    private final zzgdu zzb;
    private final int zzc;
    private final byte[] zzd;

    private zzguu(zzgvk zzgvkVar, zzgdu zzgduVar, int i, byte[] bArr) {
        this.zza = zzgvkVar;
        this.zzb = zzgduVar;
        this.zzc = i;
        this.zzd = bArr;
    }

    public static zzgcy zzb(zzgev zzgevVar) throws GeneralSecurityException {
        zzgun zzgunVar = new zzgun(zzgevVar.zze().zzd(zzgdg.zza()), zzgevVar.zzd().zzd());
        String strValueOf = String.valueOf(String.valueOf(zzgevVar.zzd().zzg()));
        return new zzguu(zzgunVar, new zzgvp(new zzgvo("HMAC".concat(strValueOf), new SecretKeySpec(zzgevVar.zzf().zzd(zzgdg.zza()), "HMAC")), zzgevVar.zzd().zze()), zzgevVar.zzd().zze(), zzgevVar.zzb().zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzgcy
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzd;
        int length = bArr.length;
        int i = this.zzc;
        int length2 = bArr3.length;
        if (length < i + length2) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        }
        if (!zzgnx.zzc(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        int i2 = length - i;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, length2, i2);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i2, length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrCopyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        if (MessageDigest.isEqual(((zzgvp) this.zzb).zzc(zzgus.zzb(bArr2, bArrCopyOfRange, bArrCopyOf)), bArrCopyOfRange2)) {
            return this.zza.zza(bArrCopyOfRange);
        }
        throw new GeneralSecurityException("invalid MAC");
    }
}
