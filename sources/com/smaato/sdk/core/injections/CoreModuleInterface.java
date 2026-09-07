package com.smaato.sdk.core.injections;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.preference.PreferenceManager;
import com.iab.omid.library.smaato.adsession.Partner;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.smaato.sdk.core.SdkConfiguration;
import com.smaato.sdk.core.ad.RequestInfoMapper;
import com.smaato.sdk.core.ad.RequestInfoProvider;
import com.smaato.sdk.core.api.ApiParams;
import com.smaato.sdk.core.api.ExpirationTimestampFactory;
import com.smaato.sdk.core.appbgdetection.AppBackgroundAwareHandler;
import com.smaato.sdk.core.browser.DiBrowserLayer;
import com.smaato.sdk.core.ccpa.CcpaDataStorage;
import com.smaato.sdk.core.csm.CsmAdResponseParser;
import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.CoreDiNames;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.dns.DnsResolver;
import com.smaato.sdk.core.errorreport.ErrorReportFactory;
import com.smaato.sdk.core.errorreport.ErrorReporter;
import com.smaato.sdk.core.framework.SimpleModuleInterface;
import com.smaato.sdk.core.gdpr.IabCmpV2DataStorage;
import com.smaato.sdk.core.gdpr.SomaGdprDataSource;
import com.smaato.sdk.core.gpp.SomaGppData;
import com.smaato.sdk.core.kpi.KpiDBHelper;
import com.smaato.sdk.core.lgpd.SomaLgpdDataSource;
import com.smaato.sdk.core.linkhandler.ActivityQueries;
import com.smaato.sdk.core.linkhandler.IntentLauncher;
import com.smaato.sdk.core.linkhandler.LinkHandler;
import com.smaato.sdk.core.locationaware.LocationAware;
import com.smaato.sdk.core.log.DiLogLayer;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.BaseConnectionStatusWatcher;
import com.smaato.sdk.core.network.ConnectionStatusWatcher;
import com.smaato.sdk.core.network.HttpClient;
import com.smaato.sdk.core.network.Interceptor;
import com.smaato.sdk.core.network.NetworkStateMonitor;
import com.smaato.sdk.core.network.PieConnectionStatusWatcher;
import com.smaato.sdk.core.network.UrlCreator;
import com.smaato.sdk.core.network.interceptors.ApiCallInterceptor;
import com.smaato.sdk.core.network.interceptors.HttpStatusToExceptionInterceptor;
import com.smaato.sdk.core.network.interceptors.LoggingInterceptor;
import com.smaato.sdk.core.network.interceptors.SomaKpiDataInterceptor;
import com.smaato.sdk.core.network.interceptors.UserAgentInterceptor;
import com.smaato.sdk.core.openmeasurement.OMImageResourceMapper;
import com.smaato.sdk.core.openmeasurement.OMVideoResourceMapper;
import com.smaato.sdk.core.rawresourceloader.RawResourceLoader;
import com.smaato.sdk.core.remoteconfig.ButtonConfigurations;
import com.smaato.sdk.core.remoteconfig.global.GenericConfigProvider;
import com.smaato.sdk.core.remoteconfig.publisher.ConfigurationProvider;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.AssetUtils;
import com.smaato.sdk.core.util.CurrentTimeProvider;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.appbackground.AppBackgroundDetector;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.webview.DiWebViewLayer;

