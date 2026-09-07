package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zzglb {
    private final zzgvs zza;
    private final Class zzb;

    /* synthetic */ zzglb(zzgvs zzgvsVar, Class cls, zzgla zzglaVar) {
        this.zza = zzgvsVar;
        this.zzb = cls;
    }

    public static zzglb zzb(zzgkz zzgkzVar, zzgvs zzgvsVar, Class cls) {
        return new zzgky(zzgvsVar, cls, zzgkzVar);
    }

    public abstract zzgdh zza(zzgnp zzgnpVar, @Nullable zzgdz zzgdzVar) throws GeneralSecurityException;

    public final zzgvs zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
