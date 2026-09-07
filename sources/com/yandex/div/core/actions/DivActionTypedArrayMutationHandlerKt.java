package com.yandex.div.core.actions;

import com.yandex.div.core.view2.Div2View;
import com.yandex.div.data.Variable;
import com.yandex.div.internal.core.VariableMutationHandler;
import com.yandex.div.internal.util.JsonUtilsKt;
import com.yandex.div.json.expressions.ExpressionResolver;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: compiled from: DivActionTypedArrayMutationHandler.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u001d\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u0007H\u0002\u001a0\u0010\b\u001a\u00020\u0006*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003H\u0002¨\u0006\u000f"}, d2 = {"mutate", "Lorg/json/JSONArray;", "action", "Lkotlin/Function1;", "", "", "", "Lkotlin/ExtensionFunctionType;", "updateVariable", "Lcom/yandex/div/core/view2/Div2View;", "name", "", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "valueMutation", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedArrayMutationHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray mutate(JSONArray jSONArray, Function1<? super List<Object>, Unit> function1) {
        List mutableList = CollectionsKt.toMutableList((Collection) JsonUtilsKt.asList(jSONArray));
        function1.invoke(mutableList);
        return new JSONArray((Collection) mutableList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateVariable(final Div2View div2View, String str, ExpressionResolver expressionResolver, final Function1<? super JSONArray, ? extends JSONArray> function1) {
        VariableMutationHandler.INSTANCE.setVariable(div2View, str, expressionResolver, new Function1<Variable, Variable>() { // from class: com.yandex.div.core.actions.DivActionTypedArrayMutationHandlerKt.updateVariable.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Variable invoke(Variable variable) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                if (!(variable instanceof Variable.ArrayVariable)) {
                    DivActionTypedUtilsKt.logError(div2View.getView(), new IllegalArgumentException("Action requires array variable"));
                    return variable;
                }
                Object value = variable.getValue();
                JSONArray jSONArray = value instanceof JSONArray ? (JSONArray) value : null;
                if (jSONArray == null) {
                    DivActionTypedUtilsKt.logError(div2View.getView(), new IllegalArgumentException("Invalid variable value"));
                    return variable;
                }
                ((Variable.ArrayVariable) variable).set(function1.invoke(jSONArray));
                return variable;
            }
        });
    }
}
