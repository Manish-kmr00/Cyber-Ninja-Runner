package com.yandex.mobile.ads.impl;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9587a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m10(p2 p2Var) {
        this(p2Var, xn0.a.a());
        int i = xn0.g;
    }

    public m10(p2 adBreak, xn0 instreamSettings) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(instreamSettings, "instreamSettings");
        this.f9587a = CollectionsKt.contains(instreamSettings.c(), adBreak.c());
    }

    public final boolean a() {
        return this.f9587a;
    }
}
