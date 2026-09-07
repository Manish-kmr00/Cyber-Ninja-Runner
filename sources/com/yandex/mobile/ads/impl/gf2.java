package com.yandex.mobile.ads.impl;

import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class gf2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wb1 f8999a;
    private final jl1 b;

    public gf2(wb1 controlsConfigurator, jl1 progressBarConfigurator) {
        Intrinsics.checkNotNullParameter(controlsConfigurator, "controlsConfigurator");
        Intrinsics.checkNotNullParameter(progressBarConfigurator, "progressBarConfigurator");
        this.f8999a = controlsConfigurator;
        this.b = progressBarConfigurator;
    }

    public final void a(ub1 videoView) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.c().setVisibility(0);
        se2 placeholderView = videoView.b();
        this.b.getClass();
        Intrinsics.checkNotNullParameter(placeholderView, "placeholderView");
        placeholderView.b().setVisibility(8);
        ImageView imageViewA = placeholderView.a();
        if (imageViewA != null) {
            imageViewA.setVisibility(8);
        }
        this.f8999a.a(videoView.a().a());
    }
}
