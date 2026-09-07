package com.yandex.div.core.util;

import com.yandex.div.core.Disposable;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAbsoluteEdgeInsets;
import com.yandex.div2.DivBackground;
import com.yandex.div2.DivCircleShape;
import com.yandex.div2.DivDrawable;
import com.yandex.div2.DivEdgeInsets;
import com.yandex.div2.DivFilter;
import com.yandex.div2.DivFixedSize;
import com.yandex.div2.DivImageBackground;
import com.yandex.div2.DivLinearGradient;
import com.yandex.div2.DivNinePatchBackground;
import com.yandex.div2.DivPivot;
import com.yandex.div2.DivPivotFixed;
import com.yandex.div2.DivRadialGradient;
import com.yandex.div2.DivRadialGradientCenter;
import com.yandex.div2.DivRadialGradientRadius;
import com.yandex.div2.DivRoundedRectangleShape;
import com.yandex.div2.DivShape;
import com.yandex.div2.DivShapeDrawable;
import com.yandex.div2.DivSize;
import com.yandex.div2.DivSizeUnit;
import com.yandex.div2.DivStroke;
import com.yandex.div2.DivTransform;
import com.yandex.div2.DivWrapContentSize;
import io.appmetrica.analytics.impl.J2;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpressionSubscribers.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010\n\u001a\u00020\u0001*\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010\u001e\u001a\u00020\u0001*\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010!\u001a\u00020\u0001*\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010$\u001a\u00020\u0001*\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010'\u001a\u00020\u0001*\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010*\u001a\u00020\u0001*\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u0010-\u001a\u00020\u0001*\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u00100\u001a\u00020\u0001*\u00020\u00022\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a2\u00103\u001a\u00020\u0001*\u00020\u00022\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0000¨\u00066"}, d2 = {"observeAbsoluteEdgeInsets", "", "Lcom/yandex/div/internal/core/ExpressionSubscriber;", "insets", "Lcom/yandex/div2/DivAbsoluteEdgeInsets;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "callback", "Lkotlin/Function1;", "", "observeBackground", J2.g, "Lcom/yandex/div2/DivBackground;", "observeCircleShape", "circle", "Lcom/yandex/div2/DivCircleShape;", "observeColorPoint", "colorPoint", "Lcom/yandex/div2/DivLinearGradient$ColorPoint;", "observeDrawable", "drawable", "Lcom/yandex/div2/DivDrawable;", "observeEdgeInsets", "Lcom/yandex/div2/DivEdgeInsets;", "observeFilter", "filter", "Lcom/yandex/div2/DivFilter;", "observeFixedSize", "fixedSize", "Lcom/yandex/div2/DivFixedSize;", "observePivot", "pivot", "Lcom/yandex/div2/DivPivot;", "observeRadialGradientCenter", "center", "Lcom/yandex/div2/DivRadialGradientCenter;", "observeRadialGradientRadius", "radius", "Lcom/yandex/div2/DivRadialGradientRadius;", "observeRoundedRectangleShape", "roundedRectangle", "Lcom/yandex/div2/DivRoundedRectangleShape;", "observeShape", "shape", "Lcom/yandex/div2/DivShape;", "observeSize", ContentDisposition.Parameters.Size, "Lcom/yandex/div2/DivSize;", "observeStroke", VastAttributes.STROKE_COLOR, "Lcom/yandex/div2/DivStroke;", "observeTransform", "transform", "Lcom/yandex/div2/DivTransform;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ExpressionSubscribersKt {
    public static final void observeSize(ExpressionSubscriber expressionSubscriber, DivSize divSize, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Expression<DivSizeUnit> expression;
        Expression<Long> expression2;
        Expression<DivSizeUnit> expression3;
        Expression<Long> expression4;
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divSize != null) {
            if (divSize instanceof DivSize.Fixed) {
                DivFixedSize value = ((DivSize.Fixed) divSize).getValue();
                expressionSubscriber.addSubscription(value.value.observe(resolver, callback));
                expressionSubscriber.addSubscription(value.unit.observe(resolver, callback));
                return;
            }
            Disposable disposableObserve = null;
            if (divSize instanceof DivSize.MatchParent) {
                Expression<Double> expression5 = ((DivSize.MatchParent) divSize).getValue().weight;
                expressionSubscriber.addSubscription(expression5 != null ? expression5.observe(resolver, callback) : null);
                return;
            }
            if (divSize instanceof DivSize.WrapContent) {
                DivWrapContentSize value2 = ((DivSize.WrapContent) divSize).getValue();
                Expression<Boolean> expression6 = value2.constrained;
                expressionSubscriber.addSubscription(expression6 != null ? expression6.observe(resolver, callback) : null);
                DivWrapContentSize.ConstraintSize constraintSize = value2.minSize;
                expressionSubscriber.addSubscription((constraintSize == null || (expression4 = constraintSize.value) == null) ? null : expression4.observe(resolver, callback));
                DivWrapContentSize.ConstraintSize constraintSize2 = value2.minSize;
                expressionSubscriber.addSubscription((constraintSize2 == null || (expression3 = constraintSize2.unit) == null) ? null : expression3.observe(resolver, callback));
                DivWrapContentSize.ConstraintSize constraintSize3 = value2.maxSize;
                expressionSubscriber.addSubscription((constraintSize3 == null || (expression2 = constraintSize3.value) == null) ? null : expression2.observe(resolver, callback));
                DivWrapContentSize.ConstraintSize constraintSize4 = value2.maxSize;
                if (constraintSize4 != null && (expression = constraintSize4.unit) != null) {
                    disposableObserve = expression.observe(resolver, callback);
                }
                expressionSubscriber.addSubscription(disposableObserve);
            }
        }
    }

    public static final void observeFixedSize(ExpressionSubscriber expressionSubscriber, DivFixedSize divFixedSize, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divFixedSize == null) {
            return;
        }
        expressionSubscriber.addSubscription(divFixedSize.value.observe(resolver, callback));
        expressionSubscriber.addSubscription(divFixedSize.unit.observe(resolver, callback));
    }

    public static final void observeEdgeInsets(ExpressionSubscriber expressionSubscriber, DivEdgeInsets divEdgeInsets, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divEdgeInsets == null) {
            return;
        }
        expressionSubscriber.addSubscription(divEdgeInsets.top.observe(resolver, callback));
        expressionSubscriber.addSubscription(divEdgeInsets.bottom.observe(resolver, callback));
        if (divEdgeInsets.start != null || divEdgeInsets.end != null) {
            Expression<Long> expression = divEdgeInsets.start;
            expressionSubscriber.addSubscription(expression != null ? expression.observe(resolver, callback) : null);
            Expression<Long> expression2 = divEdgeInsets.end;
            expressionSubscriber.addSubscription(expression2 != null ? expression2.observe(resolver, callback) : null);
            return;
        }
        expressionSubscriber.addSubscription(divEdgeInsets.left.observe(resolver, callback));
        expressionSubscriber.addSubscription(divEdgeInsets.right.observe(resolver, callback));
    }

    public static final void observeAbsoluteEdgeInsets(ExpressionSubscriber expressionSubscriber, DivAbsoluteEdgeInsets divAbsoluteEdgeInsets, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divAbsoluteEdgeInsets == null) {
            return;
        }
        expressionSubscriber.addSubscription(divAbsoluteEdgeInsets.left.observe(resolver, callback));
        expressionSubscriber.addSubscription(divAbsoluteEdgeInsets.top.observe(resolver, callback));
        expressionSubscriber.addSubscription(divAbsoluteEdgeInsets.right.observe(resolver, callback));
        expressionSubscriber.addSubscription(divAbsoluteEdgeInsets.bottom.observe(resolver, callback));
    }

    public static final void observeTransform(ExpressionSubscriber expressionSubscriber, DivTransform divTransform, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divTransform == null) {
            return;
        }
        Expression<Double> expression = divTransform.rotation;
        expressionSubscriber.addSubscription(expression != null ? expression.observe(resolver, callback) : null);
        observePivot(expressionSubscriber, divTransform.pivotX, resolver, callback);
        observePivot(expressionSubscriber, divTransform.pivotY, resolver, callback);
    }

    public static final void observePivot(ExpressionSubscriber expressionSubscriber, DivPivot divPivot, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divPivot != null) {
            if (divPivot instanceof DivPivot.Fixed) {
                DivPivotFixed value = ((DivPivot.Fixed) divPivot).getValue();
                Expression<Long> expression = value.value;
                expressionSubscriber.addSubscription(expression != null ? expression.observe(resolver, callback) : null);
                expressionSubscriber.addSubscription(value.unit.observe(resolver, callback));
                return;
            }
            if (divPivot instanceof DivPivot.Percentage) {
                expressionSubscriber.addSubscription(((DivPivot.Percentage) divPivot).getValue().value.observe(resolver, callback));
            }
        }
    }

    public static final void observeFilter(ExpressionSubscriber expressionSubscriber, DivFilter divFilter, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divFilter == null || (divFilter instanceof DivFilter.RtlMirror) || !(divFilter instanceof DivFilter.Blur)) {
            return;
        }
        expressionSubscriber.addSubscription(((DivFilter.Blur) divFilter).getValue().radius.observe(resolver, callback));
    }

    public static final void observeDrawable(ExpressionSubscriber expressionSubscriber, DivDrawable divDrawable, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divDrawable == null || !(divDrawable instanceof DivDrawable.Shape)) {
            return;
        }
        DivShapeDrawable value = ((DivDrawable.Shape) divDrawable).getValue();
        expressionSubscriber.addSubscription(value.color.observe(resolver, callback));
        observeShape(expressionSubscriber, value.shape, resolver, callback);
        observeStroke(expressionSubscriber, value.stroke, resolver, callback);
    }

    public static final void observeShape(ExpressionSubscriber expressionSubscriber, DivShape divShape, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divShape != null) {
            if (divShape instanceof DivShape.RoundedRectangle) {
                observeRoundedRectangleShape(expressionSubscriber, ((DivShape.RoundedRectangle) divShape).getValue(), resolver, callback);
            } else if (divShape instanceof DivShape.Circle) {
                observeCircleShape(expressionSubscriber, ((DivShape.Circle) divShape).getValue(), resolver, callback);
            }
        }
    }

    public static final void observeRoundedRectangleShape(ExpressionSubscriber expressionSubscriber, DivRoundedRectangleShape divRoundedRectangleShape, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divRoundedRectangleShape == null) {
            return;
        }
        Expression<Integer> expression = divRoundedRectangleShape.backgroundColor;
        expressionSubscriber.addSubscription(expression != null ? expression.observe(resolver, callback) : null);
        observeFixedSize(expressionSubscriber, divRoundedRectangleShape.cornerRadius, resolver, callback);
        observeFixedSize(expressionSubscriber, divRoundedRectangleShape.itemWidth, resolver, callback);
        observeFixedSize(expressionSubscriber, divRoundedRectangleShape.itemHeight, resolver, callback);
        observeStroke(expressionSubscriber, divRoundedRectangleShape.stroke, resolver, callback);
    }

    public static final void observeCircleShape(ExpressionSubscriber expressionSubscriber, DivCircleShape divCircleShape, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divCircleShape == null) {
            return;
        }
        Expression<Integer> expression = divCircleShape.backgroundColor;
        expressionSubscriber.addSubscription(expression != null ? expression.observe(resolver, callback) : null);
        observeFixedSize(expressionSubscriber, divCircleShape.radius, resolver, callback);
        observeStroke(expressionSubscriber, divCircleShape.stroke, resolver, callback);
    }

    public static final void observeStroke(ExpressionSubscriber expressionSubscriber, DivStroke divStroke, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divStroke == null) {
            return;
        }
        expressionSubscriber.addSubscription(divStroke.color.observe(resolver, callback));
        expressionSubscriber.addSubscription(divStroke.width.observe(resolver, callback));
        expressionSubscriber.addSubscription(divStroke.unit.observe(resolver, callback));
    }

    public static final void observeBackground(ExpressionSubscriber expressionSubscriber, DivBackground divBackground, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divBackground != null) {
            if (divBackground instanceof DivBackground.Solid) {
                expressionSubscriber.addSubscription(((DivBackground.Solid) divBackground).getValue().color.observe(resolver, callback));
                return;
            }
            if (divBackground instanceof DivBackground.Image) {
                DivImageBackground value = ((DivBackground.Image) divBackground).getValue();
                expressionSubscriber.addSubscription(value.alpha.observe(resolver, callback));
                expressionSubscriber.addSubscription(value.imageUrl.observe(resolver, callback));
                expressionSubscriber.addSubscription(value.contentAlignmentHorizontal.observe(resolver, callback));
                expressionSubscriber.addSubscription(value.contentAlignmentVertical.observe(resolver, callback));
                expressionSubscriber.addSubscription(value.preloadRequired.observe(resolver, callback));
                expressionSubscriber.addSubscription(value.scale.observe(resolver, callback));
                List<DivFilter> list = value.filters;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        observeFilter(expressionSubscriber, (DivFilter) it.next(), resolver, callback);
                    }
                    return;
                }
                return;
            }
            if (divBackground instanceof DivBackground.LinearGradient) {
                DivLinearGradient value2 = ((DivBackground.LinearGradient) divBackground).getValue();
                expressionSubscriber.addSubscription(value2.angle.observe(resolver, callback));
                ExpressionList<Integer> expressionList = value2.colors;
                expressionSubscriber.addSubscription(expressionList != null ? expressionList.observe(resolver, callback) : null);
                List<DivLinearGradient.ColorPoint> list2 = value2.colorMap;
                if (list2 != null) {
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        observeColorPoint(expressionSubscriber, (DivLinearGradient.ColorPoint) it2.next(), resolver, callback);
                    }
                    return;
                }
                return;
            }
            if (divBackground instanceof DivBackground.RadialGradient) {
                DivRadialGradient value3 = ((DivBackground.RadialGradient) divBackground).getValue();
                expressionSubscriber.addSubscription(value3.colors.observe(resolver, callback));
                observeRadialGradientCenter(expressionSubscriber, value3.centerX, resolver, callback);
                observeRadialGradientCenter(expressionSubscriber, value3.centerY, resolver, callback);
                observeRadialGradientRadius(expressionSubscriber, value3.radius, resolver, callback);
                return;
            }
            if (divBackground instanceof DivBackground.NinePatch) {
                DivNinePatchBackground value4 = ((DivBackground.NinePatch) divBackground).getValue();
                expressionSubscriber.addSubscription(value4.imageUrl.observe(resolver, callback));
                observeAbsoluteEdgeInsets(expressionSubscriber, value4.insets, resolver, callback);
            }
        }
    }

    public static final void observeColorPoint(ExpressionSubscriber expressionSubscriber, DivLinearGradient.ColorPoint colorPoint, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (colorPoint == null) {
            return;
        }
        expressionSubscriber.addSubscription(colorPoint.color.observe(resolver, callback));
        expressionSubscriber.addSubscription(colorPoint.position.observe(resolver, callback));
    }

    public static final void observeRadialGradientCenter(ExpressionSubscriber expressionSubscriber, DivRadialGradientCenter divRadialGradientCenter, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divRadialGradientCenter != null) {
            if (divRadialGradientCenter instanceof DivRadialGradientCenter.Fixed) {
                DivRadialGradientCenter.Fixed fixed = (DivRadialGradientCenter.Fixed) divRadialGradientCenter;
                expressionSubscriber.addSubscription(fixed.getValue().unit.observe(resolver, callback));
                expressionSubscriber.addSubscription(fixed.getValue().value.observe(resolver, callback));
            } else if (divRadialGradientCenter instanceof DivRadialGradientCenter.Relative) {
                expressionSubscriber.addSubscription(((DivRadialGradientCenter.Relative) divRadialGradientCenter).getValue().value.observe(resolver, callback));
            }
        }
    }

    public static final void observeRadialGradientRadius(ExpressionSubscriber expressionSubscriber, DivRadialGradientRadius divRadialGradientRadius, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(expressionSubscriber, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divRadialGradientRadius != null) {
            if (divRadialGradientRadius instanceof DivRadialGradientRadius.FixedSize) {
                DivRadialGradientRadius.FixedSize fixedSize = (DivRadialGradientRadius.FixedSize) divRadialGradientRadius;
                expressionSubscriber.addSubscription(fixedSize.getValue().unit.observe(resolver, callback));
                expressionSubscriber.addSubscription(fixedSize.getValue().value.observe(resolver, callback));
            } else if (divRadialGradientRadius instanceof DivRadialGradientRadius.Relative) {
                expressionSubscriber.addSubscription(((DivRadialGradientRadius.Relative) divRadialGradientRadius).getValue().value.observe(resolver, callback));
            }
        }
    }
}
