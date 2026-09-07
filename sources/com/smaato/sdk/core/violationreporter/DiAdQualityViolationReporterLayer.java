package com.smaato.sdk.core.violationreporter;

import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.CoreDiNames;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.log.DiLogLayer;
import com.smaato.sdk.core.remoteconfig.global.GenericConfigProvider;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.HeaderUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes14.dex */
public final class DiAdQualityViolationReporterLayer {
    public static DiRegistry createRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.violationreporter.DiAdQualityViolationReporterLayer$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiAdQualityViolationReporterLayer.lambda$createRegistry$4((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$createRegistry$4(DiRegistry diRegistry) {
        diRegistry.registerFactory(CoreDiNames.SOMA_VIOLATIONS_AGGREGATOR_URL, String.class, new ClassFactory() { // from class: com.smaato.sdk.core.violationreporter.DiAdQualityViolationReporterLayer$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return ((GenericConfigProvider) diConstructor.get(GenericConfigProvider.class)).getConfiguration().getConfigUrls().getAdViolationUrl();
            }
        });
        diRegistry.registerSingletonFactory("ad_quality_violation_reporter", ExecutorService.class, new ClassFactory() { // from class: com.smaato.sdk.core.violationreporter.DiAdQualityViolationReporterLayer$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return Executors.newSingleThreadExecutor();
            }
        });
        diRegistry.registerFactory(AdQualityViolationReportMapper.class, new ClassFactory() { // from class: com.smaato.sdk.core.violationreporter.DiAdQualityViolationReporterLayer$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiAdQualityViolationReporterLayer.lambda$createRegistry$2(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(AdQualityViolationReporter.class, new ClassFactory() { // from class: com.smaato.sdk.core.violationreporter.DiAdQualityViolationReporterLayer$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiAdQualityViolationReporterLayer.lambda$createRegistry$3(diConstructor);
            }
        });
    }

    static /* synthetic */ AdQualityViolationReportMapper lambda$createRegistry$2(DiConstructor diConstructor) {
        return new AdQualityViolationReportMapper(DiLogLayer.getLoggerFrom(diConstructor), (HeaderUtils) diConstructor.get(HeaderUtils.class));
    }

    static /* synthetic */ AdQualityViolationReporter lambda$createRegistry$3(DiConstructor diConstructor) {
        return new AdQualityViolationReporter(DiLogLayer.getLoggerFrom(diConstructor), (SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), (AdQualityViolationReportMapper) diConstructor.get(AdQualityViolationReportMapper.class), (String) diConstructor.get(CoreDiNames.SOMA_VIOLATIONS_AGGREGATOR_URL, String.class));
    }
}
