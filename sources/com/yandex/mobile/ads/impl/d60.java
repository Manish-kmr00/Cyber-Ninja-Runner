package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class d60 {
    public static Set a(String jsonData) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(a(new JSONArray(jsonData)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
            String str = "Couldn't parse " + jsonData + " to set of ExclusionRule";
            op0.b(new Object[0]);
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        return (Set) objM7904constructorimpl;
    }

    public static Set a(JSONArray jsonArray) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        try {
            Result.Companion companion = Result.INSTANCE;
            Set setCreateSetBuilder = SetsKt.createSetBuilder();
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jsonArray.getJSONObject(i);
                String string = jSONObject.getString("type");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                c60 c60VarValueOf = c60.valueOf(string);
                String string2 = jSONObject.getString("value");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                setCreateSetBuilder.add(new b60(c60VarValueOf, string2));
            }
            objM7904constructorimpl = Result.m7904constructorimpl(SetsKt.build(setCreateSetBuilder));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
            String str = "Couldn't parse " + jsonArray + " to set of ExclusionRule";
            op0.b(new Object[0]);
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        return (Set) objM7904constructorimpl;
    }

    public static String a(Set set) throws JSONException {
        if (set != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                b60 b60Var = (b60) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", b60Var.a().name());
                jSONObject.put("value", b60Var.b());
                jSONArray = jSONArray.put(jSONObject);
                Intrinsics.checkNotNullExpressionValue(jSONArray, "put(...)");
            }
            if (jSONArray != null) {
                return jSONArray.toString();
            }
        }
        return null;
    }
}
