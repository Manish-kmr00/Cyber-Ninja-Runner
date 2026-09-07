package com.yandex.div.core.expression;

import com.yandex.div.core.DivViewFacade;
import com.yandex.div.core.expression.local.RuntimeStore;
import com.yandex.div.core.expression.triggers.TriggersController;
import com.yandex.div.core.expression.variables.VariableController;
import com.yandex.div.internal.Assert;
import com.yandex.div.json.expressions.ExpressionResolver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpressionsRuntime.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\r\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u0006\u0010 \u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lcom/yandex/div/core/expression/ExpressionsRuntime;", "", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "variableController", "Lcom/yandex/div/core/expression/variables/VariableController;", "triggersController", "Lcom/yandex/div/core/expression/triggers/TriggersController;", "functionProvider", "Lcom/yandex/div/core/expression/FunctionProviderDecorator;", "runtimeStore", "Lcom/yandex/div/core/expression/local/RuntimeStore;", "(Lcom/yandex/div/json/expressions/ExpressionResolver;Lcom/yandex/div/core/expression/variables/VariableController;Lcom/yandex/div/core/expression/triggers/TriggersController;Lcom/yandex/div/core/expression/FunctionProviderDecorator;Lcom/yandex/div/core/expression/local/RuntimeStore;)V", "getExpressionResolver", "()Lcom/yandex/div/json/expressions/ExpressionResolver;", "expressionResolverImpl", "Lcom/yandex/div/core/expression/ExpressionResolverImpl;", "getExpressionResolverImpl", "()Lcom/yandex/div/core/expression/ExpressionResolverImpl;", "getFunctionProvider", "()Lcom/yandex/div/core/expression/FunctionProviderDecorator;", "getRuntimeStore", "()Lcom/yandex/div/core/expression/local/RuntimeStore;", "getTriggersController", "()Lcom/yandex/div/core/expression/triggers/TriggersController;", "unsubscribed", "", "getVariableController", "()Lcom/yandex/div/core/expression/variables/VariableController;", "cleanup", "", "cleanup$div_release", "clearBinding", "onAttachedToWindow", "view", "Lcom/yandex/div/core/DivViewFacade;", "updateSubscriptions", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExpressionsRuntime {
    private final ExpressionResolver expressionResolver;
    private final FunctionProviderDecorator functionProvider;
    private final RuntimeStore runtimeStore;
    private final TriggersController triggersController;
    private boolean unsubscribed;
    private final VariableController variableController;

    public ExpressionsRuntime(ExpressionResolver expressionResolver, VariableController variableController, TriggersController triggersController, FunctionProviderDecorator functionProvider, RuntimeStore runtimeStore) {
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(variableController, "variableController");
        Intrinsics.checkNotNullParameter(functionProvider, "functionProvider");
        Intrinsics.checkNotNullParameter(runtimeStore, "runtimeStore");
        this.expressionResolver = expressionResolver;
        this.variableController = variableController;
        this.triggersController = triggersController;
        this.functionProvider = functionProvider;
        this.runtimeStore = runtimeStore;
        this.unsubscribed = true;
    }

    public /* synthetic */ ExpressionsRuntime(ExpressionResolver expressionResolver, VariableController variableController, TriggersController triggersController, FunctionProviderDecorator functionProviderDecorator, RuntimeStore runtimeStore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(expressionResolver, variableController, (i & 4) != 0 ? null : triggersController, functionProviderDecorator, runtimeStore);
    }

    public final ExpressionResolver getExpressionResolver() {
        return this.expressionResolver;
    }

    public final VariableController getVariableController() {
        return this.variableController;
    }

    public final TriggersController getTriggersController() {
        return this.triggersController;
    }

    public final FunctionProviderDecorator getFunctionProvider() {
        return this.functionProvider;
    }

    public final RuntimeStore getRuntimeStore() {
        return this.runtimeStore;
    }

    private final ExpressionResolverImpl getExpressionResolverImpl() {
        ExpressionResolver expressionResolver = this.expressionResolver;
        if (expressionResolver instanceof ExpressionResolverImpl) {
            return (ExpressionResolverImpl) expressionResolver;
        }
        return null;
    }

    public final void clearBinding() {
        TriggersController triggersController = this.triggersController;
        if (triggersController != null) {
            triggersController.clearBinding();
        }
    }

    public final void onAttachedToWindow(DivViewFacade view) {
        Intrinsics.checkNotNullParameter(view, "view");
        TriggersController triggersController = this.triggersController;
        if (triggersController != null) {
            triggersController.onAttachedToWindow(view);
        }
    }

    public final void updateSubscriptions() {
        Unit unit;
        if (this.unsubscribed) {
            this.unsubscribed = false;
            ExpressionResolverImpl expressionResolverImpl = getExpressionResolverImpl();
            if (expressionResolverImpl != null) {
                expressionResolverImpl.subscribeOnVariables$div_release();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                Assert.fail("ExpressionRuntime must have ExpressionResolverImpl as expressionResolver.");
            }
            this.variableController.restoreSubscriptions();
        }
    }

    public final void cleanup$div_release() {
        if (this.unsubscribed) {
            return;
        }
        this.unsubscribed = true;
        TriggersController triggersController = this.triggersController;
        if (triggersController != null) {
            triggersController.clearBinding();
        }
        this.variableController.cleanupSubscriptions();
    }
}
