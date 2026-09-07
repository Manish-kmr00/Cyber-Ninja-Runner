package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdzc {
    private final zzbus zza;

    zzdzc(zzbus zzbusVar) {
        this.zza = zzbusVar;
    }

    public final void zza() {
        ListenableFuture listenableFutureZza = this.zza.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhM)).booleanValue()) {
            zzbzn.zzb(listenableFutureZza, "persistFlags");
        } else {
            zzbzn.zza(listenableFutureZza, "persistFlags");
        }
    }
}
