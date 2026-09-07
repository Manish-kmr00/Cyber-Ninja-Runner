package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kl0 implements pk.a<ox> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function1<ox, Unit> f9428a;
    final /* synthetic */ Function1<ki2, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    kl0(Function1<? super ox, Unit> function1, Function1<? super ki2, Unit> function2) {
        this.f9428a = function1;
        this.b = function2;
    }

    @Override // com.yandex.mobile.ads.impl.qq1.a
    public final void a(ki2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.b.invoke(error);
    }

    @Override // com.yandex.mobile.ads.impl.qq1.b
    public final void a(Object obj) {
        ox response = (ox) obj;
        Intrinsics.checkNotNullParameter(response, "response");
        this.f9428a.invoke(response);
    }
}
