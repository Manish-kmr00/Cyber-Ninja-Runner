package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class yl extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l10 f10749a;
    private final ou0 b;
    private final int c;
    private final Paint d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yl(Context context, l10 dimensionConverter, ou0 emptySizeMeasureSpecProvider) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dimensionConverter, "dimensionConverter");
        Intrinsics.checkNotNullParameter(emptySizeMeasureSpecProvider, "emptySizeMeasureSpecProvider");
        this.f10749a = dimensionConverter;
        this.b = emptySizeMeasureSpecProvider;
        dimensionConverter.getClass();
        this.c = l10.a(context, 0.5f);
        this.d = new Paint();
        a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float f = this.c;
        canvas.drawRect(f, f, getWidth() - this.c, getHeight() - this.c, this.d);
    }

    public final void setColor(int i) {
        if (this.d.getColor() != i) {
            this.d.setColor(i);
            requestLayout();
        }
    }

    private final void a(Context context) {
        this.f10749a.getClass();
        int iA = l10.a(context, 1.0f);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(iA);
        this.d.setColor(SupportMenu.CATEGORY_MASK);
        setClickable(false);
        setFocusable(false);
        setWillNotDraw(false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        ou0.a aVarA = this.b.a(i, i2);
        super.onMeasure(aVarA.f9859a, aVarA.b);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object parent = getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            setLeft(0);
            setTop(0);
            setRight(measuredWidth);
            setBottom(measuredHeight);
            super.onLayout(z, 0, 0, measuredWidth, measuredHeight);
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }
}
