package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfur implements zzfuo {
    private static final zzfuo zza = new zzfuo() { // from class: com.google.android.gms.internal.ads.zzfuq
        @Override // com.google.android.gms.internal.ads.zzfuo
        public final Object zza() {
            throw new IllegalStateException();
        }
    };
    private final zzfuv zzb = new zzfuv();
    private volatile zzfuo zzc;
    private Object zzd;

    zzfur(zzfuo zzfuoVar) {
        this.zzc = zzfuoVar;
    }

    public final String toString() {
        Object obj = this.zzc;
        if (obj == zza) {
            obj = "<supplier that returned " + String.valueOf(this.zzd) + ">";
        }
        return "Suppliers.memoize(" + String.valueOf(obj) + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzfuo
    public final Object zza() {
        zzfuo zzfuoVar = this.zzc;
        zzfuo zzfuoVar2 = zza;
        if (zzfuoVar != zzfuoVar2) {
            synchronized (this.zzb) {
                if (this.zzc != zzfuoVar2) {
                    Object objZza = this.zzc.zza();
                    this.zzd = objZza;
                    this.zzc = zzfuoVar2;
                    return objZza;
                }
            }
        }
        return this.zzd;
    }
}
