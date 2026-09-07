package io.bidmachine.rendering.internal;

import io.bidmachine.rendering.utils.SafeRunnable;

/* JADX INFO: loaded from: classes11.dex */
public interface l extends SafeRunnable {
    @Override // io.bidmachine.rendering.utils.SafeRunnable
    default void onThrows(Throwable th) {
        m.b(th);
    }
}
