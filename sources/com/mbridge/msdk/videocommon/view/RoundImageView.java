package com.mbridge.msdk.videocommon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.widget.MBImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class RoundImageView extends MBImageView {
    private int c;
    private int d;
    private Paint e;
    private int f;
    private Matrix g;
    private BitmapShader h;
    private int i;
    private RectF j;

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new Matrix();
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.d = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.c = 1;
    }

    private Bitmap a(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            o0.b("View", th.getMessage());
            return null;
        }
    }

    private void b() {
        Bitmap bitmapA;
        try {
            Drawable drawable = getDrawable();
            if (drawable == null || (bitmapA = a(drawable)) == null || bitmapA.isRecycled()) {
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.h = new BitmapShader(bitmapA, tileMode, tileMode);
            int i = this.c;
            float fMax = 1.0f;
            if (i == 0) {
                fMax = (this.i * 1.0f) / Math.min(bitmapA.getWidth(), bitmapA.getHeight());
            } else if (i == 1) {
                fMax = Math.max((getWidth() * 1.0f) / bitmapA.getWidth(), (getHeight() * 1.0f) / bitmapA.getHeight());
            }
            this.g.setScale(fMax, fMax);
            this.h.setLocalMatrix(this.g);
            this.e.setShader(this.h);
        } catch (Throwable th) {
            o0.b("RoundImageView", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.widget.MBImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.mbridge.msdk.widget.MBImageView, android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            if (getDrawable() == null) {
                return;
            }
            b();
            if (this.c == 1) {
                RectF rectF = this.j;
                float f = this.d;
                canvas.drawRoundRect(rectF, f, f, this.e);
            } else {
                float f2 = this.f;
                canvas.drawCircle(f2, f2, f2, this.e);
            }
        } catch (Throwable th) {
            o0.b("RoundImageView", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.widget.MBImageView, android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.c == 0) {
            int iMin = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.i = iMin;
            this.f = iMin / 2;
            setMeasuredDimension(iMin, iMin);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("state_instance"));
        this.c = bundle.getInt("state_type");
        this.d = bundle.getInt("state_border_radius");
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_instance", super.onSaveInstanceState());
        bundle.putInt("state_type", this.c);
        bundle.putInt("state_border_radius", this.d);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.c == 1) {
            this.j = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
    }

    public void setBorderRadius(int i) {
        int iA = t0.a(getContext(), i);
        if (this.d != iA) {
            this.d = iA;
            invalidate();
        }
    }

    public void setType(int i) {
        if (this.c != i) {
            this.c = i;
            if (i != 1 && i != 0) {
                this.c = 0;
            }
            requestLayout();
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new Matrix();
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.d = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.c = 1;
    }

    public RoundImageView(Context context) {
        super(context);
        this.g = new Matrix();
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.d = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.c = 1;
    }
}
