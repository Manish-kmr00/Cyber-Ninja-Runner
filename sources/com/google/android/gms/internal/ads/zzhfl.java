package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhfl implements zzhfh {
    private static final Object zza = new Object();
    private volatile zzhfh zzb;
    private volatile Object zzc = zza;

    private zzhfl(zzhfh zzhfhVar) {
        this.zzb = zzhfhVar;
    }

    public static zzhfh zza(zzhfh zzhfhVar) {
        return ((zzhfhVar instanceof zzhfl) || (zzhfhVar instanceof zzhex)) ? zzhfhVar : new zzhfl(zzhfhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final Object zzb() {
        Object obj = this.zzc;
        if (obj != zza) {
            return obj;
        }
        zzhfh zzhfhVar = this.zzb;
        if (zzhfhVar == null) {
            return this.zzc;
        }
        Object objZzb = zzhfhVar.zzb();
        this.zzc = objZzb;
        this.zzb = null;
        return objZzb;
    }
}
