package com.yandex.mobile.ads.impl;

import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class y72 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f10710a;
    private final Thread.UncaughtExceptionHandler b;
    private final cu1 c;

    public y72(lp1 reporter, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, cu1 sdkConfiguration) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        this.f10710a = reporter;
        this.b = uncaughtExceptionHandler;
        this.c = sdkConfiguration;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable throwable) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        try {
            Set<b60> setQ = this.c.q();
            if (setQ == null) {
                setQ = SetsKt.emptySet();
            }
            StackTraceElement[] stackTrace = throwable.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "getStackTrace(...)");
            if (c22.a(stackTrace, setQ)) {
                this.f10710a.reportUnhandledException(throwable);
            }
            if (this.c.p() || (uncaughtExceptionHandler2 = this.b) == null) {
                return;
            }
        } catch (Throwable th) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.f10710a.reportError("Failed to report uncaught exception", th);
                Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m7904constructorimpl(ResultKt.createFailure(th2));
                } finally {
                    if (!this.c.p() && (uncaughtExceptionHandler = this.b) != null) {
                        uncaughtExceptionHandler.uncaughtException(thread, throwable);
                    }
                }
            }
            if (this.c.p() || uncaughtExceptionHandler == null) {
                return;
            }
        }
        uncaughtExceptionHandler2.uncaughtException(thread, throwable);
    }
}
