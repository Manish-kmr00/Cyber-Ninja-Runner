package com.yandex.div.core.expression.variables;

import com.yandex.div.internal.parser.ListValidator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivVariablesParser.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
final class DivVariablesParserKt$sam$com_yandex_div_internal_parser_ListValidator$0 implements ListValidator, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    DivVariablesParserKt$sam$com_yandex_div_internal_parser_ListValidator$0(Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ListValidator) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.yandex.div.internal.parser.ListValidator
    public final /* synthetic */ boolean isValid(List list) {
        return ((Boolean) this.function.invoke(list)).booleanValue();
    }
}
