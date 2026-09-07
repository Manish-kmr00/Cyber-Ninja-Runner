package com.bytedance.sdk.openadsdk.component.Bzk;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aBv;
import com.bytedance.sdk.openadsdk.core.widget.oX;
import com.bytedance.sdk.openadsdk.utils.Bzk;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes9.dex */
public class JG extends KZx {
    private final oX Sn;
    private final com.bytedance.sdk.openadsdk.core.ML.ML Wx;

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx, com.bytedance.sdk.openadsdk.core.ML.SD, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public com.bytedance.sdk.openadsdk.core.ML.ZZv getAdIconView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public com.bytedance.sdk.openadsdk.core.ML.omh getAdTitleTextView() {
        return null;
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

    public JG(Context context) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#EDFCFF"), Color.parseColor("#FFF6FD")}));
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        this.Wx = ml;
        ml.setId(520093758);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = Vgu.KZx(context, 24.0f);
        layoutParams.topMargin = Vgu.KZx(context, 56.0f);
        ml.setLayoutParams(layoutParams);
        ml.setClickable(false);
        ml.setGravity(16);
        ml.setOrientation(0);
        this.JG = new aBv(context);
        this.JG.setId(520093759);
        this.JG.setLayoutParams(new LinearLayout.LayoutParams(Vgu.KZx(context, 24.0f), Vgu.KZx(context, 24.0f)));
        this.SD = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.SD.setId(520093761);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = Vgu.KZx(context, 8.0f);
        this.SD.setLayoutParams(layoutParams2);
        this.SD.setEllipsize(TextUtils.TruncateAt.END);
        this.SD.setMaxLines(2);
        this.SD.setTextColor(Color.parseColor("#161823"));
        this.SD.setTextSize(12.0f);
        com.bytedance.sdk.openadsdk.core.ML.SD sd = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(Vgu.KZx(context, 327.0f), -2);
        layoutParams3.addRule(13);
        layoutParams3.leftMargin = Vgu.KZx(context, 24.0f);
        layoutParams3.rightMargin = Vgu.KZx(context, 24.0f);
        sd.setLayoutParams(layoutParams3);
        this.Bzk = new aBv(context);
        this.Bzk.setId(Sn.ZL);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(Vgu.KZx(context, 80.0f), Vgu.KZx(context, 80.0f));
        layoutParams4.addRule(14);
        this.Bzk.setLayoutParams(layoutParams4);
        this.SGo = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.SGo.setId(Sn.zi);
        this.SGo.setTextSize(24.0f);
        this.SGo.setTextColor(Color.parseColor("#161823"));
        this.SGo.setGravity(17);
        this.SGo.setMaxLines(1);
        this.SGo.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(3, Sn.ZL);
        layoutParams5.topMargin = Vgu.KZx(context, 12.0f);
        layoutParams5.addRule(14);
        this.SGo.setLayoutParams(layoutParams5);
        this.BSW = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.BSW.setId(Sn.tpV);
        this.BSW.setTextSize(16.0f);
        this.BSW.setTextColor(Color.parseColor("#80161823"));
        this.BSW.setGravity(17);
        this.BSW.setMaxLines(2);
        this.BSW.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(3, Sn.zi);
        layoutParams6.topMargin = Vgu.KZx(context, 4.0f);
        layoutParams6.addRule(14);
        this.BSW.setLayoutParams(layoutParams6);
        oX oXVar = new oX(context);
        this.Sn = oXVar;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = Vgu.KZx(context, 12.0f);
        oXVar.setLayoutParams(layoutParams7);
        this.ML = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.ML.setId(520093717);
        this.ML.setBackground(Bzk.pA(context, "tt_reward_full_video_backup_btn_bg"));
        this.ML.setEllipsize(TextUtils.TruncateAt.END);
        this.ML.setLines(1);
        this.ML.setGravity(17);
        this.ML.setTextColor(-1);
        this.ML.setTextSize(16.0f);
        this.ML.setTag("open_ad_click_button_tag");
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, Vgu.KZx(context, 44.0f));
        layoutParams8.addRule(3, Sn.tpV);
        layoutParams8.topMargin = Vgu.KZx(context, 54.0f);
        layoutParams8.addRule(14);
        this.ML.setLayoutParams(layoutParams8);
        this.ZZv = new PAGLogoView(context);
        this.ZZv.setId(520093757);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, Vgu.KZx(context, 14.0f));
        layoutParams9.leftMargin = Vgu.KZx(context, 16.0f);
        layoutParams9.bottomMargin = Vgu.KZx(context, 24.0f);
        layoutParams9.addRule(12);
        this.ZZv.setLayoutParams(layoutParams9);
        addView(this.omh);
        ml.addView(this.JG);
        ml.addView(this.SD);
        addView(ml);
        sd.addView(this.Bzk);
        sd.addView(this.SGo);
        sd.addView(this.BSW);
        sd.addView(oXVar);
        sd.addView(this.ML);
        addView(sd);
        addView(this.ZZv);
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public View getUserInfo() {
        return this.Wx;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public oX getScoreBar() {
        return this.Sn;
    }
}
