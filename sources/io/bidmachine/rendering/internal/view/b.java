package io.bidmachine.rendering.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import io.bidmachine.rendering.internal.i;
import io.bidmachine.rendering.internal.l;
import io.bidmachine.rendering.model.AppearanceParams;
import io.bidmachine.rendering.model.FontStyleType;
import io.bidmachine.rendering.utils.UiUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
public class b extends View implements io.bidmachine.rendering.internal.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Paint f12374a;
    final Paint b;
    final Paint c;
    private final RectF d;
    private final RectF e;
    private final c f;
    private final AtomicBoolean g;
    private d h;
    private Runnable i;
    private float j;
    private float k;
    private float l;
    private float m;
    private int n;
    private byte o;
    private boolean p;

    /* JADX INFO: renamed from: io.bidmachine.rendering.internal.view.b$b, reason: collision with other inner class name */
    private class C0792b implements l {
        private C0792b() {
        }

        @Override // io.bidmachine.rendering.utils.SafeRunnable
        public void onRun() {
            boolean z = !b.this.c() || b.this.isShown();
            c cVar = b.this.f;
            if (z) {
                cVar.j();
            } else {
                cVar.i();
            }
            long jB = b.this.f.b();
            long jC = b.this.f.c();
            if (z) {
                b.this.a((jC * 100.0f) / jB, (int) Math.ceil((jB - jC) / 1000.0d));
            }
            if (b.this.f.e()) {
                b.this.d();
            } else {
                UiUtils.onUiThread(this, 16L);
            }
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f12376a = false;
        private long b = 0;
        private long c = 0;
        private long d = 0;

        c() {
        }

        long a() {
            return SystemClock.elapsedRealtime();
        }

        public long b() {
            return this.b;
        }

        public long c() {
            return this.c;
        }

        public boolean d() {
            return this.f12376a;
        }

        public boolean e() {
            return this.c >= this.b;
        }

        public void f() {
            this.f12376a = false;
        }

        public void g() {
            this.c = 0L;
            this.d = a();
        }

        public void h() {
            this.f12376a = true;
            this.d = a();
        }

        public void i() {
            this.d = a();
        }

        public void j() {
            if (d()) {
                long jA = a();
                this.c = Math.min(this.b, this.c + (jA - this.d));
                this.d = jA;
            }
        }

        public void a(long j) {
            this.b = j;
            g();
        }
    }

    public interface d {
        void a();
    }

    public b(Context context) {
        super(context);
        this.d = new RectF();
        this.e = new RectF();
        this.f = new c();
        this.g = new AtomicBoolean(false);
        this.m = 100.0f;
        this.o = (byte) -1;
        this.p = false;
        Paint paint = new Paint(1);
        this.f12374a = paint;
        paint.setColor(i.c);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        this.b = paint2;
        int i = i.b;
        paint2.setColor(i);
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint(1);
        this.c = paint3;
        paint3.setColor(i);
        paint3.setStyle(style);
        paint3.setAntiAlias(true);
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        d dVar;
        if (this.g.compareAndSet(false, true) && (dVar = this.h) != null) {
            dVar.a();
        }
    }

    public boolean c() {
        return this.p;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    public void e() {
        g();
        if (this.g.get()) {
            return;
        }
        this.f.h();
        C0792b c0792b = new C0792b();
        this.i = c0792b;
        UiUtils.onUiThread(c0792b, 16L);
    }

    public void f() {
        this.g.set(false);
        this.f.g();
        e();
    }

    public void g() {
        this.f.f();
        Runnable runnable = this.i;
        if (runnable == null) {
            return;
        }
        UiUtils.cancelOnUiThread(runnable);
        this.i = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() == 0 || getHeight() == 0 || this.n == 0) {
            return;
        }
        a(canvas);
        b(canvas);
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

    public void setClockwise(boolean isClockwise) {
        this.o = isClockwise ? (byte) -1 : (byte) 1;
    }

    public void setDuration(long duration) {
        this.f.a(duration);
    }

    public void setListener(d listener) {
        this.h = listener;
    }

    public void setOnlyVisibleWork(boolean onlyVisibleWork) {
        this.p = onlyVisibleWork;
    }

    @Override // io.bidmachine.rendering.internal.f
    public void a(AppearanceParams appearanceParams) {
        FontStyleType fontStyleType = appearanceParams.getFontStyleType();
        if (fontStyleType != null) {
            this.c.setTypeface(Typeface.create(Typeface.DEFAULT, fontStyleType.getTypeface()));
        }
        Integer backgroundColor = appearanceParams.getBackgroundColor();
        if (backgroundColor != null) {
            this.f12374a.setColor(backgroundColor.intValue());
        }
        Integer strokeWidthPx = appearanceParams.getStrokeWidthPx(getContext());
        if (strokeWidthPx != null) {
            float fIntValue = strokeWidthPx.intValue();
            this.l = fIntValue;
            this.b.setStrokeWidth(fIntValue);
        }
        Integer strokeColor = appearanceParams.getStrokeColor();
        if (strokeColor != null) {
            this.b.setColor(strokeColor.intValue());
        }
        a();
    }

    public void b() {
        g();
        this.h = null;
    }

    private void b(Canvas canvas) {
        canvas.drawText(String.valueOf(this.n), this.j, this.k - ((this.c.descent() + this.c.ascent()) / 2.0f), this.c);
    }

    public void a(float f, int i) {
        if (f >= 0.0f || f <= 100.0f) {
            this.m = f;
        }
        this.n = i;
        postInvalidate();
    }

    void a() {
        int iMin = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float width = (getWidth() - iMin) / 2.0f;
        float height = (getHeight() - iMin) / 2.0f;
        float f = iMin;
        this.d.set(width, height, width + f, f + height);
        this.j = this.d.centerX();
        this.k = this.d.centerY();
        float f2 = this.l / 2.0f;
        RectF rectF = this.e;
        RectF rectF2 = this.d;
        rectF.set(rectF2.left + f2, rectF2.top + f2, rectF2.right - f2, rectF2.bottom - f2);
        this.c.setTextSize(a(this.d, true));
    }

    private void a(Canvas canvas) {
        float f = this.o * (360.0f - ((this.m * 360.0f) * 0.01f));
        canvas.drawArc(this.d, 0.0f, 360.0f, false, this.f12374a);
        canvas.drawArc(this.e, 270.0f, f, false, this.b);
    }

    float a(RectF rectF, boolean z) {
        float fWidth = rectF.width();
        if (z) {
            fWidth -= this.l * 2.0f;
        }
        return fWidth * 0.70710677f * 0.9f;
    }

    private void a(Context context) {
        setLayerType(1, null);
        this.j = UiUtils.dpToPx(context, 54.0f);
        this.k = UiUtils.dpToPx(context, 54.0f);
        float fDpToPx = UiUtils.dpToPx(context, 3.0f);
        this.l = fDpToPx;
        this.b.setStrokeWidth(fDpToPx);
        a();
    }
}
