package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class gs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, fs> f9032a = MapsKt.mapOf(TuplesKt.to("html", fs.b), TuplesKt.to("native", fs.c));

    public static fs a(Map headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        return f9032a.get(kf0.a(headers, sh0.v));
    }
}
