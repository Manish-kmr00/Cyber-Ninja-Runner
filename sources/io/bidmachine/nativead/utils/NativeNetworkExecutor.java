package io.bidmachine.nativead.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class NativeNetworkExecutor implements Executor {
    private static NativeNetworkExecutor executor;
    private final ThreadPoolExecutor loaderExecutor;

    public static NativeNetworkExecutor getInstance() {
        if (executor == null) {
            executor = new NativeNetworkExecutor();
        }
        return executor;
    }

    private NativeNetworkExecutor() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        this.loaderExecutor = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 0L, TimeUnit.MICROSECONDS, new LinkedBlockingQueue());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.loaderExecutor.execute(runnable);
    }
}
