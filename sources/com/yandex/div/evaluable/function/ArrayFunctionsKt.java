package com.yandex.div.evaluable.function;

import com.json.b9;
import com.yandex.div.evaluable.EvaluableExceptionKt;
import com.yandex.div.evaluable.EvaluableType;
import com.yandex.div.evaluable.types.Color;
import com.yandex.div.evaluable.types.Url;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ArrayFunctions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0002\u001a(\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a \u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a0\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a8\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a8\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u0004\u0018\u00010\u0003H\u0000ø\u0001\u0000\u001a\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u0004\u0018\u00010\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"checkIndexOfBoundException", "", b9.f.b, "", "args", "", "", "isMethod", "", "evaluateArray", "evaluateSafe", "throwArrayException", "", "message", "throwArrayWrongTypeException", "expected", "Lcom/yandex/div/evaluable/EvaluableType;", "actual", "throwException", "type", "safeConvertToColor", "Lcom/yandex/div/evaluable/types/Color;", "safeConvertToUrl", "Lcom/yandex/div/evaluable/types/Url;", "(Ljava/lang/String;)Ljava/lang/String;", "div-evaluable"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ArrayFunctionsKt {
    public static final Color safeConvertToColor(String str) {
        Object objM7904constructorimpl;
        if (str == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(Color.m6217boximpl(Color.INSTANCE.m6227parseC4zCDoM(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        return (Color) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }

    public static final String safeConvertToUrl(String str) {
        Object objM7904constructorimpl;
        if (str == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(Url.m6229boximpl(Url.INSTANCE.m6236fromVcSV9u8(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        Url url = (Url) objM7904constructorimpl;
        if (url != null) {
            return url.m6235unboximpl();
        }
        return null;
    }

    public static /* synthetic */ Object evaluateArray$default(String str, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return evaluateArray(str, list, z);
    }

    public static final Object evaluateArray(String functionName, List<? extends Object> args, boolean z) throws JSONException {
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(args, "args");
        checkIndexOfBoundException(functionName, args, z);
        Object obj = args.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
        Object obj2 = args.get(1);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
        Object obj3 = ((JSONArray) obj).get((int) ((Long) obj2).longValue());
        Intrinsics.checkNotNullExpressionValue(obj3, "array.get(index.toInt())");
        return obj3;
    }

    public static final Object evaluateSafe(String functionName, List<? extends Object> args) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            Result.Companion companion = Result.INSTANCE;
            checkIndexOfBoundException$default(functionName, args, false, 4, null);
            Object obj = args.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
            Object obj2 = args.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
            objM7904constructorimpl = Result.m7904constructorimpl(((JSONArray) obj).get((int) ((Long) obj2).longValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            return null;
        }
        return objM7904constructorimpl;
    }

    static /* synthetic */ void checkIndexOfBoundException$default(String str, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        checkIndexOfBoundException(str, list, z);
    }

    private static final void checkIndexOfBoundException(String str, List<? extends Object> list, boolean z) {
        Object obj = list.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
        int length = ((JSONArray) obj).length();
        Object obj2 = list.get(1);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
        long jLongValue = ((Long) obj2).longValue();
        if (jLongValue < length) {
            return;
        }
        throwArrayException(str, list, "Requested index (" + jLongValue + ") out of bounds array size (" + length + ").", z);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void throwArrayWrongTypeException$default(String str, List list, EvaluableType evaluableType, Object obj, boolean z, int i, Object obj2) {
        if ((i & 16) != 0) {
            z = false;
        }
        throwArrayWrongTypeException(str, list, evaluableType, obj, z);
    }

    public static final void throwArrayWrongTypeException(String functionName, List<? extends Object> args, EvaluableType expected, Object actual, boolean z) {
        String simpleName;
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(expected, "expected");
        Intrinsics.checkNotNullParameter(actual, "actual");
        if (Intrinsics.areEqual(actual, JSONObject.NULL)) {
            simpleName = "Null";
        } else if (actual instanceof Number) {
            simpleName = "Number";
        } else if (actual instanceof JSONObject) {
            simpleName = "Dict";
        } else {
            simpleName = actual instanceof JSONArray ? "Array" : actual.getClass().getSimpleName();
        }
        throwArrayException(functionName, args, "Incorrect value type: expected " + expected.getTypeName() + ", got " + simpleName + '.', z);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void throwArrayException$default(String str, List list, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return throwArrayException(str, list, str2, z);
    }

    public static final Void throwArrayException(String functionName, List<? extends Object> args, String message, boolean z) {
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(message, "message");
        throwException("array", functionName, args, message, z);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void throwException$default(String str, String str2, List list, String str3, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        return throwException(str, str2, list, str3, z);
    }

    public static final Void throwException(String type, String functionName, List<? extends Object> args, String message, boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(message, "message");
        EvaluableExceptionKt.throwExceptionOnEvaluationFailed$default(CollectionsKt.joinToString$default(args.subList(1, args.size()), null, functionName + '(' + (z ? "" : "<" + type + ">, "), ")", 0, null, new Function1<Object, CharSequence>() { // from class: com.yandex.div.evaluable.function.ArrayFunctionsKt$throwException$signature$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return EvaluableExceptionKt.toMessageFormat(it);
            }
        }, 25, null), message, null, 4, null);
        throw new KotlinNothingValueException();
    }
}
