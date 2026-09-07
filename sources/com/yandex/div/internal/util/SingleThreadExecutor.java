package com.yandex.div.internal.util;

import com.yandex.div.internal.Assert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingleThreadExecutor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0014\u0010\u0010\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013H$J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0012\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u000f\u001a\u00020\fJ \u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yandex/div/internal/util/SingleThreadExecutor;", "", "executor", "Ljava/util/concurrent/Executor;", "threadNameSuffix", "", "(Ljava/util/concurrent/Executor;Ljava/lang/String;)V", "currentWorker", "Lcom/yandex/div/internal/util/SingleThreadExecutor$Worker;", "monitor", "passedTasks", "", "Ljava/lang/Runnable;", "addTaskLocked", "", "task", "handleError", "e", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "post", "submit", "Ljava/util/concurrent/Future;", "T", "callable", "Ljava/util/concurrent/Callable;", "Worker", "utils_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class SingleThreadExecutor {
    private Worker currentWorker;
    private final Executor executor;
    private final Object monitor;
    private List<Runnable> passedTasks;
    private final String threadNameSuffix;

    protected abstract void handleError(RuntimeException e);

    public SingleThreadExecutor(Executor executor, String threadNameSuffix) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(threadNameSuffix, "threadNameSuffix");
        this.executor = executor;
        this.threadNameSuffix = threadNameSuffix;
        this.monitor = new Object();
    }

    public final void post(Runnable task) {
        Worker worker;
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.monitor) {
            addTaskLocked(task);
            if (this.currentWorker == null) {
                worker = new Worker();
                this.currentWorker = worker;
            } else {
                worker = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (worker != null) {
            this.executor.execute(worker);
        }
    }

    private final void addTaskLocked(Runnable task) {
        if (this.passedTasks == null) {
            this.passedTasks = new ArrayList(2);
        }
        List<Runnable> list = this.passedTasks;
        if (list != null) {
            list.add(task);
        }
    }

    public final Future<?> submit(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        FutureTask futureTask = new FutureTask(task, null);
        post(futureTask);
        return futureTask;
    }

    public final <T> Future<T> submit(Callable<T> callable) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        FutureTask futureTask = new FutureTask(callable);
        post(futureTask);
        return futureTask;
    }

    /* JADX INFO: compiled from: SingleThreadExecutor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/internal/util/SingleThreadExecutor$Worker;", "Lcom/yandex/div/internal/util/NamedRunnable;", "(Lcom/yandex/div/internal/util/SingleThreadExecutor;)V", "execute", "", "utils_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class Worker extends NamedRunnable {
        public Worker() {
            super(SingleThreadExecutor.this.threadNameSuffix);
        }

        @Override // com.yandex.div.internal.util.NamedRunnable
        public void execute() {
            Object obj = SingleThreadExecutor.this.monitor;
            SingleThreadExecutor singleThreadExecutor = SingleThreadExecutor.this;
            synchronized (obj) {
                if (Intrinsics.areEqual(singleThreadExecutor.currentWorker, this) && singleThreadExecutor.passedTasks != null) {
                    List list = singleThreadExecutor.passedTasks;
                    singleThreadExecutor.passedTasks = null;
                    Unit unit = Unit.INSTANCE;
                    boolean z = true;
                    while (z) {
                        if (list != null) {
                            try {
                                SingleThreadExecutor singleThreadExecutor2 = SingleThreadExecutor.this;
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    try {
                                        ((Runnable) it.next()).run();
                                    } catch (RuntimeException e) {
                                        singleThreadExecutor2.handleError(e);
                                    }
                                }
                            } catch (Throwable th) {
                                Object obj2 = SingleThreadExecutor.this.monitor;
                                SingleThreadExecutor singleThreadExecutor3 = SingleThreadExecutor.this;
                                synchronized (obj2) {
                                    singleThreadExecutor3.currentWorker = null;
                                    Unit unit2 = Unit.INSTANCE;
                                    throw th;
                                }
                            }
                        }
                        Object obj3 = SingleThreadExecutor.this.monitor;
                        SingleThreadExecutor singleThreadExecutor4 = SingleThreadExecutor.this;
                        synchronized (obj3) {
                            if (singleThreadExecutor4.passedTasks != null) {
                                list = singleThreadExecutor4.passedTasks;
                                singleThreadExecutor4.passedTasks = null;
                            } else {
                                singleThreadExecutor4.currentWorker = null;
                                z = false;
                            }
                            Unit unit3 = Unit.INSTANCE;
                        }
                    }
                    return;
                }
                Assert.fail("We shouldn't create excessive workers");
            }
        }
    }
}
