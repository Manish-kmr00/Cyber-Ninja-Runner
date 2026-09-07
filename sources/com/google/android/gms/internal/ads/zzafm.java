package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzafm {
    protected final zzaei zza;

    protected zzafm(zzaei zzaeiVar) {
        this.zza = zzaeiVar;
    }

    protected abstract boolean zza(zzek zzekVar) throws zzaz;

    protected abstract boolean zzb(zzek zzekVar, long j) throws zzaz;

    public final boolean zzf(zzek zzekVar, long j) throws zzaz {
        return zza(zzekVar) && zzb(zzekVar, j);
    }
}
