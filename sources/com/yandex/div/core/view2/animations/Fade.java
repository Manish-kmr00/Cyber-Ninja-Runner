package com.yandex.div.core.view2.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.transition.TransitionValues;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Fade.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u001a\u0010\u0012\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J.\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016J.\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/yandex/div/core/view2/animations/Fade;", "Lcom/yandex/div/core/view2/animations/OutlineAwareVisibility;", "alpha", "", "(F)V", "getAlpha", "()F", "captureEndValues", "", "transitionValues", "Landroidx/transition/TransitionValues;", "captureStartValues", "createFadeAnimator", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "startAlpha", "endAlpha", "getCapturedAlpha", "fallbackValue", "onAppear", "sceneRoot", "Landroid/view/ViewGroup;", "startValues", "endValues", "onDisappear", "Companion", "FadeAnimatorListener", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Fade extends OutlineAwareVisibility {
    private static final Companion Companion = new Companion(null);
    private static final String PROPNAME_ALPHA = "yandex:fade:alpha";
    private static final String PROPNAME_SCREEN_POSITION = "yandex:fade:screenPosition";
    private final float alpha;

    public Fade() {
        this(0.0f, 1, null);
    }

    public /* synthetic */ Fade(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public Fade(float f) {
        this.alpha = f;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(final TransitionValues transitionValues) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        super.captureStartValues(transitionValues);
        int mode = getMode();
        if (mode == 1) {
            Map<String, Object> map = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(map, "transitionValues.values");
            map.put(PROPNAME_ALPHA, Float.valueOf(this.alpha));
        } else if (mode == 2) {
            Map<String, Object> map2 = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(map2, "transitionValues.values");
            map2.put(PROPNAME_ALPHA, Float.valueOf(transitionValues.view.getAlpha()));
        }
        UtilsKt.capturePosition(transitionValues, new Function1<int[], Unit>() { // from class: com.yandex.div.core.view2.animations.Fade.captureStartValues.1
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
                Map<String, Object> map3 = transitionValues.values;
                Intrinsics.checkNotNullExpressionValue(map3, "transitionValues.values");
                map3.put(Fade.PROPNAME_SCREEN_POSITION, position);
            }
        });
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(final TransitionValues transitionValues) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        super.captureEndValues(transitionValues);
        int mode = getMode();
        if (mode == 1) {
            Map<String, Object> map = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(map, "transitionValues.values");
            map.put(PROPNAME_ALPHA, Float.valueOf(transitionValues.view.getAlpha()));
        } else if (mode == 2) {
            Map<String, Object> map2 = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(map2, "transitionValues.values");
            map2.put(PROPNAME_ALPHA, Float.valueOf(this.alpha));
        }
        UtilsKt.capturePosition(transitionValues, new Function1<int[], Unit>() { // from class: com.yandex.div.core.view2.animations.Fade.captureEndValues.1
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
                Map<String, Object> map3 = transitionValues.values;
                Intrinsics.checkNotNullExpressionValue(map3, "transitionValues.values");
                map3.put(Fade.PROPNAME_SCREEN_POSITION, position);
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
        float capturedAlpha = getCapturedAlpha(startValues, this.alpha);
        float capturedAlpha2 = getCapturedAlpha(endValues, 1.0f);
        Object obj = endValues.values.get(PROPNAME_SCREEN_POSITION);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.IntArray");
        return createFadeAnimator(ViewCopiesKt.createOrGetVisualCopy(view, sceneRoot, this, (int[]) obj), capturedAlpha, capturedAlpha2);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
        Intrinsics.checkNotNullParameter(view, "view");
        if (startValues == null) {
            return null;
        }
        return createFadeAnimator(UtilsKt.getViewForAnimate(this, view, sceneRoot, startValues, PROPNAME_SCREEN_POSITION), getCapturedAlpha(startValues, 1.0f), getCapturedAlpha(endValues, this.alpha));
    }

    private final float getCapturedAlpha(TransitionValues transitionValues, float fallbackValue) {
        Map<String, Object> map;
        Object obj = (transitionValues == null || (map = transitionValues.values) == null) ? null : map.get(PROPNAME_ALPHA);
        Float f = obj instanceof Float ? (Float) obj : null;
        return f != null ? f.floatValue() : fallbackValue;
    }

    private final Animator createFadeAnimator(View view, float startAlpha, float endAlpha) {
        if (startAlpha == endAlpha) {
            return null;
        }
        view.setAlpha(startAlpha);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, startAlpha, endAlpha);
        objectAnimatorOfFloat.addListener(new FadeAnimatorListener(view, view.getAlpha()));
        return objectAnimatorOfFloat;
    }

    /* JADX INFO: compiled from: Fade.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/core/view2/animations/Fade$FadeAnimatorListener;", "Landroid/animation/AnimatorListenerAdapter;", "view", "Landroid/view/View;", "nonTransitionAlpha", "", "(Landroid/view/View;F)V", "isLayerTypeChanged", "", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class FadeAnimatorListener extends AnimatorListenerAdapter {
        private boolean isLayerTypeChanged;
        private final float nonTransitionAlpha;
        private final View view;

        public FadeAnimatorListener(View view, float f) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.nonTransitionAlpha = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.view.setVisibility(0);
            if (ViewCompat.hasOverlappingRendering(this.view) && this.view.getLayerType() == 0) {
                this.isLayerTypeChanged = true;
                this.view.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.view.setAlpha(this.nonTransitionAlpha);
            if (this.isLayerTypeChanged) {
                this.view.setLayerType(0, null);
            }
            animation.removeListener(this);
        }
    }

    /* JADX INFO: compiled from: Fade.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/yandex/div/core/view2/animations/Fade$Companion;", "", "()V", "PROPNAME_ALPHA", "", "PROPNAME_SCREEN_POSITION", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
