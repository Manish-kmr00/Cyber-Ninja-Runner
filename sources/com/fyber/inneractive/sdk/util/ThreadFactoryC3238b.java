package com.fyber.inneractive.sdk.util;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class ThreadFactoryC3238b implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }
}
