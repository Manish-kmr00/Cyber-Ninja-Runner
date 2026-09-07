package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j31 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c31 f9284a;
    private final long b;

    public j31(c31 multiBannerAutoSwipeController, long j) {
        Intrinsics.checkNotNullParameter(multiBannerAutoSwipeController, "multiBannerAutoSwipeController");
        this.f9284a = multiBannerAutoSwipeController;
        this.b = j;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.f9284a.a(this.b);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.f9284a.b();
    }
}
