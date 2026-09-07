package com.yandex.div.histogram.reporter;

import com.yandex.div.histogram.HistogramCallType;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HistogramReporterDelegate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "", "reportDuration", "", "histogramName", "", "duration", "", "forceCallType", "reportSize", ContentDisposition.Parameters.Size, "", "NoOp", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface HistogramReporterDelegate {
    void reportDuration(String histogramName, long duration, @HistogramCallType String forceCallType);

    void reportSize(String histogramName, int size);

    static /* synthetic */ void reportDuration$default(HistogramReporterDelegate histogramReporterDelegate, String str, long j, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportDuration");
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        histogramReporterDelegate.reportDuration(str, j, str2);
    }

    /* JADX INFO: compiled from: HistogramReporterDelegate.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate$NoOp;", "Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "()V", "reportDuration", "", "histogramName", "", "duration", "", "forceCallType", "reportSize", ContentDisposition.Parameters.Size, "", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NoOp implements HistogramReporterDelegate {
        public static final NoOp INSTANCE = new NoOp();

        @Override // com.yandex.div.histogram.reporter.HistogramReporterDelegate
        public void reportDuration(String histogramName, long duration, @HistogramCallType String forceCallType) {
            Intrinsics.checkNotNullParameter(histogramName, "histogramName");
        }

        @Override // com.yandex.div.histogram.reporter.HistogramReporterDelegate
        public void reportSize(String histogramName, int size) {
            Intrinsics.checkNotNullParameter(histogramName, "histogramName");
        }

        private NoOp() {
        }
    }
}
