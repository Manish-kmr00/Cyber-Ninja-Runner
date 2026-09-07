package com.yandex.div.core.view2.divs.tabs;

import android.util.DisplayMetrics;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.font.DivTypefaceType;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.internal.widget.tabs.TabView;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivEdgeInsets;
import com.yandex.div2.DivFontWeight;
import com.yandex.div2.DivSize;
import com.yandex.div2.DivTabs;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTabsBinder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00010\bH\u0002\u001aG\u0010\n\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\bH\u0002\u001a$\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002\u001a \u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u001b"}, d2 = {"observe", "", "Lcom/yandex/div2/DivEdgeInsets;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "subscriber", "Lcom/yandex/div/internal/core/ExpressionSubscriber;", "observer", "Lkotlin/Function1;", "", "observeFixedHeightChange", "", "Lcom/yandex/div2/DivTabs$Item;", "Lkotlin/ParameterName;", "name", "_", "observeStyle", "Lcom/yandex/div/internal/widget/tabs/TabView;", "style", "Lcom/yandex/div2/DivTabs$TabTitleStyle;", "toTypefaceType", "Lcom/yandex/div/core/font/DivTypefaceType;", "Lcom/yandex/div2/DivFontWeight;", "tryReuse", "Lcom/yandex/div/core/view2/divs/tabs/DivTabsAdapter;", "div", "Lcom/yandex/div2/DivTabs;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivTabsBinderKt {

    /* JADX INFO: compiled from: DivTabsBinder.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivFontWeight.values().length];
            try {
                iArr[DivFontWeight.MEDIUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivFontWeight.REGULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivFontWeight.LIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DivFontWeight.BOLD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DivTabsAdapter tryReuse(DivTabsAdapter divTabsAdapter, DivTabs divTabs, ExpressionResolver expressionResolver) {
        if (divTabsAdapter != null && divTabsAdapter.getIsDynamicHeight() == divTabs.dynamicHeight.evaluate(expressionResolver).booleanValue()) {
            return divTabsAdapter;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeFixedHeightChange(List<DivTabs.Item> list, ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber, Function1<Object, Unit> function1) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            DivSize height = ((DivTabs.Item) it.next()).div.value().getHeight();
            if (height instanceof DivSize.Fixed) {
                DivSize.Fixed fixed = (DivSize.Fixed) height;
                expressionSubscriber.addSubscription(fixed.getValue().unit.observe(expressionResolver, function1));
                expressionSubscriber.addSubscription(fixed.getValue().value.observe(expressionResolver, function1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observe(DivEdgeInsets divEdgeInsets, ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber, Function1<Object, Unit> function1) {
        expressionSubscriber.addSubscription(divEdgeInsets.left.observe(expressionResolver, function1));
        expressionSubscriber.addSubscription(divEdgeInsets.right.observe(expressionResolver, function1));
        expressionSubscriber.addSubscription(divEdgeInsets.top.observe(expressionResolver, function1));
        expressionSubscriber.addSubscription(divEdgeInsets.bottom.observe(expressionResolver, function1));
        function1.invoke(null);
    }

    public static final void observeStyle(final TabView tabView, final DivTabs.TabTitleStyle style, final ExpressionResolver resolver, ExpressionSubscriber subscriber) {
        Disposable disposableObserve;
        Intrinsics.checkNotNullParameter(tabView, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinderKt$observeStyle$applyStyle$1
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
                int i;
                long jLongValue = style.fontSize.evaluate(resolver).longValue();
                long j = jLongValue >> 31;
                if (j == 0 || j == -1) {
                    i = (int) jLongValue;
                } else {
                    KAssert kAssert = KAssert.INSTANCE;
                    if (Assert.isEnabled()) {
                        Assert.fail("Unable convert '" + jLongValue + "' to Int");
                    }
                    i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                BaseDivViewExtensionsKt.applyFontSize(tabView, i, style.fontSizeUnit.evaluate(resolver));
                BaseDivViewExtensionsKt.applyLetterSpacing(tabView, style.letterSpacing.evaluate(resolver).doubleValue(), i);
                TabView tabView2 = tabView;
                Expression<Long> expression = style.lineHeight;
                BaseDivViewExtensionsKt.applyLineHeight(tabView2, expression != null ? expression.evaluate(resolver) : null, style.fontSizeUnit.evaluate(resolver));
            }
        };
        subscriber.addSubscription(style.fontSize.observe(resolver, function1));
        subscriber.addSubscription(style.fontSizeUnit.observe(resolver, function1));
        Expression<Long> expression = style.lineHeight;
        if (expression != null && (disposableObserve = expression.observe(resolver, function1)) != null) {
            subscriber.addSubscription(disposableObserve);
        }
        function1.invoke(null);
        final DivEdgeInsets divEdgeInsets = style.paddings;
        final DisplayMetrics displayMetrics = tabView.getResources().getDisplayMetrics();
        Function1<? super Long, Unit> function2 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinderKt$observeStyle$applyTabPaddings$1
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
                if (divEdgeInsets.start != null || divEdgeInsets.end != null) {
                    TabView tabView2 = tabView;
                    Expression<Long> expression2 = divEdgeInsets.start;
                    Long lEvaluate = expression2 != null ? expression2.evaluate(resolver) : null;
                    DisplayMetrics metrics = displayMetrics;
                    Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                    int iDpToPx = BaseDivViewExtensionsKt.dpToPx(lEvaluate, metrics);
                    Long lEvaluate2 = divEdgeInsets.top.evaluate(resolver);
                    DisplayMetrics metrics2 = displayMetrics;
                    Intrinsics.checkNotNullExpressionValue(metrics2, "metrics");
                    int iDpToPx2 = BaseDivViewExtensionsKt.dpToPx(lEvaluate2, metrics2);
                    Expression<Long> expression3 = divEdgeInsets.end;
                    Long lEvaluate3 = expression3 != null ? expression3.evaluate(resolver) : null;
                    DisplayMetrics metrics3 = displayMetrics;
                    Intrinsics.checkNotNullExpressionValue(metrics3, "metrics");
                    int iDpToPx3 = BaseDivViewExtensionsKt.dpToPx(lEvaluate3, metrics3);
                    Long lEvaluate4 = divEdgeInsets.bottom.evaluate(resolver);
                    DisplayMetrics metrics4 = displayMetrics;
                    Intrinsics.checkNotNullExpressionValue(metrics4, "metrics");
                    tabView2.setTabPadding(iDpToPx, iDpToPx2, iDpToPx3, BaseDivViewExtensionsKt.dpToPx(lEvaluate4, metrics4));
                    return;
                }
                TabView tabView3 = tabView;
                Long lEvaluate5 = divEdgeInsets.left.evaluate(resolver);
                DisplayMetrics metrics5 = displayMetrics;
                Intrinsics.checkNotNullExpressionValue(metrics5, "metrics");
                int iDpToPx4 = BaseDivViewExtensionsKt.dpToPx(lEvaluate5, metrics5);
                Long lEvaluate6 = divEdgeInsets.top.evaluate(resolver);
                DisplayMetrics metrics6 = displayMetrics;
                Intrinsics.checkNotNullExpressionValue(metrics6, "metrics");
                int iDpToPx5 = BaseDivViewExtensionsKt.dpToPx(lEvaluate6, metrics6);
                Long lEvaluate7 = divEdgeInsets.right.evaluate(resolver);
                DisplayMetrics metrics7 = displayMetrics;
                Intrinsics.checkNotNullExpressionValue(metrics7, "metrics");
                int iDpToPx6 = BaseDivViewExtensionsKt.dpToPx(lEvaluate7, metrics7);
                Long lEvaluate8 = divEdgeInsets.bottom.evaluate(resolver);
                DisplayMetrics metrics8 = displayMetrics;
                Intrinsics.checkNotNullExpressionValue(metrics8, "metrics");
                tabView3.setTabPadding(iDpToPx4, iDpToPx5, iDpToPx6, BaseDivViewExtensionsKt.dpToPx(lEvaluate8, metrics8));
            }
        };
        subscriber.addSubscription(divEdgeInsets.top.observe(resolver, function2));
        subscriber.addSubscription(divEdgeInsets.bottom.observe(resolver, function2));
        if (divEdgeInsets.start != null || divEdgeInsets.end != null) {
            Expression<Long> expression2 = divEdgeInsets.start;
            subscriber.addSubscription(expression2 != null ? expression2.observe(resolver, function2) : null);
            Expression<Long> expression3 = divEdgeInsets.end;
            subscriber.addSubscription(expression3 != null ? expression3.observe(resolver, function2) : null);
        } else {
            subscriber.addSubscription(divEdgeInsets.left.observe(resolver, function2));
            subscriber.addSubscription(divEdgeInsets.right.observe(resolver, function2));
        }
        function2.invoke(null);
        Expression<DivFontWeight> expression4 = style.inactiveFontWeight;
        if (expression4 == null) {
            expression4 = style.fontWeight;
        }
        observeStyle$addToSubscriber(expression4, subscriber, resolver, new Function1<DivFontWeight, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinderKt.observeStyle.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DivFontWeight divFontWeight) {
                invoke2(divFontWeight);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DivFontWeight divFontWeight) {
                Intrinsics.checkNotNullParameter(divFontWeight, "divFontWeight");
                tabView.setInactiveTypefaceType(DivTabsBinderKt.toTypefaceType(divFontWeight));
            }
        });
        Expression<DivFontWeight> expression5 = style.activeFontWeight;
        if (expression5 == null) {
            expression5 = style.fontWeight;
        }
        observeStyle$addToSubscriber(expression5, subscriber, resolver, new Function1<DivFontWeight, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinderKt.observeStyle.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DivFontWeight divFontWeight) {
                invoke2(divFontWeight);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DivFontWeight divFontWeight) {
                Intrinsics.checkNotNullParameter(divFontWeight, "divFontWeight");
                tabView.setActiveTypefaceType(DivTabsBinderKt.toTypefaceType(divFontWeight));
            }
        });
    }

    private static final void observeStyle$addToSubscriber(Expression<DivFontWeight> expression, ExpressionSubscriber expressionSubscriber, ExpressionResolver expressionResolver, Function1<? super DivFontWeight, Unit> function1) {
        expressionSubscriber.addSubscription(expression.observeAndGet(expressionResolver, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DivTypefaceType toTypefaceType(DivFontWeight divFontWeight) {
        int i = WhenMappings.$EnumSwitchMapping$0[divFontWeight.ordinal()];
        if (i == 1) {
            return DivTypefaceType.MEDIUM;
        }
        if (i == 2) {
            return DivTypefaceType.REGULAR;
        }
        if (i == 3) {
            return DivTypefaceType.LIGHT;
        }
        if (i == 4) {
            return DivTypefaceType.BOLD;
        }
        throw new NoWhenBranchMatchedException();
    }
}
