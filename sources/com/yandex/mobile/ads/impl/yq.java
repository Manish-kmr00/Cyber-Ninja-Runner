package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class yq<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y00<V>[] f10763a;

    @SafeVarargs
    public yq(y00<V>... designComponentBinders) {
        Intrinsics.checkNotNullParameter(designComponentBinders, "designComponentBinders");
        this.f10763a = designComponentBinders;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        Intrinsics.checkNotNullParameter(container, "container");
        for (y00<V> y00Var : this.f10763a) {
            y00Var.a(container);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        for (y00<V> y00Var : this.f10763a) {
            y00Var.c();
        }
    }
}
