package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzeso implements zzesv {
    private final boolean zza;

    zzeso(zzeyp zzeypVar) {
        this.zza = zzeypVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 36;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return zzgbs.zzh(new zzesm(this.zza, null));
    }
}
