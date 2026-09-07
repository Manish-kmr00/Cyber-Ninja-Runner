package com.five_corp.ad.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: renamed from: com.five_corp.ad.internal.view.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3052j extends View implements com.five_corp.ad.internal.layouter.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f1573a;
    public final Paint b;
    public final Paint c;
    public float d;
    public RectF e;
    public final com.five_corp.ad.internal.logger.a f;

    public C3052j(Context context, com.five_corp.ad.internal.ad.custom_layout.i iVar, com.five_corp.ad.internal.logger.a aVar) {
        super(context);
        this.f = aVar;
        Paint paint = new Paint();
        this.f1573a = paint;
        paint.setColor(J.a(iVar.f1282a));
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(J.a(iVar.c));
        paint2.setStyle(style);
        paint2.setStrokeWidth(5.0f);
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setColor(J.a(iVar.b));
        this.e = new RectF(5.0f, 5.0f, getWidth() - 5.0f, getHeight() - 5.0f);
        this.d = 0.0f;
    }

    @Override // com.five_corp.ad.internal.layouter.k
    public final void a(com.five_corp.ad.internal.layouter.h hVar) {
        this.d = hVar.d;
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(this.e, this.c);
        canvas.drawArc(this.e, 270.0f, -(360.0f - (this.d * 360.0f)), false, this.f1573a);
        canvas.drawArc(this.e, -90.0f, this.d * 360.0f, false, this.b);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        try {
            this.e = new RectF(5.0f, 5.0f, i - 5.0f, i2 - 5.0f);
            invalidate();
        } catch (Throwable th) {
            this.f.a(th);
        }
    }
}
