package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class gg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f9000a;

    public gg(float f) {
        this.f9000a = f == 0.0f ? 1.7777778f : f;
    }

    public final int b(int i) {
        return Math.round(i * this.f9000a);
    }

    public final int a(int i) {
        return Math.round(i / this.f9000a);
    }
}
