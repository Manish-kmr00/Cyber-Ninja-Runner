package com.yandex.div.core.tooltip;

import android.animation.TimeInterpolator;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.widget.PopupWindow;
import com.json.b9;
import com.yandex.div.core.animation.SpringInterpolator;
import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAnimation;
import com.yandex.div2.DivTooltip;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTooltipAnimation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\b*\u00020\tH\u0003\u001a\u001c\u0010\u000b\u001a\u00020\b*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a&\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0013"}, d2 = {"defaultTransition", "Landroid/transition/TransitionSet;", "kotlin.jvm.PlatformType", "divTooltip", "Lcom/yandex/div2/DivTooltip;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "clearAnimation", "", "Landroid/widget/PopupWindow;", "removeTransition", "setupAnimation", "toTransition", "Landroid/transition/Transition;", "Lcom/yandex/div2/DivAnimation;", b9.h.L, "Lcom/yandex/div2/DivTooltip$Position;", "incoming", "", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivTooltipAnimationKt {

    /* JADX INFO: compiled from: DivTooltipAnimation.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivAnimation.Name.values().length];
            try {
                iArr[DivAnimation.Name.FADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivAnimation.Name.TRANSLATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivAnimation.Name.SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DivAnimation.Name.SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DivAnimation.Name.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DivAnimation.Name.NO_ANIMATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void setupAnimation(PopupWindow popupWindow, DivTooltip divTooltip, ExpressionResolver resolver) {
        TransitionSet transitionSetDefaultTransition;
        TransitionSet transitionSetDefaultTransition2;
        Intrinsics.checkNotNullParameter(popupWindow, "<this>");
        Intrinsics.checkNotNullParameter(divTooltip, "divTooltip");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        DivAnimation divAnimation = divTooltip.animationIn;
        if (divAnimation != null) {
            transitionSetDefaultTransition = toTransition(divAnimation, divTooltip.position.evaluate(resolver), true, resolver);
        } else {
            transitionSetDefaultTransition = defaultTransition(divTooltip, resolver);
        }
        popupWindow.setEnterTransition(transitionSetDefaultTransition);
        DivAnimation divAnimation2 = divTooltip.animationOut;
        if (divAnimation2 != null) {
            transitionSetDefaultTransition2 = toTransition(divAnimation2, divTooltip.position.evaluate(resolver), false, resolver);
        } else {
            transitionSetDefaultTransition2 = defaultTransition(divTooltip, resolver);
        }
        popupWindow.setExitTransition(transitionSetDefaultTransition2);
    }

    public static final void clearAnimation(PopupWindow popupWindow) {
        Intrinsics.checkNotNullParameter(popupWindow, "<this>");
        removeTransition(popupWindow);
    }

    private static final void removeTransition(PopupWindow popupWindow) {
        popupWindow.setEnterTransition(null);
        popupWindow.setExitTransition(null);
    }

    private static final TransitionSet defaultTransition(DivTooltip divTooltip, ExpressionResolver expressionResolver) {
        return new TransitionSet().addTransition(new Fade()).addTransition(new TranslateAnimation(divTooltip.position.evaluate(expressionResolver), null, 2, null)).setInterpolator((TimeInterpolator) new SpringInterpolator());
    }

    private static final Transition toTransition(DivAnimation divAnimation, DivTooltip.Position position, boolean z, ExpressionResolver expressionResolver) {
        Fade fade;
        Expression<Double> expression;
        Transition duration;
        switch (WhenMappings.$EnumSwitchMapping$0[divAnimation.name.evaluate(expressionResolver).ordinal()]) {
            case 1:
                fade = new Fade();
                break;
            case 2:
                Expression<Double> expression2 = z ? divAnimation.startValue : divAnimation.endValue;
                fade = new TranslateAnimation(position, expression2 != null ? Float.valueOf((float) expression2.evaluate(expressionResolver).doubleValue()) : null);
                break;
            case 3:
                if (z) {
                    expression = divAnimation.startValue;
                } else {
                    expression = divAnimation.endValue;
                }
                fade = new Scale(expression != null ? (float) expression.evaluate(expressionResolver).doubleValue() : 1.0f);
                break;
            case 4:
                TransitionSet transitionSet = new TransitionSet();
                List<DivAnimation> list = divAnimation.items;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        transitionSet.addTransition(toTransition((DivAnimation) it.next(), position, z, expressionResolver));
                    }
                }
                fade = transitionSet;
                break;
            case 5:
            case 6:
                fade = null;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (fade == null || (duration = fade.setDuration(divAnimation.duration.evaluate(expressionResolver).longValue())) == null) {
            return null;
        }
        return duration.setInterpolator(DivUtilKt.getAndroidInterpolator(divAnimation.interpolator.evaluate(expressionResolver)));
    }
}
