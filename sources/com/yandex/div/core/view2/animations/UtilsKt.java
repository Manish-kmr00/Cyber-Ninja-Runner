package com.yandex.div.core.view2.animations;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import androidx.core.content.ContextCompat;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.yandex.div.R;
import com.yandex.div.core.animation.ReverseInterpolatorKt;
import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAnimation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012H\u0000\u001a\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010\u001a\u001a0\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001c*\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001dH\u0000\u001a,\u0010\"\u001a\u00020\u001d*\u00020#2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0000\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010\u001a\u001a,\u0010*\u001a\u0004\u0018\u00010+*\u00020\u00042\u0006\u0010,\u001a\u00020 2\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"DEFAULT_ALPHA_END_VALUE", "", "DEFAULT_ALPHA_START_VALUE", "DEFAULT_CLICK_ANIMATION", "Lcom/yandex/div2/DivAnimation;", "getDEFAULT_CLICK_ANIMATION", "()Lcom/yandex/div2/DivAnimation;", "DEFAULT_SCALE_END_VALUE", "DEFAULT_SCALE_START_VALUE", "MAX_ALPHA_VALUE", "MIN_ALPHA_VALUE", "MIN_SCALE_VALUE", "SCALE_PIVOT_VALUE", "capturePosition", "", "transitionValues", "Landroidx/transition/TransitionValues;", "savePosition", "Lkotlin/Function1;", "", "createScaleAnimation", "Landroid/view/animation/ScaleAnimation;", "startValue", "endValue", "alphaValue", "", "(Ljava/lang/Double;)Ljava/lang/Float;", "asTouchListener", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/view/MotionEvent;", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "view", "getViewForAnimate", "Landroidx/transition/Transition;", "sceneRoot", "Landroid/view/ViewGroup;", "values", "positionKey", "", "scaleValue", "toAnimation", "Landroid/view/animation/Animation;", "resolver", "reverse", "", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class UtilsKt {
    private static final float DEFAULT_ALPHA_END_VALUE = 0.6f;
    private static final float DEFAULT_ALPHA_START_VALUE = 1.0f;
    private static final DivAnimation DEFAULT_CLICK_ANIMATION = new DivAnimation(Expression.INSTANCE.constant(100L), Expression.INSTANCE.constant(Double.valueOf(0.6d)), null, null, Expression.INSTANCE.constant(DivAnimation.Name.FADE), null, null, Expression.INSTANCE.constant(Double.valueOf(1.0d)), 108, null);
    private static final float DEFAULT_SCALE_END_VALUE = 0.95f;
    private static final float DEFAULT_SCALE_START_VALUE = 1.0f;
    private static final float MAX_ALPHA_VALUE = 1.0f;
    private static final float MIN_ALPHA_VALUE = 0.0f;
    private static final float MIN_SCALE_VALUE = 0.0f;
    private static final float SCALE_PIVOT_VALUE = 0.5f;

    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivAnimation.Name.values().length];
            try {
                iArr[DivAnimation.Name.SET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivAnimation.Name.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivAnimation.Name.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DivAnimation.Name.NO_ANIMATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DivAnimation getDEFAULT_CLICK_ANIMATION() {
        return DEFAULT_CLICK_ANIMATION;
    }

    public static final View getViewForAnimate(Transition transition, View view, ViewGroup sceneRoot, TransitionValues values, String positionKey) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(positionKey, "positionKey");
        if (Intrinsics.areEqual(values.view, view) || !ViewsKt.isActuallyLaidOut(view)) {
            return view;
        }
        Object obj = values.values.get(positionKey);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.IntArray");
        return ViewCopiesKt.createOrGetVisualCopy(view, sceneRoot, transition, (int[]) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int[], java.lang.Object] */
    public static final void capturePosition(TransitionValues transitionValues, Function1<? super int[], Unit> savePosition) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        Intrinsics.checkNotNullParameter(savePosition, "savePosition");
        ?? r0 = new int[2];
        transitionValues.view.getLocationOnScreen(r0);
        savePosition.invoke(r0);
    }

    public static final Function2<View, MotionEvent, Unit> asTouchListener(DivAnimation divAnimation, ExpressionResolver expressionResolver, View view) {
        Intrinsics.checkNotNullParameter(divAnimation, "<this>");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(view, "view");
        final Animation animation$default = toAnimation$default(divAnimation, expressionResolver, false, view, 2, null);
        final Animation animation$default2 = toAnimation$default(divAnimation, expressionResolver, true, null, 4, null);
        if (animation$default == null && animation$default2 == null) {
            return null;
        }
        return new Function2<View, MotionEvent, Unit>() { // from class: com.yandex.div.core.view2.animations.UtilsKt.asTouchListener.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view2, MotionEvent motionEvent) {
                invoke2(view2, motionEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View v, MotionEvent event) {
                Animation animation;
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                if (v.isEnabled() && v.isClickable() && v.hasOnClickListeners()) {
                    int action = event.getAction();
                    if (action == 0) {
                        Animation animation2 = animation$default;
                        if (animation2 != null) {
                            v.startAnimation(animation2);
                            return;
                        }
                        return;
                    }
                    if ((action == 1 || action == 3) && (animation = animation$default2) != null) {
                        v.startAnimation(animation);
                    }
                }
            }
        };
    }

    static /* synthetic */ Animation toAnimation$default(DivAnimation divAnimation, ExpressionResolver expressionResolver, boolean z, View view, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            view = null;
        }
        return toAnimation(divAnimation, expressionResolver, z, view);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009c  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ac A[LOOP:1: B:45:0x00aa->B:46:0x00ac, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d3  */
    /* JADX WARN: Multi-variable type inference failed */
    private static final Animation toAnimation(DivAnimation divAnimation, ExpressionResolver expressionResolver, boolean z, View view) {
        AnimationSet animationSetCreateScaleAnimation;
        Interpolator androidInterpolator;
        float fFloatValue;
        ArrayList arrayList;
        Drawable drawable;
        int numberOfLayers;
        int i;
        DivAnimation.Name nameEvaluate = divAnimation.name.evaluate(expressionResolver);
        int i2 = WhenMappings.$EnumSwitchMapping$0[nameEvaluate.ordinal()];
        if (i2 != 1) {
            animationSetCreateScaleAnimation = null;
            animationSetCreateScaleAnimation = null;
            animationSetCreateScaleAnimation = null;
            animationSetCreateScaleAnimation = null;
            if (i2 == 2) {
                Expression<Double> expression = divAnimation.startValue;
                Float fScaleValue = scaleValue(expression != null ? expression.evaluate(expressionResolver) : null);
                fFloatValue = fScaleValue != null ? fScaleValue.floatValue() : 1.0f;
                Expression<Double> expression2 = divAnimation.endValue;
                Float fScaleValue2 = scaleValue(expression2 != null ? expression2.evaluate(expressionResolver) : null);
                animationSetCreateScaleAnimation = createScaleAnimation(fFloatValue, fScaleValue2 != null ? fScaleValue2.floatValue() : DEFAULT_SCALE_END_VALUE);
            } else if (i2 != 3) {
                if (i2 != 4) {
                    Expression<Double> expression3 = divAnimation.startValue;
                    Float fAlphaValue = alphaValue(expression3 != null ? expression3.evaluate(expressionResolver) : null);
                    fFloatValue = fAlphaValue != null ? fAlphaValue.floatValue() : 1.0f;
                    Expression<Double> expression4 = divAnimation.endValue;
                    Float fAlphaValue2 = alphaValue(expression4 != null ? expression4.evaluate(expressionResolver) : null);
                    animationSetCreateScaleAnimation = new AlphaAnimation(fFloatValue, fAlphaValue2 != null ? fAlphaValue2.floatValue() : 0.6f);
                }
            } else if (view != null) {
                Drawable background = view.getBackground();
                LayerDrawable layerDrawable = background instanceof LayerDrawable ? (LayerDrawable) background : null;
                if (layerDrawable != null) {
                    IntRange intRangeUntil = RangesKt.until(0, layerDrawable.getNumberOfLayers());
                    if ((intRangeUntil instanceof Collection) && ((Collection) intRangeUntil).isEmpty()) {
                        arrayList = new ArrayList();
                        if (layerDrawable != null) {
                            numberOfLayers = layerDrawable.getNumberOfLayers();
                            for (i = 0; i < numberOfLayers; i++) {
                                Drawable drawable2 = layerDrawable.getDrawable(i);
                                Intrinsics.checkNotNullExpressionValue(drawable2, "it.getDrawable(i)");
                                arrayList.add(drawable2);
                            }
                        } else {
                            Drawable background2 = view.getBackground();
                            Intrinsics.checkNotNullExpressionValue(background2, "view.background");
                            arrayList.add(background2);
                        }
                        drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.native_animation_background);
                        if (drawable != null) {
                            arrayList.add(drawable);
                        }
                        LayerDrawable layerDrawable2 = new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[0]));
                        layerDrawable2.setId(arrayList.size() - 1, R.drawable.native_animation_background);
                        view.setBackground(layerDrawable2);
                    } else {
                        Iterator it = intRangeUntil.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (layerDrawable.getId(((IntIterator) it).nextInt()) == R.drawable.native_animation_background) {
                                }
                            } else {
                                arrayList = new ArrayList();
                                if (layerDrawable != null) {
                                    numberOfLayers = layerDrawable.getNumberOfLayers();
                                    while (i < numberOfLayers) {
                                        Drawable drawable3 = layerDrawable.getDrawable(i);
                                        Intrinsics.checkNotNullExpressionValue(drawable3, "it.getDrawable(i)");
                                        arrayList.add(drawable3);
                                    }
                                } else {
                                    Drawable background3 = view.getBackground();
                                    Intrinsics.checkNotNullExpressionValue(background3, "view.background");
                                    arrayList.add(background3);
                                }
                                drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.native_animation_background);
                                if (drawable != null) {
                                    arrayList.add(drawable);
                                }
                                LayerDrawable layerDrawable3 = new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[0]));
                                layerDrawable3.setId(arrayList.size() - 1, R.drawable.native_animation_background);
                                view.setBackground(layerDrawable3);
                            }
                        }
                    }
                } else {
                    arrayList = new ArrayList();
                    if (layerDrawable != null) {
                        numberOfLayers = layerDrawable.getNumberOfLayers();
                        while (i < numberOfLayers) {
                            Drawable drawable4 = layerDrawable.getDrawable(i);
                            Intrinsics.checkNotNullExpressionValue(drawable4, "it.getDrawable(i)");
                            arrayList.add(drawable4);
                        }
                    } else {
                        Drawable background4 = view.getBackground();
                        Intrinsics.checkNotNullExpressionValue(background4, "view.background");
                        arrayList.add(background4);
                    }
                    drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.native_animation_background);
                    if (drawable != null) {
                        arrayList.add(drawable);
                    }
                    LayerDrawable layerDrawable4 = new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[0]));
                    layerDrawable4.setId(arrayList.size() - 1, R.drawable.native_animation_background);
                    view.setBackground(layerDrawable4);
                }
            }
        } else {
            AnimationSet animationSet = new AnimationSet(false);
            List<DivAnimation> list = divAnimation.items;
            if (list != null) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    Animation animation = toAnimation((DivAnimation) it2.next(), expressionResolver, z, view);
                    if (animation != null) {
                        animationSet.addAnimation(animation);
                    }
                }
            }
            animationSetCreateScaleAnimation = animationSet;
        }
        if (nameEvaluate != DivAnimation.Name.SET) {
            if (animationSetCreateScaleAnimation != null) {
                if (z) {
                    androidInterpolator = ReverseInterpolatorKt.reversed(DivUtilKt.getAndroidInterpolator(divAnimation.interpolator.evaluate(expressionResolver)));
                } else {
                    androidInterpolator = DivUtilKt.getAndroidInterpolator(divAnimation.interpolator.evaluate(expressionResolver));
                }
                animationSetCreateScaleAnimation.setInterpolator(androidInterpolator);
            }
            if (animationSetCreateScaleAnimation != null) {
                animationSetCreateScaleAnimation.setDuration(divAnimation.duration.evaluate(expressionResolver).longValue());
            }
        }
        if (animationSetCreateScaleAnimation != null) {
            animationSetCreateScaleAnimation.setStartOffset(divAnimation.startDelay.evaluate(expressionResolver).longValue());
        }
        if (animationSetCreateScaleAnimation != null) {
            animationSetCreateScaleAnimation.setFillAfter(true);
        }
        return animationSetCreateScaleAnimation;
    }

    private static final ScaleAnimation createScaleAnimation(float f, float f2) {
        return new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
    }

    private static final Float alphaValue(Double d) {
        if (d != null) {
            return Float.valueOf(RangesKt.coerceIn((float) d.doubleValue(), 0.0f, 1.0f));
        }
        return null;
    }

    private static final Float scaleValue(Double d) {
        if (d != null) {
            return Float.valueOf(RangesKt.coerceAtLeast((float) d.doubleValue(), 0.0f));
        }
        return null;
    }
}
