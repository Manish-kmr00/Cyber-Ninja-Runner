package io.bidmachine.media3.common.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes7.dex */
public class SystemClock implements Clock {
    @Override // io.bidmachine.media3.common.util.Clock
    public void onThreadBlocked() {
    }

    protected SystemClock() {
    }

    @Override // io.bidmachine.media3.common.util.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // io.bidmachine.media3.common.util.Clock
    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // io.bidmachine.media3.common.util.Clock
    public long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }

    @Override // io.bidmachine.media3.common.util.Clock
    public long nanoTime() {
        return System.nanoTime();
    }

    @Override // io.bidmachine.media3.common.util.Clock
    public HandlerWrapper createHandler(Looper looper, Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }
}
