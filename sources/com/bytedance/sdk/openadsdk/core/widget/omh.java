package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.eG;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class omh extends com.bytedance.sdk.openadsdk.core.ML.SD {
    private boolean JG;
    private Bzk KZx;
    private com.bytedance.sdk.openadsdk.core.ML.ZZv ML;
    private com.bytedance.sdk.openadsdk.core.ML.omh Og;
    private boolean SD;
    private com.bytedance.sdk.openadsdk.core.ML.omh ZZv;
    private aBv pA;

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

    protected boolean pA() {
        return true;
    }

    public omh(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (pA()) {
            Og();
        }
    }

    public void pA(final com.bytedance.sdk.openadsdk.core.model.yFO yfo, int i) {
        if (!this.JG || yfo == null || this.SD) {
            return;
        }
        this.SD = true;
        boolean zFN = yfo.fN();
        if (!zFN && yfo.fJy() != null && !TextUtils.isEmpty(yfo.fJy().pA())) {
            try {
                com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(yfo.fJy()).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(yfo, yfo.fJy().pA(), new eG(this.pA)));
            } catch (Throwable unused) {
                this.pA.setVisibility(8);
            }
        } else {
            this.pA.setVisibility(8);
        }
        if (zFN) {
            this.Og.setText("Loading");
        } else if (!TextUtils.isEmpty(yfo.SXO())) {
            this.Og.setText(yfo.SXO());
        } else {
            this.Og.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = this.ZZv;
        if (omhVar != null) {
            omhVar.setText(yfo.gy());
        }
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = this.ML;
        if (zZv != null) {
            zZv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.omh.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/omh$1;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_omh$1_onClick_d1ad645265be64c4e184c16bb39fa796(view);
                }

                public void safedk_omh$1_onClick_d1ad645265be64c4e184c16bb39fa796(View p0) {
                    Context context = omh.this.getContext();
                    com.bytedance.sdk.openadsdk.core.model.yFO yfo2 = yfo;
                    TTWebsiteActivity.pA(context, yfo2, gbA.pA(yfo2));
                }
            });
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ML.getLayoutParams();
            if (i == 1) {
                marginLayoutParams.width = Vgu.KZx(getContext(), 64.0f);
                marginLayoutParams.height = Vgu.KZx(getContext(), 24.0f);
                marginLayoutParams.bottomMargin = Vgu.KZx(getContext(), 60.0f);
            } else {
                marginLayoutParams.width = Vgu.KZx(getContext(), 41.0f);
                marginLayoutParams.height = Vgu.KZx(getContext(), 15.0f);
                marginLayoutParams.bottomMargin = Vgu.KZx(getContext(), 24.0f);
            }
            this.ML.setLayoutParams(marginLayoutParams);
        }
    }

    public void Og() {
        if (this.JG) {
            return;
        }
        this.JG = true;
        Context context = getContext();
        setBackgroundColor(Color.parseColor("#2E2E2E"));
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        aBv abv = new aBv(context);
        this.pA = abv;
        abv.setId(520093745);
        int iKZx = Vgu.KZx(context, 64.0f);
        this.pA.setLayoutParams(new RelativeLayout.LayoutParams(iKZx, iKZx));
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.Og = omhVar;
        omhVar.setId(520093746);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(Vgu.KZx(context, 219.0f), -2);
        layoutParams2.topMargin = Vgu.KZx(context, 16.0f);
        this.Og.setLayoutParams(layoutParams2);
        this.Og.setEllipsize(TextUtils.TruncateAt.END);
        this.Og.setGravity(17);
        this.Og.setMaxWidth(Vgu.KZx(context, 150.0f));
        this.Og.setMaxLines(2);
        this.Og.setTextColor(-1);
        this.Og.setTextSize(1, 16.0f);
        Bzk bzk = new Bzk(context);
        this.KZx = bzk;
        bzk.setId(520093748);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(Vgu.KZx(context, 219.0f), Vgu.KZx(context, 6.0f));
        layoutParams3.topMargin = Vgu.KZx(context, 24.0f);
        this.KZx.setLayoutParams(layoutParams3);
        this.ZZv = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(Vgu.KZx(context, 138.0f), Vgu.KZx(context, 42.0f));
        layoutParams4.topMargin = Vgu.KZx(context, 48.0f);
        this.ZZv.setLayoutParams(layoutParams4);
        this.ZZv.setTextColor(-1);
        this.ZZv.setTextSize(16.0f);
        this.ZZv.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(2, -1);
        gradientDrawable.setCornerRadius(layoutParams4.height / 2);
        this.ZZv.setBackground(gradientDrawable);
        linearLayout.addView(this.pA);
        linearLayout.addView(this.Og);
        linearLayout.addView(this.KZx);
        linearLayout.addView(this.ZZv);
        pA(context);
        addView(linearLayout);
        addView(this.ML);
    }

    public void pA(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        this.ML = zZv;
        zZv.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(context, "tt_ad_logo_big"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Vgu.KZx(context, 64.0f), Vgu.KZx(context, 24.0f));
        layoutParams.bottomMargin = Vgu.KZx(context, 60.0f);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.ML.setLayoutParams(layoutParams);
    }

    public Bzk getLoadingProgressBar() {
        return this.KZx;
    }

    public com.bytedance.sdk.openadsdk.core.ML.omh getDownloadButton() {
        return this.ZZv;
    }

    public void setProgress(int i) {
        Bzk bzk = this.KZx;
        if (bzk != null) {
            bzk.setProgress(i);
        }
    }
}
