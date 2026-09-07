package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeuy implements zzesv {
    final ScheduledExecutorService zza;

    public zzeuy(zzbtc zzbtcVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zza = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 49;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return zzgbs.zzm(zzgbs.zzo(zzgbs.zzh(new Bundle()), ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzer)).longValue(), TimeUnit.MILLISECONDS, this.zza), new zzftl() { // from class: com.google.android.gms.internal.ads.zzeux
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return new zzeuz((Bundle) obj);
            }
        }, zzbzk.zza);
    }
}
