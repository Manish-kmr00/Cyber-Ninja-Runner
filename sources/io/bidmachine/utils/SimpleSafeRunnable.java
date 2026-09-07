package io.bidmachine.utils;

/* JADX INFO: loaded from: classes10.dex */
public interface SimpleSafeRunnable extends SafeRunnable {
    @Override // io.bidmachine.utils.SafeRunnable
    default void onThrows(Throwable th) throws Throwable {
    }
}
