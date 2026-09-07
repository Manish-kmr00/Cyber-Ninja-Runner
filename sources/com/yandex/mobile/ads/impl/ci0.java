package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ci0 extends mk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mk f8612a;
    private final u82 b;

    public ci0(mk httpStackDelegate, u82 userAgentProvider) {
        Intrinsics.checkNotNullParameter(httpStackDelegate, "httpStackDelegate");
        Intrinsics.checkNotNullParameter(userAgentProvider, "userAgentProvider");
        this.f8612a = httpStackDelegate;
        this.b = userAgentProvider;
    }

    @Override // com.yandex.mobile.ads.impl.mk
    public final zh0 a(np1<?> request, Map<String, String> additionalHeaders) throws zh, IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(additionalHeaders, "additionalHeaders");
        HashMap map = new HashMap();
        map.putAll(additionalHeaders);
        map.put(sh0.U.a(), this.b.a());
        zh0 zh0VarA = this.f8612a.a(request, map);
        Intrinsics.checkNotNullExpressionValue(zh0VarA, "executeRequest(...)");
        return zh0VarA;
    }
}
