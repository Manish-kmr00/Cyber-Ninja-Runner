package com.yandex.mobile.ads.impl;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9602a;
    private final RectF b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m70)) {
            return false;
        }
        m70 m70Var = (m70) obj;
        return this.f9602a == m70Var.f9602a && Intrinsics.areEqual(this.b, m70Var.b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f9602a) * 31;
        RectF rectF = this.b;
        return iHashCode + (rectF == null ? 0 : rectF.hashCode());
    }

    public final String toString() {
        return "Exposure(exposedPercentage=" + this.f9602a + ", visibleRectangle=" + this.b + ")";
    }

    public m70(int i, RectF rectF) {
        this.f9602a = i;
        this.b = rectF;
    }

    public final int a() {
        return this.f9602a;
    }

    public final RectF b() {
        return this.b;
    }
}
