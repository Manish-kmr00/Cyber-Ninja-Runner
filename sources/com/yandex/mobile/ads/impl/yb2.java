package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class yb2 implements hv1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ dc2 f10722a;
    final /* synthetic */ Object b;
    final /* synthetic */ Function0<Unit> c;
    final /* synthetic */ Function1<kb2, Unit> d;

    /* JADX WARN: Multi-variable type inference failed */
    yb2(dc2 dc2Var, Object obj, Function0<Unit> function0, Function1<? super kb2, Unit> function1) {
        this.f10722a = dc2Var;
        this.b = obj;
        this.c = function0;
        this.d = function1;
    }

    @Override // com.yandex.mobile.ads.impl.hv1.a
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f10722a.f.getClass();
        Intrinsics.checkNotNullParameter(error, "error");
        this.d.invoke(new kb2(error.b(), error.d() != null ? error.c() : "Internal error occured while loading ads."));
    }

    @Override // com.yandex.mobile.ads.impl.hv1.a
    public final void a(jc advertisingConfiguration, l50 environmentConfiguration) {
        Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
        Intrinsics.checkNotNullParameter(environmentConfiguration, "environmentConfiguration");
        dc2.a(this.f10722a, advertisingConfiguration, environmentConfiguration);
        this.f10722a.h.add(this.b);
        this.c.invoke();
    }
}
