package com.bytedance.sdk.openadsdk.common;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.moloco.sdk.acm.b;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import org.json.JSONException;

/* JADX INFO: loaded from: classes7.dex */
public class aBv extends Dialog {
    private static final String[] Og = {"SDK version", "App", "App version", b.d, "Device", "Creative info"};
    private ImageView JG;
    private String KZx;
    private Button ML;
    private TextView ZZv;
    private final Handler pA;

    public aBv(Context context) {
        super(context, yFO.JG(context, "tt_privacy_dialog_theme_ad_report"));
        this.pA = new Handler(Looper.getMainLooper());
        this.KZx = "";
    }

    public void pA(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.KZx = com.bytedance.sdk.component.utils.pA.pA(PangleNetworkBridge.jsonObjectInit(str)).toString();
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("TTPrivacyAdReportDialog", e.getMessage());
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(pA(getContext()), new ViewGroup.LayoutParams(Vgu.KZx(getContext()), (int) (((double) Vgu.ZZv(getContext())) * 0.9d)));
        Og();
        if (getWindow() != null) {
            getWindow().setGravity(80);
        }
    }

    private void Og() {
        final String strML = gbA.ML();
        final String strSD = gbA.SD();
        final String str = "Android " + Build.VERSION.RELEASE;
        final String str2 = Build.BRAND + " " + Build.MODEL;
        this.ML.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.aBv.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/common/aBv$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_aBv$1_onClick_c5c04dea5b326f892aa0933eed579c9a(view);
            }

            public void safedk_aBv$1_onClick_c5c04dea5b326f892aa0933eed579c9a(View p0) {
                ClipboardManager clipboardManager = (ClipboardManager) aBv.this.getContext().getSystemService("clipboard");
                if (clipboardManager != null) {
                    StringBuilder sb = new StringBuilder();
                    String[] strArr = {BuildConfig.VERSION_NAME, strML, strSD, str, str2, aBv.this.KZx};
                    for (int i = 0; i < aBv.Og.length; i++) {
                        sb.append(aBv.Og[i]).append(": ").append(strArr[i]).append("\n");
                    }
                    try {
                        clipboardManager.setPrimaryClip(ClipData.newPlainText("pangle sdk build info", sb));
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        this.JG.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.aBv.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/common/aBv$2;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_aBv$2_onClick_4009df2d373ff6f2a8596f0bd12dc491(view);
            }

            public void safedk_aBv$2_onClick_4009df2d373ff6f2a8596f0bd12dc491(View p0) {
                aBv.this.ZZv.setText("loading ...");
                aBv.this.cancel();
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.pA.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.aBv.3
                @Override // java.lang.Runnable
                public void run() {
                    aBv.this.ZZv.setText(aBv.this.KZx);
                }
            }, 1000L);
        } catch (Exception e) {
            ApmHelper.reportCustomError("showPrivacyAdReportDialogError", "showPrivacyAdReportDialogError", e);
        }
    }

    private View pA(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ml.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_ad_report_info_bg"));
        ml.setOrientation(1);
        ml.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.SD sd = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        sd.setLayoutParams(new ViewGroup.LayoutParams(-1, pA(44.0f)));
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(pA(191.0f), pA(24.0f));
        layoutParams2.addRule(13);
        omhVar.setGravity(17);
        omhVar.setText("Ad Report");
        omhVar.setTextColor(Color.parseColor("#161823"));
        omhVar.setTextSize(1, 17.0f);
        omhVar.setLayoutParams(layoutParams2);
        this.JG = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(pA(40.0f), pA(44.0f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = pA(8.0f);
        this.JG.setPadding(pA(12.0f), pA(14.0f), pA(12.0f), pA(14.0f));
        this.JG.setImageResource(yFO.ZZv(context, "tt_ad_xmark"));
        this.JG.setLayoutParams(layoutParams3);
        View view = new View(context);
        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, pA(0.5f));
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        view.setLayoutParams(layoutParams4);
        ScrollView scrollView = new ScrollView(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams5.leftMargin = pA(16.0f);
        layoutParams5.rightMargin = pA(16.0f);
        layoutParams5.weight = 1.0f;
        layoutParams5.setMarginStart(pA(16.0f));
        layoutParams5.setMarginEnd(pA(16.0f));
        scrollView.setLayoutParams(layoutParams5);
        com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ViewGroup.LayoutParams layoutParams6 = new ViewGroup.LayoutParams(-1, -1);
        ml2.setOrientation(1);
        ml2.setLayoutParams(layoutParams6);
        String strML = gbA.ML();
        String strSD = gbA.SD();
        String str = "Android " + Build.VERSION.RELEASE;
        String str2 = Build.BRAND + " " + Build.MODEL;
        com.bytedance.sdk.openadsdk.core.ML.ML mlPA = pA(context, "SDK version", BuildConfig.VERSION_NAME);
        com.bytedance.sdk.openadsdk.core.ML.ML mlPA2 = pA(context, "App", strML);
        com.bytedance.sdk.openadsdk.core.ML.ML mlPA3 = pA(context, "App version", strSD);
        com.bytedance.sdk.openadsdk.core.ML.ML mlPA4 = pA(context, b.d, str);
        com.bytedance.sdk.openadsdk.core.ML.ML mlPA5 = pA(context, "Device", str2);
        com.bytedance.sdk.openadsdk.core.ML.ML mlPA6 = pA(context, "Creative info", "loading ...");
        com.bytedance.sdk.openadsdk.core.ML.ML ml3 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, pA(76.0f));
        ml3.setBackgroundColor(-1);
        ml3.setLayoutParams(layoutParams7);
        this.ML = new Button(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -1);
        int iPA = pA(16.0f);
        layoutParams8.setMargins(iPA, iPA, iPA, iPA);
        this.ML.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_ad_report_info_button_bg"));
        this.ML.setText("copy all");
        this.ML.setTextColor(Color.parseColor("#333333"));
        this.ML.setTextSize(14.0f);
        this.ML.setLayoutParams(layoutParams8);
        ml.addView(sd);
        sd.addView(omhVar);
        sd.addView(this.JG);
        ml.addView(view);
        ml.addView(scrollView);
        scrollView.addView(ml2);
        ml2.addView(mlPA);
        ml2.addView(mlPA2);
        ml2.addView(mlPA3);
        ml2.addView(mlPA4);
        ml2.addView(mlPA5);
        ml2.addView(mlPA6);
        ml.addView(ml3);
        ml3.addView(this.ML);
        return ml;
    }

    private com.bytedance.sdk.openadsdk.core.ML.ML pA(Context context, String str, String str2) {
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, str.equals("Creative info") ? -2 : pA(74.0f));
        ml.setOrientation(1);
        ml.setPadding(0, pA(16.0f), 0, pA(16.0f));
        ml.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = pA(7.0f);
        omhVar.setIncludeFontPadding(false);
        omhVar.setText(str);
        omhVar.setTextColor(Color.parseColor("#333333"));
        omhVar.setTextSize(16.0f);
        omhVar.setTypeface(Typeface.defaultFromStyle(1));
        omhVar.setLayoutParams(layoutParams2);
        ml.addView(omhVar);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar2 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        if (str.equals("Creative info")) {
            this.ZZv = omhVar2;
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        omhVar2.setIncludeFontPadding(false);
        omhVar2.setTextColor(Color.parseColor("#666666"));
        omhVar2.setText(str2);
        omhVar2.setTextSize(14.0f);
        omhVar2.setLayoutParams(layoutParams3);
        ml.addView(omhVar2);
        return ml;
    }

    private int pA(float f) {
        return Vgu.KZx(getContext(), f);
    }
}
