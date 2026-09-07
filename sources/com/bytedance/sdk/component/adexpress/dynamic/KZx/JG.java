package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.JG.vZF;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class JG extends aBv<com.bytedance.sdk.component.adexpress.JG.JG> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.aBv
    protected void ZZv() {
    }

    public JG(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd, int i, int i2, int i3, JSONObject jSONObject) {
        super(context, ml, sd);
        this.Og = context;
        this.ZZv = sd;
        this.KZx = ml;
        pA(i, i2, i3, jSONObject, sd);
    }

    private void pA(int i, int i2, int i3, JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        int iAgB;
        this.pA = new com.bytedance.sdk.component.adexpress.JG.JG(this.Og, i, i2, i3, jSONObject);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.Og, 300.0f));
        layoutParams.gravity = 81;
        Context context = this.Og;
        if (sd.agB() > 0) {
            iAgB = sd.agB();
        } else {
            iAgB = com.bytedance.sdk.component.adexpress.ZZv.Og() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, iAgB);
        this.pA.setLayoutParams(layoutParams);
        this.pA.setClipChildren(false);
        this.pA.setSlideText(this.ZZv.YkC());
        if (this.pA instanceof com.bytedance.sdk.component.adexpress.JG.JG) {
            ((com.bytedance.sdk.component.adexpress.JG.JG) this.pA).setShakeText(this.ZZv.IIF());
            final vZF shakeView = ((com.bytedance.sdk.component.adexpress.JG.JG) this.pA).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new com.bytedance.sdk.component.adexpress.JG.yFO.pA() { // from class: com.bytedance.sdk.component.adexpress.dynamic.KZx.JG.1
                });
                shakeView.setOnClickListener((View.OnClickListener) this.KZx.getDynamicClickListener());
            }
        }
    }
}
