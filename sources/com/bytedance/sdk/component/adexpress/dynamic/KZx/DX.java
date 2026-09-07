package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class DX implements SD<com.bytedance.sdk.component.adexpress.JG.yFO> {
    private JSONObject Bzk;
    private int JG;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML KZx;
    private String ML;
    private Context Og;
    private int SD;
    private com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD ZZv;
    private int omh;
    private com.bytedance.sdk.component.adexpress.JG.yFO pA;

    public DX(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd, String str, int i, int i2, int i3, JSONObject jSONObject) {
        this.Og = context;
        this.KZx = ml;
        this.ZZv = sd;
        this.ML = str;
        this.JG = i;
        this.SD = i2;
        this.omh = i3;
        this.Bzk = jSONObject;
        ML();
    }

    private void ML() {
        final com.bytedance.sdk.component.adexpress.dynamic.JG.pA dynamicClickListener = this.KZx.getDynamicClickListener();
        try {
            new JSONObject().put("convertActionType", 1);
        } catch (Throwable unused) {
        }
        if ("16".equals(this.ML)) {
            Context context = this.Og;
            com.bytedance.sdk.component.adexpress.JG.yFO yfo = new com.bytedance.sdk.component.adexpress.JG.yFO(context, com.bytedance.sdk.component.adexpress.KZx.pA.omh(context), this.JG, this.SD, this.omh, this.Bzk);
            this.pA = yfo;
            if (yfo.getShakeLayout() != null) {
                this.pA.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.Og;
            this.pA = new com.bytedance.sdk.component.adexpress.JG.yFO(context2, com.bytedance.sdk.component.adexpress.KZx.pA.SD(context2), this.JG, this.SD, this.omh, this.Bzk);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.pA.setGravity(17);
        layoutParams.gravity = 17;
        this.pA.setLayoutParams(layoutParams);
        this.pA.setTranslationY(com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.Og, this.ZZv.nCO()));
        this.pA.setShakeText(this.ZZv.YkC());
        this.pA.setClipChildren(false);
        this.pA.setOnShakeViewListener(new com.bytedance.sdk.component.adexpress.JG.yFO.pA() { // from class: com.bytedance.sdk.component.adexpress.dynamic.KZx.DX.1
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void pA() {
        this.pA.pA();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void Og() {
        this.pA.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    /* JADX INFO: renamed from: ZZv, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.JG.yFO KZx() {
        return this.pA;
    }
}
