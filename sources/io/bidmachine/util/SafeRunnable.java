package io.bidmachine.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeRunnable.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/util/SafeRunnable;", "Ljava/lang/Runnable;", "onRun", "", "onThrows", "throwable", "", "run", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SafeRunnable extends Runnable {
    void onRun() throws Throwable;

    default void onThrows(Throwable throwable) throws Throwable {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    @Override // java.lang.Runnable
    default void run() {
        try {
            onRun();
        } catch (Throwable th) {
            try {
                SafeRunnable safeRunnable = this;
                onThrows(th);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
            }
        }
    }
}
