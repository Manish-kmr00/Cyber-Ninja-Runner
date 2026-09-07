package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class SGo extends FrameLayout {
    private String Bzk;
    private PAGLogoView JG;
    private TextView KZx;
    private TextView ML;
    private aBv Og;
    private com.bytedance.sdk.openadsdk.core.ML.omh SD;
    private com.bytedance.sdk.openadsdk.core.Og.pA SGo;
    private oX ZZv;
    private com.bytedance.sdk.openadsdk.core.model.yFO omh;
    private boolean pA;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public SGo(Context context) {
        super(context);
        setVisibility(8);
        setId(com.bytedance.sdk.openadsdk.utils.Sn.rtW);
    }

    public void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str, com.bytedance.sdk.openadsdk.core.Og.pA pAVar) {
        this.omh = yfo;
        this.Bzk = str;
        this.SGo = pAVar;
    }

    public void setClickListener(com.bytedance.sdk.openadsdk.core.Og.pA pAVar) {
        this.SGo = pAVar;
        TextView textView = this.ML;
        if (textView != null) {
            textView.setOnClickListener(pAVar);
            this.ML.setOnTouchListener(this.SGo);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            pA();
        }
    }

    private void pA() {
        if (this.pA) {
            return;
        }
        this.pA = true;
        Og();
        this.ML.setOnClickListener(this.SGo);
        this.ML.setOnTouchListener(this.SGo);
        String strGy = this.omh.gy();
        if (!TextUtils.isEmpty(strGy)) {
            this.ML.setText(strGy);
        }
        if (this.Og != null && this.omh.fJy() != null && !TextUtils.isEmpty(this.omh.fJy().pA())) {
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.omh.fJy(), this.Og, this.omh);
        }
        oX oXVar = this.ZZv;
        if (oXVar != null) {
            Vgu.pA((TextView) null, oXVar, this.omh);
            if (this.omh.Wo() != null) {
                this.ZZv.setVisibility(0);
            }
        }
        if (this.KZx != null) {
            if (this.omh.Wo() != null && !TextUtils.isEmpty(this.omh.Wo().Og())) {
                this.KZx.setText(this.omh.Wo().Og());
            } else if (!TextUtils.isEmpty(this.omh.HSv())) {
                this.KZx.setText(this.omh.HSv());
            } else {
                this.KZx.setVisibility(8);
            }
        }
        if (this.SD != null) {
            String strSXO = this.omh.SXO();
            if (!TextUtils.isEmpty(strSXO)) {
                this.SD.setText(strSXO);
            } else {
                this.SD.setVisibility(8);
            }
        }
        this.JG.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.SGo.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/SGo$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_SGo$1_onClick_e0059ab67d2ca078d8c4aa0ad479480a(view);
            }

            public void safedk_SGo$1_onClick_e0059ab67d2ca078d8c4aa0ad479480a(View p0) {
                try {
                    TTWebsiteActivity.pA(SGo.this.getContext(), SGo.this.omh, SGo.this.Bzk);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void Og() {
        FrameLayout.LayoutParams layoutParams;
        Context context = getContext();
        boolean z = this.omh.rtW() == 1;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setGravity(1);
        ml.setOrientation(1);
        if (z) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(Vgu.KZx(context, 327.0f), -2);
        }
        layoutParams.gravity = 17;
        int iKZx = Vgu.KZx(context, 24.0f);
        layoutParams.rightMargin = iKZx;
        layoutParams.leftMargin = iKZx;
        addView(ml, layoutParams);
        aBv abv = new aBv(context);
        this.Og = abv;
        abv.setBackgroundColor(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(Vgu.KZx(context, 80.0f), Vgu.KZx(context, 80.0f));
        layoutParams2.bottomMargin = Vgu.KZx(context, 12.0f);
        ml.addView(this.Og, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.KZx = omhVar;
        omhVar.setEllipsize(TextUtils.TruncateAt.END);
        this.KZx.setGravity(17);
        this.KZx.setMaxLines(2);
        this.KZx.setMaxWidth(Vgu.KZx(context, 180.0f));
        this.KZx.setTextColor(-1);
        this.KZx.setTextSize(2, 24.0f);
        ml.addView(this.KZx, new LinearLayout.LayoutParams(-1, -2));
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar2 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.SD = omhVar2;
        omhVar2.setEllipsize(TextUtils.TruncateAt.END);
        this.SD.setGravity(17);
        this.SD.setMaxLines(2);
        this.SD.setTextColor(Color.parseColor("#BFFFFFFF"));
        this.SD.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = Vgu.KZx(context, 8.0f);
        ml.addView(this.SD, layoutParams3);
        this.ZZv = new oX(context, true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, Vgu.KZx(context, 16.0f));
        layoutParams4.topMargin = Vgu.KZx(context, 12.0f);
        this.ZZv.setVisibility(8);
        ml.addView(this.ZZv, layoutParams4);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar3 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.ML = omhVar3;
        omhVar3.setId(520093707);
        this.ML.setGravity(17);
        this.ML.setText(com.bytedance.sdk.component.utils.yFO.pA(context, "tt_video_download_apk"));
        this.ML.setTextColor(-1);
        this.ML.setTextSize(2, 16.0f);
        this.ML.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_reward_full_video_backup_btn_bg"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, Vgu.KZx(context, 44.0f));
        layoutParams5.topMargin = Vgu.KZx(context, 54.0f);
        ml.addView(this.ML, layoutParams5);
        this.JG = new PAGLogoView(context);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, Vgu.KZx(context, 14.0f));
        layoutParams6.gravity = 8388691;
        layoutParams6.leftMargin = Vgu.KZx(context, 18.0f);
        if (z) {
            layoutParams6.bottomMargin = Vgu.KZx(context, 61.0f);
        } else {
            layoutParams6.bottomMargin = Vgu.KZx(context, 24.0f);
        }
        addView(this.JG, layoutParams6);
    }
}
