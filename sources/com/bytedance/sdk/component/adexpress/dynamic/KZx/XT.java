package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes12.dex */
public class XT implements SD<com.bytedance.sdk.component.adexpress.JG.BSW> {
    private final com.bytedance.sdk.component.adexpress.JG.BSW pA;

    public XT(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        int iAgB;
        com.bytedance.sdk.component.adexpress.JG.BSW bsw = new com.bytedance.sdk.component.adexpress.JG.BSW(context);
        this.pA = bsw;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        if (sd.agB() > 0) {
            iAgB = sd.agB();
        } else {
            iAgB = com.bytedance.sdk.component.adexpress.ZZv.Og() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, iAgB);
        bsw.setLayoutParams(layoutParams);
        bsw.setClipChildren(false);
        bsw.setText(sd.YkC());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void pA() {
        com.bytedance.sdk.component.adexpress.JG.BSW bsw = this.pA;
        if (bsw != null) {
            bsw.pA();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void Og() {
        com.bytedance.sdk.component.adexpress.JG.BSW bsw = this.pA;
        if (bsw != null) {
            bsw.Og();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    /* JADX INFO: renamed from: ZZv, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.JG.BSW KZx() {
        return this.pA;
    }
}
