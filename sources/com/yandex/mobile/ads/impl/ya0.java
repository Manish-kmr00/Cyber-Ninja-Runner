package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class ya0 implements tg<wa0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xj0 f10715a;

    public ya0(xj0 imageValueParser) {
        Intrinsics.checkNotNullParameter(imageValueParser, "imageValueParser");
        this.f10715a = imageValueParser;
    }

    @Override // com.yandex.mobile.ads.impl.tg
    public final wa0 a(JSONObject jsonAsset) throws p61 {
        Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
        if (jsonAsset.has("value")) {
            return new wa0(!jsonAsset.isNull("value") ? this.f10715a.a(jsonAsset) : null);
        }
        op0.b(new Object[0]);
        throw new p61("Native Ad json has not required attributes");
    }
}
