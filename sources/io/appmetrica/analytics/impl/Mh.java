package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;

/* JADX INFO: loaded from: classes5.dex */
public final class Mh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReporterConfig f11260a;
    public final /* synthetic */ Yh b;

    public Mh(Yh yh, ReporterConfig reporterConfig) {
        this.b = yh;
        this.f11260a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        ReporterConfig reporterConfig = this.f11260a;
        C4377q0 c4377q0 = yh.f11439a;
        Context context = yh.d;
        c4377q0.getClass();
        C4352p0.a(context).f().a(reporterConfig);
    }
}
