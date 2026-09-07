package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zzglf {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzglf(Class cls, Class cls2, zzgle zzgleVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzglf zzb(zzgld zzgldVar, Class cls, Class cls2) {
        return new zzglc(cls, cls2, zzgldVar);
    }

    public abstract zzgnp zza(zzgdh zzgdhVar, @Nullable zzgdz zzgdzVar) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
