package com.fyber.inneractive.sdk.config;

import java.util.Iterator;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class RunnableC3087q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3088s f1715a;

    public RunnableC3087q(C3088s c3088s) {
        this.f1715a = c3088s;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3088s c3088s = this.f1715a;
        Iterator it = c3088s.c.iterator();
        while (it.hasNext()) {
            ((r) it.next()).onGlobalConfigChanged(c3088s, c3088s.b);
        }
    }
}
