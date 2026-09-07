package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes6.dex */
public class ProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f5088a;
    private float b;
    private float c;
    private float d;
    private Drawable e;
    private float f;
    private long g;
    private Handler h;
    private Drawable i;
    private int j;
    private boolean k;
    private boolean l;
    private long m;
    private float n;
    private boolean o;
    private Drawable p;
    private Rect q;
    private Drawable r;
    private float s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private long x;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressBar.this.invalidate();
        }
    }

    public ProgressBar(Context context) {
        super(context);
        this.f5088a = new a();
        this.g = 25L;
        this.h = new Handler(Looper.getMainLooper());
        this.k = false;
        this.n = 0.95f;
        this.o = false;
        this.q = new Rect();
        a(context);
    }

    private void a(Context context) {
        setWillNotDraw(false);
    }

    private float getVelocity() {
        if (this.t) {
            return this.l ? 1.0f : 0.4f;
        }
        if (this.x >= 2000) {
            return 0.05f;
        }
        if (this.v == 1) {
            return this.l ? 1.0f : 0.4f;
        }
        if (this.u == 1) {
            return this.l ? 0.4f : 0.2f;
        }
        return this.l ? 0.2f : 0.05f;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.k) {
            this.k = true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.o ? 0L : jCurrentTimeMillis - this.m;
        this.d = Math.abs(j / 1000.0f);
        this.m = jCurrentTimeMillis;
        this.x += j;
        float velocity = getVelocity();
        this.c = velocity;
        float f = this.b + (velocity * this.d);
        this.b = f;
        if (!this.t) {
            float f2 = this.n;
            if (f > f2) {
                this.b = f2;
            }
        }
        this.q.right = (int) (this.b * this.s);
        this.h.removeCallbacksAndMessages(null);
        this.h.postDelayed(this.f5088a, this.g);
        super.draw(canvas);
        a(canvas, this.d);
    }

    @Override // android.view.View
    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public float getProgress() {
        return this.b;
    }

    public void initResource(boolean z) {
        if (z || (this.i == null && this.p == null && this.r == null && this.e == null)) {
            Drawable drawable = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_highlight", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
            this.i = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.i.getIntrinsicHeight());
            }
            Drawable drawable2 = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_head", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
            this.p = drawable2;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.p.getIntrinsicHeight());
            }
            this.r = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_tail", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
            this.e = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_end_animation", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.s = getMeasuredWidth();
    }

    public void onThemeChange() {
        if (this.k) {
            initResource(true);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.setBounds(0, 0, (int) (((double) drawable.getIntrinsicWidth()) * 1.5d), getHeight());
        }
        Drawable drawable2 = this.p;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    public void setPaused(boolean z) {
        this.o = z;
        if (z) {
            return;
        }
        this.m = System.currentTimeMillis();
    }

    public void setProgress(float f, boolean z) {
        if (!z || f < 1.0f) {
            return;
        }
        startEndAnimation();
    }

    public void setProgressBarListener(c cVar) {
    }

    public void setProgressState(int i) {
        if (i == 5) {
            this.u = 1;
            this.v = 0;
            this.w = 0;
            this.x = 0L;
            return;
        }
        if (i == 6) {
            this.v = 1;
            if (this.w == 1) {
                startEndAnimation();
            }
            this.x = 0L;
            return;
        }
        if (i == 7) {
            startEndAnimation();
        } else {
            if (i != 8) {
                return;
            }
            this.w = 1;
            if (this.v == 1) {
                startEndAnimation();
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setVisible(boolean z) {
        if (!z) {
            setVisibility(4);
            return;
        }
        this.l = true;
        this.m = System.currentTimeMillis();
        this.d = 0.0f;
        this.x = 0L;
        this.t = false;
        this.f = 0.0f;
        this.b = 0.0f;
        this.s = getMeasuredWidth();
        this.o = false;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        Drawable drawable = this.i;
        if (drawable != null) {
            this.j = -drawable.getIntrinsicWidth();
        } else {
            this.j = 0;
        }
        Drawable drawable2 = this.r;
        if (drawable2 != null) {
            drawable2.setAlpha(255);
        }
        Drawable drawable3 = this.e;
        if (drawable3 != null) {
            drawable3.setAlpha(255);
        }
        Drawable drawable4 = this.p;
        if (drawable4 != null) {
            drawable4.setAlpha(255);
        }
        setVisibility(0);
        invalidate();
    }

    public void startEndAnimation() {
        if (this.t) {
            return;
        }
        this.t = true;
        this.f = 0.0f;
    }

    private void a(Canvas canvas, float f) {
        Drawable drawable;
        Drawable drawable2;
        if (this.t) {
            float f2 = this.f;
            float f3 = this.s * 0.5f;
            int i = (int) ((1.0f - (f2 / f3)) * 255.0f);
            if (i < 0) {
                i = 0;
            }
            if (f2 > f3) {
                setVisible(false);
            }
            Drawable drawable3 = this.r;
            if (drawable3 != null) {
                drawable3.setAlpha(i);
            }
            Drawable drawable4 = this.e;
            if (drawable4 != null) {
                drawable4.setAlpha(i);
            }
            Drawable drawable5 = this.p;
            if (drawable5 != null) {
                drawable5.setAlpha(i);
            }
            canvas.save();
            canvas.translate(this.f, 0.0f);
        }
        if (this.r != null && this.p != null) {
            int iWidth = (int) (this.q.width() - (this.p.getIntrinsicWidth() * 0.05f));
            Drawable drawable6 = this.r;
            drawable6.setBounds(0, 0, iWidth, drawable6.getIntrinsicHeight());
            this.r.draw(canvas);
        }
        if (this.t && (drawable2 = this.e) != null && this.p != null) {
            int intrinsicWidth = drawable2.getIntrinsicWidth();
            Drawable drawable7 = this.e;
            drawable7.setBounds(0, 0, intrinsicWidth, drawable7.getIntrinsicHeight());
            canvas.save();
            canvas.translate(-intrinsicWidth, 0.0f);
            this.e.draw(canvas);
            canvas.restore();
        }
        if (this.p != null) {
            canvas.save();
            canvas.translate(this.q.width() - getWidth(), 0.0f);
            this.p.draw(canvas);
            canvas.restore();
        }
        if (!this.t && Math.abs(this.b - this.n) < 1.0E-5f && (drawable = this.i) != null) {
            int i2 = (int) (this.j + (f * 0.2f * this.s));
            this.j = i2;
            if (i2 + drawable.getIntrinsicWidth() >= this.q.width()) {
                this.j = -this.i.getIntrinsicWidth();
            }
            canvas.save();
            canvas.translate(this.j, 0.0f);
            this.i.draw(canvas);
            canvas.restore();
        }
        if (this.t) {
            canvas.restore();
        }
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5088a = new a();
        this.g = 25L;
        this.h = new Handler(Looper.getMainLooper());
        this.k = false;
        this.n = 0.95f;
        this.o = false;
        this.q = new Rect();
        a(context);
    }
}
