package com.yandex.div.histogram;

import com.yandex.div.histogram.util.Cancelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CpuUsageHistogramReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/histogram/CpuUsageHistogramReporter;", "", "startReporting", "Lcom/yandex/div/histogram/util/Cancelable;", "histogramName", "", "threadId", "", "NoOp", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface CpuUsageHistogramReporter {

    /* JADX INFO: compiled from: CpuUsageHistogramReporter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/yandex/div/histogram/CpuUsageHistogramReporter$NoOp;", "Lcom/yandex/div/histogram/CpuUsageHistogramReporter;", "()V", "startReporting", "Lcom/yandex/div/histogram/util/Cancelable;", "histogramName", "", "threadId", "", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NoOp implements CpuUsageHistogramReporter {
        /* JADX INFO: Access modifiers changed from: private */
        public static final void startReporting$lambda$0() {
        }

        @Override // com.yandex.div.histogram.CpuUsageHistogramReporter
        public Cancelable startReporting(String histogramName, int threadId) {
            Intrinsics.checkNotNullParameter(histogramName, "histogramName");
            return new Cancelable() { // from class: com.yandex.div.histogram.CpuUsageHistogramReporter$NoOp$$ExternalSyntheticLambda0
                @Override // com.yandex.div.histogram.util.Cancelable
                public final void cancel() {
                    CpuUsageHistogramReporter.NoOp.startReporting$lambda$0();
                }
            };
        }
    }

    Cancelable startReporting(String histogramName, int threadId);
}
