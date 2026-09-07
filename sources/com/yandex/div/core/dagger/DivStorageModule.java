package com.yandex.div.core.dagger;

import android.content.Context;
import com.yandex.div.histogram.DivParsingHistogramReporter;
import com.yandex.div.histogram.reporter.HistogramReporterDelegate;
import com.yandex.div.storage.DivStorageComponent;
import com.yandex.yatagan.Module;
import com.yandex.yatagan.Provides;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivStorageModule.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/yandex/div/core/dagger/DivStorageModule;", "", "()V", "provideDivStorageComponent", "Lcom/yandex/div/storage/DivStorageComponent;", "externalDivStorageComponent", "Lcom/yandex/div/core/dagger/ExternalOptional;", "context", "Landroid/content/Context;", "histogramReporterDelegate", "Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "parsingHistogramReporter", "Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Module
public final class DivStorageModule {
    public static final DivStorageModule INSTANCE = new DivStorageModule();

    /* JADX INFO: Access modifiers changed from: private */
    public static final DivParsingHistogramReporter provideDivStorageComponent$lambda$0(DivParsingHistogramReporter parsingHistogramReporter) {
        Intrinsics.checkNotNullParameter(parsingHistogramReporter, "$parsingHistogramReporter");
        return parsingHistogramReporter;
    }

    private DivStorageModule() {
    }

    @Singleton
    @Provides
    public final DivStorageComponent provideDivStorageComponent(@Named(Names.HAS_DEFAULTS) ExternalOptional<DivStorageComponent> externalDivStorageComponent, @Named(Names.APP_CONTEXT) Context context, HistogramReporterDelegate histogramReporterDelegate, final DivParsingHistogramReporter parsingHistogramReporter) {
        Intrinsics.checkNotNullParameter(externalDivStorageComponent, "externalDivStorageComponent");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(histogramReporterDelegate, "histogramReporterDelegate");
        Intrinsics.checkNotNullParameter(parsingHistogramReporter, "parsingHistogramReporter");
        if (externalDivStorageComponent.getOptional().isPresent()) {
            return externalDivStorageComponent.getOptional().get();
        }
        return DivStorageComponent.Companion.create$default(DivStorageComponent.INSTANCE, context, histogramReporterDelegate, null, null, null, new Provider() { // from class: com.yandex.div.core.dagger.DivStorageModule$$ExternalSyntheticLambda0
            @Override // javax.inject.Provider
            public final Object get() {
                return DivStorageModule.provideDivStorageComponent$lambda$0(parsingHistogramReporter);
            }
        }, null, 92, null);
    }
}
