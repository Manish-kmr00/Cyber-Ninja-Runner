package com.yandex.mobile.ads.impl;

import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class qt0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<T> f10047a;

    public qt0(Queue<T> queue) {
        Intrinsics.checkNotNullParameter(queue, "queue");
        this.f10047a = queue;
    }

    public final int a() {
        return this.f10047a.size();
    }

    public final T b() {
        return this.f10047a.poll();
    }
}
