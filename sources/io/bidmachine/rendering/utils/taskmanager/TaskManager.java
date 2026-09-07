package io.bidmachine.rendering.utils.taskmanager;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public interface TaskManager {
    void cancel(Runnable task);

    void execute(Runnable task);

    default void schedule(Runnable task, long delayMs) {
        schedule(task, delayMs, TimeUnit.MILLISECONDS);
    }

    void schedule(Runnable task, long delay, TimeUnit timeUnit);
}
