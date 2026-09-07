package io.bidmachine.util.taskmanager.handler;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;

/* JADX INFO: compiled from: UIHandlerTaskManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/bidmachine/util/taskmanager/handler/UIHandlerTaskManager;", "Lio/bidmachine/util/taskmanager/handler/BaseHandlerTaskManager;", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UIHandlerTaskManager extends BaseHandlerTaskManager {
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override // io.bidmachine.util.taskmanager.handler.BaseHandlerTaskManager
    protected Handler getHandler() {
        return this.handler;
    }
}
