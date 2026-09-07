package io.bidmachine.rendering.utils.taskmanager;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes12.dex */
public abstract class SingleThreadTaskManager extends BaseTaskManager {
    protected abstract Handler a();

    protected boolean b() {
        return Looper.myLooper() == a().getLooper();
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.BaseTaskManager, io.bidmachine.rendering.utils.taskmanager.TaskManager
    public void cancel(Runnable task) {
        super.cancel(task);
        a().removeCallbacks(task);
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.BaseTaskManager, io.bidmachine.rendering.utils.taskmanager.TaskManager
    public void execute(Runnable task) {
        super.execute(task);
        if (b()) {
            task.run();
        } else {
            a().post(task);
        }
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.BaseTaskManager, io.bidmachine.rendering.utils.taskmanager.TaskManager
    public void schedule(Runnable task, long delay, TimeUnit timeUnit) {
        super.schedule(task, delay, timeUnit);
        a().postDelayed(task, timeUnit.toMillis(delay));
    }
}
