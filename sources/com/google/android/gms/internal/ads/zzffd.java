package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzffd {
    public static final zzffj zza(Callable callable, Object obj, zzffl zzfflVar) {
        return zzb(callable, zzfflVar.zzb, obj, zzfflVar);
    }

    public static final zzffj zzb(Callable callable, zzgcd zzgcdVar, Object obj, zzffl zzfflVar) {
        return new zzffj(zzfflVar, obj, zzffl.zza, Collections.emptyList(), zzgcdVar.zzb(callable));
    }

    public static final zzffj zzc(ListenableFuture listenableFuture, Object obj, zzffl zzfflVar) {
        return new zzffj(zzfflVar, obj, zzffl.zza, Collections.emptyList(), listenableFuture);
    }

    public static final zzffj zzd(final zzfey zzfeyVar, zzgcd zzgcdVar, Object obj, zzffl zzfflVar) {
        return zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzffc
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                zzfeyVar.zza();
                return null;
            }
        }, zzgcdVar, obj, zzfflVar);
    }
}
