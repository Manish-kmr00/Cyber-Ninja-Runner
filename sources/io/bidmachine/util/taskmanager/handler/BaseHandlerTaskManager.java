package io.bidmachine.util.taskmanager.handler;

import android.os.Handler;
import android.os.Looper;
import io.bidmachine.util.taskmanager.BaseTaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseHandlerTaskManager.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/bidmachine/util/taskmanager/handler/BaseHandlerTaskManager;", "Lio/bidmachine/util/taskmanager/BaseTaskManager;", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "cancelTask", "", "task", "Ljava/lang/Runnable;", "isCurrentThread", "", "scheduleTask", "delayMs", "", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BaseHandlerTaskManager extends BaseTaskManager {
    protected abstract Handler getHandler();

    @Override // io.bidmachine.util.taskmanager.BaseTaskManager
    protected void scheduleTask(Runnable task, long delayMs) throws Throwable {
        Intrinsics.checkNotNullParameter(task, "task");
        if (delayMs > 0) {
            getHandler().postDelayed(task, delayMs);
        } else if (isCurrentThread()) {
            task.run();
        } else {
            getHandler().post(task);
        }
    }

    @Override // io.bidmachine.util.taskmanager.BaseTaskManager
    protected void cancelTask(Runnable task) throws Throwable {
        Intrinsics.checkNotNullParameter(task, "task");
        getHandler().removeCallbacks(task);
    }

    private final boolean isCurrentThread() {
        return Intrinsics.areEqual(Looper.myLooper(), getHandler().getLooper());
    }
}
