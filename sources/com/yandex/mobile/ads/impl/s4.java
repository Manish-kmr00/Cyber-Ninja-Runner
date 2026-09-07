package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class s4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q4 f10166a;
    private final r4 b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s4(q4 q4Var) {
        this(q4Var, r4.a.a());
        int i = r4.e;
    }

    public s4(q4 adIdProvider, r4 adIdStorage) {
        Intrinsics.checkNotNullParameter(adIdProvider, "adIdProvider");
        Intrinsics.checkNotNullParameter(adIdStorage, "adIdStorage");
        this.f10166a = adIdProvider;
        this.b = adIdStorage;
    }

    public final void a() {
        String strA = this.f10166a.a();
        if (strA == null || strA.length() == 0) {
            return;
        }
        this.b.a(strA);
    }

    public final void b() {
        String strA = this.f10166a.a();
        if (strA == null || strA.length() == 0) {
            return;
        }
        this.b.b(strA);
    }
}
