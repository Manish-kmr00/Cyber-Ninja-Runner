package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zzgmr {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgmr(Class cls, Class cls2, zzgmq zzgmqVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgmr zzb(zzgmp zzgmpVar, Class cls, Class cls2) {
        return new zzgmo(cls, cls2, zzgmpVar);
    }

    public abstract zzgnp zza(zzgdv zzgdvVar) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
