package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class sj implements g92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rj f10211a;

    public sj(rj base64Decoder) {
        Intrinsics.checkNotNullParameter(base64Decoder, "base64Decoder");
        this.f10211a = base64Decoder;
    }

    @Override // com.yandex.mobile.ads.impl.g92
    public final String a(String key, JSONObject jsonObject) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(key, "key");
        String strA = f91.a(jsonObject, "jsonAsset", key, "jsonAttribute", key);
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        this.f10211a.getClass();
        String strB = rj.b(strA);
        if (strB == null || strB.length() == 0) {
            throw new p61("Native Ad json has attribute with broken base64 encoding");
        }
        return strB;
    }
}
