package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.du;

/* JADX INFO: loaded from: classes11.dex */
public class BSW implements SD<ViewGroup> {
    private final FrameLayout Og;
    private final com.bytedance.sdk.component.adexpress.JG.SGo pA;

    public BSW(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd, String str, String str2) {
        int iAgB;
        com.bytedance.sdk.component.adexpress.JG.SGo sGo = new com.bytedance.sdk.component.adexpress.JG.SGo(context);
        this.pA = sGo;
        sGo.setImageLottieTosPath(str);
        FrameLayout frameLayout = new FrameLayout(context);
        this.Og = frameLayout;
        frameLayout.addView(sGo, new FrameLayout.LayoutParams(-2, -2));
        double dFw = sd.fw();
        dFw = dFw == 0.0d ? 1.0d : dFw;
        double dGy = sd.gy();
        double d = dGy != 0.0d ? dGy : 1.0d;
        if ("22".equals(str2)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, 250.0f));
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, 120.0f);
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        if ("20".equals(str2)) {
            pA(context, frameLayout, sd);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 81;
            if (sd.agB() > 0) {
                iAgB = sd.agB();
            } else {
                iAgB = com.bytedance.sdk.component.adexpress.ZZv.Og() ? 0 : 120;
            }
            layoutParams2.bottomMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, iAgB);
            frameLayout.setLayoutParams(layoutParams2);
            frameLayout.setClipChildren(false);
            return;
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) ml.getDynamicWidth()) * 0.32d * dFw), (int) (((double) ml.getDynamicWidth()) * 0.32d * d));
        layoutParams3.gravity = 17;
        frameLayout.setLayoutParams(layoutParams3);
    }

    private void pA(Context context, FrameLayout frameLayout, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, -du.pA(context, 5.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(context.getString(com.bytedance.sdk.component.utils.yFO.Og(context, "tt_splash_brush_mask_title")));
        textView.setTextColor(-1);
        textView.setTextSize(2, 20.0f);
        TextView textView2 = new TextView(context);
        textView2.setId(2097610738);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, du.pA(context, 5.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setText(context.getString(com.bytedance.sdk.component.utils.yFO.Og(context, "tt_splash_brush_mask_hint")));
        if (sd != null && !TextUtils.isEmpty(sd.YkC())) {
            textView2.setText(sd.YkC());
        }
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        frameLayout.addView(linearLayout);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void pA() {
        this.pA.omh();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void Og() {
        this.pA.JG();
        ViewParent parent = this.Og.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.Og);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public ViewGroup KZx() {
        return this.Og;
    }
}
