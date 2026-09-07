package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.web.C3266e;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class RunnableC3239c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object[] f2358a;
    public final /* synthetic */ C3266e b;

    public RunnableC3239c(C3266e c3266e) {
        this.b = c3266e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.getClass();
        C3266e c3266e = this.b;
        boolean z = c3266e.f;
        if (z) {
            return;
        }
        RunnableC3240d runnableC3240d = new RunnableC3240d(c3266e);
        c3266e.d = runnableC3240d;
        if (z) {
            return;
        }
        try {
            c3266e.f2406a.execute(runnableC3240d);
        } catch (NullPointerException e) {
            IAlog.f("AsyncTaskExecutor : execute(): Unable to execute the null task: %s", e.getMessage());
        } catch (RejectedExecutionException e2) {
            IAlog.f("AsyncTaskExecutor : execute(): Unable to execute the task: %s", e2.getMessage());
        }
    }
}
