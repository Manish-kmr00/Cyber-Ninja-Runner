package io.appmetrica.analytics.impl;

import android.location.Location;
import android.os.Bundle;
import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface Ja extends Nc, H6, InterfaceC3989ab {
    @Override // io.appmetrica.analytics.impl.InterfaceC3989ab
    /* synthetic */ Za a();

    @Override // io.appmetrica.analytics.impl.H6
    /* synthetic */ void a(int i, Bundle bundle);

    @Override // io.appmetrica.analytics.impl.Nc
    /* synthetic */ void a(Location location);

    void a(AppMetricaConfig appMetricaConfig);

    void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig);

    void a(DeferredDeeplinkListener deferredDeeplinkListener);

    void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener);

    void a(ReporterConfig reporterConfig);

    void a(StartupParamsCallback startupParamsCallback, List<String> list);

    @Override // io.appmetrica.analytics.impl.Nc
    /* synthetic */ void a(String str, String str2);

    @Override // io.appmetrica.analytics.impl.Nc
    /* synthetic */ void a(boolean z);

    @Override // io.appmetrica.analytics.impl.Nc
    /* synthetic */ void b(boolean z);

    Ya c(ReporterConfig reporterConfig);

    @Override // io.appmetrica.analytics.impl.Nc
    /* synthetic */ void clearAppEnvironment();

    C4088ea d();

    String e();

    Map<String, String> g();

    AdvIdentifiersResult h();

    C4364pc i();

    @Override // io.appmetrica.analytics.impl.Nc
    /* synthetic */ void putAppEnvironmentValue(String str, String str2);

    @Override // io.appmetrica.analytics.impl.Nc
    /* synthetic */ void setDataSendingEnabled(boolean z);

    @Override // io.appmetrica.analytics.impl.Nc
    /* synthetic */ void setUserProfileID(String str);
}
