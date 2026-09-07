package com.yandex.mobile.ads.impl;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class yf0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ag0 f10731a;
    private final xf0 b;
    private final Executor c;

    public final void a(final zf0 listener, final zs hostAccessChecker) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(hostAccessChecker, "hostAccessChecker");
        this.c.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.yf0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                yf0.a(this.f$0, hostAccessChecker, listener);
            }
        });
    }

    public /* synthetic */ yf0() {
        ag0 ag0Var = new ag0();
        xf0 xf0Var = new xf0();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this(ag0Var, xf0Var, executorServiceNewSingleThreadExecutor);
    }

    public yf0(ag0 hostAccessCheckRequester, xf0 hostAccessAdBlockerDetectionValidator, Executor singleThreadExecutor) {
        Intrinsics.checkNotNullParameter(hostAccessCheckRequester, "hostAccessCheckRequester");
        Intrinsics.checkNotNullParameter(hostAccessAdBlockerDetectionValidator, "hostAccessAdBlockerDetectionValidator");
        Intrinsics.checkNotNullParameter(singleThreadExecutor, "singleThreadExecutor");
        this.f10731a = hostAccessCheckRequester;
        this.b = hostAccessAdBlockerDetectionValidator;
        this.c = singleThreadExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(yf0 this$0, zs hostAccessChecker, zf0 listener) {
        Boolean boolA;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hostAccessChecker, "$hostAccessChecker");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        try {
            boolA = this$0.a(hostAccessChecker);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
            boolA = null;
        }
        listener.a(boolA);
    }

    private final Boolean a(zs hostAccessChecker) {
        this.f10731a.getClass();
        Intrinsics.checkNotNullParameter("yandex.ru", "host");
        Intrinsics.checkNotNullParameter(hostAccessChecker, "hostAccessChecker");
        FutureTask futureTask = new FutureTask(new cg0("yandex.ru", hostAccessChecker, new eg0(hostAccessChecker)));
        new Thread(futureTask).start();
        this.f10731a.getClass();
        Intrinsics.checkNotNullParameter("mobile.yandexadexchange.net", "host");
        Intrinsics.checkNotNullParameter(hostAccessChecker, "hostAccessChecker");
        FutureTask futureTask2 = new FutureTask(new cg0("mobile.yandexadexchange.net", hostAccessChecker, new eg0(hostAccessChecker)));
        new Thread(futureTask2).start();
        boolean zA = ((bg0) futureTask.get()).a();
        boolean zA2 = ((bg0) futureTask2.get()).a();
        this.b.getClass();
        if (!zA2 && zA) {
            return Boolean.TRUE;
        }
        if (zA2 || zA) {
            return Boolean.FALSE;
        }
        return null;
    }
}
