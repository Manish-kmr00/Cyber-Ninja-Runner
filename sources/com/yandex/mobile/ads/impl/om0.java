package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class om0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jz1 f9834a;
    private final ql1 b;
    private final uo0 c;

    public final void a(vc2 progressEventsObservable) {
        Intrinsics.checkNotNullParameter(progressEventsObservable, "progressEventsObservable");
        progressEventsObservable.a(this.f9834a, this.b, this.c);
    }

    public /* synthetic */ om0(do0 do0Var, so0 so0Var, zn0 zn0Var, zm0 zm0Var, id2 id2Var) {
        this(do0Var, so0Var, zn0Var, zm0Var, id2Var, new jz1(zm0Var, do0Var), new ql1(zm0Var), new uo0(zn0Var, so0Var, id2Var));
    }

    public om0(do0 instreamVideoAd, so0 videoViewProvider, zn0 videoAdPlayer, zm0 adViewsHolderManager, id2 adStatusController, jz1 skipDisplayTracker, ql1 progressDisplayTracker, uo0 visibilityTracker) {
        Intrinsics.checkNotNullParameter(instreamVideoAd, "instreamVideoAd");
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(adViewsHolderManager, "adViewsHolderManager");
        Intrinsics.checkNotNullParameter(adStatusController, "adStatusController");
        Intrinsics.checkNotNullParameter(skipDisplayTracker, "skipDisplayTracker");
        Intrinsics.checkNotNullParameter(progressDisplayTracker, "progressDisplayTracker");
        Intrinsics.checkNotNullParameter(visibilityTracker, "visibilityTracker");
        this.f9834a = skipDisplayTracker;
        this.b = progressDisplayTracker;
        this.c = visibilityTracker;
    }
}
