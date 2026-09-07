package com.bytedance.sdk.component.adexpress.JG;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes5.dex */
public class Wx extends ImageView {
    private int BSW;
    private float Bzk;
    private boolean JG;
    private int KZx;
    private boolean ML;
    private long Og;
    private float SD;
    private int SGo;
    private boolean Sn;
    private volatile boolean WV;
    private boolean Wx;
    private AnimatedImageDrawable ZZv;
    private float omh;
    private Movie pA;

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public Wx(Context context) {
        super(context);
        this.ML = Build.VERSION.SDK_INT >= 28;
        this.JG = false;
        this.Wx = true;
        this.Sn = true;
        pA();
    }

    void pA() {
        if (this.ML) {
            return;
        }
        setLayerType(1, null);
    }

    private void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;
            this.ZZv = animatedImageDrawable;
            if (!this.WV) {
                animatedImageDrawable.start();
            }
            if (!this.Sn) {
                animatedImageDrawable.setRepeatCount(0);
            }
        }
        Og();
    }

    public void setRepeatConfig(boolean z) {
        AnimatedImageDrawable animatedImageDrawable;
        this.Sn = z;
        if (z) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.ZZv) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("GifView", "setRepeatConfig error", e);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.ML || (movie = this.pA) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.pA.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i2) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : iHeight / size);
        this.Bzk = fMax;
        int i3 = (int) (iWidth * fMax);
        this.SGo = i3;
        int i4 = (int) (iHeight * fMax);
        this.BSW = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.pA != null && !this.ML) {
            this.SD = (getWidth() - this.SGo) / 2.0f;
            this.omh = (getHeight() - this.BSW) / 2.0f;
        }
        this.Wx = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.pA != null && !this.ML) {
            try {
                if (!this.WV) {
                    KZx();
                    pA(canvas);
                    Og();
                    return;
                }
                pA(canvas);
                return;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("GifView", "onDraw->Throwable->", th);
                return;
            }
        }
        super.onDraw(canvas);
    }

    private void Og() {
        if (this.pA == null || this.ML || !this.Wx) {
            return;
        }
        postInvalidateOnAnimation();
    }

    private void KZx() {
        if (this.pA == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.Og == 0) {
            this.Og = jUptimeMillis;
        }
        int iDuration = this.pA.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (!this.Sn && Math.abs(iDuration - this.KZx) < 60) {
            this.KZx = iDuration;
            this.WV = true;
        } else {
            this.KZx = (int) ((jUptimeMillis - this.Og) % ((long) iDuration));
        }
    }

    private void pA(Canvas canvas) {
        Movie movie = this.pA;
        if (movie == null) {
            return;
        }
        movie.setTime(this.KZx);
        float f = this.Bzk;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.pA.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.pA;
            float f2 = this.SD;
            float f3 = this.Bzk;
            movie2.draw(canvas, f2 / f3, this.omh / f3);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.pA != null) {
            this.Wx = i == 1;
            Og();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.pA != null) {
            this.Wx = i == 0;
            Og();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.pA != null) {
            this.Wx = i == 0;
            Og();
        }
    }
}
