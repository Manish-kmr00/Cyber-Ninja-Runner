package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class vj implements wj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10484a;
    private final boolean b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vj(Map map) {
        this(map, kf0.a((Map<String, String>) map, sh0.f0, true), kf0.a((Map<String, String>) map, sh0.g0, true));
        kf0.a((Map<String, String>) map, sh0.e0, true);
    }

    @Override // com.yandex.mobile.ads.impl.wj
    public final boolean b() {
        return this.f10484a;
    }

    public vj(Map headers, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f10484a = z;
        this.b = z2;
    }

    @Override // com.yandex.mobile.ads.impl.wj
    public final boolean a() {
        return this.b;
    }
}
