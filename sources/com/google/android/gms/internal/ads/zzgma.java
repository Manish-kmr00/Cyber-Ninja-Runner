package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgma {
    private static final zzgma zza = new zzgma();
    private final Map zzb = new HashMap();

    public static zzgma zza() {
        return zza;
    }

    public final synchronized void zzb(zzglz zzglzVar, Class cls) throws GeneralSecurityException {
        Map map = this.zzb;
        zzglz zzglzVar2 = (zzglz) map.get(cls);
        if (zzglzVar2 != null && !zzglzVar2.equals(zzglzVar)) {
            throw new GeneralSecurityException("Different key creator for parameters class already inserted");
        }
        map.put(cls, zzglzVar);
    }
}
