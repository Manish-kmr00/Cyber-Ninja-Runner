package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.PangleFilesBridge;
import com.safedk.android.utils.h;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes11.dex */
public class ML extends ImageView {
    private int BSW;
    private float Bzk;
    private boolean DX;
    private boolean JG;
    private long KZx;
    private AnimatedImageDrawable ML;
    private Movie Og;
    private boolean SD;
    private float SGo;
    private boolean Sn;
    private int WV;
    private volatile boolean Wx;
    private int ZZv;
    private float omh;
    private int pA;

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public ML(Context context) {
        super(context);
        this.JG = Build.VERSION.SDK_INT >= 28;
        this.SD = false;
        this.Sn = true;
        this.DX = true;
        pA();
    }

    void pA() {
        if (this.JG) {
            return;
        }
        setLayerType(1, null);
    }

    public void pA(int i, boolean z) {
        this.Wx = z;
        this.pA = i;
        if (i != -1) {
            if (!this.JG) {
                this.Og = pA(i);
            } else {
                this.ML = Og(i);
            }
        }
    }

    public void pA(byte[] bArr, boolean z) {
        this.Wx = z;
        if (bArr != null) {
            if (!this.JG) {
                this.Og = pA(bArr);
            } else {
                this.ML = Og(bArr);
            }
            KZx();
        }
    }

    public void setRepeatConfig(boolean z) {
        AnimatedImageDrawable animatedImageDrawable;
        this.DX = z;
        if (z) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.ML) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("GifView", "setRepeatConfig error", e);
        }
    }

    private Movie pA(int i) {
        try {
            return Movie.decodeStream(getResources().openRawResource(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    private Movie pA(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    private AnimatedImageDrawable Og(int i) {
        if (i != -1 && Build.VERSION.SDK_INT >= 28) {
            return pA(ImageDecoder.createSource(getResources(), i));
        }
        return null;
    }

    private AnimatedImageDrawable Og(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return pA(KZx(bArr));
    }

    private ImageDecoder.Source KZx(byte[] bArr) {
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        try {
            try {
                File filePA = pA(getContext(), com.bytedance.sdk.openadsdk.multipro.Og.KZx() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
                fileOutputStreamFileOutputStreamCtor = PangleFilesBridge.fileOutputStreamCtor(filePA);
                try {
                    fileOutputStreamFileOutputStreamCtor.write(bArr, 0, bArr.length);
                    if (Build.VERSION.SDK_INT >= 28) {
                        ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(filePA);
                        try {
                            fileOutputStreamFileOutputStreamCtor.close();
                        } catch (Throwable unused) {
                        }
                        return sourceCreateSource;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.bytedance.sdk.component.utils.WV.pA("GifView", "GifView  getSourceByFile fail : ", th);
                        return null;
                    } finally {
                        if (fileOutputStreamFileOutputStreamCtor != null) {
                            try {
                                fileOutputStreamFileOutputStreamCtor.close();
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStreamFileOutputStreamCtor = null;
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    private AnimatedImageDrawable pA(ImageDecoder.Source source) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source);
            setImageDrawable(drawableDecodeDrawable);
            if (drawableDecodeDrawable instanceof AnimatedImageDrawable) {
                AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawableDecodeDrawable;
                if (!this.Wx) {
                    animatedImageDrawable.start();
                }
                return animatedImageDrawable;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public void Og() {
        if (this.Og == null || !this.Wx) {
            return;
        }
        this.Wx = false;
        if (!this.JG) {
            this.KZx = SystemClock.uptimeMillis() - ((long) this.ZZv);
            invalidate();
            return;
        }
        AnimatedImageDrawable animatedImageDrawable = this.ML;
        if (animatedImageDrawable == null || animatedImageDrawable.isRunning()) {
            return;
        }
        this.ML.start();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.JG || (movie = this.Og) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.Og.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i2) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : iHeight / size);
        this.SGo = fMax;
        int i3 = (int) (iWidth * fMax);
        this.BSW = i3;
        int i4 = (int) (iHeight * fMax);
        this.WV = i4;
        setMeasuredDimension(i3, i4);
    }

    public static File pA(Context context, String str, String str2) {
        return com.bytedance.sdk.component.utils.JG.pA(context, com.bytedance.sdk.openadsdk.multipro.Og.KZx(), str, str2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.Og != null && !this.JG) {
            this.omh = (getWidth() - this.BSW) / 2.0f;
            this.Bzk = (getHeight() - this.WV) / 2.0f;
        }
        this.Sn = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.Og != null && !this.JG) {
            try {
                if (!this.Wx) {
                    ZZv();
                    pA(canvas);
                    KZx();
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

    private void KZx() {
        if (this.Og == null || this.JG || !this.Sn) {
            return;
        }
        postInvalidateOnAnimation();
    }

    private void ZZv() {
        if (this.Og == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.KZx == 0) {
            this.KZx = jUptimeMillis;
        }
        int iDuration = this.Og.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (!this.DX && Math.abs(iDuration - this.ZZv) < 60) {
            this.ZZv = iDuration;
            this.Wx = true;
        } else {
            this.ZZv = (int) ((jUptimeMillis - this.KZx) % ((long) iDuration));
        }
    }

    private void pA(Canvas canvas) {
        Movie movie = this.Og;
        if (movie == null) {
            return;
        }
        movie.setTime(this.ZZv);
        float f = this.SGo;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.Og.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.Og;
            float f2 = this.omh;
            float f3 = this.SGo;
            movie2.draw(canvas, f2 / f3, this.Bzk / f3);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.Og != null) {
            this.Sn = i == 1;
            KZx();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.Og != null) {
            this.Sn = i == 0;
            KZx();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.Og != null) {
            this.Sn = i == 0;
            KZx();
        }
    }
}
