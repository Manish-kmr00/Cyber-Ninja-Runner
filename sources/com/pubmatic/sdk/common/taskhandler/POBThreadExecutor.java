package com.pubmatic.sdk.common.taskhandler;

import com.yandex.div.core.timer.TimerController;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/pubmatic/sdk/common/taskhandler/POBThreadExecutor;", "Ljava/util/concurrent/Executor;", TimerController.CANCEL_COMMAND, "", "runnable", "Ljava/lang/Runnable;", "common_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface POBThreadExecutor extends Executor {
    boolean cancel(Runnable runnable);
}
