package com.moloco.sdk.internal.publisher.nativead.parser;

import com.pubmatic.sdk.nativead.POBNativeConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    public final Object a(String nativeOrtbString) {
        Intrinsics.checkNotNullParameter(nativeOrtbString, "nativeOrtbString");
        try {
            JSONObject jSONObject = new JSONObject(nativeOrtbString);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("native");
            if (jSONObjectOptJSONObject != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "it.optJSONObject(\"native\") ?: it");
                jSONObject = jSONObjectOptJSONObject;
            }
            Result.Companion companion = Result.INSTANCE;
            return Result.m7904constructorimpl(new com.moloco.sdk.internal.publisher.nativead.model.b(jSONObject.has("ver") ? jSONObject.getString("ver") : null, a(jSONObject.optJSONArray(POBNativeConstants.NATIVE_ASSETS)), a(jSONObject.optJSONObject("link")), c(jSONObject.optJSONArray(POBNativeConstants.NATIVE_IMPRESSION_TRACKER)), b(jSONObject.optJSONArray(POBNativeConstants.NATIVE_EVENT_TRACKERS)), jSONObject.has("privacy") ? jSONObject.getString("privacy") : null));
        } catch (Exception e) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(e));
        }
    }

    public final com.moloco.sdk.internal.publisher.nativead.model.b.a.C0549b b(JSONObject jSONObject, int i, boolean z) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        Integer numValueOf = jSONObject.has("type") ? Integer.valueOf(jSONObject.getInt("type")) : null;
        String string = jSONObject.getString("url");
        Intrinsics.checkNotNullExpressionValue(string, "getString(\"url\")");
        return new com.moloco.sdk.internal.publisher.nativead.model.b.a.C0549b(i, z, numValueOf, string, jSONObject.has("w") ? Integer.valueOf(jSONObject.getInt("w")) : null, jSONObject.has("h") ? Integer.valueOf(jSONObject.getInt("h")) : null);
    }

    public final com.moloco.sdk.internal.publisher.nativead.model.b.a.c c(JSONObject jSONObject, int i, boolean z) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("text");
        Intrinsics.checkNotNullExpressionValue(string, "getString(\"text\")");
        return new com.moloco.sdk.internal.publisher.nativead.model.b.a.c(i, z, string, jSONObject.has(POBNativeConstants.NATIVE_LENGTH) ? Integer.valueOf(jSONObject.getInt(POBNativeConstants.NATIVE_LENGTH)) : null);
    }

    public final com.moloco.sdk.internal.publisher.nativead.model.b.a.d d(JSONObject jSONObject, int i, boolean z) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("vasttag");
        Intrinsics.checkNotNullExpressionValue(string, "getString(\"vasttag\")");
        return new com.moloco.sdk.internal.publisher.nativead.model.b.a.d(i, z, string);
    }

    public final List<String> c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public final List<com.moloco.sdk.internal.publisher.nativead.model.b.C0550b> b(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(new com.moloco.sdk.internal.publisher.nativead.model.b.C0550b(jSONObject.getInt("event"), jSONObject.getInt("method"), jSONObject.has("url") ? jSONObject.getString("url") : null));
        }
        return arrayList;
    }

    public final List<com.moloco.sdk.internal.publisher.nativead.model.b.a> a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.has("id")) {
                int i2 = jSONObject.getInt("id");
                boolean z = jSONObject.optInt("required", 0) == 1;
                Object objC = c(jSONObject.optJSONObject("title"), i2, z);
                if (objC == null && (objC = b(jSONObject.optJSONObject("img"), i2, z)) == null && (objC = d(jSONObject.optJSONObject("video"), i2, z)) == null) {
                    objC = a(jSONObject.optJSONObject("data"), i2, z);
                }
                if (objC != null) {
                    arrayList.add(objC);
                }
            }
        }
        return arrayList;
    }

    public final com.moloco.sdk.internal.publisher.nativead.model.b.a.C0548a a(JSONObject jSONObject, int i, boolean z) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        Integer numValueOf = jSONObject.has("type") ? Integer.valueOf(jSONObject.getInt("type")) : null;
        Integer numValueOf2 = jSONObject.has(POBNativeConstants.NATIVE_LENGTH) ? Integer.valueOf(jSONObject.getInt(POBNativeConstants.NATIVE_LENGTH)) : null;
        String string = jSONObject.getString("value");
        Intrinsics.checkNotNullExpressionValue(string, "getString(\"value\")");
        return new com.moloco.sdk.internal.publisher.nativead.model.b.a.C0548a(i, z, numValueOf, numValueOf2, string);
    }

    public final com.moloco.sdk.internal.publisher.nativead.model.b.c a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String url = jSONObject.getString("url");
        String string = jSONObject.has(POBNativeConstants.NATIVE_FALLBACK_URL) ? jSONObject.getString(POBNativeConstants.NATIVE_FALLBACK_URL) : null;
        List<String> listC = c(jSONObject.optJSONArray(POBNativeConstants.NATIVE_CLICK_TRACKER));
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return new com.moloco.sdk.internal.publisher.nativead.model.b.c(url, listC, string);
    }
}
