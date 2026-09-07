package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class td1 implements tg<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kr1 f10290a;

    public td1(kr1 reviewCountFormatter) {
        Intrinsics.checkNotNullParameter(reviewCountFormatter, "reviewCountFormatter");
        this.f10290a = reviewCountFormatter;
    }

    @Override // com.yandex.mobile.ads.impl.tg
    public final String a(JSONObject jsonAsset) throws p61 {
        Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
        String strA = f91.a(jsonAsset, "jsonAsset", "name", "jsonAttribute", "name");
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
        Intrinsics.checkNotNullParameter("value", "jsonAttribute");
        String strOptString = jsonAsset.optString("value");
        if (strOptString == null || strOptString.length() == 0 || Intrinsics.areEqual(strOptString, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strOptString);
        return Intrinsics.areEqual("review_count", strA) ? this.f10290a.a(strOptString) : strOptString;
    }
}
