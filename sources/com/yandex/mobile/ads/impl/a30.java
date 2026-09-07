package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f8358a = CollectionsKt.listOf((Object[]) new String[]{"native_ad_view", "timer_container", "timer_value", "skip_button", "linear_progress_view", "video_progress", "mute_button"});

    public final Set<p20> a(JSONObject designCard) {
        Intrinsics.checkNotNullParameter(designCard, "designCard");
        ArrayList arrayList = new ArrayList();
        a(designCard, q20.b, new z20(this, arrayList));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!f8358a.contains(((p20) obj).a())) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList2);
    }

    private static void a(JSONArray jSONArray, q20 q20Var, Function2 function2) {
        Object obj;
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Intrinsics.checkNotNullParameter(jSONArray, "<this>");
            try {
                obj = jSONArray.get(i);
            } catch (JSONException unused) {
                obj = null;
            }
            if (obj instanceof JSONObject) {
                a((JSONObject) obj, q20Var, function2);
            } else if (obj instanceof JSONArray) {
                a((JSONArray) obj, q20Var, function2);
            }
        }
    }

    private static void a(JSONObject jSONObject, q20 q20Var, Function2 function2) {
        Object obj;
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("extensions");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (Intrinsics.areEqual((jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("params")) == null) ? null : jSONObjectOptJSONObject.optString("view_name"), "native_ad_view")) {
                    q20Var = q20.c;
                    break;
                }
            }
        }
        ((z20) function2).invoke(jSONObject, q20Var);
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Intrinsics.checkNotNull(key);
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                obj = jSONObject.get(key);
            } catch (JSONException unused) {
                obj = null;
            }
            if (obj instanceof JSONObject) {
                a((JSONObject) obj, q20Var, function2);
            } else if (obj instanceof JSONArray) {
                a((JSONArray) obj, q20Var, function2);
            }
        }
    }
}
