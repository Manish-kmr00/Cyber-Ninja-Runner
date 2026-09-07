package io.appmetrica.analytics.impl;

import android.app.Activity;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class RunnableC4201j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f11608a;
    public final /* synthetic */ C4251l b;

    public RunnableC4201j(C4251l c4251l, Activity activity) {
        this.b = c4251l;
        this.f11608a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f11608a);
    }
}
