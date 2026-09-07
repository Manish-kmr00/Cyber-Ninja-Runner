package com.yandex.div.internal.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonUtils.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\u001a2\u0010\u0005\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\u00042\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a2\u0010\u0005\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\u000b2\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a4\u0010\r\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0007\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a4\u0010\r\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\u000b2\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0007\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a\u0012\u0010\u000e\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\f\u001a\u0014\u0010\u0010\u001a\u0004\u0018\u00010\f*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\f\u001a\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0004\u001a\n\u0010\u0012\u001a\u00020\u0013*\u00020\u000b\u001a0\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00020\u0016H\u0086\bø\u0001\u0000\u001a8\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00042\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\tH\u0086\bø\u0001\u0000\u001a2\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00042\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0016H\u0086\bø\u0001\u0000\u001a\u0014\u0010\u0019\u001a\u00020\f*\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\n\u001a\u0014\u0010\u0019\u001a\u00020\f*\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"asList", "", "R", "", "Lorg/json/JSONArray;", "forEach", "", "T", "action", "Lkotlin/Function2;", "", "Lorg/json/JSONObject;", "", "forEachNullable", "getStringOrEmpty", "name", "getStringOrNull", "key", "isEmpty", "", "map", "mapping", "Lkotlin/Function1;", "mapIndexedNotNull", "mapNotNull", "summary", "indentSpaces", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class JsonUtilsKt {
    public static final /* synthetic */ <T> void forEach(JSONObject jSONObject, Function2<? super String, ? super T, Unit> action) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys");
        while (keys.hasNext()) {
            String key = keys.next();
            Object obj = jSONObject.get(key);
            Intrinsics.reifiedOperationMarker(3, "T");
            if (obj instanceof Object) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                action.invoke(key, obj);
            }
        }
    }

    public static final /* synthetic */ <T> void forEach(JSONArray jSONArray, Function2<? super Integer, ? super T, Unit> action) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.reifiedOperationMarker(3, "T");
            if (obj instanceof Object) {
                action.invoke(Integer.valueOf(i), obj);
            }
        }
    }

    public static final /* synthetic */ <T> void forEachNullable(JSONObject jSONObject, Function2<? super String, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys");
        while (keys.hasNext()) {
            String key = keys.next();
            Object objOpt = jSONObject.opt(key);
            Intrinsics.reifiedOperationMarker(3, "T?");
            if (objOpt instanceof Object) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                action.invoke(key, objOpt);
            }
        }
    }

    public static final /* synthetic */ <T> void forEachNullable(JSONArray jSONArray, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object objOpt = jSONArray.opt(i);
            Intrinsics.reifiedOperationMarker(3, "T?");
            if (objOpt instanceof Object) {
                action.invoke(Integer.valueOf(i), objOpt);
            }
        }
    }

    public static final <R> List<R> map(JSONArray jSONArray, Function1<Object, ? extends R> mapping) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(i)");
            arrayList.add(mapping.invoke(obj));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexedNotNull(JSONArray jSONArray, Function2<? super Integer, Object, ? extends R> mapping) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Integer numValueOf = Integer.valueOf(i);
            Object obj = jSONArray.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(i)");
            R rInvoke = mapping.invoke(numValueOf, obj);
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    public static final String getStringOrEmpty(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Object objOpt = jSONObject.opt(name);
        return objOpt instanceof String ? (String) objOpt : "";
    }

    public static final String getStringOrNull(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object objOpt = jSONObject.opt(key);
        if (objOpt instanceof String) {
            return (String) objOpt;
        }
        return null;
    }

    public static /* synthetic */ String summary$default(JSONObject jSONObject, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return summary(jSONObject, i);
    }

    public static final String summary(JSONObject jSONObject, int i) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return new JsonPrinter(i, 1).print(jSONObject);
    }

    public static /* synthetic */ String summary$default(JSONArray jSONArray, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return summary(jSONArray, i);
    }

    public static final String summary(JSONArray jSONArray, int i) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        return new JsonPrinter(i, 1).print(jSONArray);
    }

    public static final boolean isEmpty(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return jSONObject.length() == 0;
    }

    public static final boolean isEmpty(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        return jSONArray.length() == 0;
    }

    public static final <R> List<R> mapNotNull(JSONArray jSONArray, Function1<Object, ? extends R> mapping) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(i)");
            R rInvoke = mapping.invoke(obj);
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    public static final <R> List<R> asList(JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(i)");
            if (!(obj instanceof Object)) {
                obj = null;
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
