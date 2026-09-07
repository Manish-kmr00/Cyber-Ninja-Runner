package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class co0 implements aa2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z92 f8629a;

    public co0(z92 requestConfiguration) {
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        this.f8629a = requestConfiguration;
    }

    @Override // com.yandex.mobile.ads.impl.aa2
    public final Map<String, String> a() {
        a8 a8Var = new a8(this.f8629a.a());
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Map<String, String> mapB = this.f8629a.b();
        if (mapB != null) {
            mapCreateMapBuilder.putAll(mapB);
        }
        String strE = a8Var.e();
        if (strE != null) {
            mapCreateMapBuilder.put("video-session-id", strE);
        }
        return MapsKt.build(mapCreateMapBuilder);
    }
}
