package com.bytedance.sdk.openadsdk.common;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class XT {
    private TextView Bzk;
    private final yFO JG;
    private final RelativeLayout ML;
    TTAdDislikeToast Og;
    private final Context SD;
    private com.bytedance.sdk.openadsdk.core.ML.JG SGo;
    private boolean WV;
    private ImageView omh;
    DX pA;
    final AtomicBoolean KZx = new AtomicBoolean(false);
    final AtomicBoolean ZZv = new AtomicBoolean(false);
    private final int BSW = Vgu.KZx(com.bytedance.sdk.openadsdk.core.aBv.pA(), 44.0f);

    public XT(Context context, RelativeLayout relativeLayout, yFO yfo) {
        this.SD = context;
        this.ML = relativeLayout;
        this.JG = yfo;
        ML();
    }

    private void ML() {
        this.omh = (ImageView) this.ML.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.nCO);
        this.Bzk = (TextView) this.ML.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.bU);
        ImageView imageView = (ImageView) this.ML.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Wo);
        this.SGo = (com.bytedance.sdk.openadsdk.core.ML.JG) this.ML.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Itl);
        yFO yfo = this.JG;
        if (yfo != null) {
            this.Bzk.setText(TextUtils.isEmpty(yfo.SXO()) ? com.bytedance.sdk.component.utils.yFO.pA(this.SD, "tt_web_title_default") : this.JG.SXO());
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.XT.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/common/XT$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_XT$1_onClick_9b060c24dfdc28f855a32222c769e924(view);
            }

            public void safedk_XT$1_onClick_9b060c24dfdc28f855a32222c769e924(View p0) {
                XT.this.ZZv();
            }
        });
    }

    public void pA(int i) {
        if (i == 100) {
            this.SGo.setVisibility(8);
        } else {
            this.SGo.setVisibility(0);
            this.SGo.setProgress(i);
        }
    }

    public void pA() {
        try {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ML.getLayoutParams();
            if (this.WV) {
                return;
            }
            int i = marginLayoutParams.topMargin;
            int i2 = this.BSW;
            if (i == (-i2)) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(-i2, 0);
                valueAnimatorOfInt.setDuration(300L);
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.common.XT.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        XT.this.ML.setLayoutParams(marginLayoutParams);
                    }
                });
                valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.common.XT.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        XT.this.WV = true;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        XT.this.WV = false;
                    }
                });
                valueAnimatorOfInt.start();
            }
        } catch (Throwable unused) {
        }
    }

    public void Og() {
        try {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ML.getLayoutParams();
            if (this.WV || marginLayoutParams.topMargin != 0) {
                return;
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, -this.BSW);
            valueAnimatorOfInt.setDuration(300L);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.common.XT.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    XT.this.ML.setLayoutParams(marginLayoutParams);
                }
            });
            valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.common.XT.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    XT.this.WV = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    XT.this.WV = false;
                }
            });
            valueAnimatorOfInt.start();
        } catch (Throwable unused) {
        }
    }

    public ImageView KZx() {
        return this.omh;
    }

    protected void ZZv() {
        if (this.ZZv.get()) {
            SD();
            return;
        }
        if (this.pA == null) {
            JG();
        }
        DX dx = this.pA;
        if (dx != null) {
            dx.pA();
        }
    }

    private void JG() {
        try {
            if (this.pA == null) {
                DX dx = new DX(this.SD, this.JG);
                this.pA = dx;
                dx.setDislikeSource("landing_page");
                this.pA.setCallback(new DX.pA() { // from class: com.bytedance.sdk.openadsdk.common.XT.6
                    @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                    public void pA(View view) {
                        XT.this.KZx.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                    public void Og(View view) {
                        XT.this.KZx.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                    public void pA(FilterWord filterWord) {
                        if (XT.this.ZZv.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        XT.this.ZZv.set(true);
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) this.ML.getRootView().findViewById(R.id.content);
            frameLayout.addView(this.pA);
            if (this.Og == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.SD);
                this.Og = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("initDislike error", "TTTitleNewStyleManager", th);
        }
    }

    private void SD() {
        this.Og.show(TTAdDislikeToast.getDislikeTip());
    }
}
