package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes7.dex */
public final class J implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ U f1909a;
    public final /* synthetic */ L b;

    public J(L l, U u) {
        this.b = l;
        this.f1909a = u;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.e("retryNetworkRequest pre-execute - %s", this.f1909a.getClass().getName());
        this.b.b(this.f1909a);
    }
}
