package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class wm2 implements uu1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10577a;

    public wm2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10577a = context.getApplicationContext();
    }

    @Override // com.yandex.mobile.ads.impl.uu1
    public final dn2 a() {
        return new dn2(new re1());
    }

    @Override // com.yandex.mobile.ads.impl.uu1
    public final gl2 b() {
        return new gl2();
    }

    @Override // com.yandex.mobile.ads.impl.uu1
    public final gn2 d() {
        return new gn2(new re1());
    }

    @Override // com.yandex.mobile.ads.impl.uu1
    public final xm2 e() {
        return new xm2();
    }

    @Override // com.yandex.mobile.ads.impl.uu1
    public final void f() {
        bn2 bn2Var = bn2.f8524a;
    }

    @Override // com.yandex.mobile.ads.impl.uu1
    public final o01 c() {
        Context context = this.f10577a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return nd.a(context, bn2.f8524a, new gl2());
    }
}
