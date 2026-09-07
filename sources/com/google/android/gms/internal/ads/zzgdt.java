package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgdt {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzgds zza(String str) throws GeneralSecurityException {
        for (zzgds zzgdsVar : zza) {
            if (zzgdsVar.zza()) {
                return zzgdsVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
