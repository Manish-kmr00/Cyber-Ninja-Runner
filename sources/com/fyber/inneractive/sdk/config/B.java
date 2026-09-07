package com.fyber.inneractive.sdk.config;

import android.content.Context;

/* JADX INFO: loaded from: classes13.dex */
public final class B implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f1666a;
    public final /* synthetic */ Context b;

    public B(IAConfigManager iAConfigManager, Context context) {
        this.f1666a = iAConfigManager;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Class.forName("com.iab.omid.library.fyber.Omid");
            com.fyber.inneractive.sdk.util.r.b.post(new A(this));
        } catch (Throwable unused) {
        }
    }
}
