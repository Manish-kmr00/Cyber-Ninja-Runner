package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgzb {
    zzgzb() {
    }

    public static final boolean zza(Object obj) {
        return !((zzgza) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzgza zzgzaVarZzb = (zzgza) obj;
        zzgza zzgzaVar = (zzgza) obj2;
        if (!zzgzaVar.isEmpty()) {
            if (!zzgzaVarZzb.zze()) {
                zzgzaVarZzb = zzgzaVarZzb.zzb();
            }
            zzgzaVarZzb.zzd(zzgzaVar);
        }
        return zzgzaVarZzb;
    }
}
