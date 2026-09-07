package com.bytedance.adsdk.Og.JG;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes11.dex */
public abstract class pA extends ValueAnimator {
    private final Set<ValueAnimator.AnimatorUpdateListener> pA = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> Og = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorPauseListener> KZx = new CopyOnWriteArraySet();

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.pA.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.pA.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.pA.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.Og.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.Og.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.Og.clear();
    }

    void pA(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.Og) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.KZx.add(animatorPauseListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.KZx.remove(animatorPauseListener);
    }

    void pA() {
        Iterator<Animator.AnimatorListener> it = this.Og.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    void Og(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.Og) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    void Og() {
        Iterator<Animator.AnimatorListener> it = this.Og.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    void KZx() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.pA.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    void ZZv() {
        Iterator<Animator.AnimatorPauseListener> it = this.KZx.iterator();
        while (it.hasNext()) {
            it.next().onAnimationPause(this);
        }
    }

    void ML() {
        Iterator<Animator.AnimatorPauseListener> it = this.KZx.iterator();
        while (it.hasNext()) {
            it.next().onAnimationResume(this);
        }
    }
}
