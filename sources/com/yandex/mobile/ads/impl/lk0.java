package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class lk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nx0<?, ?> f9532a;

    public lk0(nx0<?, ?> mediatedAdController) {
        Intrinsics.checkNotNullParameter(mediatedAdController, "mediatedAdController");
        this.f9532a = mediatedAdController;
    }

    public final t4 a() {
        hz0 hz0VarC;
        mx0<T> mx0VarA = this.f9532a.a();
        if (mx0VarA == 0 || (hz0VarC = mx0VarA.c()) == null) {
            return null;
        }
        return hz0VarC.c();
    }
}
