package com.yandex.mobile.ads.impl;

import java.util.LinkedHashSet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class g {
    public static f a(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(com.json.tr.d);
            JSONArray jSONArray = jSONObject.getJSONArray("test_ids");
            Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
            LinkedHashSet linkedHashSetA = a(jSONArray);
            Intrinsics.checkNotNull(string);
            return new f(string, linkedHashSetA);
        } catch (Throwable unused) {
            String str2 = "Couldn't convert " + str + " from Json to AbExperimentData}";
            op0.b(new Object[0]);
            return null;
        }
    }

    private static LinkedHashSet a(JSONArray jSONArray) {
        Object objM7904constructorimpl;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(Boolean.valueOf(linkedHashSet.add(Long.valueOf(jSONArray.getLong(i)))));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
                String str = "Couldn't parse " + TuplesKt.to(jSONArray.get(i), LongCompanionObject.INSTANCE);
                op0.b(new Object[0]);
            }
        }
        return linkedHashSet;
    }
}
