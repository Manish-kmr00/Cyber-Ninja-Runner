package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes7.dex */
public final class ob0 implements zy1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zy1.a f9803a;
    private final int b;
    private final int c;
    private final String d;

    public ob0(int i, int i2, zy1.a sizeType) {
        Intrinsics.checkNotNullParameter(sizeType, "sizeType");
        this.f9803a = sizeType;
        this.b = (i >= 0 || -1 == i) ? i : 0;
        this.c = (i2 >= 0 || -2 == i2) ? i2 : 0;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%dx%d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        this.d = str;
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final int a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = this.c;
        return -2 == i ? oh2.b(context) : i;
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final int b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = this.c;
        if (-2 != i) {
            return oh2.a(context, i);
        }
        int i2 = oh2.b;
        return bb0.a(context, "context").heightPixels;
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final int c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = this.b;
        return -1 == i ? oh2.c(context) : i;
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final int d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = this.b;
        if (-1 != i) {
            return oh2.a(context, i);
        }
        int i2 = oh2.b;
        return bb0.a(context, "context").widthPixels;
    }

    public final int hashCode() {
        return this.f9803a.hashCode() + v3.a(this.d, ((this.b * 31) + this.c) * 31, 31);
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final zy1.a a() {
        return this.f9803a;
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final int getWidth() {
        return this.b;
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final int getHeight() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(ob0.class, obj.getClass())) {
            return false;
        }
        ob0 ob0Var = (ob0) obj;
        if (this.b != ob0Var.b) {
            return false;
        }
        return this.c == ob0Var.c && this.f9803a == ob0Var.f9803a;
    }

    public final String toString() {
        return this.d;
    }
}
