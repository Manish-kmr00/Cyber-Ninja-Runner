package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes6.dex */
public final class ut {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f10416a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ut) && Float.compare(this.f10416a, ((ut) obj).f10416a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f10416a);
    }

    public final String toString() {
        return "CoreNativeAdMedia(aspectRatio=" + this.f10416a + ")";
    }

    public ut(float f) {
        this.f10416a = f;
    }

    public final float a() {
        return this.f10416a;
    }
}
