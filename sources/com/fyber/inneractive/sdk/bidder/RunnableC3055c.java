package com.fyber.inneractive.sdk.bidder;

import com.fyber.inneractive.sdk.util.AbstractC3251o;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.bidder.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class RunnableC3055c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3056d f1629a;

    public RunnableC3055c(C3056d c3056d) {
        this.f1629a = c3056d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1629a.b = AbstractC3251o.i();
    }
}
