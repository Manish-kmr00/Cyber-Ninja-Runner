package com.smaato.sdk.core.ub;

import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.errorreport.ErrorReporter;
import com.smaato.sdk.core.framework.SimpleModuleInterface;
import com.smaato.sdk.core.injections.CoreModuleInterface;
import com.smaato.sdk.core.log.DiLogLayer;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.ub.UbRemoteSource;
import com.smaato.sdk.core.remoteconfig.global.GenericConfigProvider;
import com.smaato.sdk.core.remoteconfig.publisher.ConfigurationProvider;
import com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportFactory;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.fi.Predicate;

/* JADX INFO: loaded from: classes14.dex */
public final class UbCommonInterface implements SimpleModuleInterface {
    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String version() {
        return "22.7.2";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String moduleDiName() {
        return "UbCommonInterface";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public DiRegistry moduleDiRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.ub.UbCommonInterface$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                UbCommonInterface.lambda$moduleDiRegistry$6((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$moduleDiRegistry$6(DiRegistry diRegistry) {
        diRegistry.registerFactory(UbRemoteSource.class, new ClassFactory() { // from class: com.smaato.sdk.core.ub.UbCommonInterface$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return UbCommonInterface.lambda$moduleDiRegistry$0(diConstructor);
            }
        });
        diRegistry.registerFactory(AdCache.class, new ClassFactory() { // from class: com.smaato.sdk.core.ub.UbCommonInterface$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return UbCommonInterface.lambda$moduleDiRegistry$2(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(UbCache.class, new ClassFactory() { // from class: com.smaato.sdk.core.ub.UbCommonInterface$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return UbCommonInterface.lambda$moduleDiRegistry$3(diConstructor);
            }
        });
        diRegistry.registerFactory(UbCacheErrorReportFactory.class, new ClassFactory() { // from class: com.smaato.sdk.core.ub.UbCommonInterface$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return UbCommonInterface.lambda$moduleDiRegistry$4(diConstructor);
            }
        });
        diRegistry.registerFactory("eventErrorReporter", ErrorReporter.class, new ClassFactory() { // from class: com.smaato.sdk.core.ub.UbCommonInterface$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return UbCommonInterface.lambda$moduleDiRegistry$5(diConstructor);
            }
        });
    }

    static /* synthetic */ UbRemoteSource lambda$moduleDiRegistry$0(DiConstructor diConstructor) {
        return new UbRemoteSourceImpl((UbCache) diConstructor.get(UbCache.class), getUnifiedBiddingEventErrorReporter(diConstructor), (UbCacheErrorReportFactory) diConstructor.get(UbCacheErrorReportFactory.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ boolean lambda$moduleDiRegistry$1(AdMarkup adMarkup) {
        return adMarkup.expiresAt().getTimestamp() - System.currentTimeMillis() > 0;
    }

    static /* synthetic */ AdCache lambda$moduleDiRegistry$2(DiConstructor diConstructor) {
        return new AdCache(20, new Predicate() { // from class: com.smaato.sdk.core.ub.UbCommonInterface$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Predicate
            public final boolean test(Object obj) {
                return UbCommonInterface.lambda$moduleDiRegistry$1((AdMarkup) obj);
            }
        });
    }

    static /* synthetic */ UbCache lambda$moduleDiRegistry$3(DiConstructor diConstructor) {
        return new UbCache((AdCache) diConstructor.get(AdCache.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ UbCacheErrorReportFactory lambda$moduleDiRegistry$4(DiConstructor diConstructor) {
        return new UbCacheErrorReportFactory((Logger) diConstructor.get(Logger.class), (DataCollector) diConstructor.get(DataCollector.class), (ConfigurationProvider) diConstructor.get(ConfigurationProvider.class));
    }

    static /* synthetic */ ErrorReporter lambda$moduleDiRegistry$5(DiConstructor diConstructor) {
        return new ErrorReporter(DiLogLayer.getLoggerFrom(diConstructor), CoreModuleInterface.getDefaultHttpClient(diConstructor), ((GenericConfigProvider) diConstructor.get(GenericConfigProvider.class)).getConfiguration().getConfigUrls().getEventLogUrl());
    }

    public static ErrorReporter getUnifiedBiddingEventErrorReporter(DiConstructor diConstructor) {
        return (ErrorReporter) diConstructor.get("eventErrorReporter", ErrorReporter.class);
    }
}
