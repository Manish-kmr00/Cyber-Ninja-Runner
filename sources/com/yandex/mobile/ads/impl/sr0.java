package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class sr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c0 f10232a;

    public /* synthetic */ sr0(lp1 lp1Var) {
        this(lp1Var, new c0(lp1Var));
    }

    private static String a(String str, JSONObject jSONObject) throws JSONException, p61 {
        if (!jSONObject.has(str)) {
            return null;
        }
        String strA = f91.a(jSONObject, "jsonAsset", str, "jsonAttribute", str);
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        return strA;
    }

    public sr0(lp1 reporter, c0 actionParserProvider) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(actionParserProvider, "actionParserProvider");
        this.f10232a = actionParserProvider;
    }

    public final rr0 a(JSONObject jsonLink, wj base64EncodingParameters) throws JSONException, p61 {
        ArrayList arrayList;
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(jsonLink, "jsonLink");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        JSONArray jSONArrayOptJSONArray = jsonLink.optJSONArray("actions");
        List listBuild = null;
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList2 = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                c0 c0Var = this.f10232a;
                Intrinsics.checkNotNull(jSONObject);
                b0<?> b0VarA = c0Var.a(jSONObject, base64EncodingParameters);
                if (b0VarA != null) {
                    arrayList2.add(b0VarA.a(jSONObject));
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        String strA = a("falseClickUrl", jsonLink);
        j80 j80Var = strA != null ? new j80(strA, jsonLink.optLong("falseClickInterval", 0L)) : null;
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        String strA2 = a("trackingUrl", jsonLink);
        if (strA2 != null) {
            setCreateSetBuilder.add(strA2);
        }
        JSONArray jSONArrayOptJSONArray2 = jsonLink.optJSONArray("trackingUrls");
        if (jSONArrayOptJSONArray2 != null) {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            int length2 = jSONArrayOptJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(jSONArrayOptJSONArray2.getString(i2));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                    String str = (String) objM7904constructorimpl;
                    Intrinsics.checkNotNull(str);
                    listCreateListBuilder.add(str);
                }
            }
            listBuild = CollectionsKt.build(listCreateListBuilder);
        }
        if (listBuild != null) {
            setCreateSetBuilder.addAll(listBuild);
        }
        return new rr0(arrayList, j80Var, CollectionsKt.toList(SetsKt.build(setCreateSetBuilder)), a("url", jsonLink), jsonLink.optLong("clickableDelay", 0L));
    }
}
