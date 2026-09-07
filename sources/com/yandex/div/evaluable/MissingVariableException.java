package com.yandex.div.evaluable;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluableException.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/yandex/div/evaluable/MissingVariableException;", "Lcom/yandex/div/evaluable/EvaluableException;", "variableName", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/Exception;)V", "getVariableName", "()Ljava/lang/String;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MissingVariableException extends EvaluableException {
    private final String variableName;

    public /* synthetic */ MissingVariableException(String str, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : exc);
    }

    public final String getVariableName() {
        return this.variableName;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingVariableException(String variableName, Exception exc) {
        super("Variable '" + variableName + "' is missing.", exc);
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        this.variableName = variableName;
    }
}
