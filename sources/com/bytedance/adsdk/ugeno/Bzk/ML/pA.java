package com.bytedance.adsdk.ugeno.Bzk.ML;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.KZx;
import com.bytedance.adsdk.ugeno.SD.ZZv;
import com.bytedance.adsdk.ugeno.SD.omh;

/* JADX INFO: loaded from: classes9.dex */
public class pA extends FrameLayout {
    private LinearLayout JG;
    private double KZx;
    private LinearLayout ML;
    private float Og;
    private Context SD;
    private float ZZv;
    private KZx omh;
    private float pA;

    public pA(Context context) {
        super(context);
        this.SD = context;
        this.ML = new LinearLayout(context);
        this.JG = new LinearLayout(context);
        this.ML.setOrientation(0);
        this.ML.setGravity(GravityCompat.START);
        this.JG.setOrientation(0);
        this.JG.setGravity(GravityCompat.START);
    }

    public void pA(double d, int i, int i2, float f, int i3) {
        removeAllViews();
        this.ML.removeAllViews();
        this.JG.removeAllViews();
        this.pA = (int) omh.pA(this.SD, f);
        this.Og = (int) omh.pA(this.SD, f);
        this.KZx = d;
        this.ZZv = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setImageResource(ZZv.pA(this.SD, "tt_ugen_rating_star"));
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.JG.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageResource(ZZv.pA(this.SD, "tt_ugen_rating_star"));
            starImageView2.setColorFilter(i2);
            this.ML.addView(starImageView2);
        }
        addView(this.ML);
        addView(this.JG);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.pA, (int) this.Og);
        layoutParams.leftMargin = (int) this.ZZv;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) this.ZZv;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        KZx kZx = this.omh;
        if (kZx != null) {
            kZx.pA(i, i2);
        }
        super.onMeasure(i, i2);
        this.ML.measure(i, i2);
        double dFloor = Math.floor(this.KZx);
        float f = this.ZZv;
        float f2 = this.pA;
        this.JG.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (f + f + f2)) * dFloor) + ((double) f) + ((this.KZx - dFloor) * ((double) f2))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.ML.getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        KZx kZx = this.omh;
        if (kZx != null) {
            kZx.pA(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        KZx kZx = this.omh;
        if (kZx != null) {
            kZx.SD();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KZx kZx = this.omh;
        if (kZx != null) {
            kZx.omh();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        KZx kZx = this.omh;
        if (kZx != null) {
            kZx.Og(i, i2, i3, i4);
        }
    }

    public void pA(KZx kZx) {
        this.omh = kZx;
    }
}
