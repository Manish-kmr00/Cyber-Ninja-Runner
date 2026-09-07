package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.flow.C3116v;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes13.dex */
public final class N implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ W f2390a;

    public N(W w) {
        this.f2390a = w;
    }

    @Override // java.lang.Runnable
    public final void run() {
        W w = this.f2390a;
        w.f2397a.stopLoading();
        IAlog.a("%sonLoadTimeout after %d msec", IAlog.a(w), Long.valueOf(w.n));
        C3116v c3116v = w.h;
        if (c3116v == null || w.d == null) {
            return;
        }
        c3116v.a(EnumC3143t.IGNITE_FLOW_FAILED_TO_LOAD_WEBPAGE, w.k, com.fyber.inneractive.sdk.ignite.j.LOAD_WEBPAGE_TIMEOUT.a(), w.d);
    }
}
