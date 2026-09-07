package com.smaato.sdk.core.datacollector;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.location.LocationManager;
import android.telephony.TelephonyManager;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.NetworkStateMonitor;
import com.smaato.sdk.core.remoteconfig.global.GenericConfigProvider;
import com.smaato.sdk.core.util.AppMetaData;
import com.smaato.sdk.core.util.Clock;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes13.dex */
public final class DiDataCollectorLayer {
    public static DiRegistry createRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.datacollector.DiDataCollectorLayer$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiDataCollectorLayer.lambda$createRegistry$10((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$createRegistry$10(DiRegistry diRegistry) {
        diRegistry.registerSingletonFactory("DATA_COLLECTION_EXECUTOR_SERVICE", ExecutorService.class, new ClassFactory() { // from class: com.smaato.sdk.core.datacollector.DiDataCollectorLayer$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return Executors.newSingleThreadExecutor();
            }
        });
        diRegistry.registerSingletonFactory(DataCollector.class, new ClassFactory() { // from class: com.smaato.sdk.core.datacollector.DiDataCollectorLayer$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiDataCollectorLayer.lambda$createRegistry$1(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(TelephonyManager.class, new ClassFactory() { // from class: com.smaato.sdk.core.datacollector.DiDataCollectorLayer$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiDataCollectorLayer.lambda$createRegistry$2(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(ContentResolver.class, new ClassFactory() { // from class: com.smaato.sdk.core.datacollector.DiDataCollectorLayer$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiDataCollectorLayer.lambda$createRegistry$3(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(SystemInfoProvider.class, new ClassFactory() { // from class: com.smaato.sdk.core.datacollector.DiDataCollectorLayer$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiDataCollectorLayer.lambda$createRegistry$4(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(LocationProvider.class, new ClassFactory() { // from class: com.smaato.sdk.core.datacollector.DiDataCollectorLayer$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiDataCollectorLayer.lambda$createRegistry$5(diConstructor);
            }
        });
        diRegistry.registerFactory(Clock.class, new ClassFactory() { // from class: com.smaato.sdk.core.datacollector.DiDataCollectorLayer$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiDataCollectorLayer.lambda$createRegistry$6(diConstructor);
            }
        });
        diRegistry.registerFactory(LocationDetector.class, new ClassFactory() { // from class: com.smaato.sdk.core.datacollector.DiDataCollectorLayer$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiDataCollectorLayer.lambda$createRegistry$7(diConstructor);
            }
        });
        diRegistry.registerFactory(LocationManager.class, new ClassFactory() { // from class: com.smaato.sdk.core.datacollector.DiDataCollectorLayer$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiDataCollectorLayer.lambda$createRegistry$8(diConstructor);
            }
        });
        diRegistry.registerFactory(UserAgentProvider.class, new ClassFactory() { // from class: com.smaato.sdk.core.datacollector.DiDataCollectorLayer$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiDataCollectorLayer.lambda$createRegistry$9(diConstructor);
            }
        });
    }

    static /* synthetic */ DataCollector lambda$createRegistry$1(DiConstructor diConstructor) {
        return new DataCollector((SystemInfoProvider) diConstructor.get(SystemInfoProvider.class), (LocationProvider) diConstructor.get(LocationProvider.class));
    }

    static /* synthetic */ TelephonyManager lambda$createRegistry$2(DiConstructor diConstructor) {
        return (TelephonyManager) Objects.requireNonNull((TelephonyManager) ((Application) diConstructor.get(Application.class)).getSystemService("phone"));
    }

    static /* synthetic */ ContentResolver lambda$createRegistry$3(DiConstructor diConstructor) {
        return (ContentResolver) Objects.requireNonNull(((Application) diConstructor.get(Application.class)).getContentResolver());
    }

    static /* synthetic */ SystemInfoProvider lambda$createRegistry$4(DiConstructor diConstructor) {
        return new SystemInfoProvider((Logger) diConstructor.get(Logger.class), (Context) diConstructor.get(Application.class), (NetworkStateMonitor) diConstructor.get(NetworkStateMonitor.class), (TelephonyManager) diConstructor.get(TelephonyManager.class), (UserAgentProvider) diConstructor.get(UserAgentProvider.class));
    }

    static /* synthetic */ LocationProvider lambda$createRegistry$5(DiConstructor diConstructor) {
        return new LocationProvider((LocationDetector) diConstructor.get(LocationDetector.class), (Clock) diConstructor.get(Clock.class), ((GenericConfigProvider) diConstructor.get(GenericConfigProvider.class)).getConfiguration().getConfigProperties().getLocationValidForPeriodMin().longValue());
    }

    static /* synthetic */ Clock lambda$createRegistry$6(DiConstructor diConstructor) {
        return new Clock();
    }

    static /* synthetic */ LocationDetector lambda$createRegistry$7(DiConstructor diConstructor) {
        return new LocationDetector((LocationManager) diConstructor.get(LocationManager.class), (AppMetaData) diConstructor.get(AppMetaData.class));
    }

    static /* synthetic */ LocationManager lambda$createRegistry$8(DiConstructor diConstructor) {
        return (LocationManager) Objects.requireNonNull(((Application) diConstructor.get(Application.class)).getSystemService("location"));
    }

    static /* synthetic */ UserAgentProvider lambda$createRegistry$9(DiConstructor diConstructor) {
        return new UserAgentProvider((Context) diConstructor.get(Application.class));
    }
}
