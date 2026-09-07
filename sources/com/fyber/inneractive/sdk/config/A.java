package com.fyber.inneractive.sdk.config;

import android.content.Context;

/* JADX INFO: loaded from: classes13.dex */
public final class A implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1665a;

    public A(B b) {
        this.f1665a = b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1665a.f1666a.K = new com.fyber.inneractive.sdk.measurement.e();
        B b = this.f1665a;
        com.fyber.inneractive.sdk.measurement.e eVar = b.f1666a.K;
        Context context = b.b;
        if (eVar.f1859a) {
            return;
        }
        eVar.f1859a = true;
        com.fyber.inneractive.sdk.util.r.b.post(new com.fyber.inneractive.sdk.measurement.d(eVar, context));
    }
}
