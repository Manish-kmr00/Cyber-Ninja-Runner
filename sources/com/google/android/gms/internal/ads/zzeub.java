package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeub implements zzesv {
    private final Executor zza;
    private final String zzb;

    public zzeub(zzbyr zzbyrVar, Executor executor, String str, PackageInfo packageInfo, int i) {
        this.zza = executor;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 41;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        ListenableFuture listenableFutureZzh = zzgbs.zzh(this.zzb);
        zzftl zzftlVar = new zzftl() { // from class: com.google.android.gms.internal.ads.zzetz
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return new zzeuc((String) obj);
            }
        };
        Executor executor = this.zza;
        return zzgbs.zzf(zzgbs.zzm(listenableFutureZzh, zzftlVar, executor), Throwable.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzeua
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzgbs.zzh(new zzeuc(this.zza.zzb));
            }
        }, executor);
    }
}
