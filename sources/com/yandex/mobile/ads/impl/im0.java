package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class im0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a82 f9243a;
    private final fm0 b;

    public im0(a82 unifiedInstreamAdBinder) {
        Intrinsics.checkNotNullParameter(unifiedInstreamAdBinder, "unifiedInstreamAdBinder");
        this.f9243a = unifiedInstreamAdBinder;
        this.b = fm0.c.a();
    }

    public final void a(gt player) {
        Intrinsics.checkNotNullParameter(player, "player");
        a82 a82VarA = this.b.a(player);
        if (Intrinsics.areEqual(this.f9243a, a82VarA)) {
            return;
        }
        if (a82VarA != null) {
            a82VarA.invalidateAdPlayer();
        }
        this.b.a(player, this.f9243a);
    }

    public final void b(gt player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.b.b(player);
    }
}
