package sg.bigo.ads.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import sg.bigo.ads.common.utils.e;

/* JADX INFO: loaded from: classes2.dex */
public class Indicator extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f13316a;
    private int b;
    private Paint c;
    private Paint d;
    private int e;
    private float f;
    private int g;
    private float h;
    private int i;
    private float j;
    private float k;
    private int l;
    private float m;

    public Indicator(Context context) {
        this(context, null);
    }

    public Indicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Indicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        this.g = -2130706433;
        float fA = e.a(getContext(), 2);
        this.f = fA;
        this.i = -1;
        this.h = 8.0f * fA;
        this.j = fA * 2.0f;
        this.e = 0;
        this.k = 0.0f;
        this.l = 0;
    }

    public static float a(int i, float f, float f2, float f3) {
        float f4 = i - 1;
        return (f2 * 2.0f * f4) + (f * f4) + f3;
    }

    private void a() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.c.setColor(this.g);
        this.c.setAntiAlias(true);
        this.c.setStrokeWidth(3.0f);
        Paint paint2 = new Paint(this.c);
        this.d = paint2;
        paint2.setColor(this.i);
    }

    private void a(Canvas canvas) {
        float f;
        if (this.e <= 0) {
            return;
        }
        canvas.translate(((((canvas.getWidth() - getPaddingLeft()) - getPaddingRight()) - a(this.e, this.j, this.f, this.h)) / 2.0f) + getPaddingLeft() + this.f, (((canvas.getHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f) + getPaddingTop());
        a();
        float f2 = -this.f;
        for (int i = 0; i < this.e; i++) {
            if (i == this.l) {
                float f3 = this.f;
                canvas.drawCircle(f2 + f3, 0.0f, f3, this.c);
                float f4 = this.h + f2;
                float f5 = this.f;
                canvas.drawCircle(f4 - f5, 0.0f, f5, this.c);
                float f6 = (this.j * this.k) + f2;
                float f7 = this.f;
                RectF rectF = new RectF(f6, -f7, this.h + f6, f7);
                float f8 = this.f;
                canvas.drawRoundRect(rectF, f8, f8, this.d);
                f = this.h;
            } else {
                float f9 = this.f;
                canvas.drawCircle(f2 + f9, 0.0f, f9, this.c);
                f = this.f * 2.0f;
            }
            f2 = f2 + f + this.j;
        }
    }

    public final void a(float f, int i) {
        if (i == this.l) {
            this.k = (-f) * 2.0f;
            invalidate();
        }
    }

    public final void a(int i) {
        if (this.l != i) {
            this.l = i;
            this.k = 0.0f;
            invalidate();
        }
    }

    public float getDistance() {
        return this.j;
    }

    public float getLengthSelected() {
        return this.h;
    }

    public float getRadius() {
        return this.f;
    }

    public int getType() {
        return this.b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b != 1) {
            a(canvas);
            return;
        }
        if (this.m > 0.0f) {
            float width = canvas.getWidth();
            float height = canvas.getHeight();
            float f = this.m;
            canvas.translate(((width - f) / 2.0f) + this.f, height / 2.0f);
            a();
            float f2 = this.f;
            RectF rectF = new RectF(0.0f, -f2, f, f2);
            float f3 = this.f;
            canvas.drawRoundRect(rectF, f3, f3, this.c);
            float f4 = (f - this.h) * this.f13316a;
            float f5 = this.f;
            RectF rectF2 = new RectF(f4, -f5, this.h + f4, f5);
            float f6 = this.f;
            canvas.drawRoundRect(rectF2, f6, f6, this.d);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        float f = this.f * 2.0f;
        int i3 = this.e;
        float paddingLeft = (f * (i3 - 1)) + (this.j * (i3 - 1)) + this.h + getPaddingLeft() + getPaddingRight();
        float paddingTop = (this.f * 2.0f) + getPaddingTop() + getPaddingBottom();
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension((int) paddingLeft, (int) paddingTop);
            return;
        }
        if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension((int) paddingLeft, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, (int) paddingTop);
        } else {
            setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
        }
    }

    public void setColor(int i) {
        if (this.g != i) {
            this.g = i;
            invalidate();
        }
    }

    public void setColorSelected(int i) {
        if (this.i != i) {
            this.i = i;
            invalidate();
        }
    }

    public void setLineLength(float f) {
        if (this.m != f) {
            this.m = f;
            requestLayout();
            invalidate();
        }
    }

    public void setNum(int i) {
        if (this.e != i) {
            sg.bigo.ads.common.t.a.a("Indicator", "onMeasure, setNum=".concat(String.valueOf(i)));
            this.e = i;
            requestLayout();
            invalidate();
        }
    }

    public void setRadius(float f) {
        if (f != this.f) {
            this.f = f;
            this.h = 8.0f * f;
            this.j = f * 2.0f;
            requestLayout();
            invalidate();
        }
    }

    public void setType(int i) {
        if (this.b != i) {
            this.b = i;
            invalidate();
        }
    }
}
