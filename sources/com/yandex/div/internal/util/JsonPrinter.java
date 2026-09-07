package com.yandex.div.internal.util;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonPrinter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0014\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/internal/util/JsonPrinter;", "", "indentSpaces", "", "nestingLimit", "(II)V", "print", "", "json", "Lorg/json/JSONArray;", "Lorg/json/JSONObject;", "deepCopy", "nestingLevel", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class JsonPrinter {
    private static final Companion Companion = new Companion(null);
    private static final String ELLIPSIS = "...";
    private final int indentSpaces;
    private final int nestingLimit;

    public JsonPrinter(int i, int i2) {
        this.indentSpaces = i;
        this.nestingLimit = i2;
    }

    public final String print(JSONObject json) throws JSONException {
        String string;
        String str;
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject jSONObjectDeepCopy = deepCopy(json, this.nestingLimit);
        int i = this.indentSpaces;
        if (i == 0) {
            string = jSONObjectDeepCopy.toString();
            str = "copy.toString()";
        } else {
            string = jSONObjectDeepCopy.toString(i);
            str = "copy.toString(indentSpaces)";
        }
        Intrinsics.checkNotNullExpressionValue(string, str);
        return string;
    }

    public final String print(JSONArray json) throws JSONException {
        String string;
        String str;
        Intrinsics.checkNotNullParameter(json, "json");
        JSONArray jSONArrayDeepCopy = deepCopy(json, this.nestingLimit);
        int i = this.indentSpaces;
        if (i == 0) {
            string = jSONArrayDeepCopy.toString();
            str = "copy.toString()";
        } else {
            string = jSONArrayDeepCopy.toString(i);
            str = "copy.toString(indentSpaces)";
        }
        Intrinsics.checkNotNullExpressionValue(string, str);
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0033  */
    private final JSONObject deepCopy(JSONObject jSONObject, int i) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys");
        while (keys.hasNext()) {
            String key = keys.next();
            Object objOpt = jSONObject.opt(key);
            if (objOpt != null ? objOpt instanceof Object : true) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                if (objOpt instanceof JSONObject) {
                    if (i == 0) {
                        objOpt = "...";
                    } else {
                        objOpt = deepCopy((JSONObject) objOpt, i - 1);
                    }
                } else if (objOpt instanceof JSONArray) {
                    if (i == 0) {
                        objOpt = "...";
                    } else {
                        objOpt = deepCopy((JSONArray) objOpt, i - 1);
                    }
                }
                jSONObject2.put(key, objOpt);
            }
        }
        return jSONObject2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    private final JSONArray deepCopy(JSONArray jSONArray, int i) throws JSONException {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            Object objOpt = jSONArray.opt(i2);
            if (objOpt != null ? objOpt instanceof Object : true) {
                if (objOpt instanceof JSONObject) {
                    if (i == 0) {
                        objOpt = "...";
                    } else {
                        objOpt = deepCopy((JSONObject) objOpt, i - 1);
                    }
                } else if (objOpt instanceof JSONArray) {
                    if (i == 0) {
                        objOpt = "...";
                    } else {
                        objOpt = deepCopy((JSONArray) objOpt, i - 1);
                    }
                }
                jSONArray2.put(objOpt);
            }
        }
        return jSONArray2;
    }

    /* JADX INFO: compiled from: JsonPrinter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/internal/util/JsonPrinter$Companion;", "", "()V", "ELLIPSIS", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
