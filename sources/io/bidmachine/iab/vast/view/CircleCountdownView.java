package io.bidmachine.iab.vast.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import io.bidmachine.iab.utils.Assets;
import io.bidmachine.iab.utils.IabElement;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.utils.Utils;

/* JADX INFO: loaded from: classes10.dex */
public class CircleCountdownView extends View implements IabElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f12315a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private float f;
    private float g;
    private final RectF h;
    private final RectF i;
    private float j;
    private float k;
    private float l;
    private Paint m;
    private Paint n;
    private Rect o;
    private RectF p;
    private Paint q;
    private Paint r;
    private float s;
    private int t;

    public CircleCountdownView(Context context) {
        super(context);
        this.c = Assets.MAIN_ASSETS_COLOR;
        this.d = Assets.BACKGROUND_COLOR;
        this.e = false;
        this.f = 0.0f;
        this.g = 0.071428575f;
        this.h = new RectF();
        this.i = new RectF();
        this.j = 54.0f;
        this.k = 54.0f;
        this.l = 5.0f;
        this.s = 100.0f;
        a(context);
    }

    private void a() {
        float fMin = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float f = fMin / 2.0f;
        float width = (getWidth() / 2.0f) - f;
        float height = (getHeight() / 2.0f) - f;
        this.h.set(width, height, width + fMin, fMin + height);
        this.j = this.h.centerX();
        this.k = this.h.centerY();
        RectF rectF = this.i;
        RectF rectF2 = this.h;
        float f2 = rectF2.left;
        float f3 = this.l / 2.0f;
        rectF.set(f2 + f3, rectF2.top + f3, rectF2.right - f3, rectF2.bottom - f3);
    }

    private void b(Canvas canvas) {
        if (this.n == null) {
            Paint paint = new Paint(1);
            this.n = paint;
            paint.setAntiAlias(true);
            this.n.setStyle(Paint.Style.FILL);
            this.n.setTextAlign(Paint.Align.CENTER);
        }
        String strValueOf = String.valueOf(this.t);
        this.n.setColor(this.c);
        this.n.setTypeface(Typeface.create(Typeface.DEFAULT, this.b));
        this.n.setTextSize(a(this.g, true));
        canvas.drawText(strValueOf, this.j, this.k - ((this.n.descent() + this.n.ascent()) / 2.0f), this.n);
    }

    public void changePercentage(float percent, int remainingTime) {
        if (this.f12315a == null || percent == 100.0f) {
            this.s = percent;
            this.t = remainingTime;
            postInvalidate();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    public int getAccentColor() {
        return this.c;
    }

    public int getBackgroundColor() {
        return this.d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.t == 0 && this.f12315a == null) {
            return;
        }
        a(canvas);
        Bitmap bitmap = this.f12315a;
        if (bitmap != null) {
            a(canvas, bitmap);
        } else {
            b(canvas);
        }
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
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }

    public void setColors(int primaryColor, int backgroundColor) {
        this.c = primaryColor;
        this.d = backgroundColor;
        a();
    }

    public void setImage(Bitmap bitmap) {
        this.f12315a = bitmap;
        if (bitmap != null) {
            this.s = 100.0f;
        }
        postInvalidate();
    }

    @Override // io.bidmachine.iab.utils.IabElement
    public void setStyle(IabElementStyle style) {
        this.b = style.getFontStyle().intValue();
        this.c = style.getStrokeColor().intValue();
        this.d = style.getFillColor().intValue();
        this.e = style.isOutlined().booleanValue();
        this.l = style.getStrokeWidth(getContext()).floatValue();
        setPadding(style.getPaddingLeft(getContext()).intValue(), style.getPaddingTop(getContext()).intValue(), style.getPaddingRight(getContext()).intValue(), style.getPaddingBottom(getContext()).intValue());
        setAlpha(style.getOpacity().floatValue());
        a();
        postInvalidate();
    }

    public CircleCountdownView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.c = Assets.MAIN_ASSETS_COLOR;
        this.d = Assets.BACKGROUND_COLOR;
        this.e = false;
        this.f = 0.0f;
        this.g = 0.071428575f;
        this.h = new RectF();
        this.i = new RectF();
        this.j = 54.0f;
        this.k = 54.0f;
        this.l = 5.0f;
        this.s = 100.0f;
        a(context);
    }

    private void a(Canvas canvas, Bitmap bitmap) {
        if (this.q == null) {
            Paint paint = new Paint(7);
            this.q = paint;
            paint.setStyle(Paint.Style.FILL);
            this.q.setAntiAlias(true);
        }
        if (this.o == null) {
            this.o = new Rect();
        }
        if (this.p == null) {
            this.p = new RectF();
        }
        float fA = a(this.f, this.e);
        float f = fA / 2.0f;
        float f2 = this.j - f;
        float f3 = this.k - f;
        this.o.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.p.set(f2, f3, f2 + fA, fA + f3);
        this.q.setColorFilter(new PorterDuffColorFilter(this.c, PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, this.o, this.p, this.q);
        if (this.e) {
            if (this.r == null) {
                Paint paint2 = new Paint(1);
                this.r = paint2;
                paint2.setStyle(Paint.Style.STROKE);
            }
            this.r.setStrokeWidth(this.l);
            this.r.setColor(this.c);
            canvas.drawArc(this.i, 0.0f, 360.0f, false, this.r);
        }
    }

    private void a(Canvas canvas) {
        if (this.m == null) {
            this.m = new Paint(1);
        }
        float f = 360.0f - ((this.s * 360.0f) * 0.01f);
        this.m.setColor(this.d);
        this.m.setStyle(Paint.Style.FILL);
        canvas.drawArc(this.h, 0.0f, 360.0f, false, this.m);
        this.m.setColor(this.c);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.l);
        canvas.drawArc(this.i, 270.0f, f, false, this.m);
    }

    private float a(float f, boolean z) {
        float fWidth = this.h.width();
        if (z) {
            fWidth -= this.l * 2.0f;
        }
        float fSqrt = (float) (((double) (fWidth / 2.0f)) * Math.sqrt(2.0d));
        return fSqrt - ((f * fSqrt) * 2.0f);
    }

    private void a(Context context) {
        setLayerType(1, null);
        this.l = Utils.dpToPx(context, 3.0f);
    }
}
