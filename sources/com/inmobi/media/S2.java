package com.inmobi.media;

import android.net.Network;
import android.os.SystemClock;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.unity3d.services.UnityAdsConstants;
import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class S2 implements InterfaceC3564t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AdConfig.CustomNetworkValidation f3187a;
    public static volatile Network b;
    public static volatile boolean c;
    public static long d;
    public static long e;
    public static final AtomicBoolean f;

    static {
        S2 s2 = new S2();
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        Config configA = C3549s2.a("ads", C3517pb.b(), s2);
        Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
        f3187a = ((AdConfig) configA).getCustomNwValidation();
        c = true;
        f = new AtomicBoolean(false);
    }

    public static void a(final Network network) {
        long nonValidatedExpiry;
        long j = e;
        if (j != 0) {
            ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
            AdConfig.CustomNetworkValidation customNetworkValidation = f3187a;
            if (jElapsedRealtime < (customNetworkValidation != null ? customNetworkValidation.getRefreshDebounceTime() : 1000L)) {
                return;
            }
        }
        e = SystemClock.elapsedRealtime();
        if (Intrinsics.areEqual(b, network)) {
            long j2 = d;
            ScheduledExecutorService scheduledExecutorService2 = Ec.f3062a;
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - j2;
            if (c) {
                AdConfig.CustomNetworkValidation customNetworkValidation2 = f3187a;
                nonValidatedExpiry = customNetworkValidation2 != null ? customNetworkValidation2.getValidatedExpiry() : UnityAdsConstants.Timeout.INIT_TIMEOUT_MS;
            } else {
                AdConfig.CustomNetworkValidation customNetworkValidation3 = f3187a;
                nonValidatedExpiry = customNetworkValidation3 != null ? customNetworkValidation3.getNonValidatedExpiry() : 30000L;
            }
            if (jElapsedRealtime2 <= nonValidatedExpiry) {
                return;
            }
        }
        if (f.compareAndSet(false, true)) {
            ((ScheduledThreadPoolExecutor) S3.c.getValue()).execute(new Runnable() { // from class: com.inmobi.media.S2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    S2.b(network);
                }
            });
        }
    }

    public static final void b(Network network) {
        boolean z;
        String urlDomain;
        Intrinsics.checkNotNullParameter(network, "$network");
        try {
            try {
                AdConfig.CustomNetworkValidation customNetworkValidation = f3187a;
                z = (customNetworkValidation == null || (urlDomain = customNetworkValidation.getUrlDomain()) == null) ? false : !Intrinsics.areEqual(InetAddress.getByName(urlDomain).toString(), "");
            } catch (Exception unused) {
            }
            try {
                c = z;
                b = network;
                d = SystemClock.elapsedRealtime();
            } catch (Exception e2) {
                C3339d5 c3339d5 = C3339d5.f3292a;
                P1 event = new P1(e2);
                Intrinsics.checkNotNullParameter(event, "event");
                C3339d5.c.a(event);
            }
            f.set(false);
        } catch (Throwable th) {
            f.set(false);
            throw th;
        }
    }

    @Override // com.inmobi.media.InterfaceC3564t2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof AdConfig) {
            f3187a = ((AdConfig) config).getCustomNwValidation();
        }
    }
}
