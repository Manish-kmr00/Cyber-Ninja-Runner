package com.yandex.div.core.expression.local;

import com.yandex.div.core.expression.ExpressionResolverImpl;
import com.yandex.div.core.expression.ExpressionsRuntime;
import com.yandex.div.core.expression.FunctionProviderDecorator;
import com.yandex.div.core.expression.variables.VariableController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RuntimeStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/yandex/div/core/expression/ExpressionResolverImpl$OnCreateCallback;", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class RuntimeStore$onCreateCallback$2 extends Lambda implements Function0<ExpressionResolverImpl.OnCreateCallback> {
    final /* synthetic */ RuntimeStore this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RuntimeStore$onCreateCallback$2(RuntimeStore runtimeStore) {
        super(0);
        this.this$0 = runtimeStore;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ExpressionResolverImpl.OnCreateCallback invoke() {
        final RuntimeStore runtimeStore = this.this$0;
        return new ExpressionResolverImpl.OnCreateCallback() { // from class: com.yandex.div.core.expression.local.RuntimeStore$onCreateCallback$2$$ExternalSyntheticLambda0
            @Override // com.yandex.div.core.expression.ExpressionResolverImpl.OnCreateCallback
            public final void onCreate(ExpressionResolverImpl expressionResolverImpl, VariableController variableController, FunctionProviderDecorator functionProviderDecorator) {
                RuntimeStore$onCreateCallback$2.invoke$lambda$1(runtimeStore, expressionResolverImpl, variableController, functionProviderDecorator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(RuntimeStore this$0, ExpressionResolverImpl resolver, VariableController variableController, FunctionProviderDecorator functionProvider) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(variableController, "variableController");
        Intrinsics.checkNotNullParameter(functionProvider, "functionProvider");
        this$0.putRuntime$div_release(new ExpressionsRuntime(resolver, variableController, null, functionProvider, this$0));
    }
}
