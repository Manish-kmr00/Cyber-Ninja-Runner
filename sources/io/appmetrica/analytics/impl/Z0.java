package io.appmetrica.analytics.impl;

import android.app.Activity;

/* JADX INFO: loaded from: classes7.dex */
public final class Z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f11443a;
    public final /* synthetic */ C4278m1 b;

    public Z0(C4278m1 c4278m1, Activity activity) {
        this.b = c4278m1;
        this.f11443a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1 c4278m1 = this.b;
        Ak ak = c4278m1.h;
        Activity activity = this.f11443a;
        Pa pa = c4278m1.d().f11720a;
        if (activity != null) {
            ak.f.a(activity);
        }
        if (ak.e.a(activity, EnumC4376q.RESUMED)) {
            pa.a(activity);
        }
    }
}
