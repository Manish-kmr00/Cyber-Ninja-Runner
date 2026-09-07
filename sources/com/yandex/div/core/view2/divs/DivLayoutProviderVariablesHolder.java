package com.yandex.div.core.view2.divs;

import com.android.billingclient.api.BillingClient;
import com.yandex.div.core.Disposable;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.internal.core.DivVisitor;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivData;
import com.yandex.div2.DivFixedSize;
import com.yandex.div2.DivSize;
import com.yandex.div2.DivState;
import com.yandex.div2.DivTabs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivLayoutProviderVariablesHolder.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0016\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0014\u0010\u001e\u001a\u00020\u0002*\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010 \u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006!"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivLayoutProviderVariablesHolder;", "Lcom/yandex/div/internal/core/DivVisitor;", "", "Lcom/yandex/div/internal/core/ExpressionSubscriber;", "()V", "changedVariables", "", "", BillingClient.FeatureType.SUBSCRIPTIONS, "Lcom/yandex/div/core/Disposable;", "getSubscriptions", "()Ljava/util/List;", "clear", "contains", "", "variable", "defaultVisit", "data", "Lcom/yandex/div2/Div;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "observeDivData", "Lcom/yandex/div2/DivData;", "visit", "Lcom/yandex/div2/Div$Container;", "Lcom/yandex/div2/Div$Gallery;", "Lcom/yandex/div2/Div$Grid;", "Lcom/yandex/div2/Div$Pager;", "Lcom/yandex/div2/Div$State;", "Lcom/yandex/div2/Div$Tabs;", "observe", "Lcom/yandex/div2/DivSize;", "observeSize", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivLayoutProviderVariablesHolder extends DivVisitor<Unit> implements ExpressionSubscriber {
    private final List<String> changedVariables = new ArrayList();
    private final List<Disposable> subscriptions = new ArrayList();

    @Override // com.yandex.div.internal.core.DivVisitor
    public /* bridge */ /* synthetic */ Unit defaultVisit(Div div, ExpressionResolver expressionResolver) {
        defaultVisit2(div, expressionResolver);
        return Unit.INSTANCE;
    }

    @Override // com.yandex.div.internal.core.DivVisitor
    public /* bridge */ /* synthetic */ Unit visit(Div.Container container, ExpressionResolver expressionResolver) {
        visit2(container, expressionResolver);
        return Unit.INSTANCE;
    }

    @Override // com.yandex.div.internal.core.DivVisitor
    public /* bridge */ /* synthetic */ Unit visit(Div.Gallery gallery, ExpressionResolver expressionResolver) {
        visit2(gallery, expressionResolver);
        return Unit.INSTANCE;
    }

    @Override // com.yandex.div.internal.core.DivVisitor
    public /* bridge */ /* synthetic */ Unit visit(Div.Grid grid, ExpressionResolver expressionResolver) {
        visit2(grid, expressionResolver);
        return Unit.INSTANCE;
    }

    @Override // com.yandex.div.internal.core.DivVisitor
    public /* bridge */ /* synthetic */ Unit visit(Div.Pager pager, ExpressionResolver expressionResolver) {
        visit2(pager, expressionResolver);
        return Unit.INSTANCE;
    }

    @Override // com.yandex.div.internal.core.DivVisitor
    public /* bridge */ /* synthetic */ Unit visit(Div.State state, ExpressionResolver expressionResolver) {
        visit2(state, expressionResolver);
        return Unit.INSTANCE;
    }

    @Override // com.yandex.div.internal.core.DivVisitor
    public /* bridge */ /* synthetic */ Unit visit(Div.Tabs tabs, ExpressionResolver expressionResolver) {
        visit2(tabs, expressionResolver);
        return Unit.INSTANCE;
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber
    public List<Disposable> getSubscriptions() {
        return this.subscriptions;
    }

    public final boolean contains(String variable) {
        Intrinsics.checkNotNullParameter(variable, "variable");
        return this.changedVariables.contains(variable);
    }

    public final void clear() {
        this.changedVariables.clear();
    }

    public final void observeDivData(DivData data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Iterator<T> it = data.states.iterator();
        while (it.hasNext()) {
            visit(((DivData.State) it.next()).div, resolver);
        }
    }

    /* JADX INFO: renamed from: defaultVisit, reason: avoid collision after fix types in other method */
    protected void defaultVisit2(Div data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        observeSize(data, resolver);
    }

    /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
    protected void visit2(Div.Container data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        defaultVisit2((Div) data, resolver);
        for (DivItemBuilderResult divItemBuilderResult : DivCollectionExtensionsKt.buildItems(data.getValue(), resolver)) {
            visit(divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver());
        }
    }

    /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
    protected void visit2(Div.Grid data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        defaultVisit2((Div) data, resolver);
        Iterator<T> it = DivCollectionExtensionsKt.getNonNullItems(data.getValue()).iterator();
        while (it.hasNext()) {
            visit((Div) it.next(), resolver);
        }
    }

    /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
    protected void visit2(Div.Gallery data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        defaultVisit2((Div) data, resolver);
        for (DivItemBuilderResult divItemBuilderResult : DivCollectionExtensionsKt.buildItems(data.getValue(), resolver)) {
            visit(divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver());
        }
    }

    /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
    protected void visit2(Div.Pager data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        defaultVisit2((Div) data, resolver);
        for (DivItemBuilderResult divItemBuilderResult : DivCollectionExtensionsKt.buildItems(data.getValue(), resolver)) {
            visit(divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver());
        }
    }

    /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
    protected void visit2(Div.Tabs data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        defaultVisit2((Div) data, resolver);
        Iterator<T> it = data.getValue().items.iterator();
        while (it.hasNext()) {
            visit(((DivTabs.Item) it.next()).div, resolver);
        }
    }

    /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
    protected void visit2(Div.State data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        defaultVisit2((Div) data, resolver);
        Iterator<T> it = data.getValue().states.iterator();
        while (it.hasNext()) {
            Div div = ((DivState.State) it.next()).div;
            if (div != null) {
                visit(div, resolver);
            }
        }
    }

    private final void observeSize(Div div, ExpressionResolver expressionResolver) {
        DivBase divBaseValue = div.value();
        observe(divBaseValue.getWidth(), expressionResolver);
        observe(divBaseValue.getHeight(), expressionResolver);
    }

    private final void observe(DivSize divSize, ExpressionResolver expressionResolver) {
        Object objValue = divSize.value();
        DivFixedSize divFixedSize = objValue instanceof DivFixedSize ? (DivFixedSize) objValue : null;
        if (divFixedSize == null) {
            return;
        }
        Expression<Long> expression = divFixedSize.value;
        final Expression.MutableExpression mutableExpression = expression instanceof Expression.MutableExpression ? (Expression.MutableExpression) expression : null;
        if (mutableExpression == null) {
            return;
        }
        addSubscription(mutableExpression.observe(expressionResolver, new Function1<Long, Unit>() { // from class: com.yandex.div.core.view2.divs.DivLayoutProviderVariablesHolder.observe.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                DivLayoutProviderVariablesHolder.this.changedVariables.addAll(mutableExpression.getVariablesName());
            }
        }));
    }
}
