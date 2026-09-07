package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class lp implements b0<x> {
    @Override // com.yandex.mobile.ads.impl.b0
    public final x a(JSONObject jsonObject) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String strA = f91.a(jsonObject, "jsonAsset", "type", "jsonAttribute", "type");
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        return new jp(strA);
    }
}
