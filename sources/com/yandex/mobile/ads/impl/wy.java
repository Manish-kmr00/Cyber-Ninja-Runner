package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class wy implements y32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10603a;
    private final o8<?> b;
    private final t8 c;
    private final t1 d;
    private final m50 e;
    private final WeakReference<Context> f;

    @Override // com.yandex.mobile.ads.impl.y32
    public final void a(mp1 reporter, String targetUrl) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        this.e.c().getClass();
        this.d.a(this.f.get(), this.f10603a, this.b, reporter, targetUrl, this.c, Intrinsics.areEqual((Object) null, Boolean.TRUE) || this.b.G());
    }

    public wy(Context context, t1 adActivityShowManager, o8 adResponse, t8 receiver, uu1 sdkEnvironmentModule, m50 environmentController, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(adActivityShowManager, "adActivityShowManager");
        Intrinsics.checkNotNullParameter(environmentController, "environmentController");
        this.f10603a = adConfiguration;
        this.b = adResponse;
        this.c = receiver;
        this.d = adActivityShowManager;
        this.e = environmentController;
        this.f = new WeakReference<>(context);
    }
}
