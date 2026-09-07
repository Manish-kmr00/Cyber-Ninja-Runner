package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h22<T extends View> implements Runnable {
    private final T b;
    private final zd<T> c;

    public h22(T view, zd<T> animator) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.b = view;
        this.c = animator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.b);
    }
}
