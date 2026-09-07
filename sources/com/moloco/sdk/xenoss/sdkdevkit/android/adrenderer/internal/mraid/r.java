package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6654a;
    public final Rect b;
    public final Rect c;
    public final Rect d;
    public final Rect e;
    public final Rect f;
    public final Rect g;
    public final Rect h;
    public final Rect i;

    public r(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.f6654a = applicationContext;
        this.b = new Rect();
        this.c = new Rect();
        this.d = new Rect();
        this.e = new Rect();
        this.f = new Rect();
        this.g = new Rect();
        this.h = new Rect();
        this.i = new Rect();
    }

    public final void a(Rect rect, Rect rect2) {
        a aVar = a.f6625a;
        rect2.set(aVar.f(rect.left, this.f6654a), aVar.f(rect.top, this.f6654a), aVar.f(rect.right, this.f6654a), aVar.f(rect.bottom, this.f6654a));
    }

    public final void b(int i, int i2, int i3, int i4) {
        this.h.set(i, i2, i3 + i, i4 + i2);
        a(this.h, this.i);
    }

    public final void c(int i, int i2, int i3, int i4) {
        this.d.set(i, i2, i3 + i, i4 + i2);
        a(this.d, this.e);
    }

    public final Rect d() {
        return this.i;
    }

    public final Rect e() {
        return this.d;
    }

    public final Rect f() {
        return this.e;
    }

    public final Rect g() {
        return this.c;
    }

    public final Rect b() {
        return this.g;
    }

    public final Rect c() {
        return this.h;
    }

    public final void a(int i, int i2) {
        this.b.set(0, 0, i, i2);
        a(this.b, this.c);
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.f.set(i, i2, i3 + i, i4 + i2);
        a(this.f, this.g);
    }

    public final Rect a() {
        return this.f;
    }
}
