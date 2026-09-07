package com.yandex.mobile.ads.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetrica;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class pf implements ue {
    @Override // com.yandex.mobile.ads.impl.ue
    public final qf a(Context context, String apiKey, jf appMetricaPolicyConfigurator, ie appAdAnalyticsActivator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(appMetricaPolicyConfigurator, "appMetricaPolicyConfigurator");
        Intrinsics.checkNotNullParameter(appAdAnalyticsActivator, "appAdAnalyticsActivator");
        try {
            return new qf(LazyKt.lazy(new of(appAdAnalyticsActivator, context, this, apiKey, appMetricaPolicyConfigurator)));
        } catch (Throwable unused) {
            op0.c(new Object[0]);
            return null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ue
    public final String b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return AppMetrica.getDeviceId(context);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
            return null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ue
    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return AppMetrica.getUuid(context);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
            return null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ue
    public final void a(xe listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listener.a("AppMetrica SDK does not support autograb feature since version 6.0.0");
    }

    @Override // com.yandex.mobile.ads.impl.ue
    public final void a(Context context, nf listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            AppMetrica.requestStartupParams(context, new rf(listener), sf.a());
        } catch (Throwable unused) {
            op0.c(new Object[0]);
            listener.a(mf.b);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ue
    public final String a() {
        try {
            return AppMetrica.getLibraryVersion();
        } catch (Throwable unused) {
            op0.c(new Object[0]);
            return null;
        }
    }
}
