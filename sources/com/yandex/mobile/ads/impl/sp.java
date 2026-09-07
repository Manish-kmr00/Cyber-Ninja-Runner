package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class sp implements tg<rp> {
    @Override // com.yandex.mobile.ads.impl.tg
    public final rp a(JSONObject jsonAsset) throws p61 {
        Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
        if (jsonAsset.has("value") && jsonAsset.isNull("value")) {
            return new rp(rp.a.c, null);
        }
        rp.a aVar = rp.a.b;
        String strA = f91.a(jsonAsset, "jsonAsset", "value", "jsonAttribute", "value");
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        return new rp(aVar, strA);
    }
}
