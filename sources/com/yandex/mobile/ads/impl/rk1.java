package com.yandex.mobile.ads.impl;

import com.yandex.div.core.view2.Div2View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rk1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y20 f10115a;
    private final Div2View b;
    private final to c;
    private final s20 d;

    public rk1(y20 divKitDesign, Div2View preloadedDivView, to clickConnector, s20 clickHandler) {
        Intrinsics.checkNotNullParameter(divKitDesign, "divKitDesign");
        Intrinsics.checkNotNullParameter(preloadedDivView, "preloadedDivView");
        Intrinsics.checkNotNullParameter(clickConnector, "clickConnector");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        this.f10115a = divKitDesign;
        this.b = preloadedDivView;
        this.c = clickConnector;
        this.d = clickHandler;
    }

    public final y20 c() {
        return this.f10115a;
    }

    public final Div2View d() {
        return this.b;
    }

    public final to a() {
        return this.c;
    }

    public final s20 b() {
        return this.d;
    }
}
