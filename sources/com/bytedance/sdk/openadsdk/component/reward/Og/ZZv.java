package com.bytedance.sdk.openadsdk.component.reward.Og;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.core.model.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.BSW;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;

/* JADX INFO: loaded from: classes9.dex */
public class ZZv extends Og {
    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public boolean ML() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void SD() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public RFEndCardBackUpLayout omh() {
        return null;
    }

    public ZZv(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        super(pAVar);
    }

    public static boolean pA(yFO yfo) {
        return aBv.Og(yfo) || aBv.ZZv(yfo) || aBv.ML(yfo);
    }

    public static void pA(yFO yfo, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        if (aBv.Og(yfo)) {
            Og(frameLayout);
        } else if (aBv.ZZv(yfo) || aBv.ML(yfo)) {
            KZx(frameLayout);
        } else {
            pA(frameLayout, pAVar);
        }
    }

    static void Og(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setOrientation(1);
        frameLayout.addView(ml, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx.setId(Sn.xy);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        ml.addView(kZx, layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx2 = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx2.setId(Sn.SGo);
        kZx.addView(kZx2, new FrameLayout.LayoutParams(-1, -1));
        kZx2.addView(pA(context));
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx3 = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx3.setId(Sn.XT);
        kZx3.setVisibility(8);
        kZx3.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        kZx2.addView(kZx3, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv.setId(Sn.yFO);
        zZv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        kZx3.addView(zZv, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.view.ZZv.Og(kZx);
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx4 = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx4.setId(Sn.vZF);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.0f;
        ml.addView(kZx4, layoutParams3);
        kZx4.addView(Og(context));
        LinearLayout linearLayoutKZx = KZx(context);
        linearLayoutKZx.setBackgroundColor(Color.parseColor("#70161823"));
        kZx4.addView(linearLayoutKZx);
        linearLayoutKZx.addView(ZZv(context));
        com.bytedance.sdk.openadsdk.component.reward.view.ZZv.pA(kZx4);
    }

    private static com.bytedance.sdk.component.Bzk.ZZv Og(Context context) {
        com.bytedance.sdk.component.Bzk.ZZv zZv = new com.bytedance.sdk.component.Bzk.ZZv(context, true);
        zZv.setId(Sn.Sd);
        zZv.setLayerType(2, null);
        zZv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return zZv;
    }

    private static LinearLayout KZx(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setId(Sn.TX);
        ml.setOrientation(1);
        ml.setVisibility(8);
        ml.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return ml;
    }

    private static ImageView ZZv(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv.setScaleType(ImageView.ScaleType.FIT_XY);
        zZv.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(context, "tt_up_slide"));
        zZv.setId(Sn.BF);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Vgu.KZx(context, 18.0f), Vgu.KZx(context, 16.0f));
        layoutParams.gravity = 17;
        layoutParams.topMargin = Vgu.KZx(context, 45.0f);
        zZv.setLayoutParams(layoutParams);
        return zZv;
    }

    static void KZx(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx.setId(Sn.vZF);
        frameLayout.addView(kZx, new FrameLayout.LayoutParams(-1, -1));
        kZx.addView(Og(context));
        LinearLayout linearLayoutKZx = KZx(context);
        linearLayoutKZx.setBackgroundColor(Color.parseColor("#99161823"));
        kZx.addView(linearLayoutKZx);
        linearLayoutKZx.addView(ZZv(context));
        com.bytedance.sdk.openadsdk.component.reward.view.ZZv.pA(kZx);
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx2 = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx2.setId(Sn.xy);
        frameLayout.addView(kZx2, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx3 = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx3.setId(Sn.SGo);
        kZx2.addView(kZx3, new FrameLayout.LayoutParams(-1, -1));
        kZx3.addView(pA(context));
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx4 = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx4.setId(Sn.XT);
        kZx4.setVisibility(8);
        kZx4.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        kZx3.addView(kZx4, layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv.setId(Sn.yFO);
        zZv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        kZx4.addView(zZv, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.view.ZZv.Og(kZx2);
        BSW bsw = new BSW(context);
        bsw.setId(Sn.qmB);
        bsw.setClickable(true);
        bsw.setFocusable(true);
        frameLayout.addView(bsw, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void pA(com.bytedance.sdk.openadsdk.component.reward.view.SD sd) {
        pA(this.Og, sd, this.pA);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void Wx() {
        if (aBv.Og(this.pA.Og) && this.pA.Vgu != null && this.pA.Vgu.DX != null) {
            if (this.pA.Vgu.DX.ZZv()) {
                this.pA.Vgu.Og(0);
                this.pA.oX.set(true);
            } else {
                this.pA.aBv.set(true);
                pA(true, false, true, 80);
            }
        }
        if (aBv.ZZv(this.pA.Og) || aBv.ML(this.pA.Og)) {
            pA(true, false, true, 70);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void pA(FrameLayout frameLayout) {
        if (!aBv.ZZv(this.pA.Og) || this.pA.Wo == null) {
            return;
        }
        this.pA.Wo.pA(this.pA.Og.Bzk().Og() * 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public boolean JG() {
        if (aBv.Og(this.pA.Og)) {
            return true;
        }
        return (aBv.ZZv(this.pA.Og) || aBv.ML(this.pA.Og)) ? false : true;
    }
}
