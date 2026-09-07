package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class v82 implements u82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t82 f10461a;

    public v82(t82 userAgentCreator) {
        Intrinsics.checkNotNullParameter(userAgentCreator, "userAgentCreator");
        this.f10461a = userAgentCreator;
    }

    @Override // com.yandex.mobile.ads.impl.u82
    public final String a() {
        return this.f10461a.a();
    }
}
