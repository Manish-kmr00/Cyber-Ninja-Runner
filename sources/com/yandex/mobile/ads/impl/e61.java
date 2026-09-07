package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e61 implements h61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8766a;
    private final uu1 b;
    private final List<g61> c;
    private final ht0 d;
    private final dt0 e;
    private st f;
    private yt g;
    private hu h;

    public final void b(final v7 adRequestData, final r61 requestPolicy) {
        final y91 nativeResponseType = y91.e;
        final ba1 sourceType = ba1.c;
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(nativeResponseType, "nativeResponseType");
        Intrinsics.checkNotNullParameter(sourceType, "sourceType");
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        this.d.a();
        this.e.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.e61$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                e61.b(adRequestData, nativeResponseType, sourceType, requestPolicy, this);
            }
        });
    }

    public /* synthetic */ e61(Context context, wm2 wm2Var) {
        this(context, wm2Var, new CopyOnWriteArrayList(), new ht0(context), new dt0(), null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(v7 adRequestData, y91 nativeResponseType, ba1 sourceType, aq1 requestPolicy, e61 this$0) {
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        Intrinsics.checkNotNullParameter(nativeResponseType, "$nativeResponseType");
        Intrinsics.checkNotNullParameter(sourceType, "$sourceType");
        Intrinsics.checkNotNullParameter(requestPolicy, "$requestPolicy");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g61 g61Var = new g61(this$0.f8766a, this$0.b, new q61(adRequestData, nativeResponseType, sourceType, requestPolicy, 1), this$0);
        this$0.c.add(g61Var);
        g61Var.a(this$0.h);
        g61Var.c();
    }

    public e61(Context context, wm2 sdkEnvironmentModule, List nativeAdLoadingItems, ht0 mainThreadUsageValidator, dt0 mainThreadExecutor, st stVar, yt ytVar, hu huVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(nativeAdLoadingItems, "nativeAdLoadingItems");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        this.f8766a = context;
        this.b = sdkEnvironmentModule;
        this.c = nativeAdLoadingItems;
        this.d = mainThreadUsageValidator;
        this.e = mainThreadExecutor;
        this.f = stVar;
        this.g = ytVar;
        this.h = huVar;
        mainThreadUsageValidator.a();
    }

    public final void a() {
        this.d.a();
        this.e.a();
        Iterator<g61> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.c.clear();
    }

    public final void a(final v7 adRequestData, final r61 requestPolicy) {
        final y91 nativeResponseType = y91.c;
        final ba1 sourceType = ba1.c;
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(nativeResponseType, "nativeResponseType");
        Intrinsics.checkNotNullParameter(sourceType, "sourceType");
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        this.d.a();
        this.e.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.e61$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                e61.a(adRequestData, nativeResponseType, sourceType, requestPolicy, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(v7 adRequestData, y91 nativeResponseType, ba1 sourceType, aq1 requestPolicy, e61 this$0) {
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        Intrinsics.checkNotNullParameter(nativeResponseType, "$nativeResponseType");
        Intrinsics.checkNotNullParameter(sourceType, "$sourceType");
        Intrinsics.checkNotNullParameter(requestPolicy, "$requestPolicy");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g61 g61Var = new g61(this$0.f8766a, this$0.b, new q61(adRequestData, nativeResponseType, sourceType, requestPolicy, 1), this$0);
        this$0.c.add(g61Var);
        g61Var.a(this$0.f);
        g61Var.c();
    }

    public final void a(final v7 adRequestData, final r61 requestPolicy, final int i) {
        final y91 nativeResponseType = y91.d;
        final ba1 sourceType = ba1.c;
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(nativeResponseType, "nativeResponseType");
        Intrinsics.checkNotNullParameter(sourceType, "sourceType");
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        this.d.a();
        this.e.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.e61$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                e61.a(adRequestData, nativeResponseType, sourceType, requestPolicy, i, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(v7 adRequestData, y91 nativeResponseType, ba1 sourceType, aq1 requestPolicy, int i, e61 this$0) {
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        Intrinsics.checkNotNullParameter(nativeResponseType, "$nativeResponseType");
        Intrinsics.checkNotNullParameter(sourceType, "$sourceType");
        Intrinsics.checkNotNullParameter(requestPolicy, "$requestPolicy");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g61 g61Var = new g61(this$0.f8766a, this$0.b, new q61(adRequestData, nativeResponseType, sourceType, requestPolicy, i), this$0);
        this$0.c.add(g61Var);
        g61Var.a(this$0.g);
        g61Var.c();
    }

    @Override // com.yandex.mobile.ads.impl.h61
    public final void a(g61 nativeAdLoadingItem) {
        Intrinsics.checkNotNullParameter(nativeAdLoadingItem, "nativeAdLoadingItem");
        this.d.a();
        this.c.remove(nativeAdLoadingItem);
    }

    public final void a(st stVar) {
        this.d.a();
        this.f = stVar;
        Iterator<g61> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(stVar);
        }
    }

    public final void a(qm2 qm2Var) {
        this.d.a();
        this.g = qm2Var;
        Iterator<g61> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(qm2Var);
        }
    }

    public final void a(zm2 zm2Var) {
        this.d.a();
        this.h = zm2Var;
        Iterator<g61> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(zm2Var);
        }
    }
}
