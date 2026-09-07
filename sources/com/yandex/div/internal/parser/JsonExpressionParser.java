package com.yandex.div.internal.parser;

import com.json.b9;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.ParsingExceptionKt;
import com.yandex.div.json.expressions.ConstantExpressionList;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.json.expressions.MutableExpressionList;
import com.yandex.div.serialization.ParsingContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class JsonExpressionParser {
    private static final ExpressionList<?> EMPTY_EXPRESSION_LIST = new ConstantExpressionList(Collections.emptyList());

    private JsonExpressionParser() {
    }

    public static <V> Expression<V> readExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper) {
        return readExpression(parsingContext, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), JsonParsers.alwaysValid());
    }

    public static <R, V> Expression<V> readExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1) {
        return readExpression(parsingContext, jSONObject, str, typeHelper, function1, JsonParsers.alwaysValid());
    }

    public static <V> Expression<V> readExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, ValueValidator<V> valueValidator) {
        return readExpression(parsingContext, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), valueValidator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> Expression<V> readExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ValueValidator<V> valueValidator) {
        Object objOptSafe = optSafe(jSONObject, str);
        if (objOptSafe == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        if (Expression.mayBeExpression(objOptSafe)) {
            return new Expression.MutableExpression(str, objOptSafe.toString(), function1, valueValidator, parsingContext.getLogger(), typeHelper, null);
        }
        try {
            V vInvoke = function1.invoke(objOptSafe);
            if (vInvoke == null) {
                throw ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe);
            }
            if (!typeHelper.isTypeValid(vInvoke)) {
                throw ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe);
            }
            try {
                if (!valueValidator.isValid(vInvoke)) {
                    throw ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe);
                }
                return Expression.constant(vInvoke);
            } catch (ClassCastException unused) {
                throw ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe);
            }
        } catch (ClassCastException unused2) {
            throw ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe);
        } catch (Exception e) {
            throw ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe, e);
        }
    }

    public static Expression<String> readOptionalExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<String> typeHelper) {
        return readOptionalExpression(parsingContext, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), JsonParsers.alwaysValidString(), null);
    }

    public static <V> Expression<V> readOptionalExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Expression<V> expression) {
        return readOptionalExpression(parsingContext, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), JsonParsers.alwaysValid(), expression);
    }

    public static <R, V> Expression<V> readOptionalExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1) {
        return readOptionalExpression(parsingContext, jSONObject, str, typeHelper, function1, JsonParsers.alwaysValid(), null);
    }

    public static <R, V> Expression<V> readOptionalExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, Expression<V> expression) {
        return readOptionalExpression(parsingContext, jSONObject, str, typeHelper, function1, JsonParsers.alwaysValid(), expression);
    }

    public static <V> Expression<V> readOptionalExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, ValueValidator<V> valueValidator) {
        return readOptionalExpression(parsingContext, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), valueValidator, null);
    }

    public static <V> Expression<V> readOptionalExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, ValueValidator<V> valueValidator, Expression<V> expression) {
        return readOptionalExpression(parsingContext, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), valueValidator, expression);
    }

    public static <R, V> Expression<V> readOptionalExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ValueValidator<V> valueValidator) {
        return readOptionalExpression(parsingContext, jSONObject, str, typeHelper, function1, valueValidator, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> Expression<V> readOptionalExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ValueValidator<V> valueValidator, Expression<V> expression) {
        Object objOptSafe = optSafe(jSONObject, str);
        if (objOptSafe == null) {
            return null;
        }
        if (Expression.mayBeExpression(objOptSafe)) {
            return new Expression.MutableExpression(str, objOptSafe.toString(), function1, valueValidator, parsingContext.getLogger(), typeHelper, expression);
        }
        try {
            V vInvoke = function1.invoke(objOptSafe);
            if (vInvoke == null) {
                parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe));
                return null;
            }
            if (!typeHelper.isTypeValid(vInvoke)) {
                parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe));
                return null;
            }
            try {
                if (!valueValidator.isValid(vInvoke)) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe));
                    return null;
                }
                return Expression.constant(vInvoke);
            } catch (ClassCastException unused) {
                parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe));
                return null;
            }
        } catch (ClassCastException unused2) {
            parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe));
            return null;
        } catch (Exception e) {
            parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe, e));
            return null;
        }
    }

    public static ExpressionList<String> readExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, ListValidator<String> listValidator) {
        return readExpressionList(parsingContext, jSONObject, str, TypeHelpersKt.TYPE_HELPER_STRING, JsonParsers.doNotConvert(), listValidator, JsonParsers.alwaysValidString());
    }

    public static <R, V> ExpressionList<V> readExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1) {
        return readExpressionList(parsingContext, jSONObject, str, typeHelper, function1, JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static ExpressionList<String> readExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<String> typeHelper, ListValidator<String> listValidator) {
        return readExpressionList(parsingContext, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), listValidator, JsonParsers.alwaysValidString());
    }

    public static <R, V> ExpressionList<V> readExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ListValidator<V> listValidator) {
        return readExpressionList(parsingContext, jSONObject, str, typeHelper, function1, listValidator, JsonParsers.alwaysValid());
    }

    public static <V> ExpressionList<V> readExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        return readExpressionList(parsingContext, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), listValidator, valueValidator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> ExpressionList<V> readExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            List<? extends V> listEmptyList = Collections.emptyList();
            try {
                if (!listValidator.isValid(listEmptyList)) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, listEmptyList));
                    return emptyExpressionList();
                }
                return emptyExpressionList();
            } catch (ClassCastException unused) {
                parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, listEmptyList));
                return emptyExpressionList();
            }
        }
        ArrayList arrayList = new ArrayList(length);
        ParsingErrorLogger logger = null;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            Object objOptSafe = optSafe(jSONArrayOptJSONArray, i);
            if (objOptSafe != null) {
                if (Expression.mayBeExpression(objOptSafe)) {
                    if (logger == null) {
                        logger = parsingContext.getLogger();
                    }
                    arrayList.add(new Expression.MutableExpression(str + b9.i.d + i + b9.i.e, objOptSafe.toString(), function1, valueValidator, logger, typeHelper, null));
                    z = true;
                } else {
                    try {
                        V vInvoke = function1.invoke(objOptSafe);
                        if (vInvoke != null) {
                            if (!typeHelper.isTypeValid(vInvoke)) {
                                parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, objOptSafe));
                            } else {
                                try {
                                    if (!valueValidator.isValid(vInvoke)) {
                                        parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, vInvoke));
                                    } else {
                                        arrayList.add(vInvoke);
                                    }
                                } catch (ClassCastException unused2) {
                                    parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, vInvoke));
                                }
                            }
                        }
                    } catch (ClassCastException unused3) {
                        parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, objOptSafe));
                    } catch (Exception e) {
                        parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, objOptSafe, e));
                    }
                }
            }
        }
        if (z) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = arrayList.get(i2);
                if (!(obj instanceof Expression)) {
                    arrayList.set(i2, Expression.constant(obj));
                }
            }
            return new MutableExpressionList(str, arrayList, listValidator, parsingContext.getLogger());
        }
        try {
            if (!listValidator.isValid(arrayList)) {
                throw ParsingExceptionKt.invalidValue(jSONObject, str, arrayList);
            }
            return new ConstantExpressionList(arrayList);
        } catch (ClassCastException unused4) {
            throw ParsingExceptionKt.typeMismatch(jSONObject, str, arrayList);
        }
    }

    public static <R, V> ExpressionList<V> readOptionalExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1) {
        return readOptionalExpressionList(parsingContext, jSONObject, str, typeHelper, function1, JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static <V> ExpressionList<V> readOptionalExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, ListValidator<V> listValidator) {
        return readOptionalExpressionList(parsingContext, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), listValidator, JsonParsers.alwaysValid());
    }

    public static <R, V> ExpressionList<V> readOptionalExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ListValidator<V> listValidator) {
        return readOptionalExpressionList(parsingContext, jSONObject, str, typeHelper, function1, listValidator, JsonParsers.alwaysValid());
    }

    public static <V> ExpressionList<V> readOptionalExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        return readOptionalExpressionList(parsingContext, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), listValidator, valueValidator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> ExpressionList<V> readOptionalExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            List<? extends V> listEmptyList = Collections.emptyList();
            try {
                if (!listValidator.isValid(listEmptyList)) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, listEmptyList));
                    return emptyExpressionList();
                }
                return emptyExpressionList();
            } catch (ClassCastException unused) {
                parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, listEmptyList));
                return emptyExpressionList();
            }
        }
        ArrayList arrayList = new ArrayList(length);
        ParsingErrorLogger logger = null;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            Object objOptSafe = optSafe(jSONArrayOptJSONArray, i);
            if (objOptSafe != null) {
                if (Expression.mayBeExpression(objOptSafe)) {
                    if (logger == null) {
                        logger = parsingContext.getLogger();
                    }
                    arrayList.add(new Expression.MutableExpression(str + b9.i.d + i + b9.i.e, objOptSafe.toString(), function1, valueValidator, logger, typeHelper, null));
                    z = true;
                } else {
                    try {
                        V vInvoke = function1.invoke(objOptSafe);
                        if (vInvoke != null) {
                            if (!typeHelper.isTypeValid(vInvoke)) {
                                parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, objOptSafe));
                            } else {
                                try {
                                    if (!valueValidator.isValid(vInvoke)) {
                                        parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, vInvoke));
                                    } else {
                                        arrayList.add(vInvoke);
                                    }
                                } catch (ClassCastException unused2) {
                                    parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, vInvoke));
                                }
                            }
                        }
                    } catch (ClassCastException unused3) {
                        parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, objOptSafe));
                    } catch (Exception e) {
                        parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, objOptSafe, e));
                    }
                }
            }
        }
        if (z) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = arrayList.get(i2);
                if (!(obj instanceof Expression)) {
                    arrayList.set(i2, Expression.constant(obj));
                }
            }
            return new MutableExpressionList(str, arrayList, listValidator, parsingContext.getLogger());
        }
        try {
            if (!listValidator.isValid(arrayList)) {
                parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, arrayList));
                return null;
            }
            return new ConstantExpressionList(arrayList);
        } catch (ClassCastException unused4) {
            parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, arrayList));
            return null;
        }
    }

    private static <T> T optSafe(JSONObject jSONObject, String str) {
        T t = (T) jSONObject.opt(str);
        if (t == JSONObject.NULL) {
            return null;
        }
        return t;
    }

    private static <T> T optSafe(JSONArray jSONArray, int i) {
        T t = (T) jSONArray.opt(i);
        if (t == JSONObject.NULL) {
            return null;
        }
        return t;
    }

    private static <V> ExpressionList<V> emptyExpressionList() {
        return (ExpressionList<V>) EMPTY_EXPRESSION_LIST;
    }

    public static <V> void writeExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, Expression<V> expression) {
        writeExpression(parsingContext, jSONObject, str, expression, JsonParsers.doNotConvert());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> void writeExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, Expression<V> expression, Function1<V, R> function1) {
        if (expression == null) {
            return;
        }
        Object rawValue = expression.getRawValue();
        try {
            if (!(expression instanceof Expression.MutableExpression)) {
                jSONObject.put(str, function1.invoke(rawValue));
            } else {
                jSONObject.put(str, rawValue);
            }
        } catch (JSONException e) {
            parsingContext.getLogger().logError(e);
        }
    }

    public static <V> void writeExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, ExpressionList<V> expressionList) {
        writeExpressionList(parsingContext, jSONObject, str, expressionList, JsonParsers.doNotConvert());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> void writeExpressionList(ParsingContext parsingContext, JSONObject jSONObject, String str, ExpressionList<V> expressionList, Function1<V, R> function1) {
        if (expressionList == null) {
            return;
        }
        int i = 0;
        if (expressionList instanceof ConstantExpressionList) {
            List<V> listEvaluate = expressionList.evaluate(ExpressionResolver.EMPTY);
            int size = listEvaluate.size();
            JSONArray jSONArray = new JSONArray();
            while (i < size) {
                jSONArray.put(function1.invoke(listEvaluate.get(i)));
                i++;
            }
            try {
                jSONObject.put(str, jSONArray);
                return;
            } catch (JSONException e) {
                parsingContext.getLogger().logError(e);
                return;
            }
        }
        if (expressionList instanceof MutableExpressionList) {
            List expressionsInternal = ((MutableExpressionList) expressionList).getExpressionsInternal();
            if (expressionsInternal.isEmpty()) {
                return;
            }
            int size2 = expressionsInternal.size();
            JSONArray jSONArray2 = new JSONArray();
            while (i < size2) {
                Expression expression = (Expression) expressionsInternal.get(i);
                if (expression instanceof Expression.ConstantExpression) {
                    jSONArray2.put(function1.invoke(expression.evaluate(ExpressionResolver.EMPTY)));
                } else {
                    jSONArray2.put(expression.getRawValue());
                }
                i++;
            }
            try {
                jSONObject.put(str, jSONArray2);
            } catch (JSONException e2) {
                parsingContext.getLogger().logError(e2);
            }
        }
    }
}
