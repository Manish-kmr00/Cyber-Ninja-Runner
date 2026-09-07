package io.bidmachine;

import io.bidmachine.utils.task.BackgroundTaskManager;
import io.bidmachine.utils.task.TaskManager;

/* JADX INFO: loaded from: classes5.dex */
class CommonBackgroundTaskManager {
    private static volatile TaskManager instance;

    CommonBackgroundTaskManager() {
    }

    public static TaskManager get() {
        TaskManager backgroundTaskManager = instance;
        if (backgroundTaskManager == null) {
            synchronized (CommonBackgroundTaskManager.class) {
                backgroundTaskManager = instance;
                if (backgroundTaskManager == null) {
                    backgroundTaskManager = new BackgroundTaskManager();
                    instance = backgroundTaskManager;
                }
            }
        }
        return backgroundTaskManager;
    }
}
