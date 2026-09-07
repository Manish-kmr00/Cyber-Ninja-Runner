package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ql0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ct f10032a;

    public ql0(ct instreamAdBinder) {
        Intrinsics.checkNotNullParameter(instreamAdBinder, "instreamAdBinder");
        this.f10032a = instreamAdBinder;
    }

    public final void a(q70 instreamAdView, List<pb2> friendlyOverlays) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
        this.f10032a.a(instreamAdView, friendlyOverlays);
    }

    public final void b() {
        this.f10032a.d();
    }

    public final void a() {
        this.f10032a.c();
    }
}
