package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class oX extends View {
    private float JG;
    private int KZx;
    private Drawable ML;
    private final boolean Og;
    private Drawable ZZv;
    private final Path pA;

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public oX(Context context) {
        this(context, false);
    }

    public oX(Context context, boolean z) {
        super(context);
        this.pA = new Path();
        this.Og = z;
        pA();
    }

    private void pA() {
        Context context = getContext();
        this.ZZv = com.bytedance.sdk.component.utils.yFO.KZx(context, this.Og ? "tt_star_thick_dark" : "tt_star_thick");
        this.ML = com.bytedance.sdk.component.utils.yFO.KZx(context, "tt_star");
    }

    public void pA(double d, int i) {
        int iPA = (int) Vgu.pA(getContext(), i, false);
        this.KZx = iPA;
        this.ZZv.setBounds(0, 0, iPA, iPA);
        Drawable drawable = this.ML;
        int i2 = this.KZx;
        drawable.setBounds(0, 0, i2, i2);
        this.JG = ((float) d) / 5.0f;
        Og();
        requestLayout();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Og();
    }

    private void Og() {
        int width = getWidth();
        int height = getHeight();
        if (this.JG <= 0.0f || width <= 0 || height <= 0) {
            return;
        }
        this.pA.reset();
        this.pA.addRect(new RectF(0.0f, 0.0f, width * this.JG, height), Path.Direction.CCW);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.KZx * 5, 1073741824), View.MeasureSpec.makeMeasureSpec(this.KZx, 1073741824));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.KZx <= 0) {
            return;
        }
        int iSave = canvas.save();
        for (int i = 0; i < 5; i++) {
            this.ZZv.draw(canvas);
            canvas.translate(this.KZx, 0.0f);
        }
        canvas.restoreToCount(iSave);
        canvas.clipPath(this.pA);
        for (int i2 = 0; i2 < 5; i2++) {
            this.ML.draw(canvas);
            canvas.translate(this.KZx, 0.0f);
        }
    }
}
