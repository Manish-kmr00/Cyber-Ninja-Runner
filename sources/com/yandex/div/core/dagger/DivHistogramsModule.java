package com.yandex.div.core.dagger;

import com.yandex.div.histogram.reporter.HistogramReporter;
import com.yandex.div.histogram.reporter.HistogramReporterDelegate;
import com.yandex.yatagan.Module;
import com.yandex.yatagan.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivHistogramsModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/dagger/DivHistogramsModule;", "", "()V", "provideHistogramReporter", "Lcom/yandex/div/histogram/reporter/HistogramReporter;", "histogramReporterDelegate", "Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Module
public final class DivHistogramsModule {
    public static final DivHistogramsModule INSTANCE = new DivHistogramsModule();

    private DivHistogramsModule() {
    }

    @Provides
    @DivScope
    public final HistogramReporter provideHistogramReporter(HistogramReporterDelegate histogramReporterDelegate) {
        Intrinsics.checkNotNullParameter(histogramReporterDelegate, "histogramReporterDelegate");
        return DivHistogramsModuleKt.createHistogramReporter(histogramReporterDelegate);
    }
}
