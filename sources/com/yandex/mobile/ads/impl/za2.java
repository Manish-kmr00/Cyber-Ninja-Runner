package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class za2 implements Comparable<za2> {
    private final int b;
    private final int c;
    private final int d;

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(za2 other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i = this.b;
        int i2 = other.b;
        if (i != i2) {
            return Intrinsics.compare(i, i2);
        }
        int i3 = this.c;
        int i4 = other.c;
        return i3 != i4 ? Intrinsics.compare(i3, i4) : Intrinsics.compare(this.d, other.d);
    }

    public za2(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public final int a() {
        return this.b;
    }
}
