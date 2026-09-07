package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgpa {
    static {
        int i = zzgtw.zza;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzgph.zzc();
        zzgom.zzc();
        zzgou.zza(true);
        if (zzgkp.zzb()) {
            return;
        }
        zzgoe.zzd(true);
    }
}
