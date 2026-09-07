package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class RunnableC3279s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f2421a;

    public RunnableC3279s(I i) {
        this.f2421a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            I i = this.f2421a;
            if (i.V != null) {
                i.getClass();
                IAlog.a("%sunregistering orientation broadcast receiver", IAlog.a(i));
                this.f2421a.V.a();
            }
        } catch (IllegalArgumentException e) {
            if (e.getMessage() != null && !e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
        this.f2421a.V = null;
    }
}
