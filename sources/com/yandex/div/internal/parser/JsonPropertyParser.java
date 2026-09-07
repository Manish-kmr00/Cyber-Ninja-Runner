package com.yandex.div.internal.parser;

import com.yandex.div.json.ParsingExceptionKt;
import com.yandex.div.serialization.Deserializer;
import com.yandex.div.serialization.ParsingContext;
import com.yandex.div.serialization.Serializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class JsonPropertyParser {
    private JsonPropertyParser() {
    }

    public static String readString(ParsingContext parsingContext, JSONObject jSONObject, String str) {
        Object objOptSafe = optSafe(jSONObject, str);
        if (objOptSafe == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        try {
            return (String) objOptSafe;
        } catch (ClassCastException unused) {
            throw ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe);
        } catch (Exception e) {
            throw ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe, e);
        }
    }

    public static String readOptionalString(ParsingContext parsingContext, JSONObject jSONObject, String str) {
        Object objOptSafe = optSafe(jSONObject, str);
        if (objOptSafe == null) {
            return null;
        }
        try {
            return (String) objOptSafe;
        } catch (ClassCastException unused) {
            parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe));
            return null;
        } catch (Exception e) {
            parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe, e));
            return null;
        }
    }

    public static <V> V read(ParsingContext parsingContext, JSONObject jSONObject, String str) {
        return (V) read(parsingContext, jSONObject, str, JsonParsers.doNotConvert(), JsonParsers.alwaysValid());
    }

    public static <R, V> V read(ParsingContext parsingContext, JSONObject jSONObject, String str, Function1<R, V> function1) {
        return (V) read(parsingContext, jSONObject, str, function1, JsonParsers.alwaysValid());
    }

    public static <V> V read(ParsingContext parsingContext, JSONObject jSONObject, String str, ValueValidator<V> valueValidator) {
        return (V) read(parsingContext, jSONObject, str, JsonParsers.doNotConvert(), valueValidator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> V read(ParsingContext parsingContext, JSONObject jSONObject, String str, Function1<R, V> function1, ValueValidator<V> valueValidator) {
        Object objOptSafe = optSafe(jSONObject, str);
        if (objOptSafe == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        try {
            V v = (V) function1.invoke(objOptSafe);
            if (v == null) {
                throw ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe);
            }
            try {
                if (valueValidator.isValid(v)) {
                    return v;
                }
                throw ParsingExceptionKt.invalidValue(jSONObject, str, v);
            } catch (ClassCastException unused) {
                throw ParsingExceptionKt.typeMismatch(jSONObject, str, v);
            }
        } catch (ClassCastException unused2) {
            throw ParsingExceptionKt.typeMismatch(jSONObject, str, objOptSafe);
        } catch (Exception e) {
            throw ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe, e);
        }
    }

    public static <V> V read(ParsingContext parsingContext, JSONObject jSONObject, String str, Lazy<Deserializer<JSONObject, V>> lazy) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        try {
            V vDeserialize = lazy.getValue().deserialize(parsingContext, jSONObjectOptJSONObject);
            if (vDeserialize != null) {
                return vDeserialize;
            }
            throw ParsingExceptionKt.invalidValue(jSONObject, str, (Object) null);
        } catch (Exception e) {
            throw ParsingExceptionKt.dependencyFailed(jSONObject, str, e);
        }
    }

    public static <V> V readOptional(ParsingContext parsingContext, JSONObject jSONObject, String str) {
        return (V) readOptional(parsingContext, jSONObject, str, JsonParsers.doNotConvert(), JsonParsers.alwaysValid());
    }

    public static <R, V> V readOptional(ParsingContext parsingContext, JSONObject jSONObject, String str, Function1<R, V> function1) {
        return (V) readOptional(parsingContext, jSONObject, str, function1, JsonParsers.alwaysValid());
    }

    public static <V> V readOptional(ParsingContext parsingContext, JSONObject jSONObject, String str, ValueValidator<V> valueValidator) {
        return (V) readOptional(parsingContext, jSONObject, str, JsonParsers.doNotConvert(), valueValidator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> V readOptional(ParsingContext parsingContext, JSONObject jSONObject, String str, Function1<R, V> function1, ValueValidator<V> valueValidator) {
        Object objOptSafe = optSafe(jSONObject, str);
        if (objOptSafe == null) {
            return null;
        }
        try {
            V v = (V) function1.invoke(objOptSafe);
            if (v == null) {
                parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe));
                return null;
            }
            try {
                if (valueValidator.isValid(v)) {
                    return v;
                }
                parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, objOptSafe));
                return null;
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

    public static <V> V readOptional(ParsingContext parsingContext, JSONObject jSONObject, String str, Lazy<Deserializer<JSONObject, V>> lazy) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        try {
            return lazy.getValue().deserialize(parsingContext, jSONObjectOptJSONObject);
        } catch (Exception e) {
            parsingContext.getLogger().logError(ParsingExceptionKt.dependencyFailed(jSONObject, str, e));
            return null;
        }
    }

    public static <R, V> List<V> readList(ParsingContext parsingContext, JSONObject jSONObject, String str, Function1<R, V> function1) {
        return readList(parsingContext, jSONObject, str, function1, JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static List<String> readList(ParsingContext parsingContext, JSONObject jSONObject, String str, ListValidator<String> listValidator) {
        return readList(parsingContext, jSONObject, str, JsonParsers.doNotConvert(), listValidator, JsonParsers.alwaysValidString());
    }

    public static <R, V> List<V> readList(ParsingContext parsingContext, JSONObject jSONObject, String str, Function1<R, V> function1, ListValidator<V> listValidator) {
        return readList(parsingContext, jSONObject, str, function1, listValidator, JsonParsers.alwaysValid());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> List<V> readList(ParsingContext parsingContext, JSONObject jSONObject, String str, Function1<R, V> function1, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            List<V> listEmptyList = Collections.emptyList();
            try {
                if (!listValidator.isValid(listEmptyList)) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, listEmptyList));
                }
                return listEmptyList;
            } catch (ClassCastException unused) {
                parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, listEmptyList));
                return listEmptyList;
            }
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object objOptSafe = optSafe(jSONArrayOptJSONArray, i);
            if (objOptSafe != null) {
                try {
                    V vInvoke = function1.invoke(objOptSafe);
                    if (vInvoke != null) {
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
                } catch (ClassCastException unused3) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, objOptSafe));
                } catch (Exception e) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, objOptSafe, e));
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

    public static <V> List<V> readList(ParsingContext parsingContext, JSONObject jSONObject, String str, Lazy<Deserializer<JSONObject, V>> lazy) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectNullable = nullable(jSONArrayOptJSONArray.optJSONObject(i));
            if (jSONObjectNullable != null) {
                try {
                    V vDeserialize = lazy.getValue().deserialize(parsingContext, jSONObjectNullable);
                    if (vDeserialize != null) {
                        arrayList.add(vDeserialize);
                    }
                } catch (Exception e) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.dependencyFailed(jSONArrayOptJSONArray, str, i, e));
                }
            }
        }
        return arrayList;
    }

    public static <V> List<V> readList(ParsingContext parsingContext, JSONObject jSONObject, String str, Lazy<Deserializer<JSONObject, V>> lazy, ListValidator<V> listValidator) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, str);
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            List<V> listEmptyList = Collections.emptyList();
            try {
                if (!listValidator.isValid(listEmptyList)) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, listEmptyList));
                }
                return listEmptyList;
            } catch (ClassCastException unused) {
                parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, listEmptyList));
                return listEmptyList;
            }
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectNullable = nullable(jSONArrayOptJSONArray.optJSONObject(i));
            if (jSONObjectNullable != null) {
                try {
                    V vDeserialize = lazy.getValue().deserialize(parsingContext, jSONObjectNullable);
                    if (vDeserialize != null) {
                        arrayList.add(vDeserialize);
                    }
                } catch (Exception e) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.dependencyFailed(jSONArrayOptJSONArray, str, i, e));
                }
            }
        }
        try {
            if (listValidator.isValid(arrayList)) {
                return arrayList;
            }
            throw ParsingExceptionKt.invalidValue(jSONObject, str, arrayList);
        } catch (ClassCastException unused2) {
            throw ParsingExceptionKt.typeMismatch(jSONObject, str, arrayList);
        }
    }

    public static <R, V> List<V> readOptionalList(ParsingContext parsingContext, JSONObject jSONObject, String str, Function1<R, V> function1) {
        return readOptionalList(parsingContext, jSONObject, str, function1, JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static <R, V> List<V> readOptionalList(ParsingContext parsingContext, JSONObject jSONObject, String str, Function1<R, V> function1, ListValidator<V> listValidator) {
        return readOptionalList(parsingContext, jSONObject, str, function1, listValidator, JsonParsers.alwaysValid());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> List<V> readOptionalList(ParsingContext parsingContext, JSONObject jSONObject, String str, Function1<R, V> function1, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            List<V> listEmptyList = Collections.emptyList();
            try {
                if (listValidator.isValid(listEmptyList)) {
                    return listEmptyList;
                }
                parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, listEmptyList));
                return null;
            } catch (ClassCastException unused) {
                parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, listEmptyList));
                return null;
            }
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object objOptSafe = optSafe(jSONArrayOptJSONArray, i);
            if (objOptSafe != null) {
                try {
                    V vInvoke = function1.invoke(objOptSafe);
                    if (vInvoke != null) {
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
                } catch (ClassCastException unused3) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONArrayOptJSONArray, str, i, objOptSafe));
                } catch (Exception e) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONArrayOptJSONArray, str, i, objOptSafe, e));
                }
            }
        }
        try {
            if (listValidator.isValid(arrayList)) {
                return arrayList;
            }
            parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, arrayList));
            return null;
        } catch (ClassCastException unused4) {
            parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, arrayList));
            return null;
        }
    }

    public static <V> List<V> readOptionalList(ParsingContext parsingContext, JSONObject jSONObject, String str, Lazy<Deserializer<JSONObject, V>> lazy) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectNullable = nullable(jSONArrayOptJSONArray.optJSONObject(i));
            if (jSONObjectNullable != null) {
                try {
                    V vDeserialize = lazy.getValue().deserialize(parsingContext, jSONObjectNullable);
                    if (vDeserialize != null) {
                        arrayList.add(vDeserialize);
                    }
                } catch (Exception e) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.dependencyFailed(jSONArrayOptJSONArray, str, i, e));
                }
            }
        }
        return arrayList;
    }

    public static <V> List<V> readOptionalList(ParsingContext parsingContext, JSONObject jSONObject, String str, Lazy<Deserializer<JSONObject, V>> lazy, ListValidator<V> listValidator) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int length = jSONArrayOptJSONArray.length();
        if (length == 0) {
            List<V> listEmptyList = Collections.emptyList();
            try {
                if (listValidator.isValid(listEmptyList)) {
                    return listEmptyList;
                }
                parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, listEmptyList));
                return null;
            } catch (ClassCastException unused) {
                parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, listEmptyList));
                return null;
            }
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectNullable = nullable(jSONArrayOptJSONArray.optJSONObject(i));
            if (jSONObjectNullable != null) {
                try {
                    V vDeserialize = lazy.getValue().deserialize(parsingContext, jSONObjectNullable);
                    if (vDeserialize != null) {
                        arrayList.add(vDeserialize);
                    }
                } catch (Exception e) {
                    parsingContext.getLogger().logError(ParsingExceptionKt.dependencyFailed(jSONArrayOptJSONArray, str, i, e));
                }
            }
        }
        try {
            if (listValidator.isValid(arrayList)) {
                return arrayList;
            }
            parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, arrayList));
            return null;
        } catch (ClassCastException unused2) {
            parsingContext.getLogger().logError(ParsingExceptionKt.typeMismatch(jSONObject, str, arrayList));
            return null;
        }
    }

    private static JSONObject nullable(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == JSONObject.NULL) {
            return null;
        }
        return jSONObject;
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

    public static <V> void write(ParsingContext parsingContext, JSONObject jSONObject, String str, V v) {
        write(parsingContext, jSONObject, str, v, JsonParsers.doNotConvert());
    }

    public static <R, V> void write(ParsingContext parsingContext, JSONObject jSONObject, String str, V v, Function1<V, R> function1) {
        if (v != null) {
            try {
                jSONObject.put(str, function1.invoke(v));
            } catch (JSONException e) {
                parsingContext.getLogger().logError(e);
            }
        }
    }

    public static <V> void write(ParsingContext parsingContext, JSONObject jSONObject, String str, V v, Lazy<Serializer<JSONObject, V>> lazy) {
        if (v != null) {
            try {
                jSONObject.put(str, lazy.getValue().serialize(parsingContext, v));
            } catch (JSONException e) {
                parsingContext.getLogger().logError(e);
            }
        }
    }

    public static <V> void writeList(ParsingContext parsingContext, JSONObject jSONObject, String str, List<V> list) {
        writeList(parsingContext, jSONObject, str, list, JsonParsers.doNotConvert());
    }

    public static <R, V> void writeList(ParsingContext parsingContext, JSONObject jSONObject, String str, List<V> list, Function1<V, R> function1) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < size; i++) {
            jSONArray.put(function1.invoke(list.get(i)));
        }
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException e) {
            parsingContext.getLogger().logError(e);
        }
    }

    public static <V> void writeList(ParsingContext parsingContext, JSONObject jSONObject, String str, List<V> list, Lazy<Serializer<JSONObject, V>> lazy) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < size; i++) {
            jSONArray.put(lazy.getValue().serialize(parsingContext, list.get(i)));
        }
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException e) {
            parsingContext.getLogger().logError(e);
        }
    }
}
