package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class ym0 {
    static final /* synthetic */ KProperty<Object>[] c = {ta.a(ym0.class, "view", "getView()Lcom/monetization/ads/instream/view/ExtendedInstreamAdView;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<pb2> f10752a;
    private final zn1 b;

    public ym0(q70 instreamAdView, List<pb2> friendlyOverlays) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
        this.f10752a = friendlyOverlays;
        this.b = ao1.a(instreamAdView);
    }

    public final List<pb2> a() {
        return this.f10752a;
    }

    public final q70 b() {
        return (q70) this.b.getValue(this, c[0]);
    }
}
