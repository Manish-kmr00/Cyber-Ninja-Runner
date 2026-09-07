package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgkx {
    private static final Logger zza = Logger.getLogger(zzgkx.class.getName());
    private static final zzgkx zzb = new zzgkx();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    public static zzgkx zzc() {
        return zzb;
    }

    private final synchronized zzgdi zzg(String str) throws GeneralSecurityException {
        ConcurrentMap concurrentMap;
        concurrentMap = this.zzc;
        if (!concurrentMap.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str + ", see https://developers.google.com/tink/faq/registration_errors");
        }
        return (zzgdi) concurrentMap.get(str);
    }

    private final synchronized void zzh(zzgdi zzgdiVar, boolean z, boolean z2) throws GeneralSecurityException {
        String str = ((zzgli) zzgdiVar).zza;
        ConcurrentMap concurrentMap = this.zzd;
        if (concurrentMap.containsKey(str) && !((Boolean) concurrentMap.get(str)).booleanValue()) {
            throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
        }
        ConcurrentMap concurrentMap2 = this.zzc;
        zzgdi zzgdiVar2 = (zzgdi) concurrentMap2.get(str);
        if (zzgdiVar2 != null && !zzgdiVar2.getClass().equals(zzgdiVar.getClass())) {
            zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type ".concat(str));
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, zzgdiVar2.getClass().getName(), zzgdiVar.getClass().getName()));
        }
        concurrentMap2.putIfAbsent(str, zzgdiVar);
        concurrentMap.put(str, true);
    }

    public final zzgdi zza(String str, Class cls) throws GeneralSecurityException {
        zzgdi zzgdiVarZzg = zzg(str);
        if (zzgdiVarZzg.zzb().equals(cls)) {
            return zzgdiVarZzg;
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + String.valueOf(zzgdiVarZzg.getClass()) + ", which only supports: " + zzgdiVarZzg.zzb().toString());
    }

    public final zzgdi zzb(String str) throws GeneralSecurityException {
        return zzg(str);
    }

    public final synchronized void zzd(zzgdi zzgdiVar, boolean z) throws GeneralSecurityException {
        zzf(zzgdiVar, 1, true);
    }

    public final boolean zze(String str) {
        return ((Boolean) this.zzd.get(str)).booleanValue();
    }

    public final synchronized void zzf(zzgdi zzgdiVar, int i, boolean z) throws GeneralSecurityException {
        if (!zzgko.zza(i)) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        zzh(zzgdiVar, false, true);
    }
}
