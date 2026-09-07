package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class nn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f9746a;
    private final String b;

    public nn1(String body, HashMap headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        this.f9746a = headers;
        this.b = body;
    }

    public final Map<String, String> b() {
        return this.f9746a;
    }

    public final String a() {
        return this.b;
    }
}
