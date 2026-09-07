package com.yandex.div.core.expression.variables;

import com.yandex.div.data.Variable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingleVariableSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u00002\u00020\u0001BJ\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016J\u001c\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0016\u001a\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0092\u0004¢\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/core/expression/variables/SingleVariableSource;", "Lcom/yandex/div/core/expression/variables/VariableSource;", "variables", "", "", "Lcom/yandex/div/data/Variable;", "requestObserver", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "variableName", "", "declarationObservers", "", "Lcom/yandex/div/core/expression/variables/DeclarationObserver;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;Ljava/util/Collection;)V", "getMutableVariable", "observeDeclaration", "observer", "observeVariables", "receiveVariablesUpdates", "removeDeclarationObserver", "removeVariablesObserver", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class SingleVariableSource implements VariableSource {
    private final Collection<DeclarationObserver> declarationObservers;
    private final Function1<String, Unit> requestObserver;
    private final Map<String, Variable> variables;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleVariableSource(Map<String, ? extends Variable> variables, Function1<? super String, Unit> requestObserver, Collection<DeclarationObserver> declarationObservers) {
        Intrinsics.checkNotNullParameter(variables, "variables");
        Intrinsics.checkNotNullParameter(requestObserver, "requestObserver");
        Intrinsics.checkNotNullParameter(declarationObservers, "declarationObservers");
        this.variables = variables;
        this.requestObserver = requestObserver;
        this.declarationObservers = declarationObservers;
    }

    @Override // com.yandex.div.core.expression.variables.VariableSource
    public Variable getMutableVariable(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.requestObserver.invoke(name);
        return this.variables.get(name);
    }

    @Override // com.yandex.div.core.expression.variables.VariableSource
    public void observeDeclaration(DeclarationObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.declarationObservers.add(observer);
    }

    @Override // com.yandex.div.core.expression.variables.VariableSource
    public void observeVariables(Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Iterator<T> it = this.variables.values().iterator();
        while (it.hasNext()) {
            ((Variable) it.next()).addObserver(observer);
        }
    }

    @Override // com.yandex.div.core.expression.variables.VariableSource
    public void receiveVariablesUpdates(Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Iterator<T> it = this.variables.values().iterator();
        while (it.hasNext()) {
            observer.invoke((Variable) it.next());
        }
    }

    @Override // com.yandex.div.core.expression.variables.VariableSource
    public void removeDeclarationObserver(DeclarationObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.declarationObservers.remove(observer);
    }

    @Override // com.yandex.div.core.expression.variables.VariableSource
    public void removeVariablesObserver(Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Iterator<T> it = this.variables.values().iterator();
        while (it.hasNext()) {
            ((Variable) it.next()).removeObserver(observer);
        }
    }
}
