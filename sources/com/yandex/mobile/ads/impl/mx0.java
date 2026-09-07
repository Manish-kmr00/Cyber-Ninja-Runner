package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.base.a;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class mx0<T extends com.monetization.ads.mediation.base.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f9676a;
    private final hz0 b;
    private final px0 c;
    private final b80 d;

    public mx0(T mediatedAdapter, hz0 mediationNetwork, px0 mediatedAdData, b80 extrasCreator) {
        Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(mediatedAdData, "mediatedAdData");
        Intrinsics.checkNotNullParameter(extrasCreator, "extrasCreator");
        this.f9676a = mediatedAdapter;
        this.b = mediationNetwork;
        this.c = mediatedAdData;
        this.d = extrasCreator;
    }

    public final Map<String, Object> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.d.a(context);
    }

    public final T b() {
        return this.f9676a;
    }

    public final hz0 c() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.d.a(this.b);
    }

    public final px0 a() {
        return this.c;
    }
}
