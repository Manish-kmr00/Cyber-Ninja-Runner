package net.pubnative.lite.sdk.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public class BitmapDownloaderExecutor {
    private static final int CORE_POOL_SIZE = 4;
    private static final long KEEP_ALIVE_TIME = 60;
    private static final int MAX_POOL_SIZE = 10;
    private static final TimeUnit TIME_UNIT;
    private static final BlockingQueue<Runnable> WORK_QUEUE;
    private static final ExecutorService sExecutor;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        TIME_UNIT = timeUnit;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        WORK_QUEUE = linkedBlockingQueue;
        sExecutor = new ThreadPoolExecutor(4, 10, 60L, timeUnit, linkedBlockingQueue, new ThreadPoolExecutor.CallerRunsPolicy());
    }

    private BitmapDownloaderExecutor() {
    }

    public static synchronized ExecutorService getExecutor() {
        return sExecutor;
    }
}
