package com.yandex.div.storage.histogram;

import com.yandex.div.histogram.HistogramFilter;
import com.yandex.div.histogram.reporter.HistogramReporter;
import com.yandex.div.histogram.reporter.HistogramReporterDelegate;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HistogramRecorder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0012J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0017J\"\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0012J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0017J\u001e\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yandex/div/storage/histogram/HistogramRecorder;", "", "histogramReporterDelegate", "Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "histogramNameProvider", "Lcom/yandex/div/storage/histogram/HistogramNameProvider;", "(Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;Lcom/yandex/div/storage/histogram/HistogramNameProvider;)V", "histogramReporter", "Lcom/yandex/div/histogram/reporter/HistogramReporter;", "recordedHistograms", "Ljava/util/concurrent/CopyOnWriteArraySet;", "", "getHistogramCallType", "histogramName", "reportDivDataLoadTime", "", "duration", "", "filter", "Lcom/yandex/div/histogram/HistogramFilter;", "reportDuration", "time", "reportTemplateLoadedTime", "reportTemplatesParseTime", "parsingHistogramNames", "", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class HistogramRecorder {
    private final HistogramNameProvider histogramNameProvider;
    private final HistogramReporter histogramReporter;
    private final CopyOnWriteArraySet<String> recordedHistograms;

    public HistogramRecorder(HistogramReporterDelegate histogramReporterDelegate, HistogramNameProvider histogramNameProvider) {
        Intrinsics.checkNotNullParameter(histogramReporterDelegate, "histogramReporterDelegate");
        this.histogramNameProvider = histogramNameProvider;
        this.histogramReporter = new HistogramReporter(histogramReporterDelegate);
        this.recordedHistograms = new CopyOnWriteArraySet<>();
    }

    public static /* synthetic */ void reportTemplateLoadedTime$default(HistogramRecorder histogramRecorder, long j, HistogramFilter histogramFilter, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportTemplateLoadedTime");
        }
        if ((i & 2) != 0) {
            histogramFilter = HistogramFilter.INSTANCE.getON();
        }
        histogramRecorder.reportTemplateLoadedTime(j, histogramFilter);
    }

    public void reportTemplateLoadedTime(long duration, HistogramFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        HistogramNameProvider histogramNameProvider = this.histogramNameProvider;
        if (histogramNameProvider != null) {
            reportDuration(histogramNameProvider.getDivLoadTemplatesReportName(), duration, filter);
        }
    }

    public static /* synthetic */ void reportDivDataLoadTime$default(HistogramRecorder histogramRecorder, long j, HistogramFilter histogramFilter, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportDivDataLoadTime");
        }
        if ((i & 2) != 0) {
            histogramFilter = HistogramFilter.INSTANCE.getON();
        }
        histogramRecorder.reportDivDataLoadTime(j, histogramFilter);
    }

    public void reportDivDataLoadTime(long duration, HistogramFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        HistogramNameProvider histogramNameProvider = this.histogramNameProvider;
        if (histogramNameProvider != null) {
            reportDuration(histogramNameProvider.getDivDataLoadReportName(), duration, filter);
        }
    }

    static /* synthetic */ void reportDuration$default(HistogramRecorder histogramRecorder, String str, long j, HistogramFilter histogramFilter, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportDuration");
        }
        if ((i & 4) != 0) {
            histogramFilter = HistogramFilter.INSTANCE.getON();
        }
        histogramRecorder.reportDuration(str, j, histogramFilter);
    }

    private void reportDuration(String histogramName, long time, HistogramFilter filter) {
        HistogramReporter histogramReporter = this.histogramReporter;
        HistogramNameProvider histogramNameProvider = this.histogramNameProvider;
        histogramReporter.reportDuration(histogramName, time, histogramNameProvider != null ? histogramNameProvider.getComponentName() : null, getHistogramCallType(histogramName), filter);
    }

    private String getHistogramCallType(String histogramName) {
        String hotCallTypeSuffix;
        String coldCallTypeSuffix;
        if (this.recordedHistograms.add(histogramName)) {
            HistogramNameProvider histogramNameProvider = this.histogramNameProvider;
            return (histogramNameProvider == null || (coldCallTypeSuffix = histogramNameProvider.getColdCallTypeSuffix()) == null) ? "Cold" : coldCallTypeSuffix;
        }
        HistogramNameProvider histogramNameProvider2 = this.histogramNameProvider;
        return (histogramNameProvider2 == null || (hotCallTypeSuffix = histogramNameProvider2.getHotCallTypeSuffix()) == null) ? "Warm" : hotCallTypeSuffix;
    }

    public void reportTemplatesParseTime(Set<String> parsingHistogramNames, long duration) {
        Intrinsics.checkNotNullParameter(parsingHistogramNames, "parsingHistogramNames");
        for (String str : parsingHistogramNames) {
            HistogramReporter histogramReporter = this.histogramReporter;
            HistogramNameProvider histogramNameProvider = this.histogramNameProvider;
            HistogramReporter.reportDuration$default(histogramReporter, str, duration, histogramNameProvider != null ? histogramNameProvider.getComponentName() : null, null, null, 24, null);
        }
    }
}
