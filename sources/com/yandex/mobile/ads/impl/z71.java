package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z71 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ie2 f10796a;
    private final j91 b;

    public z71(ie2 videoEventController, j91 nativeMediaContent) {
        Intrinsics.checkNotNullParameter(videoEventController, "videoEventController");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        this.f10796a = videoEventController;
        this.b = nativeMediaContent;
    }

    public final a81 a() {
        za1 za1VarA = this.b.a();
        if (za1VarA == null) {
            return null;
        }
        ie2 ie2Var = this.f10796a;
        return new a81(za1VarA, ie2Var, ie2Var);
    }
}
