package com.fyber.inneractive.sdk.flow;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class RunnableC3098c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3099d f1785a;

    public RunnableC3098c(C3099d c3099d) {
        this.f1785a = c3099d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.fyber.inneractive.sdk.util.r.b.post(this.f1785a.c);
    }
}
