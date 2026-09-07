package com.bytedance.sdk.openadsdk.component.Bzk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aBv;
import com.bytedance.sdk.openadsdk.core.widget.oX;
import com.bytedance.sdk.openadsdk.utils.Bzk;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes6.dex */
public class ZZv extends KZx {
    private final com.bytedance.sdk.openadsdk.core.ML.omh DX;
    private final oX Sn;
    private final com.bytedance.sdk.openadsdk.core.ML.KZx Wx;
    private final com.bytedance.sdk.openadsdk.core.ML.ML aBv;
    private final com.bytedance.sdk.openadsdk.core.ML.ZZv oX;

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx, com.bytedance.sdk.openadsdk.core.ML.SD, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx, com.bytedance.sdk.openadsdk.core.ML.SD, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public ZZv(Context context) {
        super(context);
        setId(520093753);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
        int iKZx = Vgu.KZx(context, 8.0f);
        int iKZx2 = Vgu.KZx(context, 9.0f);
        int iKZx3 = Vgu.KZx(context, 10.0f);
        int iKZx4 = Vgu.KZx(context, 40.0f);
        this.WV = new com.bytedance.sdk.openadsdk.core.widget.KZx(context);
        this.WV.setPadding(iKZx2, 0, iKZx2, 0);
        this.WV.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Vgu.KZx(context, 32.0f), Vgu.KZx(context, 14.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, iKZx3, iKZx3);
        this.WV.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        this.Wx = kZx;
        kZx.setBackgroundColor(-1);
        kZx.setId(520093758);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, Vgu.KZx(context, 107.0f));
        layoutParams2.addRule(12);
        kZx.setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setOrientation(0);
        ml.setGravity(16);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        ml.setLayoutParams(layoutParams3);
        kZx.addView(ml);
        this.JG = new aBv(context);
        this.JG.setId(520093759);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(iKZx4, iKZx4);
        layoutParams4.rightMargin = iKZx;
        layoutParams4.setMarginEnd(iKZx);
        this.JG.setLayoutParams(layoutParams4);
        this.SD = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.SD.setId(520093761);
        this.SD.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.SD.setEllipsize(TextUtils.TruncateAt.END);
        this.SD.setMaxLines(2);
        this.SD.setTextColor(Color.parseColor("#161823"));
        this.SD.setTextSize(30.0f);
        ml.addView(this.JG);
        ml.addView(this.SD);
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx2 = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(2, kZx.getId());
        layoutParams5.addRule(10);
        kZx2.setLayoutParams(layoutParams5);
        this.pA = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        this.pA.setId(520093754);
        this.pA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        kZx2.addView(this.pA, new FrameLayout.LayoutParams(-1, -1));
        this.Og = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        this.Og.setId(520093755);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.gravity = 17;
        kZx2.addView(this.Og, layoutParams6);
        this.KZx = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        this.KZx.setId(520093756);
        kZx2.addView(this.KZx, new FrameLayout.LayoutParams(-1, -1));
        this.ML = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.ML.setId(520093717);
        this.ML.setBackground(Bzk.pA(context, Color.parseColor("#b3000000"), 24));
        this.ML.setEllipsize(TextUtils.TruncateAt.END);
        this.ML.setGravity(17);
        this.ML.setSingleLine(true);
        this.ML.setText(yFO.pA(context, "tt_video_download_apk"));
        this.ML.setTextColor(-1);
        this.ML.setTextSize(1, 16.0f);
        this.ML.setTag("open_ad_click_button_tag");
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(Vgu.KZx(context, 236.0f), Vgu.KZx(context, 48.0f));
        layoutParams7.gravity = 81;
        layoutParams7.bottomMargin = Vgu.KZx(context, 32.0f);
        kZx2.addView(this.ML, layoutParams7);
        com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        this.aBv = ml2;
        ml2.setOrientation(0);
        ml2.setGravity(16);
        ml2.setBackground(new pA(context));
        ml2.setPadding(Vgu.KZx(context, 16.0f), Vgu.KZx(context, 8.0f), Vgu.KZx(context, 16.0f), Vgu.KZx(context, 8.0f));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(10);
        layoutParams8.topMargin = Vgu.KZx(context, 90.0f);
        ml2.setLayoutParams(layoutParams8);
        aBv abv = new aBv(context);
        this.oX = abv;
        ml2.addView(abv, new LinearLayout.LayoutParams(Vgu.KZx(context, 36.0f), Vgu.KZx(context, 36.0f)));
        com.bytedance.sdk.openadsdk.core.ML.ML ml3 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.leftMargin = Vgu.KZx(context, 8.0f);
        ml2.addView(ml3, layoutParams9);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.DX = omhVar;
        omhVar.setTextColor(-1);
        ml3.addView(omhVar, new LinearLayout.LayoutParams(-2, -2));
        oX oXVar = new oX(context, true);
        this.Sn = oXVar;
        ml3.addView(oXVar, new LinearLayout.LayoutParams(-2, -2));
        this.ZZv = new PAGLogoView(context);
        this.ZZv.setId(520093757);
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-2, Vgu.KZx(context, 14.0f));
        layoutParams10.gravity = 83;
        kZx2.addView(this.ZZv, layoutParams10);
        addView(kZx2);
        addView(this.WV);
        addView(kZx);
        addView(this.omh);
        addView(ml2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public View getUserInfo() {
        return this.Wx;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public com.bytedance.sdk.openadsdk.core.ML.omh getAdTitleTextView() {
        return this.DX;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public com.bytedance.sdk.openadsdk.core.ML.ZZv getAdIconView() {
        return this.oX;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public oX getScoreBar() {
        return this.Sn;
    }

    private static final class pA extends Drawable {
        private final boolean ZZv;
        private static final int ML = Color.parseColor("#b0000000");
        private static final int JG = Color.parseColor("#40000000");
        private final RectF pA = new RectF();
        private final Paint Og = new Paint();
        private final Path KZx = new Path();

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public pA(Context context) {
            this.ZZv = com.bytedance.sdk.component.adexpress.ZZv.Og.pA(context);
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            float[] fArr;
            super.onBoundsChange(rect);
            this.pA.set(rect);
            this.KZx.reset();
            int iHeight = rect.height() / 2;
            Path path = this.KZx;
            RectF rectF = this.pA;
            if (this.ZZv) {
                float f = iHeight;
                fArr = new float[]{f, f, 0.0f, 0.0f, 0.0f, 0.0f, f, f};
            } else {
                float f2 = iHeight;
                fArr = new float[]{0.0f, 0.0f, f2, f2, f2, f2, 0.0f, 0.0f};
            }
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            float f3 = rect.right;
            boolean z = this.ZZv;
            this.Og.setShader(new LinearGradient(0.0f, 0.0f, f3, 0.0f, new int[]{z ? JG : ML, z ? ML : JG}, (float[]) null, Shader.TileMode.CLAMP));
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawPath(this.KZx, this.Og);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public com.bytedance.sdk.openadsdk.core.ML.ML getOverlayLayout() {
        return this.aBv;
    }
}
