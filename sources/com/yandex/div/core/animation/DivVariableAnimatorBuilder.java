package com.yandex.div.core.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.actions.DivActionTypedUtilsKt;
import com.yandex.div.core.expression.ExpressionsRuntime;
import com.yandex.div.core.expression.variables.VariableController;
import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.data.Variable;
import com.yandex.div.evaluable.MissingVariableException;
import com.yandex.div.evaluable.types.Color;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivActionAnimatorStart;
import com.yandex.div2.DivAnimationDirection;
import com.yandex.div2.DivAnimationInterpolator;
import com.yandex.div2.DivAnimator;
import com.yandex.div2.DivAnimatorBase;
import com.yandex.div2.DivColorAnimator;
import com.yandex.div2.DivCount;
import com.yandex.div2.DivNumberAnimator;
import com.yandex.div2.DivTypedValue;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DivVariableAnimatorBuilder.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ*\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0002J0\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J0\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0015H\u0002J*\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0002J4\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\n\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\fH\u0082\b¢\u0006\u0002\u0010\u001cJ,\u0010\u001d\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0002¨\u0006 "}, d2 = {"Lcom/yandex/div/core/animation/DivVariableAnimatorBuilder;", "", "()V", "build", "Landroid/animation/Animator;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "animator", "Lcom/yandex/div2/DivAnimator;", "startAction", "Lcom/yandex/div2/DivActionAnimatorStart;", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "buildColorAnimator", "Lcom/yandex/div2/DivColorAnimator;", "resolver", "buildDoubleAnimator", "Lcom/yandex/div2/DivNumberAnimator;", "variable", "Lcom/yandex/div/data/Variable$DoubleVariable;", "buildIntegerAnimator", "Lcom/yandex/div/data/Variable$IntegerVariable;", "buildNumberAnimator", "findVariable", "T", "Lcom/yandex/div/data/Variable;", "name", "", "(Lcom/yandex/div/core/view2/Div2View;Ljava/lang/String;Lcom/yandex/div/json/expressions/ExpressionResolver;)Lcom/yandex/div/data/Variable;", "configure", "Landroid/animation/ObjectAnimator;", "Lcom/yandex/div2/DivAnimatorBase;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivVariableAnimatorBuilder {
    public static final DivVariableAnimatorBuilder INSTANCE = new DivVariableAnimatorBuilder();

    private DivVariableAnimatorBuilder() {
    }

    public final Animator build(Div2View divView, DivAnimator animator, DivActionAnimatorStart startAction, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(animator, "animator");
        Intrinsics.checkNotNullParameter(startAction, "startAction");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        if (animator instanceof DivAnimator.Number) {
            return buildNumberAnimator(divView, ((DivAnimator.Number) animator).getValue(), startAction, expressionResolver);
        }
        if (animator instanceof DivAnimator.Color) {
            return buildColorAnimator(divView, ((DivAnimator.Color) animator).getValue(), startAction, expressionResolver);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Animator buildNumberAnimator(Div2View divView, DivNumberAnimator animator, DivActionAnimatorStart startAction, ExpressionResolver resolver) {
        VariableController variableController;
        String variableName = animator.getVariableName();
        ExpressionsRuntime runtimeFor = BaseDivViewExtensionsKt.getRuntimeFor(divView.getRuntimeStore(), resolver);
        if (runtimeFor == null) {
            runtimeFor = divView.getExpressionsRuntime();
        }
        Variable mutableVariable = (runtimeFor == null || (variableController = runtimeFor.getVariableController()) == null) ? null : variableController.getMutableVariable(variableName);
        if (!(mutableVariable instanceof Variable)) {
            mutableVariable = null;
        }
        if (mutableVariable instanceof Variable.IntegerVariable) {
            return buildIntegerAnimator(divView, animator, startAction, resolver, (Variable.IntegerVariable) mutableVariable);
        }
        if (mutableVariable instanceof Variable.DoubleVariable) {
            return buildDoubleAnimator(divView, animator, startAction, resolver, (Variable.DoubleVariable) mutableVariable);
        }
        DivActionTypedUtilsKt.logError(divView, new MissingVariableException("Unable to find number variable with name '" + animator.getVariableName() + '\'', null, 2, null));
        return null;
    }

    private final Animator buildIntegerAnimator(Div2View divView, DivNumberAnimator animator, DivActionAnimatorStart startAction, ExpressionResolver resolver, Variable.IntegerVariable variable) {
        Object objEvaluate;
        Number numberEvaluate;
        DivTypedValue divTypedValue = startAction.startValue;
        if (divTypedValue == null || (objEvaluate = DivActionTypedUtilsKt.longValue(divTypedValue, resolver)) == null) {
            Expression<Double> expression = animator.startValue;
            objEvaluate = expression != null ? expression.evaluate(resolver) : null;
        }
        DivTypedValue divTypedValue2 = startAction.endValue;
        if (divTypedValue2 == null || (numberEvaluate = DivActionTypedUtilsKt.longValue(divTypedValue2, resolver)) == null) {
            numberEvaluate = animator.endValue.evaluate(resolver);
        }
        if (objEvaluate != null) {
            variable.setValueDirectly(objEvaluate);
        }
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(variable, IntegerValueProperty.INSTANCE, numberEvaluate.intValue());
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfInt, "ofInt(variable, IntegerV…operty, endValue.toInt())");
        return configure(objectAnimatorOfInt, divView, animator, startAction, resolver);
    }

    private final Animator buildDoubleAnimator(Div2View divView, DivNumberAnimator animator, DivActionAnimatorStart startAction, ExpressionResolver resolver, Variable.DoubleVariable variable) {
        Double dEvaluate;
        Double dDoubleValue;
        DivTypedValue divTypedValue = startAction.startValue;
        if (divTypedValue == null || (dEvaluate = DivActionTypedUtilsKt.doubleValue(divTypedValue, resolver)) == null) {
            Expression<Double> expression = animator.startValue;
            dEvaluate = expression != null ? expression.evaluate(resolver) : null;
        }
        DivTypedValue divTypedValue2 = startAction.endValue;
        double dDoubleValue2 = (divTypedValue2 == null || (dDoubleValue = DivActionTypedUtilsKt.doubleValue(divTypedValue2, resolver)) == null) ? animator.endValue.evaluate(resolver).doubleValue() : dDoubleValue.doubleValue();
        if (dEvaluate != null) {
            variable.setValueDirectly(dEvaluate);
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(variable, NumberValueProperty.INSTANCE, (float) dDoubleValue2);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(variable, Number…erty, endValue.toFloat())");
        return configure(objectAnimatorOfFloat, divView, animator, startAction, resolver);
    }

    private final Animator buildColorAnimator(Div2View divView, DivColorAnimator animator, DivActionAnimatorStart startAction, ExpressionResolver resolver) {
        Integer numColorIntValue;
        Integer numColorIntValue2;
        VariableController variableController;
        String variableName = animator.getVariableName();
        ExpressionsRuntime runtimeFor = BaseDivViewExtensionsKt.getRuntimeFor(divView.getRuntimeStore(), resolver);
        if (runtimeFor == null) {
            runtimeFor = divView.getExpressionsRuntime();
        }
        Integer numEvaluate = null;
        Variable mutableVariable = (runtimeFor == null || (variableController = runtimeFor.getVariableController()) == null) ? null : variableController.getMutableVariable(variableName);
        if (!(mutableVariable instanceof Variable.ColorVariable)) {
            mutableVariable = null;
        }
        Variable.ColorVariable colorVariable = (Variable.ColorVariable) mutableVariable;
        if (colorVariable == null) {
            DivActionTypedUtilsKt.logError(divView, new MissingVariableException("Unable to find color variable with name '" + animator.getVariableName() + '\'', null, 2, null));
            return null;
        }
        DivTypedValue divTypedValue = startAction.startValue;
        if (divTypedValue == null || (numColorIntValue2 = DivActionTypedUtilsKt.colorIntValue(divTypedValue, resolver)) == null) {
            Expression<Integer> expression = animator.startValue;
            if (expression != null) {
                numEvaluate = expression.evaluate(resolver);
            }
        } else {
            numEvaluate = numColorIntValue2;
        }
        DivTypedValue divTypedValue2 = startAction.endValue;
        int iIntValue = (divTypedValue2 == null || (numColorIntValue = DivActionTypedUtilsKt.colorIntValue(divTypedValue2, resolver)) == null) ? animator.endValue.evaluate(resolver).intValue() : numColorIntValue.intValue();
        if (numEvaluate != null) {
            colorVariable.setValueDirectly(Color.m6217boximpl(Color.m6218constructorimpl(numEvaluate.intValue())));
        }
        ObjectAnimator objectAnimatorOfArgb = ObjectAnimator.ofArgb(colorVariable, ColorIntValueProperty.INSTANCE, iIntValue);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfArgb, "ofArgb(variable, ColorIntValueProperty, endValue)");
        return configure(objectAnimatorOfArgb, divView, animator, startAction, resolver);
    }

    private final ObjectAnimator configure(ObjectAnimator objectAnimator, final Div2View div2View, DivAnimatorBase divAnimatorBase, DivActionAnimatorStart divActionAnimatorStart, final ExpressionResolver expressionResolver) {
        DivAnimationDirection divAnimationDirectionEvaluate;
        DivAnimationInterpolator divAnimationInterpolatorEvaluate;
        int iCoerceAtLeast;
        Expression<DivAnimationDirection> expression = divActionAnimatorStart.direction;
        if (expression == null || (divAnimationDirectionEvaluate = expression.evaluate(expressionResolver)) == null) {
            divAnimationDirectionEvaluate = divAnimatorBase.getDirection().evaluate(expressionResolver);
        }
        Expression<Long> duration = divActionAnimatorStart.duration;
        if (duration == null) {
            duration = divAnimatorBase.getDuration();
        }
        objectAnimator.setDuration(duration.evaluate(expressionResolver).longValue());
        Expression<Long> startDelay = divActionAnimatorStart.startDelay;
        if (startDelay == null) {
            startDelay = divAnimatorBase.getStartDelay();
        }
        objectAnimator.setStartDelay(startDelay.evaluate(expressionResolver).longValue());
        Expression<DivAnimationInterpolator> expression2 = divActionAnimatorStart.interpolator;
        if (expression2 == null || (divAnimationInterpolatorEvaluate = expression2.evaluate(expressionResolver)) == null) {
            divAnimationInterpolatorEvaluate = divAnimatorBase.getInterpolator().evaluate(expressionResolver);
        }
        objectAnimator.setInterpolator(DivUtilKt.androidInterpolator(divAnimationInterpolatorEvaluate, DivUtilKt.isReversed(divAnimationDirectionEvaluate)));
        DivCount repeatCount = divActionAnimatorStart.repeatCount;
        if (repeatCount == null) {
            repeatCount = divAnimatorBase.getRepeatCount();
        }
        if (repeatCount instanceof DivCount.Fixed) {
            iCoerceAtLeast = RangesKt.coerceAtLeast(((int) ((DivCount.Fixed) repeatCount).getValue().value.evaluate(expressionResolver).longValue()) - 1, 0);
        } else {
            if (!(repeatCount instanceof DivCount.Infinity)) {
                throw new NoWhenBranchMatchedException();
            }
            iCoerceAtLeast = -1;
        }
        objectAnimator.setRepeatCount(iCoerceAtLeast);
        objectAnimator.setRepeatMode(DivUtilKt.isAlternated(divAnimationDirectionEvaluate) ? 2 : 1);
        final List<DivAction> endActions = divAnimatorBase.getEndActions();
        if (endActions != null) {
            objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.yandex.div.core.animation.DivVariableAnimatorBuilder$configure$lambda$2$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Iterator it = endActions.iterator();
                    while (it.hasNext()) {
                        div2View.handleAction((DivAction) it.next(), DivActionHandler.DivActionReason.ANIMATION_END, expressionResolver);
                    }
                }
            });
        }
        final List<DivAction> cancelActions = divAnimatorBase.getCancelActions();
        if (cancelActions != null) {
            objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.yandex.div.core.animation.DivVariableAnimatorBuilder$configure$lambda$5$$inlined$doOnCancel$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Iterator it = cancelActions.iterator();
                    while (it.hasNext()) {
                        div2View.handleAction((DivAction) it.next(), DivActionHandler.DivActionReason.ANIMATION_CANCEL, expressionResolver);
                    }
                }
            });
        }
        return objectAnimator;
    }

    private final /* synthetic */ <T extends Variable> T findVariable(Div2View divView, String name, ExpressionResolver resolver) {
        VariableController variableController;
        ExpressionsRuntime runtimeFor = BaseDivViewExtensionsKt.getRuntimeFor(divView.getRuntimeStore(), resolver);
        if (runtimeFor == null) {
            runtimeFor = divView.getExpressionsRuntime();
        }
        T t = (runtimeFor == null || (variableController = runtimeFor.getVariableController()) == null) ? null : (T) variableController.getMutableVariable(name);
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }
}
