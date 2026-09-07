package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgeb {
    public static zzgdv zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzgst zzgstVarZzf = zzgst.zzf(bArr, zzgxf.zza());
            zzgmi zzgmiVarZzc = zzgmi.zzc();
            zzgnm zzgnmVarZza = zzgnm.zza(zzgstVarZzf);
            return !zzgmiVarZzc.zzk(zzgnmVarZza) ? new zzgln(zzgnmVarZza) : zzgmiVarZzc.zzb(zzgnmVarZza);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] zzb(zzgdv zzgdvVar) throws GeneralSecurityException {
        return ((zzgnm) zzgmi.zzc().zze(zzgdvVar, zzgnm.class)).zzc().zzaV();
    }
}
