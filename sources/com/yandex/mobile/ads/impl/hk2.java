package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hk2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9108a;
    private final aa2 b;
    private final fd2 c;
    private final wb2 d;

    public final void a(Context context, eb2 wrapperAd, wp1<List<eb2>> listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(wrapperAd, "wrapperAd");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.d.a(context, this.f9108a, this.b, wrapperAd, this.c, new ik2(context, wrapperAd, listener, new jk2(context, wrapperAd)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hk2(Context context, o3 o3Var, aa2 aa2Var, fd2 fd2Var) {
        this(context, o3Var, aa2Var, fd2Var, wb2.a.a(context));
        int i = wb2.d;
    }

    public hk2(Context context, o3 adConfiguration, aa2 requestConfigurationParametersProvider, fd2 reportParametersProvider, wb2 videoAdLoadNetwork) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(reportParametersProvider, "reportParametersProvider");
        Intrinsics.checkNotNullParameter(videoAdLoadNetwork, "videoAdLoadNetwork");
        this.f9108a = adConfiguration;
        this.b = requestConfigurationParametersProvider;
        this.c = reportParametersProvider;
        this.d = videoAdLoadNetwork;
    }
}
