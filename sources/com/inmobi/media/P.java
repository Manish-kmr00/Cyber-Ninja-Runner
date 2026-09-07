package com.inmobi.media;

import android.app.Activity;
import android.util.Log;
import com.inmobi.adquality.models.AdQualityResult;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class P implements InterfaceC3564t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ScheduledExecutorService f3162a;
    public static ExecutorService b;
    public static final Lazy c;
    public static N d;
    public static AdConfig e;

    static {
        P p = new P();
        c = LazyKt.lazy(O.f3152a);
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        Config configA = C3549s2.a("ads", C3517pb.b(), p);
        Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
        e = (AdConfig) configA;
    }

    public static void a(long j, final C3333d execute) {
        Intrinsics.checkNotNullParameter(execute, "execute");
        ScheduledExecutorService scheduledExecutorService = f3162a;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(5, new V4("AdQualityComponent-aqHandler"));
            Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewScheduledThreadPool, "newScheduledThreadPool(...)");
            f3162a = scheduledExecutorServiceNewScheduledThreadPool;
        }
        ScheduledExecutorService scheduledExecutorService2 = f3162a;
        if (scheduledExecutorService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aqHandlerExecutor");
            scheduledExecutorService2 = null;
        }
        scheduledExecutorService2.schedule(new Runnable() { // from class: com.inmobi.media.P$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                P.b(execute);
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public static final void b(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static void a(final C3319c execute) {
        Intrinsics.checkNotNullParameter(execute, "execute");
        ExecutorService executorService = b;
        if (executorService == null || executorService.isShutdown()) {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new V4("AdQualityComponent-aqBeacon"));
            Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
            b = executorServiceNewSingleThreadExecutor;
        }
        ExecutorService executorService2 = b;
        if (executorService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aqBeaconExecutor");
            executorService2 = null;
        }
        executorService2.submit(new Runnable() { // from class: com.inmobi.media.P$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                P.a(execute);
            }
        });
    }

    public static final void a(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // com.inmobi.media.InterfaceC3564t2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof AdConfig) {
            AdConfig adConfig = (AdConfig) config;
            e = adConfig;
            N n = d;
            if (n != null) {
                Intrinsics.checkNotNullParameter(adConfig, "adConfig");
                n.f3140a = adConfig;
                if (!n.b.get()) {
                    if (adConfig.getAdQuality().getEnabled()) {
                        n.a();
                        return;
                    }
                    return;
                }
                if (!n.b.get() || adConfig.getAdQuality().getEnabled()) {
                    return;
                }
                Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
                Intrinsics.checkNotNullParameter("kill switch encountered. shut down.", "message");
                Log.i("AdQualityBeaconExecutor", "kill switch encountered. shut down.");
                n.b.set(false);
                ExecutorService executorService = b;
                if (executorService != null) {
                    executorService.shutdown();
                    try {
                        try {
                            executorService.shutdownNow();
                        } catch (Exception e2) {
                            Intrinsics.checkNotNullParameter("AdQualityComponent", "tag");
                            Intrinsics.checkNotNullParameter("shutdown fail", "message");
                            Log.e("AdQualityComponent", "shutdown fail", e2);
                            Thread.currentThread().interrupt();
                        }
                    } catch (InterruptedException unused) {
                        executorService.shutdownNow();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static void a(Activity activity, Ba renderView, String beaconUrl, boolean z, JSONObject extras, C3543ra listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(beaconUrl, "url");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Z adQualityManager = renderView.getAdQualityManager();
        adQualityManager.getClass();
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(beaconUrl, "url");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(listener, "listener");
        N n = null;
        if (extras.length() > 0 && beaconUrl.length() > 0) {
            adQualityManager.j = beaconUrl;
            adQualityManager.k = extras;
            adQualityManager.a("report ad starting");
            if (z) {
                adQualityManager.a("report ad capture");
                adQualityManager.a(activity, 0L, true, listener);
            } else {
                adQualityManager.a("report ad report");
                adQualityManager.a(new AdQualityResult("", null, beaconUrl, extras.toString()), false);
            }
        } else {
            listener.f3417a.b("window.mraidview.broadcastEvent('AdReportFailed')");
            adQualityManager.a((Exception) null, "Incorrect parameters for reporting. url - " + beaconUrl + " , extras - " + extras);
        }
        N n2 = d;
        if (n2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
        } else {
            n = n2;
        }
        n.getClass();
        Intrinsics.checkNotNullParameter(beaconUrl, "beaconUrl");
        Intrinsics.checkNotNullParameter(listener, "listener");
        n.d.put(beaconUrl, new WeakReference(listener));
        String creativeID = renderView.getCreativeID();
        if (creativeID.length() > 0) {
            Lazy lazy = c;
            if (((CopyOnWriteArrayList) lazy.getValue()).size() < e.getAdReport().getCridls()) {
                ((CopyOnWriteArrayList) lazy.getValue()).add(creativeID);
            }
        }
    }

    public static void a(Ba view, Ba renderView, String beaconUrl, boolean z, JSONObject extras, C3543ra listener) {
        Intrinsics.checkNotNullParameter(view, "adView");
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(beaconUrl, "url");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Z adQualityManager = renderView.getAdQualityManager();
        adQualityManager.getClass();
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(beaconUrl, "url");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(listener, "listener");
        N n = null;
        if (extras.length() > 0 && beaconUrl.length() > 0) {
            adQualityManager.j = beaconUrl;
            adQualityManager.k = extras;
            if (z) {
                adQualityManager.a(view, 0L, true, listener);
            } else {
                adQualityManager.a(new AdQualityResult("", null, beaconUrl, extras.toString()), false);
            }
        } else {
            listener.f3417a.b("window.mraidview.broadcastEvent('AdReportFailed')");
            adQualityManager.a((Exception) null, "Incorrect parameters for reporting. url - " + beaconUrl + " , extras - " + extras);
        }
        N n2 = d;
        if (n2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
        } else {
            n = n2;
        }
        n.getClass();
        Intrinsics.checkNotNullParameter(beaconUrl, "beaconUrl");
        Intrinsics.checkNotNullParameter(listener, "listener");
        n.d.put(beaconUrl, new WeakReference(listener));
        String creativeID = renderView.getCreativeID();
        if (creativeID.length() > 0) {
            Lazy lazy = c;
            if (((CopyOnWriteArrayList) lazy.getValue()).size() < e.getAdReport().getCridls()) {
                ((CopyOnWriteArrayList) lazy.getValue()).add(creativeID);
            }
        }
    }
}
