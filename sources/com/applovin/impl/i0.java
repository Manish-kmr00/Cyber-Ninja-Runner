package com.applovin.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes4.dex */
public class i0 extends View {
    private static final int w = Color.rgb(66, 145, 241);
    private static final int x = Color.rgb(66, 145, 241);
    private static final int y = Color.rgb(66, 145, 241);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f441a;
    private Paint b;
    protected Paint c;
    protected Paint d;
    private RectF e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private float l;
    private int m;
    private String n;
    private String o;
    private float p;
    private String q;
    private float r;
    private final float s;
    private final float t;
    private final float u;
    private final int v;

    private static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static float c(Resources resources, float f) {
            return (f * resources.getDisplayMetrics().density) + 0.5f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static float d(Resources resources, float f) {
            return f * resources.getDisplayMetrics().scaledDensity;
        }
    }

    public i0(Context context) {
        this(context, null);
    }

    private float getProgressAngle() {
        return (getProgress() / this.j) * 360.0f;
    }

    protected void a() {
        this.k = w;
        this.g = x;
        this.f = this.t;
        setMax(100);
        setProgress(0);
        this.l = this.s;
        this.m = 0;
        this.p = this.u;
        this.h = y;
    }

    protected void b() {
        TextPaint textPaint = new TextPaint();
        this.c = textPaint;
        textPaint.setColor(this.g);
        this.c.setTextSize(this.f);
        this.c.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        this.d = textPaint2;
        textPaint2.setColor(this.h);
        this.d.setTextSize(this.p);
        this.d.setAntiAlias(true);
        Paint paint = new Paint();
        this.f441a = paint;
        paint.setColor(this.k);
        this.f441a.setStyle(Paint.Style.STROKE);
        this.f441a.setAntiAlias(true);
        this.f441a.setStrokeWidth(this.l);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(this.m);
        this.b.setAntiAlias(true);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.f8160a, this, me);
        return super.dispatchTouchEvent(me);
    }

    public int getFinishedStrokeColor() {
        return this.k;
    }

    public float getFinishedStrokeWidth() {
        return this.l;
    }

    public int getInnerBackgroundColor() {
        return this.m;
    }

    public String getInnerBottomText() {
        return this.q;
    }

    public int getInnerBottomTextColor() {
        return this.h;
    }

    public float getInnerBottomTextSize() {
        return this.p;
    }

    public int getMax() {
        return this.j;
    }

    public String getPrefixText() {
        return this.n;
    }

    public int getProgress() {
        return this.i;
    }

    public String getSuffixText() {
        return this.o;
    }

    public int getTextColor() {
        return this.g;
    }

    public float getTextSize() {
        return this.f;
    }

    @Override // android.view.View
    public void invalidate() {
        b();
        super.invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.l;
        this.e.set(f, f, getWidth() - f, getHeight() - f);
        float width = getWidth();
        float f2 = this.l;
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((width - f2) + f2) / 2.0f, this.b);
        canvas.drawArc(this.e, 270.0f, -getProgressAngle(), false, this.f441a);
        String str = this.n + this.i + this.o;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (getWidth() - this.c.measureText(str)) / 2.0f, (getWidth() - (this.c.descent() + this.c.ascent())) / 2.0f, this.c);
        }
        if (TextUtils.isEmpty(getInnerBottomText())) {
            return;
        }
        this.d.setTextSize(this.p);
        canvas.drawText(getInnerBottomText(), (getWidth() - this.d.measureText(getInnerBottomText())) / 2.0f, (getHeight() - this.r) - ((this.c.descent() + this.c.ascent()) / 2.0f), this.d);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(a(i), a(i2));
        this.r = getHeight() - ((getHeight() * 3) / 4);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.g = bundle.getInt("text_color");
        this.f = bundle.getFloat("text_size");
        this.p = bundle.getFloat("inner_bottom_text_size");
        this.q = bundle.getString("inner_bottom_text");
        this.h = bundle.getInt("inner_bottom_text_color");
        this.k = bundle.getInt("finished_stroke_color");
        this.l = bundle.getFloat("finished_stroke_width");
        this.m = bundle.getInt("inner_background_color");
        b();
        setMax(bundle.getInt("max"));
        setProgress(bundle.getInt("progress"));
        this.n = bundle.getString("prefix");
        this.o = bundle.getString("suffix");
        super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        bundle.putFloat("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", getInnerBottomText());
        bundle.putInt("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt("max", getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString("suffix", getSuffixText());
        bundle.putString("prefix", getPrefixText());
        bundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        bundle.putInt("inner_background_color", getInnerBackgroundColor());
        return bundle;
    }

    public void setFinishedStrokeColor(int i) {
        this.k = i;
        invalidate();
    }

    public void setFinishedStrokeWidth(float f) {
        this.l = f;
        invalidate();
    }

    public void setInnerBackgroundColor(int i) {
        this.m = i;
        invalidate();
    }

    public void setInnerBottomText(String str) {
        this.q = str;
        invalidate();
    }

    public void setInnerBottomTextColor(int i) {
        this.h = i;
        invalidate();
    }

    public void setInnerBottomTextSize(float f) {
        this.p = f;
        invalidate();
    }

    public void setMax(int i) {
        if (i > 0) {
            this.j = i;
            invalidate();
        }
    }

    public void setPrefixText(String str) {
        this.n = str;
        invalidate();
    }

    public void setProgress(int i) {
        this.i = i;
        if (i > getMax()) {
            this.i %= getMax();
        }
        invalidate();
    }

    public void setSuffixText(String str) {
        this.o = str;
        invalidate();
    }

    public void setTextColor(int i) {
        this.g = i;
        invalidate();
    }

    public void setTextSize(float f) {
        this.f = f;
        invalidate();
    }

    public i0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new RectF();
        this.i = 0;
        this.n = "";
        this.o = "";
        this.q = "";
        this.t = a.d(getResources(), 14.0f);
        this.v = (int) a.c(getResources(), 100.0f);
        this.s = a.c(getResources(), 4.0f);
        this.u = a.d(getResources(), 18.0f);
        a();
        b();
    }

    private int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.v;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }
}
