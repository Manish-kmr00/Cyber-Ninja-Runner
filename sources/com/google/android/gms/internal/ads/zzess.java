package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzess implements zzesv {
    private final zzgcd zza;
    private final Context zzb;

    zzess(zzgcd zzgcdVar, Context context) {
        this.zza = zzgcdVar;
        this.zzb = context;
    }

    public static /* synthetic */ zzesr zzc(zzess zzessVar) {
        return new zzesr(com.google.android.gms.ads.internal.util.zzad.zzb(zzessVar.zzb, (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzge)));
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 37;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzess.zzc(this.zza);
            }
        });
    }
}
