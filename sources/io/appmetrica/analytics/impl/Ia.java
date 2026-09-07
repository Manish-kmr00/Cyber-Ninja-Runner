package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;

/* JADX INFO: loaded from: classes5.dex */
public interface Ia {
    C4505v4 a();

    void a(AppMetricaConfig appMetricaConfig, InterfaceC3989ab interfaceC3989ab);

    Handler b();

    W1 c();

    C4388qb d();

    ICommonExecutor getDefaultExecutor();
}
