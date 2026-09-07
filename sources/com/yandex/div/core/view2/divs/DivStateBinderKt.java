package com.yandex.div.core.view2.divs;

import androidx.transition.Transition;
import com.yandex.div.core.view2.animations.Fade;
import com.yandex.div.core.view2.animations.Scale;
import com.yandex.div.core.view2.animations.VerticalTranslation;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAnimation;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DivStateBinder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0002\u0010\u0003\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0015\u0010\f\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0002\u0010\u0003¨\u0006\r"}, d2 = {"alphaValue", "", "", "(Ljava/lang/Double;)Ljava/lang/Float;", "scaleValue", "toTransition", "Landroidx/transition/Transition;", "Lcom/yandex/div2/DivAnimation;", "incoming", "", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "translateValue", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivStateBinderKt {

    /* JADX INFO: compiled from: DivStateBinder.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivAnimation.Name.values().length];
            try {
                iArr[DivAnimation.Name.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivAnimation.Name.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivAnimation.Name.NO_ANIMATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x00bb  */
    public static final Transition toTransition(DivAnimation divAnimation, boolean z, ExpressionResolver expressionResolver) {
        Float fTranslateValue;
        Float fTranslateValue2;
        Float fScaleValue;
        Float fAlphaValue;
        int i = WhenMappings.$EnumSwitchMapping$0[divAnimation.name.evaluate(expressionResolver).ordinal()];
        if (i == 1) {
            if (z) {
                Expression<Double> expression = divAnimation.startValue;
                if (expression != null) {
                    fTranslateValue = translateValue(Double.valueOf(expression.evaluate(expressionResolver).doubleValue()));
                } else {
                    fTranslateValue = null;
                }
            } else {
                Expression<Double> expression2 = divAnimation.endValue;
                if (expression2 != null) {
                    fTranslateValue = translateValue(Double.valueOf(expression2.evaluate(expressionResolver).doubleValue()));
                } else {
                    fTranslateValue = null;
                }
            }
            if (z) {
                Expression<Double> expression3 = divAnimation.endValue;
                fTranslateValue2 = translateValue(expression3 != null ? expression3.evaluate(expressionResolver) : null);
            } else {
                Expression<Double> expression4 = divAnimation.startValue;
                fTranslateValue2 = translateValue(expression4 != null ? expression4.evaluate(expressionResolver) : null);
            }
            return new VerticalTranslation(fTranslateValue != null ? fTranslateValue.floatValue() : -1.0f, fTranslateValue2 != null ? fTranslateValue2.floatValue() : 0.0f);
        }
        if (i == 2) {
            if (z) {
                Expression<Double> expression5 = divAnimation.startValue;
                fScaleValue = scaleValue(expression5 != null ? expression5.evaluate(expressionResolver) : null);
            } else {
                Expression<Double> expression6 = divAnimation.endValue;
                fScaleValue = scaleValue(expression6 != null ? expression6.evaluate(expressionResolver) : null);
            }
            return new Scale(fScaleValue != null ? fScaleValue.floatValue() : 1.0f, 0.0f, 0.0f, 6, null);
        }
        if (i == 3) {
            return null;
        }
        if (z) {
            Expression<Double> expression7 = divAnimation.startValue;
            fAlphaValue = alphaValue(expression7 != null ? expression7.evaluate(expressionResolver) : null);
        } else {
            Expression<Double> expression8 = divAnimation.endValue;
            fAlphaValue = alphaValue(expression8 != null ? expression8.evaluate(expressionResolver) : null);
        }
        Fade fade = new Fade(fAlphaValue != null ? fAlphaValue.floatValue() : 1.0f);
        fade.setMode(z ? 1 : 2);
        return fade;
    }

    private static final Float translateValue(Double d) {
        if (d != null) {
            return Float.valueOf(RangesKt.coerceIn((float) d.doubleValue(), -1.0f, 1.0f));
        }
        return null;
    }

    private static final Float scaleValue(Double d) {
        if (d != null) {
            return Float.valueOf(RangesKt.coerceAtLeast((float) d.doubleValue(), 0.0f));
        }
        return null;
    }

    private static final Float alphaValue(Double d) {
        if (d != null) {
            return Float.valueOf(RangesKt.coerceIn((float) d.doubleValue(), 0.0f, 1.0f));
        }
        return null;
    }
}
