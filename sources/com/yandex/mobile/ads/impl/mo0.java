package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class mo0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ct f9660a;
    private final lo0 b;

    public mo0(ct instreamAdBinder) {
        Intrinsics.checkNotNullParameter(instreamAdBinder, "instreamAdBinder");
        this.f9660a = instreamAdBinder;
        this.b = lo0.c.a();
    }

    public final void a(ju player) {
        Intrinsics.checkNotNullParameter(player, "player");
        ct ctVarA = this.b.a(player);
        if (Intrinsics.areEqual(this.f9660a, ctVarA)) {
            return;
        }
        if (ctVarA != null) {
            ctVarA.a();
        }
        this.b.a(player, this.f9660a);
    }

    public final void b(ju player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.b.b(player);
    }
}
