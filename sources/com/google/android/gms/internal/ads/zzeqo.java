package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeqo implements zzesv {
    private final zzgcd zza;
    private final zzdud zzb;

    zzeqo(zzgcd zzgcdVar, zzdud zzdudVar) {
        this.zza = zzgcdVar;
        this.zzb = zzdudVar;
    }

    public static /* synthetic */ zzeqp zzc(zzeqo zzeqoVar) {
        zzdud zzdudVar = zzeqoVar.zzb;
        return new zzeqp(zzdudVar.zzc(), zzdudVar.zzr(), com.google.android.gms.ads.internal.zzv.zzt().zzl(), zzdudVar.zzp(), zzdudVar.zzs());
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 23;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeqn
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeqo.zzc(this.zza);
            }
        });
    }
}
