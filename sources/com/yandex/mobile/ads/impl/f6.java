package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zn0 f8868a;

    public f6(zn0 instreamVastAdPlayer) {
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        this.f8868a = instreamVastAdPlayer;
    }

    public final void a(float f, boolean z) {
        zn0 zn0Var = this.f8868a;
        if (z) {
            f = 0.0f;
        }
        zn0Var.a(f);
    }
}
