package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class p2 implements bg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k9 f9888a;
    private final String b;
    private final t42 c;
    private final List<String> d;
    private final Map<String, List<String>> e;
    private r2 f;

    public p2(k9 adSource, String str, t42 timeOffset, List breakTypes, ArrayList extensions, HashMap trackingEvents) {
        Intrinsics.checkNotNullParameter(adSource, "adSource");
        Intrinsics.checkNotNullParameter(timeOffset, "timeOffset");
        Intrinsics.checkNotNullParameter(breakTypes, "breakTypes");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        Intrinsics.checkNotNullParameter(trackingEvents, "trackingEvents");
        this.f9888a = adSource;
        this.b = str;
        this.c = timeOffset;
        this.d = breakTypes;
        this.e = trackingEvents;
    }

    public final k9 b() {
        return this.f9888a;
    }

    public final String c() {
        return this.b;
    }

    public final t42 f() {
        return this.c;
    }

    public final List<String> d() {
        return this.d;
    }

    @Override // com.yandex.mobile.ads.impl.bg2
    public final Map<String, List<String>> a() {
        return this.e;
    }

    public final r2 e() {
        return this.f;
    }

    public final void a(r2 r2Var) {
        this.f = r2Var;
    }
}
