package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class wb2 {
    private static final Object b = new Object();
    private static volatile wb2 c;
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bq1 f10553a;

    public static final class a {
        @JvmStatic
        public static wb2 a(Context context) {
            wb2 wb2Var;
            Intrinsics.checkNotNullParameter(context, "context");
            wb2 wb2Var2 = wb2.c;
            if (wb2Var2 != null) {
                return wb2Var2;
            }
            synchronized (wb2.b) {
                wb2Var = wb2.c;
                if (wb2Var == null) {
                    wb2Var = new wb2(zk2.a(context, 1));
                    wb2.c = wb2Var;
                }
            }
            return wb2Var;
        }
    }

    public wb2(bq1 requestQueue) {
        Intrinsics.checkNotNullParameter(requestQueue, "requestQueue");
        this.f10553a = requestQueue;
    }

    public final void a(Context context, o3 adConfiguration, z92 requestConfiguration, aa2 requestConfigurationParametersProvider, Object requestTag, s92 requestListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(requestTag, "requestTag");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(requestTag, "requestTag");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        this.f10553a.a(new ba2(new ha2()).a(context, adConfiguration, requestConfiguration, requestConfigurationParametersProvider, requestTag, requestListener));
    }

    public final void a(Context context, o3 adConfiguration, aa2 requestConfigurationParametersProvider, eb2 wrapperAd, fd2 reportParametersProvider, ik2 requestListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(wrapperAd, "wrapperAd");
        Intrinsics.checkNotNullParameter(reportParametersProvider, "reportParametersProvider");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(wrapperAd, "wrapperAd");
        Intrinsics.checkNotNullParameter(reportParametersProvider, "reportParametersProvider");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        this.f10553a.a(new qk2(new ha2(), new on0()).a(context, adConfiguration, requestConfigurationParametersProvider, wrapperAd, reportParametersProvider, requestListener));
    }

    public final void a(Context context, o3 adConfiguration, gi2 requestConfiguration, Object requestTag, ii2 requestListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        Intrinsics.checkNotNullParameter(requestTag, "requestTag");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        Intrinsics.checkNotNullParameter(requestTag, "requestTag");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        b8 b8Var = new b8();
        ji2 ji2Var = new ji2();
        up1 up1Var = new up1();
        this.f10553a.a(new hi2(b8Var, ji2Var, up1Var, new fq(up1Var), new h50(), new dx1()).a(context, adConfiguration, requestConfiguration, requestTag, requestListener));
    }
}
