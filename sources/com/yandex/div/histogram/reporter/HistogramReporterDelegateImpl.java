package com.yandex.div.histogram.reporter;

import com.yandex.div.histogram.HistogramCallType;
import com.yandex.div.histogram.HistogramCallTypeProvider;
import com.yandex.div.histogram.HistogramRecordConfiguration;
import com.yandex.div.histogram.HistogramRecorder;
import com.yandex.div.histogram.TaskExecutor;
import com.yandex.div.histogram.util.HistogramUtils;
import io.ktor.http.ContentDisposition;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: HistogramReporterDelegateImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/histogram/reporter/HistogramReporterDelegateImpl;", "Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "histogramRecorder", "Ljavax/inject/Provider;", "Lcom/yandex/div/histogram/HistogramRecorder;", "histogramCallTypeProvider", "Lcom/yandex/div/histogram/HistogramCallTypeProvider;", "histogramRecordConfig", "Lcom/yandex/div/histogram/HistogramRecordConfiguration;", "taskExecutor", "Lcom/yandex/div/histogram/TaskExecutor;", "(Ljavax/inject/Provider;Lcom/yandex/div/histogram/HistogramCallTypeProvider;Lcom/yandex/div/histogram/HistogramRecordConfiguration;Ljavax/inject/Provider;)V", "reportDuration", "", "histogramName", "", "duration", "", "forceCallType", "reportSize", ContentDisposition.Parameters.Size, "", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HistogramReporterDelegateImpl implements HistogramReporterDelegate {
    private final HistogramCallTypeProvider histogramCallTypeProvider;
    private final HistogramRecordConfiguration histogramRecordConfig;
    private final Provider<HistogramRecorder> histogramRecorder;
    private final Provider<TaskExecutor> taskExecutor;

    public HistogramReporterDelegateImpl(Provider<HistogramRecorder> histogramRecorder, HistogramCallTypeProvider histogramCallTypeProvider, HistogramRecordConfiguration histogramRecordConfig, Provider<TaskExecutor> taskExecutor) {
        Intrinsics.checkNotNullParameter(histogramRecorder, "histogramRecorder");
        Intrinsics.checkNotNullParameter(histogramCallTypeProvider, "histogramCallTypeProvider");
        Intrinsics.checkNotNullParameter(histogramRecordConfig, "histogramRecordConfig");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        this.histogramRecorder = histogramRecorder;
        this.histogramCallTypeProvider = histogramCallTypeProvider;
        this.histogramRecordConfig = histogramRecordConfig;
        this.taskExecutor = taskExecutor;
    }

    @Override // com.yandex.div.histogram.reporter.HistogramReporterDelegate
    public void reportDuration(final String histogramName, final long duration, @HistogramCallType String forceCallType) {
        Intrinsics.checkNotNullParameter(histogramName, "histogramName");
        final String histogramCallType = forceCallType == null ? this.histogramCallTypeProvider.getHistogramCallType(histogramName) : forceCallType;
        if (HistogramUtils.INSTANCE.shouldRecordHistogram(histogramCallType, this.histogramRecordConfig)) {
            this.taskExecutor.get().post(new Function0<Unit>() { // from class: com.yandex.div.histogram.reporter.HistogramReporterDelegateImpl.reportDuration.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((HistogramRecorder) HistogramReporterDelegateImpl.this.histogramRecorder.get()).recordShortTimeHistogram(histogramName + '.' + histogramCallType, RangesKt.coerceAtLeast(duration, 1L), TimeUnit.MILLISECONDS);
                }
            });
        }
    }

    @Override // com.yandex.div.histogram.reporter.HistogramReporterDelegate
    public void reportSize(final String histogramName, final int size) {
        Intrinsics.checkNotNullParameter(histogramName, "histogramName");
        this.taskExecutor.get().post(new Function0<Unit>() { // from class: com.yandex.div.histogram.reporter.HistogramReporterDelegateImpl.reportSize.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((HistogramRecorder) HistogramReporterDelegateImpl.this.histogramRecorder.get()).recordCount100KHistogram(histogramName + ".Size", RangesKt.coerceAtLeast(size, 1));
            }
        });
    }
}
