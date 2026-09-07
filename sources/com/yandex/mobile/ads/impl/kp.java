package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class kp implements z<x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mp1 f9442a;
    private final l51 b;

    public kp(mp1 reporter, l51 nativeAdEventController) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(nativeAdEventController, "nativeAdEventController");
        this.f9442a = reporter;
        this.b = nativeAdEventController;
    }

    @Override // com.yandex.mobile.ads.impl.z
    public final df0 a(View view, x action) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(action, "action");
        this.b.a();
        this.f9442a.a(hp1.b.D);
        return new df0(false);
    }
}
