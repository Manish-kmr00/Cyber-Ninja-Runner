package com.yandex.div.core.expression;

import com.yandex.div2.DivVariable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: ExpressionsRuntimeProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"name", "", "Lcom/yandex/div2/DivVariable;", "getName", "(Lcom/yandex/div2/DivVariable;)Ljava/lang/String;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ExpressionsRuntimeProviderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String getName(DivVariable divVariable) {
        if (divVariable instanceof DivVariable.Bool) {
            return ((DivVariable.Bool) divVariable).getValue().name;
        }
        if (divVariable instanceof DivVariable.Integer) {
            return ((DivVariable.Integer) divVariable).getValue().name;
        }
        if (divVariable instanceof DivVariable.Number) {
            return ((DivVariable.Number) divVariable).getValue().name;
        }
        if (divVariable instanceof DivVariable.Str) {
            return ((DivVariable.Str) divVariable).getValue().name;
        }
        if (divVariable instanceof DivVariable.Color) {
            return ((DivVariable.Color) divVariable).getValue().name;
        }
        if (divVariable instanceof DivVariable.Url) {
            return ((DivVariable.Url) divVariable).getValue().name;
        }
        if (divVariable instanceof DivVariable.Dict) {
            return ((DivVariable.Dict) divVariable).getValue().name;
        }
        if (divVariable instanceof DivVariable.Array) {
            return ((DivVariable.Array) divVariable).getValue().name;
        }
        throw new NoWhenBranchMatchedException();
    }
}
