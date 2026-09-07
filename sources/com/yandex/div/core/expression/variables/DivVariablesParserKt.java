package com.yandex.div.core.expression.variables;

import com.yandex.div.data.Variable;
import com.yandex.div2.DivVariable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivVariablesParser.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toVariable", "Lcom/yandex/div/data/Variable;", "Lcom/yandex/div2/DivVariable;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivVariablesParserKt {
    public static final Variable toVariable(DivVariable divVariable) {
        Intrinsics.checkNotNullParameter(divVariable, "<this>");
        if (divVariable instanceof DivVariable.Bool) {
            DivVariable.Bool bool = (DivVariable.Bool) divVariable;
            return new Variable.BooleanVariable(bool.getValue().name, bool.getValue().value);
        }
        if (divVariable instanceof DivVariable.Integer) {
            DivVariable.Integer integer = (DivVariable.Integer) divVariable;
            return new Variable.IntegerVariable(integer.getValue().name, integer.getValue().value);
        }
        if (divVariable instanceof DivVariable.Number) {
            DivVariable.Number number = (DivVariable.Number) divVariable;
            return new Variable.DoubleVariable(number.getValue().name, number.getValue().value);
        }
        if (divVariable instanceof DivVariable.Str) {
            DivVariable.Str str = (DivVariable.Str) divVariable;
            return new Variable.StringVariable(str.getValue().name, str.getValue().value);
        }
        if (divVariable instanceof DivVariable.Color) {
            DivVariable.Color color = (DivVariable.Color) divVariable;
            return new Variable.ColorVariable(color.getValue().name, color.getValue().value);
        }
        if (divVariable instanceof DivVariable.Url) {
            DivVariable.Url url = (DivVariable.Url) divVariable;
            return new Variable.UrlVariable(url.getValue().name, url.getValue().value);
        }
        if (divVariable instanceof DivVariable.Dict) {
            DivVariable.Dict dict = (DivVariable.Dict) divVariable;
            return new Variable.DictVariable(dict.getValue().name, dict.getValue().value);
        }
        if (!(divVariable instanceof DivVariable.Array)) {
            throw new NoWhenBranchMatchedException();
        }
        DivVariable.Array array = (DivVariable.Array) divVariable;
        return new Variable.ArrayVariable(array.getValue().name, array.getValue().value);
    }
}
