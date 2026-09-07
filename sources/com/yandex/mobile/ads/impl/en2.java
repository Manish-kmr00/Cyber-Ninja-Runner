package com.yandex.mobile.ads.impl;

import kotlin.Function;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class en2 implements qa2, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ fn2 f8815a;

    en2(fn2 fn2Var) {
        this.f8815a = fn2Var;
    }

    @Override // com.yandex.mobile.ads.impl.qa2
    public final void a(pa2 p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        fn2.a(this.f8815a, p0);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof qa2) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.f8815a, fn2.class, "trackVerificationNotExecuted", "trackVerificationNotExecuted(Lcom/yandex/mobile/ads/video/playback/tracker/verification/omsdk/error/VerificationNotExecutedException;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
