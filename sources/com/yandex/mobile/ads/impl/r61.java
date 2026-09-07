package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r61 implements aq1<u61> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final br1<u61> f10077a;

    @Override // com.yandex.mobile.ads.impl.aq1
    public final boolean a() {
        return true;
    }

    public /* synthetic */ r61(Context context, lp1 lp1Var) {
        this(context, lp1Var, new y61(context, lp1Var));
    }

    @Override // com.yandex.mobile.ads.impl.aq1
    public final u61 a(tc1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        return this.f10077a.a(networkResponse);
    }

    public r61(Context context, lp1 reporter, br1<u61> nativeAdResponseParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(nativeAdResponseParser, "nativeAdResponseParser");
        this.f10077a = nativeAdResponseParser;
    }
}
