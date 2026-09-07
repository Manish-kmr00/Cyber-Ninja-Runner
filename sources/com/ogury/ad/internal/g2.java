package com.ogury.ad.internal;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g2 implements t6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f7303a;
    public final Rect b;
    public final float c;

    public g2(Rect adLayoutRect, Rect containerRect, float f) {
        Intrinsics.checkNotNullParameter(adLayoutRect, "adLayoutRect");
        Intrinsics.checkNotNullParameter(containerRect, "containerRect");
        this.f7303a = adLayoutRect;
        this.b = containerRect;
        this.c = f;
    }

    @Override // com.ogury.ad.internal.t6
    public final void a(Rect adLayoutRect, Rect containerRect) {
        Intrinsics.checkNotNullParameter(adLayoutRect, "adLayoutRect");
        Intrinsics.checkNotNullParameter(containerRect, "containerRect");
        b();
    }

    public final boolean b() {
        Rect rect = this.f7303a;
        int i = rect.left;
        int i2 = this.b.left;
        if (i < i2) {
            rect.right = (i2 - i) + rect.right;
            rect.left = i2;
        }
        if (a() < this.c) {
            Rect rect2 = this.f7303a;
            int i3 = rect2.top;
            int i4 = this.b.top;
            if (i3 < i4) {
                rect2.bottom = (i4 - i3) + rect2.bottom;
                rect2.top = i4;
            }
            if (a() < this.c) {
                Rect rect3 = this.f7303a;
                int i5 = rect3.right;
                int i6 = this.b.right;
                if (i5 > i6) {
                    int i7 = i5 - i6;
                    rect3.left -= i7;
                    rect3.right = i5 - i7;
                }
                if (a() < this.c) {
                    Rect rect4 = this.f7303a;
                    int i8 = rect4.bottom;
                    int i9 = this.b.bottom;
                    if (i8 > i9) {
                        int i10 = i8 - i9;
                        rect4.top -= i10;
                        rect4.bottom = i8 - i10;
                    }
                    if (a() < this.c) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final float a() {
        Rect rect = this.f7303a;
        Rect rect2 = this.b;
        Intrinsics.checkNotNullParameter(rect, "<this>");
        Intrinsics.checkNotNullParameter(rect2, "rect2");
        Rect rect3 = new Rect(rect);
        if (!rect3.intersect(rect2)) {
            rect3 = null;
        }
        if (rect3 == null) {
            return 0.0f;
        }
        return (rect3.height() * rect3.width()) / (this.f7303a.height() * this.f7303a.width());
    }
}
