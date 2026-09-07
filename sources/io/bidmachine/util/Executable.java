package io.bidmachine.util;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: Executable.kt */
/* JADX INFO: loaded from: classes8.dex */
@FunctionalInterface
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/util/Executable;", "T", "", "execute", "", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "(Ljava/lang/Object;)V", "executeSafely", "", "(Ljava/lang/Object;)Z", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface Executable<T> {
    void execute(T t);

    default boolean executeSafely(T t) {
        if (t == null) {
            return false;
        }
        execute(t);
        return true;
    }
}
