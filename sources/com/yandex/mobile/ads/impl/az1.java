package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class az1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zy1 f8461a;

    public final zy1 a() {
        return this.f8461a;
    }

    public final void a(zy1 zy1Var) {
        if (zy1Var == null) {
            dp0.c("Ad size can't be null or empty.", new Object[0]);
            return;
        }
        zy1 zy1Var2 = this.f8461a;
        if (zy1Var2 != null && !Intrinsics.areEqual(zy1Var2, zy1Var)) {
            dp0.c("Ad size can't be set twice.", new Object[0]);
        } else {
            this.f8461a = zy1Var;
        }
    }
}
