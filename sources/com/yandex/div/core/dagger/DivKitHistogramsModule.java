package com.yandex.div.core.dagger;

import com.yandex.div.histogram.DivParsingHistogramReporter;
import com.yandex.div.histogram.DivParsingHistogramReporterImpl;
import com.yandex.div.histogram.HistogramColdTypeChecker;
import com.yandex.div.histogram.HistogramConfiguration;
import com.yandex.div.histogram.HistogramRecorder;
import com.yandex.div.histogram.reporter.HistogramReporter;
import com.yandex.div.histogram.reporter.HistogramReporterDelegate;
import com.yandex.div.internal.util.DoubleCheckProvider;
import com.yandex.yatagan.Module;
import com.yandex.yatagan.Provides;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivKitHistogramsModule.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0007J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J,\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004H\u0007¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/dagger/DivKitHistogramsModule;", "", "()V", "provideCalculateSizeExecutor", "Ljavax/inject/Provider;", "Ljava/util/concurrent/Executor;", "histogramConfiguration", "Lcom/yandex/div/histogram/HistogramConfiguration;", "executorService", "Ljava/util/concurrent/ExecutorService;", "provideDivParsingHistogramReporter", "Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "histogramReporterDelegate", "Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "provideHistogramReporter", "Lcom/yandex/div/histogram/reporter/HistogramReporter;", "provideHistogramReporterDelegate", "histogramRecorderProvider", "Lcom/yandex/div/histogram/HistogramRecorder;", "histogramColdTypeCheckerProvider", "Lcom/yandex/div/histogram/HistogramColdTypeChecker;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Module
public final class DivKitHistogramsModule {
    public static final DivKitHistogramsModule INSTANCE = new DivKitHistogramsModule();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Executor provideCalculateSizeExecutor$lambda$1() {
        return new Executor() { // from class: com.yandex.div.core.dagger.DivKitHistogramsModule$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                DivKitHistogramsModule.provideCalculateSizeExecutor$lambda$1$lambda$0(runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideCalculateSizeExecutor$lambda$1$lambda$0(Runnable runnable) {
    }

    private DivKitHistogramsModule() {
    }

    @Singleton
    @Provides
    public final DivParsingHistogramReporter provideDivParsingHistogramReporter(HistogramConfiguration histogramConfiguration, Provider<HistogramReporterDelegate> histogramReporterDelegate, Provider<ExecutorService> executorService) {
        Intrinsics.checkNotNullParameter(histogramConfiguration, "histogramConfiguration");
        Intrinsics.checkNotNullParameter(histogramReporterDelegate, "histogramReporterDelegate");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        if (histogramConfiguration.getIsReportingEnabled()) {
            Provider<Executor> providerProvideCalculateSizeExecutor = provideCalculateSizeExecutor(histogramConfiguration, executorService);
            HistogramReporterDelegate histogramReporterDelegate2 = histogramReporterDelegate.get();
            Intrinsics.checkNotNullExpressionValue(histogramReporterDelegate2, "histogramReporterDelegate.get()");
            return new DivParsingHistogramReporterImpl(new AnonymousClass1(provideHistogramReporter(histogramReporterDelegate2)), new AnonymousClass2(providerProvideCalculateSizeExecutor));
        }
        return DivParsingHistogramReporter.INSTANCE.getDEFAULT();
    }

    /* JADX INFO: renamed from: com.yandex.div.core.dagger.DivKitHistogramsModule$provideDivParsingHistogramReporter$1, reason: invalid class name */
    /* JADX INFO: compiled from: DivKitHistogramsModule.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<HistogramReporter> {
        AnonymousClass1(Object obj) {
            super(0, obj, Provider.class, "get", "get()Ljava/lang/Object;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HistogramReporter invoke() {
            return (HistogramReporter) ((Provider) this.receiver).get();
        }
    }

    /* JADX INFO: renamed from: com.yandex.div.core.dagger.DivKitHistogramsModule$provideDivParsingHistogramReporter$2, reason: invalid class name */
    /* JADX INFO: compiled from: DivKitHistogramsModule.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Executor> {
        AnonymousClass2(Object obj) {
            super(0, obj, Provider.class, "get", "get()Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Executor invoke() {
            return (Executor) ((Provider) this.receiver).get();
        }
    }

    @Provides
    public final HistogramReporterDelegate provideHistogramReporterDelegate(HistogramConfiguration histogramConfiguration, Provider<HistogramRecorder> histogramRecorderProvider, Provider<HistogramColdTypeChecker> histogramColdTypeCheckerProvider) {
        Intrinsics.checkNotNullParameter(histogramConfiguration, "histogramConfiguration");
        Intrinsics.checkNotNullParameter(histogramRecorderProvider, "histogramRecorderProvider");
        Intrinsics.checkNotNullParameter(histogramColdTypeCheckerProvider, "histogramColdTypeCheckerProvider");
        if (histogramConfiguration.getIsReportingEnabled()) {
            return DivHistogramsModuleKt.createHistogramReporterDelegate(histogramConfiguration, histogramRecorderProvider, histogramColdTypeCheckerProvider);
        }
        return HistogramReporterDelegate.NoOp.INSTANCE;
    }

    private final Provider<Executor> provideCalculateSizeExecutor(HistogramConfiguration histogramConfiguration, Provider<ExecutorService> executorService) {
        if (!histogramConfiguration.getIsSizeRecordingEnabled()) {
            return new Provider() { // from class: com.yandex.div.core.dagger.DivKitHistogramsModule$$ExternalSyntheticLambda1
                @Override // javax.inject.Provider
                public final Object get() {
                    return DivKitHistogramsModule.provideCalculateSizeExecutor$lambda$1();
                }
            };
        }
        Intrinsics.checkNotNull(executorService, "null cannot be cast to non-null type javax.inject.Provider<java.util.concurrent.Executor>");
        return executorService;
    }

    private final Provider<HistogramReporter> provideHistogramReporter(final HistogramReporterDelegate histogramReporterDelegate) {
        return new DoubleCheckProvider(new Function0<HistogramReporter>() { // from class: com.yandex.div.core.dagger.DivKitHistogramsModule.provideHistogramReporter.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HistogramReporter invoke() {
                return DivHistogramsModuleKt.createHistogramReporter(histogramReporterDelegate);
            }
        });
    }
}
