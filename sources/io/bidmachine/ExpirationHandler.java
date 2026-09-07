package io.bidmachine;

import io.bidmachine.core.Utils;
import io.bidmachine.utils.task.CancelableTask;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
public class ExpirationHandler {
    private final long expirationTimeMs;
    private final ExpiredTask expiredTask;
    private final AtomicBoolean isExpireTrackerSubscribed;
    private final TaskScheduler taskScheduler;

    public interface Listener {
        void onExpired();
    }

    public interface TaskScheduler {
        void cancelTask(CancelableTask cancelableTask);

        void scheduleTask(CancelableTask cancelableTask, long j);
    }

    public ExpirationHandler(long j, Listener listener) {
        this(j, listener, new BackgroundTaskScheduler());
    }

    public ExpirationHandler(long j, Listener listener, TaskScheduler taskScheduler) {
        this.expiredTask = new ExpiredTask(listener);
        this.expirationTimeMs = j;
        this.taskScheduler = taskScheduler;
        this.isExpireTrackerSubscribed = new AtomicBoolean(false);
    }

    TaskScheduler getTaskScheduler() {
        return this.taskScheduler;
    }

    public void start() {
        if (this.expirationTimeMs <= 0 || !this.isExpireTrackerSubscribed.compareAndSet(false, true)) {
            return;
        }
        this.taskScheduler.scheduleTask(this.expiredTask, this.expirationTimeMs);
    }

    public void stop() {
        this.isExpireTrackerSubscribed.set(false);
        this.taskScheduler.cancelTask(this.expiredTask);
    }

    private static class BackgroundTaskScheduler implements TaskScheduler {
        private BackgroundTaskScheduler() {
        }

        @Override // io.bidmachine.ExpirationHandler.TaskScheduler
        public void scheduleTask(CancelableTask cancelableTask, long j) {
            cancelableTask.setCancel(false);
            Utils.onBackgroundThread(cancelableTask, j);
        }

        @Override // io.bidmachine.ExpirationHandler.TaskScheduler
        public void cancelTask(CancelableTask cancelableTask) {
            cancelableTask.setCancel(true);
            Utils.cancelBackgroundThreadTask(cancelableTask);
        }
    }

    private static class ExpiredTask extends CancelableTask {
        private final WeakReference<Listener> weakExpirationListener;

        public ExpiredTask(Listener listener) {
            this.weakExpirationListener = new WeakReference<>(listener);
        }

        @Override // io.bidmachine.utils.task.CancelableTask
        public void runTask() {
            Listener listener = this.weakExpirationListener.get();
            if (listener != null) {
                listener.onExpired();
            }
        }
    }
}
