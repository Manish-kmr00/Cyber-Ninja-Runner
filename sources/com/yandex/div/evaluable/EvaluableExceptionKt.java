package com.yandex.div.evaluable;

import com.yandex.div.evaluable.internal.Token;
import com.yandex.div.evaluable.types.Color;
import com.yandex.div.evaluable.types.DateTime;
import com.yandex.div.evaluable.types.Url;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: EvaluableException.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0000\u001a\u001e\u0010\u0011\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0000\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0000\u001a*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00012\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cH\u0000\u001a8\u0010\u001d\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0019\u001a\u00020\u00012\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cH\u0000\u001a8\u0010\u001e\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0019\u001a\u00020\u00012\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cH\u0000\u001a\f\u0010\u001f\u001a\u00020\u0001*\u00020\u0010H\u0000\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"REASON_CONVERT_TO_BOOLEAN", "", "REASON_CONVERT_TO_COLOR", "REASON_CONVERT_TO_INTEGER", "REASON_CONVERT_TO_NUMBER", "REASON_CONVERT_TO_URL", "REASON_DIVISION_BY_ZERO", "REASON_EMPTY_ARGUMENT_LIST", "REASON_INDEXES_ORDER", "REASON_INTEGER_OVERFLOW", "REASON_OUT_OF_BOUNDS", "REASON_OUT_OF_RANGE", "functionToMessageFormat", "name", "args", "", "", "methodToMessageFormat", "throwExceptionOnEvaluationFailed", "", "operator", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary;", "left", "right", "expression", "reason", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "throwExceptionOnFunctionEvaluationFailed", "throwExceptionOnMethodEvaluationFailed", "toMessageFormat", "div-evaluable"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class EvaluableExceptionKt {
    public static final String REASON_CONVERT_TO_BOOLEAN = "Unable to convert value to Boolean.";
    public static final String REASON_CONVERT_TO_COLOR = "Unable to convert value to Color, expected format #AARRGGBB.";
    public static final String REASON_CONVERT_TO_INTEGER = "Unable to convert value to Integer.";
    public static final String REASON_CONVERT_TO_NUMBER = "Unable to convert value to Number.";
    public static final String REASON_CONVERT_TO_URL = "Unable to convert value to Url.";
    public static final String REASON_DIVISION_BY_ZERO = "Division by zero is not supported.";
    public static final String REASON_EMPTY_ARGUMENT_LIST = "Function requires non empty argument list.";
    public static final String REASON_INDEXES_ORDER = "Indexes should be in ascending order.";
    public static final String REASON_INTEGER_OVERFLOW = "Integer overflow.";
    public static final String REASON_OUT_OF_BOUNDS = "Indexes are out of bounds.";
    public static final String REASON_OUT_OF_RANGE = "Value out of range 0..1.";

    public static /* synthetic */ Void throwExceptionOnEvaluationFailed$default(String str, String str2, Exception exc, int i, Object obj) {
        if ((i & 4) != 0) {
            exc = null;
        }
        return throwExceptionOnEvaluationFailed(str, str2, exc);
    }

    public static final Void throwExceptionOnEvaluationFailed(String expression, String reason, Exception exc) {
        Intrinsics.checkNotNullParameter(expression, "expression");
        Intrinsics.checkNotNullParameter(reason, "reason");
        throw new EvaluableException("Failed to evaluate [" + expression + "]. " + reason, exc);
    }

    public static /* synthetic */ Void throwExceptionOnFunctionEvaluationFailed$default(String str, List list, String str2, Exception exc, int i, Object obj) {
        if ((i & 8) != 0) {
            exc = null;
        }
        return throwExceptionOnFunctionEvaluationFailed(str, list, str2, exc);
    }

    public static final Void throwExceptionOnFunctionEvaluationFailed(String name, List<? extends Object> args, String reason, Exception exc) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(reason, "reason");
        throwExceptionOnEvaluationFailed(functionToMessageFormat(name, args), reason, exc);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void throwExceptionOnMethodEvaluationFailed$default(String str, List list, String str2, Exception exc, int i, Object obj) {
        if ((i & 8) != 0) {
            exc = null;
        }
        return throwExceptionOnMethodEvaluationFailed(str, list, str2, exc);
    }

    public static final Void throwExceptionOnMethodEvaluationFailed(String name, List<? extends Object> args, String reason, Exception exc) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(reason, "reason");
        throwExceptionOnEvaluationFailed(methodToMessageFormat(name, args), reason, exc);
        throw new KotlinNothingValueException();
    }

    public static final String functionToMessageFormat(String name, List<? extends Object> args) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        return CollectionsKt.joinToString$default(args, null, name + '(', ")", 0, null, new Function1<Object, CharSequence>() { // from class: com.yandex.div.evaluable.EvaluableExceptionKt.functionToMessageFormat.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return EvaluableExceptionKt.toMessageFormat(it);
            }
        }, 25, null);
    }

    public static final String methodToMessageFormat(String name, List<? extends Object> args) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.size() > 1) {
            return CollectionsKt.joinToString$default(args.subList(1, args.size()), StringUtils.COMMA, name + '(', ")", 0, null, null, 56, null);
        }
        return name + "()";
    }

    public static final Void throwExceptionOnEvaluationFailed(Token.Operator.Binary operator, Object left, Object right) {
        EvaluableType evaluableType;
        String string;
        EvaluableType evaluableType2;
        EvaluableType evaluableType3;
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        String str = toMessageFormat(left) + ' ' + operator + ' ' + toMessageFormat(right);
        if (!Intrinsics.areEqual(left.getClass(), right.getClass())) {
            StringBuilder sb = new StringBuilder("different types: ");
            EvaluableType.Companion companion = EvaluableType.INSTANCE;
            if (left instanceof Long) {
                evaluableType2 = EvaluableType.INTEGER;
            } else if (left instanceof Double) {
                evaluableType2 = EvaluableType.NUMBER;
            } else if (left instanceof Boolean) {
                evaluableType2 = EvaluableType.BOOLEAN;
            } else if (left instanceof String) {
                evaluableType2 = EvaluableType.STRING;
            } else if (left instanceof DateTime) {
                evaluableType2 = EvaluableType.DATETIME;
            } else if (left instanceof Color) {
                evaluableType2 = EvaluableType.COLOR;
            } else if (left instanceof Url) {
                evaluableType2 = EvaluableType.URL;
            } else if (left instanceof JSONObject) {
                evaluableType2 = EvaluableType.DICT;
            } else {
                if (!(left instanceof JSONArray)) {
                    throw new EvaluableException("Unable to find type for " + left.getClass().getName(), null, 2, null);
                }
                evaluableType2 = EvaluableType.ARRAY;
            }
            StringBuilder sbAppend = sb.append(evaluableType2.getTypeName()).append(" and ");
            EvaluableType.Companion companion2 = EvaluableType.INSTANCE;
            if (right instanceof Long) {
                evaluableType3 = EvaluableType.INTEGER;
            } else if (right instanceof Double) {
                evaluableType3 = EvaluableType.NUMBER;
            } else if (right instanceof Boolean) {
                evaluableType3 = EvaluableType.BOOLEAN;
            } else if (right instanceof String) {
                evaluableType3 = EvaluableType.STRING;
            } else if (right instanceof DateTime) {
                evaluableType3 = EvaluableType.DATETIME;
            } else if (right instanceof Color) {
                evaluableType3 = EvaluableType.COLOR;
            } else if (right instanceof Url) {
                evaluableType3 = EvaluableType.URL;
            } else if (right instanceof JSONObject) {
                evaluableType3 = EvaluableType.DICT;
            } else {
                if (!(right instanceof JSONArray)) {
                    throw new EvaluableException("Unable to find type for " + right.getClass().getName(), null, 2, null);
                }
                evaluableType3 = EvaluableType.ARRAY;
            }
            string = sbAppend.append(evaluableType3.getTypeName()).toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            EvaluableType.Companion companion3 = EvaluableType.INSTANCE;
            if (left instanceof Long) {
                evaluableType = EvaluableType.INTEGER;
            } else if (left instanceof Double) {
                evaluableType = EvaluableType.NUMBER;
            } else if (left instanceof Boolean) {
                evaluableType = EvaluableType.BOOLEAN;
            } else if (left instanceof String) {
                evaluableType = EvaluableType.STRING;
            } else if (left instanceof DateTime) {
                evaluableType = EvaluableType.DATETIME;
            } else if (left instanceof Color) {
                evaluableType = EvaluableType.COLOR;
            } else if (left instanceof Url) {
                evaluableType = EvaluableType.URL;
            } else if (left instanceof JSONObject) {
                evaluableType = EvaluableType.DICT;
            } else {
                if (!(left instanceof JSONArray)) {
                    throw new EvaluableException("Unable to find type for " + left.getClass().getName(), null, 2, null);
                }
                evaluableType = EvaluableType.ARRAY;
            }
            string = sb2.append(evaluableType.getTypeName()).append(" type").toString();
        }
        throwExceptionOnEvaluationFailed$default(str, "Operator '" + operator + "' cannot be applied to " + string + '.', null, 4, null);
        throw new KotlinNothingValueException();
    }

    public static final String toMessageFormat(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, new Function1<Object, CharSequence>() { // from class: com.yandex.div.evaluable.EvaluableExceptionKt.toMessageFormat.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return EvaluableExceptionKt.toMessageFormat(it);
            }
        }, 30, null);
    }

    public static final String toMessageFormat(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (obj instanceof JSONArray) {
            return "<array>";
        }
        if (obj instanceof JSONObject) {
            return "<dict>";
        }
        return obj instanceof String ? "'" + obj + '\'' : obj.toString();
    }
}
