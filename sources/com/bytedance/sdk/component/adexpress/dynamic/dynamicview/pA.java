package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes12.dex */
public class pA extends Og {
    private final Bitmap KZx;
    private final Rect Og = new Rect();
    private final Paint ZZv = new Paint(1);

    public pA(Bitmap bitmap, Og og) {
        this.KZx = bitmap;
        if (og != null) {
            this.pA = og.pA;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        int iWidth = rect.width();
        int width = this.KZx.getWidth();
        int height = this.KZx.getHeight();
        this.Og.set(0, 0, width, height);
        if (height >= iHeight && width >= iWidth) {
            if (width > iWidth) {
                this.Og.left = (width - iWidth) / 2;
                Rect rect2 = this.Og;
                rect2.right = rect2.left + iWidth;
            }
            if (height > iHeight) {
                this.Og.top = (height - iHeight) / 2;
                Rect rect3 = this.Og;
                rect3.bottom = rect3.top + iHeight;
                return;
            }
            return;
        }
        float f = iHeight;
        float f2 = f * 1.0f;
        float f3 = height;
        float f4 = f2 / f3;
        float f5 = iWidth;
        float f6 = 1.0f * f5;
        float f7 = width;
        if (Math.max(f4, f6 / f7) > f4) {
            int i = (int) ((f2 / f5) * f7);
            this.Og.top = (height - i) / 2;
            Rect rect4 = this.Og;
            rect4.bottom = rect4.top + i;
            return;
        }
        int i2 = (int) ((f6 / f) * f3);
        this.Og.left = (width - i2) / 2;
        Rect rect5 = this.Og;
        rect5.right = rect5.left + i2;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Og
    protected void pA(Canvas canvas) {
        canvas.drawBitmap(this.KZx, this.Og, getBounds(), this.ZZv);
    }
}
