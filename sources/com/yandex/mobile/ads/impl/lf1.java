package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class lf1 implements zy1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9511a;
    private final zy1 b;
    private final zy1 c;

    public lf1(Context appContext, ob0 portraitSizeInfo, ob0 landscapeSizeInfo) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(portraitSizeInfo, "portraitSizeInfo");
        Intrinsics.checkNotNullParameter(landscapeSizeInfo, "landscapeSizeInfo");
        this.f9511a = appContext;
        this.b = portraitSizeInfo;
        this.c = landscapeSizeInfo;
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final int a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return hs.a(context) == gf1.c ? this.c.a(context) : this.b.a(context);
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final int b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return hs.a(context) == gf1.c ? this.c.b(context) : this.b.b(context);
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final int c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return hs.a(context) == gf1.c ? this.c.c(context) : this.b.c(context);
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final int d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return hs.a(context) == gf1.c ? this.c.d(context) : this.b.d(context);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lf1)) {
            return false;
        }
        lf1 lf1Var = (lf1) obj;
        return Intrinsics.areEqual(this.f9511a, lf1Var.f9511a) && Intrinsics.areEqual(this.b, lf1Var.b) && Intrinsics.areEqual(this.c, lf1Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f9511a.hashCode() * 31)) * 31);
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final int getWidth() {
        if (hs.a(this.f9511a) == gf1.c) {
            return this.c.getWidth();
        }
        return this.b.getWidth();
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final int getHeight() {
        if (hs.a(this.f9511a) == gf1.c) {
            return this.c.getHeight();
        }
        return this.b.getHeight();
    }

    @Override // com.yandex.mobile.ads.impl.zy1
    public final zy1.a a() {
        if (hs.a(this.f9511a) == gf1.c) {
            return this.c.a();
        }
        return this.b.a();
    }

    public final String toString() {
        if (hs.a(this.f9511a) == gf1.c) {
            return this.c.toString();
        }
        return this.b.toString();
    }
}
