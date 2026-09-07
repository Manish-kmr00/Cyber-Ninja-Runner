package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class nm extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f9741a;
    private final float b;
    private final Paint c;
    private final Paint d;
    private final Paint e;
    private float f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nm(Context context, l10 dimensionConverter) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dimensionConverter, "dimensionConverter");
        dimensionConverter.getClass();
        this.f9741a = l10.a(context, 34.0f);
        float fA = l10.a(context, 3.0f);
        this.b = fA;
        float fA2 = l10.a(context, 20.0f);
        Paint paint = new Paint();
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.c = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(fA);
        paint2.setAntiAlias(true);
        this.d = paint2;
        Paint paint3 = new Paint();
        paint3.setStyle(style);
        paint3.setTextSize(fA2);
        paint3.setTextAlign(Paint.Align.CENTER);
        this.e = paint3;
        this.f = 40.0f;
        a();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float f = 2;
        float f2 = this.f9741a / f;
        canvas.drawCircle(f2, f2, f2, this.c);
        canvas.drawCircle(f2, f2, f2 - (this.b / f), this.d);
        float f3 = this.f9741a / f;
        canvas.drawText("!", f3, f3 - ((this.e.ascent() + this.e.descent()) / f), this.e);
    }

    private final void a() {
        this.d.setColor(oh2.a(SupportMenu.CATEGORY_MASK, this.f));
        this.c.setColor(oh2.a(-1, this.f));
        this.e.setColor(oh2.a(SupportMenu.CATEGORY_MASK, this.f));
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        this.f = z ? 0.0f : 40.0f;
        a();
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3 = (int) this.f9741a;
        setMeasuredDimension(i3, i3);
    }
}
