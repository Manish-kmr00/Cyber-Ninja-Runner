package com.smaato.sdk.nativead.injections;

import android.app.Application;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.api.ApiParams;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.CoreDiNames;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.framework.SimpleModuleInterface;
import com.smaato.sdk.core.gdpr.SomaGdprDataSource;
import com.smaato.sdk.core.linkhandler.LinkHandler;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.csm.CsmParameters;
import com.smaato.sdk.core.mvvm.model.csm.CsmRemoteSource;
import com.smaato.sdk.core.mvvm.model.om.OMTrackingRemoteSource;
import com.smaato.sdk.core.mvvm.model.soma.SomaAdRequest;
import com.smaato.sdk.core.mvvm.model.soma.SomaRemoteSource;
import com.smaato.sdk.core.mvvm.model.ub.UbRemoteSource;
import com.smaato.sdk.core.network.HttpClient;
import com.smaato.sdk.core.network.Interceptor;
import com.smaato.sdk.core.network.NetworkStateMonitor;
import com.smaato.sdk.core.network.interceptors.ApiCallInterceptor;
import com.smaato.sdk.core.network.interceptors.HttpStatusToExceptionInterceptor;
import com.smaato.sdk.core.network.interceptors.LoggingInterceptor;
import com.smaato.sdk.core.network.interceptors.SomaKpiDataInterceptor;
import com.smaato.sdk.core.network.interceptors.UserAgentInterceptor;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.violationreporter.AdQualityViolationReporter;
import com.smaato.sdk.nativead.model.soma.NativeAdInterceptor;
import com.smaato.sdk.nativead.model.soma.NativeAdResponseParser;
import com.smaato.sdk.nativead.model.soma.NativeSomaRemoteSource;
import com.smaato.sdk.nativead.model.utils.IconImagesLoader;
import com.smaato.sdk.nativead.repository.NativeAdRepository;
import com.smaato.sdk.nativead.viewmodel.NativeAdViewModel;
import com.smaato.sdk.richmedia.util.HtmlPlayerUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class NativeModuleInterface implements SimpleModuleInterface {
    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String version() {
        return "22.7.2";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String moduleDiName() {
        return "NativeModuleInterface";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public DiRegistry moduleDiRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.nativead.injections.NativeModuleInterface$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5621x1131a1a1((DiRegistry) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$5$com-smaato-sdk-nativead-injections-NativeModuleInterface, reason: not valid java name */
    /* synthetic */ void m5621x1131a1a1(DiRegistry diRegistry) {
        diRegistry.registerFactory(NativeAdViewModel.class, new ClassFactory() { // from class: com.smaato.sdk.nativead.injections.NativeModuleInterface$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return NativeModuleInterface.lambda$moduleDiRegistry$0(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(NativeAdRepository.class, new ClassFactory() { // from class: com.smaato.sdk.nativead.injections.NativeModuleInterface$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return this.f$0.m5620xdd7d4525(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(NativeSomaRemoteSource.class, new ClassFactory() { // from class: com.smaato.sdk.nativead.injections.NativeModuleInterface$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return NativeModuleInterface.lambda$moduleDiRegistry$2(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(IconImagesLoader.class, new ClassFactory() { // from class: com.smaato.sdk.nativead.injections.NativeModuleInterface$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return NativeModuleInterface.lambda$moduleDiRegistry$3(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory("NativeModuleInterface", HttpClient.class, new ClassFactory() { // from class: com.smaato.sdk.nativead.injections.NativeModuleInterface$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return HttpClient.builder().addInterceptor((Interceptor) diConstructor.get(UserAgentInterceptor.class)).addInterceptor((Interceptor) diConstructor.get(ApiCallInterceptor.class)).addInterceptor((Interceptor) diConstructor.get(SomaKpiDataInterceptor.class)).addInterceptor((Interceptor) diConstructor.get(HttpStatusToExceptionInterceptor.class)).addInterceptor(new NativeAdInterceptor()).addInterceptor((Interceptor) diConstructor.get(LoggingInterceptor.class)).build();
            }
        });
    }

    static /* synthetic */ NativeAdViewModel lambda$moduleDiRegistry$0(DiConstructor diConstructor) {
        return new NativeAdViewModel((NativeAdRepository) diConstructor.get(NativeAdRepository.class), (Logger) diConstructor.get(Logger.class));
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$1$com-smaato-sdk-nativead-injections-NativeModuleInterface, reason: not valid java name */
    /* synthetic */ NativeAdRepository m5620xdd7d4525(DiConstructor diConstructor) {
        return new NativeAdRepository((SomaRemoteSource) diConstructor.get(NativeSomaRemoteSource.class), (UbRemoteSource) diConstructor.getOrNull(UbRemoteSource.class), createDummyCsmRemoteSource(), (SomaGdprDataSource) diConstructor.get(SomaGdprDataSource.class), (NetworkStateMonitor) diConstructor.get(NetworkStateMonitor.class), (LinkHandler) diConstructor.get(LinkHandler.class), (SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), (AdQualityViolationReporter) diConstructor.get(AdQualityViolationReporter.class), (OMTrackingRemoteSource) diConstructor.get(OMTrackingRemoteSource.class), createResponseParserMap(diConstructor), (ApiParams) diConstructor.get(ApiParams.class), (IconImagesLoader) diConstructor.get(IconImagesLoader.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ NativeSomaRemoteSource lambda$moduleDiRegistry$2(DiConstructor diConstructor) {
        return new NativeSomaRemoteSource((HttpClient) diConstructor.get("NativeModuleInterface", HttpClient.class), (String) diConstructor.get(CoreDiNames.SOMA_API_URL, String.class), (HeaderValueUtils) diConstructor.get(HeaderValueUtils.class), (IconImagesLoader) diConstructor.get(IconImagesLoader.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ IconImagesLoader lambda$moduleDiRegistry$3(DiConstructor diConstructor) {
        return new IconImagesLoader((SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), (Logger) diConstructor.get(Logger.class), (Application) diConstructor.get(Application.class));
    }

    private CsmRemoteSource createDummyCsmRemoteSource() {
        return new CsmRemoteSource() { // from class: com.smaato.sdk.nativead.injections.NativeModuleInterface.1
            @Override // com.smaato.sdk.core.mvvm.model.csm.CsmRemoteSource
            public void loadAd(String str, SomaAdRequest somaAdRequest, Consumer consumer, Consumer consumer2, CsmParameters csmParameters) {
            }
        };
    }

    private Map createResponseParserMap(DiConstructor diConstructor) {
        HashMap map = new HashMap();
        map.put(AdFormat.NATIVE, new NativeAdResponseParser((HeaderValueUtils) diConstructor.get(HeaderValueUtils.class), (HtmlPlayerUtils) diConstructor.get(HtmlPlayerUtils.class)));
        return map;
    }
}
