package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes10.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ A f1842a;

    public z(A a2) {
        this.f1842a = a2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        A a2 = this.f1842a;
        a2.getClass();
        IAlog.a("%sRe-enabling clicks, grace period has passed", IAlog.a(a2));
        A a3 = this.f1842a;
        a3.f = true;
        a3.g = null;
    }
}
