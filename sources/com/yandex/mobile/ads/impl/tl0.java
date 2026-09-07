package com.yandex.mobile.ads.impl;

import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class tl0 {
    private static final Set<u42> b = SetsKt.mutableSetOf(u42.d, u42.e, u42.c, u42.b, u42.f);
    private static final Map<fa2.b, et.a> c = MapsKt.mapOf(TuplesKt.to(fa2.b.b, et.a.c), TuplesKt.to(fa2.b.c, et.a.b), TuplesKt.to(fa2.b.d, et.a.d));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w42 f10313a;

    public final et a(t42 timeOffset) {
        et.a aVar;
        Intrinsics.checkNotNullParameter(timeOffset, "timeOffset");
        fa2 fa2VarA = this.f10313a.a(timeOffset.a());
        if (fa2VarA == null || (aVar = c.get(fa2VarA.c())) == null) {
            return null;
        }
        return new et(aVar, (long) fa2VarA.d());
    }

    public /* synthetic */ tl0() {
        this(new w42(b));
    }

    public tl0(w42 timeOffsetParser) {
        Intrinsics.checkNotNullParameter(timeOffsetParser, "timeOffsetParser");
        this.f10313a = timeOffsetParser;
    }
}
