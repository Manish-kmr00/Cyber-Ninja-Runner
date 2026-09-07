package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.utils.Vgu;

/* JADX INFO: loaded from: classes13.dex */
public class Sn {
    private boolean JG;
    private final Activity KZx;
    private boolean ML = false;
    com.bytedance.sdk.component.adexpress.dynamic.ZZv Og;
    private final pA ZZv;
    com.bytedance.sdk.openadsdk.component.reward.top.KZx pA;

    public Sn(pA pAVar) {
        this.KZx = pAVar.SzT;
        this.ZZv = pAVar;
    }

    public void pA() {
        if (this.ML) {
            return;
        }
        this.ML = true;
        if (this.ZZv.tM != null) {
            this.pA = this.ZZv.tM;
            this.JG = true;
        } else {
            this.pA = (com.bytedance.sdk.openadsdk.component.reward.top.KZx) this.ZZv.CIG.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Lf);
        }
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx = this.pA;
        if (kZx != null) {
            kZx.pA(this.ZZv.Og);
            if (this.ZZv.Og.rjD()) {
                pA(false);
            } else {
                pA(this.ZZv.Og.uQ());
            }
        }
    }

    public void pA(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx;
        if (this.JG || (kZx = this.pA) == null) {
            return;
        }
        kZx.setShowDislike(z);
    }

    public void Og(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx = this.pA;
        if (kZx != null) {
            kZx.setSoundMute(z);
        }
        com.bytedance.sdk.component.adexpress.dynamic.ZZv zZv = this.Og;
        if (zZv != null) {
            zZv.setSoundMute(z);
        }
    }

    public void KZx(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx;
        if (this.JG || (kZx = this.pA) == null) {
            return;
        }
        kZx.setShowSound(z);
    }

    public void ZZv(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx;
        if (this.JG || (kZx = this.pA) == null) {
            return;
        }
        kZx.setShowSkip(z);
    }

    public void pA(String str, CharSequence charSequence) {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx;
        if (this.JG || (kZx = this.pA) == null) {
            return;
        }
        kZx.setTime(String.valueOf(str), charSequence);
    }

    public void pA(CharSequence charSequence) {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx;
        if (this.JG || (kZx = this.pA) == null) {
            return;
        }
        kZx.setSkipText(charSequence);
    }

    public void Og() {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx;
        if (this.JG || (kZx = this.pA) == null) {
            return;
        }
        kZx.showCountDownText();
    }

    public void ML(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx;
        if (this.JG || (kZx = this.pA) == null) {
            return;
        }
        kZx.setSkipEnable(z);
    }

    public void KZx() {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx;
        if (this.JG || (kZx = this.pA) == null) {
            return;
        }
        kZx.showSkipButton();
    }

    public void ZZv() {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx = this.pA;
        if (kZx != null) {
            kZx.clickSkip();
        }
    }

    public void ML() {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx = this.pA;
        if (kZx != null) {
            kZx.clickSound();
        }
    }

    public void JG() {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx;
        if (this.JG || (kZx = this.pA) == null) {
            return;
        }
        kZx.setSkipInvisiable();
    }

    public void pA(com.bytedance.sdk.openadsdk.component.reward.top.Og og) {
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx = this.pA;
        if (kZx != null) {
            kZx.setListener(og);
        }
    }

    public void pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv zZv) {
        this.Og = zZv;
    }

    public void pA(int i) {
        View viewFindViewById;
        com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx = this.pA;
        if (kZx == null || kZx.getITopLayout() == null || i == 0 || (viewFindViewById = this.pA.getITopLayout().findViewById(520093713)) == null || !(viewFindViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || viewFindViewById.getWidth() <= 0 || viewFindViewById.getVisibility() != 0) {
            return;
        }
        int[] iArr = new int[2];
        viewFindViewById.getLocationOnScreen(iArr);
        int width = i - (iArr[0] + viewFindViewById.getWidth());
        if (width < Vgu.KZx(this.KZx, 16.0f)) {
            ((ViewGroup.MarginLayoutParams) viewFindViewById.getLayoutParams()).rightMargin += Vgu.KZx(this.KZx, 16.0f) - width;
            viewFindViewById.requestLayout();
        }
    }
}
