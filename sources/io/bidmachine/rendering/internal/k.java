package io.bidmachine.rendering.internal;

import io.bidmachine.util.SafeExecutable;

/* JADX INFO: loaded from: classes11.dex */
public interface k extends SafeExecutable {
    @Override // io.bidmachine.util.SafeExecutable
    default void onThrows(Throwable th) {
        m.b(th);
    }
}
