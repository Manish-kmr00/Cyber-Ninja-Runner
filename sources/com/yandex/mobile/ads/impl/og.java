package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class og {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ig<?>> f9814a;
    private final i3 b;
    private final po1 c;
    private final mk0 d;
    private final rr0 e;

    /* JADX WARN: Multi-variable type inference failed */
    public og(List<? extends ig<?>> assets, i3 adClickHandler, po1 renderedTimer, mk0 impressionEventsObservable, rr0 rr0Var) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(adClickHandler, "adClickHandler");
        Intrinsics.checkNotNullParameter(renderedTimer, "renderedTimer");
        Intrinsics.checkNotNullParameter(impressionEventsObservable, "impressionEventsObservable");
        this.f9814a = assets;
        this.b = adClickHandler;
        this.c = renderedTimer;
        this.d = impressionEventsObservable;
        this.e = rr0Var;
    }

    public final ng a(bp clickListenerFactory, c71 viewAdapter) {
        Intrinsics.checkNotNullParameter(clickListenerFactory, "clickListenerFactory");
        Intrinsics.checkNotNullParameter(viewAdapter, "viewAdapter");
        return new ng(clickListenerFactory, this.f9814a, this.b, viewAdapter, this.c, this.d, this.e);
    }
}
