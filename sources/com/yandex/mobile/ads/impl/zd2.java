package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class zd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f10809a;
    private final String b;

    public zd2(String str, List clickTrackings) {
        Intrinsics.checkNotNullParameter(clickTrackings, "clickTrackings");
        this.f10809a = clickTrackings;
        this.b = str;
    }

    public final List<String> b() {
        return this.f10809a;
    }

    public final String a() {
        return this.b;
    }
}
