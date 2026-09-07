package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.varioqub.appmetricaadapter.AppMetricaAdapter;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class we {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppMetricaAdapter f10558a;

    public we(Context context) {
        AppMetricaAdapter appMetricaAdapter;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            appMetricaAdapter = new AppMetricaAdapter(context);
        } catch (Throwable th) {
            String str = "Couldn't create AppMetricaAdapter, cause = " + th;
            op0.b(new Object[0]);
            appMetricaAdapter = null;
        }
        this.f10558a = appMetricaAdapter;
    }

    public final void a(String apiKey) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        try {
            AppMetricaAdapter appMetricaAdapter = this.f10558a;
            if (appMetricaAdapter != null) {
                appMetricaAdapter.setCustomReporter(apiKey);
            }
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
    }

    public final void b(String experiments) {
        Intrinsics.checkNotNullParameter(experiments, "experiments");
        try {
            AppMetricaAdapter appMetricaAdapter = this.f10558a;
            if (appMetricaAdapter != null) {
                appMetricaAdapter.setExperiments(experiments);
            }
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
    }

    public final void a(Set<Long> testIds) {
        Intrinsics.checkNotNullParameter(testIds, "testIds");
        try {
            AppMetricaAdapter appMetricaAdapter = this.f10558a;
            if (appMetricaAdapter != null) {
                appMetricaAdapter.setTriggeredTestIds(testIds);
            }
        } catch (Throwable unused) {
            testIds.toString();
            op0.c(new Object[0]);
        }
    }
}
