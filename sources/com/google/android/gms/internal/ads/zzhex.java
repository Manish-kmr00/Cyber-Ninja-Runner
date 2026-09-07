package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzhex implements zzhfh, zzhes {
    private static final Object zza = new Object();
    private volatile zzhfh zzb;
    private volatile Object zzc = zza;

    private zzhex(zzhfh zzhfhVar) {
        this.zzb = zzhfhVar;
    }

    public static zzhes zza(zzhfh zzhfhVar) {
        return zzhfhVar instanceof zzhes ? (zzhes) zzhfhVar : new zzhex(zzhfhVar);
    }

    public static zzhfh zzc(zzhfh zzhfhVar) {
        return zzhfhVar instanceof zzhex ? zzhfhVar : new zzhex(zzhfhVar);
    }

    private final synchronized Object zzd() {
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj != obj2) {
            return obj;
        }
        Object objZzb = this.zzb.zzb();
        Object obj3 = this.zzc;
        if (obj3 != obj2 && obj3 != objZzb) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objZzb + ". This is likely due to a circular dependency.");
        }
        this.zzc = objZzb;
        this.zzb = null;
        return objZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final Object zzb() {
        Object obj = this.zzc;
        return obj == zza ? zzd() : obj;
    }
}
