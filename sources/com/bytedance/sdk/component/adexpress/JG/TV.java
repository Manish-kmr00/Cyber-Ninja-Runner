package com.bytedance.sdk.component.adexpress.JG;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes5.dex */
public class TV extends FrameLayout {
    private static final int Bzk = (com.bytedance.sdk.component.adexpress.dynamic.ML.BSW.Og("", 0.0f, true)[1] / 2) + 1;
    private static final int SGo = (com.bytedance.sdk.component.adexpress.dynamic.ML.BSW.Og("", 0.0f, true)[1] / 2) + 3;
    private Drawable JG;
    private float KZx;
    private Drawable ML;
    LinearLayout Og;
    private double SD;
    private float ZZv;
    private float omh;
    LinearLayout pA;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public TV(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pA = new LinearLayout(getContext());
        this.Og = new LinearLayout(getContext());
        this.pA.setOrientation(0);
        this.pA.setGravity(GravityCompat.START);
        this.Og.setOrientation(0);
        this.Og.setGravity(GravityCompat.START);
        this.ML = com.bytedance.sdk.component.utils.yFO.KZx(context, "tt_star_thick");
        this.JG = com.bytedance.sdk.component.utils.yFO.KZx(context, "tt_star");
    }

    public Drawable getStarEmptyDrawable() {
        return this.ML;
    }

    public Drawable getStarFillDrawable() {
        return this.JG;
    }

    public void pA(double d, int i, int i2, int i3) {
        float f = i2;
        this.KZx = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.KZx(getContext(), f);
        this.ZZv = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.KZx(getContext(), f);
        this.SD = d;
        this.omh = i3;
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.Og.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.pA.addView(starImageView2);
        }
        addView(this.pA);
        addView(this.Og);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.KZx, (int) this.ZZv));
        imageView.setPadding(1, Bzk, 1, SGo);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.pA.measure(i, i2);
        double d = this.SD;
        float f = this.KZx;
        this.Og.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((((int) d) * f) + 1.0f)) + (((double) (f - 2.0f)) * (d - ((double) ((int) d))))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.pA.getMeasuredHeight(), 1073741824));
        if (this.omh > 0.0f) {
            LinearLayout linearLayout = this.pA;
            linearLayout.setPadding(0, ((int) (linearLayout.getMeasuredHeight() - this.omh)) / 2, 0, 0);
            this.Og.setPadding(0, ((int) (this.pA.getMeasuredHeight() - this.omh)) / 2, 0, 0);
        }
    }
}
