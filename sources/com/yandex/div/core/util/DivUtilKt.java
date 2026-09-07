package com.yandex.div.core.util;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewGroupKt;
import com.yandex.div.core.animation.EaseInInterpolator;
import com.yandex.div.core.animation.EaseInOutInterpolator;
import com.yandex.div.core.animation.EaseInterpolator;
import com.yandex.div.core.animation.EaseOutInterpolator;
import com.yandex.div.core.animation.ReverseInterpolatorKt;
import com.yandex.div.core.animation.SpringInterpolator;
import com.yandex.div.core.expression.variables.DivVariablesParserKt;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.data.Variable;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivAnimationDirection;
import com.yandex.div2.DivAnimationInterpolator;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivBorder;
import com.yandex.div2.DivCornersRadius;
import com.yandex.div2.DivImage;
import com.yandex.div2.DivState;
import com.yandex.div2.DivVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0017\u001a\u00020\u0006*\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\u001a\u0014\u0010\u001b\u001a\u00020\u0006*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\u001a,\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\u001a\u0016\u0010$\u001a\u0004\u0018\u00010%*\u00020&2\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\u001a\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(*\b\u0012\u0004\u0012\u00020*0(H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b\"\u0018\u0010\t\u001a\u00020\u0006*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0018\u0010\f\u001a\u00020\u0006*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0018\u0010\r\u001a\u00020\u0006*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\b\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006+"}, d2 = {"androidInterpolator", "Landroid/view/animation/Interpolator;", "Lcom/yandex/div2/DivAnimationInterpolator;", "getAndroidInterpolator", "(Lcom/yandex/div2/DivAnimationInterpolator;)Landroid/view/animation/Interpolator;", "isAlternated", "", "Lcom/yandex/div2/DivAnimationDirection;", "(Lcom/yandex/div2/DivAnimationDirection;)Z", "isBranch", "Lcom/yandex/div2/Div;", "(Lcom/yandex/div2/Div;)Z", "isLeaf", "isReversed", "type", "", "getType", "(Lcom/yandex/div2/Div;)Ljava/lang/String;", "requestHierarchyLayout", "", "v", "Landroid/view/View;", "reverse", "canBeReused", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "containsStateInnerTransitions", "getCornerRadii", "", "Lcom/yandex/div2/DivBorder;", "widthPx", "", "heightPx", "metrics", "Landroid/util/DisplayMetrics;", "getDefaultState", "Lcom/yandex/div2/DivState$State;", "Lcom/yandex/div2/DivState;", "toVariables", "", "Lcom/yandex/div/data/Variable;", "Lcom/yandex/div2/DivVariable;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivUtilKt {

    /* JADX INFO: compiled from: DivUtil.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DivAnimationInterpolator.values().length];
            try {
                iArr[DivAnimationInterpolator.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivAnimationInterpolator.EASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivAnimationInterpolator.EASE_IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DivAnimationInterpolator.EASE_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DivAnimationInterpolator.EASE_IN_OUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DivAnimationInterpolator.SPRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DivAnimationDirection.values().length];
            try {
                iArr2[DivAnimationDirection.REVERSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DivAnimationDirection.ALTERNATE_REVERSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[DivAnimationDirection.ALTERNATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final String getType(Div div) {
        Intrinsics.checkNotNullParameter(div, "<this>");
        if (div instanceof Div.Text) {
            return "text";
        }
        if (div instanceof Div.Image) {
            return "image";
        }
        if (div instanceof Div.GifImage) {
            return "gif";
        }
        if (div instanceof Div.Separator) {
            return "separator";
        }
        if (div instanceof Div.Indicator) {
            return "indicator";
        }
        if (div instanceof Div.Slider) {
            return "slider";
        }
        if (div instanceof Div.Input) {
            return "input";
        }
        if (div instanceof Div.Video) {
            return "video";
        }
        if (div instanceof Div.Container) {
            return "container";
        }
        if (div instanceof Div.Grid) {
            return "grid";
        }
        if (div instanceof Div.State) {
            return "state";
        }
        if (div instanceof Div.Gallery) {
            return "gallery";
        }
        if (div instanceof Div.Pager) {
            return "pager";
        }
        if (div instanceof Div.Tabs) {
            return "tabs";
        }
        if (div instanceof Div.Custom) {
            return "custom";
        }
        if (div instanceof Div.Select) {
            return "select";
        }
        if (div instanceof Div.Switch) {
            return "switch";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean canBeReused(Div div, Div other, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(div, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (!Intrinsics.areEqual(getType(div), getType(other))) {
            return false;
        }
        DivBase divBaseValue = div.value();
        DivBase divBaseValue2 = other.value();
        if ((divBaseValue instanceof DivImage) && (divBaseValue2 instanceof DivImage)) {
            return Intrinsics.areEqual(((DivImage) divBaseValue).imageUrl.evaluate(resolver), ((DivImage) divBaseValue2).imageUrl.evaluate(resolver));
        }
        return divBaseValue.getBackground() == divBaseValue2.getBackground();
    }

    public static final Interpolator getAndroidInterpolator(DivAnimationInterpolator divAnimationInterpolator) {
        Intrinsics.checkNotNullParameter(divAnimationInterpolator, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[divAnimationInterpolator.ordinal()]) {
            case 1:
                return new LinearInterpolator();
            case 2:
                return new EaseInterpolator();
            case 3:
                return new EaseInInterpolator();
            case 4:
                return new EaseOutInterpolator();
            case 5:
                return new EaseInOutInterpolator();
            case 6:
                return new SpringInterpolator();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final Interpolator androidInterpolator(DivAnimationInterpolator divAnimationInterpolator, boolean z) {
        Intrinsics.checkNotNullParameter(divAnimationInterpolator, "<this>");
        if (z) {
            return ReverseInterpolatorKt.reversed(getAndroidInterpolator(divAnimationInterpolator));
        }
        return getAndroidInterpolator(divAnimationInterpolator);
    }

    public static final boolean isReversed(DivAnimationDirection divAnimationDirection) {
        Intrinsics.checkNotNullParameter(divAnimationDirection, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[divAnimationDirection.ordinal()];
        return i == 1 || i == 2;
    }

    public static final boolean isAlternated(DivAnimationDirection divAnimationDirection) {
        Intrinsics.checkNotNullParameter(divAnimationDirection, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[divAnimationDirection.ordinal()];
        return i == 2 || i == 3;
    }

    public static final void requestHierarchyLayout(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v.requestLayout();
        if (v instanceof ViewGroup) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) v).iterator();
            while (it.hasNext()) {
                requestHierarchyLayout(it.next());
            }
        }
    }

    public static final float[] getCornerRadii(DivBorder divBorder, float f, float f2, DisplayMetrics metrics, ExpressionResolver resolver) {
        Expression<Long> expression;
        Expression<Long> expression2;
        Expression<Long> expression3;
        Expression<Long> expression4;
        Intrinsics.checkNotNullParameter(divBorder, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        DivCornersRadius divCornersRadius = divBorder.cornersRadius;
        if (divCornersRadius == null || (expression = divCornersRadius.topLeft) == null) {
            expression = divBorder.cornerRadius;
        }
        float fDpToPx = BaseDivViewExtensionsKt.dpToPx(expression != null ? expression.evaluate(resolver) : null, metrics);
        DivCornersRadius divCornersRadius2 = divBorder.cornersRadius;
        if (divCornersRadius2 == null || (expression2 = divCornersRadius2.topRight) == null) {
            expression2 = divBorder.cornerRadius;
        }
        float fDpToPx2 = BaseDivViewExtensionsKt.dpToPx(expression2 != null ? expression2.evaluate(resolver) : null, metrics);
        DivCornersRadius divCornersRadius3 = divBorder.cornersRadius;
        if (divCornersRadius3 == null || (expression3 = divCornersRadius3.bottomLeft) == null) {
            expression3 = divBorder.cornerRadius;
        }
        float fDpToPx3 = BaseDivViewExtensionsKt.dpToPx(expression3 != null ? expression3.evaluate(resolver) : null, metrics);
        DivCornersRadius divCornersRadius4 = divBorder.cornersRadius;
        if (divCornersRadius4 == null || (expression4 = divCornersRadius4.bottomRight) == null) {
            expression4 = divBorder.cornerRadius;
        }
        float fDpToPx4 = BaseDivViewExtensionsKt.dpToPx(expression4 != null ? expression4.evaluate(resolver) : null, metrics);
        Float f3 = (Float) Collections.min(CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(f / (fDpToPx + fDpToPx2)), Float.valueOf(f / (fDpToPx3 + fDpToPx4)), Float.valueOf(f2 / (fDpToPx + fDpToPx3)), Float.valueOf(f2 / (fDpToPx2 + fDpToPx4))}));
        Intrinsics.checkNotNullExpressionValue(f3, "f");
        if (f3.floatValue() > 0.0f && f3.floatValue() < 1.0f) {
            fDpToPx *= f3.floatValue();
            fDpToPx2 *= f3.floatValue();
            fDpToPx3 *= f3.floatValue();
            fDpToPx4 *= f3.floatValue();
        }
        return new float[]{fDpToPx, fDpToPx, fDpToPx2, fDpToPx2, fDpToPx4, fDpToPx4, fDpToPx3, fDpToPx3};
    }

    public static final boolean containsStateInnerTransitions(Div div, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(div, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        DivBase divBaseValue = div.value();
        if (divBaseValue.getTransitionIn() != null || divBaseValue.getTransitionChange() != null || divBaseValue.getTransitionOut() != null) {
            return true;
        }
        if (!(div instanceof Div.Container)) {
            if (!(div instanceof Div.Grid)) {
                if (!(div instanceof Div.Text) && !(div instanceof Div.Image) && !(div instanceof Div.GifImage) && !(div instanceof Div.Separator) && !(div instanceof Div.Indicator) && !(div instanceof Div.State) && !(div instanceof Div.Gallery) && !(div instanceof Div.Pager) && !(div instanceof Div.Tabs) && !(div instanceof Div.Custom) && !(div instanceof Div.Select) && !(div instanceof Div.Slider) && !(div instanceof Div.Video) && !(div instanceof Div.Input) && !(div instanceof Div.Switch)) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                List<Div> nonNullItems = DivCollectionExtensionsKt.getNonNullItems(((Div.Grid) div).getValue());
                if (!(nonNullItems instanceof Collection) || !nonNullItems.isEmpty()) {
                    Iterator<T> it = nonNullItems.iterator();
                    while (it.hasNext()) {
                        if (containsStateInnerTransitions((Div) it.next(), resolver)) {
                            return true;
                        }
                    }
                }
            }
        } else {
            List<DivItemBuilderResult> listBuildItems = DivCollectionExtensionsKt.buildItems(((Div.Container) div).getValue(), resolver);
            if (!(listBuildItems instanceof Collection) || !listBuildItems.isEmpty()) {
                for (DivItemBuilderResult divItemBuilderResult : listBuildItems) {
                    if (containsStateInnerTransitions(divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final DivState.State getDefaultState(DivState divState, ExpressionResolver resolver) {
        Object next;
        Intrinsics.checkNotNullParameter(divState, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Expression<String> expression = divState.defaultStateId;
        if (expression != null) {
            Iterator<T> it = divState.states.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((DivState.State) next).stateId, expression.evaluate(resolver)));
            DivState.State state = (DivState.State) next;
            if (state != null) {
                return state;
            }
        }
        return (DivState.State) CollectionsKt.firstOrNull((List) divState.states);
    }

    public static final boolean isBranch(Div div) {
        Intrinsics.checkNotNullParameter(div, "<this>");
        boolean z = false;
        if (!(div instanceof Div.Text) && !(div instanceof Div.Image) && !(div instanceof Div.GifImage) && !(div instanceof Div.Separator) && !(div instanceof Div.Indicator) && !(div instanceof Div.Slider) && !(div instanceof Div.Input) && !(div instanceof Div.Custom) && !(div instanceof Div.Select) && !(div instanceof Div.Video) && !(div instanceof Div.Switch)) {
            z = true;
            if (!(div instanceof Div.Container) && !(div instanceof Div.Grid) && !(div instanceof Div.Gallery) && !(div instanceof Div.Pager) && !(div instanceof Div.Tabs) && !(div instanceof Div.State)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return z;
    }

    public static final boolean isLeaf(Div div) {
        Intrinsics.checkNotNullParameter(div, "<this>");
        return !isBranch(div);
    }

    public static final List<Variable> toVariables(List<? extends DivVariable> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends DivVariable> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(DivVariablesParserKt.toVariable((DivVariable) it.next()));
        }
        return arrayList;
    }
}
