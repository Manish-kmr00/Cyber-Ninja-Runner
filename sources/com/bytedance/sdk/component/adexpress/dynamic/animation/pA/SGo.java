package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class SGo extends ZZv {
    private float JG;
    private float ML;
    private pA ZZv;

    public SGo(View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA pAVar) {
        super(view, pAVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv
    List<ObjectAnimator> pA() {
        int i;
        String str;
        if ((this.KZx instanceof ImageView) && (this.KZx.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML)) {
            this.KZx = (View) this.KZx.getParent();
        }
        this.KZx.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.KZx, "alpha", 0.0f, 1.0f).setDuration((int) (this.Og.SGo() * 1000.0d));
        this.ZZv = new pA(this.KZx);
        final int i2 = this.KZx.getLayoutParams().height;
        this.ML = i2;
        this.JG = this.KZx.getLayoutParams().width;
        if ("left".equals(this.Og.pA()) || "right".equals(this.Og.pA())) {
            i = (int) this.JG;
            str = "width";
        } else {
            str = "height";
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.ZZv, str, 0, i).setDuration((int) (this.Og.SGo() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pA(duration));
        arrayList.add(pA(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.pA.SGo.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SGo.this.ZZv.pA(i2);
            }
        });
        return arrayList;
    }

    private class pA {
        private View Og;

        public pA(View view) {
            this.Og = view;
        }

        public void pA(int i) {
            if (ViewHierarchyConstants.DIMENSION_TOP_KEY.equals(SGo.this.Og.pA())) {
                if (SGo.this.KZx instanceof ViewGroup) {
                    for (int i2 = 0; i2 < ((ViewGroup) SGo.this.KZx).getChildCount(); i2++) {
                        ((ViewGroup) SGo.this.KZx).getChildAt(i2).setTranslationY(i - SGo.this.ML);
                    }
                }
                SGo.this.KZx.setTranslationY(SGo.this.ML - i);
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.Og.getLayoutParams();
            layoutParams.height = i;
            this.Og.setLayoutParams(layoutParams);
            this.Og.requestLayout();
        }
    }
}
