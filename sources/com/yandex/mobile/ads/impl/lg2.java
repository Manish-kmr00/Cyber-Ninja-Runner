package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class lg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kg2 f9514a;

    public lg2(kg2 videoViewProvider) {
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        this.f9514a = videoViewProvider;
    }

    public final boolean a() {
        View view = this.f9514a.getView();
        return (view == null || oh2.d(view) || oh2.b(view) < 1) ? false : true;
    }
}
