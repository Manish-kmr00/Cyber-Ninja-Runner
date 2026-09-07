package com.yandex.div.core.view2.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.yandex.div.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: Slide.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 &2\u00020\u0001:\u0005&'()*B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\\\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J.\u0010 \u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u000eH\u0016J.\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006+"}, d2 = {"Lcom/yandex/div/core/view2/animations/Slide;", "Lcom/yandex/div/core/view2/animations/OutlineAwareVisibility;", "distance", "", "slideEdge", "(II)V", "getDistance", "()I", "slideCalculator", "Lcom/yandex/div/core/view2/animations/Slide$SlideCalculator;", "getSlideEdge", "captureEndValues", "", "transitionValues", "Landroidx/transition/TransitionValues;", "captureStartValues", "createTranslateAnimator", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "transition", "Landroidx/transition/Transition;", "values", "viewPositionX", "viewPositionY", "startX", "", "startY", "endX", "endY", "interpolator", "Landroid/animation/TimeInterpolator;", "onAppear", "sceneRoot", "Landroid/view/ViewGroup;", "startValues", "endValues", "onDisappear", "Companion", "HorizontalSlideCalculator", "SlideCalculator", "TransitionPositionListener", "VerticalSlideCalculator", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Slide extends OutlineAwareVisibility {
    public static final int DISTANCE_TO_EDGE = -1;
    private static final String PROPNAME_SCREEN_POSITION = "yandex:slide:screenPosition";
    private final int distance;
    private final SlideCalculator slideCalculator;
    private final int slideEdge;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Slide$Companion$calculatorLeft$1 calculatorLeft = new HorizontalSlideCalculator() { // from class: com.yandex.div.core.view2.animations.Slide$Companion$calculatorLeft$1
        @Override // com.yandex.div.core.view2.animations.Slide.SlideCalculator
        public float getGoneX(ViewGroup sceneRoot, View view, int distance) {
            Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
            Intrinsics.checkNotNullParameter(view, "view");
            return view.getTranslationX() - Slide.INSTANCE.exactValueBy(distance, view.getRight());
        }
    };
    private static final Slide$Companion$calculatorTop$1 calculatorTop = new VerticalSlideCalculator() { // from class: com.yandex.div.core.view2.animations.Slide$Companion$calculatorTop$1
        @Override // com.yandex.div.core.view2.animations.Slide.SlideCalculator
        public float getGoneY(ViewGroup sceneRoot, View view, int distance) {
            Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
            Intrinsics.checkNotNullParameter(view, "view");
            return view.getTranslationY() - Slide.INSTANCE.exactValueBy(distance, view.getBottom());
        }
    };
    private static final Slide$Companion$calculatorRight$1 calculatorRight = new HorizontalSlideCalculator() { // from class: com.yandex.div.core.view2.animations.Slide$Companion$calculatorRight$1
        @Override // com.yandex.div.core.view2.animations.Slide.SlideCalculator
        public float getGoneX(ViewGroup sceneRoot, View view, int distance) {
            Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
            Intrinsics.checkNotNullParameter(view, "view");
            return view.getTranslationX() + Slide.INSTANCE.exactValueBy(distance, sceneRoot.getWidth() - view.getLeft());
        }
    };
    private static final Slide$Companion$calculatorBottom$1 calculatorBottom = new VerticalSlideCalculator() { // from class: com.yandex.div.core.view2.animations.Slide$Companion$calculatorBottom$1
        @Override // com.yandex.div.core.view2.animations.Slide.SlideCalculator
        public float getGoneY(ViewGroup sceneRoot, View view, int distance) {
            Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
            Intrinsics.checkNotNullParameter(view, "view");
            return view.getTranslationY() + Slide.INSTANCE.exactValueBy(distance, sceneRoot.getHeight() - view.getTop());
        }
    };

    /* JADX INFO: compiled from: Slide.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/animations/Slide$SlideCalculator;", "", "getGoneX", "", "sceneRoot", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "distance", "", "getGoneY", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private interface SlideCalculator {
        float getGoneX(ViewGroup sceneRoot, View view, int distance);

        float getGoneY(ViewGroup sceneRoot, View view, int distance);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Slide() {
        int i = 0;
        this(i, i, 3, null);
    }

    public /* synthetic */ Slide(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? 80 : i2);
    }

    public final int getDistance() {
        return this.distance;
    }

    public final int getSlideEdge() {
        return this.slideEdge;
    }

    public Slide(int i, int i2) {
        Slide$Companion$calculatorLeft$1 slide$Companion$calculatorLeft$1;
        this.distance = i;
        this.slideEdge = i2;
        if (i2 == 3) {
            slide$Companion$calculatorLeft$1 = calculatorLeft;
        } else if (i2 == 5) {
            slide$Companion$calculatorLeft$1 = calculatorRight;
        } else if (i2 == 48) {
            slide$Companion$calculatorLeft$1 = calculatorTop;
        } else {
            slide$Companion$calculatorLeft$1 = calculatorBottom;
        }
        this.slideCalculator = slide$Companion$calculatorLeft$1;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(final TransitionValues transitionValues) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        super.captureStartValues(transitionValues);
        UtilsKt.capturePosition(transitionValues, new Function1<int[], Unit>() { // from class: com.yandex.div.core.view2.animations.Slide.captureStartValues.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(int[] iArr) {
                invoke2(iArr);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(int[] position) {
                Intrinsics.checkNotNullParameter(position, "position");
                Map<String, Object> map = transitionValues.values;
                Intrinsics.checkNotNullExpressionValue(map, "transitionValues.values");
                map.put(Slide.PROPNAME_SCREEN_POSITION, position);
            }
        });
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(final TransitionValues transitionValues) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        super.captureEndValues(transitionValues);
        UtilsKt.capturePosition(transitionValues, new Function1<int[], Unit>() { // from class: com.yandex.div.core.view2.animations.Slide.captureEndValues.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(int[] iArr) {
                invoke2(iArr);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(int[] position) {
                Intrinsics.checkNotNullParameter(position, "position");
                Map<String, Object> map = transitionValues.values;
                Intrinsics.checkNotNullExpressionValue(map, "transitionValues.values");
                map.put(Slide.PROPNAME_SCREEN_POSITION, position);
            }
        });
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
        Intrinsics.checkNotNullParameter(view, "view");
        if (endValues == null) {
            return null;
        }
        Object obj = endValues.values.get(PROPNAME_SCREEN_POSITION);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.IntArray");
        int[] iArr = (int[]) obj;
        Slide slide = this;
        return createTranslateAnimator(ViewCopiesKt.createOrGetVisualCopy(view, sceneRoot, slide, iArr), slide, endValues, iArr[0], iArr[1], this.slideCalculator.getGoneX(sceneRoot, view, this.distance), this.slideCalculator.getGoneY(sceneRoot, view, this.distance), view.getTranslationX(), view.getTranslationY(), getInterpolator());
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
        Intrinsics.checkNotNullParameter(view, "view");
        if (startValues == null) {
            return null;
        }
        Object obj = startValues.values.get(PROPNAME_SCREEN_POSITION);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.IntArray");
        int[] iArr = (int[]) obj;
        Slide slide = this;
        return createTranslateAnimator(UtilsKt.getViewForAnimate(slide, view, sceneRoot, startValues, PROPNAME_SCREEN_POSITION), slide, startValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.slideCalculator.getGoneX(sceneRoot, view, this.distance), this.slideCalculator.getGoneY(sceneRoot, view, this.distance), getInterpolator());
    }

    private final Animator createTranslateAnimator(View view, Transition transition, TransitionValues values, int viewPositionX, int viewPositionY, float startX, float startY, float endX, float endY, TimeInterpolator interpolator) {
        float f;
        float f2;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        Object tag = values.view.getTag(R.id.div_transition_position);
        int[] iArr = tag instanceof int[] ? (int[]) tag : null;
        if (iArr != null) {
            f = (iArr[0] - viewPositionX) + translationX;
            f2 = (iArr[1] - viewPositionY) + translationY;
        } else {
            f = startX;
            f2 = startY;
        }
        int iRoundToInt = viewPositionX + MathKt.roundToInt(f - translationX);
        int iRoundToInt2 = viewPositionY + MathKt.roundToInt(f2 - translationY);
        view.setTranslationX(f);
        view.setTranslationY(f2);
        if (f == endX && f2 == endY) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f, endX), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f2, endY));
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder, "ofPropertyValuesHolder(\n…, startY, endY)\n        )");
        View view2 = values.view;
        Intrinsics.checkNotNullExpressionValue(view2, "values.view");
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view2, view, iRoundToInt, iRoundToInt2, translationX, translationY);
        transition.addListener(transitionPositionListener);
        objectAnimatorOfPropertyValuesHolder.addListener(transitionPositionListener);
        objectAnimatorOfPropertyValuesHolder.addPauseListener(transitionPositionListener);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(interpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX INFO: compiled from: Slide.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/yandex/div/core/view2/animations/Slide$TransitionPositionListener;", "Landroid/animation/AnimatorListenerAdapter;", "Landroidx/transition/Transition$TransitionListener;", "originalView", "Landroid/view/View;", "movingView", "startX", "", "startY", "terminalX", "", "terminalY", "(Landroid/view/View;Landroid/view/View;IIFF)V", "pausedX", "pausedY", "getTerminalX", "()F", "getTerminalY", "transitionPosition", "", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationPause", "animator", "onAnimationResume", "onTransitionCancel", "transition", "Landroidx/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final View movingView;
        private final View originalView;
        private float pausedX;
        private float pausedY;
        private final int startX;
        private final int startY;
        private final float terminalX;
        private final float terminalY;
        private int[] transitionPosition;

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "transition");
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "transition");
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "transition");
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "transition");
        }

        public final float getTerminalX() {
            return this.terminalX;
        }

        public final float getTerminalY() {
            return this.terminalY;
        }

        public TransitionPositionListener(View originalView, View movingView, int i, int i2, float f, float f2) {
            Intrinsics.checkNotNullParameter(originalView, "originalView");
            Intrinsics.checkNotNullParameter(movingView, "movingView");
            this.originalView = originalView;
            this.movingView = movingView;
            this.terminalX = f;
            this.terminalY = f2;
            this.startX = i - MathKt.roundToInt(movingView.getTranslationX());
            this.startY = i2 - MathKt.roundToInt(movingView.getTranslationY());
            Object tag = originalView.getTag(R.id.div_transition_position);
            int[] iArr = tag instanceof int[] ? (int[]) tag : null;
            this.transitionPosition = iArr;
            if (iArr != null) {
                originalView.setTag(R.id.div_transition_position, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (this.transitionPosition == null) {
                this.transitionPosition = new int[]{this.startX + MathKt.roundToInt(this.movingView.getTranslationX()), this.startY + MathKt.roundToInt(this.movingView.getTranslationY())};
            }
            this.originalView.setTag(R.id.div_transition_position, this.transitionPosition);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.pausedX = this.movingView.getTranslationX();
            this.pausedY = this.movingView.getTranslationY();
            this.movingView.setTranslationX(this.terminalX);
            this.movingView.setTranslationY(this.terminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.movingView.setTranslationX(this.pausedX);
            this.movingView.setTranslationY(this.pausedY);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "transition");
            this.movingView.setTranslationX(this.terminalX);
            this.movingView.setTranslationY(this.terminalY);
            transition.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Slide.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\"\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/yandex/div/core/view2/animations/Slide$HorizontalSlideCalculator;", "Lcom/yandex/div/core/view2/animations/Slide$SlideCalculator;", "()V", "getGoneY", "", "sceneRoot", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "distance", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static abstract class HorizontalSlideCalculator implements SlideCalculator {
        @Override // com.yandex.div.core.view2.animations.Slide.SlideCalculator
        public float getGoneY(ViewGroup sceneRoot, View view, int distance) {
            Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
            Intrinsics.checkNotNullParameter(view, "view");
            return view.getTranslationY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Slide.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\"\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/yandex/div/core/view2/animations/Slide$VerticalSlideCalculator;", "Lcom/yandex/div/core/view2/animations/Slide$SlideCalculator;", "()V", "getGoneX", "", "sceneRoot", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "distance", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static abstract class VerticalSlideCalculator implements SlideCalculator {
        @Override // com.yandex.div.core.view2.animations.Slide.SlideCalculator
        public float getGoneX(ViewGroup sceneRoot, View view, int distance) {
            Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
            Intrinsics.checkNotNullParameter(view, "view");
            return view.getTranslationX();
        }
    }

    /* JADX INFO: compiled from: Slide.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0005*\u0004\b\u000b\u000e\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/view2/animations/Slide$Companion;", "", "()V", "DISTANCE_TO_EDGE", "", "PROPNAME_SCREEN_POSITION", "", "calculatorBottom", "com/yandex/div/core/view2/animations/Slide$Companion$calculatorBottom$1", "Lcom/yandex/div/core/view2/animations/Slide$Companion$calculatorBottom$1;", "calculatorLeft", "com/yandex/div/core/view2/animations/Slide$Companion$calculatorLeft$1", "Lcom/yandex/div/core/view2/animations/Slide$Companion$calculatorLeft$1;", "calculatorRight", "com/yandex/div/core/view2/animations/Slide$Companion$calculatorRight$1", "Lcom/yandex/div/core/view2/animations/Slide$Companion$calculatorRight$1;", "calculatorTop", "com/yandex/div/core/view2/animations/Slide$Companion$calculatorTop$1", "Lcom/yandex/div/core/view2/animations/Slide$Companion$calculatorTop$1;", "exactValueBy", "edgeDistance", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int exactValueBy(int i, int i2) {
            return i == -1 ? i2 : i;
        }

        private Companion() {
        }
    }
}
