package com.yandex.div.core.view2.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scale.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0002\"#B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J2\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u001a\u0010\u0016\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u001a\u0010\u0018\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J.\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\nH\u0016J.\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\nH\u0016J!\u0010\u001f\u001a\u00020\b*\u00020\n2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0!H\u0082\bR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/yandex/div/core/view2/animations/Scale;", "Lcom/yandex/div/core/view2/animations/OutlineAwareVisibility;", "scaleFactor", "", "pivotX", "pivotY", "(FFF)V", "captureEndScaleValues", "", "transitionValues", "Landroidx/transition/TransitionValues;", "captureEndValues", "captureStartScaleValues", "captureStartValues", "createScaleAnimator", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "startScaleX", "startScaleY", "endScaleX", "endScaleY", "getCapturedScaleX", "fallbackValue", "getCapturedScaleY", "onAppear", "sceneRoot", "Landroid/view/ViewGroup;", "startValues", "endValues", "onDisappear", "withNoScale", "block", "Lkotlin/Function1;", "Companion", "ScaleAnimatorListener", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Scale extends OutlineAwareVisibility {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final float NO_SCALE = 1.0f;

    @Deprecated
    public static final float PIVOT_CENTER = 0.5f;

    @Deprecated
    public static final String PROPNAME_SCALE_X = "yandex:scale:scaleX";

    @Deprecated
    public static final String PROPNAME_SCALE_Y = "yandex:scale:scaleY";
    private static final String PROPNAME_SCREEN_POSITION = "yandex:scale:screenPosition";
    private final float pivotX;
    private final float pivotY;
    private final float scaleFactor;

    public /* synthetic */ Scale(float f, float f2, float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? 0.5f : f2, (i & 4) != 0 ? 0.5f : f3);
    }

    public Scale(float f, float f2, float f3) {
        this.scaleFactor = f;
        this.pivotX = f2;
        this.pivotY = f3;
    }

    private final void withNoScale(TransitionValues transitionValues, Function1<? super TransitionValues, Unit> function1) {
        float scaleX = transitionValues.view.getScaleX();
        float scaleY = transitionValues.view.getScaleY();
        transitionValues.view.setScaleX(1.0f);
        transitionValues.view.setScaleY(1.0f);
        function1.invoke(transitionValues);
        transitionValues.view.setScaleX(scaleX);
        transitionValues.view.setScaleY(scaleY);
    }

    private final void captureStartScaleValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        int mode = getMode();
        if (mode == 1) {
            Map<String, Object> map = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(map, "transitionValues.values");
            map.put(PROPNAME_SCALE_X, Float.valueOf(this.scaleFactor));
            Map<String, Object> map2 = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(map2, "transitionValues.values");
            map2.put(PROPNAME_SCALE_Y, Float.valueOf(this.scaleFactor));
            return;
        }
        if (mode != 2) {
            return;
        }
        Map<String, Object> map3 = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(map3, "transitionValues.values");
        map3.put(PROPNAME_SCALE_X, Float.valueOf(view.getScaleX()));
        Map<String, Object> map4 = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(map4, "transitionValues.values");
        map4.put(PROPNAME_SCALE_Y, Float.valueOf(view.getScaleY()));
    }

    private final void captureEndScaleValues(TransitionValues transitionValues) {
        int mode = getMode();
        if (mode == 1) {
            Map<String, Object> map = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(map, "transitionValues.values");
            map.put(PROPNAME_SCALE_X, Float.valueOf(1.0f));
            Map<String, Object> map2 = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(map2, "transitionValues.values");
            map2.put(PROPNAME_SCALE_Y, Float.valueOf(1.0f));
            return;
        }
        if (mode != 2) {
            return;
        }
        Map<String, Object> map3 = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(map3, "transitionValues.values");
        map3.put(PROPNAME_SCALE_X, Float.valueOf(this.scaleFactor));
        Map<String, Object> map4 = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(map4, "transitionValues.values");
        map4.put(PROPNAME_SCALE_Y, Float.valueOf(this.scaleFactor));
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
        Intrinsics.checkNotNullParameter(view, "view");
        if (endValues == null) {
            return null;
        }
        float capturedScaleX = getCapturedScaleX(startValues, this.scaleFactor);
        float capturedScaleY = getCapturedScaleY(startValues, this.scaleFactor);
        float capturedScaleX2 = getCapturedScaleX(endValues, 1.0f);
        float capturedScaleY2 = getCapturedScaleY(endValues, 1.0f);
        Object obj = endValues.values.get(PROPNAME_SCREEN_POSITION);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.IntArray");
        return createScaleAnimator(ViewCopiesKt.createOrGetVisualCopy(view, sceneRoot, this, (int[]) obj), capturedScaleX, capturedScaleY, capturedScaleX2, capturedScaleY2);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
        Intrinsics.checkNotNullParameter(view, "view");
        if (startValues == null) {
            return null;
        }
        return createScaleAnimator(UtilsKt.getViewForAnimate(this, view, sceneRoot, startValues, PROPNAME_SCREEN_POSITION), getCapturedScaleX(startValues, 1.0f), getCapturedScaleY(startValues, 1.0f), getCapturedScaleX(endValues, this.scaleFactor), getCapturedScaleY(endValues, this.scaleFactor));
    }

    private final float getCapturedScaleX(TransitionValues transitionValues, float fallbackValue) {
        Map<String, Object> map;
        Object obj = (transitionValues == null || (map = transitionValues.values) == null) ? null : map.get(PROPNAME_SCALE_X);
        Float f = obj instanceof Float ? (Float) obj : null;
        return f != null ? f.floatValue() : fallbackValue;
    }

    private final float getCapturedScaleY(TransitionValues transitionValues, float fallbackValue) {
        Map<String, Object> map;
        Object obj = (transitionValues == null || (map = transitionValues.values) == null) ? null : map.get(PROPNAME_SCALE_Y);
        Float f = obj instanceof Float ? (Float) obj : null;
        return f != null ? f.floatValue() : fallbackValue;
    }

    private final Animator createScaleAnimator(View view, float startScaleX, float startScaleY, float endScaleX, float endScaleY) {
        if (startScaleX == endScaleX && startScaleY == endScaleY) {
            return null;
        }
        view.setVisibility(4);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, startScaleX, endScaleX), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, startScaleY, endScaleY));
        objectAnimatorOfPropertyValuesHolder.addListener(new ScaleAnimatorListener(this, view, view.getScaleX(), view.getScaleY()));
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX INFO: compiled from: Scale.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/core/view2/animations/Scale$ScaleAnimatorListener;", "Landroid/animation/AnimatorListenerAdapter;", "view", "Landroid/view/View;", "nonTransitionScaleX", "", "nonTransitionScaleY", "(Lcom/yandex/div/core/view2/animations/Scale;Landroid/view/View;FF)V", "isPivotSet", "", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class ScaleAnimatorListener extends AnimatorListenerAdapter {
        private boolean isPivotSet;
        private final float nonTransitionScaleX;
        private final float nonTransitionScaleY;
        final /* synthetic */ Scale this$0;
        private final View view;

        public ScaleAnimatorListener(Scale scale, View view, float f, float f2) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = scale;
            this.view = view;
            this.nonTransitionScaleX = f;
            this.nonTransitionScaleY = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.view.setVisibility(0);
            if (this.this$0.pivotX == 0.5f && this.this$0.pivotY == 0.5f) {
                return;
            }
            this.isPivotSet = true;
            View view = this.view;
            view.setPivotX(view.getWidth() * this.this$0.pivotX);
            View view2 = this.view;
            view2.setPivotY(view2.getHeight() * this.this$0.pivotY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.view.setScaleX(this.nonTransitionScaleX);
            this.view.setScaleY(this.nonTransitionScaleY);
            if (this.isPivotSet) {
                if (Build.VERSION.SDK_INT >= 28) {
                    this.view.resetPivot();
                } else {
                    View view = this.view;
                    view.setPivotX(view.getWidth() * 0.5f);
                    View view2 = this.view;
                    view2.setPivotY(view2.getHeight() * 0.5f);
                }
            }
            animation.removeListener(this);
        }
    }

    /* JADX INFO: compiled from: Scale.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/yandex/div/core/view2/animations/Scale$Companion;", "", "()V", "NO_SCALE", "", "PIVOT_CENTER", "PROPNAME_SCALE_X", "", "PROPNAME_SCALE_Y", "PROPNAME_SCREEN_POSITION", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(final TransitionValues transitionValues) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        float scaleX = transitionValues.view.getScaleX();
        float scaleY = transitionValues.view.getScaleY();
        transitionValues.view.setScaleX(1.0f);
        transitionValues.view.setScaleY(1.0f);
        super.captureStartValues(transitionValues);
        transitionValues.view.setScaleX(scaleX);
        transitionValues.view.setScaleY(scaleY);
        captureStartScaleValues(transitionValues);
        UtilsKt.capturePosition(transitionValues, new Function1<int[], Unit>() { // from class: com.yandex.div.core.view2.animations.Scale.captureStartValues.2
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
                map.put(Scale.PROPNAME_SCREEN_POSITION, position);
            }
        });
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(final TransitionValues transitionValues) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        float scaleX = transitionValues.view.getScaleX();
        float scaleY = transitionValues.view.getScaleY();
        transitionValues.view.setScaleX(1.0f);
        transitionValues.view.setScaleY(1.0f);
        super.captureEndValues(transitionValues);
        transitionValues.view.setScaleX(scaleX);
        transitionValues.view.setScaleY(scaleY);
        captureEndScaleValues(transitionValues);
        UtilsKt.capturePosition(transitionValues, new Function1<int[], Unit>() { // from class: com.yandex.div.core.view2.animations.Scale.captureEndValues.2
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
                map.put(Scale.PROPNAME_SCREEN_POSITION, position);
            }
        });
    }
}
