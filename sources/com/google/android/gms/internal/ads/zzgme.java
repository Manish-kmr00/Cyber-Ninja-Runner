package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgme {
    private static final zzgme zza = new zzgme();
    private final Map zzb = new HashMap();

    zzgme() {
    }

    public static zzgme zzb() {
        return zza;
    }

    public final synchronized zzgdv zza(String str) throws GeneralSecurityException {
        Map map;
        map = this.zzb;
        if (!map.containsKey("AES128_GCM")) {
            throw new GeneralSecurityException("Name AES128_GCM does not exist");
        }
        return (zzgdv) map.get("AES128_GCM");
    }

    public final synchronized void zzc(String str, zzgdv zzgdvVar) throws GeneralSecurityException {
        Map map = this.zzb;
        if (!map.containsKey(str)) {
            map.put(str, zzgdvVar);
            return;
        }
        if (((zzgdv) map.get(str)).equals(zzgdvVar)) {
            return;
        }
        throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + String.valueOf(map.get(str)) + "), cannot insert " + String.valueOf(zzgdvVar));
    }

    public final synchronized void zzd(Map map) throws GeneralSecurityException {
        for (Map.Entry entry : map.entrySet()) {
            zzc((String) entry.getKey(), (zzgdv) entry.getValue());
        }
    }
}
