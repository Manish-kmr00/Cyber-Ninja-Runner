package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class yj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xj1 f10745a;

    public /* synthetic */ yj1(j82 j82Var) {
        this(j82Var, new xj1(j82Var));
    }

    public final ArrayList a(JSONArray jSONArray) throws JSONException, p61 {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(this.f10745a.a(jSONObjectOptJSONObject));
                }
            }
        }
        return arrayList;
    }

    public yj1(j82 urlJsonParser, xj1 preferredPackageParser) {
        Intrinsics.checkNotNullParameter(urlJsonParser, "urlJsonParser");
        Intrinsics.checkNotNullParameter(preferredPackageParser, "preferredPackageParser");
        this.f10745a = preferredPackageParser;
    }
}
