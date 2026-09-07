package io.bidmachine.util.taskmanager;

import io.bidmachine.util.Cancelable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: compiled from: CancelableTask.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/bidmachine/util/taskmanager/CancelableTask;", "Ljava/lang/Runnable;", "Lio/bidmachine/util/Cancelable;", "()V", "isCanceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "run", "", "runTask", "setCancel", "isCancel", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class CancelableTask implements Runnable, Cancelable {
    private final AtomicBoolean isCanceled = new AtomicBoolean(false);

    public abstract void runTask();

    @Override // java.lang.Runnable
    public void run() {
        if (isCanceled()) {
            return;
        }
        runTask();
    }

    @Override // io.bidmachine.util.Cancelable
    public boolean isCanceled() {
        return this.isCanceled.get();
    }

    @Override // io.bidmachine.util.Cancelable
    public void setCancel(boolean isCancel) {
        this.isCanceled.set(isCancel);
    }
}
