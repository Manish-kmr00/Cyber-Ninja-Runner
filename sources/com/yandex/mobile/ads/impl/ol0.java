package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class ol0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nl0 f9830a;

    public final ArrayList a(JSONObject jsonObject) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jsonObject.optJSONArray("installedPackages");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jsonObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                nl0 nl0Var = this.f9830a;
                Intrinsics.checkNotNull(jsonObject2);
                nl0Var.getClass();
                Intrinsics.checkNotNullParameter(jsonObject2, "jsonInstalledPackage");
                if (!h91.a(jsonObject2, "name")) {
                    throw new p61("Native Ad json has not required attributes");
                }
                String strA = f91.a(jsonObject2, "jsonAsset", "name", "jsonAttribute", "name");
                if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
                    throw new p61("Native Ad json has not required attributes");
                }
                Intrinsics.checkNotNull(strA);
                int i2 = oa.b;
                Intrinsics.checkNotNullParameter(jsonObject2, "jsonObject");
                Intrinsics.checkNotNullParameter("minVersion", "jsonAttribute");
                int iOptInt = jsonObject2.optInt("minVersion", 0);
                if (iOptInt < 0) {
                    iOptInt = 0;
                }
                Intrinsics.checkNotNullParameter(jsonObject2, "jsonObject");
                Intrinsics.checkNotNullParameter("maxVersion", "jsonAttribute");
                int i3 = Integer.MAX_VALUE;
                int iOptInt2 = jsonObject2.optInt("maxVersion", Integer.MAX_VALUE);
                if (iOptInt2 >= 0) {
                    i3 = iOptInt2;
                }
                arrayList.add(new ml0(iOptInt, i3, strA));
            }
        }
        return arrayList;
    }

    public /* synthetic */ ol0() {
        this(new nl0());
    }

    public ol0(nl0 installedPackageJsonParser) {
        Intrinsics.checkNotNullParameter(installedPackageJsonParser, "installedPackageJsonParser");
        this.f9830a = installedPackageJsonParser;
    }
}
