package com.yandex.mobile.ads.impl;

import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class l02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j02 f9466a = new j02();
    private final ui b = new ui();

    public final k02 a(JSONObject jsonValue) throws JSONException {
        c02 c02Var;
        ti tiVarA;
        ArrayList arrayList;
        l02 l02Var = this;
        String str = "jsonValue";
        Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
        Object objOpt = jsonValue.opt("ColorWizButton");
        String str2 = objOpt instanceof String ? (String) objOpt : null;
        Object objOpt2 = jsonValue.opt("ColorWizButtonText");
        String str3 = objOpt2 instanceof String ? (String) objOpt2 : null;
        Object objOpt3 = jsonValue.opt("ColorWizBack");
        String str4 = objOpt3 instanceof String ? (String) objOpt3 : null;
        Object objOpt4 = jsonValue.opt("ColorWizBackRight");
        String str5 = objOpt4 instanceof String ? (String) objOpt4 : null;
        JSONObject jSONObjectOptJSONObject = jsonValue.optJSONObject("backgroundColors");
        JSONObject jsonValue2 = jsonValue.optJSONObject("smart-center");
        JSONArray jSONArrayOptJSONArray = jsonValue.optJSONArray("smart-centers");
        if (jsonValue2 != null) {
            l02Var.f9466a.getClass();
            Intrinsics.checkNotNullParameter(jsonValue2, "jsonValue");
            c02Var = new c02(jsonValue2.getInt(VastAttributes.HORIZONTAL_POSITION), jsonValue2.getInt(VastAttributes.VERTICAL_POSITION), jsonValue2.getInt("w"), jsonValue2.getInt("h"));
        } else {
            c02Var = null;
        }
        if (jSONObjectOptJSONObject != null) {
            l02Var.b.getClass();
            tiVarA = ui.a(jSONObjectOptJSONObject);
        } else {
            tiVarA = null;
        }
        if (jSONArrayOptJSONArray != null) {
            IntRange intRangeUntil = RangesKt.until(0, jSONArrayOptJSONArray.length());
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                j02 j02Var = l02Var.f9466a;
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(iNextInt);
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(...)");
                j02Var.getClass();
                Intrinsics.checkNotNullParameter(jSONObjectOptJSONObject2, str);
                arrayList2.add(new c02(jSONObjectOptJSONObject2.getInt(VastAttributes.HORIZONTAL_POSITION), jSONObjectOptJSONObject2.getInt(VastAttributes.VERTICAL_POSITION), jSONObjectOptJSONObject2.getInt("w"), jSONObjectOptJSONObject2.getInt("h")));
                l02Var = this;
                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                str = str;
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new k02(str2, str3, str4, str5, tiVarA, c02Var, arrayList);
    }
}
