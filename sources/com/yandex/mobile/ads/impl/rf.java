package com.yandex.mobile.ads.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.StartupParamsItem;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class rf implements StartupParamsCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nf f10102a;

    public rf(nf appMetricaStartupParamsCallback) {
        Intrinsics.checkNotNullParameter(appMetricaStartupParamsCallback, "appMetricaStartupParamsCallback");
        this.f10102a = appMetricaStartupParamsCallback;
    }

    @Override // io.appmetrica.analytics.StartupParamsCallback
    public final void onRequestError(StartupParamsCallback.Reason reason, StartupParamsCallback.Result result) {
        mf mfVar;
        Intrinsics.checkNotNullParameter(reason, "reason");
        nf nfVar = this.f10102a;
        if (Intrinsics.areEqual(reason, StartupParamsCallback.Reason.NETWORK)) {
            mfVar = mf.c;
        } else {
            mfVar = Intrinsics.areEqual(reason, StartupParamsCallback.Reason.INVALID_RESPONSE) ? mf.d : mf.b;
        }
        nfVar.a(mfVar);
    }

    @Override // io.appmetrica.analytics.StartupParamsCallback
    public final void onReceive(StartupParamsCallback.Result result) {
        Map<String, StartupParamsItem> map;
        StartupParamsItem startupParamsItem;
        Map<String, StartupParamsItem> map2;
        StartupParamsItem startupParamsItem2;
        Map<String, StartupParamsItem> map3;
        StartupParamsItem startupParamsItem3;
        nf nfVar = this.f10102a;
        String id = null;
        String id2 = (result == null || (map3 = result.parameters) == null || (startupParamsItem3 = map3.get(StartupParamsCallback.APPMETRICA_UUID)) == null) ? null : startupParamsItem3.getId();
        String id3 = (result == null || (map2 = result.parameters) == null || (startupParamsItem2 = map2.get(StartupParamsCallback.APPMETRICA_DEVICE_ID)) == null) ? null : startupParamsItem2.getId();
        if (result != null && (map = result.parameters) != null && (startupParamsItem = map.get("appmetrica_get_ad_url")) != null) {
            id = startupParamsItem.getId();
        }
        nfVar.a(new lf(id2, id3, id));
    }
}
