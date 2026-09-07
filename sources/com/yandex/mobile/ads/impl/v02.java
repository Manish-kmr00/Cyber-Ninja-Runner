package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class v02 implements tg<u02> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mj0 f10441a;

    @Override // com.yandex.mobile.ads.impl.tg
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final u02 a(JSONObject jsonAsset) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
        String strA = f91.a(jsonAsset, "jsonAsset", "title", "jsonAttribute", "title");
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        JSONObject jSONObject = jsonAsset.getJSONObject("image");
        mj0 mj0Var = this.f10441a;
        Intrinsics.checkNotNull(jSONObject);
        return new u02(mj0Var.b(jSONObject), strA);
    }

    public /* synthetic */ v02() {
        this(new mj0());
    }

    public v02(mj0 imageParser) {
        Intrinsics.checkNotNullParameter(imageParser, "imageParser");
        this.f10441a = imageParser;
    }
}
