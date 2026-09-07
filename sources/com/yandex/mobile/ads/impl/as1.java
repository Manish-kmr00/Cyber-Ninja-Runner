package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class as1 implements du {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ur1 f8438a;
    private final pm1 b;
    private final ht0 c;
    private final dt0 d;
    private final AtomicBoolean e;
    private final ps f;

    public as1(Context context, ur1 rewardedAdContentController, pm1 proxyRewardedAdShowListener, ht0 mainThreadUsageValidator, dt0 mainThreadExecutor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rewardedAdContentController, "rewardedAdContentController");
        Intrinsics.checkNotNullParameter(proxyRewardedAdShowListener, "proxyRewardedAdShowListener");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        this.f8438a = rewardedAdContentController;
        this.b = proxyRewardedAdShowListener;
        this.c = mainThreadUsageValidator;
        this.d = mainThreadExecutor;
        this.e = new AtomicBoolean(false);
        this.f = rewardedAdContentController.n();
        rewardedAdContentController.a(proxyRewardedAdShowListener);
    }

    @Override // com.yandex.mobile.ads.impl.du
    public final void show(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.c.a();
        this.d.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.as1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                as1.a(this.f$0, activity);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.du
    public final void a(um2 um2Var) {
        this.c.a();
        this.b.a(um2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(as1 this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (!this$0.e.getAndSet(true)) {
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(this$0.f8438a.a(activity));
            if (thM7907exceptionOrNullimpl != null) {
                this$0.b.a(new q6(String.valueOf(thM7907exceptionOrNullimpl.getMessage())));
                return;
            }
            return;
        }
        this$0.b.a(r6.b());
    }

    @Override // com.yandex.mobile.ads.impl.du
    public final ps getInfo() {
        return this.f;
    }
}
