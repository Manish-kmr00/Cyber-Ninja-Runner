package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bg implements rs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uf f8507a;
    private final lm1 b;
    private final ht0 c;
    private final dt0 d;
    private final AtomicBoolean e;
    private final ps f;

    public bg(Context context, uf appOpenAdContentController, lm1 proxyAppOpenAdShowListener, ht0 mainThreadUsageValidator, dt0 mainThreadExecutor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appOpenAdContentController, "appOpenAdContentController");
        Intrinsics.checkNotNullParameter(proxyAppOpenAdShowListener, "proxyAppOpenAdShowListener");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        this.f8507a = appOpenAdContentController;
        this.b = proxyAppOpenAdShowListener;
        this.c = mainThreadUsageValidator;
        this.d = mainThreadExecutor;
        this.e = new AtomicBoolean(false);
        this.f = appOpenAdContentController.n();
        appOpenAdContentController.a(proxyAppOpenAdShowListener);
    }

    @Override // com.yandex.mobile.ads.impl.rs
    public final void show(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.c.a();
        this.d.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.bg$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                bg.a(this.f$0, activity);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.rs
    public final void a(il2 il2Var) {
        this.c.a();
        this.b.a(il2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(bg this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (!this$0.e.getAndSet(true)) {
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(this$0.f8507a.a(activity));
            if (thM7907exceptionOrNullimpl != null) {
                this$0.b.a(new q6(String.valueOf(thM7907exceptionOrNullimpl.getMessage())));
                return;
            }
            return;
        }
        this$0.b.a(r6.b());
    }

    @Override // com.yandex.mobile.ads.impl.rs
    public final ps getInfo() {
        return this.f;
    }
}
