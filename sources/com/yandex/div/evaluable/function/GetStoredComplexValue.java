package com.yandex.div.evaluable.function;

import com.json.b9;
import com.yandex.div.evaluable.Evaluable;
import com.yandex.div.evaluable.EvaluableExceptionKt;
import com.yandex.div.evaluable.EvaluableType;
import com.yandex.div.evaluable.EvaluationContext;
import com.yandex.div.evaluable.Function;
import com.yandex.div.evaluable.FunctionArgument;
import java.math.BigDecimal;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: StoredValueFunctions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J3\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J.\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0002R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/yandex/div/evaluable/function/GetStoredComplexValue;", "T", "", "Lcom/yandex/div/evaluable/Function;", "()V", "declaredArgs", "", "Lcom/yandex/div/evaluable/FunctionArgument;", "getDeclaredArgs", "()Ljava/util/List;", "isPure", "", "()Z", "evaluate", "evaluationContext", "Lcom/yandex/div/evaluable/EvaluationContext;", "expressionContext", "Lcom/yandex/div/evaluable/ExpressionContext;", "args", "evaluate-ex6DHhM", "(Lcom/yandex/div/evaluable/EvaluationContext;Lcom/yandex/div/evaluable/Evaluable;Ljava/util/List;)Ljava/lang/Object;", "throwWrongTypeException", "", b9.f.b, "", "expected", "Lcom/yandex/div/evaluable/EvaluableType;", "actual", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class GetStoredComplexValue<T> extends Function {
    private final List<FunctionArgument> declaredArgs = CollectionsKt.listOf(new FunctionArgument(EvaluableType.STRING, false, 2, null));
    private final boolean isPure;

    @Override // com.yandex.div.evaluable.Function
    /* JADX INFO: renamed from: isPure, reason: from getter */
    public boolean getIsPure() {
        return this.isPure;
    }

    @Override // com.yandex.div.evaluable.Function
    public List<FunctionArgument> getDeclaredArgs() {
        return this.declaredArgs;
    }

    @Override // com.yandex.div.evaluable.Function
    /* JADX INFO: renamed from: evaluate-ex6DHhM */
    protected Object mo6115evaluateex6DHhM(EvaluationContext evaluationContext, Evaluable expressionContext, List<? extends Object> args) {
        Intrinsics.checkNotNullParameter(evaluationContext, "evaluationContext");
        Intrinsics.checkNotNullParameter(expressionContext, "expressionContext");
        Intrinsics.checkNotNullParameter(args, "args");
        Object obj = args.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        Object obj2 = evaluationContext.getStoredValueProvider().get((String) obj);
        if (obj2 == null) {
            EvaluableExceptionKt.throwExceptionOnFunctionEvaluationFailed$default(getName(), args, "Missing value.", null, 8, null);
            throw new KotlinNothingValueException();
        }
        if (obj2 != null) {
            return obj2;
        }
        throwWrongTypeException(getName(), args, getResultType(), obj2);
        throw new KotlinNothingValueException();
    }

    private final Void throwWrongTypeException(String functionName, List<? extends Object> args, EvaluableType expected, Object actual) {
        String simpleName;
        if (actual instanceof Integer ? true : actual instanceof Double ? true : actual instanceof BigDecimal) {
            simpleName = "Number";
        } else if (actual instanceof JSONObject) {
            simpleName = "Dict";
        } else {
            simpleName = actual instanceof JSONArray ? "Array" : actual.getClass().getSimpleName();
        }
        EvaluableExceptionKt.throwExceptionOnFunctionEvaluationFailed$default(functionName, args, "Incorrect value type: expected " + expected.getTypeName() + ", got " + simpleName + '.', null, 8, null);
        throw new KotlinNothingValueException();
    }
}
