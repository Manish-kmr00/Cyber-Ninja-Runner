package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class RunnableC3105j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC3106k f1802a;

    public RunnableC3105j(AbstractC3106k abstractC3106k) {
        this.f1802a = abstractC3106k;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC3106k abstractC3106k = this.f1802a;
        abstractC3106k.getClass();
        IAlog.a("%s : IAAdContentLoaderImpl : retry load ad task started execution", IAlog.a(abstractC3106k));
        this.f1802a.b();
    }
}
