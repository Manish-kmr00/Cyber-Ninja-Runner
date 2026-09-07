package com.yandex.div.core.dagger;

import com.yandex.div.histogram.HistogramCallTypeProvider;
import com.yandex.div.histogram.HistogramColdTypeChecker;
import com.yandex.div.histogram.HistogramConfiguration;
import com.yandex.div.histogram.HistogramRecorder;
import com.yandex.div.histogram.reporter.HistogramReporter;
import com.yandex.div.histogram.reporter.HistogramReporterDelegate;
import com.yandex.div.histogram.reporter.HistogramReporterDelegateImpl;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivHistogramsModule.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a,\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0000¨\u0006\f"}, d2 = {"createHistogramReporter", "Lcom/yandex/div/histogram/reporter/HistogramReporter;", "histogramReporterDelegate", "Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "createHistogramReporterDelegate", "histogramConfiguration", "Lcom/yandex/div/histogram/HistogramConfiguration;", "histogramRecorderProvider", "Ljavax/inject/Provider;", "Lcom/yandex/div/histogram/HistogramRecorder;", "histogramColdTypeChecker", "Lcom/yandex/div/histogram/HistogramColdTypeChecker;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivHistogramsModuleKt {
    public static final HistogramReporter createHistogramReporter(HistogramReporterDelegate histogramReporterDelegate) {
        Intrinsics.checkNotNullParameter(histogramReporterDelegate, "histogramReporterDelegate");
        return new HistogramReporter(histogramReporterDelegate);
    }

    public static final HistogramReporterDelegate createHistogramReporterDelegate(HistogramConfiguration histogramConfiguration, Provider<HistogramRecorder> histogramRecorderProvider, Provider<HistogramColdTypeChecker> histogramColdTypeChecker) {
        Intrinsics.checkNotNullParameter(histogramConfiguration, "histogramConfiguration");
        Intrinsics.checkNotNullParameter(histogramRecorderProvider, "histogramRecorderProvider");
        Intrinsics.checkNotNullParameter(histogramColdTypeChecker, "histogramColdTypeChecker");
        if (!histogramConfiguration.getIsReportingEnabled()) {
            return HistogramReporterDelegate.NoOp.INSTANCE;
        }
        return new HistogramReporterDelegateImpl(histogramRecorderProvider, new HistogramCallTypeProvider(new DivHistogramsModuleKt$createHistogramReporterDelegate$histogramCallTypeProvider$1(histogramColdTypeChecker)), histogramConfiguration, histogramConfiguration.getTaskExecutorProvider());
    }
}
