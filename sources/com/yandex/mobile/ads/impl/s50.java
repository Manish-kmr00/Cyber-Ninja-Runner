package com.yandex.mobile.ads.impl;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f10177a = SetsKt.setOf("sysconst-update");

    public final boolean a(String param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return !this.f10177a.contains(param);
    }
}
