package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o01 implements lp1 {
    private static final Object e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f9767a;
    private final boolean b;
    private final Executor c;
    private final Lazy d;

    public o01(lp1 lp1Var, Lazy<? extends j92> lazyVarioqubAdapter, boolean z, Executor executor) {
        Intrinsics.checkNotNullParameter(lazyVarioqubAdapter, "lazyVarioqubAdapter");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f9767a = lp1Var;
        this.b = z;
        this.c = executor;
        this.d = lazyVarioqubAdapter;
    }

    @Override // com.yandex.mobile.ads.impl.lp1
    public final void reportAnr(final Map<Thread, StackTraceElement[]> traces) {
        Intrinsics.checkNotNullParameter(traces, "traces");
        if (this.f9767a != null) {
            this.c.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.o01$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    o01.a(this.f$0, traces);
                }
            });
        } else {
            op0.d(new Object[0]);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lp1
    public final void reportError(final String message, final Throwable error) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(error, "error");
        if (this.b) {
            if (this.f9767a != null) {
                this.c.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.o01$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        o01.a(this.f$0, message, error);
                    }
                });
            } else {
                op0.d(new Object[0]);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.lp1
    public final void reportUnhandledException(final Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (this.f9767a != null) {
            this.c.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.o01$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    o01.a(this.f$0, throwable);
                }
            });
        } else {
            op0.d(new Object[0]);
        }
    }

    private static void a(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), ArraysKt.toList((Object[]) entry.getValue()));
        }
        String str = "reportAnr(), traces = " + linkedHashMap;
        op0.b(new Object[0]);
    }

    private static void a(String str, Throwable th) {
        String str2 = "reportError(), message = " + str + ", error = " + th;
        op0.b(new Object[0]);
    }

    private static void a(String str, Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), ArraysKt.contentDeepToString(new Object[]{entry.getValue()}));
        }
        String str2 = "reportEvent(), eventName = " + str + ", reportData = " + linkedHashMap;
        op0.a(new Object[0]);
    }

    private static void a(Throwable th) {
        String str = "reportUnhandledException(), throwable = " + th;
        op0.b(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(o01 this$0, Map traces) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(traces, "$traces");
        try {
            this$0.getClass();
            a(traces);
            this$0.f9767a.reportAnr(traces);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(o01 this$0, String message, Throwable error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "$message");
        Intrinsics.checkNotNullParameter(error, "$error");
        try {
            this$0.getClass();
            a(message, error);
            this$0.f9767a.reportError(message, error);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lp1
    public final void a(final hp1 report) {
        Intrinsics.checkNotNullParameter(report, "report");
        if (this.f9767a != null) {
            this.c.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.o01$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    o01.a(this.f$0, report);
                }
            });
        } else {
            op0.d(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(o01 this$0, hp1 report) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(report, "$report");
        try {
            k92.a((j92) this$0.d.getValue(), report);
            a(report.c(), report.b());
            this$0.f9767a.a(report);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(o01 this$0, Throwable throwable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(throwable, "$throwable");
        try {
            this$0.getClass();
            a(throwable);
            this$0.f9767a.reportUnhandledException(throwable);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lp1
    public final void a(boolean z) {
        lp1 lp1Var = this.f9767a;
        if (lp1Var != null) {
            lp1Var.a(z);
        }
    }
}
