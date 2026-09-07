package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class nu1 implements aq1<cu1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iw1 f9757a;
    private final br1<cu1> b;
    private final lu1 c;
    private final Context d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ nu1(Context context, lp1 lp1Var) {
        this(context, lp1Var, iw1.a.a(), new qu1(lp1Var), new lu1());
        int i = iw1.l;
    }

    @Override // com.yandex.mobile.ads.impl.aq1
    public final cu1 a(tc1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        return this.b.a(networkResponse);
    }

    public nu1(Context context, lp1 reporter, iw1 sdkSettings, br1<cu1> sdkConfigurationResponseParser, lu1 sdkConfigurationRefreshChecker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        Intrinsics.checkNotNullParameter(sdkConfigurationResponseParser, "sdkConfigurationResponseParser");
        Intrinsics.checkNotNullParameter(sdkConfigurationRefreshChecker, "sdkConfigurationRefreshChecker");
        this.f9757a = sdkSettings;
        this.b = sdkConfigurationResponseParser;
        this.c = sdkConfigurationRefreshChecker;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.d = applicationContext;
    }

    @Override // com.yandex.mobile.ads.impl.aq1
    public final boolean a() {
        cu1 cu1VarA = this.f9757a.a(this.d);
        return cu1VarA == null || this.c.a(cu1VarA);
    }
}
