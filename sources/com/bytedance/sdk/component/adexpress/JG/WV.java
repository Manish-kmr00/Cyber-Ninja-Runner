package com.bytedance.sdk.component.adexpress.JG;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class WV extends View {
    private Paint BSW;
    private int[] Bzk;
    private final List<pA> DX;
    private int JG;
    private int KZx;
    private int ML;
    Rect Og;
    private int SD;
    private Bitmap SGo;
    private LinearGradient Sn;
    private Xfermode WV;
    private PorterDuff.Mode Wx;
    private int ZZv;
    private int omh;
    Rect pA;

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public WV(Context context) {
        super(context);
        this.Wx = PorterDuff.Mode.DST_IN;
        this.DX = new ArrayList();
        pA();
    }

    private void pA() {
        this.KZx = com.bytedance.sdk.component.utils.yFO.ZZv(getContext(), "tt_splash_unlock_image_arrow");
        this.ZZv = Color.parseColor("#00ffffff");
        this.ML = Color.parseColor("#ffffffff");
        int color = Color.parseColor("#00ffffff");
        this.JG = color;
        this.SD = 10;
        this.omh = 40;
        this.Bzk = new int[]{this.ZZv, this.ML, color};
        setLayerType(1, null);
        this.BSW = new Paint(1);
        this.SGo = BitmapFactory.decodeResource(getResources(), this.KZx);
        this.WV = new PorterDuffXfermode(this.Wx);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.SGo, this.pA, this.Og, this.BSW);
        canvas.save();
        Iterator<pA> it = this.DX.iterator();
        while (it.hasNext()) {
            pA next = it.next();
            this.Sn = new LinearGradient(next.Og, 0.0f, next.Og + this.omh, this.SD, this.Bzk, (float[]) null, Shader.TileMode.CLAMP);
            this.BSW.setColor(-1);
            this.BSW.setShader(this.Sn);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.BSW);
            this.BSW.setShader(null);
            next.pA();
            if (next.Og > getWidth()) {
                it.remove();
            }
        }
        this.BSW.setXfermode(this.WV);
        canvas.drawBitmap(this.SGo, this.pA, this.Og, this.BSW);
        this.BSW.setXfermode(null);
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.SGo == null) {
            return;
        }
        this.pA = new Rect(0, 0, this.SGo.getWidth(), this.SGo.getHeight());
        this.Og = new Rect(0, 0, getWidth(), getHeight());
    }

    public void pA(int i) {
        this.DX.add(new pA(i));
        postInvalidate();
    }

    public static class pA {
        private int Og = 0;
        private final int pA;

        public pA(int i) {
            this.pA = i;
        }

        public void pA() {
            this.Og += this.pA;
        }
    }
}
