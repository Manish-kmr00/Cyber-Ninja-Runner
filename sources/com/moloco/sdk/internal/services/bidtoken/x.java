package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.internal.MolocoLogger;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class x {
    public static final boolean a(com.moloco.sdk.internal.bidtoken.a aVar, long j) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        long millis = TimeUnit.SECONDS.toMillis(aVar.a());
        long millis2 = TimeUnit.MINUTES.toMillis(2L);
        boolean z = j >= millis - millis2;
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, w.f, "[sbt] currentTimeInMillis: " + j + ", expirationTimeMillis: " + millis + ", expiredThresholdMillis: " + millis2 + ", expired: " + z, false, 4, null);
        return z;
    }

    public static final boolean b(com.moloco.sdk.internal.bidtoken.a aVar, long j) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        long millis = TimeUnit.SECONDS.toMillis(aVar.a());
        long millis2 = TimeUnit.MINUTES.toMillis(15L);
        boolean z = !a(aVar, j) && millis - j <= millis2;
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, w.f, "[sbt] currentTimeInMillis: " + j + ", expiryTimeMillis: " + millis + ", nearExpiryThresholdMillis: " + millis2 + ", expiring: " + z, false, 4, null);
        return z;
    }
}
