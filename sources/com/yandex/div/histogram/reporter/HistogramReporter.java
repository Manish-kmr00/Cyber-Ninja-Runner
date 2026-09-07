package com.yandex.div.histogram.reporter;

import com.yandex.div.histogram.HistogramCallType;
import com.yandex.div.histogram.HistogramFilter;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HistogramReporter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J:\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0016J.\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/histogram/reporter/HistogramReporter;", "", "histogramReporterDelegate", "Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "(Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;)V", "reportDuration", "", "histogramName", "", "duration", "", "componentName", "forceCallType", "filter", "Lcom/yandex/div/histogram/HistogramFilter;", "reportSize", ContentDisposition.Parameters.Size, "", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class HistogramReporter {
    private final HistogramReporterDelegate histogramReporterDelegate;

    public HistogramReporter(HistogramReporterDelegate histogramReporterDelegate) {
        Intrinsics.checkNotNullParameter(histogramReporterDelegate, "histogramReporterDelegate");
        this.histogramReporterDelegate = histogramReporterDelegate;
    }

    public static /* synthetic */ void reportDuration$default(HistogramReporter histogramReporter, String str, long j, String str2, String str3, HistogramFilter histogramFilter, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportDuration");
        }
        histogramReporter.reportDuration(str, j, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? HistogramFilter.INSTANCE.getON() : histogramFilter);
    }

    public void reportDuration(String histogramName, long duration, String componentName, @HistogramCallType String forceCallType, HistogramFilter filter) {
        Intrinsics.checkNotNullParameter(histogramName, "histogramName");
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (filter.report(null)) {
            this.histogramReporterDelegate.reportDuration(histogramName, duration, forceCallType);
        }
        if (componentName != null) {
            String str = componentName + '.' + histogramName;
            if (filter.report(componentName)) {
                this.histogramReporterDelegate.reportDuration(str, duration, forceCallType);
            }
        }
    }

    public static /* synthetic */ void reportSize$default(HistogramReporter histogramReporter, String str, int i, String str2, HistogramFilter histogramFilter, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportSize");
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            histogramFilter = HistogramFilter.INSTANCE.getON();
        }
        histogramReporter.reportSize(str, i, str2, histogramFilter);
    }

    public void reportSize(String histogramName, int size, String componentName, HistogramFilter filter) {
        Intrinsics.checkNotNullParameter(histogramName, "histogramName");
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (filter.report(null)) {
            this.histogramReporterDelegate.reportSize(histogramName, size);
        }
        if (componentName != null) {
            String str = componentName + '.' + histogramName;
            if (filter.report(componentName)) {
                this.histogramReporterDelegate.reportSize(str, size);
            }
        }
    }
}
