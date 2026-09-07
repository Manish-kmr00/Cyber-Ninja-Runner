package io.bidmachine.util.taskmanager;

import com.yandex.div.core.timer.TimerController;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TaskManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/util/taskmanager/TaskManager;", "", TimerController.CANCEL_COMMAND, "", "task", "Ljava/lang/Runnable;", "execute", "schedule", "delayMs", "", "delay", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface TaskManager {
    void cancel(Runnable task);

    void schedule(Runnable task, long delayMs);

    default void execute(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        schedule(task, 0L);
    }

    default void schedule(Runnable task, long delay, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        schedule(task, timeUnit.toMillis(delay));
    }
}
