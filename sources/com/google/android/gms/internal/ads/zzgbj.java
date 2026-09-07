package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzgbj extends zzgbt {
    zzgbj() {
    }

    public static zzgbj zzE(ListenableFuture listenableFuture) {
        return listenableFuture instanceof zzgbj ? (zzgbj) listenableFuture : new zzgbk(listenableFuture);
    }
}
