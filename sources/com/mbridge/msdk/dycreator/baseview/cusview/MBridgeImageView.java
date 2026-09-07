package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.o0;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class MBridgeImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Xfermode f4802a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private float[] k;
    private float[] l;
    private RectF m;
    private RectF n;
    private boolean o;
    private boolean p;
    private Path q;
    private Paint r;

    public MBridgeImageView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        a(canvas, this.i, this.j, this.n, this.k);
    }

    private void b() {
        int i;
        int i2;
        int i3;
        try {
            if (this.k == null || this.l == null) {
                return;
            }
            int i4 = 0;
            while (true) {
                i = 2;
                if (i4 >= 2) {
                    break;
                }
                float[] fArr = this.k;
                float f = this.e;
                fArr[i4] = f;
                this.l[i4] = f - (this.i / 2.0f);
                i4++;
            }
            while (true) {
                i2 = 4;
                if (i >= 4) {
                    break;
                }
                float[] fArr2 = this.k;
                float f2 = this.f;
                fArr2[i] = f2;
                this.l[i] = f2 - (this.i / 2.0f);
                i++;
            }
            while (true) {
                if (i2 >= 6) {
                    break;
                }
                float[] fArr3 = this.k;
                float f3 = this.g;
                fArr3[i2] = f3;
                this.l[i2] = f3 - (this.i / 2.0f);
                i2++;
            }
            for (i3 = 6; i3 < 8; i3++) {
                float[] fArr4 = this.k;
                float f4 = this.h;
                fArr4[i3] = f4;
                this.l[i3] = f4 - (this.i / 2.0f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c() {
        RectF rectF = this.n;
        if (rectF != null) {
            float f = this.i / 2.0f;
            rectF.set(f, f, this.b - f, this.c - f);
        }
    }

    private void d() {
        RectF rectF = this.m;
        if (rectF != null) {
            rectF.set(0.0f, 0.0f, this.b, this.c);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        try {
            canvas.saveLayer(this.m, null, 31);
            int i = this.b;
            int i2 = this.i * 2;
            float f = (i - i2) * 1.0f;
            float f2 = i;
            int i3 = this.c;
            float f3 = i3;
            canvas.scale(f / f2, ((i3 - i2) * 1.0f) / f3, f2 / 2.0f, f3 / 2.0f);
            super.onDraw(canvas);
            Paint paint = this.r;
            if (paint != null) {
                paint.reset();
                this.r.setAntiAlias(true);
                this.r.setStyle(Paint.Style.FILL);
                this.r.setXfermode(this.f4802a);
            }
            Path path = this.q;
            if (path != null) {
                path.reset();
                this.q.addRoundRect(this.m, this.l, Path.Direction.CCW);
            }
            canvas.drawPath(this.q, this.r);
            Paint paint2 = this.r;
            if (paint2 != null) {
                paint2.setXfermode(null);
            }
            canvas.restore();
            if (this.o) {
                a(canvas);
            }
        } catch (Exception e) {
            o0.a("MBridgeImageView", e.getMessage());
        }
    }

    @Override // android.widget.ImageView, android.view.View
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
        this.b = i;
        this.c = i2;
        if (this.p) {
            b();
        } else {
            a();
        }
        c();
        d();
    }

    public void setBorder(int i, int i2, int i3) {
        this.o = true;
        this.i = i2;
        this.j = i3;
        this.d = i;
    }

    public void setCornerRadius(int i) {
        this.d = i;
    }

    public void setCustomBorder(int i, int i2, int i3, int i4, int i5, int i6) {
        this.o = true;
        this.p = true;
        this.i = i5;
        this.j = i6;
        this.e = i;
        this.g = i3;
        this.f = i2;
        this.h = i4;
    }

    public MBridgeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        try {
            a(i, i2);
            Path path = this.q;
            if (path != null) {
                path.addRoundRect(rectF, fArr, Path.Direction.CCW);
            }
            if (canvas != null) {
                canvas.drawPath(this.q, this.r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MBridgeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = new Path();
        this.r = new Paint();
        this.k = new float[8];
        this.l = new float[8];
        this.n = new RectF();
        this.m = new RectF();
        this.f4802a = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    private void a(int i, int i2) {
        Path path = this.q;
        if (path != null) {
            path.reset();
        }
        Paint paint = this.r;
        if (paint != null) {
            paint.setStrokeWidth(i);
            this.r.setColor(i2);
            this.r.setStyle(Paint.Style.STROKE);
        }
    }

    private void a() {
        if (this.k == null || this.l == null) {
            return;
        }
        int i = 0;
        while (true) {
            try {
                float[] fArr = this.k;
                if (i >= fArr.length) {
                    return;
                }
                float f = this.d;
                fArr[i] = f;
                this.l[i] = f - (this.i / 2.0f);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
