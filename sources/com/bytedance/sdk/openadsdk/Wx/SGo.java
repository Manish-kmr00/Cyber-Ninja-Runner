package com.bytedance.sdk.openadsdk.Wx;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aBv;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SGo extends com.bytedance.sdk.openadsdk.core.ML.KZx {
    protected com.bytedance.sdk.openadsdk.core.ML.omh JG;
    protected aBv KZx;
    protected com.bytedance.sdk.openadsdk.core.ML.omh ML;
    protected com.bytedance.sdk.openadsdk.core.ML.ZZv Og;
    protected com.bytedance.sdk.openadsdk.core.ML.omh ZZv;
    protected com.bytedance.sdk.openadsdk.core.ML.KZx pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    protected abstract void pA(Context context);

    public SGo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        pA(context);
    }

    public FrameLayout getTtAdContainer() {
        return this.pA;
    }

    public ImageView getTtFullImg() {
        return this.Og;
    }

    public aBv getTtFullAdIcon() {
        return this.KZx;
    }

    public TextView getTtFullAdAppName() {
        return this.ZZv;
    }

    public TextView getTtFullAdDesc() {
        return this.ML;
    }

    public TextView getTtFullAdDownload() {
        return this.JG;
    }

    protected com.bytedance.sdk.openadsdk.core.ML.KZx ML(Context context) {
        return new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
    }

    protected com.bytedance.sdk.openadsdk.core.ML.ZZv JG(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return zZv;
    }

    protected aBv SD(Context context) {
        aBv abv = new aBv(context);
        abv.setScaleType(ImageView.ScaleType.FIT_XY);
        abv.setBackgroundColor(0);
        return abv;
    }

    protected com.bytedance.sdk.openadsdk.core.ML.omh Og(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar.setEllipsize(TextUtils.TruncateAt.END);
        omhVar.setMaxLines(1);
        omhVar.setTextColor(Color.parseColor("#FF999999"));
        omhVar.setTextSize(2, 16.0f);
        return omhVar;
    }

    protected com.bytedance.sdk.openadsdk.core.ML.omh KZx(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar.setEllipsize(TextUtils.TruncateAt.END);
        omhVar.setMaxLines(1);
        omhVar.setSingleLine();
        omhVar.setTextColor(Color.parseColor("#FF999999"));
        omhVar.setTextSize(2, 12.0f);
        return omhVar;
    }

    protected com.bytedance.sdk.openadsdk.core.ML.omh ZZv(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_backup_btn_1"));
        omhVar.setGravity(17);
        omhVar.setText(yFO.pA(context, "tt_video_download_apk"));
        omhVar.setTextColor(-1);
        omhVar.setTextSize(2, 14.0f);
        return omhVar;
    }

    protected PAGLogoView omh(Context context) {
        PAGLogoView pAGLogoView = new PAGLogoView(context);
        pAGLogoView.setId(520093739);
        return pAGLogoView;
    }
}
