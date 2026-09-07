package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
public final class bd2 implements ed2.a, tc2.a {
    static final /* synthetic */ KProperty<Object>[] k = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(bd2.class, "adParameterManager", "getAdParameterManager()Lcom/monetization/ads/video/render/report/VideoAdRenderingResultReporter$ResponseReportParameterManager;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(bd2.class, "requestParameterManager", "getRequestParameterManager()Lcom/monetization/ads/video/render/report/VideoAdRenderingResultReporter$RequestReportParameterManager;", 0))};
    private static final long l = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g5 f8497a;
    private final eg2 b;
    private final ig1 c;
    private final ed2 d;
    private final tc2 e;
    private final dd2 f;
    private final xe2 g;
    private boolean h;
    private final zc2 i;
    private final ad2 j;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(bd2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(new pc2(pc2.a.i, new s00()));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bd2(Context context, o3 o3Var, o8 o8Var, rb2 rb2Var, g5 g5Var, id2 id2Var, kg2 kg2Var, mf2 mf2Var, fg2 fg2Var) {
        this(context, o3Var, o8Var, rb2Var, g5Var, id2Var, kg2Var, mf2Var, fg2Var, ig1.a.a(false));
        int i = ig1.f9217a;
    }

    public final void c() {
        this.d.b();
        this.e.b();
        this.c.stop();
    }

    public final void d() {
        this.d.b();
        this.e.b();
        this.c.stop();
    }

    public bd2(Context context, o3 adConfiguration, o8 o8Var, rb2 videoAdInfo, g5 adLoadingPhasesManager, id2 videoAdStatusController, kg2 videoViewProvider, mf2 renderValidator, fg2 videoTracker, ig1 pausableTimer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(videoAdStatusController, "videoAdStatusController");
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        Intrinsics.checkNotNullParameter(renderValidator, "renderValidator");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(pausableTimer, "pausableTimer");
        this.f8497a = adLoadingPhasesManager;
        this.b = videoTracker;
        this.c = pausableTimer;
        this.d = new ed2(renderValidator, this);
        this.e = new tc2(videoAdStatusController, this);
        this.f = new dd2(context, adConfiguration, o8Var, adLoadingPhasesManager);
        this.g = new xe2(videoAdInfo, videoViewProvider);
        Delegates delegates = Delegates.INSTANCE;
        this.i = new zc2(this);
        this.j = new ad2(this);
    }

    public final void a(pc2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.d.b();
        this.e.b();
        this.c.stop();
        if (this.h) {
            return;
        }
        this.h = true;
        String lowerCase = error.a().name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String message = error.b().getMessage();
        if (message == null) {
            message = "";
        }
        this.f.a(lowerCase, message);
    }

    public final void f() {
        this.d.a();
    }

    @Override // com.yandex.mobile.ads.impl.ed2.a
    public final void a() {
        this.d.b();
        g5 g5Var = this.f8497a;
        f5 f5Var = f5.w;
        ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
        this.b.i();
        this.e.a();
        this.c.a(l, new kg1() { // from class: com.yandex.mobile.ads.impl.bd2$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.kg1
            public final void a() {
                bd2.b(this.f$0);
            }
        });
    }

    public final void e() {
        this.h = false;
        this.f.b(null);
        this.d.b();
        this.e.b();
        this.c.stop();
    }

    @Override // com.yandex.mobile.ads.impl.tc2.a
    public final void b() {
        this.f.b(this.g.a());
        this.f8497a.a(f5.w);
        if (this.h) {
            return;
        }
        this.h = true;
        this.f.a();
    }

    public final void a(dd2.b bVar) {
        this.i.setValue(this, k[0], bVar);
    }

    public final void a(dd2.a aVar) {
        this.j.setValue(this, k[1], aVar);
    }
}
