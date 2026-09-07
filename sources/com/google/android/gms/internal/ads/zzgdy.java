package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgdy {
    static {
        Logger.getLogger(zzgdy.class.getName());
        new ConcurrentHashMap();
        HashSet hashSet = new HashSet();
        hashSet.add(zzgcy.class);
        hashSet.add(zzgdd.class);
        hashSet.add(zzgea.class);
        hashSet.add(zzgdf.class);
        hashSet.add(zzgde.class);
        hashSet.add(zzgdu.class);
        hashSet.add(zzgqc.class);
        hashSet.add(zzgdw.class);
        hashSet.add(zzgdx.class);
        Collections.unmodifiableSet(hashSet);
    }

    private zzgdy() {
    }

    public static Object zza(zzgsp zzgspVar, Class cls) throws GeneralSecurityException {
        String strZzg = zzgspVar.zzg();
        return zzgkx.zzc().zza(strZzg, cls).zzc(zzgspVar.zzf());
    }
}
