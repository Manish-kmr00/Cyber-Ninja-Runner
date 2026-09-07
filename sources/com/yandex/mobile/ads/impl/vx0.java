package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.base.a;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vx0<T extends com.monetization.ads.mediation.base.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<hz0> f10516a;
    private final b80 b;
    private final yx0<T> c;
    private final qx0 d;
    private int e;

    public final mx0<T> a(Context context, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        while (this.e < this.f10516a.size()) {
            List<hz0> list = this.f10516a;
            int i = this.e;
            this.e = i + 1;
            hz0 hz0Var = list.get(i);
            com.monetization.ads.mediation.base.a mediatedAdapter = this.c.a(context, hz0Var, clazz);
            if (mediatedAdapter != null) {
                this.d.getClass();
                Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
                return new mx0<>(mediatedAdapter, hz0Var, new px0(mediatedAdapter), this.b);
            }
        }
        return null;
    }

    public /* synthetic */ vx0(List list, hy0 hy0Var, cy0 cy0Var) {
        this(list, hy0Var, cy0Var, new yx0(cy0Var), new qx0());
    }

    public vx0(List mediationNetworks, hy0 extrasCreator, cy0 mediatedAdapterReporter, yx0 mediatedAdapterCreator, qx0 mediatedAdDataFactory) {
        Intrinsics.checkNotNullParameter(mediationNetworks, "mediationNetworks");
        Intrinsics.checkNotNullParameter(extrasCreator, "extrasCreator");
        Intrinsics.checkNotNullParameter(mediatedAdapterReporter, "mediatedAdapterReporter");
        Intrinsics.checkNotNullParameter(mediatedAdapterCreator, "mediatedAdapterCreator");
        Intrinsics.checkNotNullParameter(mediatedAdDataFactory, "mediatedAdDataFactory");
        this.f10516a = mediationNetworks;
        this.b = extrasCreator;
        this.c = mediatedAdapterCreator;
        this.d = mediatedAdDataFactory;
    }
}
