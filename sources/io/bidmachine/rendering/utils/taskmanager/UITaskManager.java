package io.bidmachine.rendering.utils.taskmanager;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes13.dex */
public class UITaskManager extends SingleThreadTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f12443a = new Handler(Looper.getMainLooper());

    @Override // io.bidmachine.rendering.utils.taskmanager.SingleThreadTaskManager
    protected Handler a() {
        return f12443a;
    }
}
