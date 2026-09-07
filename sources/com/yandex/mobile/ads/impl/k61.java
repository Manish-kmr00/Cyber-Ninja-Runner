package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k61 implements yc1<u61> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final aq1<u61> f9385a;
    private final si2<u61> b;

    @Override // com.yandex.mobile.ads.impl.yc1
    public final pi2 a(Context context, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        return sc1.a(adConfiguration, this.b);
    }

    public /* synthetic */ k61(aq1 aq1Var) {
        this(aq1Var, new v61(aq1Var));
    }

    public k61(aq1<u61> requestPolicy, si2<u61> responseBodyParser) {
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        Intrinsics.checkNotNullParameter(responseBodyParser, "responseBodyParser");
        this.f9385a = requestPolicy;
        this.b = responseBodyParser;
    }
}