/* JADX INFO: loaded from: classes12.dex */
public class CoreModuleInterface implements SimpleModuleInterface {
    public static final String NAME_DEFAULT_HTTP_HANDLER = "default";
    public static final String NAME_HTTP_HANDLER_WITH_STATUS_TO_EXCEPTION = "status_to_exception";
    public static final String NAME_SOMA_HTTP_HANDLER = "soma";
    public static final String OMID_JS_DI_NAME = "OMID_JS";

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String version() {
        return "22.7.2";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String moduleDiName() {
        return "CoreLightInterface";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public DiRegistry moduleDiRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda35
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5525xdf87b75b((DiRegistry) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$40$com-smaato-sdk-core-injections-CoreModuleInterface, reason: not valid java name */
    /* synthetic */ void m5525xdf87b75b(DiRegistry diRegistry) {
        diRegistry.registerFactory(AppBackgroundAwareHandler.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$0(diConstructor);
            }
        });
        diRegistry.registerFactory(CsmAdResponseParser.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$1(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(IabCmpV2DataStorage.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda14
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$2(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(SomaLgpdDataSource.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda26
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$3(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(SomaGdprDataSource.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda28
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$4(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(SimpleHttpClient.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda29
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$5(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory("default", HttpClient.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda30
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return HttpClient.builder().addInterceptor((Interceptor) diConstructor.get(LoggingInterceptor.class)).build();
            }
        });
        diRegistry.registerSingletonFactory(NAME_HTTP_HANDLER_WITH_STATUS_TO_EXCEPTION, HttpClient.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda31
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return HttpClient.builder().addInterceptor((Interceptor) diConstructor.get(HttpStatusToExceptionInterceptor.class)).addInterceptor((Interceptor) diConstructor.get(LoggingInterceptor.class)).build();
            }
        });
        diRegistry.registerSingletonFactory(NAME_SOMA_HTTP_HANDLER, HttpClient.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda32
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return HttpClient.builder().addInterceptor((Interceptor) diConstructor.get(UserAgentInterceptor.class)).addInterceptor((Interceptor) diConstructor.get(ApiCallInterceptor.class)).addInterceptor((Interceptor) diConstructor.get(SomaKpiDataInterceptor.class)).addInterceptor((Interceptor) diConstructor.get(HttpStatusToExceptionInterceptor.class)).addInterceptor((Interceptor) diConstructor.get(LoggingInterceptor.class)).build();
            }
        });
        diRegistry.registerSingletonFactory(IntentLauncher.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda34
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$9(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(ActivityQueries.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$10(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(ApiParams.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda22
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$11(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(LinkHandler.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda33
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$12(diConstructor);
            }
        });
        diRegistry.registerFactory(SomaGppData.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda36
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$13(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(ApiCallInterceptor.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda37
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$14(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(SomaKpiDataInterceptor.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda38
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$15(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(HttpStatusToExceptionInterceptor.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda39
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$16(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(UserAgentInterceptor.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda40
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$17(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(LoggingInterceptor.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda41
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$18(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(RawResourceLoader.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$19(diConstructor);
            }
        });
        diRegistry.registerFactory(CoreDiNames.NAME_DEFAULT_SHARED_PREFERENCES, SharedPreferences.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return PreferenceManager.getDefaultSharedPreferences((Context) diConstructor.get(Application.class));
            }
        });
        diRegistry.registerFactory(CoreDiNames.NAME_SMAATO_SDK_INTERNAL_PREFERENCES, SharedPreferences.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return ((Application) diConstructor.get(Application.class)).getSharedPreferences("com.smaato.sdk.prefs", 0);
            }
        });
        diRegistry.registerFactory(RequestInfoProvider.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$22(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(HeaderValueUtils.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$23(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(NetworkStateMonitor.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$24(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(ConnectionStatusWatcher.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return this.f$0.createConnectionStatusWatcher(diConstructor);
            }
        });
        diRegistry.registerFactory(ConnectivityManager.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$25(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(Partner.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return Partner.createPartner("Smaato", "22.7.2");
            }
        });
        diRegistry.registerFactory(OMVideoResourceMapper.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$27(diConstructor);
            }
        });
        diRegistry.registerFactory(OMImageResourceMapper.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$28(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory("OMID_JS", String.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return AssetUtils.getFileFromAssets((Context) diConstructor.get(Application.class), DiLogLayer.getLoggerFrom(diConstructor), POBCommonConstants.INTERNAL_SERVICE_FILE_NAME);
            }
        });
        diRegistry.registerFactory(ExpirationTimestampFactory.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$30(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(CcpaDataStorage.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda17
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$31(diConstructor);
            }
        });
        diRegistry.registerFactory(RequestInfoMapper.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda18
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$32(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(ErrorReportFactory.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda19
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$33(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory("configErrorReporter", ErrorReporter.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda20
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return this.f$0.m5523x9af6f56(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(GenericConfigProvider.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda21
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$35(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(ConfigurationProvider.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda23
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return this.f$0.m5524x6560a414(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(ButtonConfigurations.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda24
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$37(diConstructor);
            }
        });
        diRegistry.registerFactory(CurrentTimeProvider.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda25
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$38(diConstructor);
            }
        });
        diRegistry.registerFactory(UrlCreator.class, new ClassFactory() { // from class: com.smaato.sdk.core.injections.CoreModuleInterface$$ExternalSyntheticLambda27
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CoreModuleInterface.lambda$moduleDiRegistry$39(diConstructor);
            }
        });
        diRegistry.addFrom(DiBrowserLayer.createRegistry());
        diRegistry.addFrom(DiWebViewLayer.createRegistry());
    }

    static /* synthetic */ AppBackgroundAwareHandler lambda$moduleDiRegistry$0(DiConstructor diConstructor) {
        return new AppBackgroundAwareHandler(DiLogLayer.getLoggerFrom(diConstructor), Threads.newUiHandler(), (AppBackgroundDetector) diConstructor.get(AppBackgroundDetector.class));
    }

    static /* synthetic */ CsmAdResponseParser lambda$moduleDiRegistry$1(DiConstructor diConstructor) {
        return new CsmAdResponseParser(DiLogLayer.getLoggerFrom(diConstructor));
    }

    static /* synthetic */ IabCmpV2DataStorage lambda$moduleDiRegistry$2(DiConstructor diConstructor) {
        return new IabCmpV2DataStorage((SharedPreferences) diConstructor.get(CoreDiNames.NAME_DEFAULT_SHARED_PREFERENCES, SharedPreferences.class));
    }

    static /* synthetic */ SomaLgpdDataSource lambda$moduleDiRegistry$3(DiConstructor diConstructor) {
        return new SomaLgpdDataSource((LocationAware) diConstructor.get(CoreDiNames.LOCATION_AWARE_LGPD, LocationAware.class));
    }

    static /* synthetic */ SomaGdprDataSource lambda$moduleDiRegistry$4(DiConstructor diConstructor) {
        return new SomaGdprDataSource((IabCmpV2DataStorage) diConstructor.get(IabCmpV2DataStorage.class), (LocationAware) diConstructor.get(CoreDiNames.LOCATION_AWARE_GDPR, LocationAware.class));
    }

    static /* synthetic */ SimpleHttpClient lambda$moduleDiRegistry$5(DiConstructor diConstructor) {
        return new SimpleHttpClient((HttpClient) diConstructor.get("default", HttpClient.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ IntentLauncher lambda$moduleDiRegistry$9(DiConstructor diConstructor) {
        return new IntentLauncher((Application) diConstructor.get(Application.class));
    }

    static /* synthetic */ ActivityQueries lambda$moduleDiRegistry$10(DiConstructor diConstructor) {
        return new ActivityQueries((Context) diConstructor.get(Application.class));
    }

    static /* synthetic */ ApiParams lambda$moduleDiRegistry$11(DiConstructor diConstructor) {
        return new ApiParams((DataCollector) diConstructor.get(DataCollector.class), (RequestInfoProvider) diConstructor.get(RequestInfoProvider.class));
    }

    static /* synthetic */ LinkHandler lambda$moduleDiRegistry$12(DiConstructor diConstructor) {
        return new LinkHandler((Application) diConstructor.get(Application.class), (HttpClient) diConstructor.get("default", HttpClient.class), (SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), (IntentLauncher) diConstructor.get(IntentLauncher.class), (ActivityQueries) diConstructor.get(ActivityQueries.class));
    }

    static /* synthetic */ SomaGppData lambda$moduleDiRegistry$13(DiConstructor diConstructor) {
        return new SomaGppData((SharedPreferences) diConstructor.get(CoreDiNames.NAME_DEFAULT_SHARED_PREFERENCES, SharedPreferences.class));
    }

    static /* synthetic */ ApiCallInterceptor lambda$moduleDiRegistry$14(DiConstructor diConstructor) {
        return new ApiCallInterceptor((SomaGdprDataSource) diConstructor.get(SomaGdprDataSource.class), (SomaLgpdDataSource) diConstructor.get(SomaLgpdDataSource.class), (SomaGppData) diConstructor.get(SomaGppData.class), (SdkConfiguration) diConstructor.get(SdkConfiguration.class), (RequestInfoProvider) diConstructor.get(RequestInfoProvider.class), (DataCollector) diConstructor.get(DataCollector.class), ((Boolean) diConstructor.get(CoreDiNames.NAME_HTTPS_ONLY, Boolean.class)).booleanValue(), (Logger) diConstructor.get(Logger.class), (ApiParams) diConstructor.get(ApiParams.class));
    }

    static /* synthetic */ SomaKpiDataInterceptor lambda$moduleDiRegistry$15(DiConstructor diConstructor) {
        return new SomaKpiDataInterceptor((KpiDBHelper) diConstructor.get(KpiDBHelper.class));
    }

    static /* synthetic */ HttpStatusToExceptionInterceptor lambda$moduleDiRegistry$16(DiConstructor diConstructor) {
        return new HttpStatusToExceptionInterceptor();
    }

    static /* synthetic */ UserAgentInterceptor lambda$moduleDiRegistry$17(DiConstructor diConstructor) {
        return new UserAgentInterceptor((Application) diConstructor.get(Application.class));
    }

    static /* synthetic */ LoggingInterceptor lambda$moduleDiRegistry$18(DiConstructor diConstructor) {
        return new LoggingInterceptor((Boolean) diConstructor.get(CoreDiNames.NAME_IS_LOGGING_ENABLED, Boolean.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ RawResourceLoader lambda$moduleDiRegistry$19(DiConstructor diConstructor) {
        return new RawResourceLoader((Application) diConstructor.get(Application.class));
    }

    static /* synthetic */ RequestInfoProvider lambda$moduleDiRegistry$22(DiConstructor diConstructor) {
        return new RequestInfoProvider((DataCollector) diConstructor.get(DataCollector.class), (SomaGdprDataSource) diConstructor.get(SomaGdprDataSource.class), (SomaLgpdDataSource) diConstructor.get(SomaLgpdDataSource.class), (SdkConfiguration) diConstructor.get(SdkConfiguration.class), ((DataCollector) diConstructor.get(DataCollector.class)).getSystemInfo());
    }

    static /* synthetic */ HeaderValueUtils lambda$moduleDiRegistry$23(DiConstructor diConstructor) {
        return new HeaderValueUtils((Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ NetworkStateMonitor lambda$moduleDiRegistry$24(DiConstructor diConstructor) {
        return new NetworkStateMonitor((ConnectivityManager) diConstructor.get(ConnectivityManager.class), (ConnectionStatusWatcher) diConstructor.get(ConnectionStatusWatcher.class));
    }

    static /* synthetic */ ConnectivityManager lambda$moduleDiRegistry$25(DiConstructor diConstructor) {
        return (ConnectivityManager) Objects.requireNonNull((ConnectivityManager) ((Application) diConstructor.get(Application.class)).getSystemService("connectivity"));
    }

    static /* synthetic */ OMVideoResourceMapper lambda$moduleDiRegistry$27(DiConstructor diConstructor) {
        return new OMVideoResourceMapper(CampaignEx.KEY_OMID);
    }

    static /* synthetic */ OMImageResourceMapper lambda$moduleDiRegistry$28(DiConstructor diConstructor) {
        return new OMImageResourceMapper();
    }

    static /* synthetic */ ExpirationTimestampFactory lambda$moduleDiRegistry$30(DiConstructor diConstructor) {
        return new ExpirationTimestampFactory((CurrentTimeProvider) diConstructor.get(CurrentTimeProvider.class));
    }

    static /* synthetic */ CcpaDataStorage lambda$moduleDiRegistry$31(DiConstructor diConstructor) {
        return new CcpaDataStorage((SharedPreferences) diConstructor.get(CoreDiNames.NAME_DEFAULT_SHARED_PREFERENCES, SharedPreferences.class));
    }

    static /* synthetic */ RequestInfoMapper lambda$moduleDiRegistry$32(DiConstructor diConstructor) {
        return new RequestInfoMapper();
    }

    static /* synthetic */ ErrorReportFactory lambda$moduleDiRegistry$33(DiConstructor diConstructor) {
        return new ErrorReportFactory((DataCollector) diConstructor.get(DataCollector.class));
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$34$com-smaato-sdk-core-injections-CoreModuleInterface, reason: not valid java name */
    /* synthetic */ ErrorReporter m5523x9af6f56(DiConstructor diConstructor) {
        return new ErrorReporter(DiLogLayer.getLoggerFrom(diConstructor), getDefaultHttpClient(diConstructor), getPublisherConfigLogUrl(diConstructor));
    }

    static /* synthetic */ GenericConfigProvider lambda$moduleDiRegistry$35(DiConstructor diConstructor) {
        return new GenericConfigProvider((SharedPreferences) diConstructor.get(CoreDiNames.NAME_SMAATO_SDK_INTERNAL_PREFERENCES, SharedPreferences.class), (DnsResolver) diConstructor.get(DnsResolver.class), "1", (SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), (Logger) diConstructor.get(Logger.class));
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$36$com-smaato-sdk-core-injections-CoreModuleInterface, reason: not valid java name */
    /* synthetic */ ConfigurationProvider m5524x6560a414(DiConstructor diConstructor) {
        return new ConfigurationProvider(((Application) diConstructor.get(Application.class)).getSharedPreferences("com.smaato.sdk.config.publisher", 0), (DnsResolver) diConstructor.get(DnsResolver.class), "publisher_config", (SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), (NetworkStateMonitor) diConstructor.get(NetworkStateMonitor.class), getPublisherConfigDownloadUrl(diConstructor), (ErrorReportFactory) diConstructor.get(ErrorReportFactory.class), (ErrorReporter) diConstructor.get("configErrorReporter", ErrorReporter.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ ButtonConfigurations lambda$moduleDiRegistry$37(DiConstructor diConstructor) {
        return new ButtonConfigurations((GenericConfigProvider) diConstructor.get(GenericConfigProvider.class), (ConfigurationProvider) diConstructor.get(ConfigurationProvider.class));
    }

    static /* synthetic */ CurrentTimeProvider lambda$moduleDiRegistry$38(DiConstructor diConstructor) {
        return new CurrentTimeProvider();
    }

    static /* synthetic */ UrlCreator lambda$moduleDiRegistry$39(DiConstructor diConstructor) {
        return new UrlCreator();
    }

    public static HttpClient getHttpClientWithStatusToException(DiConstructor diConstructor) {
        return (HttpClient) diConstructor.get(NAME_HTTP_HANDLER_WITH_STATUS_TO_EXCEPTION, HttpClient.class);
    }

    public static HttpClient getDefaultHttpClient(DiConstructor diConstructor) {
        return (HttpClient) diConstructor.get("default", HttpClient.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConnectionStatusWatcher createConnectionStatusWatcher(DiConstructor diConstructor) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PieConnectionStatusWatcher((ConnectivityManager) diConstructor.get(ConnectivityManager.class));
        }
        return new BaseConnectionStatusWatcher((Application) diConstructor.get(Application.class));
    }

    private String getPublisherConfigDownloadUrl(DiConstructor diConstructor) {
        return ((GenericConfigProvider) diConstructor.get(GenericConfigProvider.class)).getConfiguration().getConfigUrls().getConfigurationUrl();
    }

    private String getPublisherConfigLogUrl(DiConstructor diConstructor) {
        return ((GenericConfigProvider) diConstructor.get(GenericConfigProvider.class)).getConfiguration().getConfigUrls().getConfigLogUrl();
    }
}
