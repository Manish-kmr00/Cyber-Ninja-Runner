package com.yandex.div.core.actions;

import com.yandex.div.core.view2.Div2View;
import com.yandex.div.data.Variable;
import com.yandex.div.internal.core.VariableMutationHandler;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivActionDictSetValue;
import com.yandex.div2.DivActionTyped;
import com.yandex.div2.DivTypedValue;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivActionTypedDictSetValueHandler.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/actions/DivActionTypedDictSetValueHandler;", "Lcom/yandex/div/core/actions/DivActionTypedHandler;", "()V", "handleAction", "", "scopeId", "", "action", "Lcom/yandex/div2/DivActionTyped;", "view", "Lcom/yandex/div/core/view2/Div2View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "handleSetValue", "", "Lcom/yandex/div2/DivActionDictSetValue;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedDictSetValueHandler implements DivActionTypedHandler {
    @Inject
    public DivActionTypedDictSetValueHandler() {
    }

    @Override // com.yandex.div.core.actions.DivActionTypedHandler
    public boolean handleAction(String scopeId, DivActionTyped action, Div2View view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (!(action instanceof DivActionTyped.DictSetValue)) {
            return false;
        }
        handleSetValue(((DivActionTyped.DictSetValue) action).getValue(), view, resolver);
        return true;
    }

    private final void handleSetValue(DivActionDictSetValue action, final Div2View view, ExpressionResolver resolver) {
        String strEvaluate = action.variableName.evaluate(resolver);
        final String strEvaluate2 = action.key.evaluate(resolver);
        DivTypedValue divTypedValue = action.value;
        final Object objEvaluate = divTypedValue != null ? DivActionTypedUtilsKt.evaluate(divTypedValue, resolver) : null;
        VariableMutationHandler.INSTANCE.setVariable(view, strEvaluate, resolver, new Function1<Variable, Variable>() { // from class: com.yandex.div.core.actions.DivActionTypedDictSetValueHandler.handleSetValue.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Variable invoke(Variable variable) throws JSONException {
                Intrinsics.checkNotNullParameter(variable, "variable");
                if (!(variable instanceof Variable.DictVariable)) {
                    DivActionTypedUtilsKt.logError(view, new IllegalArgumentException("dict_set_value action requires dict variable"));
                    return variable;
                }
                Object value = variable.getValue();
                JSONObject jSONObject = value instanceof JSONObject ? (JSONObject) value : null;
                if (jSONObject != null) {
                    JSONObject jSONObjectClone = DivActionTypedDictSetValueHandlerKt.clone(jSONObject);
                    Object obj = objEvaluate;
                    if (obj == null) {
                        jSONObjectClone.remove(strEvaluate2);
                        ((Variable.DictVariable) variable).set(jSONObjectClone);
                    } else {
                        JSONObject jSONObjectPut = jSONObjectClone.put(strEvaluate2, obj);
                        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "newDict.put(key, newValue)");
                        ((Variable.DictVariable) variable).set(jSONObjectPut);
                    }
                    return variable;
                }
                DivActionTypedUtilsKt.logError(view, new IllegalArgumentException("Invalid variable value"));
                return variable;
            }
        });
    }
}
