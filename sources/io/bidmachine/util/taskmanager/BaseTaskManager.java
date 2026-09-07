package io.bidmachine.util.taskmanager;

import com.yandex.div.core.timer.TimerController;
import io.bidmachine.util.Cancelable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseTaskManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H$J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH$¨\u0006\u000e"}, d2 = {"Lio/bidmachine/util/taskmanager/BaseTaskManager;", "Lio/bidmachine/util/taskmanager/TaskManager;", "()V", TimerController.CANCEL_COMMAND, "", "task", "Ljava/lang/Runnable;", "isCancel", "", "cancelTask", "schedule", "delayMs", "", "scheduleTask", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BaseTaskManager implements TaskManager {
    protected abstract void cancelTask(Runnable task) throws Throwable;

    protected abstract void scheduleTask(Runnable task, long delayMs) throws Throwable;

    @Override // io.bidmachine.util.taskmanager.TaskManager
    public void schedule(Runnable task, long delayMs) {
        Intrinsics.checkNotNullParameter(task, "task");
        cancel(task, false);
        try {
            BaseTaskManager baseTaskManager = this;
            scheduleTask(task, delayMs);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
    }

    @Override // io.bidmachine.util.taskmanager.TaskManager
    public void cancel(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        cancel(task, true);
    }

    private final void cancel(Runnable task, boolean isCancel) {
        Cancelable cancelable = task instanceof Cancelable ? (Cancelable) task : null;
        if (cancelable != null) {
            try {
                cancelable.setCancel(isCancel);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
            }
        }
        try {
            BaseTaskManager baseTaskManager = this;
            cancelTask(task);
            Unit unit2 = Unit.INSTANCE;
        } catch (Throwable unused2) {
        }
    }
}
