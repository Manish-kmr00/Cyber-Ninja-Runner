package com.bytedance.adsdk.ugeno.core;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class SD {
    private int JG;
    private AnimatorSet KZx = new AnimatorSet();
    private int ML;
    private pA Og;
    private String SD;
    private View ZZv;
    Paint pA;

    public SD(View view, pA pAVar) {
        this.ZZv = view;
        this.Og = pAVar;
        Paint paint = new Paint();
        this.pA = paint;
        paint.setAntiAlias(true);
    }

    public void pA() {
        ArrayList arrayList = new ArrayList();
        List<pA.C0178pA> listKZx = this.Og.KZx();
        if (listKZx == null || listKZx.size() <= 0) {
            return;
        }
        for (pA.C0178pA c0178pA : listKZx) {
            if (c0178pA != null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0178pA.pA());
                if (TextUtils.equals(c0178pA.ML(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0178pA.ML(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0178pA.ML());
                }
                objectAnimator.setStartDelay(c0178pA.ZZv());
                objectAnimator.setTarget(this.ZZv);
                if (TextUtils.equals(c0178pA.ML(), "backgroundColor")) {
                    objectAnimator.setIntValues((int) c0178pA.JG(), (int) c0178pA.SD());
                    Log.d("UGenAnimation", "playAnimation: from = " + c0178pA.JG() + "; to=" + c0178pA.SD());
                } else {
                    objectAnimator.setFloatValues(c0178pA.JG(), c0178pA.SD());
                }
                int iOg = (int) this.Og.Og();
                if (iOg != 0) {
                    objectAnimator.setRepeatCount(iOg);
                } else {
                    objectAnimator.setRepeatCount((int) c0178pA.Og());
                }
                if (TextUtils.equals(c0178pA.ML(), "backgroundColor")) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String strJG = this.Og.JG();
                if (TextUtils.isEmpty(strJG)) {
                    strJG = c0178pA.KZx();
                }
                if (TextUtils.equals(strJG, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0178pA.omh() != null && c0178pA.omh().length > 0) {
                    objectAnimator.setFloatValues(c0178pA.omh());
                }
                if (TextUtils.equals(c0178pA.ML(), "rotationX")) {
                    this.ZZv.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.core.SD.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SD.this.ZZv.setPivotX(SD.this.ZZv.getWidth() / 2.0f);
                            SD.this.ZZv.setPivotY(SD.this.ZZv.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0178pA.ML(), "ripple")) {
                    this.SD = c0178pA.SGo();
                }
                String strBzk = c0178pA.Bzk();
                strBzk.hashCode();
                switch (strBzk) {
                    case "accelerate":
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case "decelerate":
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case "linear":
                    case "standard":
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case "accelerateDecelerate":
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.Og.ZZv() != 0) {
            this.KZx.setDuration(this.Og.ZZv());
        }
        this.KZx.setStartDelay(this.Og.ML());
        if (TextUtils.equals(this.Og.pA(), "sequentially")) {
            this.KZx.playSequentially(arrayList);
        } else {
            this.KZx.playTogether(arrayList);
        }
        this.KZx.start();
    }

    public void Og() {
        AnimatorSet animatorSet = this.KZx;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void pA(Canvas canvas, IAnimation iAnimation) {
        try {
            if (iAnimation.getRipple() == 0.0f || TextUtils.isEmpty(this.SD)) {
                return;
            }
            this.pA.setColor(com.bytedance.adsdk.ugeno.SD.pA.pA(this.SD));
            this.pA.setAlpha(90);
            ViewGroup viewGroup = (ViewGroup) this.ZZv.getParent();
            viewGroup.setClipChildren(true);
            int i = this.ML;
            int i2 = this.JG;
            canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * iAnimation.getRipple(), this.pA);
        } catch (Throwable th) {
            Log.d("UGenAnimation", "ripple animation error " + th.getMessage());
        }
    }

    public void pA(int i, int i2) {
        this.ML = i / 2;
        this.JG = i2 / 2;
    }
}
