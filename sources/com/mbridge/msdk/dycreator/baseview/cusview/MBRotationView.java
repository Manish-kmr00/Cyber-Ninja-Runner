package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes7.dex */
public class MBRotationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Camera f4790a;
    private Matrix b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private float k;
    private float l;
    private boolean m;
    private boolean n;
    private boolean o;
    Runnable p;

    public MBRotationView(Context context) {
        super(context);
        this.e = 40;
        this.f = 20;
        this.g = 0;
        this.h = 0;
        this.j = 0;
        this.k = 0.5f;
        this.l = 0.9f;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.1
            @Override // java.lang.Runnable
            public void run() {
                MBRotationView.this.b();
            }
        };
        a();
    }

    private void b(Canvas canvas) {
        int height = getHeight() / 2;
        int i = ((this.g * this.c) / 2) / this.e;
        a(canvas, i, height, 0);
        a(canvas, i, height, 1);
        if (Math.abs(this.g) > this.e / 2) {
            a(canvas, i, height, 3);
            a(canvas, i, height, 2);
        } else {
            a(canvas, i, height, 2);
            a(canvas, i, height, 3);
        }
    }

    private int c(int i) {
        int i2;
        int i3;
        int i4;
        if (i == 0) {
            i2 = this.o ? this.h - 2 : this.h + 2;
        } else if (i != 1) {
            if (i != 2) {
                i2 = i != 3 ? 0 : this.h;
            } else if (this.o) {
                i3 = this.h;
                i2 = i3 - 1;
            } else {
                i4 = this.h;
                i2 = i4 + 1;
            }
        } else if (this.o) {
            i4 = this.h;
            i2 = i4 + 1;
        } else {
            i3 = this.h;
            i2 = i3 - 1;
        }
        int childCount = i2 % getChildCount();
        return childCount >= 0 ? childCount : childCount + getChildCount();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (getChildCount() == 0) {
            return;
        }
        if (this.n) {
            b(canvas);
        } else {
            a(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        float f = i5;
        float f2 = this.k;
        int i6 = (int) (((1.0f - f2) * f) / 2.0f);
        int i7 = i4 - i2;
        float f3 = i7;
        float f4 = this.l;
        int i8 = (int) (((1.0f - f4) * f3) / 2.0f);
        this.c = (int) (f3 * f4);
        this.d = (int) (f * f2);
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            childAt.layout(i6, i8, i5 - i6, i7 - i8);
            childAt.setClickable(true);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i10 = layoutParams.width;
            int i11 = this.d;
            if (i10 != i11) {
                layoutParams.width = i11;
                layoutParams.height = this.c;
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void setAutoscroll(boolean z) {
        if (z) {
            postDelayed(this.p, 1000 / this.f);
        }
        this.m = z;
    }

    public void setHeightRatio(float f) {
        this.l = f;
    }

    public void setRotateV(boolean z) {
        this.n = z;
        invalidate();
    }

    public void setWidthRatio(float f) {
        this.k = f;
    }

    private void a() {
        this.f4790a = new Camera();
        this.b = new Matrix();
        setWillNotDraw(false);
    }

    private void a(Canvas canvas) {
        int width = getWidth() / 2;
        int i = ((this.g * this.d) / 2) / this.e;
        b(canvas, i, width, 0);
        b(canvas, i, width, 1);
        if (Math.abs(this.g) > this.e / 2) {
            b(canvas, i, width, 3);
            b(canvas, i, width, 2);
        } else {
            b(canvas, i, width, 2);
            b(canvas, i, width, 3);
        }
    }

    private void b(int i, int i2, int i3) {
        float f = (-i) / 2.0f;
        if (i3 == 0) {
            this.f4790a.translate(0.0f, f, 0.0f);
            float f2 = -i2;
            this.f4790a.rotateX(f2);
            this.f4790a.translate(0.0f, f, 0.0f);
            this.f4790a.translate(0.0f, f, 0.0f);
            this.f4790a.rotateX(f2);
            this.f4790a.translate(0.0f, f, 0.0f);
            return;
        }
        if (i3 == 1) {
            this.f4790a.translate(0.0f, f, 0.0f);
            this.f4790a.rotateX(i2);
            this.f4790a.translate(0.0f, f, 0.0f);
        } else if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            this.f4790a.rotateX(0.0f);
        } else {
            this.f4790a.translate(0.0f, f, 0.0f);
            this.f4790a.rotateX(-i2);
            this.f4790a.translate(0.0f, f, 0.0f);
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        canvas.save();
        this.f4790a.save();
        this.b.reset();
        float f = i;
        this.f4790a.translate(0.0f, f, 0.0f);
        this.f4790a.rotateX(this.g);
        this.f4790a.translate(0.0f, f, 0.0f);
        if (i == 0) {
            if (this.o) {
                b(this.c, this.e, i3);
            } else {
                b(-this.c, -this.e, i3);
            }
        } else if (i > 0) {
            b(this.c, this.e, i3);
        } else if (i < 0) {
            b(-this.c, -this.e, i3);
        }
        this.f4790a.getMatrix(this.b);
        this.f4790a.restore();
        this.b.preTranslate((-getWidth()) / 2, -i2);
        this.b.postTranslate(getWidth() / 2, i2);
        canvas.concat(this.b);
        View childAt = getChildAt(c(i3));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (getChildCount() == 0) {
            return;
        }
        int i = this.g - 1;
        this.g = i;
        this.i = this.h;
        a(i);
        if (this.m) {
            postDelayed(this.p, 1000 / this.f);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        canvas.save();
        this.f4790a.save();
        this.b.reset();
        float f = i;
        this.f4790a.translate(f, 0.0f, 0.0f);
        this.f4790a.rotateY(this.g);
        this.f4790a.translate(f, 0.0f, 0.0f);
        if (i == 0) {
            if (this.o) {
                a(this.d, this.e, i3);
            } else {
                a(-this.d, -this.e, i3);
            }
        } else if (i > 0) {
            a(this.d, this.e, i3);
        } else if (i < 0) {
            a(-this.d, -this.e, i3);
        }
        this.f4790a.getMatrix(this.b);
        this.f4790a.restore();
        this.b.preTranslate(-i2, (-getHeight()) / 2);
        this.b.postTranslate(i2, getHeight() / 2);
        canvas.concat(this.b);
        View childAt = getChildAt(c(i3));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    private void a(int i) {
        int i2 = this.e;
        int i3 = this.i - (i / i2);
        this.g = i % i2;
        b(i3);
        invalidate();
    }

    private void a(int i, int i2, int i3) {
        if (i3 == 0) {
            float f = (-i) / 2;
            this.f4790a.translate(f, 0.0f, 0.0f);
            float f2 = -i2;
            this.f4790a.rotateY(f2);
            this.f4790a.translate(f, 0.0f, 0.0f);
            this.f4790a.translate(f, 0.0f, 0.0f);
            this.f4790a.rotateY(f2);
            this.f4790a.translate(f, 0.0f, 0.0f);
            return;
        }
        if (i3 == 1) {
            float f3 = i / 2;
            this.f4790a.translate(f3, 0.0f, 0.0f);
            this.f4790a.rotateY(i2);
            this.f4790a.translate(f3, 0.0f, 0.0f);
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            this.f4790a.rotateY(0.0f);
        } else {
            float f4 = (-i) / 2;
            this.f4790a.translate(f4, 0.0f, 0.0f);
            this.f4790a.rotateY(-i2);
            this.f4790a.translate(f4, 0.0f, 0.0f);
        }
    }

    private void b(int i) {
        int iC;
        this.h = i;
        if (Math.abs(this.g) > this.e / 2) {
            iC = c(2);
        } else {
            iC = c(3);
        }
        if (this.j != iC) {
            this.j = iC;
        }
    }

    public MBRotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 40;
        this.f = 20;
        this.g = 0;
        this.h = 0;
        this.j = 0;
        this.k = 0.5f;
        this.l = 0.9f;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.1
            @Override // java.lang.Runnable
            public void run() {
                MBRotationView.this.b();
            }
        };
        a();
    }

    public MBRotationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 40;
        this.f = 20;
        this.g = 0;
        this.h = 0;
        this.j = 0;
        this.k = 0.5f;
        this.l = 0.9f;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.1
            @Override // java.lang.Runnable
            public void run() {
                MBRotationView.this.b();
            }
        };
        a();
    }
}
