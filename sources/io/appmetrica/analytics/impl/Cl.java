package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class Cl extends X5 {
    public final T3 b;

    public Cl(Context context, String str) {
        this(context, str, new SafePackageManager(), C4486ua.j().e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.appmetrica.analytics.impl.X5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Dl load(W5 w5) {
        Dl dl = (Dl) super.load(w5);
        Hl hl = w5.f11402a;
        dl.d = hl.f;
        dl.e = hl.g;
        Bl bl = (Bl) w5.componentArguments;
        String str = bl.f11077a;
        if (str != null) {
            dl.f = str;
            dl.g = bl.b;
        }
        Map<String, String> map = bl.c;
        dl.h = map;
        dl.i = (L3) this.b.a(new L3(map, X7.c));
        Bl bl2 = (Bl) w5.componentArguments;
        dl.k = bl2.d;
        dl.j = bl2.e;
        Hl hl2 = w5.f11402a;
        dl.l = hl2.p;
        dl.m = hl2.r;
        long j = hl2.v;
        if (dl.n == 0) {
            dl.n = j;
        }
        return dl;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new Dl();
    }

    public Cl(Context context, String str, SafePackageManager safePackageManager, T3 t3) {
        super(context, str, safePackageManager);
        this.b = t3;
    }

    public final Dl a() {
        return new Dl();
    }
}
