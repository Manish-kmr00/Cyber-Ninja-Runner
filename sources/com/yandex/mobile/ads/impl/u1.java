package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class u1 implements y32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<String> f10346a;
    private final o3 b;
    private final t8 c;
    private final t1 d;
    private final m50 e;
    private final WeakReference<Context> f;

    @Override // com.yandex.mobile.ads.impl.y32
    public final void a(mp1 reporter, String targetUrl) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        this.e.c().getClass();
        this.d.a(this.f.get(), this.b, this.f10346a, reporter, targetUrl, this.c, Intrinsics.areEqual((Object) null, Boolean.TRUE) || this.f10346a.G());
    }

    public u1(Context context, t1 adActivityShowManager, o8 adResponse, t8 resultReceiver, uu1 sdkEnvironmentModule, m50 environmentController, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        Intrinsics.checkNotNullParameter(adActivityShowManager, "adActivityShowManager");
        Intrinsics.checkNotNullParameter(environmentController, "environmentController");
        this.f10346a = adResponse;
        this.b = adConfiguration;
        this.c = resultReceiver;
        this.d = adActivityShowManager;
        this.e = environmentController;
        this.f = new WeakReference<>(context);
    }

    public /* synthetic */ u1(Context context, o8 o8Var, t8 t8Var, uu1 uu1Var, o3 o3Var) {
        t1 t1Var = new t1(uu1Var);
        int i = m50.e;
        this(context, t1Var, o8Var, t8Var, uu1Var, m50.a.a(context), o3Var);
    }
}
