package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzdd {
    private static Executor zza;

    public static synchronized Executor zza() {
        if (zza == null) {
            zza = zzeu.zzF("ExoPlayer:BackgroundExecutor");
        }
        return zza;
    }
}
