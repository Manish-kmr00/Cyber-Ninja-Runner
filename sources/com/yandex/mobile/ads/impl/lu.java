package com.yandex.mobile.ads.impl;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class lu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f9567a;
    private final RectF b;
    private final Path c;
    private final float[] d;

    public final void a(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.d == null || this.c.isEmpty()) {
            return;
        }
        canvas.clipPath(this.c);
    }

    public /* synthetic */ lu(View view, float f, float f2, float f3, float f4) {
        this(view, f, f2, f3, f4, new RectF(), new Path());
    }

    public lu(View roundView, float f, float f2, float f3, float f4, RectF clipRect, Path clipPath) {
        Intrinsics.checkNotNullParameter(roundView, "roundView");
        Intrinsics.checkNotNullParameter(clipRect, "clipRect");
        Intrinsics.checkNotNullParameter(clipPath, "clipPath");
        this.f9567a = roundView;
        this.b = clipRect;
        this.c = clipPath;
        this.d = a(f, f2, f3, f4);
    }

    private static float[] a(float f, float f2, float f3, float f4) {
        if (f > 0.0f || f2 > 0.0f || f3 > 0.0f || f4 > 0.0f) {
            return new float[]{f, f, f2, f2, f3, f3, f4, f4};
        }
        return null;
    }

    public final void a() {
        if (this.d != null) {
            int measuredWidth = this.f9567a.getMeasuredWidth();
            int measuredHeight = this.f9567a.getMeasuredHeight();
            int paddingLeft = this.f9567a.getPaddingLeft();
            int paddingTop = this.f9567a.getPaddingTop();
            int paddingRight = measuredWidth - this.f9567a.getPaddingRight();
            int paddingBottom = measuredHeight - this.f9567a.getPaddingBottom();
            if (paddingLeft >= paddingRight || paddingTop >= paddingBottom) {
                return;
            }
            this.b.set(paddingLeft, paddingTop, paddingRight, paddingBottom);
            this.c.reset();
            this.c.addRoundRect(this.b, this.d, Path.Direction.CW);
        }
    }
}
