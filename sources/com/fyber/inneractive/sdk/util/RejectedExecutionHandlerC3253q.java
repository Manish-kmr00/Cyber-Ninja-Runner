package com.fyber.inneractive.sdk.util;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class RejectedExecutionHandlerC3253q implements RejectedExecutionHandler {
    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        IAlog.a("rejectedExecution received for - %s", runnable);
    }
}
