package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzgvp implements zzgdu {
    private static final byte[] zza = {0};
    private final zzgqc zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzgvp(zzgoa zzgoaVar) throws GeneralSecurityException {
        this.zzb = new zzgvm(zzgoaVar.zze().zzd(zzgdg.zza()));
        this.zzc = zzgoaVar.zzc().zzb();
        this.zzd = zzgoaVar.zzd().zzd();
        if (zzgoaVar.zzc().zzf().equals(zzgog.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzgdu zza(zzgoa zzgoaVar) throws GeneralSecurityException {
        return new zzgvp(zzgoaVar);
    }

    public static zzgdu zzb(zzgop zzgopVar) throws GeneralSecurityException {
        return new zzgvp(zzgopVar);
    }

    public final byte[] zzc(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        return bArr2.length > 0 ? zzgus.zzb(this.zzd, this.zzb.zza(zzgus.zzb(bArr, bArr2), this.zzc)) : zzgus.zzb(this.zzd, this.zzb.zza(bArr, this.zzc));
    }

    private zzgvp(zzgop zzgopVar) throws GeneralSecurityException {
        String strValueOf = String.valueOf(String.valueOf(zzgopVar.zzc().zzf()));
        this.zzb = new zzgvo("HMAC".concat(strValueOf), new SecretKeySpec(zzgopVar.zze().zzd(zzgdg.zza()), "HMAC"));
        this.zzc = zzgopVar.zzc().zzb();
        this.zzd = zzgopVar.zzd().zzd();
        if (zzgopVar.zzc().zzg().equals(zzgox.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzgvp(zzgqc zzgqcVar, int i) throws GeneralSecurityException {
        this.zzb = zzgqcVar;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        zzgqcVar.zza(new byte[0], i);
    }
}
