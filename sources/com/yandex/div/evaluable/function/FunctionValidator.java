package com.yandex.div.evaluable.function;

import com.yandex.div.evaluable.EvaluableException;
import com.yandex.div.evaluable.Function;
import com.yandex.div.evaluable.FunctionArgument;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FunctionValidator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t¨\u0006\n"}, d2 = {"Lcom/yandex/div/evaluable/function/FunctionValidator;", "", "()V", "validateFunction", "Lcom/yandex/div/evaluable/Function;", "function", "validateOverloading", "nonValidatedFunction", "overloadedFunctions", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FunctionValidator {
    public static final FunctionValidator INSTANCE = new FunctionValidator();

    private FunctionValidator() {
    }

    public final Function validateFunction(Function function) {
        Intrinsics.checkNotNullParameter(function, "function");
        List<FunctionArgument> declaredArgs = function.getDeclaredArgs();
        int lastIndex = CollectionsKt.getLastIndex(declaredArgs);
        for (int i = 0; i < lastIndex; i++) {
            if (declaredArgs.get(i).isVariadic()) {
                throw new EvaluableException("Variadic argument allowed at the end of list only", null, 2, null);
            }
        }
        return function;
    }

    public final Function validateOverloading(Function nonValidatedFunction, List<? extends Function> overloadedFunctions) {
        Intrinsics.checkNotNullParameter(nonValidatedFunction, "nonValidatedFunction");
        Intrinsics.checkNotNullParameter(overloadedFunctions, "overloadedFunctions");
        for (Function function : overloadedFunctions) {
            if (FunctionValidatorKt.conflictsWith(nonValidatedFunction, function)) {
                throw new EvaluableException("Function " + nonValidatedFunction + " has conflict with " + function, null, 2, null);
            }
        }
        return nonValidatedFunction;
    }
}
