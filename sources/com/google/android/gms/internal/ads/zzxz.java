package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzxz implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzxz(zzz zzzVar, int i) {
        this.zza = 1 == (zzzVar.zze & 1);
        this.zzb = zzlv.zza(i, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxz zzxzVar) {
        return zzfwl.zzj().zzd(this.zzb, zzxzVar.zzb).zzd(this.zza, zzxzVar.zza).zza();
    }
}
