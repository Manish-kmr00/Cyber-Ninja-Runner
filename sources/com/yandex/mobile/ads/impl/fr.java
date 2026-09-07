package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ol0 f8919a;

    public final fb0 a(String conditionKey, JSONObject jsonNativeAd) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonNativeAd, "jsonNativeAd");
        Intrinsics.checkNotNullParameter(conditionKey, "conditionKey");
        JSONObject jSONObject = jsonNativeAd.getJSONObject(conditionKey);
        ol0 ol0Var = this.f8919a;
        Intrinsics.checkNotNull(jSONObject);
        return new fb0(ol0Var.a(jSONObject));
    }

    public /* synthetic */ fr() {
        this(new ol0());
    }

    public fr(ol0 installedPackagesJsonParser) {
        Intrinsics.checkNotNullParameter(installedPackagesJsonParser, "installedPackagesJsonParser");
        this.f8919a = installedPackagesJsonParser;
    }
}
