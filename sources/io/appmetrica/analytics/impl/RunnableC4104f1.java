package io.appmetrica.analytics.impl;

import android.app.Activity;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.f1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class RunnableC4104f1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f11541a;
    public final /* synthetic */ C4278m1 b;

    public RunnableC4104f1(C4278m1 c4278m1, Activity activity) {
        this.b = c4278m1;
        this.f11541a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1 c4278m1 = this.b;
        Ak ak = c4278m1.h;
        Activity activity = this.f11541a;
        Pa pa = c4278m1.d().f11720a;
        if (activity != null) {
            ak.f.a(activity);
        }
        if (ak.e.a(activity, EnumC4376q.PAUSED)) {
            pa.b(activity);
        }
    }
}
