package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class xj0 implements tg<uj0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mj0 f10659a;

    @Override // com.yandex.mobile.ads.impl.tg
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final uj0 a(JSONObject jsonAsset) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
        if (!jsonAsset.has("value") || jsonAsset.isNull("value")) {
            op0.b(new Object[0]);
            throw new p61("Native Ad json has not required attributes");
        }
        JSONObject jSONObject = jsonAsset.getJSONObject("value");
        mj0 mj0Var = this.f10659a;
        Intrinsics.checkNotNull(jSONObject);
        return mj0Var.b(jSONObject);
    }

    public /* synthetic */ xj0() {
        this(new mj0());
    }

    public xj0(mj0 imageParser) {
        Intrinsics.checkNotNullParameter(imageParser, "imageParser");
        this.f10659a = imageParser;
    }
}
