package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class Og extends Dialog {
    private String BSW;
    private String Bzk;
    private com.bytedance.sdk.openadsdk.core.ML.pA JG;
    private com.bytedance.sdk.openadsdk.core.ML.omh KZx;
    private com.bytedance.sdk.openadsdk.core.ML.pA ML;
    private com.bytedance.sdk.openadsdk.core.ML.ZZv Og;
    private View SD;
    private String SGo;
    private boolean Sn;
    private String WV;
    private int Wx;
    private com.bytedance.sdk.openadsdk.core.ML.omh ZZv;
    private final Context omh;
    public pA pA;

    public interface pA {
        void Og();

        void pA();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    public Og(Context context) {
        super(context, com.bytedance.sdk.component.utils.yFO.JG(context, "tt_custom_dialog"));
        this.Wx = -1;
        this.Sn = false;
        this.omh = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(pA(this.omh));
        setCanceledOnTouchOutside(false);
        Og();
        pA();
    }

    private void pA() {
        this.JG.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.Og.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/Og$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_Og$1_onClick_38f0329bf2388d68b73c95f2ba846e4c(view);
            }

            public void safedk_Og$1_onClick_38f0329bf2388d68b73c95f2ba846e4c(View p0) {
                if (Og.this.pA != null) {
                    Og.this.pA.pA();
                }
            }
        });
        this.ML.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.Og.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/Og$2;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_Og$2_onClick_bcb341d3921105431f17d7448f47d9f7(view);
            }

            public void safedk_Og$2_onClick_bcb341d3921105431f17d7448f47d9f7(View p0) {
                if (Og.this.pA != null) {
                    Og.this.pA.Og();
                }
            }
        });
    }

    private void Og() {
        if (!TextUtils.isEmpty(this.SGo)) {
            this.KZx.setText(this.SGo);
            this.KZx.setVisibility(0);
        } else {
            this.KZx.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.Bzk)) {
            this.ZZv.setText(this.Bzk);
        }
        if (!TextUtils.isEmpty(this.BSW)) {
            this.JG.setText(this.BSW);
        } else {
            this.JG.setText(com.bytedance.sdk.component.utils.yFO.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), "tt_postive_txt"));
        }
        if (!TextUtils.isEmpty(this.WV)) {
            this.ML.setText(this.WV);
        } else {
            this.ML.setText(com.bytedance.sdk.component.utils.yFO.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), "tt_negtive_txt"));
        }
        int i = this.Wx;
        if (i != -1) {
            this.Og.setImageResource(i);
            this.Og.setVisibility(0);
        } else {
            this.Og.setVisibility(8);
        }
        if (this.Sn) {
            this.SD.setVisibility(8);
            this.ML.setVisibility(8);
        } else {
            this.ML.setVisibility(0);
            this.SD.setVisibility(0);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Og();
    }

    private View pA(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.SD sd = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        sd.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        ml.setMinimumWidth(pA(260.0f));
        ml.setPadding(0, pA(32.0f), 0, 0);
        ml.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_custom_dialog_bg"));
        ml.setOrientation(1);
        ml.setLayoutParams(layoutParams);
        this.KZx = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.leftMargin = pA(16.0f);
        layoutParams2.rightMargin = pA(16.0f);
        layoutParams2.bottomMargin = pA(16.0f);
        this.KZx.setGravity(17);
        this.KZx.setVisibility(0);
        this.KZx.setTextColor(Color.parseColor("#333333"));
        this.KZx.setTextSize(18.0f);
        this.KZx.setLayoutParams(layoutParams2);
        this.Og = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        layoutParams3.leftMargin = pA(16.0f);
        layoutParams3.rightMargin = pA(16.0f);
        layoutParams3.bottomMargin = pA(10.0f);
        this.Og.setMaxHeight(pA(150.0f));
        this.Og.setMaxWidth(pA(150.0f));
        this.Og.setVisibility(0);
        this.Og.setLayoutParams(layoutParams3);
        this.ZZv = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.leftMargin = pA(20.0f);
        layoutParams4.rightMargin = pA(20.0f);
        this.ZZv.setGravity(17);
        this.ZZv.setLineSpacing(pA(3.0f), 1.2f);
        this.ZZv.setTextSize(18.0f);
        this.ZZv.setTextColor(Color.parseColor("#000000"));
        this.ZZv.setLayoutParams(layoutParams4);
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams5.topMargin = pA(32.0f);
        view.setBackgroundColor(Color.parseColor("#E4E4E4"));
        view.setLayoutParams(layoutParams5);
        com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        ml2.setOrientation(0);
        ml2.setLayoutParams(layoutParams6);
        com.bytedance.sdk.openadsdk.core.ML.pA pAVar = new com.bytedance.sdk.openadsdk.core.ML.pA(context);
        this.ML = pAVar;
        pAVar.setId(520093718);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        layoutParams7.leftMargin = pA(10.0f);
        layoutParams7.weight = 1.0f;
        this.ML.setPadding(0, pA(16.0f), 0, pA(16.0f));
        this.ML.setBackground(null);
        this.ML.setGravity(17);
        this.ML.setSingleLine(true);
        this.ML.setTextColor(Color.parseColor("#999999"));
        this.ML.setTextSize(16.0f);
        this.ML.setLayoutParams(layoutParams7);
        this.SD = new View(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(1, -1);
        this.SD.setBackgroundColor(Color.parseColor("#E4E4E4"));
        this.SD.setLayoutParams(layoutParams8);
        this.JG = new com.bytedance.sdk.openadsdk.core.ML.pA(context);
        this.ML.setId(520093719);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, -2);
        layoutParams9.rightMargin = pA(10.0f);
        layoutParams9.weight = 1.0f;
        this.JG.setPadding(0, pA(16.0f), 0, pA(16.0f));
        this.JG.setBackground(null);
        this.JG.setGravity(17);
        this.JG.setSingleLine(true);
        this.JG.setTextColor(Color.parseColor("#38ADFF"));
        this.JG.setTextSize(16.0f);
        this.JG.setLayoutParams(layoutParams9);
        sd.addView(ml);
        ml.addView(this.KZx);
        ml.addView(this.Og);
        ml.addView(this.ZZv);
        ml.addView(view);
        ml.addView(ml2);
        ml2.addView(this.ML);
        ml2.addView(this.SD);
        ml2.addView(this.JG);
        return sd;
    }

    private int pA(float f) {
        return Vgu.KZx(getContext(), f);
    }

    public Og pA(pA pAVar) {
        this.pA = pAVar;
        return this;
    }

    public Og pA(String str) {
        this.Bzk = str;
        return this;
    }

    public Og Og(String str) {
        this.BSW = str;
        return this;
    }

    public Og KZx(String str) {
        this.WV = str;
        return this;
    }
}
