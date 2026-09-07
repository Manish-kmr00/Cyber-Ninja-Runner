package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzepz implements zzesv {
    private final Context zza;
    private final zzgcd zzb;

    zzepz(zzgcd zzgcdVar, Context context) {
        this.zzb = zzgcdVar;
        this.zza = context;
    }

    public static /* synthetic */ zzeqa zzc(zzepz zzepzVar) {
        com.google.android.gms.ads.internal.zzv.zzq();
        return new zzeqa(com.google.android.gms.ads.internal.util.zzs.zzt(zzepzVar.zza));
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 57;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzepy
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzepz.zzc(this.zza);
            }
        });
    }
}
