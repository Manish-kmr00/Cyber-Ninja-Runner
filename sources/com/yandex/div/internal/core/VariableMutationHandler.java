package com.yandex.div.internal.core;

import com.yandex.div.core.actions.DivActionTypedUtilsKt;
import com.yandex.div.core.expression.ExpressionsRuntime;
import com.yandex.div.core.expression.variables.VariableController;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.data.Variable;
import com.yandex.div.data.VariableMutationException;
import com.yandex.div.json.expressions.ExpressionResolver;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VariableMutationHandler.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/yandex/div/internal/core/VariableMutationHandler;", "", "()V", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class VariableMutationHandler {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final <T extends Variable> VariableMutationException setVariable(Div2View div2View, String str, ExpressionResolver expressionResolver, Function1<? super T, ? extends T> function1) {
        return INSTANCE.setVariable(div2View, str, expressionResolver, function1);
    }

    @JvmStatic
    public static final VariableMutationException setVariable(Div2View div2View, String str, String str2, ExpressionResolver expressionResolver) {
        return INSTANCE.setVariable(div2View, str, str2, expressionResolver);
    }

    /* JADX INFO: compiled from: VariableMutationHandler.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J@\u0010\u0010\u001a\u0004\u0018\u00010\u0004\"\b\b\u0000\u0010\u0011*\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00110\u0013H\u0007J*\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/internal/core/VariableMutationHandler$Companion;", "", "()V", "createAndReportError", "Lcom/yandex/div/data/VariableMutationException;", "e", "", "div2View", "Lcom/yandex/div/core/view2/Div2View;", "message", "", "findVariable", "Lcom/yandex/div/data/Variable;", "name", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "setVariable", "T", "valueMutation", "Lkotlin/Function1;", "value", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final VariableMutationException setVariable(Div2View div2View, String name, String value, ExpressionResolver resolver) {
            Object objM7904constructorimpl;
            Intrinsics.checkNotNullParameter(div2View, "div2View");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Variable variableFindVariable = findVariable(div2View, name, resolver);
            if (variableFindVariable == null) {
                return createAndReportError(null, div2View, "Variable '" + name + "' not defined!");
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                variableFindVariable.set(value);
                objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl == null) {
                return null;
            }
            return VariableMutationHandler.INSTANCE.createAndReportError(thM7907exceptionOrNullimpl, div2View, "Variable '" + name + "' mutation failed!");
        }

        @JvmStatic
        public final <T extends Variable> VariableMutationException setVariable(Div2View div2View, String name, ExpressionResolver resolver, Function1<? super T, ? extends T> valueMutation) {
            Object objM7904constructorimpl;
            Intrinsics.checkNotNullParameter(div2View, "div2View");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(valueMutation, "valueMutation");
            Variable variableFindVariable = findVariable(div2View, name, resolver);
            if (variableFindVariable == null) {
                return createAndReportError(null, div2View, "Variable '" + name + "' not defined!");
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                variableFindVariable.setValue(valueMutation.invoke(variableFindVariable));
                objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl == null) {
                return null;
            }
            return VariableMutationHandler.INSTANCE.createAndReportError(thM7907exceptionOrNullimpl, div2View, "Variable '" + name + "' mutation failed!");
        }

        private final Variable findVariable(Div2View div2View, String name, ExpressionResolver resolver) {
            VariableController variableController;
            ExpressionsRuntime runtimeFor = BaseDivViewExtensionsKt.getRuntimeFor(div2View.getRuntimeStore(), resolver);
            if (runtimeFor == null) {
                runtimeFor = div2View.getExpressionsRuntime();
            }
            if (runtimeFor == null || (variableController = runtimeFor.getVariableController()) == null) {
                return null;
            }
            return variableController.getMutableVariable(name);
        }

        private final VariableMutationException createAndReportError(Throwable e, Div2View div2View, String message) {
            VariableMutationException variableMutationException = new VariableMutationException(message, e);
            DivActionTypedUtilsKt.logError(div2View, variableMutationException);
            return variableMutationException;
        }
    }
}
