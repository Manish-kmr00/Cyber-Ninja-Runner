package io.bidmachine.utils.task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
public class BackgroundTaskManager implements TaskManager {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(CORE_POOL_SIZE);
    private final Map<Runnable, Future<?>> futureMap = new ConcurrentHashMap();

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        CORE_POOL_SIZE = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
    }

    @Override // io.bidmachine.utils.task.TaskManager
    public void execute(Runnable runnable) {
        try {
            this.executor.execute(runnable);
        } catch (Throwable unused) {
        }
    }

    @Override // io.bidmachine.utils.task.TaskManager
    public void schedule(CancelableTask cancelableTask, long j, TimeUnit timeUnit) {
        try {
            cancelableTask.setCancel(false);
            this.futureMap.put(cancelableTask, this.executor.schedule(new ScheduledTask(cancelableTask), j, timeUnit));
        } catch (Throwable unused) {
        }
    }

    @Override // io.bidmachine.utils.task.TaskManager
    public void cancel(CancelableTask cancelableTask) {
        try {
            cancelableTask.setCancel(true);
            Future<?> futureRemoveFuture = removeFuture(cancelableTask);
            if (futureRemoveFuture == null) {
                return;
            }
            futureRemoveFuture.cancel(false);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Future<?> removeFuture(Runnable runnable) {
        try {
            return this.futureMap.remove(runnable);
        } catch (Throwable unused) {
            return null;
        }
    }

    Map<Runnable, Future<?>> getFutureMap() {
        return this.futureMap;
    }

    private class ScheduledTask implements Runnable {
        private final Runnable runnable;

        public ScheduledTask(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            BackgroundTaskManager.this.removeFuture(this.runnable);
            this.runnable.run();
        }
    }
}
