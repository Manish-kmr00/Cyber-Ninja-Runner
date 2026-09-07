package com.yandex.div.core.view2.errors;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.yandex.div.core.expression.variables.VariableController;
import com.yandex.div.data.Variable;
import com.yandex.div.data.VariableMutationException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VariableMonitor.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u001a\u001a\u00020\tH\u0002J<\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00172\"\u0010\u001c\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u001dH\u0002J<\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010 \"\u0004\b\u0001\u0010!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!0\b2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!0\bH\u0002J\u001e\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tJ\b\u0010&\u001a\u00020\u0005H\u0002J\u0016\u0010'\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0)H\u0002J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\tH\u0002J4\u0010,\u001a\u00020\u00052,\u0010-\u001a(\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00170\u0016\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0018J\u001e\u0010.\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00170\u0016H\u0002J\u0012\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u0016*\u00020\nH\u0002R<\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R8\u0010\u0015\u001a,\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00170\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/yandex/div/core/view2/errors/VariableMonitor;", "", "errorHandler", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "value", "", "", "Lcom/yandex/div/core/expression/variables/VariableController;", "controllerMap", "getControllerMap", "()Ljava/util/Map;", "setControllerMap", "(Ljava/util/Map;)V", "variables", "", "Lkotlin/Pair;", "Lcom/yandex/div/core/view2/errors/PathAndName;", "Lcom/yandex/div/data/Variable;", "variablesUpdatedCallback", "", "Lcom/yandex/div/core/view2/errors/VariableWithPath;", "Lcom/yandex/div/core/view2/errors/VariablesUpdatedCallback;", "createCallback", "path", "entriesToVariables", "entry", "", "hasAllPairs", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "map", TypedValues.TransitionType.S_FROM, "mutateVariable", "name", "notifyOnChange", "onControllersChange", "oldControllers", "", "saveVariable", "variable", "setVariablesUpdatedCallback", "callback", "variablesList", "getAllNames", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class VariableMonitor {
    private Map<String, ? extends VariableController> controllerMap;
    private final Function1<Throwable, Unit> errorHandler;
    private final Map<Pair<String, String>, Variable> variables;
    private Function1<? super List<? extends Pair<String, ? extends Variable>>, Unit> variablesUpdatedCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public VariableMonitor(Function1<? super Throwable, Unit> errorHandler) {
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        this.errorHandler = errorHandler;
        this.variables = new LinkedHashMap();
        this.controllerMap = MapsKt.emptyMap();
    }

    public final Map<String, VariableController> getControllerMap() {
        return this.controllerMap;
    }

    public final void setControllerMap(Map<String, ? extends VariableController> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (hasAllPairs(this.controllerMap, value)) {
            return;
        }
        Set<? extends VariableController> set = CollectionsKt.toSet(this.controllerMap.values());
        this.controllerMap = value;
        onControllersChange(set);
    }

    public final void mutateVariable(String name, String path, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(value, "value");
        Variable variable = this.variables.get(TuplesKt.to(path, name));
        if (Intrinsics.areEqual(String.valueOf(variable != null ? variable.getValue() : null), value) || variable == null) {
            return;
        }
        try {
            variable.set(value);
        } catch (Exception unused) {
            this.errorHandler.invoke(new VariableMutationException("Unable to set '" + value + "' value to variable '" + name + "'.", null, 2, null));
        }
    }

    public final void setVariablesUpdatedCallback(Function1<? super List<? extends Pair<String, ? extends Variable>>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.variablesUpdatedCallback = callback;
        notifyOnChange();
    }

    private final void onControllersChange(Set<? extends VariableController> oldControllers) {
        Map<String, ? extends VariableController> map = this.controllerMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends VariableController> entry : map.entrySet()) {
            if (!oldControllers.contains(entry.getValue())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str = (String) entry2.getKey();
            VariableController variableController = (VariableController) entry2.getValue();
            VariableController.subscribeToVariablesChange$default(variableController, getAllNames(variableController), false, createCallback(str), 2, null);
        }
        this.variables.clear();
        for (Map.Entry<String, ? extends VariableController> entry3 : this.controllerMap.entrySet()) {
            String key = entry3.getKey();
            Iterator<T> it = entry3.getValue().captureAll().iterator();
            while (it.hasNext()) {
                saveVariable((Variable) it.next(), key);
            }
        }
        notifyOnChange();
    }

    private final Function1<Variable, Unit> createCallback(final String path) {
        return new Function1<Variable, Unit>() { // from class: com.yandex.div.core.view2.errors.VariableMonitor.createCallback.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Variable variable) {
                invoke2(variable);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Variable variable) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                VariableMonitor.this.saveVariable(variable, path);
                VariableMonitor.this.notifyOnChange();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyOnChange() {
        List<Pair<String, Variable>> listVariablesList = variablesList();
        Function1<? super List<? extends Pair<String, ? extends Variable>>, Unit> function1 = this.variablesUpdatedCallback;
        if (function1 != null) {
            function1.invoke(listVariablesList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveVariable(Variable variable, String path) {
        this.variables.put(TuplesKt.to(path, variable.getName()), variable);
    }

    private final List<Pair<String, Variable>> variablesList() {
        Map<Pair<String, String>, Variable> map = this.variables;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<Pair<String, String>, Variable>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(entriesToVariables(it.next()));
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.yandex.div.core.view2.errors.VariableMonitor$variablesList$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Pair pair = (Pair) t;
                Pair pair2 = (Pair) t2;
                return ComparisonsKt.compareValues(((String) pair.component1()) + ((Variable) pair.component2()).getName(), ((String) pair2.component1()) + ((Variable) pair2.component2()).getName());
            }
        });
    }

    private final Pair<String, Variable> entriesToVariables(Map.Entry<Pair<String, String>, ? extends Variable> entry) {
        Pair<String, String> key = entry.getKey();
        return TuplesKt.to(key.getFirst(), entry.getValue());
    }

    private final List<String> getAllNames(VariableController variableController) {
        List<Variable> listCaptureAll = variableController.captureAll();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listCaptureAll, 10));
        Iterator<T> it = listCaptureAll.iterator();
        while (it.hasNext()) {
            arrayList.add(((Variable) it.next()).getName());
        }
        return arrayList;
    }

    private final <K, V> boolean hasAllPairs(Map<K, ? extends V> map, Map<K, ? extends V> from) {
        if (from.isEmpty()) {
            return true;
        }
        for (Map.Entry<K, ? extends V> entry : from.entrySet()) {
            K key = entry.getKey();
            if (!Intrinsics.areEqual(map.get(key), entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
