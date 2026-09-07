package com.smaato.sdk.banner.injections;

import android.app.Application;
import android.content.Context;
import com.smaato.sdk.banner.model.csm.BannerCsmRemoteSource;
import com.smaato.sdk.banner.model.soma.BannerSomaRemoteSource;
import com.smaato.sdk.banner.view.BannerViewDelegate;
import com.smaato.sdk.banner.viewmodel.BannerViewModel;
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
import com.smaato.sdk.core.mvvm.model.imagead.ImageAdResponseParser;
import com.smaato.sdk.core.mvvm.model.om.OMTrackingRemoteSource;
import com.smaato.sdk.core.mvvm.model.soma.SomaRemoteSource;
import com.smaato.sdk.core.mvvm.model.ub.UbRemoteSource;
import com.smaato.sdk.core.mvvm.model.video.VideoWrappedInRichMediaAdResponseParser;
import com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository;
import com.smaato.sdk.core.network.HttpClient;
import com.smaato.sdk.core.network.NetworkStateMonitor;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.violationreporter.AdQualityViolationReporter;
import com.smaato.sdk.richmedia.ad.RichMediaAdResponseParser;
import com.smaato.sdk.richmedia.util.HtmlPlayerUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class BannerModuleInterface implements SimpleModuleInterface {
    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String version() {
        return "22.7.2";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String moduleDiName() {
        return "BannerModuleInterface";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public DiRegistry moduleDiRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.banner.injections.BannerModuleInterface$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5497xa49fd5ba((DiRegistry) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$5$com-smaato-sdk-banner-injections-BannerModuleInterface, reason: not valid java name */
    /* synthetic */ void m5497xa49fd5ba(DiRegistry diRegistry) {
        diRegistry.registerFactory(BannerViewDelegate.class, new ClassFactory() { // from class: com.smaato.sdk.banner.injections.BannerModuleInterface$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return BannerModuleInterface.lambda$moduleDiRegistry$0(diConstructor);
            }
        });
        diRegistry.registerFactory(BannerViewModel.class, new ClassFactory() { // from class: com.smaato.sdk.banner.injections.BannerModuleInterface$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return BannerModuleInterface.lambda$moduleDiRegistry$1(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory("BannerModuleInterface", SmaatoSdkRepository.class, new ClassFactory() { // from class: com.smaato.sdk.banner.injections.BannerModuleInterface$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return this.f$0.m5496xa0fcdd1d(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(BannerSomaRemoteSource.class, new ClassFactory() { // from class: com.smaato.sdk.banner.injections.BannerModuleInterface$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return BannerModuleInterface.lambda$moduleDiRegistry$3(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(BannerCsmRemoteSource.class, new ClassFactory() { // from class: com.smaato.sdk.banner.injections.BannerModuleInterface$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return BannerModuleInterface.lambda$moduleDiRegistry$4(diConstructor);
            }
        });
    }

    static /* synthetic */ BannerViewDelegate lambda$moduleDiRegistry$0(DiConstructor diConstructor) {
        return new BannerViewDelegate((Logger) diConstructor.get(Logger.class), (BannerViewModel) diConstructor.get(BannerViewModel.class), (HtmlPlayerUtils) diConstructor.get(HtmlPlayerUtils.class));
    }

    static /* synthetic */ BannerViewModel lambda$moduleDiRegistry$1(DiConstructor diConstructor) {
        return new BannerViewModel((SmaatoSdkRepository) diConstructor.get("BannerModuleInterface", SmaatoSdkRepository.class), (Logger) diConstructor.get(Logger.class));
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$2$com-smaato-sdk-banner-injections-BannerModuleInterface, reason: not valid java name */
    /* synthetic */ SmaatoSdkRepository m5496xa0fcdd1d(DiConstructor diConstructor) {
        return new SmaatoSdkRepository((SomaRemoteSource) diConstructor.get(BannerSomaRemoteSource.class), (UbRemoteSource) diConstructor.getOrNull(UbRemoteSource.class), (CsmRemoteSource) diConstructor.get(BannerCsmRemoteSource.class), (SomaGdprDataSource) diConstructor.get(SomaGdprDataSource.class), (NetworkStateMonitor) diConstructor.get(NetworkStateMonitor.class), (LinkHandler) diConstructor.get(LinkHandler.class), (SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), (AdQualityViolationReporter) diConstructor.get(AdQualityViolationReporter.class), (OMTrackingRemoteSource) diConstructor.get(OMTrackingRemoteSource.class), createResponseParserMap(diConstructor), (ApiParams) diConstructor.get(ApiParams.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ BannerSomaRemoteSource lambda$moduleDiRegistry$3(DiConstructor diConstructor) {
        return new BannerSomaRemoteSource((HttpClient) diConstructor.get(CoreModuleInterface.NAME_SOMA_HTTP_HANDLER, HttpClient.class), (String) diConstructor.get(CoreDiNames.SOMA_API_URL, String.class), (HeaderValueUtils) diConstructor.get(HeaderValueUtils.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ BannerCsmRemoteSource lambda$moduleDiRegistry$4(DiConstructor diConstructor) {
        return new BannerCsmRemoteSource((CsmAdResponseParser) diConstructor.get(CsmAdResponseParser.class), (BannerSomaRemoteSource) diConstructor.get(BannerSomaRemoteSource.class), (Context) diConstructor.get(Application.class));
    }

    private Map createResponseParserMap(DiConstructor diConstructor) {
        HashMap map = new HashMap();
        map.put(AdFormat.STATIC_IMAGE, new ImageAdResponseParser((HeaderValueUtils) diConstructor.get(HeaderValueUtils.class), (Logger) diConstructor.get(Logger.class)));
        map.put(AdFormat.RICH_MEDIA, new RichMediaAdResponseParser((HeaderValueUtils) diConstructor.get(HeaderValueUtils.class), (Logger) diConstructor.get(Logger.class)));
        map.put(AdFormat.VIDEO, new VideoWrappedInRichMediaAdResponseParser((HeaderValueUtils) diConstructor.get(HeaderValueUtils.class)));
        map.put(AdFormat.CSM, new SomaCsmResponseParser((HeaderValueUtils) diConstructor.get(HeaderValueUtils.class)));
        return map;
    }
}
