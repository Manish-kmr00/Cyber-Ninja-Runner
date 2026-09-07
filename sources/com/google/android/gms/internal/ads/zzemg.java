package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzemg implements zzesv {
    private final Executor zza;
    private final zzbza zzb;

    zzemg(Executor executor, zzbza zzbzaVar) {
        this.zza = executor;
        this.zzb = zzbzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 10;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdd)).booleanValue() ? zzgbs.zzh(new zzemh(null)) : zzgbs.zzm(this.zzb.zzk(), new zzftl() { // from class: com.google.android.gms.internal.ads.zzemf
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                ArrayList arrayList = (ArrayList) obj;
                if (true == arrayList.isEmpty()) {
                    arrayList = null;
                }
                return new zzemh(arrayList);
            }
        }, this.zza);
    }
}
