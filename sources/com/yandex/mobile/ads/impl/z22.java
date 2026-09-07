package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class z22 implements tg<String> {
    @Override // com.yandex.mobile.ads.impl.tg
    public final String a(JSONObject jsonAsset) throws p61 {
        Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
        String strA = f91.a(jsonAsset, "jsonAsset", "value", "jsonAttribute", "value");
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        return strA;
    }
}
