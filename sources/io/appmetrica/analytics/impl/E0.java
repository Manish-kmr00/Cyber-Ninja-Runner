package io.appmetrica.analytics.impl;

import android.content.Intent;

/* JADX INFO: loaded from: classes13.dex */
public final class E0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f11112a;
    public final /* synthetic */ C4278m1 b;

    public E0(C4278m1 c4278m1, Intent intent) {
        this.b = c4278m1;
        this.f11112a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        G7 g7 = this.b.d().b;
        Intent intent = this.f11112a;
        g7.getClass();
        if (intent != null) {
            g7.a(intent.getDataString(), false);
        }
    }
}
