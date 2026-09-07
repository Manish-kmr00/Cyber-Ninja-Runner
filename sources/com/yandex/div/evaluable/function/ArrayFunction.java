package com.yandex.div.evaluable.function;

import com.yandex.div.evaluable.EvaluableType;
import com.yandex.div.evaluable.Function;
import com.yandex.div.evaluable.FunctionArgument;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArrayFunctions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/evaluable/function/ArrayFunction;", "Lcom/yandex/div/evaluable/Function;", "resultType", "Lcom/yandex/div/evaluable/EvaluableType;", "(Lcom/yandex/div/evaluable/EvaluableType;)V", "declaredArgs", "", "Lcom/yandex/div/evaluable/FunctionArgument;", "getDeclaredArgs", "()Ljava/util/List;", "isMethod", "", "()Z", "isPure", "getResultType", "()Lcom/yandex/div/evaluable/EvaluableType;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class ArrayFunction extends Function {
    private final List<FunctionArgument> declaredArgs;
    private final boolean isMethod;
    private final boolean isPure;
    private final EvaluableType resultType;

    @Override // com.yandex.div.evaluable.Function
    public final EvaluableType getResultType() {
        return this.resultType;
    }

    public ArrayFunction(EvaluableType resultType) {
        Intrinsics.checkNotNullParameter(resultType, "resultType");
        this.resultType = resultType;
        int i = 2;
        boolean z = false;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.declaredArgs = CollectionsKt.listOf((Object[]) new FunctionArgument[]{new FunctionArgument(EvaluableType.ARRAY, z, i, defaultConstructorMarker), new FunctionArgument(EvaluableType.INTEGER, z, i, defaultConstructorMarker)});
    }

    @Override // com.yandex.div.evaluable.Function
    public List<FunctionArgument> getDeclaredArgs() {
        return this.declaredArgs;
    }

    @Override // com.yandex.div.evaluable.Function
    /* JADX INFO: renamed from: isPure, reason: from getter */
    public boolean getIsPure() {
        return this.isPure;
    }

    /* JADX INFO: renamed from: isMethod, reason: from getter */
    public boolean getIsMethod() {
        return this.isMethod;
    }
}
