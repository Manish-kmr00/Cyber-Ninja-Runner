package com.yandex.mobile.ads.impl;

import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Typeface f8492a;
    private final Typeface b;
    private final Typeface c;
    private final Typeface d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bc0)) {
            return false;
        }
        bc0 bc0Var = (bc0) obj;
        return Intrinsics.areEqual(this.f8492a, bc0Var.f8492a) && Intrinsics.areEqual(this.b, bc0Var.b) && Intrinsics.areEqual(this.c, bc0Var.c) && Intrinsics.areEqual(this.d, bc0Var.d);
    }

    public final int hashCode() {
        Typeface typeface = this.f8492a;
        int iHashCode = (typeface == null ? 0 : typeface.hashCode()) * 31;
        Typeface typeface2 = this.b;
        int iHashCode2 = (iHashCode + (typeface2 == null ? 0 : typeface2.hashCode())) * 31;
        Typeface typeface3 = this.c;
        int iHashCode3 = (iHashCode2 + (typeface3 == null ? 0 : typeface3.hashCode())) * 31;
        Typeface typeface4 = this.d;
        return iHashCode3 + (typeface4 != null ? typeface4.hashCode() : 0);
    }

    public final String toString() {
        return "FontTypefaceData(light=" + this.f8492a + ", regular=" + this.b + ", medium=" + this.c + ", bold=" + this.d + ")";
    }

    public bc0(Typeface typeface, Typeface typeface2, Typeface typeface3, Typeface typeface4) {
        this.f8492a = typeface;
        this.b = typeface2;
        this.c = typeface3;
        this.d = typeface4;
    }

    public final Typeface b() {
        return this.f8492a;
    }

    public final Typeface d() {
        return this.b;
    }

    public final Typeface c() {
        return this.c;
    }

    public final Typeface a() {
        return this.d;
    }
}
