package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class to1 {
    public static final to1 b = new to1(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10323a;

    public to1(boolean z) {
        this.f10323a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && to1.class == obj.getClass() && this.f10323a == ((to1) obj).f10323a;
    }

    public final int hashCode() {
        return !this.f10323a ? 1 : 0;
    }
}
