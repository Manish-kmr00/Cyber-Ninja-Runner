package com.yandex.div.evaluable;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalFunctionProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J+\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\fH\u0002J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\u0016J\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/evaluable/LocalFunctionProvider;", "Lcom/yandex/div/evaluable/FunctionProvider;", "functions", "", "Lcom/yandex/div/evaluable/Function;", "(Ljava/util/List;)V", "findFunction", "name", "", "matcher", "Lkotlin/Function1;", "Lcom/yandex/div/evaluable/Function$MatchResult;", "Lkotlin/ExtensionFunctionType;", "get", "args", "Lcom/yandex/div/evaluable/EvaluableType;", "getMethod", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LocalFunctionProvider implements FunctionProvider {
    private final List<Function> functions;

    /* JADX WARN: Multi-variable type inference failed */
    public LocalFunctionProvider(List<? extends Function> functions) {
        Intrinsics.checkNotNullParameter(functions, "functions");
        this.functions = functions;
    }

    @Override // com.yandex.div.evaluable.FunctionProvider
    public Function get(String name, final List<? extends EvaluableType> args) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        Function functionFindFunction = findFunction(name, new Function1<Function, Function.MatchResult>() { // from class: com.yandex.div.evaluable.LocalFunctionProvider.get.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Function.MatchResult invoke(Function findFunction) {
                Intrinsics.checkNotNullParameter(findFunction, "$this$findFunction");
                return findFunction.matchesArguments$div_evaluable(args);
            }
        });
        if (functionFindFunction != null) {
            return functionFindFunction;
        }
        Function functionFindFunction2 = findFunction(name, new Function1<Function, Function.MatchResult>() { // from class: com.yandex.div.evaluable.LocalFunctionProvider.get.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Function.MatchResult invoke(Function findFunction) {
                Intrinsics.checkNotNullParameter(findFunction, "$this$findFunction");
                return findFunction.matchesArgumentsWithCast$div_evaluable(args);
            }
        });
        if (functionFindFunction2 != null) {
            return functionFindFunction2;
        }
        throw new MissingLocalFunctionException(name, args);
    }

    @Override // com.yandex.div.evaluable.FunctionProvider
    public Function getMethod(String name, final List<? extends EvaluableType> args) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        Function functionFindFunction = findFunction(name, new Function1<Function, Function.MatchResult>() { // from class: com.yandex.div.evaluable.LocalFunctionProvider.getMethod.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Function.MatchResult invoke(Function findFunction) {
                Intrinsics.checkNotNullParameter(findFunction, "$this$findFunction");
                return findFunction.matchesArguments$div_evaluable(args);
            }
        });
        if (functionFindFunction != null) {
            return functionFindFunction;
        }
        Function functionFindFunction2 = findFunction(name, new Function1<Function, Function.MatchResult>() { // from class: com.yandex.div.evaluable.LocalFunctionProvider.getMethod.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Function.MatchResult invoke(Function findFunction) {
                Intrinsics.checkNotNullParameter(findFunction, "$this$findFunction");
                return findFunction.matchesArgumentsWithCast$div_evaluable(args);
            }
        });
        if (functionFindFunction2 != null) {
            return functionFindFunction2;
        }
        throw new MissingLocalFunctionException(name, args);
    }

    private final Function findFunction(String name, Function1<? super Function, ? extends Function.MatchResult> matcher) {
        List<Function> list = this.functions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Function function = (Function) obj;
            if (Intrinsics.areEqual(function.getName(), name) && Intrinsics.areEqual(matcher.invoke(function), Function.MatchResult.Ok.INSTANCE)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return (Function) arrayList2.get(0);
        }
        throw new EvaluableException("Function " + arrayList2.get(0) + " declared multiple times.", null, 2, null);
    }
}
