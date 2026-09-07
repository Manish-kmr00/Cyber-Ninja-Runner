package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.Vgu;

/* JADX INFO: loaded from: classes9.dex */
public class BSW {
    private com.bytedance.sdk.openadsdk.core.widget.Bzk KZx;
    private com.bytedance.sdk.openadsdk.core.ML.omh ML;
    protected Context Og;
    private com.bytedance.sdk.openadsdk.core.widget.aBv ZZv;
    protected View pA = ML();

    public BSW(Context context) {
        this.Og = context;
    }

    public View pA() {
        return this.pA;
    }

    public com.bytedance.sdk.openadsdk.core.widget.aBv Og() {
        return this.ZZv;
    }

    public com.bytedance.sdk.openadsdk.core.ML.omh KZx() {
        return this.ML;
    }

    private View ML() {
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(this.Og);
        ml.setGravity(1);
        ml.setOrientation(1);
        com.bytedance.sdk.openadsdk.core.widget.aBv abv = new com.bytedance.sdk.openadsdk.core.widget.aBv(this.Og);
        this.ZZv = abv;
        abv.setId(520093745);
        int iKZx = Vgu.KZx(this.Og, 64.0f);
        ml.addView(this.ZZv, new LinearLayout.LayoutParams(iKZx, iKZx));
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(this.Og);
        this.ML = omhVar;
        omhVar.setId(520093746);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Vgu.KZx(this.Og, 219.0f), -2);
        layoutParams.topMargin = Vgu.KZx(this.Og, 16.0f);
        this.ML.setLayoutParams(layoutParams);
        this.ML.setEllipsize(TextUtils.TruncateAt.END);
        this.ML.setGravity(17);
        this.ML.setMaxWidth(Vgu.KZx(this.Og, 150.0f));
        this.ML.setMaxLines(2);
        this.ML.setTextColor(-1);
        this.ML.setTextSize(1, 16.0f);
        ml.addView(this.ML);
        this.KZx = new com.bytedance.sdk.openadsdk.core.widget.Bzk(this.Og);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(Vgu.KZx(this.Og, 219.0f), Vgu.KZx(this.Og, 6.0f));
        layoutParams2.topMargin = Vgu.KZx(this.Og, 32.0f);
        ml.addView(this.KZx, layoutParams2);
        return ml;
    }

    public void pA(int i) {
        this.KZx.setProgress(i);
    }

    public void ZZv() {
        this.pA = null;
        this.Og = null;
    }
}
