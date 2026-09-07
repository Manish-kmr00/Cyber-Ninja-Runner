package com.bytedance.sdk.openadsdk.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.sdk.openadsdk.core.ML.ZZv;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes9.dex */
public class NiceImageView extends ZZv {
    private final Path BF;
    private int BSW;
    private int Bzk;
    private int DX;
    private int JG;
    private boolean KZx;
    private int ML;
    private boolean Og;
    private int SD;
    private int SGo;
    private final RectF Sd;
    private final Xfermode Sn;
    private final Paint TX;
    private Path WQf;
    private int WV;
    private int Wx;
    private final float[] XT;
    private int ZZv;
    private float aBv;
    private int oX;
    private int omh;
    private final Context pA;
    private RectF vZF;
    private final float[] yFO;

    @Override // com.bytedance.sdk.openadsdk.core.ML.ZZv, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.ZZv, android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public NiceImageView(Context context) {
        this(context, null);
    }

    public NiceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NiceImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ML = -1;
        this.SD = -1;
        this.pA = context;
        this.omh = Vgu.KZx(context, 10.0f);
        this.XT = new float[8];
        this.yFO = new float[8];
        this.Sd = new RectF();
        this.vZF = new RectF();
        this.TX = new Paint();
        this.BF = new Path();
        if (Build.VERSION.SDK_INT <= 27) {
            this.Sn = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.Sn = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.WQf = new Path();
        }
        KZx();
        ZZv();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.DX = i;
        this.oX = i2;
        pA();
        Og();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.vZF, null, 31);
        if (!this.KZx) {
            int i = this.DX;
            int i2 = this.ZZv;
            int i3 = this.JG;
            int i4 = this.oX;
            canvas.scale((((i - (i2 * 2)) - (i3 * 2)) * 1.0f) / i, (((i4 - (i2 * 2)) - (i3 * 2)) * 1.0f) / i4, i / 2.0f, i4 / 2.0f);
        }
        super.onDraw(canvas);
        this.TX.reset();
        this.BF.reset();
        if (this.Og) {
            this.BF.addCircle(this.DX / 2.0f, this.oX / 2.0f, this.aBv, Path.Direction.CCW);
        } else {
            this.BF.addRoundRect(this.vZF, this.yFO, Path.Direction.CCW);
        }
        this.TX.setAntiAlias(true);
        this.TX.setStyle(Paint.Style.FILL);
        this.TX.setXfermode(this.Sn);
        if (Build.VERSION.SDK_INT <= 27) {
            canvas.drawPath(this.BF, this.TX);
        } else {
            this.WQf.addRect(this.vZF, Path.Direction.CCW);
            this.WQf.op(this.BF, Path.Op.DIFFERENCE);
            canvas.drawPath(this.WQf, this.TX);
        }
        this.TX.setXfermode(null);
        int i5 = this.Wx;
        if (i5 != 0) {
            this.TX.setColor(i5);
            canvas.drawPath(this.BF, this.TX);
        }
        canvas.restore();
        pA(canvas);
    }

    private void pA(Canvas canvas) {
        if (this.Og) {
            int i = this.ZZv;
            if (i > 0) {
                pA(canvas, i, this.ML, this.aBv - (i / 2.0f));
            }
            int i2 = this.JG;
            if (i2 > 0) {
                pA(canvas, i2, this.SD, (this.aBv - this.ZZv) - (i2 / 2.0f));
                return;
            }
            return;
        }
        int i3 = this.ZZv;
        if (i3 > 0) {
            pA(canvas, i3, this.ML, this.Sd, this.XT);
        }
    }

    private void pA(Canvas canvas, int i, int i2, float f) {
        pA(i, i2);
        this.BF.addCircle(this.DX / 2.0f, this.oX / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.BF, this.TX);
    }

    private void pA(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        pA(i, i2);
        this.BF.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.BF, this.TX);
    }

    private void pA(int i, int i2) {
        this.BF.reset();
        this.TX.setStrokeWidth(i);
        this.TX.setColor(i2);
        this.TX.setStyle(Paint.Style.STROKE);
    }

    private void pA() {
        if (this.Og) {
            return;
        }
        RectF rectF = this.Sd;
        int i = this.ZZv;
        rectF.set(i / 2.0f, i / 2.0f, this.DX - (i / 2.0f), this.oX - (i / 2.0f));
    }

    private void Og() {
        if (this.Og) {
            float fMin = Math.min(this.DX, this.oX) / 2.0f;
            this.aBv = fMin;
            RectF rectF = this.vZF;
            int i = this.DX;
            int i2 = this.oX;
            rectF.set((i / 2.0f) - fMin, (i2 / 2.0f) - fMin, (i / 2.0f) + fMin, (i2 / 2.0f) + fMin);
            return;
        }
        this.vZF.set(0.0f, 0.0f, this.DX, this.oX);
        if (this.KZx) {
            this.vZF = this.Sd;
        }
    }

    private void KZx() {
        if (this.Og) {
            return;
        }
        int i = 0;
        if (this.omh <= 0) {
            float[] fArr = this.XT;
            int i2 = this.Bzk;
            float f = i2;
            fArr[1] = f;
            fArr[0] = f;
            int i3 = this.SGo;
            float f2 = i3;
            fArr[3] = f2;
            fArr[2] = f2;
            int i4 = this.WV;
            float f3 = i4;
            fArr[5] = f3;
            fArr[4] = f3;
            int i5 = this.BSW;
            float f4 = i5;
            fArr[7] = f4;
            fArr[6] = f4;
            float[] fArr2 = this.yFO;
            int i6 = this.ZZv;
            float f5 = i2 - (i6 / 2.0f);
            fArr2[1] = f5;
            fArr2[0] = f5;
            float f6 = i3 - (i6 / 2.0f);
            fArr2[3] = f6;
            fArr2[2] = f6;
            float f7 = i4 - (i6 / 2.0f);
            fArr2[5] = f7;
            fArr2[4] = f7;
            float f8 = i5 - (i6 / 2.0f);
            fArr2[7] = f8;
            fArr2[6] = f8;
            return;
        }
        while (true) {
            float[] fArr3 = this.XT;
            if (i >= fArr3.length) {
                return;
            }
            int i7 = this.omh;
            fArr3[i] = i7;
            this.yFO[i] = i7 - (this.ZZv / 2.0f);
            i++;
        }
    }

    private void pA(boolean z) {
        if (z) {
            this.omh = 0;
        }
        KZx();
        pA();
        invalidate();
    }

    private void ZZv() {
        if (this.Og) {
            return;
        }
        this.JG = 0;
    }

    public void isCoverSrc(boolean z) {
        this.KZx = z;
        Og();
        invalidate();
    }

    public void isCircle(boolean z) {
        this.Og = z;
        ZZv();
        Og();
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.ZZv = Vgu.KZx(this.pA, i);
        pA(false);
    }

    public void setBorderColor(int i) {
        this.ML = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.JG = Vgu.KZx(this.pA, i);
        ZZv();
        invalidate();
    }

    public void setInnerBorderColor(int i) {
        this.SD = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.omh = Vgu.KZx(this.pA, i);
        pA(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.Bzk = Vgu.KZx(this.pA, i);
        pA(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.SGo = Vgu.KZx(this.pA, i);
        pA(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.BSW = Vgu.KZx(this.pA, i);
        pA(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.WV = Vgu.KZx(this.pA, i);
        pA(true);
    }

    public void setMaskColor(int i) {
        this.Wx = i;
        invalidate();
    }
}
