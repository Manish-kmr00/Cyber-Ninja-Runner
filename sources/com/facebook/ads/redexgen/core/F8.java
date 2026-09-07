package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class F8 extends FrameLayout {
    public int A00;
    public int A01;
    public final ImageView A02;
    public final ImageView A03;

    public F8(C2699k1 c2699k1) {
        super(c2699k1);
        this.A03 = new ImageView(c2699k1);
        this.A02 = new ImageView(c2699k1);
        A00();
    }

    public F8(C2699k1 c2699k1, AttributeSet attributeSet) {
        super(c2699k1, attributeSet);
        this.A03 = new ImageView(c2699k1, attributeSet);
        this.A02 = new ImageView(c2699k1, attributeSet);
        A00();
    }

    public F8(C2699k1 c2699k1, AttributeSet attributeSet, int i) {
        super(c2699k1, attributeSet, i);
        this.A03 = new ImageView(c2699k1, attributeSet, i);
        this.A02 = new ImageView(c2699k1, attributeSet, i);
        A00();
    }

    public F8(C2699k1 c2699k1, AttributeSet attributeSet, int i, int i2) {
        super(c2699k1, attributeSet, i, i2);
        this.A03 = new ImageView(c2699k1, attributeSet, i, i2);
        this.A02 = new ImageView(c2699k1, attributeSet, i, i2);
        A00();
    }

    private void A00() {
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
        addView(this.A03, new FrameLayout.LayoutParams(-2, -2));
        CU.A04(this.A03, CU.A0B);
        setId(D3.A00());
    }

    public ImageView getBodyImageView() {
        return this.A03;
    }

    public int getImageHeight() {
        return this.A00;
    }

    public int getImageWidth() {
        return this.A01;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.A01 <= 0 || this.A00 <= 0) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        float fMin = Math.min(i5 / this.A01, i6 / this.A00);
        int i7 = (int) (this.A01 * fMin);
        int i8 = (int) (this.A00 * fMin);
        this.A02.layout(i, i2, i3, i4);
        int blurBorderViewHeight = (i5 / 2) + i;
        int blurBorderViewWidth = (i6 / 2) + i2;
        this.A03.layout(blurBorderViewHeight - (i7 / 2), blurBorderViewWidth - (i8 / 2), (i7 / 2) + blurBorderViewHeight, blurBorderViewWidth + (i8 / 2));
        this.A02.setVisibility(0);
    }

    public void setImage(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            D3.A0Q(this.A02, new BitmapDrawable(getContext().getResources(), bitmap2));
        } else {
            D3.A0K(this.A02, 0);
        }
        if (bitmap != null) {
            this.A01 = bitmap.getWidth();
            this.A00 = bitmap.getHeight();
            this.A03.setImageBitmap(Bitmap.createBitmap(bitmap));
            return;
        }
        this.A03.setImageDrawable(null);
    }
}
