package com.yandex.mobile.ads.impl;

import android.widget.FrameLayout;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class zk0 {
    private static final List<f92.a> b = CollectionsKt.listOf((Object[]) new f92.a[]{f92.a.c, f92.a.d, f92.a.i});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final al0 f10824a;

    public final void a(FrameLayout adView) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        this.f10824a.a(adView);
    }

    public /* synthetic */ zk0() {
        this(new al0());
    }

    public final void a(f92 validationResult, FrameLayout adView) {
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        Intrinsics.checkNotNullParameter(adView, "adView");
        this.f10824a.a(adView, validationResult, !b.contains(validationResult.b()));
    }

    public zk0(al0 renderer) {
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        this.f10824a = renderer;
    }
}
