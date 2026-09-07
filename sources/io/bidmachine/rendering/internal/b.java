package io.bidmachine.rendering.internal;

import io.bidmachine.rendering.utils.taskmanager.BackgroundTaskManager;
import io.bidmachine.rendering.utils.taskmanager.TaskManager;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public class b implements TaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile BackgroundTaskManager f12348a;

    private static BackgroundTaskManager a() {
        BackgroundTaskManager backgroundTaskManager = f12348a;
        if (backgroundTaskManager == null) {
            synchronized (BackgroundTaskManager.class) {
                backgroundTaskManager = f12348a;
                if (backgroundTaskManager == null) {
                    backgroundTaskManager = new BackgroundTaskManager();
                    f12348a = backgroundTaskManager;
                }
            }
        }
        return backgroundTaskManager;
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.TaskManager
    public void cancel(Runnable runnable) {
        a().cancel(runnable);
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.TaskManager
    public void execute(Runnable runnable) {
        a().execute(runnable);
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.TaskManager
    public void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        a().schedule(runnable, j, timeUnit);
    }
}
