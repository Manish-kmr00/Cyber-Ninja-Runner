package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzffb {
    final /* synthetic */ zzffl zza;
    private final Object zzb;
    private final List zzc;

    /* synthetic */ zzffb(zzffl zzfflVar, Object obj, List list, zzffk zzffkVar) {
        this.zza = zzfflVar;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzffj zza(Callable callable) {
        List list = this.zzc;
        zzgbq zzgbqVarZzb = zzgbs.zzb(list);
        ListenableFuture listenableFutureZza = zzgbqVarZzb.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzffa
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return null;
            }
        }, zzbzk.zzg);
        zzffl zzfflVar = this.zza;
        return new zzffj(zzfflVar, this.zzb, listenableFutureZza, list, zzgbqVarZzb.zza(callable, zzfflVar.zzb));
    }
}
