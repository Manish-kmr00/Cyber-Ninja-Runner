package com.yandex.div.core.view2.divs;

import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.downloader.DivPatchManager;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.util.ReleasablesKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.divs.widgets.DivGridLayout;
import com.yandex.div.core.view2.reuse.util.RebindUtilsKt;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.internal.widget.DivLayoutParams;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivAlignmentHorizontal;
import com.yandex.div2.DivAlignmentVertical;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivGrid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivGridBinder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B3\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0002J$\u0010\u001f\u001a\u00020\u000f*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0002J\u001c\u0010#\u001a\u00020\u000f*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J*\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%*\u00020'2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0002J$\u0010*\u001a\u00020\u000f*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0002J0\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%*\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00182\f\u0010,\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J0\u0010-\u001a\u00020\u000f*\u00020\u00032\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0!2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010!2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivGridBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivGrid;", "Lcom/yandex/div/core/view2/divs/widgets/DivGridLayout;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "divPatchManager", "Lcom/yandex/div/core/downloader/DivPatchManager;", "divBinder", "Ljavax/inject/Provider;", "Lcom/yandex/div/core/view2/DivBinder;", "divViewCreator", "Lcom/yandex/div/core/view2/DivViewCreator;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/downloader/DivPatchManager;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "bindLayoutParams", "", "childView", "Landroid/view/View;", "childDiv", "Lcom/yandex/div2/DivBase;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "bindView", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "path", "Lcom/yandex/div/core/state/DivStatePath;", "setDataWithoutBinding", "bindingContext", "applyColumnSpan", "spanExpr", "Lcom/yandex/div/json/expressions/Expression;", "", "applyGridLayoutParams", "applyPatchToChild", "", "Lcom/yandex/div2/Div;", "Landroid/view/ViewGroup;", "childIndex", "", "applyRowSpan", "dispatchBinding", FirebaseAnalytics.Param.ITEMS, "observeContentAlignment", "horizontalAlignment", "Lcom/yandex/div2/DivAlignmentHorizontal;", "verticalAlignment", "Lcom/yandex/div2/DivAlignmentVertical;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivGridBinder implements DivViewBinder<DivGrid, DivGridLayout> {
    private final DivBaseBinder baseBinder;
    private final Provider<DivBinder> divBinder;
    private final DivPatchManager divPatchManager;
    private final Provider<DivViewCreator> divViewCreator;

    @Inject
    public DivGridBinder(DivBaseBinder baseBinder, DivPatchManager divPatchManager, Provider<DivBinder> divBinder, Provider<DivViewCreator> divViewCreator) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(divPatchManager, "divPatchManager");
        Intrinsics.checkNotNullParameter(divBinder, "divBinder");
        Intrinsics.checkNotNullParameter(divViewCreator, "divViewCreator");
        this.baseBinder = baseBinder;
        this.divPatchManager = divPatchManager;
        this.divBinder = divBinder;
        this.divViewCreator = divViewCreator;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, final DivGridLayout view, DivGrid div, DivStatePath path) {
        List<Div> list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        DivGrid div2 = view.getDiv();
        Div2View divView = context.getDivView();
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        view.setReleaseViewVisitor$div_release(divView.getReleaseViewVisitor$div_release());
        DivGridLayout divGridLayout = view;
        this.baseBinder.bindView(context, divGridLayout, div, div2);
        BaseDivViewExtensionsKt.applyDivActions(divGridLayout, context, div.action, div.actions, div.longtapActions, div.doubletapActions, div.hoverStartActions, div.hoverEndActions, div.pressStartActions, div.pressEndActions, div.actionAnimation, div.getAccessibility());
        view.addSubscription(div.columnCount.observeAndGet(expressionResolver, new Function1<Long, Unit>() { // from class: com.yandex.div.core.view2.divs.DivGridBinder.bindView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                int i;
                DivGridLayout divGridLayout2 = view;
                long j2 = j >> 31;
                if (j2 == 0 || j2 == -1) {
                    i = (int) j;
                } else {
                    KAssert kAssert = KAssert.INSTANCE;
                    if (Assert.isEnabled()) {
                        Assert.fail("Unable convert '" + j + "' to Int");
                    }
                    i = j > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                divGridLayout2.setColumnCount(i);
            }
        }));
        observeContentAlignment(view, div.contentAlignmentHorizontal, div.contentAlignmentVertical, expressionResolver);
        List<Div> nonNullItems = DivCollectionExtensionsKt.getNonNullItems(div);
        DivGridLayout divGridLayout2 = view;
        RebindUtilsKt.tryRebindPlainContainerChildren(divGridLayout2, divView, DivCollectionExtensionsKt.toDivItemBuilderResult(nonNullItems, expressionResolver), this.divViewCreator);
        BaseDivViewExtensionsKt.trackVisibilityActions(divGridLayout2, divView, DivCollectionExtensionsKt.toDivItemBuilderResult(dispatchBinding(view, context, nonNullItems, path), expressionResolver), (div2 == null || (list = div2.items) == null) ? null : DivCollectionExtensionsKt.toDivItemBuilderResult(list, expressionResolver));
    }

    private final void observeContentAlignment(final DivGridLayout divGridLayout, final Expression<DivAlignmentHorizontal> expression, final Expression<DivAlignmentVertical> expression2, final ExpressionResolver expressionResolver) {
        divGridLayout.setGravity(BaseDivViewExtensionsKt.evaluateGravity(expression.evaluate(expressionResolver), expression2.evaluate(expressionResolver)));
        Function1<? super DivAlignmentHorizontal, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivGridBinder$observeContentAlignment$callback$1
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
                divGridLayout.setGravity(BaseDivViewExtensionsKt.evaluateGravity(expression.evaluate(expressionResolver), expression2.evaluate(expressionResolver)));
            }
        };
        divGridLayout.addSubscription(expression.observe(expressionResolver, function1));
        divGridLayout.addSubscription(expression2.observe(expressionResolver, function1));
    }

    private final List<Div> dispatchBinding(DivGridLayout divGridLayout, BindingContext bindingContext, List<? extends Div> list, DivStatePath divStatePath) {
        Div2View divView = bindingContext.getDivView();
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int size = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            List<Div> listApplyPatchToChild = applyPatchToChild(divGridLayout, bindingContext, (Div) obj, i2 + size);
            size += listApplyPatchToChild.size() - 1;
            CollectionsKt.addAll(arrayList, listApplyPatchToChild);
            i2 = i3;
        }
        ArrayList arrayList2 = arrayList;
        for (Object obj2 : arrayList2) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Div div = (Div) obj2;
            View childView = divGridLayout.getChildAt(i);
            DivBase divBaseValue = div.value();
            DivStatePath divStatePathResolvePath = BaseDivViewExtensionsKt.resolvePath(divBaseValue, i, divStatePath);
            childView.setLayoutParams(new DivLayoutParams(-2, -2));
            DivBinder divBinder = this.divBinder.get();
            Intrinsics.checkNotNullExpressionValue(childView, "childView");
            divBinder.bind(bindingContext, childView, div, divStatePathResolvePath);
            bindLayoutParams(childView, divBaseValue, expressionResolver);
            if (BaseDivViewExtensionsKt.getHasSightActions(divBaseValue)) {
                divView.bindViewToDiv$div_release(childView, div);
            } else {
                divView.unbindViewFromDiv$div_release(childView);
            }
            i = i4;
        }
        return arrayList2;
    }

    private final List<Div> applyPatchToChild(ViewGroup viewGroup, BindingContext bindingContext, Div div, int i) {
        Div2View divView = bindingContext.getDivView();
        String id = div.value().getId();
        if (id != null && !divView.getComplexRebindInProgress$div_release()) {
            Map<Div, View> mapCreateViewsForId = this.divPatchManager.createViewsForId(bindingContext, id);
            if (mapCreateViewsForId == null) {
                return CollectionsKt.listOf(div);
            }
            viewGroup.removeViewAt(i);
            Iterator<Map.Entry<Div, View>> it = mapCreateViewsForId.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                viewGroup.addView(it.next().getValue(), i2 + i, new DivLayoutParams(-2, -2));
                i2++;
            }
            return CollectionsKt.toList(mapCreateViewsForId.keySet());
        }
        return CollectionsKt.listOf(div);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void bindLayoutParams(final View childView, final DivBase childDiv, final ExpressionResolver resolver) {
        this.baseBinder.bindLayoutParams$div_release(childView, childDiv, null, resolver, ReleasablesKt.getExpressionSubscriber(childView));
        applyGridLayoutParams(childView, resolver, childDiv);
        if (childView instanceof ExpressionSubscriber) {
            Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivGridBinder$bindLayoutParams$callback$1
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
                    this.this$0.applyGridLayoutParams(childView, resolver, childDiv);
                }
            };
            ExpressionSubscriber expressionSubscriber = (ExpressionSubscriber) childView;
            Expression<Long> columnSpan = childDiv.getColumnSpan();
            expressionSubscriber.addSubscription(columnSpan != null ? columnSpan.observe(resolver, function1) : null);
            Expression<Long> rowSpan = childDiv.getRowSpan();
            expressionSubscriber.addSubscription(rowSpan != null ? rowSpan.observe(resolver, function1) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyGridLayoutParams(View view, ExpressionResolver expressionResolver, DivBase divBase) {
        applyColumnSpan(view, expressionResolver, divBase.getColumnSpan());
        applyRowSpan(view, expressionResolver, divBase.getRowSpan());
    }

    private final void applyColumnSpan(View view, ExpressionResolver expressionResolver, Expression<Long> expression) {
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        DivLayoutParams divLayoutParams = layoutParams instanceof DivLayoutParams ? (DivLayoutParams) layoutParams : null;
        if (divLayoutParams == null) {
            return;
        }
        if (expression != null) {
            long jLongValue = expression.evaluate(expressionResolver).longValue();
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
        } else {
            i = 1;
        }
        if (divLayoutParams.getColumnSpan() != i) {
            divLayoutParams.setColumnSpan(i);
            view.requestLayout();
        }
    }

    private final void applyRowSpan(View view, ExpressionResolver expressionResolver, Expression<Long> expression) {
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        DivLayoutParams divLayoutParams = layoutParams instanceof DivLayoutParams ? (DivLayoutParams) layoutParams : null;
        if (divLayoutParams == null) {
            return;
        }
        if (expression != null) {
            long jLongValue = expression.evaluate(expressionResolver).longValue();
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
        } else {
            i = 1;
        }
        if (divLayoutParams.getRowSpan() != i) {
            divLayoutParams.setRowSpan(i);
            view.requestLayout();
        }
    }

    public final void setDataWithoutBinding(BindingContext bindingContext, DivGridLayout view, DivGrid div) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        view.setDiv(div);
        List<Div> nonNullItems = DivCollectionExtensionsKt.getNonNullItems(div);
        int size = nonNullItems.size();
        for (int i = 0; i < size; i++) {
            View childView = view.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childView, "childView");
            BindingContext bindingContext2 = BaseDivViewExtensionsKt.getBindingContext(childView);
            if (bindingContext2 == null) {
                bindingContext2 = bindingContext;
            }
            this.divBinder.get().setDataWithoutBinding(bindingContext2, childView, nonNullItems.get(i));
        }
    }
}
