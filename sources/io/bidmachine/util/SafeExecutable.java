package io.bidmachine.util;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeExecutable.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/util/SafeExecutable;", "T", "Lio/bidmachine/util/Executable;", "execute", "", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "(Ljava/lang/Object;)V", "onExecute", "onThrows", "throwable", "", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SafeExecutable<T> extends Executable<T> {
    void onExecute(T t) throws Throwable;

    default void onThrows(Throwable throwable) throws Throwable {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    @Override // io.bidmachine.util.Executable
    default void execute(T t) {
        try {
            onExecute(t);
        } catch (Throwable th) {
            try {
                SafeExecutable<T> safeExecutable = this;
                onThrows(th);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
            }
        }
    }
}
