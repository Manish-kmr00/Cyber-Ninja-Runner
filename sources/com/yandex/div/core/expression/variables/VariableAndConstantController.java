package com.yandex.div.core.expression.variables;

import com.yandex.div.core.Disposable;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.data.Variable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VariableAndConstantController.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u001c\u0010\u0014\u001a\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0016H\u0016J6\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0016H\u0016J2\u0010\u001e\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110 2\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0016H\u0016J*\u0010!\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110 2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/yandex/div/core/expression/variables/VariableAndConstantController;", "Lcom/yandex/div/core/expression/variables/VariableController;", "delegate", "constants", "Lcom/yandex/div/core/expression/variables/ConstantsProvider;", "(Lcom/yandex/div/core/expression/variables/VariableController;Lcom/yandex/div/core/expression/variables/ConstantsProvider;)V", "addSource", "", "source", "Lcom/yandex/div/core/expression/variables/VariableSource;", "cleanupSubscriptions", "declare", "variable", "Lcom/yandex/div/data/Variable;", "get", "", "name", "", "getMutableVariable", "restoreSubscriptions", "setOnAnyVariableChangeCallback", "callback", "Lkotlin/Function1;", "subscribeToVariableChange", "Lcom/yandex/div/core/Disposable;", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "invokeOnSubscription", "", "observer", "subscribeToVariablesChange", "names", "", "subscribeToVariablesUndeclared", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class VariableAndConstantController implements VariableController {
    private final ConstantsProvider constants;
    private final VariableController delegate;

    public VariableAndConstantController(VariableController delegate, ConstantsProvider constants) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(constants, "constants");
        this.delegate = delegate;
        this.constants = constants;
    }

    @Override // com.yandex.div.core.expression.variables.VariableController, com.yandex.div.evaluable.VariableProvider
    public Object get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.constants.get(name);
        return obj == null ? super.get(name) : obj;
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public Disposable subscribeToVariablesChange(List<String> names, boolean invokeOnSubscription, Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.delegate.subscribeToVariablesChange(names, invokeOnSubscription, observer);
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public Disposable subscribeToVariablesUndeclared(List<String> names, Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.delegate.subscribeToVariablesUndeclared(names, observer);
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public Disposable subscribeToVariableChange(String name, ErrorCollector errorCollector, boolean invokeOnSubscription, Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.delegate.subscribeToVariableChange(name, errorCollector, invokeOnSubscription, observer);
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public void addSource(VariableSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.delegate.addSource(source);
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public Variable getMutableVariable(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.delegate.getMutableVariable(name);
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public void declare(Variable variable) {
        Intrinsics.checkNotNullParameter(variable, "variable");
        this.delegate.declare(variable);
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public void setOnAnyVariableChangeCallback(Function1<? super Variable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.delegate.setOnAnyVariableChangeCallback(callback);
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public void cleanupSubscriptions() {
        this.delegate.cleanupSubscriptions();
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public void restoreSubscriptions() {
        this.delegate.restoreSubscriptions();
    }
}
