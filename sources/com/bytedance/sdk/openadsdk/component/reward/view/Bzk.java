package com.bytedance.sdk.openadsdk.component.reward.view;

import android.graphics.Color;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;

/* JADX INFO: loaded from: classes13.dex */
public class Bzk extends SGo {
    @Override // com.bytedance.sdk.openadsdk.component.reward.view.SGo
    protected boolean pA() {
        return false;
    }

    public Bzk(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        super(pAVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.view.SGo
    public void pA(int i, int i2) {
        super.pA(i, i2);
        if (yFO.ML(this.ZZv) && this.ZZv.Mc() == 3 && this.ZZv.IG() == 0) {
            try {
                FrameLayout frameLayout = (FrameLayout) this.KZx.CIG.findViewById(Sn.SGo);
                frameLayout.setBackgroundColor(Color.parseColor("#000000"));
                if (this.ZZv.rtW() == 1) {
                    int iKZx = Vgu.KZx(aBv.pA(), 90.0f);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                    layoutParams.bottomMargin = iKZx;
                    frameLayout.setLayoutParams(layoutParams);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
