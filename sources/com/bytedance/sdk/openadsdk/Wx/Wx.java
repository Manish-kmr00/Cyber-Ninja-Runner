package com.bytedance.sdk.openadsdk.Wx;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class Wx extends com.bytedance.sdk.openadsdk.core.ML.SD {
    @Override // com.bytedance.sdk.openadsdk.core.ML.SD, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.SD, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public Wx(Context context) {
        this(context, null);
    }

    public Wx(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Wx(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        pA(context);
    }

    private void pA(Context context) {
        setId(520093726);
        setBackgroundColor(-1);
        com.bytedance.sdk.openadsdk.core.ML.SD sd = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        sd.setId(com.bytedance.sdk.openadsdk.utils.Sn.ka);
        sd.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        sd.setBackgroundColor(0);
        sd.setGravity(17);
        addView(sd);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv.setId(com.bytedance.sdk.openadsdk.utils.Sn.uhO);
        zZv.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        sd.addView(zZv);
        com.bytedance.sdk.openadsdk.core.ML.JG jg = new com.bytedance.sdk.openadsdk.core.ML.JG(context);
        jg.setId(com.bytedance.sdk.openadsdk.utils.Sn.bA);
        int iKZx = Vgu.KZx(context, 60.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iKZx, iKZx);
        layoutParams.addRule(13);
        jg.setLayoutParams(layoutParams);
        jg.setIndeterminateDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_video_loading_progress_bar"));
        sd.addView(jg);
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setId(com.bytedance.sdk.openadsdk.utils.Sn.GbR);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        ml.setLayoutParams(layoutParams2);
        ml.setGravity(1);
        ml.setOrientation(1);
        ml.setVisibility(8);
        sd.addView(ml);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv2 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv2.setId(com.bytedance.sdk.openadsdk.utils.Sn.aj);
        zZv2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        zZv2.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_refreshing_video_textpage"));
        zZv2.setScaleType(ImageView.ScaleType.CENTER);
        ml.addView(zZv2);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar.setId(com.bytedance.sdk.openadsdk.utils.Sn.sPI);
        omhVar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        omhVar.setText(yFO.pA(context, "tt_video_retry_des_txt"));
        omhVar.setTextColor(Color.parseColor("#999999"));
        ml.addView(omhVar);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv3 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv3.setId(com.bytedance.sdk.openadsdk.utils.Sn.lgT);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        zZv3.setLayoutParams(layoutParams3);
        zZv3.setScaleType(ImageView.ScaleType.CENTER);
        zZv3.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_play_movebar_textpage"));
        zZv3.setVisibility(8);
        addView(zZv3);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv4 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv4.setId(com.bytedance.sdk.openadsdk.utils.Sn.BDQ);
        int iKZx2 = Vgu.KZx(context, 30.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iKZx2, iKZx2);
        layoutParams4.addRule(21);
        layoutParams4.addRule(11);
        int iKZx3 = Vgu.KZx(context, 7.0f);
        layoutParams4.setMarginEnd(iKZx3);
        layoutParams4.rightMargin = iKZx3;
        layoutParams4.topMargin = iKZx3;
        zZv4.setLayoutParams(layoutParams4);
        zZv4.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_detail_video_btn_bg"));
        zZv4.setScaleType(ImageView.ScaleType.CENTER);
        zZv4.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_close_move_detail"));
        addView(zZv4);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar2 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar2.setId(com.bytedance.sdk.openadsdk.utils.Sn.FK);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(9);
        layoutParams5.addRule(20);
        layoutParams5.addRule(10);
        omhVar2.setLayoutParams(layoutParams5);
        omhVar2.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_video_black_desc_gradient"));
        omhVar2.setEllipsize(TextUtils.TruncateAt.END);
        omhVar2.setMaxLines(2);
        int iKZx4 = Vgu.KZx(context, 15.0f);
        omhVar2.setPadding(iKZx4, Vgu.KZx(context, 14.0f), iKZx4, 0);
        omhVar2.setSingleLine(false);
        omhVar2.setTextColor(-1);
        omhVar2.setTextSize(2, 17.0f);
        omhVar2.setVisibility(8);
        addView(omhVar2);
        com.bytedance.sdk.openadsdk.core.ML.SD sd2 = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        sd2.setId(com.bytedance.sdk.openadsdk.utils.Sn.mY);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(10);
        sd2.setLayoutParams(layoutParams6);
        sd2.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_video_black_desc_gradient"));
        sd2.setGravity(16);
        sd2.setVisibility(8);
        addView(sd2);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv5 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv5.setId(com.bytedance.sdk.openadsdk.utils.Sn.Tsy);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams7.addRule(15);
        int iKZx5 = Vgu.KZx(context, 12.0f);
        layoutParams7.leftMargin = iKZx5;
        layoutParams7.setMarginStart(iKZx5);
        zZv5.setLayoutParams(layoutParams7);
        zZv5.setScaleType(ImageView.ScaleType.CENTER);
        zZv5.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_leftbackbutton_titlebar_photo_preview"));
        sd2.addView(zZv5);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar3 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar3.setId(com.bytedance.sdk.openadsdk.utils.Sn.Qd);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams8.addRule(15);
        int iKZx6 = Vgu.KZx(context, 16.0f);
        layoutParams8.leftMargin = iKZx6;
        layoutParams8.rightMargin = iKZx;
        layoutParams8.setMarginStart(iKZx6);
        layoutParams8.setMarginEnd(iKZx);
        layoutParams8.addRule(17, com.bytedance.sdk.openadsdk.utils.Sn.Tsy);
        layoutParams8.addRule(0, com.bytedance.sdk.openadsdk.utils.Sn.xt);
        layoutParams8.addRule(1, com.bytedance.sdk.openadsdk.utils.Sn.Tsy);
        layoutParams8.addRule(16, com.bytedance.sdk.openadsdk.utils.Sn.xt);
        omhVar3.setLayoutParams(layoutParams8);
        omhVar3.setEllipsize(TextUtils.TruncateAt.END);
        omhVar3.setGravity(16);
        omhVar3.setMaxLines(1);
        omhVar3.setSingleLine(true);
        omhVar3.setTextColor(-1);
        omhVar3.setTextSize(2, 17.0f);
        sd2.addView(omhVar3);
        com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml2.setId(com.bytedance.sdk.openadsdk.utils.Sn.xt);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.addRule(21);
        layoutParams9.addRule(11);
        int iKZx7 = Vgu.KZx(context, 14.0f);
        layoutParams9.rightMargin = iKZx7;
        layoutParams9.setMarginEnd(iKZx7);
        ml2.setLayoutParams(layoutParams9);
        ml2.setGravity(16);
        ml2.setOrientation(1);
        sd2.addView(ml2);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar4 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar4.setId(com.bytedance.sdk.openadsdk.utils.Sn.HMH);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.gravity = 1;
        omhVar4.setLayoutParams(layoutParams10);
        omhVar4.setGravity(16);
        omhVar4.setMaxLines(1);
        omhVar4.setSingleLine(true);
        omhVar4.setTextColor(-1);
        omhVar4.setTextSize(2, 12.0f);
        ml2.addView(omhVar4);
        com.bytedance.sdk.openadsdk.core.ML.ML ml3 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml3.setId(com.bytedance.sdk.openadsdk.utils.Sn.Bpk);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, Vgu.KZx(context, 40.0f));
        layoutParams11.addRule(12);
        layoutParams11.addRule(21);
        layoutParams11.addRule(11);
        ml3.setLayoutParams(layoutParams11);
        ml3.setGravity(16);
        ml3.setOrientation(0);
        ml3.setVisibility(8);
        addView(ml3);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar5 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar5.setId(com.bytedance.sdk.openadsdk.utils.Sn.fg);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.leftMargin = iKZx6;
        layoutParams12.rightMargin = iKZx5;
        layoutParams12.setMarginEnd(iKZx5);
        layoutParams12.setMarginStart(iKZx6);
        omhVar5.setLayoutParams(layoutParams12);
        omhVar5.setText(yFO.pA(context, "tt_00_00"));
        omhVar5.setTextColor(-1);
        omhVar5.setTextSize(2, 10.0f);
        ml3.addView(omhVar5);
        SeekBar seekBar = new SeekBar(context);
        seekBar.setId(com.bytedance.sdk.openadsdk.utils.Sn.PKZ);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(0, Vgu.KZx(context, 5.0f));
        layoutParams13.gravity = 16;
        seekBar.setLayoutParams(layoutParams13);
        seekBar.setMax(100);
        seekBar.setPadding(0, 0, 0, 0);
        seekBar.setProgressDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_seek_progress"));
        seekBar.setThumb(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_seek_thumb"));
        seekBar.setThumbOffset(0);
        ml3.addView(seekBar);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar6 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar6.setId(com.bytedance.sdk.openadsdk.utils.Sn.FHA);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams14.leftMargin = iKZx5;
        layoutParams14.rightMargin = iKZx6;
        layoutParams14.setMarginEnd(iKZx6);
        layoutParams14.setMarginStart(iKZx5);
        omhVar6.setLayoutParams(layoutParams14);
        omhVar6.setText(yFO.pA(context, "tt_00_00"));
        omhVar6.setTextColor(-1);
        omhVar6.setTextSize(2, 10.0f);
        ml3.addView(omhVar6);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv6 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv6.setId(com.bytedance.sdk.openadsdk.utils.Sn.Kj);
        zZv6.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        zZv6.setPadding(iKZx6, 0, iKZx6, 0);
        zZv6.setScaleType(ImageView.ScaleType.CENTER);
        zZv6.setVisibility(8);
        zZv6.setImageDrawable(yFO.KZx(context, "tt_enlarge_video"));
        ml3.addView(zZv6);
        WV wv = new WV(context);
        wv.setId(com.bytedance.sdk.openadsdk.utils.Sn.Xj);
        wv.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(wv);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar7 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar7.setId(com.bytedance.sdk.openadsdk.utils.Sn.rX);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.leftMargin = iKZx5;
        layoutParams15.addRule(9);
        layoutParams15.addRule(20);
        omhVar7.setLayoutParams(layoutParams15);
        omhVar7.setBackgroundColor(Color.parseColor("#00000000"));
        omhVar7.setText("close");
        omhVar7.setMinHeight(Vgu.KZx(context, 44.0f));
        omhVar7.setCompoundDrawablesWithIntrinsicBounds(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_shadow_btn_back"), (Drawable) null, (Drawable) null, (Drawable) null);
        addView(omhVar7);
    }
}
