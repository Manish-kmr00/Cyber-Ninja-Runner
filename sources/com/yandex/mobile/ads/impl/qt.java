package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class qt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Bitmap> f10046a;
    private final String b;
    private final int c;
    private final int d;

    public qt(Function0<Bitmap> getBitmap, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(getBitmap, "getBitmap");
        this.f10046a = getBitmap;
        this.b = str;
        this.c = i;
        this.d = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qt)) {
            return false;
        }
        qt qtVar = (qt) obj;
        return Intrinsics.areEqual(this.f10046a, qtVar.f10046a) && Intrinsics.areEqual(this.b, qtVar.b) && this.c == qtVar.c && this.d == qtVar.d;
    }

    public final int hashCode() {
        int iHashCode = this.f10046a.hashCode() * 31;
        String str = this.b;
        return Integer.hashCode(this.d) + wx1.a(this.c, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
    }

    public final String toString() {
        return "CoreNativeAdImage(getBitmap=" + this.f10046a + ", sizeType=" + this.b + ", width=" + this.c + ", height=" + this.d + ")";
    }

    public final String c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final int b() {
        return this.d;
    }

    public final Bitmap a() {
        return this.f10046a.invoke();
    }
}
