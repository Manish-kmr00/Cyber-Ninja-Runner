package io.bidmachine.rendering.utils;

/* JADX INFO: loaded from: classes10.dex */
public interface SafeRunnable extends Runnable {
    void onRun();

    default void onThrows(Throwable throwable) {
    }

    @Override // java.lang.Runnable
    default void run() {
        try {
            onRun();
        } catch (Throwable th) {
            try {
                onThrows(th);
            } catch (Throwable unused) {
            }
        }
    }
}
