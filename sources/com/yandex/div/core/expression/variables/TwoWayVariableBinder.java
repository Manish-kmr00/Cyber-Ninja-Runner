package com.yandex.div.core.expression.variables;

import com.yandex.div.DivDataTag;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.expression.ExpressionsRuntime;
import com.yandex.div.core.expression.ExpressionsRuntimeProvider;
import com.yandex.div.core.expression.local.RuntimeStore;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.data.Variable;
import com.yandex.div.internal.core.VariableMutationHandler;
import com.yandex.div2.DivData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: TwoWayVariableBinder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J.\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0011\u0010\u0012\u001a\u00020\r*\u00028\u0000H&¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/expression/variables/TwoWayVariableBinder;", "T", "", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "expressionsRuntimeProvider", "Lcom/yandex/div/core/expression/ExpressionsRuntimeProvider;", "(Lcom/yandex/div/core/view2/errors/ErrorCollectors;Lcom/yandex/div/core/expression/ExpressionsRuntimeProvider;)V", "bindVariable", "Lcom/yandex/div/core/Disposable;", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "variableName", "", "callbacks", "Lcom/yandex/div/core/expression/variables/TwoWayVariableBinder$Callbacks;", "path", "Lcom/yandex/div/core/state/DivStatePath;", "toStringValue", "(Ljava/lang/Object;)Ljava/lang/String;", "Callbacks", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class TwoWayVariableBinder<T> {
    private final ErrorCollectors errorCollectors;
    private final ExpressionsRuntimeProvider expressionsRuntimeProvider;

    /* JADX INFO: compiled from: TwoWayVariableBinder.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u0001H'¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/expression/variables/TwoWayVariableBinder$Callbacks;", "T", "", "onVariableChanged", "", "value", "(Ljava/lang/Object;)V", "setViewStateChangeListener", "valueUpdater", "Lkotlin/Function1;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callbacks<T> {
        void onVariableChanged(T value);

        void setViewStateChangeListener(Function1<? super T, Unit> valueUpdater);
    }

    public abstract String toStringValue(T t);

    public TwoWayVariableBinder(ErrorCollectors errorCollectors, ExpressionsRuntimeProvider expressionsRuntimeProvider) {
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        Intrinsics.checkNotNullParameter(expressionsRuntimeProvider, "expressionsRuntimeProvider");
        this.errorCollectors = errorCollectors;
        this.expressionsRuntimeProvider = expressionsRuntimeProvider;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0042  */
    public Disposable bindVariable(final BindingContext bindingContext, final String variableName, final Callbacks<T> callbacks, DivStatePath path) {
        VariableController variableController;
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(path, "path");
        final Div2View divView = bindingContext.getDivView();
        DivData divData = divView.getDivData();
        if (divData == null) {
            return Disposable.NULL;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        DivDataTag dataTag = divView.getDataTag();
        RuntimeStore runtimeStore = bindingContext.getRuntimeStore();
        if (runtimeStore != null) {
            ExpressionsRuntime runtimeWithOrNull$div_release = runtimeStore.getRuntimeWithOrNull$div_release(bindingContext.getExpressionResolver());
            variableController = runtimeWithOrNull$div_release != null ? runtimeWithOrNull$div_release.getVariableController() : null;
            if (variableController == null) {
                variableController = this.expressionsRuntimeProvider.getOrCreate$div_release(dataTag, divData, divView).getVariableController();
            }
        } else {
            variableController = this.expressionsRuntimeProvider.getOrCreate$div_release(dataTag, divData, divView).getVariableController();
        }
        callbacks.setViewStateChangeListener(new Function1<T, Unit>() { // from class: com.yandex.div.core.expression.variables.TwoWayVariableBinder.bindVariable.1
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
            public final void invoke2(T t) {
                if (Intrinsics.areEqual(objectRef.element, t)) {
                    return;
                }
                objectRef.element = t;
                VariableMutationHandler.INSTANCE.setVariable(divView, variableName, this.toStringValue(t), bindingContext.getExpressionResolver());
            }
        });
        return variableController.subscribeToVariableChange(variableName, this.errorCollectors.getOrCreate(dataTag, divData), true, new Function1<Variable, Unit>() { // from class: com.yandex.div.core.expression.variables.TwoWayVariableBinder.bindVariable.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Variable variable) {
                invoke2(variable);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Variable changed) {
                Intrinsics.checkNotNullParameter(changed, "changed");
                T t = (T) changed.getValue();
                if (t == null) {
                    t = null;
                }
                if (Intrinsics.areEqual(objectRef.element, t)) {
                    return;
                }
                objectRef.element = t;
                callbacks.onVariableChanged(t);
            }
        });
    }
}
