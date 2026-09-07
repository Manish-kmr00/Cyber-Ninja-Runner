package com.yandex.div.evaluable.function;

import com.json.b9;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.yandex.div.evaluable.EvaluableExceptionKt;
import com.yandex.div.evaluable.EvaluableType;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DictFunctions.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0000\u001a*\u0010\b\u001a\u0004\u0018\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0000\u001a&\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\r\u001a\u00020\u0003H\u0000\u001a0\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0000\u001a0\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0002\u001a8\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\u0015"}, d2 = {"evaluate", "", b9.f.b, "", "args", "", "isMethod", "", "evaluateSafe", POBNativeConstants.NATIVE_FALLBACK_URL, "defaultFallback", "throwDictException", "", "message", "throwException", "throwMissingPropertyException", "propName", "throwWrongTypeException", "expected", "Lcom/yandex/div/evaluable/EvaluableType;", "actual", "div-evaluable"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DictFunctionsKt {
    public static /* synthetic */ Object evaluate$default(String str, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return evaluate(str, list, z);
    }

    public static final Object evaluate(String functionName, List<? extends Object> args, boolean z) {
        Object objM7904constructorimpl;
        Object objM7904constructorimpl2;
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(args, "args");
        JSONObject jSONObject = (JSONObject) CollectionsKt.first((List) args);
        int size = args.size() - 1;
        for (int i = 1; i < size; i++) {
            Object obj = args.get(i);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNull(jSONObject);
                Object objOpt = jSONObject.opt(str);
                jSONObject = objOpt instanceof JSONObject ? (JSONObject) objOpt : null;
                objM7904constructorimpl2 = Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl2 = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl2) != null) {
                throwMissingPropertyException(functionName, args, str, z);
                throw new KotlinNothingValueException();
            }
        }
        Object objLast = CollectionsKt.last(args);
        Intrinsics.checkNotNull(objLast, "null cannot be cast to non-null type kotlin.String");
        String str2 = (String) objLast;
        try {
            Result.Companion companion3 = Result.INSTANCE;
            Intrinsics.checkNotNull(jSONObject);
            objM7904constructorimpl = Result.m7904constructorimpl(jSONObject.get(str2));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) == null) {
            Intrinsics.checkNotNullExpressionValue(objM7904constructorimpl, "runCatching { dict!!.get…propName, isMethod)\n    }");
            return objM7904constructorimpl;
        }
        throwMissingPropertyException(functionName, args, str2, z);
        throw new KotlinNothingValueException();
    }

    static /* synthetic */ Void throwMissingPropertyException$default(String str, List list, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return throwMissingPropertyException(str, list, str2, z);
    }

    private static final Void throwMissingPropertyException(String str, List<? extends Object> list, String str2, boolean z) {
        throwException(str, list, "Missing property \"" + str2 + "\" in the dict.", z);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void throwWrongTypeException$default(String str, List list, EvaluableType evaluableType, Object obj, boolean z, int i, Object obj2) {
        if ((i & 16) != 0) {
            z = false;
        }
        return throwWrongTypeException(str, list, evaluableType, obj, z);
    }

    public static final Void throwWrongTypeException(String functionName, List<? extends Object> args, EvaluableType expected, Object actual, boolean z) {
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
        throwException(functionName, args, "Incorrect value type: expected " + expected.getTypeName() + ", got " + simpleName + '.', z);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void throwException$default(String str, List list, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return throwException(str, list, str2, z);
    }

    public static final Void throwException(String functionName, List<? extends Object> args, String message, boolean z) {
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(message, "message");
        EvaluableExceptionKt.throwExceptionOnEvaluationFailed$default(CollectionsKt.joinToString$default(args.subList(1, args.size()), null, functionName + '(' + (z ? "" : "<dict>, "), ")", 0, null, new Function1<Object, CharSequence>() { // from class: com.yandex.div.evaluable.function.DictFunctionsKt$throwException$signature$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return EvaluableExceptionKt.toMessageFormat(it);
            }
        }, 25, null), message, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Object evaluateSafe$default(List list, Object obj, boolean z, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = false;
        }
        return evaluateSafe(list, obj, z);
    }

    public static final Object evaluateSafe(List<? extends Object> args, Object fallback, boolean z) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        int i = !z ? 1 : 0;
        Object obj = args.get(i);
        JSONObject jSONObjectOptJSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        if (jSONObjectOptJSONObject == null) {
            return fallback;
        }
        int size = args.size() - 1;
        for (int i2 = i + 1; i2 < size; i2++) {
            Object obj2 = args.get(i2);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            jSONObjectOptJSONObject = jSONObjectOptJSONObject.optJSONObject((String) obj2);
            if (jSONObjectOptJSONObject == null) {
                return fallback;
            }
        }
        Object objLast = CollectionsKt.last(args);
        Intrinsics.checkNotNull(objLast, "null cannot be cast to non-null type kotlin.String");
        return jSONObjectOptJSONObject.opt((String) objLast);
    }

    public static final Void throwDictException(String functionName, List<? extends Object> args, String message) {
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(message, "message");
        ArrayFunctionsKt.throwException$default("dict", functionName, args, message, false, 16, null);
        throw new KotlinNothingValueException();
    }
}
