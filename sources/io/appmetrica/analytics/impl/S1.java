package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class S1 implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean e = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ma f11341a;
    public final C4264lc b = C4455t4.i().l();
    public final C4557x6 c = new C4557x6();
    public final C4001an d = new C4001an();

    public S1(C4482u6 c4482u6) {
        this.f11341a = c4482u6;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTraceElementArrB;
        try {
            e.set(true);
            Ma ma = this.f11341a;
            Tm tmApply = this.c.apply(thread);
            C4001an c4001an = this.d;
            Thread threadA = c4001an.f11468a.a();
            ArrayList arrayListA = c4001an.a(threadA, thread);
            if (thread != threadA) {
                try {
                    stackTraceElementArrB = c4001an.f11468a.b();
                    if (stackTraceElementArrB == null) {
                        try {
                            stackTraceElementArrB = threadA.getStackTrace();
                        } catch (SecurityException unused) {
                        }
                    }
                } catch (SecurityException unused2) {
                    stackTraceElementArrB = null;
                }
                arrayListA.add(0, (Tm) c4001an.b.apply(threadA, stackTraceElementArrB));
            }
            ma.a(th, new S(tmApply, arrayListA, this.b.b()));
        } catch (Throwable th2) {
            LoggerStorage.getMainPublicOrAnonymousLogger().error(th2, th2.getMessage(), new Object[0]);
        }
    }
}
