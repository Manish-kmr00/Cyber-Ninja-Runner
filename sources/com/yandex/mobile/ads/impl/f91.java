package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class f91 {
    public static String a(JSONObject jSONObject, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(jSONObject, str);
        Intrinsics.checkNotNullParameter(str2, str3);
        return jSONObject.optString(str4);
    }
}
