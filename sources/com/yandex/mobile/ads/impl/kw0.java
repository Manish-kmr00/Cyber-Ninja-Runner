package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class kw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g92 f9454a;

    public kw0(g92 valueReader) {
        Intrinsics.checkNotNullParameter(valueReader, "valueReader");
        this.f9454a = valueReader;
    }

    public final Object a(JSONObject jsonValue) {
        Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
        String strA = this.f9454a.a("html", jsonValue);
        float f = (float) jsonValue.getDouble("aspectRatio");
        if (f == 0.0f) {
            f = 1.7777778f;
        }
        return new su0(strA, f);
    }
}
