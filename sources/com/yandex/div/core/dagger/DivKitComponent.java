package com.yandex.div.core.dagger;

import android.content.Context;
import com.safedk.android.utils.j;
import com.yandex.android.beacon.SendBeaconManager;
import com.yandex.div.core.DivKitConfiguration;
import com.yandex.div.histogram.DivParsingHistogramReporter;
import com.yandex.div.histogram.HistogramRecordConfiguration;
import com.yandex.div.histogram.HistogramRecorder;
import com.yandex.div.histogram.reporter.HistogramReporterDelegate;
import com.yandex.yatagan.BindsInstance;
import com.yandex.yatagan.Component;
import java.util.concurrent.ExecutorService;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivKitComponent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Singleton
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u001cJ\b\u0010\u001a\u001a\u00020\u001bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/dagger/DivKitComponent;", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "getExecutorService", "()Ljava/util/concurrent/ExecutorService;", "histogramRecordConfiguration", "Lcom/yandex/div/histogram/HistogramRecordConfiguration;", "getHistogramRecordConfiguration", "()Lcom/yandex/div/histogram/HistogramRecordConfiguration;", "histogramRecorder", "Lcom/yandex/div/histogram/HistogramRecorder;", "getHistogramRecorder", "()Lcom/yandex/div/histogram/HistogramRecorder;", "histogramReporterDelegate", "Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "getHistogramReporterDelegate", "()Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "parsingHistogramReporter", "Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "getParsingHistogramReporter", "()Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "sendBeaconManager", "Lcom/yandex/android/beacon/SendBeaconManager;", "getSendBeaconManager", "()Lcom/yandex/android/beacon/SendBeaconManager;", "div2Component", "Lcom/yandex/div/core/dagger/Div2Component$Builder;", "Builder", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Component(modules = {DivKitConfiguration.class, DivKitModule.class, DivKitHistogramsModule.class, DivActionTypedModule.class, DivStorageModule.class}, multiThreadAccess = true)
public interface DivKitComponent {

    /* JADX INFO: compiled from: DivKitComponent.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0004H'J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/dagger/DivKitComponent$Builder;", "", "applicationContext", "context", "Landroid/content/Context;", "build", "Lcom/yandex/div/core/dagger/DivKitComponent;", j.c, "Lcom/yandex/div/core/DivKitConfiguration;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Component.Builder
    public interface Builder {
        @BindsInstance
        Builder applicationContext(@Named(Names.APP_CONTEXT) Context context);

        DivKitComponent build();

        Builder configuration(DivKitConfiguration configuration);
    }

    Div2Component.Builder div2Component();

    ExecutorService getExecutorService();

    HistogramRecordConfiguration getHistogramRecordConfiguration();

    HistogramRecorder getHistogramRecorder();

    HistogramReporterDelegate getHistogramReporterDelegate();

    DivParsingHistogramReporter getParsingHistogramReporter();

    SendBeaconManager getSendBeaconManager();
}
