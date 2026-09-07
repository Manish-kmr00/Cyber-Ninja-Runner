package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class nm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bt f9742a;
    private final mm0 b;
    private lm0 c;

    public /* synthetic */ nm0(bt btVar, ye2 ye2Var) {
        this(btVar, ye2Var, new mm0(ye2Var));
    }

    public nm0(bt instreamVideoAd, ye2 videoPlayerController, mm0 instreamAdPlaylistCreator) {
        Intrinsics.checkNotNullParameter(instreamVideoAd, "instreamVideoAd");
        Intrinsics.checkNotNullParameter(videoPlayerController, "videoPlayerController");
        Intrinsics.checkNotNullParameter(instreamAdPlaylistCreator, "instreamAdPlaylistCreator");
        this.f9742a = instreamVideoAd;
        this.b = instreamAdPlaylistCreator;
    }

    public final lm0 a() {
        lm0 lm0Var = this.c;
        if (lm0Var != null) {
            return lm0Var;
        }
        lm0 lm0VarA = this.b.a(this.f9742a.a());
        this.c = lm0VarA;
        return lm0VarA;
    }
}
