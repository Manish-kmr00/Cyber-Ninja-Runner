package com.yandex.div.histogram;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public interface HistogramBridge {
    void recordBooleanHistogram(String str, boolean z);

    void recordCountHistogram(String str, int i, int i2, int i3, int i4);

    void recordEnumeratedHistogram(String str, int i, int i2);

    void recordLinearCountHistogram(String str, int i, int i2, int i3, int i4);

    void recordSparseSlowlyHistogram(String str, int i);

    void recordTimeHistogram(String str, long j, long j2, long j3, TimeUnit timeUnit, int i);
}
