package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
abstract class zzyi {
    public final int zza;
    public final zzbm zzb;
    public final int zzc;
    public final zzz zzd;

    public zzyi(int i, zzbm zzbmVar, int i2) {
        this.zza = i;
        this.zzb = zzbmVar;
        this.zzc = i2;
        this.zzd = zzbmVar.zzb(i2);
    }

    public abstract int zzb();

    public abstract boolean zzc(zzyi zzyiVar);
}
