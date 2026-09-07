package com.bytedance.sdk.openadsdk.component.reward.Og;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.model.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;

/* JADX INFO: loaded from: classes13.dex */
public class KZx extends Og {
    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public boolean JG() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public boolean ML() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void SD() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void pA(FrameLayout frameLayout) {
    }

    public KZx(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        super(pAVar);
    }

    public static boolean pA(yFO yfo) {
        new Object[]{"match type:", Boolean.valueOf(aBv.KZx(yfo))};
        return aBv.KZx(yfo);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void pA(com.bytedance.sdk.openadsdk.component.reward.view.SD sd) {
        Og(sd);
    }

    private void Og(com.bytedance.sdk.openadsdk.component.reward.view.SD sd) {
        if (sd == null) {
            return;
        }
        Context context = sd.getContext();
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setOrientation(1);
        sd.addView(ml, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx.setId(Sn.xy);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 100.0f;
        ml.addView(kZx, layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx2 = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx2.setId(Sn.SGo);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        kZx.addView(kZx2, layoutParams2);
        kZx2.addView(pA(context));
        if (this.Og.RS() != 3 && this.Og.RS() != 5) {
            com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
            zZv.setId(Sn.LAE);
            zZv.setVisibility(8);
            zZv.setBackground(com.bytedance.sdk.openadsdk.core.widget.ZZv.pA());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(Vgu.KZx(context, 28.0f), Vgu.KZx(context, 28.0f));
            layoutParams3.gravity = 8388693;
            layoutParams3.rightMargin = Vgu.KZx(context, 20.0f);
            layoutParams3.bottomMargin = Vgu.KZx(context, 10.0f);
            kZx.addView(zZv, layoutParams3);
        }
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx3 = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx3.setId(Sn.vZF);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 0.0f;
        ml.addView(kZx3, layoutParams4);
        kZx3.addView(Og(context));
        com.bytedance.sdk.openadsdk.component.reward.view.ZZv.pA(kZx3);
        com.bytedance.sdk.openadsdk.component.reward.view.ZZv.Og(kZx);
    }

    private static com.bytedance.sdk.component.Bzk.ZZv Og(Context context) {
        com.bytedance.sdk.component.Bzk.ZZv zZv = new com.bytedance.sdk.component.Bzk.ZZv(context, true);
        zZv.setId(Sn.Sd);
        zZv.setLayerType(2, null);
        zZv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return zZv;
    }
}
