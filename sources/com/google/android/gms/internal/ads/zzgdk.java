package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgdk {
    public static final zzgdv zza(zzgdv zzgdvVar) throws GeneralSecurityException {
        return zzgdvVar != null ? zzgdvVar : zzgeb.zza(zzb(null).zzaV());
    }

    static final zzgst zzb(zzgdv zzgdvVar) {
        try {
            return ((zzgnm) zzgmi.zzc().zze(null, zzgnm.class)).zzc();
        } catch (GeneralSecurityException e) {
            throw new zzgnw("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat("null"), e);
        }
    }
}
