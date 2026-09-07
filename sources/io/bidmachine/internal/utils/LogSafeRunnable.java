package io.bidmachine.internal.utils;

import io.bidmachine.core.Logger;
import io.bidmachine.utils.SafeRunnable;

/* JADX INFO: loaded from: classes13.dex */
public interface LogSafeRunnable extends SafeRunnable {
    @Override // io.bidmachine.utils.SafeRunnable
    default void onThrows(Throwable th) throws Throwable {
        Logger.w(th);
    }
}
