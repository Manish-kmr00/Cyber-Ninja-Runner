package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z90 extends ja0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f10801a;
    private final m90 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z90(o3 adConfiguration, ViewGroup nativeAdView, pt adEventListener, ie2 videoEventController, m90 feedItemBinder) {
        super(nativeAdView, 0);
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
        Intrinsics.checkNotNullParameter(adEventListener, "adEventListener");
        Intrinsics.checkNotNullParameter(videoEventController, "videoEventController");
        Intrinsics.checkNotNullParameter(feedItemBinder, "feedItemBinder");
        this.f10801a = nativeAdView;
        this.b = feedItemBinder;
    }

    public final void a(k90 feedItem) {
        Intrinsics.checkNotNullParameter(feedItem, "feedItem");
        m90 m90Var = this.b;
        Context context = this.f10801a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        m90Var.a(context, feedItem.a(), feedItem.c(), feedItem.b());
    }

    public final void a() {
        this.b.b();
    }
}
