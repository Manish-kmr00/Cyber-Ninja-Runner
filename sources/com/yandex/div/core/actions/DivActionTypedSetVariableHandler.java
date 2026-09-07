package com.yandex.div.core.actions;

import android.net.Uri;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.data.Variable;
import com.yandex.div.evaluable.types.Color;
import com.yandex.div.internal.core.VariableMutationHandler;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivActionTyped;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivActionTypedSetVariableHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Singleton
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082\b¢\u0006\u0002\u0010\u000bJ*\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/core/actions/DivActionTypedSetVariableHandler;", "Lcom/yandex/div/core/actions/DivActionTypedHandler;", "()V", "checkValueAndCast", "T", "", "newValue", "view", "Lcom/yandex/div/core/view2/Div2View;", "variableName", "", "(Ljava/lang/Object;Lcom/yandex/div/core/view2/Div2View;Ljava/lang/String;)Ljava/lang/Object;", "handleAction", "", "scopeId", "action", "Lcom/yandex/div2/DivActionTyped;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "handleSetVariable", "", "Lcom/yandex/div2/DivActionTyped$SetVariable;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedSetVariableHandler implements DivActionTypedHandler {
    @Inject
    public DivActionTypedSetVariableHandler() {
    }

    @Override // com.yandex.div.core.actions.DivActionTypedHandler
    public boolean handleAction(String scopeId, DivActionTyped action, Div2View view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (!(action instanceof DivActionTyped.SetVariable)) {
            return false;
        }
        handleSetVariable((DivActionTyped.SetVariable) action, view, resolver);
        return true;
    }

    private final void handleSetVariable(DivActionTyped.SetVariable action, final Div2View view, ExpressionResolver resolver) {
        final String strEvaluate = action.getValue().variableName.evaluate(resolver);
        final Object objEvaluate = DivActionTypedUtilsKt.evaluate(action.getValue().value, resolver);
        VariableMutationHandler.INSTANCE.setVariable(view, strEvaluate, resolver, new Function1<Variable, Variable>() { // from class: com.yandex.div.core.actions.DivActionTypedSetVariableHandler.handleSetVariable.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Variable invoke(Variable variable) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                Object obj = objEvaluate;
                Div2View div2View = view;
                String str = strEvaluate;
                String lowerCase = "array";
                if (!(variable instanceof Variable.ArrayVariable)) {
                    if (!(variable instanceof Variable.BooleanVariable)) {
                        if (!(variable instanceof Variable.ColorVariable)) {
                            if (!(variable instanceof Variable.DictVariable)) {
                                if (!(variable instanceof Variable.DoubleVariable)) {
                                    if (!(variable instanceof Variable.IntegerVariable)) {
                                        if (!(variable instanceof Variable.StringVariable)) {
                                            if (variable instanceof Variable.UrlVariable) {
                                                Uri uri = (Uri) (obj instanceof Uri ? obj : null);
                                                if (uri == null) {
                                                    if (obj instanceof Integer ? true : obj instanceof Double) {
                                                        lowerCase = "number";
                                                    } else if (obj instanceof JSONObject) {
                                                        lowerCase = "dict";
                                                    } else if (!(obj instanceof JSONArray)) {
                                                        String simpleName = obj.getClass().getSimpleName();
                                                        Intrinsics.checkNotNullExpressionValue(simpleName, "newValue.javaClass.simpleName");
                                                        lowerCase = simpleName.toLowerCase(Locale.ROOT);
                                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                                    }
                                                    DivActionTypedUtilsKt.logError(div2View, new IllegalArgumentException("Trying to set value with invalid type (" + lowerCase + ") to variable " + str));
                                                }
                                                if (uri != null) {
                                                    ((Variable.UrlVariable) variable).set(uri);
                                                }
                                            }
                                        } else {
                                            String str2 = (String) (obj instanceof String ? obj : null);
                                            if (str2 == null) {
                                                if (obj instanceof Integer ? true : obj instanceof Double) {
                                                    lowerCase = "number";
                                                } else if (obj instanceof JSONObject) {
                                                    lowerCase = "dict";
                                                } else if (!(obj instanceof JSONArray)) {
                                                    String simpleName2 = obj.getClass().getSimpleName();
                                                    Intrinsics.checkNotNullExpressionValue(simpleName2, "newValue.javaClass.simpleName");
                                                    lowerCase = simpleName2.toLowerCase(Locale.ROOT);
                                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                                }
                                                DivActionTypedUtilsKt.logError(div2View, new IllegalArgumentException("Trying to set value with invalid type (" + lowerCase + ") to variable " + str));
                                            }
                                            if (str2 != null) {
                                                variable.set(str2);
                                            }
                                        }
                                    } else {
                                        Long l = (Long) (obj instanceof Long ? obj : null);
                                        if (l == null) {
                                            if (obj instanceof Integer ? true : obj instanceof Double) {
                                                lowerCase = "number";
                                            } else if (obj instanceof JSONObject) {
                                                lowerCase = "dict";
                                            } else if (!(obj instanceof JSONArray)) {
                                                String simpleName3 = obj.getClass().getSimpleName();
                                                Intrinsics.checkNotNullExpressionValue(simpleName3, "newValue.javaClass.simpleName");
                                                lowerCase = simpleName3.toLowerCase(Locale.ROOT);
                                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                            }
                                            DivActionTypedUtilsKt.logError(div2View, new IllegalArgumentException("Trying to set value with invalid type (" + lowerCase + ") to variable " + str));
                                        }
                                        if (l != null) {
                                            ((Variable.IntegerVariable) variable).set(l.longValue());
                                        }
                                    }
                                } else {
                                    boolean z = obj instanceof Double;
                                    Double d = (Double) (z ? obj : null);
                                    if (d == null) {
                                        if (obj instanceof Integer ? true : z) {
                                            lowerCase = "number";
                                        } else if (obj instanceof JSONObject) {
                                            lowerCase = "dict";
                                        } else if (!(obj instanceof JSONArray)) {
                                            String simpleName4 = obj.getClass().getSimpleName();
                                            Intrinsics.checkNotNullExpressionValue(simpleName4, "newValue.javaClass.simpleName");
                                            lowerCase = simpleName4.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                        }
                                        DivActionTypedUtilsKt.logError(div2View, new IllegalArgumentException("Trying to set value with invalid type (" + lowerCase + ") to variable " + str));
                                    }
                                    if (d != null) {
                                        ((Variable.DoubleVariable) variable).set(d.doubleValue());
                                    }
                                }
                            } else {
                                boolean z2 = obj instanceof JSONObject;
                                JSONObject jSONObject = (JSONObject) (z2 ? obj : null);
                                if (jSONObject == null) {
                                    if (obj instanceof Integer ? true : obj instanceof Double) {
                                        lowerCase = "number";
                                    } else if (z2) {
                                        lowerCase = "dict";
                                    } else if (!(obj instanceof JSONArray)) {
                                        String simpleName5 = obj.getClass().getSimpleName();
                                        Intrinsics.checkNotNullExpressionValue(simpleName5, "newValue.javaClass.simpleName");
                                        lowerCase = simpleName5.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    }
                                    DivActionTypedUtilsKt.logError(div2View, new IllegalArgumentException("Trying to set value with invalid type (" + lowerCase + ") to variable " + str));
                                }
                                if (jSONObject != null) {
                                    ((Variable.DictVariable) variable).set(jSONObject);
                                }
                            }
                        } else {
                            boolean z3 = obj instanceof Integer;
                            Integer num = (Integer) (z3 ? obj : null);
                            if (num == null) {
                                if (z3 ? true : obj instanceof Double) {
                                    lowerCase = "number";
                                } else if (obj instanceof JSONObject) {
                                    lowerCase = "dict";
                                } else if (!(obj instanceof JSONArray)) {
                                    String simpleName6 = obj.getClass().getSimpleName();
                                    Intrinsics.checkNotNullExpressionValue(simpleName6, "newValue.javaClass.simpleName");
                                    lowerCase = simpleName6.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                }
                                DivActionTypedUtilsKt.logError(div2View, new IllegalArgumentException("Trying to set value with invalid type (" + lowerCase + ") to variable " + str));
                            }
                            if (num != null) {
                                ((Variable.ColorVariable) variable).m6161setcIhhviA(Color.m6218constructorimpl(num.intValue()));
                            }
                        }
                    } else {
                        Boolean bool = (Boolean) (obj instanceof Boolean ? obj : null);
                        if (bool == null) {
                            if (obj instanceof Integer ? true : obj instanceof Double) {
                                lowerCase = "number";
                            } else if (obj instanceof JSONObject) {
                                lowerCase = "dict";
                            } else if (!(obj instanceof JSONArray)) {
                                String simpleName7 = obj.getClass().getSimpleName();
                                Intrinsics.checkNotNullExpressionValue(simpleName7, "newValue.javaClass.simpleName");
                                lowerCase = simpleName7.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            }
                            DivActionTypedUtilsKt.logError(div2View, new IllegalArgumentException("Trying to set value with invalid type (" + lowerCase + ") to variable " + str));
                        }
                        if (bool != null) {
                            ((Variable.BooleanVariable) variable).set(bool.booleanValue());
                        }
                    }
                } else {
                    boolean z4 = obj instanceof JSONArray;
                    JSONArray jSONArray = (JSONArray) (z4 ? obj : null);
                    if (jSONArray == null) {
                        if (obj instanceof Integer ? true : obj instanceof Double) {
                            lowerCase = "number";
                        } else if (obj instanceof JSONObject) {
                            lowerCase = "dict";
                        } else if (!z4) {
                            String simpleName8 = obj.getClass().getSimpleName();
                            Intrinsics.checkNotNullExpressionValue(simpleName8, "newValue.javaClass.simpleName");
                            lowerCase = simpleName8.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        }
                        DivActionTypedUtilsKt.logError(div2View, new IllegalArgumentException("Trying to set value with invalid type (" + lowerCase + ") to variable " + str));
                    }
                    if (jSONArray != null) {
                        ((Variable.ArrayVariable) variable).set(jSONArray);
                    }
                }
                return variable;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final /* synthetic */ <T> T checkValueAndCast(Object newValue, Div2View view, String variableName) {
        String lowerCase;
        Intrinsics.reifiedOperationMarker(2, "T");
        if (newValue == 0) {
            if (newValue instanceof Integer ? true : newValue instanceof Double) {
                lowerCase = "number";
            } else if (newValue instanceof JSONObject) {
                lowerCase = "dict";
            } else if (newValue instanceof JSONArray) {
                lowerCase = "array";
            } else {
                String simpleName = newValue.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "newValue.javaClass.simpleName");
                lowerCase = simpleName.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            }
            DivActionTypedUtilsKt.logError(view, new IllegalArgumentException("Trying to set value with invalid type (" + lowerCase + ") to variable " + variableName));
        }
        return newValue;
    }
}
