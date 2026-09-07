package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gbA;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZZv implements gbA {
    public View KZx;
    com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA Og;
    private Set<ScheduledFuture<?>> ZZv = new HashSet();
    public List<ObjectAnimator> pA = pA();

    abstract List<ObjectAnimator> pA();

    public ZZv(View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA pAVar) {
        this.KZx = view;
        this.Og = pAVar;
    }

    public void KZx() {
        List<ObjectAnimator> list = this.pA;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.Og.aBv() > 0.0d) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        pA pAVar = ZZv.this.new pA(objectAnimator);
                        ScheduledFuture<?> scheduledFuturePA = com.bytedance.sdk.component.adexpress.ZZv.ZZv.pA(pAVar, (long) (ZZv.this.Og.aBv() * 1000.0d), TimeUnit.MILLISECONDS);
                        pAVar.pA(scheduledFuturePA);
                        ZZv.this.ZZv.add(scheduledFuturePA);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gbA
    public void Og() {
        List<ObjectAnimator> list = this.pA;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.ZZv.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    ObjectAnimator pA(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.Og.Sn() * 1000.0d));
        if (this.Og.DX() > 0) {
            objectAnimator.setRepeatCount(this.Og.DX() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!Constants.NORMAL.equals(this.Og.oX())) {
            if ("alternate".equals(this.Og.oX()) || "alternate-reverse".equals(this.Og.oX())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.Og.Wx())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.Og.oX())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.Og.oX())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    ZZv.this.KZx.setVisibility(0);
                    if (ZZv.this.KZx.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG) {
                        ((View) ZZv.this.KZx.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }

    public class pA implements Runnable {
        ScheduledFuture<?> Og;
        ObjectAnimator pA;

        pA(ObjectAnimator objectAnimator) {
            this.pA = objectAnimator;
        }

        public void pA(ScheduledFuture<?> scheduledFuture) {
            this.Og = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx() != null) {
                com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().KZx().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv.pA.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pA.this.pA.resume();
                    }
                });
                if (this.Og != null) {
                    ZZv.this.ZZv.remove(this.Og);
                }
            }
        }
    }
}
