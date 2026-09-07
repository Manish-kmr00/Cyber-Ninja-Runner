package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzbyr {
    public final ListenableFuture zza(Context context, int i) {
        zzbzp zzbzpVar = new zzbzp();
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        if (com.google.android.gms.ads.internal.util.client.zzf.zzu(context)) {
            zzbzk.zza.execute(new zzbyq(this, context, zzbzpVar));
        }
        return zzbzpVar;
    }
}
