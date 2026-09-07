package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbvf {
    private final WeakHashMap zza = new WeakHashMap();

    public final Future zzb(Context context) {
        return zzbzk.zza.zzb(new zzbvd(this, context));
    }
}
