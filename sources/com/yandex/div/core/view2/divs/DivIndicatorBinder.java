package com.yandex.div.core.view2.divs;

import android.util.DisplayMetrics;
import com.yandex.div.core.util.ExpressionSubscribersKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.divs.pager.PagerIndicatorConnector;
import com.yandex.div.core.view2.divs.widgets.DivPagerIndicatorView;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.widget.indicator.IndicatorParams;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivFixedSize;
import com.yandex.div2.DivIndicator;
import com.yandex.div2.DivIndicatorItemPlacement;
import com.yandex.div2.DivRoundedRectangleShape;
import com.yandex.div2.DivShape;
import com.yandex.div2.DivSizeUnit;
import com.yandex.div2.DivStroke;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivIndicatorBinder.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u001c\u0010\u000f\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\n\u0010\u0013\u001a\u00020\u0014*\u00020\u0015J%\u0010\u0016\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J0\u0010\u001e\u001a\u00020\n*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\n0!H\u0002J4\u0010#\u001a\u00020\u0017*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0(2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0002J4\u0010#\u001a\u00020\u0017*\u00020)2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0(2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivIndicatorBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivIndicator;", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerIndicatorView;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "pagerIndicatorConnector", "Lcom/yandex/div/core/view2/divs/pager/PagerIndicatorConnector;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/view2/divs/pager/PagerIndicatorConnector;)V", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "applyStyle", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "indicator", "convert", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Animation;", "Lcom/yandex/div2/DivIndicator$Animation;", "multiply", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;", "multiplier", "", "color", "", "(Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;FLjava/lang/Integer;)Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;", "observeStyle", "observeWidthAndHeightSubscription", "Lcom/yandex/div2/DivBase;", "callback", "Lkotlin/Function1;", "", "toIndicatorParamsShape", "Lcom/yandex/div2/DivRoundedRectangleShape;", "metrics", "Landroid/util/DisplayMetrics;", "deprecatedColor", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivShape;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivIndicatorBinder implements DivViewBinder<DivIndicator, DivPagerIndicatorView> {
    private final DivBaseBinder baseBinder;
    private final PagerIndicatorConnector pagerIndicatorConnector;

    @Inject
    public DivIndicatorBinder(DivBaseBinder baseBinder, PagerIndicatorConnector pagerIndicatorConnector) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(pagerIndicatorConnector, "pagerIndicatorConnector");
        this.baseBinder = baseBinder;
        this.pagerIndicatorConnector = pagerIndicatorConnector;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, DivPagerIndicatorView view, DivIndicator div) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        String str = div.pagerId;
        if (str != null) {
            this.pagerIndicatorConnector.submitIndicator$div_release(str, view);
        }
        DivIndicator div2 = view.getDiv();
        if (div == div2) {
            return;
        }
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        this.baseBinder.bindView(context, view, div, div2);
        observeStyle(view, expressionResolver, div);
    }

    private final void observeStyle(final DivPagerIndicatorView divPagerIndicatorView, final ExpressionResolver expressionResolver, final DivIndicator divIndicator) {
        applyStyle(divPagerIndicatorView, expressionResolver, divIndicator);
        Function1<? super DivIndicator.Animation, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivIndicatorBinder$observeStyle$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                this.this$0.applyStyle(divPagerIndicatorView, expressionResolver, divIndicator);
            }
        };
        divPagerIndicatorView.addSubscription(divIndicator.animation.observe(expressionResolver, function1));
        divPagerIndicatorView.addSubscription(divIndicator.activeItemColor.observe(expressionResolver, function1));
        divPagerIndicatorView.addSubscription(divIndicator.activeItemSize.observe(expressionResolver, function1));
        divPagerIndicatorView.addSubscription(divIndicator.inactiveItemColor.observe(expressionResolver, function1));
        divPagerIndicatorView.addSubscription(divIndicator.minimumItemSize.observe(expressionResolver, function1));
        DivPagerIndicatorView divPagerIndicatorView2 = divPagerIndicatorView;
        ExpressionSubscribersKt.observeShape(divPagerIndicatorView2, divIndicator.shape, expressionResolver, function1);
        ExpressionSubscribersKt.observeRoundedRectangleShape(divPagerIndicatorView2, divIndicator.activeShape, expressionResolver, function1);
        ExpressionSubscribersKt.observeRoundedRectangleShape(divPagerIndicatorView2, divIndicator.inactiveShape, expressionResolver, function1);
        ExpressionSubscribersKt.observeRoundedRectangleShape(divPagerIndicatorView2, divIndicator.inactiveMinimumShape, expressionResolver, function1);
        DivIndicatorItemPlacement itemsPlacementCompat = BaseDivViewExtensionsKt.getItemsPlacementCompat(divIndicator);
        if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Default) {
            DivIndicatorItemPlacement.Default r1 = (DivIndicatorItemPlacement.Default) itemsPlacementCompat;
            divPagerIndicatorView.addSubscription(r1.getValue().spaceBetweenCenters.value.observe(expressionResolver, function1));
            divPagerIndicatorView.addSubscription(r1.getValue().spaceBetweenCenters.unit.observe(expressionResolver, function1));
        } else if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Stretch) {
            DivIndicatorItemPlacement.Stretch stretch = (DivIndicatorItemPlacement.Stretch) itemsPlacementCompat;
            divPagerIndicatorView.addSubscription(stretch.getValue().itemSpacing.value.observe(expressionResolver, function1));
            divPagerIndicatorView.addSubscription(stretch.getValue().itemSpacing.unit.observe(expressionResolver, function1));
            divPagerIndicatorView.addSubscription(stretch.getValue().maxVisibleItems.observe(expressionResolver, function1));
        }
        observeWidthAndHeightSubscription(divPagerIndicatorView, divIndicator, expressionResolver, function1);
    }

    private final void observeWidthAndHeightSubscription(DivPagerIndicatorView divPagerIndicatorView, DivBase divBase, ExpressionResolver expressionResolver, Function1<Object, Unit> function1) {
        Object objValue = divBase.getWidth().value();
        if (objValue instanceof DivFixedSize) {
            ExpressionSubscribersKt.observeFixedSize(divPagerIndicatorView, (DivFixedSize) objValue, expressionResolver, function1);
        }
        Object objValue2 = divBase.getHeight().value();
        if (objValue2 instanceof DivFixedSize) {
            ExpressionSubscribersKt.observeFixedSize(divPagerIndicatorView, (DivFixedSize) objValue2, expressionResolver, function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0091  */
    /* JADX WARN: Code duplicated, block: B:20:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:21:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:24:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:27:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:31:0x0100  */
    /* JADX WARN: Code duplicated, block: B:33:0x0119  */
    /* JADX WARN: Code duplicated, block: B:35:0x011d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0149  */
    /* JADX WARN: Code duplicated, block: B:47:0x017b  */
    /* JADX WARN: Code duplicated, block: B:51:0x018e  */
    public final void applyStyle(DivPagerIndicatorView divPagerIndicatorView, ExpressionResolver expressionResolver, DivIndicator divIndicator) {
        String str;
        IndicatorParams.Shape indicatorParamsShape$default;
        IndicatorParams.Shape shape;
        IndicatorParams.Shape shape2;
        DivIndicatorBinder divIndicatorBinder;
        IndicatorParams.Shape shapeMultiply;
        String str2;
        IndicatorParams.Shape shapeMultiply$default;
        DivIndicatorItemPlacement itemsPlacementCompat;
        long jLongValue;
        long j;
        int i;
        IndicatorParams.ItemPlacement.Stretch stretch;
        IndicatorParams.Shape indicatorParamsShape$default2;
        DisplayMetrics metrics = divPagerIndicatorView.getResources().getDisplayMetrics();
        DivRoundedRectangleShape divRoundedRectangleShape = divIndicator.activeShape;
        DivRoundedRectangleShape divRoundedRectangleShape2 = divIndicator.inactiveShape;
        DivRoundedRectangleShape divRoundedRectangleShape3 = divIndicator.inactiveMinimumShape;
        float fDoubleValue = (float) divIndicator.activeItemSize.evaluate(expressionResolver).doubleValue();
        float fDoubleValue2 = (float) divIndicator.minimumItemSize.evaluate(expressionResolver).doubleValue();
        if (divRoundedRectangleShape2 != null) {
            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
            str = "metrics";
            indicatorParamsShape$default = toIndicatorParamsShape$default(this, divRoundedRectangleShape2, metrics, expressionResolver, divIndicator.inactiveItemColor, 0.0f, 8, (Object) null);
            if (indicatorParamsShape$default == null) {
            }
            shape = indicatorParamsShape$default;
            if (divRoundedRectangleShape != null) {
                Intrinsics.checkNotNullExpressionValue(metrics, str);
                shape2 = shape;
                indicatorParamsShape$default2 = toIndicatorParamsShape$default(this, divRoundedRectangleShape, metrics, expressionResolver, divIndicator.activeItemColor, 0.0f, 8, (Object) null);
                if (indicatorParamsShape$default2 == null) {
                    shapeMultiply = indicatorParamsShape$default2;
                    divIndicatorBinder = this;
                }
                if (divRoundedRectangleShape3 != null) {
                    Intrinsics.checkNotNullExpressionValue(metrics, str);
                    str2 = str;
                    shapeMultiply$default = toIndicatorParamsShape$default(this, divRoundedRectangleShape3, metrics, expressionResolver, divIndicator.inactiveItemColor, 0.0f, 8, (Object) null);
                    if (shapeMultiply$default == null) {
                    }
                    IndicatorParams.Shape shape3 = shapeMultiply$default;
                    IndicatorParams.Animation animationConvert = divIndicatorBinder.convert(divIndicator.animation.evaluate(expressionResolver));
                    itemsPlacementCompat = BaseDivViewExtensionsKt.getItemsPlacementCompat(divIndicator);
                    if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Default) {
                        DivFixedSize divFixedSize = ((DivIndicatorItemPlacement.Default) itemsPlacementCompat).getValue().spaceBetweenCenters;
                        Intrinsics.checkNotNullExpressionValue(metrics, str2);
                        stretch = new IndicatorParams.ItemPlacement.Default(BaseDivViewExtensionsKt.toPx(divFixedSize, metrics, expressionResolver));
                    } else {
                        if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Stretch) {
                            throw new NoWhenBranchMatchedException();
                        }
                        DivIndicatorItemPlacement.Stretch stretch2 = (DivIndicatorItemPlacement.Stretch) itemsPlacementCompat;
                        DivFixedSize divFixedSize2 = stretch2.getValue().itemSpacing;
                        Intrinsics.checkNotNullExpressionValue(metrics, str2);
                        float px = BaseDivViewExtensionsKt.toPx(divFixedSize2, metrics, expressionResolver);
                        jLongValue = stretch2.getValue().maxVisibleItems.evaluate(expressionResolver).longValue();
                        j = jLongValue >> 31;
                        if (j != 0 || j == -1) {
                            i = (int) jLongValue;
                        } else {
                            KAssert kAssert = KAssert.INSTANCE;
                            if (Assert.isEnabled()) {
                                Assert.fail("Unable convert '" + jLongValue + "' to Int");
                            }
                            i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        }
                        stretch = new IndicatorParams.ItemPlacement.Stretch(px, i);
                    }
                    divPagerIndicatorView.setStyle(new IndicatorParams.Style(animationConvert, shapeMultiply, shape2, shape3, stretch));
                }
                str2 = str;
                shapeMultiply$default = multiply$default(this, shape2, fDoubleValue2, null, 2, null);
                IndicatorParams.Shape shape4 = shapeMultiply$default;
                IndicatorParams.Animation animationConvert2 = divIndicatorBinder.convert(divIndicator.animation.evaluate(expressionResolver));
                itemsPlacementCompat = BaseDivViewExtensionsKt.getItemsPlacementCompat(divIndicator);
                if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Default) {
                    DivFixedSize divFixedSize3 = ((DivIndicatorItemPlacement.Default) itemsPlacementCompat).getValue().spaceBetweenCenters;
                    Intrinsics.checkNotNullExpressionValue(metrics, str2);
                    stretch = new IndicatorParams.ItemPlacement.Default(BaseDivViewExtensionsKt.toPx(divFixedSize3, metrics, expressionResolver));
                } else {
                    if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Stretch) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DivIndicatorItemPlacement.Stretch stretch3 = (DivIndicatorItemPlacement.Stretch) itemsPlacementCompat;
                    DivFixedSize divFixedSize4 = stretch3.getValue().itemSpacing;
                    Intrinsics.checkNotNullExpressionValue(metrics, str2);
                    float px2 = BaseDivViewExtensionsKt.toPx(divFixedSize4, metrics, expressionResolver);
                    jLongValue = stretch3.getValue().maxVisibleItems.evaluate(expressionResolver).longValue();
                    j = jLongValue >> 31;
                    if (j != 0) {
                        i = (int) jLongValue;
                    } else {
                        i = (int) jLongValue;
                    }
                    stretch = new IndicatorParams.ItemPlacement.Stretch(px2, i);
                }
                divPagerIndicatorView.setStyle(new IndicatorParams.Style(animationConvert2, shapeMultiply, shape2, shape4, stretch));
            }
            shape2 = shape;
            divIndicatorBinder = this;
            shapeMultiply = divIndicatorBinder.multiply(shape2, fDoubleValue, divIndicator.activeItemColor.evaluate(expressionResolver));
            if (divRoundedRectangleShape3 != null) {
                Intrinsics.checkNotNullExpressionValue(metrics, str);
                str2 = str;
                shapeMultiply$default = toIndicatorParamsShape$default(this, divRoundedRectangleShape3, metrics, expressionResolver, divIndicator.inactiveItemColor, 0.0f, 8, (Object) null);
                if (shapeMultiply$default == null) {
                }
                IndicatorParams.Shape shape5 = shapeMultiply$default;
                IndicatorParams.Animation animationConvert3 = divIndicatorBinder.convert(divIndicator.animation.evaluate(expressionResolver));
                itemsPlacementCompat = BaseDivViewExtensionsKt.getItemsPlacementCompat(divIndicator);
                if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Default) {
                    DivFixedSize divFixedSize5 = ((DivIndicatorItemPlacement.Default) itemsPlacementCompat).getValue().spaceBetweenCenters;
                    Intrinsics.checkNotNullExpressionValue(metrics, str2);
                    stretch = new IndicatorParams.ItemPlacement.Default(BaseDivViewExtensionsKt.toPx(divFixedSize5, metrics, expressionResolver));
                } else {
                    if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Stretch) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DivIndicatorItemPlacement.Stretch stretch4 = (DivIndicatorItemPlacement.Stretch) itemsPlacementCompat;
                    DivFixedSize divFixedSize6 = stretch4.getValue().itemSpacing;
                    Intrinsics.checkNotNullExpressionValue(metrics, str2);
                    float px3 = BaseDivViewExtensionsKt.toPx(divFixedSize6, metrics, expressionResolver);
                    jLongValue = stretch4.getValue().maxVisibleItems.evaluate(expressionResolver).longValue();
                    j = jLongValue >> 31;
                    if (j != 0) {
                        i = (int) jLongValue;
                    } else {
                        i = (int) jLongValue;
                    }
                    stretch = new IndicatorParams.ItemPlacement.Stretch(px3, i);
                }
                divPagerIndicatorView.setStyle(new IndicatorParams.Style(animationConvert3, shapeMultiply, shape2, shape5, stretch));
            }
            str2 = str;
            shapeMultiply$default = multiply$default(this, shape2, fDoubleValue2, null, 2, null);
            IndicatorParams.Shape shape6 = shapeMultiply$default;
            IndicatorParams.Animation animationConvert4 = divIndicatorBinder.convert(divIndicator.animation.evaluate(expressionResolver));
            itemsPlacementCompat = BaseDivViewExtensionsKt.getItemsPlacementCompat(divIndicator);
            if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Default) {
                DivFixedSize divFixedSize7 = ((DivIndicatorItemPlacement.Default) itemsPlacementCompat).getValue().spaceBetweenCenters;
                Intrinsics.checkNotNullExpressionValue(metrics, str2);
                stretch = new IndicatorParams.ItemPlacement.Default(BaseDivViewExtensionsKt.toPx(divFixedSize7, metrics, expressionResolver));
            } else {
                if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Stretch) {
                    throw new NoWhenBranchMatchedException();
                }
                DivIndicatorItemPlacement.Stretch stretch5 = (DivIndicatorItemPlacement.Stretch) itemsPlacementCompat;
                DivFixedSize divFixedSize8 = stretch5.getValue().itemSpacing;
                Intrinsics.checkNotNullExpressionValue(metrics, str2);
                float px4 = BaseDivViewExtensionsKt.toPx(divFixedSize8, metrics, expressionResolver);
                jLongValue = stretch5.getValue().maxVisibleItems.evaluate(expressionResolver).longValue();
                j = jLongValue >> 31;
                if (j != 0) {
                    i = (int) jLongValue;
                } else {
                    i = (int) jLongValue;
                }
                stretch = new IndicatorParams.ItemPlacement.Stretch(px4, i);
            }
            divPagerIndicatorView.setStyle(new IndicatorParams.Style(animationConvert4, shapeMultiply, shape2, shape6, stretch));
        }
        str = "metrics";
        if (divRoundedRectangleShape != null) {
            Intrinsics.checkNotNullExpressionValue(metrics, str);
            indicatorParamsShape$default = toIndicatorParamsShape(divRoundedRectangleShape, metrics, expressionResolver, divIndicator.inactiveItemColor, 1 / fDoubleValue);
        } else {
            if (divRoundedRectangleShape3 != null) {
                Intrinsics.checkNotNullExpressionValue(metrics, str);
                indicatorParamsShape$default = toIndicatorParamsShape(divRoundedRectangleShape3, metrics, expressionResolver, divIndicator.inactiveItemColor, fDoubleValue2);
            } else {
                indicatorParamsShape$default = null;
            }
            if (indicatorParamsShape$default == null) {
                DivShape divShape = divIndicator.shape;
                Intrinsics.checkNotNullExpressionValue(metrics, str);
                indicatorParamsShape$default = toIndicatorParamsShape$default(this, divShape, metrics, expressionResolver, divIndicator.inactiveItemColor, 0.0f, 8, (Object) null);
            }
        }
        shape = indicatorParamsShape$default;
        if (divRoundedRectangleShape != null) {
            Intrinsics.checkNotNullExpressionValue(metrics, str);
            shape2 = shape;
            indicatorParamsShape$default2 = toIndicatorParamsShape$default(this, divRoundedRectangleShape, metrics, expressionResolver, divIndicator.activeItemColor, 0.0f, 8, (Object) null);
            if (indicatorParamsShape$default2 == null) {
                shapeMultiply = indicatorParamsShape$default2;
                divIndicatorBinder = this;
            }
            if (divRoundedRectangleShape3 != null) {
                Intrinsics.checkNotNullExpressionValue(metrics, str);
                str2 = str;
                shapeMultiply$default = toIndicatorParamsShape$default(this, divRoundedRectangleShape3, metrics, expressionResolver, divIndicator.inactiveItemColor, 0.0f, 8, (Object) null);
                if (shapeMultiply$default == null) {
                }
                IndicatorParams.Shape shape7 = shapeMultiply$default;
                IndicatorParams.Animation animationConvert5 = divIndicatorBinder.convert(divIndicator.animation.evaluate(expressionResolver));
                itemsPlacementCompat = BaseDivViewExtensionsKt.getItemsPlacementCompat(divIndicator);
                if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Default) {
                    DivFixedSize divFixedSize9 = ((DivIndicatorItemPlacement.Default) itemsPlacementCompat).getValue().spaceBetweenCenters;
                    Intrinsics.checkNotNullExpressionValue(metrics, str2);
                    stretch = new IndicatorParams.ItemPlacement.Default(BaseDivViewExtensionsKt.toPx(divFixedSize9, metrics, expressionResolver));
                } else {
                    if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Stretch) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DivIndicatorItemPlacement.Stretch stretch6 = (DivIndicatorItemPlacement.Stretch) itemsPlacementCompat;
                    DivFixedSize divFixedSize10 = stretch6.getValue().itemSpacing;
                    Intrinsics.checkNotNullExpressionValue(metrics, str2);
                    float px5 = BaseDivViewExtensionsKt.toPx(divFixedSize10, metrics, expressionResolver);
                    jLongValue = stretch6.getValue().maxVisibleItems.evaluate(expressionResolver).longValue();
                    j = jLongValue >> 31;
                    if (j != 0) {
                        i = (int) jLongValue;
                    } else {
                        i = (int) jLongValue;
                    }
                    stretch = new IndicatorParams.ItemPlacement.Stretch(px5, i);
                }
                divPagerIndicatorView.setStyle(new IndicatorParams.Style(animationConvert5, shapeMultiply, shape2, shape7, stretch));
            }
            str2 = str;
            shapeMultiply$default = multiply$default(this, shape2, fDoubleValue2, null, 2, null);
            IndicatorParams.Shape shape8 = shapeMultiply$default;
            IndicatorParams.Animation animationConvert6 = divIndicatorBinder.convert(divIndicator.animation.evaluate(expressionResolver));
            itemsPlacementCompat = BaseDivViewExtensionsKt.getItemsPlacementCompat(divIndicator);
            if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Default) {
                DivFixedSize divFixedSize11 = ((DivIndicatorItemPlacement.Default) itemsPlacementCompat).getValue().spaceBetweenCenters;
                Intrinsics.checkNotNullExpressionValue(metrics, str2);
                stretch = new IndicatorParams.ItemPlacement.Default(BaseDivViewExtensionsKt.toPx(divFixedSize11, metrics, expressionResolver));
            } else {
                if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Stretch) {
                    throw new NoWhenBranchMatchedException();
                }
                DivIndicatorItemPlacement.Stretch stretch7 = (DivIndicatorItemPlacement.Stretch) itemsPlacementCompat;
                DivFixedSize divFixedSize12 = stretch7.getValue().itemSpacing;
                Intrinsics.checkNotNullExpressionValue(metrics, str2);
                float px6 = BaseDivViewExtensionsKt.toPx(divFixedSize12, metrics, expressionResolver);
                jLongValue = stretch7.getValue().maxVisibleItems.evaluate(expressionResolver).longValue();
                j = jLongValue >> 31;
                if (j != 0) {
                    i = (int) jLongValue;
                } else {
                    i = (int) jLongValue;
                }
                stretch = new IndicatorParams.ItemPlacement.Stretch(px6, i);
            }
            divPagerIndicatorView.setStyle(new IndicatorParams.Style(animationConvert6, shapeMultiply, shape2, shape8, stretch));
        }
        shape2 = shape;
        divIndicatorBinder = this;
        shapeMultiply = divIndicatorBinder.multiply(shape2, fDoubleValue, divIndicator.activeItemColor.evaluate(expressionResolver));
        if (divRoundedRectangleShape3 != null) {
            Intrinsics.checkNotNullExpressionValue(metrics, str);
            str2 = str;
            shapeMultiply$default = toIndicatorParamsShape$default(this, divRoundedRectangleShape3, metrics, expressionResolver, divIndicator.inactiveItemColor, 0.0f, 8, (Object) null);
            if (shapeMultiply$default == null) {
            }
            IndicatorParams.Shape shape9 = shapeMultiply$default;
            IndicatorParams.Animation animationConvert7 = divIndicatorBinder.convert(divIndicator.animation.evaluate(expressionResolver));
            itemsPlacementCompat = BaseDivViewExtensionsKt.getItemsPlacementCompat(divIndicator);
            if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Default) {
                DivFixedSize divFixedSize13 = ((DivIndicatorItemPlacement.Default) itemsPlacementCompat).getValue().spaceBetweenCenters;
                Intrinsics.checkNotNullExpressionValue(metrics, str2);
                stretch = new IndicatorParams.ItemPlacement.Default(BaseDivViewExtensionsKt.toPx(divFixedSize13, metrics, expressionResolver));
            } else {
                if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Stretch) {
                    throw new NoWhenBranchMatchedException();
                }
                DivIndicatorItemPlacement.Stretch stretch8 = (DivIndicatorItemPlacement.Stretch) itemsPlacementCompat;
                DivFixedSize divFixedSize14 = stretch8.getValue().itemSpacing;
                Intrinsics.checkNotNullExpressionValue(metrics, str2);
                float px7 = BaseDivViewExtensionsKt.toPx(divFixedSize14, metrics, expressionResolver);
                jLongValue = stretch8.getValue().maxVisibleItems.evaluate(expressionResolver).longValue();
                j = jLongValue >> 31;
                if (j != 0) {
                    i = (int) jLongValue;
                } else {
                    i = (int) jLongValue;
                }
                stretch = new IndicatorParams.ItemPlacement.Stretch(px7, i);
            }
            divPagerIndicatorView.setStyle(new IndicatorParams.Style(animationConvert7, shapeMultiply, shape2, shape9, stretch));
        }
        str2 = str;
        shapeMultiply$default = multiply$default(this, shape2, fDoubleValue2, null, 2, null);
        IndicatorParams.Shape shape10 = shapeMultiply$default;
        IndicatorParams.Animation animationConvert8 = divIndicatorBinder.convert(divIndicator.animation.evaluate(expressionResolver));
        itemsPlacementCompat = BaseDivViewExtensionsKt.getItemsPlacementCompat(divIndicator);
        if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Default) {
            DivFixedSize divFixedSize15 = ((DivIndicatorItemPlacement.Default) itemsPlacementCompat).getValue().spaceBetweenCenters;
            Intrinsics.checkNotNullExpressionValue(metrics, str2);
            stretch = new IndicatorParams.ItemPlacement.Default(BaseDivViewExtensionsKt.toPx(divFixedSize15, metrics, expressionResolver));
        } else {
            if (itemsPlacementCompat instanceof DivIndicatorItemPlacement.Stretch) {
                throw new NoWhenBranchMatchedException();
            }
            DivIndicatorItemPlacement.Stretch stretch9 = (DivIndicatorItemPlacement.Stretch) itemsPlacementCompat;
            DivFixedSize divFixedSize16 = stretch9.getValue().itemSpacing;
            Intrinsics.checkNotNullExpressionValue(metrics, str2);
            float px8 = BaseDivViewExtensionsKt.toPx(divFixedSize16, metrics, expressionResolver);
            jLongValue = stretch9.getValue().maxVisibleItems.evaluate(expressionResolver).longValue();
            j = jLongValue >> 31;
            if (j != 0) {
                i = (int) jLongValue;
            } else {
                i = (int) jLongValue;
            }
            stretch = new IndicatorParams.ItemPlacement.Stretch(px8, i);
        }
        divPagerIndicatorView.setStyle(new IndicatorParams.Style(animationConvert8, shapeMultiply, shape2, shape10, stretch));
    }

    public final IndicatorParams.Animation convert(DivIndicator.Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "<this>");
        if (animation == DivIndicator.Animation.WORM) {
            return IndicatorParams.Animation.WORM;
        }
        return animation == DivIndicator.Animation.SLIDER ? IndicatorParams.Animation.SLIDER : IndicatorParams.Animation.SCALE;
    }

    static /* synthetic */ IndicatorParams.Shape toIndicatorParamsShape$default(DivIndicatorBinder divIndicatorBinder, DivRoundedRectangleShape divRoundedRectangleShape, DisplayMetrics displayMetrics, ExpressionResolver expressionResolver, Expression expression, float f, int i, Object obj) {
        if ((i & 8) != 0) {
            f = 1.0f;
        }
        return divIndicatorBinder.toIndicatorParamsShape(divRoundedRectangleShape, displayMetrics, expressionResolver, (Expression<Integer>) expression, f);
    }

    private final IndicatorParams.Shape toIndicatorParamsShape(DivRoundedRectangleShape divRoundedRectangleShape, DisplayMetrics displayMetrics, ExpressionResolver expressionResolver, Expression<Integer> expression, float f) {
        DivSizeUnit divSizeUnitEvaluate;
        Expression<Integer> expression2;
        Expression<Double> expression3;
        Expression<DivSizeUnit> expression4;
        DivStroke divStroke = divRoundedRectangleShape.stroke;
        if (divStroke == null || (expression4 = divStroke.unit) == null || (divSizeUnitEvaluate = expression4.evaluate(expressionResolver)) == null) {
            divSizeUnitEvaluate = DivSizeUnit.DP;
        }
        DivStroke divStroke2 = divRoundedRectangleShape.stroke;
        Integer numEvaluate = null;
        Integer numValueOf = (divStroke2 == null || (expression3 = divStroke2.width) == null) ? null : Integer.valueOf(BaseDivViewExtensionsKt.unitToPx(Double.valueOf(expression3.evaluate(expressionResolver).doubleValue()), displayMetrics, divSizeUnitEvaluate));
        Expression<Integer> expression5 = divRoundedRectangleShape.backgroundColor;
        if (expression5 != null) {
            expression = expression5;
        }
        int iIntValue = expression.evaluate(expressionResolver).intValue();
        float pxF = BaseDivViewExtensionsKt.toPxF(divRoundedRectangleShape.itemWidth, displayMetrics, expressionResolver);
        float pxF2 = BaseDivViewExtensionsKt.toPxF(divRoundedRectangleShape.itemHeight, displayMetrics, expressionResolver);
        float pxF3 = BaseDivViewExtensionsKt.toPxF(divRoundedRectangleShape.cornerRadius, displayMetrics, expressionResolver);
        Float fValueOf = numValueOf != null ? Float.valueOf(numValueOf.intValue()) : null;
        DivStroke divStroke3 = divRoundedRectangleShape.stroke;
        if (divStroke3 != null && (expression2 = divStroke3.color) != null) {
            numEvaluate = expression2.evaluate(expressionResolver);
        }
        return BaseDivViewExtensionsKt.createRoundedRectangle(iIntValue, pxF, pxF2, pxF3, f, fValueOf, numEvaluate);
    }

    static /* synthetic */ IndicatorParams.Shape toIndicatorParamsShape$default(DivIndicatorBinder divIndicatorBinder, DivShape divShape, DisplayMetrics displayMetrics, ExpressionResolver expressionResolver, Expression expression, float f, int i, Object obj) {
        if ((i & 8) != 0) {
            f = 1.0f;
        }
        return divIndicatorBinder.toIndicatorParamsShape(divShape, displayMetrics, expressionResolver, (Expression<Integer>) expression, f);
    }

    private final IndicatorParams.Shape toIndicatorParamsShape(DivShape divShape, DisplayMetrics displayMetrics, ExpressionResolver expressionResolver, Expression<Integer> expression, float f) {
        if (divShape instanceof DivShape.RoundedRectangle) {
            return toIndicatorParamsShape(((DivShape.RoundedRectangle) divShape).getValue(), displayMetrics, expressionResolver, expression, f);
        }
        if (!(divShape instanceof DivShape.Circle)) {
            throw new NoWhenBranchMatchedException();
        }
        return BaseDivViewExtensionsKt.createCircle(expression.evaluate(expressionResolver).intValue(), BaseDivViewExtensionsKt.toPxF(((DivShape.Circle) divShape).getValue().radius, displayMetrics, expressionResolver), f);
    }

    static /* synthetic */ IndicatorParams.Shape multiply$default(DivIndicatorBinder divIndicatorBinder, IndicatorParams.Shape shape, float f, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return divIndicatorBinder.multiply(shape, f, num);
    }

    private final IndicatorParams.Shape multiply(IndicatorParams.Shape shape, float f, Integer num) {
        if (shape instanceof IndicatorParams.Shape.RoundedRect) {
            int iIntValue = num != null ? num.intValue() : shape.getColor();
            IndicatorParams.Shape.RoundedRect roundedRect = (IndicatorParams.Shape.RoundedRect) shape;
            return BaseDivViewExtensionsKt.createRoundedRectangle(iIntValue, roundedRect.getItemSize().getItemWidth(), roundedRect.getItemSize().getItemHeight(), roundedRect.getItemSize().getCornerRadius(), f, Float.valueOf(roundedRect.getStrokeWidth()), Integer.valueOf(roundedRect.getStrokeColor()));
        }
        if (shape instanceof IndicatorParams.Shape.Circle) {
            return BaseDivViewExtensionsKt.createCircle(num != null ? num.intValue() : shape.getColor(), ((IndicatorParams.Shape.Circle) shape).getItemSize().getRadius(), f);
        }
        throw new NoWhenBranchMatchedException();
    }
}
