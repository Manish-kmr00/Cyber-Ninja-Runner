package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class mg2 implements ld2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kg2 f9637a;

    public mg2(kg2 videoViewProvider) {
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        this.f9637a = videoViewProvider;
    }

    @Override // com.yandex.mobile.ads.impl.ld2
    public final boolean a() {
        View view = this.f9637a.getView();
        return (view == null || oh2.d(view) || !oh2.a(view, 50)) ? false : true;
    }
}
