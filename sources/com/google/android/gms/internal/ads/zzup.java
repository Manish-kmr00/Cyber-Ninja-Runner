package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzup {
    private static final AtomicLong zza = new AtomicLong();

    public zzup(long j, zzgj zzgjVar, long j2) {
        Uri uri = zzgjVar.zza;
        Collections.emptyMap();
    }

    public zzup(long j, zzgj zzgjVar, Uri uri, Map map, long j2, long j3, long j4) {
    }

    public static long zza() {
        return zza.getAndIncrement();
    }
}
