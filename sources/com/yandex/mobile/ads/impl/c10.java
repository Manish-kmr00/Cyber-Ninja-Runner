package com.yandex.mobile.ads.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class c10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ak0 f8557a;

    public final x00 a(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String strOptString = jsonObject.optString("type");
        String strOptString2 = jsonObject.optString(TypedValues.AttributesType.S_TARGET);
        String strOptString3 = jsonObject.optString("layout");
        if (strOptString == null || strOptString.length() == 0 || strOptString2 == null || strOptString2.length() == 0 || strOptString3 == null || strOptString3.length() == 0) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jsonObject.optJSONArray("images");
        ArrayList arrayListA = jSONArrayOptJSONArray != null ? this.f8557a.a(jSONArrayOptJSONArray) : null;
        Intrinsics.checkNotNull(strOptString);
        Intrinsics.checkNotNull(strOptString2);
        Intrinsics.checkNotNull(strOptString3);
        return new x00(strOptString, strOptString2, strOptString3, arrayListA);
    }

    public /* synthetic */ c10() {
        this(new ak0());
    }

    public c10(ak0 imageValuesParser) {
        Intrinsics.checkNotNullParameter(imageValuesParser, "imageValuesParser");
        this.f8557a = imageValuesParser;
    }
}
