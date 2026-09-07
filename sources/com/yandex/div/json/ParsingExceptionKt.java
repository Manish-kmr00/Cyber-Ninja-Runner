package com.yandex.div.json;

import com.amazon.aps.shared.util.APSSharedUtil;
import com.yandex.div.internal.util.JsonArray;
import com.yandex.div.internal.util.JsonObject;
import com.yandex.div.internal.util.JsonUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ParsingException.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\u0010\u001a\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003\u001a\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000b\u001a&\u0010\u0006\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003\u001a,\u0010\u0006\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00012\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003\u001a$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0000\u001a\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b\u001a!\u0010\u0014\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u0002H\u0015¢\u0006\u0002\u0010\u0017\u001a)\u0010\u0014\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00152\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u0002H\u0015¢\u0006\u0002\u0010\u0018\u001a,\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u001d\u001a1\u0010\u0014\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u0002H\u0015¢\u0006\u0002\u0010\u001e\u001a9\u0010\u0014\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u0002H\u00152\u0006\u0010\t\u001a\u00020\u001d¢\u0006\u0002\u0010\u001f\u001a)\u0010\u0014\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00152\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0016\u001a\u0002H\u0015¢\u0006\u0002\u0010 \u001a1\u0010\u0014\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00152\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0016\u001a\u0002H\u00152\u0006\u0010\t\u001a\u00020\u001d¢\u0006\u0002\u0010!\u001a\u0016\u0010\"\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b\u001a\u001e\u0010\"\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0016\u0010\"\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\b\u001a*\u0010#\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u001d\u001a\u001a\u0010#\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u001d\u001a-\u0010&\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00152\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0016\u001a\u0002H\u00152\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010'\u001a\u0016\u0010(\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\b\u001a\u0016\u0010*\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u001c\u001a\u000e\u0010*\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b\u001a,\u0010*\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u001d\u001a&\u0010*\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u001c\u001a\u001e\u0010*\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u001c\u001a\u000e\u0010,\u001a\u00020\b*\u0004\u0018\u00010\u001cH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006-"}, d2 = {"MAX_TO_STRING_LENGTH", "", "SILENT_PARSING_EXCEPTION", "Lcom/yandex/div/json/ParsingException;", "getSILENT_PARSING_EXCEPTION", "()Lcom/yandex/div/json/ParsingException;", "dependencyFailed", "path", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "key", "json", "Lorg/json/JSONArray;", "index", "Lorg/json/JSONObject;", "invalidCondition", "message", "input", "invalidValue", "T", "value", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/yandex/div/json/ParsingException;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/yandex/div/json/ParsingException;", "expressionKey", "rawExpression", "wrongValue", "", "", "(Lorg/json/JSONArray;Ljava/lang/String;ILjava/lang/Object;)Lcom/yandex/div/json/ParsingException;", "(Lorg/json/JSONArray;Ljava/lang/String;ILjava/lang/Object;Ljava/lang/Throwable;)Lcom/yandex/div/json/ParsingException;", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)Lcom/yandex/div/json/ParsingException;", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Lcom/yandex/div/json/ParsingException;", "missingValue", "missingVariable", "expression", "variableName", "resolveFailed", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Lcom/yandex/div/json/ParsingException;", "templateNotFound", "templateId", "typeMismatch", "wrongTypeValue", "trimLength", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ParsingExceptionKt {
    private static final int MAX_TO_STRING_LENGTH = 100;
    private static final ParsingException SILENT_PARSING_EXCEPTION = new ParsingException(ParsingExceptionReason.MISSING_VARIABLE, "", null, null, null, 28, null);

    public static final ParsingException missingValue(JSONObject json, String key) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        return new ParsingException(ParsingExceptionReason.MISSING_VALUE, "Value for key '" + key + "' is missing", null, new JsonObject(json), JsonUtilsKt.summary$default(json, 0, 1, (Object) null), 4, null);
    }

    public static final ParsingException missingValue(JSONArray json, String key, int i) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        return new ParsingException(ParsingExceptionReason.MISSING_VALUE, "Value at " + i + " position of '" + key + "' is missing", null, new JsonArray(json), JsonUtilsKt.summary$default(json, 0, 1, (Object) null), 4, null);
    }

    public static final ParsingException missingValue(String key, String path) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(path, "path");
        return new ParsingException(ParsingExceptionReason.MISSING_VALUE, "Value for key '" + key + "' at path '" + path + "' is missing", null, null, null, 28, null);
    }

    public static final ParsingException typeMismatch(JSONObject json, String key, Object value) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return new ParsingException(ParsingExceptionReason.TYPE_MISMATCH, "Value for key '" + key + "' has wrong type " + value.getClass().getName(), null, new JsonObject(json), JsonUtilsKt.summary$default(json, 0, 1, (Object) null), 4, null);
    }

    public static final ParsingException typeMismatch(JSONArray json, String key, int i, Object value) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return new ParsingException(ParsingExceptionReason.TYPE_MISMATCH, "Value at " + i + " position of '" + key + "' has wrong type " + value.getClass().getName(), null, new JsonArray(json), JsonUtilsKt.summary$default(json, 0, 1, (Object) null), 4, null);
    }

    public static final ParsingException typeMismatch(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new ParsingException(ParsingExceptionReason.TYPE_MISMATCH, "Value at path '" + path + "' has wrong type", null, null, null, 28, null);
    }

    public static /* synthetic */ ParsingException typeMismatch$default(String str, String str2, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 8) != 0) {
            th = null;
        }
        return typeMismatch(str, str2, obj, th);
    }

    public static final ParsingException typeMismatch(String expressionKey, String rawExpression, Object obj, Throwable th) {
        Intrinsics.checkNotNullParameter(expressionKey, "expressionKey");
        Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
        return new ParsingException(ParsingExceptionReason.TYPE_MISMATCH, "Expression '" + expressionKey + "': '" + rawExpression + "' received value of wrong type: '" + obj + '\'', th, null, null, 24, null);
    }

    public static final ParsingException typeMismatch(int i, Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new ParsingException(ParsingExceptionReason.TYPE_MISMATCH, "Item builder data at " + i + " position has wrong type: " + value.getClass().getName(), null, null, null, 28, null);
    }

    public static final ParsingException templateNotFound(JSONObject json, String templateId) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        return new ParsingException(ParsingExceptionReason.MISSING_TEMPLATE, "Template '" + templateId + "' is missing!", null, new JsonObject(json), JsonUtilsKt.summary$default(json, 0, 1, (Object) null), 4, null);
    }

    public static final <T> ParsingException invalidValue(JSONObject json, String key, T t) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        return new ParsingException(ParsingExceptionReason.INVALID_VALUE, "Value '" + trimLength(t) + "' for key '" + key + "' is not valid", null, new JsonObject(json), JsonUtilsKt.summary$default(json, 0, 1, (Object) null), 4, null);
    }

    public static /* synthetic */ ParsingException invalidValue$default(String str, String str2, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 8) != 0) {
            th = null;
        }
        return invalidValue(str, str2, obj, th);
    }

    public static final ParsingException invalidValue(String expressionKey, String rawExpression, Object obj, Throwable th) {
        Intrinsics.checkNotNullParameter(expressionKey, "expressionKey");
        Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
        return new ParsingException(ParsingExceptionReason.INVALID_VALUE, "Field '" + expressionKey + "' with expression '" + rawExpression + "' received wrong value: '" + obj + '\'', th, null, null, 24, null);
    }

    private static final String trimLength(Object obj) {
        String strValueOf = String.valueOf(obj);
        return strValueOf.length() > 100 ? StringsKt.take(strValueOf, 97) + APSSharedUtil.TRUNCATE_SEPARATOR : strValueOf;
    }

    public static final <T> ParsingException invalidValue(JSONObject json, String key, T t, Throwable cause) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cause, "cause");
        return new ParsingException(ParsingExceptionReason.INVALID_VALUE, "Value '" + trimLength(t) + "' for key '" + key + "' is not valid", cause, new JsonObject(json), null, 16, null);
    }

    public static final <T> ParsingException invalidValue(JSONArray json, String key, int i, T t, Throwable cause) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cause, "cause");
        return new ParsingException(ParsingExceptionReason.INVALID_VALUE, "Value '" + trimLength(t) + "' at " + i + " position of '" + key + "' is not valid", cause, new JsonArray(json), null, 16, null);
    }

    public static final <T> ParsingException invalidValue(JSONArray json, String key, int i, T t) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        return new ParsingException(ParsingExceptionReason.INVALID_VALUE, "Value '" + trimLength(t) + "' at " + i + " position of '" + key + "' is not valid", null, new JsonArray(json), JsonUtilsKt.summary$default(json, 0, 1, (Object) null), 4, null);
    }

    public static final <T> ParsingException invalidValue(String path, T t) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new ParsingException(ParsingExceptionReason.INVALID_VALUE, "Value '" + trimLength(t) + "' at path '" + path + "' is not valid", null, null, null, 28, null);
    }

    public static /* synthetic */ ParsingException resolveFailed$default(String str, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 4) != 0) {
            th = null;
        }
        return resolveFailed(str, obj, th);
    }

    public static final <T> ParsingException resolveFailed(String key, T t, Throwable th) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new ParsingException(ParsingExceptionReason.INVALID_VALUE, "Value '" + trimLength(t) + "' for key '" + key + "' could not be resolved", th, null, null, 24, null);
    }

    public static final <T> ParsingException invalidValue(String key, String path, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(path, "path");
        return new ParsingException(ParsingExceptionReason.INVALID_VALUE, "Value '" + trimLength(t) + "' for key '" + key + "' at path '" + path + "' is not valid", null, null, null, 28, null);
    }

    public static /* synthetic */ ParsingException missingVariable$default(String str, String str2, String str3, Throwable th, int i, Object obj) {
        if ((i & 8) != 0) {
            th = null;
        }
        return missingVariable(str, str2, str3, th);
    }

    public static final ParsingException missingVariable(String key, String expression, String variableName, Throwable th) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(expression, "expression");
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        return new ParsingException(ParsingExceptionReason.MISSING_VARIABLE, "Undefined variable '" + variableName + "' at \"" + key + "\": \"" + expression + '\"', th, null, null, 24, null);
    }

    public static /* synthetic */ ParsingException missingVariable$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return missingVariable(str, th);
    }

    public static final ParsingException missingVariable(String variableName, Throwable th) {
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        return new ParsingException(ParsingExceptionReason.MISSING_VARIABLE, "No variable could be resolved for '" + variableName, th, null, null, 24, null);
    }

    public static final ParsingException dependencyFailed(JSONObject json, String key, ParsingException cause) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cause, "cause");
        return dependencyFailed(json, key, (Exception) cause);
    }

    public static final ParsingException dependencyFailed(JSONObject json, String key, Exception cause) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cause, "cause");
        return new ParsingException(ParsingExceptionReason.DEPENDENCY_FAILED, "Value for key '" + key + "' is failed to create", cause, new JsonObject(json), JsonUtilsKt.summary$default(json, 0, 1, (Object) null));
    }

    public static final ParsingException dependencyFailed(JSONArray json, String key, int i, ParsingException cause) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cause, "cause");
        return dependencyFailed(json, key, i, (Exception) cause);
    }

    public static final ParsingException dependencyFailed(JSONArray json, String key, int i, Exception cause) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cause, "cause");
        return new ParsingException(ParsingExceptionReason.DEPENDENCY_FAILED, "Value at " + i + " position of '" + key + "' is failed to create", cause, new JsonArray(json), JsonUtilsKt.summary$default(json, 0, 1, (Object) null));
    }

    public static final ParsingException dependencyFailed(String path, ParsingException cause) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(cause, "cause");
        return dependencyFailed(path, (Exception) cause);
    }

    public static final ParsingException dependencyFailed(String path, Exception cause) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(cause, "cause");
        return new ParsingException(ParsingExceptionReason.DEPENDENCY_FAILED, "Value at path '" + path + "' is failed to create", cause, null, null, 24, null);
    }

    public static final ParsingException dependencyFailed(String key, String path, ParsingException cause) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(cause, "cause");
        return dependencyFailed(key, path, (Exception) cause);
    }

    public static final ParsingException dependencyFailed(String key, String path, Exception cause) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(cause, "cause");
        return new ParsingException(ParsingExceptionReason.DEPENDENCY_FAILED, "Value for key '" + key + "' at path '" + path + "' is failed to create", cause, null, null, 24, null);
    }

    public static final ParsingException invalidCondition(String message, String input) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(input, "input");
        return new ParsingException(ParsingExceptionReason.INVALID_VALUE, message, null, null, input, 12, null);
    }

    public static final ParsingException getSILENT_PARSING_EXCEPTION() {
        return SILENT_PARSING_EXCEPTION;
    }
}
