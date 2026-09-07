package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bp1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dp1 f8530a;

    public bp1(jg2 videoViewAdapter, fp1 replayController) {
        Intrinsics.checkNotNullParameter(videoViewAdapter, "videoViewAdapter");
        Intrinsics.checkNotNullParameter(replayController, "replayController");
        this.f8530a = new dp1(videoViewAdapter, replayController, this);
    }

    public static void b(ap1 replayActionView) {
        Intrinsics.checkNotNullParameter(replayActionView, "replayActionView");
        replayActionView.setBackground(null);
        replayActionView.setVisibility(8);
        replayActionView.a().setOnClickListener(null);
    }

    public final void a(ap1 replayActionView) {
        Intrinsics.checkNotNullParameter(replayActionView, "replayActionView");
        replayActionView.setVisibility(4);
        replayActionView.a().setOnClickListener(this.f8530a);
    }
}
