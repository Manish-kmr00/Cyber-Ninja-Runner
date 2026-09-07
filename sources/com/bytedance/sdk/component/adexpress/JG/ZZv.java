package com.bytedance.sdk.component.adexpress.JG;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ZZv extends View {
    private Paint BSW;
    private List<Integer> Bzk;
    private int JG;
    private float KZx;
    private float ML;
    private int Og;
    private boolean SD;
    private Paint SGo;
    private int Sn;
    private float WV;
    private float Wx;
    private int ZZv;
    private List<Integer> omh;
    private int pA;

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public ZZv(Context context) {
        this(context, null);
    }

    public ZZv(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ZZv(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pA = -1;
        this.Og = SupportMenu.CATEGORY_MASK;
        this.KZx = 18.0f;
        this.ZZv = 3;
        this.ML = 50.0f;
        this.JG = 2;
        this.SD = false;
        this.omh = new ArrayList();
        this.Bzk = new ArrayList();
        this.Sn = 24;
        KZx();
    }

    private void KZx() {
        Paint paint = new Paint();
        this.SGo = paint;
        paint.setAntiAlias(true);
        this.SGo.setStrokeWidth(this.Sn);
        this.omh.add(255);
        this.Bzk.add(0);
        Paint paint2 = new Paint();
        this.BSW = paint2;
        paint2.setAntiAlias(true);
        this.BSW.setColor(Color.parseColor("#0FFFFFFF"));
        this.BSW.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        this.WV = f;
        this.Wx = i2 / 2.0f;
        float f2 = f - (this.Sn / 2.0f);
        this.ML = f2;
        this.KZx = f2 / 4.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.SGo.setShader(new LinearGradient(this.WV, 0.0f, this.Wx, getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.omh.size()) {
                break;
            }
            Integer num = this.omh.get(i);
            this.SGo.setAlpha(num.intValue());
            Integer num2 = this.Bzk.get(i);
            if (this.KZx + num2.intValue() < this.ML) {
                canvas.drawCircle(this.WV, this.Wx, this.KZx + num2.intValue(), this.SGo);
            }
            if (num.intValue() > 0 && num2.intValue() < this.ML) {
                this.omh.set(i, Integer.valueOf(num.intValue() - this.JG > 0 ? num.intValue() - (this.JG * 3) : 1));
                this.Bzk.set(i, Integer.valueOf(num2.intValue() + this.JG));
            }
            i++;
        }
        List<Integer> list = this.Bzk;
        if (list.get(list.size() - 1).intValue() >= this.ML / this.ZZv) {
            this.omh.add(255);
            this.Bzk.add(0);
        }
        if (this.Bzk.size() >= 3) {
            this.Bzk.remove(0);
            this.omh.remove(0);
        }
        this.SGo.setAlpha(255);
        this.SGo.setColor(this.Og);
        canvas.drawCircle(this.WV, this.Wx, this.KZx, this.BSW);
        if (this.SD) {
            invalidate();
        }
    }

    public void pA() {
        this.SD = true;
        invalidate();
    }

    public void Og() {
        this.SD = false;
        this.Bzk.clear();
        this.omh.clear();
        this.omh.add(255);
        this.Bzk.add(0);
        invalidate();
    }

    public void setColor(int i) {
        this.pA = i;
    }

    public void setCoreColor(int i) {
        this.Og = i;
    }

    public void setCoreRadius(int i) {
        this.KZx = i;
    }

    public void setDiffuseWidth(int i) {
        this.ZZv = i;
    }

    public void setMaxWidth(int i) {
        this.ML = i;
    }

    public void setDiffuseSpeed(int i) {
        this.JG = i;
    }
}
