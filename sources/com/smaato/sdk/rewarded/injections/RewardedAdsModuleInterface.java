package com.smaato.sdk.rewarded.injections;

import android.app.Application;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.api.ApiParams;
import com.smaato.sdk.core.csm.CsmAdResponseParser;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.CoreDiNames;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.framework.SimpleModuleInterface;
import com.smaato.sdk.core.gdpr.SomaGdprDataSource;
import com.smaato.sdk.core.injections.CoreModuleInterface;
import com.smaato.sdk.core.linkhandler.LinkHandler;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.csm.CsmRemoteSource;
import com.smaato.sdk.core.mvvm.model.csm.SomaCsmResponseParser;
import com.smaato.sdk.core.mvvm.model.om.OMTrackingRemoteSource;
import com.smaato.sdk.core.mvvm.model.soma.SomaRemoteSource;
import com.smaato.sdk.core.mvvm.model.ub.UbRemoteSource;
import com.smaato.sdk.core.mvvm.model.video.VideoResourceCache;
import com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository;
import com.smaato.sdk.core.mvvm.viewmodel.VastObjectChecker;
import com.smaato.sdk.core.network.HttpClient;
import com.smaato.sdk.core.network.NetworkStateMonitor;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.violationreporter.AdQualityViolationReporter;
import com.smaato.sdk.interstitial.model.soma.InterstitialSomaRemoteSource;
import com.smaato.sdk.rewarded.model.csm.RewardedCsmRemoteSource;
import com.smaato.sdk.rewarded.viewmodel.RewardedAdViewModel;
import com.smaato.sdk.richmedia.ad.RichMediaAdResponseParser;
import com.smaato.sdk.video.ad.VideoAdResponseParser;
import com.smaato.sdk.video.vast.buildlight.VastScenarioPicker;
import com.smaato.sdk.video.vast.buildlight.VastTreeBuilder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class RewardedAdsModuleInterface implements SimpleModuleInterface {
    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String version() {
        return "22.7.2";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String moduleDiName() {
        return "RewardedModuleInterface";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public DiRegistry moduleDiRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.rewarded.injections.RewardedAdsModuleInterface$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5629xe6a3c4b3((DiRegistry) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$4$com-smaato-sdk-rewarded-injections-RewardedAdsModuleInterface, reason: not valid java name */
    /* synthetic */ void m5629xe6a3c4b3(DiRegistry diRegistry) {
        diRegistry.registerFactory(RewardedAdViewModel.class, new ClassFactory() { // from class: com.smaato.sdk.rewarded.injections.RewardedAdsModuleInterface$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RewardedAdsModuleInterface.lambda$moduleDiRegistry$0(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory("RewardedModuleInterface", SmaatoSdkRepository.class, new ClassFactory() { // from class: com.smaato.sdk.rewarded.injections.RewardedAdsModuleInterface$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return this.f$0.m5628xbf537f0(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory("RewardedModuleInterface", InterstitialSomaRemoteSource.class, new ClassFactory() { // from class: com.smaato.sdk.rewarded.injections.RewardedAdsModuleInterface$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RewardedAdsModuleInterface.lambda$moduleDiRegistry$2(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(RewardedCsmRemoteSource.class, new ClassFactory() { // from class: com.smaato.sdk.rewarded.injections.RewardedAdsModuleInterface$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RewardedAdsModuleInterface.lambda$moduleDiRegistry$3(diConstructor);
            }
        });
    }

    static /* synthetic */ RewardedAdViewModel lambda$moduleDiRegistry$0(DiConstructor diConstructor) {
        return new RewardedAdViewModel((SmaatoSdkRepository) diConstructor.get("RewardedModuleInterface", SmaatoSdkRepository.class), (VastObjectChecker) diConstructor.get(VastObjectChecker.class), (Logger) diConstructor.get(Logger.class));
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$1$com-smaato-sdk-rewarded-injections-RewardedAdsModuleInterface, reason: not valid java name */
    /* synthetic */ SmaatoSdkRepository m5628xbf537f0(DiConstructor diConstructor) {
        return new SmaatoSdkRepository((SomaRemoteSource) diConstructor.get("RewardedModuleInterface", InterstitialSomaRemoteSource.class), (UbRemoteSource) diConstructor.getOrNull(UbRemoteSource.class), (CsmRemoteSource) diConstructor.get(RewardedCsmRemoteSource.class), (SomaGdprDataSource) diConstructor.get(SomaGdprDataSource.class), (NetworkStateMonitor) diConstructor.get(NetworkStateMonitor.class), (LinkHandler) diConstructor.get(LinkHandler.class), (SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), (AdQualityViolationReporter) diConstructor.get(AdQualityViolationReporter.class), (OMTrackingRemoteSource) diConstructor.get(OMTrackingRemoteSource.class), createResponseParserMap(diConstructor), (ApiParams) diConstructor.get(ApiParams.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ InterstitialSomaRemoteSource lambda$moduleDiRegistry$2(DiConstructor diConstructor) {
        return new InterstitialSomaRemoteSource((HttpClient) diConstructor.get(CoreModuleInterface.NAME_SOMA_HTTP_HANDLER, HttpClient.class), (String) diConstructor.get(CoreDiNames.SOMA_API_URL, String.class), (HeaderValueUtils) diConstructor.get(HeaderValueUtils.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ RewardedCsmRemoteSource lambda$moduleDiRegistry$3(DiConstructor diConstructor) {
        return new RewardedCsmRemoteSource((CsmAdResponseParser) diConstructor.get(CsmAdResponseParser.class), (InterstitialSomaRemoteSource) diConstructor.get("RewardedModuleInterface", InterstitialSomaRemoteSource.class));
    }

    private Map createResponseParserMap(DiConstructor diConstructor) {
        HashMap map = new HashMap();
        map.put(AdFormat.VIDEO, new VideoAdResponseParser((HeaderValueUtils) diConstructor.get(HeaderValueUtils.class), (VastTreeBuilder) diConstructor.get(VastTreeBuilder.class), (VastScenarioPicker) diConstructor.get(VastScenarioPicker.class), false, false, (VideoResourceCache) diConstructor.get(VideoResourceCache.class), (ApiParams) diConstructor.get(ApiParams.class), (Application) diConstructor.get(Application.class), (Logger) diConstructor.get(Logger.class)));
        map.put(AdFormat.RICH_MEDIA, new RichMediaAdResponseParser((HeaderValueUtils) diConstructor.get(HeaderValueUtils.class), (Logger) diConstructor.get(Logger.class)));
        map.put(AdFormat.CSM, new SomaCsmResponseParser((HeaderValueUtils) diConstructor.get(HeaderValueUtils.class)));
        return map;
    }
}
