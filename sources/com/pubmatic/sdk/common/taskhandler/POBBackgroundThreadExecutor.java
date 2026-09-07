package com.pubmatic.sdk.common.taskhandler;

import com.yandex.div.core.timer.TimerController;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/pubmatic/sdk/common/taskhandler/POBBackgroundThreadExecutor;", "Lcom/pubmatic/sdk/common/taskhandler/POBThreadExecutor;", "<init>", "()V", "Ljava/lang/Runnable;", "runnable", "", "execute", "(Ljava/lang/Runnable;)V", "", TimerController.CANCEL_COMMAND, "(Ljava/lang/Runnable;)Z", "Ljava/util/concurrent/ExecutorService;", "a", "Ljava/util/concurrent/ExecutorService;", "executor", "common_release"}, k = 1, mv = {1, 7, 1})
public final class POBBackgroundThreadExecutor implements POBThreadExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ExecutorService executor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), new POBThreadFactory("POBBackgroundThreadExecutor"));

    @Override // com.pubmatic.sdk.common.taskhandler.POBThreadExecutor
    public boolean cancel(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.executor.execute(runnable);
    }
}
