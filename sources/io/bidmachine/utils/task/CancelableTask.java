package io.bidmachine.utils.task;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
public abstract class CancelableTask implements Runnable {
    private final AtomicBoolean isCanceled = new AtomicBoolean(false);

    public abstract void runTask();

    public boolean isCanceled() {
        return this.isCanceled.get();
    }

    public void setCancel(boolean z) {
        this.isCanceled.set(z);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isCanceled()) {
            return;
        }
        runTask();
    }
}
