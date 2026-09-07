package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes13.dex */
public class Og extends GradientDrawable {
    private final Paint Og;
    protected Path pA;

    public Og() {
        this.pA = new Path();
        Paint paint = new Paint(1);
        this.Og = paint;
        paint.setColor(-1);
    }

    public Og(GradientDrawable.Orientation orientation, int[] iArr) {
        super(orientation, iArr);
        this.pA = new Path();
        Paint paint = new Paint(1);
        this.Og = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.pA;
        if (path == null || path.isEmpty()) {
            pA(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.Og, 31);
        pA(canvas);
        this.Og.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.pA, this.Og);
        this.Og.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    protected void pA(Canvas canvas) {
        super.draw(canvas);
    }

    public void pA(int i, int i2, int i3, int i4) {
        this.pA.addRect(i, i2, i3, i4, Path.Direction.CW);
        invalidateSelf();
    }
}
