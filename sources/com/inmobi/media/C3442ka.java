package com.inmobi.media;

import android.content.Context;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.CrashConfig;
import com.inmobi.commons.core.configs.TelemetryConfig;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: renamed from: com.inmobi.media.ka, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3442ka implements InterfaceC3564t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC3396h6 f3360a;
    public static C3468m6 b;
    public static final AtomicBoolean c;
    public static TelemetryConfig d;
    public static CrashConfig e;
    public static final ReentrantLock f;
    public static final C3428ja g;
    public static final ReferenceQueue h;
    public static final ConcurrentHashMap i;
    public static final AtomicBoolean j;

    static {
        C3442ka c3442ka = new C3442ka();
        f3360a = EnumC3396h6.ERROR;
        c = new AtomicBoolean(false);
        f = new ReentrantLock();
        g = C3428ja.f3348a;
        h = new ReferenceQueue();
        i = new ConcurrentHashMap();
        j = new AtomicBoolean(false);
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        Config configA = C3549s2.a("telemetry", C3517pb.b(), c3442ka);
        Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.TelemetryConfig");
        d = (TelemetryConfig) configA;
        Config configA2 = C3549s2.a("crashReporting", C3517pb.b(), c3442ka);
        Intrinsics.checkNotNull(configA2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.CrashConfig");
        e = (CrashConfig) configA2;
    }

    public static M4 a(String logType, String placementType, boolean z) {
        Intrinsics.checkNotNullParameter(logType, "logType");
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        Context context = C3517pb.d();
        if (context == null) {
            return null;
        }
        try {
            b();
            TelemetryConfig.LoggingConfig loggingConfig = d.getLoggingConfig();
            double dB = b(logType, placementType, loggingConfig);
            EnumC3396h6 logLevel = a(logType, placementType, loggingConfig);
            boolean z2 = !loggingConfig.getEnabled();
            long expiry = loggingConfig.getExpiry() * ((long) 1000);
            int maxNoOfEntries = loggingConfig.getMaxNoOfEntries();
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            return new M4(context, dB, logLevel, z2, z, maxNoOfEntries, expiry, false);
        } catch (Exception e2) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e2, "event"));
            return null;
        }
    }

    public static void b() {
        if (b == null && f.tryLock()) {
            try {
                if (b == null && c.get()) {
                    Context contextD = C3517pb.d();
                    if (contextD != null) {
                        TelemetryConfig.LoggingConfig loggingConfig = d.getLoggingConfig();
                        b = new C3468m6(contextD, loggingConfig.getLoggingUrl(), loggingConfig.getRetryInterval() * ((long) 1000), loggingConfig.getExpiry(), loggingConfig.getMaxRetries(), loggingConfig.getMaxNoOfEntries());
                    }
                    C3468m6 c3468m6 = b;
                    if (c3468m6 != null) {
                        P4.a(c3468m6);
                    }
                }
            } finally {
                f.unlock();
            }
        }
    }

    public static final void c() throws InterruptedException {
        WeakReference weakReference;
        L4 l4;
        while (c.get()) {
            Reference referenceRemove = h.remove();
            ConcurrentHashMap concurrentHashMap = i;
            if (CollectionsKt.contains(concurrentHashMap.keySet(), referenceRemove)) {
                Pair pair = (Pair) concurrentHashMap.get(referenceRemove);
                if (pair != null && (weakReference = (WeakReference) pair.getSecond()) != null && (l4 = (L4) weakReference.get()) != null) {
                    ((M4) l4).a("ReferenceTracker", " reference " + ((String) pair.getFirst()) + " reference is GCed.");
                }
                TypeIntrinsics.asMutableMap(concurrentHashMap).remove(referenceRemove);
            }
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                if (((WeakReference) ((Pair) entry.getValue()).getSecond()).get() == null) {
                    i.remove(entry.getKey());
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static EnumC3396h6 a(String str, String str2, TelemetryConfig.LoggingConfig loggingConfig) {
        switch (str.hashCode()) {
            case -1396342996:
                if (str.equals("banner")) {
                    if (Intrinsics.areEqual(str2, "AB")) {
                        return AbstractC3410i6.a(loggingConfig.getBanner().getAb().getLogLevel());
                    }
                    return AbstractC3410i6.a(loggingConfig.getBanner().getNonAb().getLogLevel());
                }
                break;
            case -1052618729:
                if (str.equals("native")) {
                    if (Intrinsics.areEqual(str2, "AB")) {
                        return AbstractC3410i6.a(loggingConfig.getNative().getAb().getLogLevel());
                    }
                    return AbstractC3410i6.a(loggingConfig.getNative().getNonAb().getLogLevel());
                }
                break;
            case -171121434:
                if (str.equals("intNative")) {
                    if (Intrinsics.areEqual(str2, "AB")) {
                        return AbstractC3410i6.a(loggingConfig.getInt_native().getAb().getLogLevel());
                    }
                    return AbstractC3410i6.a(loggingConfig.getInt_native().getNonAb().getLogLevel());
                }
                break;
            case 93166550:
                if (str.equals("audio")) {
                    return AbstractC3410i6.a(loggingConfig.getAudio().getNonAb().getLogLevel());
                }
                break;
            case 1957200954:
                if (str.equals("intHtml")) {
                    if (Intrinsics.areEqual(str2, "AB")) {
                        return AbstractC3410i6.a(loggingConfig.getInt_html().getAb().getLogLevel());
                    }
                    return AbstractC3410i6.a(loggingConfig.getInt_html().getNonAb().getLogLevel());
                }
                break;
            case 1966366787:
                if (str.equals("getToken")) {
                    return AbstractC3410i6.a(loggingConfig.getGetToken().getLogLevel());
                }
                break;
        }
        return f3360a;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static double b(String str, String str2, TelemetryConfig.LoggingConfig loggingConfig) {
        switch (str.hashCode()) {
            case -1396342996:
                if (!str.equals("banner")) {
                    return 0.01d;
                }
                if (Intrinsics.areEqual(str2, "AB")) {
                    return loggingConfig.getBanner().getAb().getSamplePercent();
                }
                return loggingConfig.getBanner().getNonAb().getSamplePercent();
            case -1052618729:
                if (!str.equals("native")) {
                    return 0.01d;
                }
                if (Intrinsics.areEqual(str2, "AB")) {
                    return loggingConfig.getNative().getAb().getSamplePercent();
                }
                return loggingConfig.getNative().getNonAb().getSamplePercent();
            case -171121434:
                if (!str.equals("intNative")) {
                    return 0.01d;
                }
                if (Intrinsics.areEqual(str2, "AB")) {
                    return loggingConfig.getInt_native().getAb().getSamplePercent();
                }
                return loggingConfig.getInt_native().getNonAb().getSamplePercent();
            case 93166550:
                if (str.equals("audio")) {
                    return loggingConfig.getAudio().getNonAb().getSamplePercent();
                }
                return 0.01d;
            case 1957200954:
                if (!str.equals("intHtml")) {
                    return 0.01d;
                }
                if (Intrinsics.areEqual(str2, "AB")) {
                    return loggingConfig.getInt_html().getAb().getSamplePercent();
                }
                return loggingConfig.getInt_html().getNonAb().getSamplePercent();
            case 1966366787:
                if (str.equals("getToken")) {
                    return loggingConfig.getGetToken().getSamplePercent();
                }
                return 0.01d;
            default:
                return 0.01d;
        }
    }

    public static void a(Object obj, L4 l4) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            if (d.getLoggingConfig().getEnabled()) {
                if (l4 != null) {
                    ((M4) l4).a("RemoteLoggerComponent", "starting to track reference of " + obj);
                }
                if (l4 != null) {
                    i.put(new PhantomReference(obj, h), new Pair(obj.toString(), new WeakReference(l4)));
                    if (j.getAndSet(true)) {
                        return;
                    }
                    ScheduledExecutorService scheduledExecutorService = AbstractC3554s6.f3426a;
                    Runnable runnable = new Runnable() { // from class: com.inmobi.media.ka$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() throws InterruptedException {
                            C3442ka.c();
                        }
                    };
                    Intrinsics.checkNotNullParameter("RemoteLoggerComponent", "tag");
                    Intrinsics.checkNotNullParameter(runnable, "runnable");
                    try {
                        AbstractC3554s6.b.submit(runnable);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e2) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e2, "event"));
        }
    }

    @Override // com.inmobi.media.InterfaceC3564t2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof TelemetryConfig) {
            d = (TelemetryConfig) config;
            C3468m6 c3468m6 = b;
            if (c3468m6 != null) {
                c3468m6.g.set(true);
            }
            b = null;
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.ka$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3442ka.a();
                }
            };
            ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            Ec.f3062a.execute(runnable);
            return;
        }
        if (config instanceof CrashConfig) {
            e = (CrashConfig) config;
        }
    }

    public static final void a() {
        b();
    }
}
