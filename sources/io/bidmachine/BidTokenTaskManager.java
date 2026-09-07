package io.bidmachine;

import io.bidmachine.utils.task.BackgroundTaskManager;
import io.bidmachine.utils.task.CancelableTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public class BidTokenTaskManager {
    private static volatile BackgroundTaskManager instance;

    private static BackgroundTaskManager get() {
        BackgroundTaskManager backgroundTaskManager = instance;
        if (backgroundTaskManager == null) {
            synchronized (BackgroundTaskManager.class) {
                backgroundTaskManager = instance;
                if (backgroundTaskManager == null) {
                    backgroundTaskManager = new BackgroundTaskManager();
                    instance = backgroundTaskManager;
                }
            }
        }
        return backgroundTaskManager;
    }

    public static void execute(Runnable runnable) {
        get().execute(runnable);
    }

    public static void schedule(CancelableTask cancelableTask, long j, TimeUnit timeUnit) {
        get().schedule(cancelableTask, j, timeUnit);
    }

    public static void cancel(CancelableTask cancelableTask) {
        get().cancel(cancelableTask);
    }
}
