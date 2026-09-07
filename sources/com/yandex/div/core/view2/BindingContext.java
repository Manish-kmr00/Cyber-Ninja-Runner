package com.yandex.div.core.view2;

import com.yandex.div.core.expression.local.RuntimeStore;
import com.yandex.div.json.expressions.ExpressionResolver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BindingContext.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005J\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/view2/BindingContext;", "", "divView", "Lcom/yandex/div/core/view2/Div2View;", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "runtimeStore", "Lcom/yandex/div/core/expression/local/RuntimeStore;", "(Lcom/yandex/div/core/view2/Div2View;Lcom/yandex/div/json/expressions/ExpressionResolver;Lcom/yandex/div/core/expression/local/RuntimeStore;)V", "getDivView", "()Lcom/yandex/div/core/view2/Div2View;", "getExpressionResolver", "()Lcom/yandex/div/json/expressions/ExpressionResolver;", "getRuntimeStore", "()Lcom/yandex/div/core/expression/local/RuntimeStore;", "getFor", "resolver", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BindingContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Div2View divView;
    private final ExpressionResolver expressionResolver;
    private final RuntimeStore runtimeStore;

    public /* synthetic */ BindingContext(Div2View div2View, ExpressionResolver expressionResolver, RuntimeStore runtimeStore, DefaultConstructorMarker defaultConstructorMarker) {
        this(div2View, expressionResolver, runtimeStore);
    }

    private BindingContext(Div2View div2View, ExpressionResolver expressionResolver, RuntimeStore runtimeStore) {
        this.divView = div2View;
        this.expressionResolver = expressionResolver;
        this.runtimeStore = runtimeStore;
    }

    public final Div2View getDivView() {
        return this.divView;
    }

    public final ExpressionResolver getExpressionResolver() {
        return this.expressionResolver;
    }

    public final RuntimeStore getRuntimeStore() {
        return this.runtimeStore;
    }

    public final BindingContext getFor(ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return Intrinsics.areEqual(this.expressionResolver, resolver) ? this : new BindingContext(this.divView, resolver, this.runtimeStore);
    }

    public final BindingContext getFor(ExpressionResolver resolver, RuntimeStore runtimeStore) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return Intrinsics.areEqual(this.expressionResolver, resolver) ? this : new BindingContext(this.divView, resolver, runtimeStore);
    }

    /* JADX INFO: compiled from: BindingContext.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/view2/BindingContext$Companion;", "", "()V", "createEmpty", "Lcom/yandex/div/core/view2/BindingContext;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BindingContext createEmpty(Div2View divView) {
            Intrinsics.checkNotNullParameter(divView, "divView");
            return new BindingContext(divView, ExpressionResolver.EMPTY, null, 0 == true ? 1 : 0);
        }
    }
}
