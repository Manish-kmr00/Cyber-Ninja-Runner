package io.bidmachine.utils.task;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public interface TaskManager {
    void cancel(CancelableTask cancelableTask);

    void execute(Runnable runnable);

    void schedule(CancelableTask cancelableTask, long j, TimeUnit timeUnit);

    default void schedule(CancelableTask cancelableTask, long j) {
        schedule(cancelableTask, j, TimeUnit.MILLISECONDS);
    }
}
