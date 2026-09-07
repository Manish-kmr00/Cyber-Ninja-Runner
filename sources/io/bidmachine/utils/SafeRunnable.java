package io.bidmachine.utils;

/* JADX INFO: loaded from: classes12.dex */
public interface SafeRunnable extends Runnable {
    void onRun() throws Throwable;

    void onThrows(Throwable th) throws Throwable;

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
