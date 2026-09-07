package com.pubmatic.sdk.common.taskhandler;

import android.os.Handler;
import android.os.Looper;
import com.yandex.div.core.timer.TimerController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/pubmatic/sdk/common/taskhandler/POBMainThreadExecutor;", "Lcom/pubmatic/sdk/common/taskhandler/POBThreadExecutor;", "<init>", "()V", "Ljava/lang/Runnable;", "runnable", "", "execute", "(Ljava/lang/Runnable;)V", "", TimerController.CANCEL_COMMAND, "(Ljava/lang/Runnable;)Z", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "executor", "common_release"}, k = 1, mv = {1, 7, 1})
public final class POBMainThreadExecutor implements POBThreadExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Handler executor = new Handler(Looper.getMainLooper());

    @Override // com.pubmatic.sdk.common.taskhandler.POBThreadExecutor
    public boolean cancel(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.executor.removeCallbacks(runnable);
        return true;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.executor.post(runnable);
    }
}
