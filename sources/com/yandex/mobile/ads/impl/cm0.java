package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cm0 implements em0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8625a;
    private final uu1 b;
    private final ht0 c;
    private final dt0 d;
    private final CopyOnWriteArrayList<dm0> e;
    private ft f;

    public final void a(final gi2 requestConfig) {
        Intrinsics.checkNotNullParameter(requestConfig, "requestConfig");
        this.c.a();
        this.d.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.cm0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                cm0.a(this.f$0, requestConfig);
            }
        });
    }

    public /* synthetic */ cm0(Context context, uu1 uu1Var) {
        this(context, uu1Var, new ht0(context), new dt0());
    }

    public cm0(Context context, uu1 sdkEnvironmentModule, ht0 mainThreadUsageValidator, dt0 mainThreadExecutor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        this.f8625a = context;
        this.b = sdkEnvironmentModule;
        this.c = mainThreadUsageValidator;
        this.d = mainThreadExecutor;
        this.e = new CopyOnWriteArrayList<>();
        mainThreadUsageValidator.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(cm0 this$0, gi2 requestConfig) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestConfig, "$requestConfig");
        Context context = this$0.f8625a;
        uu1 uu1Var = this$0.b;
        int i = c32.d;
        dm0 dm0Var = new dm0(context, uu1Var, this$0, c32.a.a());
        this$0.e.add(dm0Var);
        dm0Var.a(this$0.f);
        dm0Var.a(requestConfig);
    }

    @Override // com.yandex.mobile.ads.impl.em0
    public final void a(dm0 nativeAdLoadingItem) {
        Intrinsics.checkNotNullParameter(nativeAdLoadingItem, "nativeAdLoadingItem");
        this.c.a();
        this.e.remove(nativeAdLoadingItem);
    }

    public final void a(ft ftVar) {
        this.c.a();
        this.f = ftVar;
        Iterator<T> it = this.e.iterator();
        while (it.hasNext()) {
            ((dm0) it.next()).a(ftVar);
        }
    }
}
