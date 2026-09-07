package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzgkm extends ThreadLocal {
    zzgkm() {
    }

    protected static final Cipher zza() {
        try {
            Cipher cipher = (Cipher) zzgva.zza.zza("AES/GCM-SIV/NoPadding");
            if (zzgkn.zzd(cipher)) {
                return cipher;
            }
            return null;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
