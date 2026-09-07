package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kk2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9426a;
    private final aa2 b;
    private final fd2 c;
    private final Context d;
    private int e;

    public kk2(Context context, o3 adConfiguration, aa2 requestConfigurationParametersProvider, fd2 reportParametersProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(reportParametersProvider, "reportParametersProvider");
        this.f9426a = adConfiguration;
        this.b = requestConfigurationParametersProvider;
        this.c = reportParametersProvider;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.d = applicationContext;
    }

    public final void a(Context context, List<eb2> wrapperAds, wp1<List<eb2>> listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(wrapperAds, "wrapperAds");
        Intrinsics.checkNotNullParameter(listener, "listener");
        int i = this.e + 1;
        this.e = i;
        if (i > 5) {
            Intrinsics.checkNotNullParameter("Maximum count of VAST wrapper requests exceeded.", "description");
            listener.a(new kb2(1, "Maximum count of VAST wrapper requests exceeded."));
            return;
        }
        Context context2 = this.d;
        o3 o3Var = this.f9426a;
        fd2 fd2Var = this.c;
        aa2 aa2Var = this.b;
        new lk2(context2, o3Var, fd2Var, aa2Var, new hk2(context2, o3Var, aa2Var, fd2Var)).a(context, wrapperAds, listener);
    }
}
