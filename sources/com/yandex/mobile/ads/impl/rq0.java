package com.yandex.mobile.ads.impl;

import android.text.Html;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class rq0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rq0 f10131a = new rq0();
    private static final Json b = JsonKt.Json$default(null, a.b, 1, null);

    public static String a(String key, JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(key, "key");
        String string = jsonObject.getString(key);
        if (string == null || string.length() == 0 || Intrinsics.areEqual("null", string)) {
            throw new JSONException("Json value can not be null or empty");
        }
        return String.valueOf(Html.fromHtml(string));
    }

    @JvmStatic
    public static final Integer b(String name, JSONObject jsonObject) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(Integer.valueOf(jsonObject.getInt(name)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        return (Integer) objM7904constructorimpl;
    }

    public static List c(String name, JSONObject parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(name, "name");
        JSONArray jSONArrayOptJSONArray = parent.optJSONArray(name);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            String strOptString = jSONArrayOptJSONArray.optString(i);
            f10131a.getClass();
            if (strOptString != null && strOptString.length() != 0 && !Intrinsics.areEqual("null", strOptString)) {
                Intrinsics.checkNotNull(strOptString);
                listCreateListBuilder.add(strOptString);
            }
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    public static Map a(JSONObject parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter("bidding_info", "name");
        JSONObject jSONObjectOptJSONObject = parent.optJSONObject("bidding_info");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObjectOptJSONObject.optString(next);
            f10131a.getClass();
            if (strOptString != null && strOptString.length() != 0 && !Intrinsics.areEqual("null", strOptString)) {
                Intrinsics.checkNotNull(next);
                Intrinsics.checkNotNull(strOptString);
                mapCreateMapBuilder.put(next, strOptString);
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    private rq0() {
    }

    static final class a extends Lambda implements Function1<JsonBuilder, Unit> {
        public static final a b = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(JsonBuilder jsonBuilder) {
            JsonBuilder Json = jsonBuilder;
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setExplicitNulls(false);
            Json.setIgnoreUnknownKeys(true);
            return Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final JSONObject a(String content) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(new JSONObject(content));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        return (JSONObject) objM7904constructorimpl;
    }

    public static Json a() {
        return b;
    }
}
