package com.yandex.div.core;

import androidx.core.app.NotificationCompat;
import com.safedk.android.utils.j;
import com.yandex.android.beacon.SendBeaconConfiguration;
import com.yandex.div.core.dagger.ExternalOptional;
import com.yandex.div.core.dagger.Names;
import com.yandex.div.histogram.CpuUsageHistogramReporter;
import com.yandex.div.histogram.HistogramConfiguration;
import com.yandex.div.histogram.HistogramRecordConfiguration;
import com.yandex.div.histogram.HistogramRecorder;
import com.yandex.div.storage.DivStorageComponent;
import com.yandex.yatagan.Module;
import com.yandex.yatagan.Provides;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivKitConfiguration.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B=\b\u0002\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0004H\u0007R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/DivKitConfiguration;", "", "sendBeaconConfiguration", "Ljavax/inject/Provider;", "Lcom/yandex/android/beacon/SendBeaconConfiguration;", "executorService", "Ljava/util/concurrent/ExecutorService;", "histogramConfiguration", "Lcom/yandex/div/histogram/HistogramConfiguration;", "divStorageComponent", "Lcom/yandex/div/storage/DivStorageComponent;", "(Ljavax/inject/Provider;Ljava/util/concurrent/ExecutorService;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "cpuUsageHistogramReporter", "Lcom/yandex/div/histogram/CpuUsageHistogramReporter;", "externalDivStorageComponent", "Lcom/yandex/div/core/dagger/ExternalOptional;", "histogramRecordConfiguration", "Lcom/yandex/div/histogram/HistogramRecordConfiguration;", "histogramRecorder", "Lcom/yandex/div/histogram/HistogramRecorder;", "Builder", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Module
public final class DivKitConfiguration {
    private final Provider<DivStorageComponent> divStorageComponent;
    private final ExecutorService executorService;
    private final Provider<HistogramConfiguration> histogramConfiguration;
    private final Provider<SendBeaconConfiguration> sendBeaconConfiguration;

    public /* synthetic */ DivKitConfiguration(Provider provider, ExecutorService executorService, Provider provider2, Provider provider3, DefaultConstructorMarker defaultConstructorMarker) {
        this(provider, executorService, provider2, provider3);
    }

    private DivKitConfiguration(Provider<SendBeaconConfiguration> provider, ExecutorService executorService, Provider<HistogramConfiguration> provider2, Provider<DivStorageComponent> provider3) {
        this.sendBeaconConfiguration = provider;
        this.executorService = executorService;
        this.histogramConfiguration = provider2;
        this.divStorageComponent = provider3;
    }

    @Provides
    public final SendBeaconConfiguration sendBeaconConfiguration() {
        Provider<SendBeaconConfiguration> provider = this.sendBeaconConfiguration;
        if (provider != null) {
            return provider.get();
        }
        return null;
    }

    @Provides
    /* JADX INFO: renamed from: executorService, reason: from getter */
    public final ExecutorService getExecutorService() {
        return this.executorService;
    }

    @Provides
    public final HistogramRecordConfiguration histogramRecordConfiguration() {
        HistogramConfiguration histogramConfiguration = this.histogramConfiguration.get();
        Intrinsics.checkNotNullExpressionValue(histogramConfiguration, "histogramConfiguration.get()");
        return histogramConfiguration;
    }

    @Provides
    public final HistogramConfiguration histogramConfiguration() {
        HistogramConfiguration histogramConfiguration = this.histogramConfiguration.get();
        Intrinsics.checkNotNullExpressionValue(histogramConfiguration, "histogramConfiguration.get()");
        return histogramConfiguration;
    }

    @Singleton
    @Provides
    public final HistogramRecorder histogramRecorder() {
        return new HistogramRecorder(this.histogramConfiguration.get().getHistogramBridge().get());
    }

    @Singleton
    @Provides
    public final CpuUsageHistogramReporter cpuUsageHistogramReporter() {
        CpuUsageHistogramReporter cpuUsageHistogramReporter = this.histogramConfiguration.get().getCpuUsageHistogramReporter().get();
        Intrinsics.checkNotNullExpressionValue(cpuUsageHistogramReporter, "histogramConfiguration.g…geHistogramReporter.get()");
        return cpuUsageHistogramReporter;
    }

    @Singleton
    @Provides
    @Named(Names.HAS_DEFAULTS)
    public final ExternalOptional<DivStorageComponent> externalDivStorageComponent() {
        ExternalOptional.Companion companion = ExternalOptional.INSTANCE;
        Provider<DivStorageComponent> provider = this.divStorageComponent;
        return companion.ofNullable(provider != null ? provider.get() : null);
    }

    /* JADX INFO: compiled from: DivKitConfiguration.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u0003\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0007J\u0014\u0010\b\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fJ\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/DivKitConfiguration$Builder;", "", "()V", "divStorageComponent", "Ljavax/inject/Provider;", "Lcom/yandex/div/storage/DivStorageComponent;", "executorService", "Ljava/util/concurrent/ExecutorService;", "histogramConfiguration", "Lcom/yandex/div/histogram/HistogramConfiguration;", "kotlin.jvm.PlatformType", "sendBeaconConfiguration", "Lcom/yandex/android/beacon/SendBeaconConfiguration;", "build", "Lcom/yandex/div/core/DivKitConfiguration;", "component", NotificationCompat.CATEGORY_SERVICE, j.c, "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private Provider<DivStorageComponent> divStorageComponent;
        private ExecutorService executorService;
        private Provider<HistogramConfiguration> histogramConfiguration = new Provider() { // from class: com.yandex.div.core.DivKitConfiguration$Builder$$ExternalSyntheticLambda1
            @Override // javax.inject.Provider
            public final Object get() {
                return HistogramConfiguration.DEFAULT;
            }
        };
        private Provider<SendBeaconConfiguration> sendBeaconConfiguration;

        /* JADX INFO: Access modifiers changed from: private */
        public static final SendBeaconConfiguration sendBeaconConfiguration$lambda$1(SendBeaconConfiguration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "$configuration");
            return configuration;
        }

        public final Builder sendBeaconConfiguration(final SendBeaconConfiguration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            this.sendBeaconConfiguration = new Provider() { // from class: com.yandex.div.core.DivKitConfiguration$Builder$$ExternalSyntheticLambda0
                @Override // javax.inject.Provider
                public final Object get() {
                    return DivKitConfiguration.Builder.sendBeaconConfiguration$lambda$1(configuration);
                }
            };
            return this;
        }

        public final Builder sendBeaconConfiguration(Provider<SendBeaconConfiguration> configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            this.sendBeaconConfiguration = configuration;
            return this;
        }

        public final Builder executorService(ExecutorService service) {
            Intrinsics.checkNotNullParameter(service, "service");
            this.executorService = service;
            return this;
        }

        public final Builder histogramConfiguration(Provider<HistogramConfiguration> configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            this.histogramConfiguration = configuration;
            return this;
        }

        public final Builder divStorageComponent(Provider<DivStorageComponent> component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.divStorageComponent = component;
            return this;
        }

        public final DivKitConfiguration build() {
            Provider<SendBeaconConfiguration> provider = this.sendBeaconConfiguration;
            ExecutorService executorServiceNewSingleThreadExecutor = this.executorService;
            if (executorServiceNewSingleThreadExecutor == null) {
                executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            }
            ExecutorService executorService = executorServiceNewSingleThreadExecutor;
            Intrinsics.checkNotNullExpressionValue(executorService, "executorService ?: Execu…newSingleThreadExecutor()");
            return new DivKitConfiguration(provider, executorService, this.histogramConfiguration, this.divStorageComponent, null);
        }
    }
}
