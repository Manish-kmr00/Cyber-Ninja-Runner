package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zzgmn {
    private final zzgvs zza;
    private final Class zzb;

    /* synthetic */ zzgmn(zzgvs zzgvsVar, Class cls, zzgmm zzgmmVar) {
        this.zza = zzgvsVar;
        this.zzb = cls;
    }

    public static zzgmn zzb(zzgml zzgmlVar, zzgvs zzgvsVar, Class cls) {
        return new zzgmk(zzgvsVar, cls, zzgmlVar);
    }

    public abstract zzgdv zza(zzgnp zzgnpVar) throws GeneralSecurityException;

    public final zzgvs zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
