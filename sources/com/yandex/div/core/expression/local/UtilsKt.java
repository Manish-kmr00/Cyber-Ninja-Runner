package com.yandex.div.core.expression.local;

import com.yandex.div.data.Variable;
import com.yandex.div2.Div;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivFunction;
import com.yandex.div2.DivTrigger;
import com.yandex.div2.DivVariable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2 = {"needLocalRuntime", "", "Lcom/yandex/div2/Div;", "getNeedLocalRuntime", "(Lcom/yandex/div2/Div;)Z", "variables", "", "Lcom/yandex/div/data/Variable;", "variableTriggers", "Lcom/yandex/div2/DivTrigger;", "functions", "Lcom/yandex/div2/DivFunction;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class UtilsKt {
    public static final boolean getNeedLocalRuntime(Div div) {
        List<DivTrigger> variableTriggers;
        List<DivFunction> functions;
        Intrinsics.checkNotNullParameter(div, "<this>");
        DivBase divBaseValue = div.value();
        List<DivVariable> variables = divBaseValue.getVariables();
        return !((variables == null || variables.isEmpty()) && ((variableTriggers = divBaseValue.getVariableTriggers()) == null || variableTriggers.isEmpty()) && ((functions = divBaseValue.getFunctions()) == null || functions.isEmpty()));
    }

    public static final boolean needLocalRuntime(List<? extends Variable> list, List<DivTrigger> list2, List<DivFunction> list3) {
        List<DivTrigger> list4;
        List<DivFunction> list5;
        List<? extends Variable> list6 = list;
        return ((list6 == null || list6.isEmpty()) && ((list4 = list2) == null || list4.isEmpty()) && ((list5 = list3) == null || list5.isEmpty())) ? false : true;
    }
}
