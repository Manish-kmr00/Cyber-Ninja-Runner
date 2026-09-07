package sg.bigo.ads.common.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.transition.ChangeBounds;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    public static class a extends ChangeBounds implements ValueAnimator.AnimatorUpdateListener {
        protected void a(TransitionValues transitionValues, TransitionValues transitionValues2) {
        }

        protected void a(Object obj, Object obj2) {
        }

        @Override // android.transition.ChangeBounds, android.transition.Transition
        public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            try {
                a(transitionValues, transitionValues2);
            } catch (Exception unused) {
            }
            Animator animatorCreateAnimator = super.createAnimator(viewGroup, transitionValues, transitionValues2);
            if (animatorCreateAnimator instanceof ValueAnimator) {
                ((ValueAnimator) animatorCreateAnimator).addUpdateListener(this);
            }
            return animatorCreateAnimator;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
                a(objectAnimator.getTarget(), objectAnimator.getAnimatedValue());
            }
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.common.utils.b$b, reason: collision with other inner class name */
    public static class InterpolatorC0875b implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f13284a;
        private final float b;
        private final float c;

        public InterpolatorC0875b(long j, long j2, long j3) {
            long j4 = j + j2;
            long j5 = j3 + j4;
            this.f13284a = j5;
            this.b = (j2 * 1.0f) / j5;
            this.c = (j4 * 1.0f) / j5;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.b;
            if (f < f2) {
                return 0.0f;
            }
            float f3 = this.c;
            if (f > f3) {
                return 1.0f;
            }
            return (f - f2) / (f3 - f2);
        }
    }

    public static class c implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static class d implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static Interpolator a(int i) {
        if (i == 1) {
            return new AccelerateInterpolator(1.5f);
        }
        if (i != 2) {
            return i != 3 ? new LinearInterpolator() : new AccelerateDecelerateInterpolator();
        }
        return new DecelerateInterpolator(1.5f);
    }

    public static void a(final View view) {
        if (view == null) {
            return;
        }
        final int iA = e.a(view.getContext(), 40);
        view.setVisibility(4);
        view.post(new Runnable() { // from class: sg.bigo.ads.common.utils.b.1
            @Override // java.lang.Runnable
            public final void run() {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, view.getTranslationY() + iA, view.getTranslationY());
                translateAnimation.setDuration(300L);
                translateAnimation.setInterpolator(b.a(2));
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setInterpolator(b.a(2));
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.setAnimationListener(new c() { // from class: sg.bigo.ads.common.utils.b.1.1
                    @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                    public final void onAnimationStart(Animation animation) {
                        view.setVisibility(0);
                    }
                });
                view.startAnimation(animationSet);
            }
        });
    }
}
