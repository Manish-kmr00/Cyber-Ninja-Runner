package com.yandex.div.core.expression.variables;

import com.yandex.div.data.Variable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiVariableSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u0012\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/core/expression/variables/MultiVariableSource;", "Lcom/yandex/div/core/expression/variables/VariableSource;", "variableController", "Lcom/yandex/div/core/expression/variables/DivVariableController;", "variableRequestObserver", "Lkotlin/Function1;", "", "", "(Lcom/yandex/div/core/expression/variables/DivVariableController;Lkotlin/jvm/functions/Function1;)V", "getMutableVariable", "Lcom/yandex/div/data/Variable;", "name", "observeDeclaration", "observer", "Lcom/yandex/div/core/expression/variables/DeclarationObserver;", "observeVariables", "receiveVariablesUpdates", "removeDeclarationObserver", "removeVariablesObserver", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class MultiVariableSource implements VariableSource {
    private final DivVariableController variableController;
    private final Function1<String, Unit> variableRequestObserver;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiVariableSource(DivVariableController variableController, Function1<? super String, Unit> variableRequestObserver) {
        Intrinsics.checkNotNullParameter(variableController, "variableController");
        Intrinsics.checkNotNullParameter(variableRequestObserver, "variableRequestObserver");
        this.variableController = variableController;
        this.variableRequestObserver = variableRequestObserver;
    }

    @Override // com.yandex.div.core.expression.variables.VariableSource
    public Variable getMutableVariable(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.variableRequestObserver.invoke(name);
        return this.variableController.get(name);
    }

    @Override // com.yandex.div.core.expression.variables.VariableSource
    public void observeDeclaration(DeclarationObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.variableController.addDeclarationObserver$div_release(observer);
    }

    @Override // com.yandex.div.core.expression.variables.VariableSource
    public void removeDeclarationObserver(DeclarationObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.variableController.removeDeclarationObserver$div_release(observer);
    }

    @Override // com.yandex.div.core.expression.variables.VariableSource
    public void observeVariables(Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.variableController.addVariableObserver$div_release(observer);
    }

    @Override // com.yandex.div.core.expression.variables.VariableSource
    public void removeVariablesObserver(Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.variableController.removeVariablesObserver$div_release(observer);
    }

    @Override // com.yandex.div.core.expression.variables.VariableSource
    public void receiveVariablesUpdates(Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.variableController.receiveVariablesUpdates$div_release(observer);
    }
}
