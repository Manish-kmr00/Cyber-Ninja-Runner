package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ty implements b0<ry> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j82 f10338a;
    private final yj1 b;

    public ty(j82 urlJsonParser, yj1 preferredPackagesParser) {
        Intrinsics.checkNotNullParameter(urlJsonParser, "urlJsonParser");
        Intrinsics.checkNotNullParameter(preferredPackagesParser, "preferredPackagesParser");
        this.f10338a = urlJsonParser;
        this.b = preferredPackagesParser;
    }

    @Override // com.yandex.mobile.ads.impl.b0
    public final x a(JSONObject jsonObject) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String strA = f91.a(jsonObject, "jsonAsset", "type", "jsonAttribute", "type");
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        this.f10338a.getClass();
        return new ry(strA, j82.a("fallbackUrl", jsonObject), this.b.a(jsonObject.optJSONArray("preferredPackages")));
    }
}
