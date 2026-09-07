package com.yandex.div.histogram;

import com.yandex.div.internal.util.DoubleCheckProvider;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: HistogramConfiguration.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lcom/yandex/div/histogram/HistogramConfiguration;", "Lcom/yandex/div/histogram/HistogramRecordConfiguration;", "cpuUsageHistogramReporter", "Ljavax/inject/Provider;", "Lcom/yandex/div/histogram/CpuUsageHistogramReporter;", "getCpuUsageHistogramReporter", "()Ljavax/inject/Provider;", "histogramBridge", "Lcom/yandex/div/histogram/HistogramBridge;", "getHistogramBridge", "isReportingEnabled", "", "()Z", "taskExecutorProvider", "Lcom/yandex/div/histogram/TaskExecutor;", "getTaskExecutorProvider", "Companion", "DefaultHistogramConfiguration", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface HistogramConfiguration extends HistogramRecordConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final HistogramConfiguration DEFAULT = new DefaultHistogramConfiguration();

    Provider<CpuUsageHistogramReporter> getCpuUsageHistogramReporter();

    Provider<HistogramBridge> getHistogramBridge();

    Provider<TaskExecutor> getTaskExecutorProvider();

    /* JADX INFO: renamed from: isReportingEnabled */
    boolean getIsReportingEnabled();

    /* JADX INFO: compiled from: HistogramConfiguration.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/histogram/HistogramConfiguration$DefaultHistogramConfiguration;", "Lcom/yandex/div/histogram/HistogramConfiguration;", "()V", "cpuUsageHistogramReporter", "Ljavax/inject/Provider;", "Lcom/yandex/div/histogram/CpuUsageHistogramReporter;", "getCpuUsageHistogramReporter", "()Ljavax/inject/Provider;", "histogramBridge", "Lcom/yandex/div/histogram/HistogramBridge;", "getHistogramBridge", "isColdRecordingEnabled", "", "()Z", "isCoolRecordingEnabled", "isReportingEnabled", "isSizeRecordingEnabled", "isWarmRecordingEnabled", "renderConfiguration", "Lcom/yandex/div/histogram/RenderConfiguration;", "getRenderConfiguration", "taskExecutorProvider", "Lcom/yandex/div/histogram/TaskExecutor;", "getTaskExecutorProvider", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class DefaultHistogramConfiguration implements HistogramConfiguration {
        private final boolean isColdRecordingEnabled;
        private final boolean isCoolRecordingEnabled;
        private final boolean isReportingEnabled;
        private final boolean isSizeRecordingEnabled;
        private final boolean isWarmRecordingEnabled;
        private final Provider<HistogramBridge> histogramBridge = new DoubleCheckProvider(HistogramConfiguration$DefaultHistogramConfiguration$histogramBridge$1.INSTANCE);
        private final Provider<CpuUsageHistogramReporter> cpuUsageHistogramReporter = new DoubleCheckProvider(new Function0<CpuUsageHistogramReporter>() { // from class: com.yandex.div.histogram.HistogramConfiguration$DefaultHistogramConfiguration$cpuUsageHistogramReporter$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CpuUsageHistogramReporter invoke() {
                return new CpuUsageHistogramReporter.NoOp();
            }
        });
        private final Provider<TaskExecutor> taskExecutorProvider = new DoubleCheckProvider(HistogramConfiguration$DefaultHistogramConfiguration$taskExecutorProvider$1.INSTANCE);
        private final Provider<RenderConfiguration> renderConfiguration = new DoubleCheckProvider(HistogramConfiguration$DefaultHistogramConfiguration$renderConfiguration$1.INSTANCE);

        @Override // com.yandex.div.histogram.HistogramConfiguration
        public Provider<HistogramBridge> getHistogramBridge() {
            return this.histogramBridge;
        }

        @Override // com.yandex.div.histogram.HistogramConfiguration
        public Provider<CpuUsageHistogramReporter> getCpuUsageHistogramReporter() {
            return this.cpuUsageHistogramReporter;
        }

        @Override // com.yandex.div.histogram.HistogramConfiguration
        /* JADX INFO: renamed from: isReportingEnabled, reason: from getter */
        public boolean getIsReportingEnabled() {
            return this.isReportingEnabled;
        }

        @Override // com.yandex.div.histogram.HistogramRecordConfiguration
        /* JADX INFO: renamed from: isColdRecordingEnabled, reason: from getter */
        public boolean getIsColdRecordingEnabled() {
            return this.isColdRecordingEnabled;
        }

        @Override // com.yandex.div.histogram.HistogramRecordConfiguration
        /* JADX INFO: renamed from: isCoolRecordingEnabled, reason: from getter */
        public boolean getIsCoolRecordingEnabled() {
            return this.isCoolRecordingEnabled;
        }

        @Override // com.yandex.div.histogram.HistogramRecordConfiguration
        /* JADX INFO: renamed from: isWarmRecordingEnabled, reason: from getter */
        public boolean getIsWarmRecordingEnabled() {
            return this.isWarmRecordingEnabled;
        }

        @Override // com.yandex.div.histogram.HistogramRecordConfiguration
        /* JADX INFO: renamed from: isSizeRecordingEnabled, reason: from getter */
        public boolean getIsSizeRecordingEnabled() {
            return this.isSizeRecordingEnabled;
        }

        @Override // com.yandex.div.histogram.HistogramConfiguration
        public Provider<TaskExecutor> getTaskExecutorProvider() {
            return this.taskExecutorProvider;
        }

        @Override // com.yandex.div.histogram.HistogramRecordConfiguration
        public Provider<RenderConfiguration> getRenderConfiguration() {
            return this.renderConfiguration;
        }
    }

    /* JADX INFO: compiled from: HistogramConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/histogram/HistogramConfiguration$Companion;", "", "()V", "DEFAULT", "Lcom/yandex/div/histogram/HistogramConfiguration;", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
