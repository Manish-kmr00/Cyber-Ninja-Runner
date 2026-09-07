package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ak0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mj0 f8413a;

    public final ArrayList a(JSONArray jsonArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            mj0 mj0Var = this.f8413a;
            JSONObject jSONObject = jsonArray.getJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
            arrayList.add(mj0Var.b(jSONObject));
        }
        return arrayList;
    }

    public /* synthetic */ ak0() {
        this(new mj0());
    }

    public ak0(mj0 imageParser) {
        Intrinsics.checkNotNullParameter(imageParser, "imageParser");
        this.f8413a = imageParser;
    }
}
