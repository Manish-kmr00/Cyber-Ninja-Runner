package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class zm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ym0 f10828a;

    public final ym0 a() {
        return this.f10828a;
    }

    public final void a(q70 instreamAdView, List<pb2> friendlyOverlays) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
        this.f10828a = new ym0(instreamAdView, friendlyOverlays);
    }

    public final void b() {
        this.f10828a = null;
    }
}
