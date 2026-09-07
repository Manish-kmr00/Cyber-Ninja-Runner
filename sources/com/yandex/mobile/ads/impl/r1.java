package com.yandex.mobile.ads.impl;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class r1 implements m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f10064a;
    private final c1 b;
    private final u0 c;

    public r1(Activity activity, c1 adActivityData, u0 activityResultRegistrar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adActivityData, "adActivityData");
        Intrinsics.checkNotNullParameter(activityResultRegistrar, "activityResultRegistrar");
        this.f10064a = activity;
        this.b = adActivityData;
        this.c = activityResultRegistrar;
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void a() {
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void b() {
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void d() {
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final boolean e() {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void g() {
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void onAdClosed() {
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void c() {
        this.c.a(this.f10064a, this.b);
    }
}
