package com.yandex.div.core.expression.variables;

import android.os.Handler;
import android.os.Looper;
import com.yandex.div.data.Variable;
import com.yandex.div.data.VariableDeclarationException;
import com.yandex.div.data.VariableMutationException;
import com.yandex.div.internal.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DivVariableController.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u001dJ!\u0010\u001e\u001a\u00020\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0002\b\u001fJ\u001e\u0010 \u001a\u00020\f2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\rJ\u0013\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\"H\u0000¢\u0006\u0002\b#J\u001f\u0010$\u001a\u00020\f2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0%\"\u00020\u001a¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u0004\u0018\u00010\u001a2\u0006\u0010(\u001a\u00020\tJ\u000e\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\tJ\u0010\u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020\tH\u0002J\u001f\u0010,\u001a\u00020\f2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0%\"\u00020\u001a¢\u0006\u0002\u0010&J!\u0010-\u001a\u00020\f2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0%\"\u00020\u001aH\u0002¢\u0006\u0002\u0010&J!\u0010.\u001a\u00020\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0002\b/J\u001f\u00100\u001a\u00020\f2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0%\"\u00020\t¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0002\b4J!\u00105\u001a\u00020\f2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0%\"\u00020\tH\u0002¢\u0006\u0002\u00102J\u001e\u00107\u001a\u00020\f2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\rJ!\u00108\u001a\u00020\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0002\b9J\u001f\u0010:\u001a\u00020\f2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0%\"\u00020\u001a¢\u0006\u0002\u0010&J!\u0010;\u001a\u00020\f2\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0%\"\u00020\u001aH\u0002¢\u0006\u0002\u0010&R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/yandex/div/core/expression/variables/DivVariableController;", "", "internalVariableController", "(Lcom/yandex/div/core/expression/variables/DivVariableController;)V", "declarationObservers", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/yandex/div/core/expression/variables/DeclarationObserver;", "declaredVariableNames", "", "", "externalVariableRequestObservers", "Lkotlin/Function1;", "", "Lcom/yandex/div/core/expression/variables/VariableRequestObserver;", "mainHandler", "Landroid/os/Handler;", "pendingDeclaration", "requestsObserver", "undeclaredVariables", "", "variableSource", "Lcom/yandex/div/core/expression/variables/MultiVariableSource;", "getVariableSource$div_release", "()Lcom/yandex/div/core/expression/variables/MultiVariableSource;", "variables", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/yandex/div/data/Variable;", "addDeclarationObserver", "observer", "addDeclarationObserver$div_release", "addVariableObserver", "addVariableObserver$div_release", "addVariableRequestObserver", "captureAllVariables", "", "captureAllVariables$div_release", "declare", "", "([Lcom/yandex/div/data/Variable;)V", "get", "variableName", "isDeclared", "", "isDeclaredLocal", "putOrUpdate", "putOrUpdateInternal", "receiveVariablesUpdates", "receiveVariablesUpdates$div_release", "removeAll", "variablesNames", "([Ljava/lang/String;)V", "removeDeclarationObserver", "removeDeclarationObserver$div_release", "removeVariableInternal", "names", "removeVariableRequestObserver", "removeVariablesObserver", "removeVariablesObserver$div_release", "replaceAll", "replaceAllInternal", "newVariables", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivVariableController {
    private final ConcurrentLinkedQueue<DeclarationObserver> declarationObservers;
    private final Set<String> declaredVariableNames;
    private final ConcurrentLinkedQueue<Function1<String, Unit>> externalVariableRequestObservers;
    private final DivVariableController internalVariableController;
    private final Handler mainHandler;
    private final Set<String> pendingDeclaration;
    private final Function1<String, Unit> requestsObserver;
    private final Map<String, String> undeclaredVariables;
    private final MultiVariableSource variableSource;
    private final ConcurrentHashMap<String, Variable> variables;

    public DivVariableController() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public DivVariableController(DivVariableController divVariableController) {
        this.internalVariableController = divVariableController;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.variables = new ConcurrentHashMap<>();
        this.declarationObservers = new ConcurrentLinkedQueue<>();
        this.undeclaredVariables = new LinkedHashMap();
        this.declaredVariableNames = new LinkedHashSet();
        this.pendingDeclaration = new LinkedHashSet();
        this.externalVariableRequestObservers = new ConcurrentLinkedQueue<>();
        Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.yandex.div.core.expression.variables.DivVariableController$requestsObserver$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String variableName) {
                Intrinsics.checkNotNullParameter(variableName, "variableName");
                Iterator it = this.this$0.externalVariableRequestObservers.iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(variableName);
                }
            }
        };
        this.requestsObserver = function1;
        this.variableSource = new MultiVariableSource(this, function1);
    }

    public /* synthetic */ DivVariableController(DivVariableController divVariableController, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divVariableController);
    }

    /* JADX INFO: renamed from: getVariableSource$div_release, reason: from getter */
    public final MultiVariableSource getVariableSource() {
        return this.variableSource;
    }

    public final void declare(final Variable... variables) throws VariableDeclarationException {
        Intrinsics.checkNotNullParameter(variables, "variables");
        synchronized (this.declaredVariableNames) {
            ArrayList arrayList = new ArrayList();
            for (Variable variable : variables) {
                if (this.declaredVariableNames.contains(variable.getName()) || this.pendingDeclaration.contains(variable.getName())) {
                    arrayList.add(variable);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (!arrayList2.isEmpty()) {
                throw new VariableDeclarationException(StringsKt.trimIndent("\n                        Wanted to declare new variable(s) '" + arrayList2 + "',\n                        but variable(s) with such name(s) already exists!\n                    "), null, 2, null);
            }
            Set<String> set = this.pendingDeclaration;
            ArrayList arrayList3 = new ArrayList(variables.length);
            for (Variable variable2 : variables) {
                arrayList3.add(variable2.getName());
            }
            set.addAll(arrayList3);
        }
        if (!Intrinsics.areEqual(this.mainHandler.getLooper(), Looper.myLooper())) {
            this.mainHandler.post(new Runnable() { // from class: com.yandex.div.core.expression.variables.DivVariableController$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    DivVariableController.declare$lambda$3(this.f$0, variables);
                }
            });
        } else {
            putOrUpdateInternal((Variable[]) Arrays.copyOf(variables, variables.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void declare$lambda$3(DivVariableController this$0, Variable[] variables) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(variables, "$variables");
        this$0.putOrUpdateInternal((Variable[]) Arrays.copyOf(variables, variables.length));
    }

    public final Variable get(String variableName) {
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        if (isDeclaredLocal(variableName)) {
            return this.variables.get(variableName);
        }
        DivVariableController divVariableController = this.internalVariableController;
        if (divVariableController != null) {
            return divVariableController.get(variableName);
        }
        return null;
    }

    public final boolean isDeclared(String variableName) {
        boolean z;
        DivVariableController divVariableController;
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        synchronized (this.declaredVariableNames) {
            z = true;
            if (!isDeclaredLocal(variableName) && ((divVariableController = this.internalVariableController) == null || !divVariableController.isDeclared(variableName))) {
                z = false;
            }
        }
        return z;
    }

    public final void putOrUpdate(final Variable... variables) throws VariableMutationException {
        Intrinsics.checkNotNullParameter(variables, "variables");
        if (!Intrinsics.areEqual(this.mainHandler.getLooper(), Looper.myLooper())) {
            this.mainHandler.post(new Runnable() { // from class: com.yandex.div.core.expression.variables.DivVariableController$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DivVariableController.putOrUpdate$lambda$5(this.f$0, variables);
                }
            });
        } else {
            putOrUpdateInternal((Variable[]) Arrays.copyOf(variables, variables.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void putOrUpdate$lambda$5(DivVariableController this$0, Variable[] variables) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(variables, "$variables");
        this$0.putOrUpdateInternal((Variable[]) Arrays.copyOf(variables, variables.length));
    }

    public final void replaceAll(final Variable... variables) throws VariableMutationException {
        Intrinsics.checkNotNullParameter(variables, "variables");
        if (!Intrinsics.areEqual(this.mainHandler.getLooper(), Looper.myLooper())) {
            this.mainHandler.post(new Runnable() { // from class: com.yandex.div.core.expression.variables.DivVariableController$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    DivVariableController.replaceAll$lambda$6(this.f$0, variables);
                }
            });
        } else {
            replaceAllInternal((Variable[]) Arrays.copyOf(variables, variables.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void replaceAll$lambda$6(DivVariableController this$0, Variable[] variables) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(variables, "$variables");
        this$0.replaceAllInternal((Variable[]) Arrays.copyOf(variables, variables.length));
    }

    public final void removeAll(final String... variablesNames) {
        Intrinsics.checkNotNullParameter(variablesNames, "variablesNames");
        if (!Intrinsics.areEqual(this.mainHandler.getLooper(), Looper.myLooper())) {
            this.mainHandler.post(new Runnable() { // from class: com.yandex.div.core.expression.variables.DivVariableController$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DivVariableController.removeAll$lambda$7(this.f$0, variablesNames);
                }
            });
        } else {
            removeVariableInternal((String[]) Arrays.copyOf(variablesNames, variablesNames.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeAll$lambda$7(DivVariableController this$0, String[] variablesNames) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(variablesNames, "$variablesNames");
        this$0.removeVariableInternal((String[]) Arrays.copyOf(variablesNames, variablesNames.length));
    }

    private final void putOrUpdateInternal(Variable... variables) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.declaredVariableNames) {
            for (Variable variable : variables) {
                String str = this.undeclaredVariables.get(variable.getName());
                if (str != null && !Intrinsics.areEqual(str, variable.getClass().getName())) {
                    throw new VariableMutationException("Cannot declare new variable with type = " + variable.getClass().getName() + ", because this variable have been declaredwith another type = " + str, null, 2, null);
                }
                if (!this.declaredVariableNames.contains(variable.getName())) {
                    this.declaredVariableNames.add(variable.getName());
                    this.pendingDeclaration.remove(variable.getName());
                    arrayList.add(variable);
                }
                final Variable variable2 = this.variables.get(variable.getName());
                if (variable2 != null) {
                    variable2.setValue(variable);
                    variable.addObserver(new Function1<Variable, Unit>() { // from class: com.yandex.div.core.expression.variables.DivVariableController$putOrUpdateInternal$1$1$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Variable variable3) {
                            invoke2(variable3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Variable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            variable2.setValue(it);
                        }
                    });
                } else {
                    Variable variablePut = this.variables.put(variable.getName(), variable);
                    if (variablePut != null) {
                        Assert.fail(StringsKt.trimIndent("\n                    Wanted to put new variable '" + variable + "', but variable with such name\n                    already exists '" + variablePut + "'! Is there a race?\n                "));
                    }
                    this.undeclaredVariables.remove(variable.getName());
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        for (DeclarationObserver declarationObserver : this.declarationObservers) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                declarationObserver.onDeclared((Variable) it.next());
            }
        }
    }

    private final void removeVariableInternal(String... names) {
        ConcurrentHashMap<String, Variable> concurrentHashMap = this.variables;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Variable> entry : concurrentHashMap.entrySet()) {
            if (ArraysKt.contains(names, entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        synchronized (this.declaredVariableNames) {
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                this.declaredVariableNames.remove(entry2.getKey());
                Map<String, String> map = this.undeclaredVariables;
                Object key = entry2.getKey();
                String name = entry2.getValue().getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "existing.value::class.java.name");
                map.put((String) key, name);
                this.variables.remove(entry2.getKey());
            }
            Unit unit = Unit.INSTANCE;
        }
        for (DeclarationObserver declarationObserver : this.declarationObservers) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                declarationObserver.onUndeclared((Variable) ((Map.Entry) it.next()).getValue());
            }
        }
    }

    private final void replaceAllInternal(Variable... newVariables) {
        ConcurrentHashMap<String, Variable> concurrentHashMap = this.variables;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, Variable>> it = concurrentHashMap.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Variable> next = it.next();
            int length = newVariables.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (Intrinsics.areEqual(next.getKey(), newVariables[i].getName())) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        Collection<?> collectionValues = linkedHashMap.values();
        List mutableList = ArraysKt.toMutableList(newVariables);
        mutableList.removeAll(collectionValues);
        Collection<?> collection = collectionValues;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(((Variable) it2.next()).getName());
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            removeVariableInternal((String) it3.next());
        }
        Iterator it4 = mutableList.iterator();
        while (it4.hasNext()) {
            putOrUpdateInternal((Variable) it4.next());
        }
    }

    private final boolean isDeclaredLocal(String variableName) {
        boolean zContains;
        synchronized (this.declaredVariableNames) {
            zContains = this.declaredVariableNames.contains(variableName);
        }
        return zContains;
    }

    public final void addVariableRequestObserver(Function1<? super String, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.externalVariableRequestObservers.add(observer);
        DivVariableController divVariableController = this.internalVariableController;
        if (divVariableController != null) {
            divVariableController.addVariableRequestObserver(observer);
        }
    }

    public final void removeVariableRequestObserver(Function1<? super String, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.externalVariableRequestObservers.remove(observer);
        DivVariableController divVariableController = this.internalVariableController;
        if (divVariableController != null) {
            divVariableController.removeVariableRequestObserver(observer);
        }
    }

    public final void addDeclarationObserver$div_release(DeclarationObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.declarationObservers.add(observer);
        DivVariableController divVariableController = this.internalVariableController;
        if (divVariableController != null) {
            divVariableController.addDeclarationObserver$div_release(observer);
        }
    }

    public final void removeDeclarationObserver$div_release(DeclarationObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.declarationObservers.remove(observer);
        DivVariableController divVariableController = this.internalVariableController;
        if (divVariableController != null) {
            divVariableController.removeDeclarationObserver$div_release(observer);
        }
    }

    public final void addVariableObserver$div_release(Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Collection<Variable> collectionValues = this.variables.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "variables.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((Variable) it.next()).addObserver(observer);
        }
        DivVariableController divVariableController = this.internalVariableController;
        if (divVariableController != null) {
            divVariableController.addVariableObserver$div_release(observer);
        }
    }

    public final void removeVariablesObserver$div_release(Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Collection<Variable> collectionValues = this.variables.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "variables.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((Variable) it.next()).removeObserver(observer);
        }
        DivVariableController divVariableController = this.internalVariableController;
        if (divVariableController != null) {
            divVariableController.removeVariablesObserver$div_release(observer);
        }
    }

    public final void receiveVariablesUpdates$div_release(Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Collection<Variable> collectionValues = this.variables.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "variables.values");
        for (Variable it : collectionValues) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            observer.invoke(it);
        }
        DivVariableController divVariableController = this.internalVariableController;
        if (divVariableController != null) {
            divVariableController.receiveVariablesUpdates$div_release(observer);
        }
    }

    public final List<Variable> captureAllVariables$div_release() {
        List<Variable> listEmptyList;
        Collection<Variable> collectionValues = this.variables.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "variables.values");
        DivVariableController divVariableController = this.internalVariableController;
        if (divVariableController == null || (listEmptyList = divVariableController.captureAllVariables$div_release()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return CollectionsKt.plus((Collection) collectionValues, (Iterable) listEmptyList);
    }
}
