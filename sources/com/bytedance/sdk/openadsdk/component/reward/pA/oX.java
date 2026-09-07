package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.WQf;

/* JADX INFO: loaded from: classes2.dex */
public class oX {
    private com.bytedance.sdk.openadsdk.core.widget.omh JG;
    private final Context KZx;
    private final pA ML;
    private final com.bytedance.sdk.openadsdk.core.model.yFO Og;
    private AnimatorSet SD;
    private final int ZZv;
    com.bytedance.sdk.openadsdk.core.widget.Bzk pA;

    public oX(pA pAVar) {
        this.KZx = pAVar.Gx;
        this.Og = pAVar.Og;
        this.ZZv = pAVar.YkC;
        this.ML = pAVar;
    }

    public void pA() {
        try {
            if (WQf.KZx(this.Og)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.widget.omh omhVar = new com.bytedance.sdk.openadsdk.core.widget.omh(this.KZx);
            this.JG = omhVar;
            this.pA = omhVar.getLoadingProgressBar();
            com.bytedance.sdk.openadsdk.core.ML.omh downloadButton = this.JG.getDownloadButton();
            if (downloadButton != null) {
                downloadButton.setOnClickListener(this.ML.roi.ML());
            }
            this.JG.pA(this.Og, this.ZZv);
        } catch (Throwable unused) {
        }
    }

    public void Og() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(1, 80);
        valueAnimatorOfInt.setDuration(2000L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.oX.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (oX.this.pA != null) {
                    oX.this.pA.setProgress(iIntValue);
                }
            }
        });
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(81, 99);
        valueAnimatorOfInt2.setDuration(3000L);
        valueAnimatorOfInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.oX.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (oX.this.pA != null) {
                    oX.this.pA.setProgress(iIntValue);
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.SD = animatorSet;
        animatorSet.play(valueAnimatorOfInt).before(valueAnimatorOfInt2);
        this.SD.start();
    }

    public void KZx() {
        AnimatorSet animatorSet = this.SD;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public View ZZv() {
        return this.JG;
    }
}
