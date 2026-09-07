package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class wk1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ye2 f10571a;

    public wk1(ye2 videoPlayerController) {
        Intrinsics.checkNotNullParameter(videoPlayerController, "videoPlayerController");
        this.f10571a = videoPlayerController;
    }

    public final boolean a() {
        return this.f10571a.c() <= 0;
    }
}
