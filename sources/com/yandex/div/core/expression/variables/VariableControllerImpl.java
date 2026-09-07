package com.yandex.div.core.expression.variables;

import com.yandex.div.core.Disposable;
import com.yandex.div.core.ObserverList;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.data.Variable;
import com.yandex.div.data.VariableDeclarationException;
import com.yandex.div.internal.Assert;
import com.yandex.div.json.ParsingExceptionKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VariableControllerImpl.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J$\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0012J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u001bH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\fH\u0012J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\fH\u0012J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\fH\u0012J$\u0010$\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0012J\b\u0010%\u001a\u00020\rH\u0016J\u001c\u0010&\u001a\u00020\r2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J6\u0010(\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J:\u0010.\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00122\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010,\u001a\u00020-2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0012J2\u0010/\u001a\u00020)2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b2\u0006\u0010,\u001a\u00020-2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J*\u00101\u001a\u00020)2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u000fX\u0092\u0004¢\u0006\u0002\n\u0000R,\u0010\u0010\u001a \u0012\u0004\u0012\u00020\u0012\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u000f0\u0011X\u0092\u0004¢\u0006\u0002\n\u0000R,\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u0012\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u000f0\u0011X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u0011X\u0092\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/yandex/div/core/expression/variables/VariableControllerImpl;", "Lcom/yandex/div/core/expression/variables/VariableController;", "delegate", "(Lcom/yandex/div/core/expression/variables/VariableController;)V", "declarationObserver", "com/yandex/div/core/expression/variables/VariableControllerImpl$declarationObserver$1", "Lcom/yandex/div/core/expression/variables/VariableControllerImpl$declarationObserver$1;", "extraVariablesSources", "", "Lcom/yandex/div/core/expression/variables/VariableSource;", "notifyVariableChangedCallback", "Lkotlin/Function1;", "Lcom/yandex/div/data/Variable;", "", "onAnyVariableChangeObservers", "Lcom/yandex/div/core/ObserverList;", "onChangeObservers", "", "", "onRemoveObservers", "variables", "addObserver", "name", "observer", "addSource", "source", "captureAll", "", "cleanupSubscriptions", "declare", "variable", "getMutableVariable", "notifyVariableChanged", "v", "onVariableDeclared", "onVariableRemoved", "removeChangeObserver", "restoreSubscriptions", "setOnAnyVariableChangeCallback", "callback", "subscribeToVariableChange", "Lcom/yandex/div/core/Disposable;", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "invokeOnSubscription", "", "subscribeToVariableChangeImpl", "subscribeToVariablesChange", "names", "subscribeToVariablesUndeclared", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class VariableControllerImpl implements VariableController {
    private final VariableControllerImpl$declarationObserver$1 declarationObserver;
    private final VariableController delegate;
    private final List<VariableSource> extraVariablesSources;
    private final Function1<Variable, Unit> notifyVariableChangedCallback;
    private final ObserverList<Function1<Variable, Unit>> onAnyVariableChangeObservers;
    private final Map<String, ObserverList<Function1<Variable, Unit>>> onChangeObservers;
    private final Map<String, ObserverList<Function1<Variable, Unit>>> onRemoveObservers;
    private final Map<String, Variable> variables;

    public VariableControllerImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Type inference failed for: r1v12, types: [com.yandex.div.core.expression.variables.VariableControllerImpl$declarationObserver$1] */
    public VariableControllerImpl(VariableController variableController) {
        this.delegate = variableController;
        this.variables = new LinkedHashMap();
        this.extraVariablesSources = new ArrayList();
        this.onChangeObservers = new LinkedHashMap();
        this.onRemoveObservers = new LinkedHashMap();
        this.onAnyVariableChangeObservers = new ObserverList<>();
        this.notifyVariableChangedCallback = new Function1<Variable, Unit>() { // from class: com.yandex.div.core.expression.variables.VariableControllerImpl$notifyVariableChangedCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Variable variable) {
                invoke2(variable);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Variable v) {
                Intrinsics.checkNotNullParameter(v, "v");
                this.this$0.notifyVariableChanged(v);
            }
        };
        this.declarationObserver = new DeclarationObserver() { // from class: com.yandex.div.core.expression.variables.VariableControllerImpl$declarationObserver$1
            @Override // com.yandex.div.core.expression.variables.DeclarationObserver
            public void onDeclared(Variable variable) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                this.this$0.onVariableDeclared(variable);
            }

            @Override // com.yandex.div.core.expression.variables.DeclarationObserver
            public void onUndeclared(Variable variable) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                this.this$0.onVariableRemoved(variable);
            }
        };
    }

    public /* synthetic */ VariableControllerImpl(VariableController variableController, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : variableController);
    }

    private void addObserver(String name, Function1<? super Variable, Unit> observer) {
        Map<String, ObserverList<Function1<Variable, Unit>>> map = this.onChangeObservers;
        ObserverList<Function1<Variable, Unit>> observerList = map.get(name);
        if (observerList == null) {
            observerList = new ObserverList<>();
            map.put(name, observerList);
        }
        observerList.addObserver(observer);
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public Disposable subscribeToVariablesChange(final List<String> names, boolean invokeOnSubscription, final Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(observer, "observer");
        final ArrayList arrayList = new ArrayList();
        for (String str : names) {
            if (!this.variables.containsKey(str)) {
                VariableController variableController = this.delegate;
                if ((variableController != null ? variableController.getMutableVariable(str) : null) != null) {
                    arrayList.add(this.delegate.subscribeToVariableChange(str, null, invokeOnSubscription, observer));
                }
            }
            subscribeToVariableChangeImpl(str, null, invokeOnSubscription, observer);
        }
        return new Disposable() { // from class: com.yandex.div.core.expression.variables.VariableControllerImpl$$ExternalSyntheticLambda2
            @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
            public final void close() {
                VariableControllerImpl.subscribeToVariablesChange$lambda$5(names, arrayList, this, observer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void subscribeToVariablesChange$lambda$5(List names, List disposables, VariableControllerImpl this$0, Function1 observer) {
        Intrinsics.checkNotNullParameter(names, "$names");
        Intrinsics.checkNotNullParameter(disposables, "$disposables");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        Iterator it = names.iterator();
        while (it.hasNext()) {
            this$0.removeChangeObserver((String) it.next(), observer);
        }
        Iterator it2 = disposables.iterator();
        while (it2.hasNext()) {
            ((Disposable) it2.next()).close();
        }
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public Disposable subscribeToVariableChange(final String name, ErrorCollector errorCollector, boolean invokeOnSubscription, final Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.variables.containsKey(name)) {
            VariableController variableController = this.delegate;
            if ((variableController != null ? variableController.getMutableVariable(name) : null) != null) {
                return this.delegate.subscribeToVariableChange(name, errorCollector, invokeOnSubscription, observer);
            }
        }
        subscribeToVariableChangeImpl(name, errorCollector, invokeOnSubscription, observer);
        return new Disposable() { // from class: com.yandex.div.core.expression.variables.VariableControllerImpl$$ExternalSyntheticLambda0
            @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
            public final void close() {
                VariableControllerImpl.subscribeToVariableChange$lambda$6(this.f$0, name, observer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void subscribeToVariableChange$lambda$6(VariableControllerImpl this$0, String name, Function1 observer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        this$0.removeChangeObserver(name, observer);
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public Disposable subscribeToVariablesUndeclared(final List<String> names, final Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(observer, "observer");
        for (String str : names) {
            Map<String, ObserverList<Function1<Variable, Unit>>> map = this.onRemoveObservers;
            ObserverList<Function1<Variable, Unit>> observerList = map.get(str);
            if (observerList == null) {
                observerList = new ObserverList<>();
                map.put(str, observerList);
            }
            observerList.addObserver(observer);
        }
        return new Disposable() { // from class: com.yandex.div.core.expression.variables.VariableControllerImpl$$ExternalSyntheticLambda1
            @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
            public final void close() {
                VariableControllerImpl.subscribeToVariablesUndeclared$lambda$10(names, this, observer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void subscribeToVariablesUndeclared$lambda$10(List names, VariableControllerImpl this$0, Function1 observer) {
        Intrinsics.checkNotNullParameter(names, "$names");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        Iterator it = names.iterator();
        while (it.hasNext()) {
            ObserverList<Function1<Variable, Unit>> observerList = this$0.onRemoveObservers.get((String) it.next());
            if (observerList != null) {
                observerList.removeObserver(observer);
            }
        }
    }

    static /* synthetic */ void subscribeToVariableChangeImpl$default(VariableControllerImpl variableControllerImpl, String str, ErrorCollector errorCollector, boolean z, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribeToVariableChangeImpl");
        }
        if ((i & 2) != 0) {
            errorCollector = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        variableControllerImpl.subscribeToVariableChangeImpl(str, errorCollector, z, function1);
    }

    private void subscribeToVariableChangeImpl(String name, ErrorCollector errorCollector, boolean invokeOnSubscription, Function1<? super Variable, Unit> observer) {
        Variable mutableVariable = getMutableVariable(name);
        if (mutableVariable == null) {
            if (errorCollector != null) {
                errorCollector.logError(ParsingExceptionKt.missingVariable$default(name, null, 2, null));
            }
            addObserver(name, observer);
        } else {
            if (invokeOnSubscription) {
                Assert.assertMainThread();
                observer.invoke(mutableVariable);
            }
            addObserver(name, observer);
        }
    }

    private void removeChangeObserver(String name, Function1<? super Variable, Unit> observer) {
        ObserverList<Function1<Variable, Unit>> observerList = this.onChangeObservers.get(name);
        if (observerList != null) {
            observerList.removeObserver(observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyVariableChanged(Variable v) {
        Assert.assertMainThread();
        Iterator<Function1<Variable, Unit>> it = this.onAnyVariableChangeObservers.iterator();
        while (it.hasNext()) {
            it.next().invoke(v);
        }
        ObserverList<Function1<Variable, Unit>> observerList = this.onChangeObservers.get(v.getName());
        if (observerList != null) {
            Iterator<Function1<Variable, Unit>> it2 = observerList.iterator();
            while (it2.hasNext()) {
                it2.next().invoke(v);
            }
        }
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public void addSource(VariableSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        source.observeVariables(this.notifyVariableChangedCallback);
        source.observeDeclaration(this.declarationObserver);
        this.extraVariablesSources.add(source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVariableDeclared(Variable variable) {
        variable.addObserver(this.notifyVariableChangedCallback);
        notifyVariableChanged(variable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVariableRemoved(Variable variable) {
        variable.removeObserver(this.notifyVariableChangedCallback);
        ObserverList<Function1<Variable, Unit>> observerList = this.onRemoveObservers.get(variable.getName());
        if (observerList != null) {
            Iterator<Function1<Variable, Unit>> it = observerList.iterator();
            while (it.hasNext()) {
                it.next().invoke(variable);
            }
        }
        for (Function1<Variable, Unit> it2 : this.onAnyVariableChangeObservers) {
            it2.invoke(variable);
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            variable.removeObserver(it2);
        }
        this.variables.remove(variable.getName());
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public Variable getMutableVariable(String name) {
        Variable mutableVariable;
        Intrinsics.checkNotNullParameter(name, "name");
        Variable variable = this.variables.get(name);
        if (variable != null) {
            return variable;
        }
        VariableController variableController = this.delegate;
        if (variableController != null && (mutableVariable = variableController.getMutableVariable(name)) != null) {
            return mutableVariable;
        }
        Iterator<T> it = this.extraVariablesSources.iterator();
        while (it.hasNext()) {
            Variable mutableVariable2 = ((VariableSource) it.next()).getMutableVariable(name);
            if (mutableVariable2 != null) {
                return mutableVariable2;
            }
        }
        return null;
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public void cleanupSubscriptions() {
        for (VariableSource variableSource : this.extraVariablesSources) {
            variableSource.removeVariablesObserver(this.notifyVariableChangedCallback);
            variableSource.removeDeclarationObserver(this.declarationObserver);
        }
        this.onAnyVariableChangeObservers.clear();
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public void restoreSubscriptions() {
        for (VariableSource variableSource : this.extraVariablesSources) {
            variableSource.observeVariables(this.notifyVariableChangedCallback);
            variableSource.receiveVariablesUpdates(this.notifyVariableChangedCallback);
            variableSource.observeDeclaration(this.declarationObserver);
        }
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public void declare(Variable variable) throws VariableDeclarationException {
        Intrinsics.checkNotNullParameter(variable, "variable");
        Variable variablePut = this.variables.put(variable.getName(), variable);
        if (variablePut != null) {
            this.variables.put(variable.getName(), variablePut);
            throw new VariableDeclarationException("Variable '" + variable.getName() + "' already declared!", null, 2, null);
        }
        onVariableDeclared(variable);
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public void setOnAnyVariableChangeCallback(final Function1<? super Variable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.onAnyVariableChangeObservers.addObserver(callback);
        VariableController variableController = this.delegate;
        if (variableController != null) {
            variableController.setOnAnyVariableChangeCallback(new Function1<Variable, Unit>() { // from class: com.yandex.div.core.expression.variables.VariableControllerImpl.setOnAnyVariableChangeCallback.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Variable variable) {
                    invoke2(variable);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Variable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (VariableControllerImpl.this.variables.get(it.getName()) == null) {
                        callback.invoke(it);
                    }
                }
            });
        }
    }

    @Override // com.yandex.div.core.expression.variables.VariableController
    public List<Variable> captureAll() {
        return CollectionsKt.toList(this.variables.values());
    }
}
