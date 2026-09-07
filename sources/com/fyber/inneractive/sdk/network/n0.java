package com.fyber.inneractive.sdk.network;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f1928a;
    public final WeakReference b;
    public final int c;
    public final m0 d = new m0(this);

    public n0(U u, Thread thread, int i) {
        this.b = new WeakReference(u);
        this.f1928a = new WeakReference(thread);
        this.c = i;
    }
}
