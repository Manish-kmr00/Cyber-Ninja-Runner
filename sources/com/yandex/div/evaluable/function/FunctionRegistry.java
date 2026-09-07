package com.yandex.div.evaluable.function;

import com.yandex.div.evaluable.EvaluableException;
import com.yandex.div.evaluable.EvaluableType;
import com.yandex.div.evaluable.Function;
import com.yandex.div.evaluable.FunctionArgument;
import com.yandex.div.evaluable.FunctionProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FunctionRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013H\u0016J&\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013H\u0016J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0007J\u001e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/yandex/div/evaluable/function/FunctionRegistry;", "Lcom/yandex/div/evaluable/FunctionProvider;", "()V", "exposedFunctions", "", "", "", "Lcom/yandex/div/evaluable/Function;", "getExposedFunctions", "()Ljava/util/Map;", "exposedMethods", "getExposedMethods", "knownFunctions", "", "knownMethods", "ensureRegistered", "", "name", "args", "", "Lcom/yandex/div/evaluable/FunctionArgument;", "resultType", "Lcom/yandex/div/evaluable/EvaluableType;", "isMethod", "", "get", "getMethod", "register", "function", "registerMethod", "method", "validateFunction", "overloadedFunctions", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FunctionRegistry implements FunctionProvider {
    private final Map<String, List<Function>> knownFunctions = new LinkedHashMap();
    private final Map<String, List<Function>> knownMethods = new LinkedHashMap();

    public final Map<String, List<Function>> getExposedFunctions() {
        return this.knownFunctions;
    }

    public final Map<String, List<Function>> getExposedMethods() {
        return this.knownMethods;
    }

    public final void register(Function function) {
        Intrinsics.checkNotNullParameter(function, "function");
        Map<String, List<Function>> map = this.knownFunctions;
        String name = function.getName();
        ArrayList arrayList = map.get(name);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(name, arrayList);
        }
        List<Function> list = arrayList;
        if (list.contains(function)) {
            return;
        }
        list.add(validateFunction(function, list));
    }

    public final void registerMethod(Function method) {
        Intrinsics.checkNotNullParameter(method, "method");
        Map<String, List<Function>> map = this.knownMethods;
        String name = method.getName();
        ArrayList arrayList = map.get(name);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(name, arrayList);
        }
        List<Function> list = arrayList;
        if (list.contains(method)) {
            return;
        }
        list.add(validateFunction(method, list));
    }

    private final Function validateFunction(Function function, List<? extends Function> overloadedFunctions) {
        return FunctionValidator.INSTANCE.validateOverloading(FunctionValidator.INSTANCE.validateFunction(function), overloadedFunctions);
    }

    @Override // com.yandex.div.evaluable.FunctionProvider
    public Function get(String name, List<? extends EvaluableType> args) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        return get(name, args, false);
    }

    @Override // com.yandex.div.evaluable.FunctionProvider
    public Function getMethod(String name, List<? extends EvaluableType> args) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        return get(name, args, true);
    }

    public final void ensureRegistered(String name, List<FunctionArgument> args, EvaluableType resultType, boolean isMethod) {
        List<Function> list;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(resultType, "resultType");
        if (isMethod) {
            List<Function> list2 = this.knownMethods.get(name);
            if (list2 == null) {
                throw new EvaluableException("Unknown method name: '" + name + "'.", null, 2, null);
            }
            list = list2;
        } else {
            List<Function> list3 = this.knownFunctions.get(name);
            if (list3 != null) {
                list = list3;
            } else {
                throw new EvaluableException("Unknown function name: '" + name + "'.", null, 2, null);
            }
        }
        List<Function> list4 = list;
        boolean z = list4 instanceof Collection;
        if (!z || !list4.isEmpty()) {
            Iterator<T> it = list4.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((Function) it.next()).getDeclaredArgs(), args)) {
                    if (!z || !list4.isEmpty()) {
                        Iterator<T> it2 = list4.iterator();
                        while (it2.hasNext()) {
                            if (((Function) it2.next()).getResultType() == resultType) {
                                return;
                            }
                        }
                    }
                    throw new EvaluableException("Function with specified result type is not registered.", null, 2, null);
                }
            }
        }
        throw new EvaluableException("Function with declared args is not registered.", null, 2, null);
    }

    private final Function get(String name, List<? extends EvaluableType> args, boolean isMethod) throws Exception {
        List<Function> list;
        Object next;
        Object obj = null;
        if (isMethod) {
            List<Function> list2 = this.knownMethods.get(name);
            if (list2 == null) {
                throw new EvaluableException("Unknown method name: " + name + '.', null, 2, null);
            }
            list = list2;
        } else {
            List<Function> list3 = this.knownFunctions.get(name);
            if (list3 == null) {
                throw new EvaluableException("Unknown function name: " + name + '.', null, 2, null);
            }
            list = list3;
        }
        if (list.size() == 1) {
            return FunctionValidatorKt.withArgumentsValidation((Function) CollectionsKt.first((List) list), args);
        }
        List<Function> list4 = list;
        Iterator<T> it = list4.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((Function) next).matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE));
        Function function = (Function) next;
        if (function != null) {
            return function;
        }
        Iterator<T> it2 = list4.iterator();
        boolean z = false;
        Object obj2 = null;
        while (true) {
            if (!it2.hasNext()) {
                if (!z) {
                    break;
                }
                obj = obj2;
                break;
            }
            Object next2 = it2.next();
            if (Intrinsics.areEqual(((Function) next2).matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                if (z) {
                    break;
                }
                z = true;
                obj2 = next2;
            }
        }
        Function function2 = (Function) obj;
        if (function2 != null) {
            return function2;
        }
        throw FunctionValidatorKt.getFunctionArgumentsException(name, args, isMethod);
    }
}
