package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class vy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mp1 f10517a;
    private final bf1 b;
    private final l51 c;
    private final zj1 d;

    public vy(o3 adConfiguration, o8 adResponse, mp1 reporter, n91 openUrlHandler, l51 nativeAdEventController, zj1 preferredPackagesViewer) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(openUrlHandler, "openUrlHandler");
        Intrinsics.checkNotNullParameter(nativeAdEventController, "nativeAdEventController");
        Intrinsics.checkNotNullParameter(preferredPackagesViewer, "preferredPackagesViewer");
        this.f10517a = reporter;
        this.b = openUrlHandler;
        this.c = nativeAdEventController;
        this.d = preferredPackagesViewer;
    }

    public final void a(Context context, ry action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        if (this.d.a(context, action.d())) {
            this.f10517a.a(hp1.b.F);
            this.c.d();
        } else {
            this.b.a(action.c());
        }
    }
}
