package com.yandex.div.internal.parser;

import com.json.b9;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionKt;
import com.yandex.div.json.expressions.ConstantExpressionList;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import com.yandex.div.json.expressions.MutableExpressionList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class JsonParser {
    private static final ValueValidator<?> ALWAYS_VALID = new ValueValidator() { // from class: com.yandex.div.internal.parser.JsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return JsonParser.lambda$static$0(obj);
        }
    };
    private static final ValueValidator<String> ALWAYS_VALID_STRING = new ValueValidator() { // from class: com.yandex.div.internal.parser.JsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return JsonParser.lambda$static$1((String) obj);
        }
    };
    private static final ListValidator<?> ALWAYS_VALID_LIST = new ListValidator() { // from class: com.yandex.div.internal.parser.JsonParser$$ExternalSyntheticLambda2
        @Override // com.yandex.div.internal.parser.ListValidator
        public final boolean isValid(List list) {
            return JsonParser.lambda$static$2(list);
        }
    };
    private static final Function1<?, ?> AS_IS = new Function1() { // from class: com.yandex.div.internal.parser.JsonParser$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return JsonParser.lambda$static$3(obj);
        }
    };
    private static final ExpressionList<?> EMPTY_EXPRESSION_LIST = new ConstantExpressionList(Collections.emptyList());

    static /* synthetic */ boolean lambda$static$0(Object obj) {
        return true;
    }

    static /* synthetic */ boolean lambda$static$1(String str) {
        return true;
    }

    static /* synthetic */ boolean lambda$static$2(List list) {
        return true;
    }

    static /* synthetic */ Object lambda$static$3(Object obj) {
        return obj;
    }

    public static <T> Expression<T> readOptionalExpression(JSONObject jSONObject, String str, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readOptionalExpression(jSONObject, str, doNotConvert(), valueValidator, parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <T> Expression<T> readOptionalExpression(JSONObject jSONObject, String str, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, Expression<T> expression, TypeHelper<T> typeHelper) {
        return readOptionalExpression(jSONObject, str, doNotConvert(), alwaysValid(), parsingErrorLogger, parsingEnvironment, expression, typeHelper);
    }

    public static Expression<String> readOptionalExpression(JSONObject jSONObject, String str, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<String> typeHelper) {
        return readOptionalExpression(jSONObject, str, doNotConvert(), ALWAYS_VALID_STRING, parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <R, T> Expression<T> readOptionalExpression(JSONObject jSONObject, String str, Function1<R, T> function1, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readOptionalExpression(jSONObject, str, function1, alwaysValid(), parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <T> Expression<T> readExpression(JSONObject jSONObject, String str, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readExpression(jSONObject, str, doNotConvert(), alwaysValid(), parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <T> Expression<T> readExpression(JSONObject jSONObject, String str, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readExpression(jSONObject, str, doNotConvert(), valueValidator, parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <R, T> Expression<T> readExpression(JSONObject jSONObject, String str, Function1<R, T> function1, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readExpression(jSONObject, str, function1, alwaysValid(), parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <R, T> Expression<T> readOptionalExpression(JSONObject jSONObject, String str, Function1<R, T> function1, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readOptionalExpression(jSONObject, str, function1, valueValidator, parsingErrorLogger, parsingEnvironment, null, typeHelper);
    }

    public static <R, T> Expression<T> readOptionalExpression(JSONObject jSONObject, String str, Function1<R, T> function1, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, Expression<T> expression, TypeHelper<T> typeHelper) {
        return readOptionalExpression(jSONObject, str, function1, alwaysValid(), parsingErrorLogger, parsingEnvironment, expression, typeHelper);
    }

    public static <T> Expression<T> readOptionalExpression(JSONObject jSONObject, String str, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, Expression<T> expression, TypeHelper<T> typeHelper) {
        return readOptionalExpression(jSONObject, str, doNotConvert(), valueValidator, parsingErrorLogger, parsingEnvironment, expression, typeHelper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> Expression<T> readOptionalExpression(JSONObject jSONObject, String str, Function1<R, T> function1, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, Expression<T> expression, TypeHelper<T> typeHelper) {
        Object objOptSafe = optSafe(jSONObject, str);
        if (objOptSafe == null) {
            return null;
        }
        if (Expression.mayBeExpression(objOptSafe)) {
            return new Expression.MutableExpression(str, objOptSafe.toString(), function1, valueValidator, parsingErrorLogger, typeHelper, expression);
        }
        try {
            T tInvoke = function1.invoke(objOptSafe);
            if (tInvoke == null) {
                parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe));
                return null;
            }
            if (!typeHelper.isTypeValid(tInvoke)) {
                parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe));
                return null;
            }
            try {
                if (!valueValidator.isValid(tInvoke)) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe));
                    return null;
                }
                return Expression.constant(tInvoke);
            } catch (ClassCastException unused) {
                parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe));
                return null;
            }
        } catch (ClassCastException unused2) {
            parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe));
            return null;
        } catch (Exception e) {
            parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe, e));
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> Expression<T> readExpression(JSONObject jSONObject, String str, Function1<R, T> function1, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        Object objOptSafe = optSafe(jSONObject, str);
        if (objOptSafe == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        if (Expression.mayBeExpression(objOptSafe)) {
            return new Expression.MutableExpression(str, objOptSafe.toString(), function1, valueValidator, parsingErrorLogger, typeHelper, null);
        }
        try {
            T tInvoke = function1.invoke(objOptSafe);
            if (tInvoke == null) {
                throw ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe);
            }
            if (!typeHelper.isTypeValid(tInvoke)) {
                throw ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe);
            }
            try {
                if (!valueValidator.isValid(tInvoke)) {
                    throw ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe);
                }
                return Expression.constant(tInvoke);
            } catch (ClassCastException unused) {
                throw ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe);
            }
        } catch (ClassCastException unused2) {
            throw ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe);
        } catch (Exception e) {
            throw ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe, e);
        }
    }

    public static <T> T readOptional(JSONObject jSONObject, String str, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return (T) readOptional(jSONObject, str, doNotConvert(), valueValidator, parsingErrorLogger, parsingEnvironment);
    }

    public static <T> T readOptional(JSONObject jSONObject, String str, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return (T) readOptional(jSONObject, str, doNotConvert(), alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> T readOptional(JSONObject jSONObject, String str, Function1<R, T> function1, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return (T) readOptional(jSONObject, str, function1, alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <T extends JSONSerializable> T readOptional(JSONObject jSONObject, String str, Function2<ParsingEnvironment, JSONObject, T> function2, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        try {
            return function2.invoke(parsingEnvironment, jSONObjectOptJSONObject);
        } catch (ParsingException e) {
            parsingErrorLogger.logError(e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> T readOptional(JSONObject jSONObject, String str, Function1<R, T> function1, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        Object objOptSafe = optSafe(jSONObject, str);
        if (objOptSafe == null) {
            return null;
        }
        try {
            T t = (T) function1.invoke(objOptSafe);
            if (t == null) {
                parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe));
                return null;
            }
            try {
                if (valueValidator.isValid(t)) {
                    return t;
                }
                parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe));
                return null;
            } catch (ClassCastException unused) {
                parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe));
                return null;
            }
        } catch (ClassCastException unused2) {
            parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe));
            return null;
        } catch (Exception e) {
            parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe, e));
            return null;
        }
    }

    public static <T> T readOptional(JSONObject jSONObject, String str, Function2<ParsingEnvironment, JSONObject, T> function2, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        try {
            T tInvoke = function2.invoke(parsingEnvironment, jSONObjectOptJSONObject);
            if (tInvoke == null) {
                parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, jSONObjectOptJSONObject));
                return null;
            }
            try {
                if (valueValidator.isValid(tInvoke)) {
                    return tInvoke;
                }
                parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, jSONObjectOptJSONObject));
                return null;
            } catch (ClassCastException unused) {
                parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, jSONObjectOptJSONObject));
                return null;
            }
        } catch (ClassCastException unused2) {
            parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, jSONObjectOptJSONObject));
            return null;
        } catch (Exception e) {
            parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, jSONObjectOptJSONObject, e));
            return null;
        }
    }

    public static <T> T read(JSONObject jSONObject, String str, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return (T) read(jSONObject, str, doNotConvert(), valueValidator, parsingErrorLogger, parsingEnvironment);
    }

    public static <T> T read(JSONObject jSONObject, String str, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return (T) read(jSONObject, str, doNotConvert(), alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> T read(JSONObject jSONObject, String str, Function1<R, T> function1, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return (T) read(jSONObject, str, function1, alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <T> T read(JSONObject jSONObject, String str, Function2<ParsingEnvironment, JSONObject, T> function2, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return (T) read(jSONObject, str, function2, alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <T> T read(JSONObject jSONObject, String str, Function2<ParsingEnvironment, JSONObject, T> function2, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        try {
            T tInvoke = function2.invoke(parsingEnvironment, jSONObjectOptJSONObject);
            if (tInvoke == null) {
                throw ParsingExceptionKt.invalidValue(jSONObject, str, (Object) null);
            }
            try {
                if (valueValidator.isValid(tInvoke)) {
                    return tInvoke;
                }
                throw ParsingExceptionKt.invalidValue(jSONObject, str, tInvoke);
            } catch (ClassCastException unused) {
                throw ParsingExceptionKt.typeMismatch(jSONObject, str, tInvoke);
            }
        } catch (ParsingException e) {
            throw ParsingExceptionKt.dependencyFailed(jSONObject, str, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> T read(JSONObject jSONObject, String str, Function1<R, T> function1, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        Object objOptSafe = optSafe(jSONObject, str);
        if (objOptSafe == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        try {
            T t = (T) function1.invoke(objOptSafe);
            if (t == null) {
                throw ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe);
            }
            try {
                if (valueValidator.isValid(t)) {
                    return t;
                }
                throw ParsingExceptionKt.invalidValue(jSONObject, str, t);
            } catch (ClassCastException unused) {
                throw ParsingExceptionKt.typeMismatch(jSONObject, str, t);
            }
        } catch (ClassCastException unused2) {
            throw ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe);
        } catch (Exception e) {
            throw ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe, e);
        }
    }

    public static <R, T> List<T> readOptionalList(JSONObject jSONObject, String str, Function2<ParsingEnvironment, R, T> function2, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readOptionalList(jSONObject, str, function2, alwaysValidList(), alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> List<T> readOptionalList(JSONObject jSONObject, String str, Function2<ParsingEnvironment, R, T> function2, ListValidator<T> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readOptionalList(jSONObject, str, function2, listValidator, alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> List<T> readOptionalList(JSONObject jSONObject, String str, Function1<R, T> function1, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readOptionalList(jSONObject, str, function1, alwaysValidList(), alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> List<T> readOptionalList(JSONObject jSONObject, String str, Function1<R, T> function1, ListValidator<T> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readOptionalList(jSONObject, str, function1, listValidator, alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> List<T> readOptionalList(JSONObject jSONObject, String str, Function1<R, T> function1, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            List<T> listEmptyList = Collections.emptyList();
            try {
                if (listValidator.isValid(listEmptyList)) {
                    return listEmptyList;
                }
                parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, listEmptyList));
                return null;
            } catch (ClassCastException unused) {
                parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, listEmptyList));
                return null;
            }
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object objOpt = jSONArrayOptJSONArray.opt(i);
            if (Intrinsics.areEqual(objOpt, JSONObject.NULL)) {
                objOpt = null;
            }
            if (objOpt != null) {
                try {
                    T tInvoke = function1.invoke(objOpt);
                    if (tInvoke != null) {
                        try {
                            if (!valueValidator.isValid(tInvoke)) {
                                parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, tInvoke));
                            } else {
                                arrayList.add(tInvoke);
                            }
                        } catch (ClassCastException unused2) {
                            parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, tInvoke));
                        }
                    }
                } catch (ClassCastException unused3) {
                    parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, objOpt));
                } catch (Exception e) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, objOpt, e));
                }
            }
        }
        try {
            if (listValidator.isValid(arrayList)) {
                return arrayList;
            }
            parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, arrayList));
            return null;
        } catch (ClassCastException unused4) {
            parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, arrayList));
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> List<T> readOptionalList(JSONObject jSONObject, String str, Function2<ParsingEnvironment, R, T> function2, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            List<T> listEmptyList = Collections.emptyList();
            try {
                if (listValidator.isValid(listEmptyList)) {
                    return listEmptyList;
                }
                parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, listEmptyList));
                return null;
            } catch (ClassCastException unused) {
                parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, listEmptyList));
                return null;
            }
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object objOptSafe = optSafe(jSONArrayOptJSONArray.optJSONObject(i));
            if (objOptSafe != null) {
                try {
                    T tInvoke = function2.invoke(parsingEnvironment, objOptSafe);
                    if (tInvoke != null) {
                        try {
                            if (!valueValidator.isValid(tInvoke)) {
                                parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, tInvoke));
                            } else {
                                arrayList.add(tInvoke);
                            }
                        } catch (ClassCastException unused2) {
                            parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, tInvoke));
                        }
                    }
                } catch (ClassCastException unused3) {
                    parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, objOptSafe));
                } catch (Exception e) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, objOptSafe, e));
                }
            }
        }
        try {
            if (listValidator.isValid(arrayList)) {
                return arrayList;
            }
            parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, arrayList));
            return null;
        } catch (ClassCastException unused4) {
            parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, arrayList));
            return null;
        }
    }

    public static <T> List<T> readList(JSONObject jSONObject, String str, Function2<ParsingEnvironment, JSONObject, T> function2, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readList(jSONObject, str, function2, alwaysValidList(), alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <T> List<T> readList(JSONObject jSONObject, String str, Function2<ParsingEnvironment, JSONObject, T> function2, ListValidator<T> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readList(jSONObject, str, function2, listValidator, alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <T> List<T> readList(JSONObject jSONObject, String str, Function2<ParsingEnvironment, JSONObject, T> function2, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            List<T> listEmptyList = Collections.emptyList();
            try {
                if (!listValidator.isValid(listEmptyList)) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, listEmptyList));
                }
                return listEmptyList;
            } catch (ClassCastException unused) {
                parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, listEmptyList));
                return listEmptyList;
            }
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = (JSONObject) optSafe(jSONArrayOptJSONArray.optJSONObject(i));
            if (jSONObject2 != null) {
                try {
                    T tInvoke = function2.invoke(parsingEnvironment, jSONObject2);
                    if (tInvoke != null) {
                        try {
                            if (!valueValidator.isValid(tInvoke)) {
                                parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, tInvoke));
                            } else {
                                arrayList.add(tInvoke);
                            }
                        } catch (ClassCastException unused2) {
                            parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, tInvoke));
                        }
                    }
                } catch (ClassCastException unused3) {
                    parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, jSONObject2));
                } catch (Exception e) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, jSONObject2, e));
                }
            }
        }
        try {
            if (listValidator.isValid(arrayList)) {
                return arrayList;
            }
            throw ParsingExceptionKt.invalidValue(jSONObject, str, arrayList);
        } catch (ClassCastException unused4) {
            throw ParsingExceptionKt.typeMismatch(jSONObject, str, arrayList);
        }
    }

    public static List<String> readList(JSONObject jSONObject, String str, ListValidator<String> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readList(jSONObject, str, doNotConvert(), listValidator, ALWAYS_VALID_STRING, parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> List<T> readList(JSONObject jSONObject, String str, Function1<R, T> function1, ListValidator<T> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readList(jSONObject, str, function1, listValidator, alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> List<T> readList(JSONObject jSONObject, String str, Function1<R, T> function1, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            List<T> listEmptyList = Collections.emptyList();
            try {
                if (!listValidator.isValid(listEmptyList)) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, listEmptyList));
                }
                return listEmptyList;
            } catch (ClassCastException unused) {
                parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, listEmptyList));
                return listEmptyList;
            }
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object objOptSafe = optSafe(jSONArrayOptJSONArray.opt(i));
            if (objOptSafe != null) {
                try {
                    T tInvoke = function1.invoke(objOptSafe);
                    if (tInvoke != null) {
                        try {
                            if (!valueValidator.isValid(tInvoke)) {
                                parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, tInvoke));
                            } else {
                                arrayList.add(tInvoke);
                            }
                        } catch (ClassCastException unused2) {
                            parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, tInvoke));
                        }
                    }
                } catch (ClassCastException unused3) {
                    parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, objOptSafe));
                } catch (Exception e) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, objOptSafe, e));
                }
            }
        }
        try {
            if (listValidator.isValid(arrayList)) {
                return arrayList;
            }
            throw ParsingExceptionKt.invalidValue(jSONObject, str, arrayList);
        } catch (ClassCastException unused4) {
            throw ParsingExceptionKt.typeMismatch(jSONObject, str, arrayList);
        }
    }

    public static ExpressionList<String> readExpressionList(JSONObject jSONObject, String str, ListValidator<String> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<String> typeHelper) {
        return readExpressionList(jSONObject, str, doNotConvert(), listValidator, ALWAYS_VALID_STRING, parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static ExpressionList<String> readExpressionList(JSONObject jSONObject, String str, ListValidator<String> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readExpressionList(jSONObject, str, doNotConvert(), listValidator, ALWAYS_VALID_STRING, parsingErrorLogger, parsingEnvironment, TypeHelpersKt.TYPE_HELPER_STRING);
    }

    public static <R, T> ExpressionList<T> readExpressionList(JSONObject jSONObject, String str, Function1<R, T> function1, ListValidator<T> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readExpressionList(jSONObject, str, function1, listValidator, alwaysValid(), parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <T> ExpressionList<T> readExpressionList(JSONObject jSONObject, String str, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readExpressionList(jSONObject, str, doNotConvert(), listValidator, valueValidator, parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <T> ExpressionList<T> readOptionalExpressionList(JSONObject jSONObject, String str, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readOptionalExpressionList(jSONObject, str, doNotConvert(), listValidator, valueValidator, parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <R, T> ExpressionList<T> readOptionalExpressionList(JSONObject jSONObject, String str, Function1<R, T> function1, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readExpressionList(jSONObject, str, function1, listValidator, valueValidator, parsingErrorLogger, parsingEnvironment, typeHelper, ErrorHandler.IGNORE);
    }

    public static <R, T> ExpressionList<T> readExpressionList(JSONObject jSONObject, String str, Function1<R, T> function1, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        ExpressionList<T> expressionList = readExpressionList(jSONObject, str, function1, listValidator, valueValidator, parsingErrorLogger, parsingEnvironment, typeHelper, ErrorHandler.FAIL_FAST);
        if (expressionList != null) {
            return expressionList;
        }
        throw ParsingExceptionKt.invalidValue(str, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <R, T> ExpressionList readExpressionList(JSONObject jSONObject, String str, Function1<R, T> function1, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper, ErrorHandler errorHandler) {
        ErrorHandler errorHandler2;
        int i;
        ArrayList arrayList;
        int i2;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            errorHandler.process(ParsingExceptionKt.missingValue(jSONObject, str));
            return null;
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            List<? extends T> listEmptyList = Collections.emptyList();
            try {
                if (!listValidator.isValid(listEmptyList)) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject, str, listEmptyList));
                    return EMPTY_EXPRESSION_LIST;
                }
                return EMPTY_EXPRESSION_LIST;
            } catch (ClassCastException unused) {
                parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONObject, str, listEmptyList));
                return EMPTY_EXPRESSION_LIST;
            }
        }
        ArrayList arrayList2 = new ArrayList(length);
        boolean z = false;
        int i3 = 0;
        while (i3 < length) {
            Object objOptSafe = optSafe(jSONArrayOptJSONArray.opt(i3));
            if (objOptSafe == null) {
                i = i3;
                arrayList = arrayList2;
                i2 = length;
            } else if (Expression.mayBeExpression(objOptSafe)) {
                i = i3;
                arrayList = arrayList2;
                i2 = length;
                arrayList.add(new Expression.MutableExpression(str + b9.i.d + i3 + b9.i.e, objOptSafe.toString(), function1, valueValidator, parsingErrorLogger, typeHelper, null));
                z = true;
            } else {
                i = i3;
                arrayList = arrayList2;
                i2 = length;
                try {
                    T tInvoke = function1.invoke(objOptSafe);
                    if (tInvoke != null) {
                        if (!typeHelper.isTypeValid(tInvoke)) {
                            parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, objOptSafe));
                        } else {
                            try {
                                if (!valueValidator.isValid(tInvoke)) {
                                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, tInvoke));
                                } else {
                                    arrayList.add(tInvoke);
                                }
                            } catch (ClassCastException unused2) {
                                parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, tInvoke));
                            }
                        }
                    }
                } catch (ClassCastException unused3) {
                    parsingErrorLogger.logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, objOptSafe));
                } catch (Exception e) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, objOptSafe, e));
                }
            }
            i3 = i + 1;
            arrayList2 = arrayList;
            length = i2;
        }
        ArrayList arrayList3 = arrayList2;
        if (z) {
            for (int i4 = 0; i4 < arrayList3.size(); i4++) {
                Object obj = arrayList3.get(i4);
                if (!(obj instanceof Expression)) {
                    arrayList3.set(i4, Expression.constant(obj));
                }
            }
            return new MutableExpressionList(str, arrayList3, listValidator, parsingEnvironment.getLogger());
        }
        try {
            if (!listValidator.isValid(arrayList3)) {
                errorHandler2 = errorHandler;
                try {
                    errorHandler2.process(ParsingExceptionKt.invalidValue(jSONObject, str, arrayList3));
                    return null;
                } catch (ClassCastException unused4) {
                }
            } else {
                return new ConstantExpressionList(arrayList3);
            }
        } catch (ClassCastException unused5) {
            errorHandler2 = errorHandler;
        }
        errorHandler2.process(ParsingExceptionKt.typeMismatch(jSONObject, str, arrayList3));
        return null;
    }

    public static <T> ValueValidator<T> alwaysValid() {
        return (ValueValidator<T>) ALWAYS_VALID;
    }

    static ValueValidator<String> alwaysValidString() {
        return ALWAYS_VALID_STRING;
    }

    public static <T> ListValidator<T> alwaysValidList() {
        return (ListValidator<T>) ALWAYS_VALID_LIST;
    }

    static <T> Function1<T, T> doNotConvert() {
        return (Function1<T, T>) AS_IS;
    }

    private static <T> T optSafe(T t) {
        if (t == null || t == JSONObject.NULL) {
            return null;
        }
        return t;
    }

    private static Object optSafe(JSONObject jSONObject, String str) {
        Object objOpt = jSONObject.opt(str);
        if (objOpt == null || objOpt == JSONObject.NULL) {
            return null;
        }
        return objOpt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface ErrorHandler {
        public static final ErrorHandler FAIL_FAST = new ErrorHandler() { // from class: com.yandex.div.internal.parser.JsonParser$ErrorHandler$$ExternalSyntheticLambda0
            @Override // com.yandex.div.internal.parser.JsonParser.ErrorHandler
            public final void process(ParsingException parsingException) {
                JsonParser.ErrorHandler.lambda$static$0(parsingException);
            }
        };
        public static final ErrorHandler IGNORE = new ErrorHandler() { // from class: com.yandex.div.internal.parser.JsonParser$ErrorHandler$$ExternalSyntheticLambda1
            @Override // com.yandex.div.internal.parser.JsonParser.ErrorHandler
            public final void process(ParsingException parsingException) {
                JsonParser.ErrorHandler.lambda$static$1(parsingException);
            }
        };

        static /* synthetic */ void lambda$static$1(ParsingException parsingException) {
        }

        void process(ParsingException parsingException);

        static /* synthetic */ void lambda$static$0(ParsingException parsingException) {
            throw parsingException;
        }
    }
}
