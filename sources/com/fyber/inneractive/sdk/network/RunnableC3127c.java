package com.fyber.inneractive.sdk.network;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class RunnableC3127c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1917a;
    public final /* synthetic */ long b;
    public final /* synthetic */ C3130f c;

    public RunnableC3127c(C3130f c3130f, int i, long j) {
        this.c = c3130f;
        this.f1917a = i;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.d.sendEmptyMessageDelayed(this.f1917a, this.b);
    }
}
