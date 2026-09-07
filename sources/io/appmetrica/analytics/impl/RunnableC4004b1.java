package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.b1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class RunnableC4004b1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f11471a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C4278m1 d;

    public RunnableC4004b1(C4278m1 c4278m1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c4278m1;
        this.f11471a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4377q0 c4377q0 = this.d.f11662a;
        Context applicationContext = this.f11471a.getApplicationContext();
        c4377q0.getClass();
        C4352p0 c4352p0A = C4352p0.a(applicationContext);
        c4352p0A.f().a(this.b, this.c);
    }
}
