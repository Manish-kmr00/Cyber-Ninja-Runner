package com.smaato.sdk.richmedia.injections;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import com.smaato.sdk.core.SdkConfiguration;
import com.smaato.sdk.core.ad.RequestInfoMapper;
import com.smaato.sdk.core.ad.RequestInfoProvider;
import com.smaato.sdk.core.appbgdetection.AppBackgroundAwareHandler;
import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.CoreDiNames;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.dns.DnsResolver;
import com.smaato.sdk.core.framework.SimpleModuleInterface;
import com.smaato.sdk.core.framework.VisibilityPrivateConfig;
import com.smaato.sdk.core.gdpr.SomaGdprDataSource;
import com.smaato.sdk.core.lgpd.SomaLgpdDataSource;
import com.smaato.sdk.core.log.DiLogLayer;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.view.RichMediaAdContentViewCreator;
import com.smaato.sdk.core.rawresourceloader.RawResourceLoader;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.AppMetaData;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.core.util.Whatever;
import com.smaato.sdk.core.util.appbackground.AppBackgroundDetector;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.notifier.ChangeSenderUtils;
import com.smaato.sdk.richmedia.ad.RichMediaAdContentViewCreatorImpl;
import com.smaato.sdk.richmedia.ad.RichMediaAdResponseParser;
import com.smaato.sdk.richmedia.mraid.MraidConfigurator;
import com.smaato.sdk.richmedia.mraid.RichMediaWebViewFactory;
import com.smaato.sdk.richmedia.mraid.dataprovider.AudioVolumeContentObserver;
import com.smaato.sdk.richmedia.mraid.dataprovider.AudioVolumeObserver;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidStateMachineFactory;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidSupportsProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MusicPlaybackVolume;
import com.smaato.sdk.richmedia.util.HtmlPlayerUtils;
import com.smaato.sdk.richmedia.util.OutstreamAdTemplateResourceCache;
import com.smaato.sdk.richmedia.util.RichMediaHtmlUtils;
import com.smaato.sdk.richmedia.widget.LoadedWebViewCache;
import com.smaato.sdk.richmedia.widget.OrientationBroadcastReceiver;
import com.smaato.sdk.richmedia.widget.OrientationChangeWatcher;

/* JADX INFO: loaded from: classes9.dex */
public class RichMediaLightModuleInterface implements SimpleModuleInterface {
    public static final String RICH_MEDIA_VISIBILITY_PRIVATE_CONFIG_NAME = "RICH_MEDIA_VISIBILITY_PRIVATE_CONFIG_NAME";

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String version() {
        return "22.7.2";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String moduleDiName() {
        return "RichMediaLightModuleInterface";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public DiRegistry moduleDiRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5645xaa33fbc6((DiRegistry) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$10$com-smaato-sdk-richmedia-injections-RichMediaLightModuleInterface, reason: not valid java name */
    /* synthetic */ void m5645xaa33fbc6(DiRegistry diRegistry) {
        diRegistry.registerFactory(moduleDiName(), RichMediaHtmlUtils.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$moduleDiRegistry$0(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(HtmlPlayerUtils.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$moduleDiRegistry$1(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(OutstreamAdTemplateResourceCache.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda17
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$moduleDiRegistry$2(diConstructor);
            }
        });
        diRegistry.registerFactory(MraidConfigurator.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda18
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$moduleDiRegistry$3(diConstructor);
            }
        });
        diRegistry.registerFactory(MraidStateMachineFactory.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda19
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$moduleDiRegistry$4(diConstructor);
            }
        });
        diRegistry.registerFactory(moduleDiName(), VisibilityPrivateConfig.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda20
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return this.f$0.m5646x5e8afc8a(diConstructor);
            }
        });
        diRegistry.registerFactory(RICH_MEDIA_VISIBILITY_PRIVATE_CONFIG_NAME, VisibilityPrivateConfig.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda21
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return this.f$0.m5647x3a4c784b(diConstructor);
            }
        });
        diRegistry.registerFactory(RichMediaAdResponseParser.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$moduleDiRegistry$7(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(RichMediaAdContentViewCreator.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$moduleDiRegistry$8(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(LoadedWebViewCache.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$moduleDiRegistry$9(diConstructor);
            }
        });
        diRegistry.addFrom(provideOrientationChangeWatcher());
        diRegistry.addFrom(provideRichMediaWebViewFactory());
        diRegistry.addFrom(provideMraidSupportsFeature());
        diRegistry.addFrom(provideAudioVolumeObserver());
    }

    static /* synthetic */ RichMediaHtmlUtils lambda$moduleDiRegistry$0(DiConstructor diConstructor) {
        return new RichMediaHtmlUtils((Boolean) diConstructor.get(CoreDiNames.NAME_IS_LOGGING_ENABLED, Boolean.class));
    }

    static /* synthetic */ HtmlPlayerUtils lambda$moduleDiRegistry$1(DiConstructor diConstructor) {
        return new HtmlPlayerUtils((OutstreamAdTemplateResourceCache) diConstructor.get(OutstreamAdTemplateResourceCache.class));
    }

    static /* synthetic */ OutstreamAdTemplateResourceCache lambda$moduleDiRegistry$2(DiConstructor diConstructor) {
        return new OutstreamAdTemplateResourceCache((SharedPreferences) diConstructor.get(CoreDiNames.NAME_SMAATO_SDK_INTERNAL_PREFERENCES, SharedPreferences.class), (DnsResolver) diConstructor.get(DnsResolver.class), "1", (RawResourceLoader) diConstructor.get(RawResourceLoader.class), (SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), DiLogLayer.getLoggerFrom(diConstructor));
    }

    static /* synthetic */ MraidConfigurator lambda$moduleDiRegistry$3(DiConstructor diConstructor) {
        return new MraidConfigurator((AppBackgroundAwareHandler) diConstructor.get(AppBackgroundAwareHandler.class), (OrientationChangeWatcher) diConstructor.get(OrientationChangeWatcher.class), (AppBackgroundDetector) diConstructor.get(AppBackgroundDetector.class), DiLogLayer.getLoggerFrom(diConstructor), (RequestInfoProvider) diConstructor.get(RequestInfoProvider.class), (SdkConfiguration) diConstructor.get(SdkConfiguration.class), (MraidStateMachineFactory) diConstructor.get(MraidStateMachineFactory.class), (RichMediaWebViewFactory) diConstructor.get(RichMediaWebViewFactory.class), (RequestInfoMapper) diConstructor.get(RequestInfoMapper.class), (MraidSupportsProperties) diConstructor.get(MraidSupportsProperties.class), (AudioVolumeObserver) diConstructor.get(AudioVolumeObserver.class), (MusicPlaybackVolume) diConstructor.get(MusicPlaybackVolume.class), (DataCollector) diConstructor.get(DataCollector.class), (LoadedWebViewCache) diConstructor.get(LoadedWebViewCache.class));
    }

    static /* synthetic */ MraidStateMachineFactory lambda$moduleDiRegistry$4(DiConstructor diConstructor) {
        return new MraidStateMachineFactory(MraidStateMachineFactory.State.LOADING);
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$5$com-smaato-sdk-richmedia-injections-RichMediaLightModuleInterface, reason: not valid java name */
    /* synthetic */ VisibilityPrivateConfig m5646x5e8afc8a(DiConstructor diConstructor) {
        return createVisibilityPrivateConfig();
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$6$com-smaato-sdk-richmedia-injections-RichMediaLightModuleInterface, reason: not valid java name */
    /* synthetic */ VisibilityPrivateConfig m5647x3a4c784b(DiConstructor diConstructor) {
        return createVisibilityPrivateConfig();
    }

    static /* synthetic */ RichMediaAdResponseParser lambda$moduleDiRegistry$7(DiConstructor diConstructor) {
        return new RichMediaAdResponseParser((HeaderValueUtils) diConstructor.get(HeaderValueUtils.class), DiLogLayer.getLoggerFrom(diConstructor));
    }

    static /* synthetic */ RichMediaAdContentViewCreator lambda$moduleDiRegistry$8(DiConstructor diConstructor) {
        return new RichMediaAdContentViewCreatorImpl((MraidConfigurator) diConstructor.get(MraidConfigurator.class), (RichMediaWebViewFactory) diConstructor.get(RichMediaWebViewFactory.class), (AppBackgroundDetector) diConstructor.get(AppBackgroundDetector.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ LoadedWebViewCache lambda$moduleDiRegistry$9(DiConstructor diConstructor) {
        return new LoadedWebViewCache();
    }

    private VisibilityPrivateConfig createVisibilityPrivateConfig() {
        return new VisibilityPrivateConfig.Builder().visibilityRatio(0.01d).visibilityTimeMillis(0L).build();
    }

    private DiRegistry provideAudioVolumeObserver() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                RichMediaLightModuleInterface.lambda$provideAudioVolumeObserver$14((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$provideAudioVolumeObserver$14(DiRegistry diRegistry) {
        diRegistry.registerFactory(AudioVolumeContentObserver.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$provideAudioVolumeObserver$11(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(AudioVolumeObserver.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$provideAudioVolumeObserver$12(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(MusicPlaybackVolume.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$provideAudioVolumeObserver$13(diConstructor);
            }
        });
    }

    static /* synthetic */ AudioVolumeContentObserver lambda$provideAudioVolumeObserver$11(DiConstructor diConstructor) {
        MusicPlaybackVolume musicPlaybackVolume = (MusicPlaybackVolume) diConstructor.get(MusicPlaybackVolume.class);
        return new AudioVolumeContentObserver((Context) diConstructor.get(Application.class), musicPlaybackVolume, ChangeSenderUtils.createUniqueValueChangeSender(Integer.valueOf(musicPlaybackVolume.getCurrentVolume())));
    }

    static /* synthetic */ AudioVolumeObserver lambda$provideAudioVolumeObserver$12(DiConstructor diConstructor) {
        return new AudioVolumeObserver((AudioVolumeContentObserver) diConstructor.get(AudioVolumeContentObserver.class), ((MusicPlaybackVolume) diConstructor.get(MusicPlaybackVolume.class)).getMaxVolume());
    }

    static /* synthetic */ MusicPlaybackVolume lambda$provideAudioVolumeObserver$13(DiConstructor diConstructor) {
        return new MusicPlaybackVolume((AudioManager) ((Application) diConstructor.get(Application.class)).getSystemService("audio"));
    }

    private DiRegistry provideOrientationChangeWatcher() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                RichMediaLightModuleInterface.lambda$provideOrientationChangeWatcher$17((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$provideOrientationChangeWatcher$17(DiRegistry diRegistry) {
        diRegistry.registerFactory(OrientationBroadcastReceiver.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$provideOrientationChangeWatcher$15(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(OrientationChangeWatcher.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return RichMediaLightModuleInterface.lambda$provideOrientationChangeWatcher$16(diConstructor);
            }
        });
    }

    static /* synthetic */ OrientationBroadcastReceiver lambda$provideOrientationChangeWatcher$15(DiConstructor diConstructor) {
        return new OrientationBroadcastReceiver((Context) diConstructor.get(Application.class), ChangeSenderUtils.createChangeSender(Whatever.INSTANCE));
    }

    static /* synthetic */ OrientationChangeWatcher lambda$provideOrientationChangeWatcher$16(DiConstructor diConstructor) {
        return new OrientationChangeWatcher((OrientationBroadcastReceiver) diConstructor.get(OrientationBroadcastReceiver.class));
    }

    private DiRegistry provideRichMediaWebViewFactory() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5649xe2da60a5((DiRegistry) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$provideRichMediaWebViewFactory$19$com-smaato-sdk-richmedia-injections-RichMediaLightModuleInterface, reason: not valid java name */
    /* synthetic */ void m5649xe2da60a5(DiRegistry diRegistry) {
        diRegistry.registerFactory(RichMediaWebViewFactory.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return this.f$0.m5648x718e4e4(diConstructor);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$provideRichMediaWebViewFactory$18$com-smaato-sdk-richmedia-injections-RichMediaLightModuleInterface, reason: not valid java name */
    /* synthetic */ RichMediaWebViewFactory m5648x718e4e4(DiConstructor diConstructor) {
        return new RichMediaWebViewFactory(DiLogLayer.getLoggerFrom(diConstructor), (RichMediaHtmlUtils) diConstructor.get(moduleDiName(), RichMediaHtmlUtils.class));
    }

    private DiRegistry provideMraidSupportsFeature() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda14
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((DiRegistry) obj).registerFactory(MraidSupportsProperties.class, new ClassFactory() { // from class: com.smaato.sdk.richmedia.injections.RichMediaLightModuleInterface$$ExternalSyntheticLambda5
                    @Override // com.smaato.sdk.core.di.ClassFactory
                    /* JADX INFO: renamed from: get */
                    public final Object get2(DiConstructor diConstructor) {
                        return RichMediaLightModuleInterface.lambda$provideMraidSupportsFeature$20(diConstructor);
                    }
                });
            }
        });
    }

    static /* synthetic */ MraidSupportsProperties lambda$provideMraidSupportsFeature$20(DiConstructor diConstructor) {
        return new MraidSupportsProperties((AppMetaData) diConstructor.get(AppMetaData.class), (SdkConfiguration) diConstructor.get(SdkConfiguration.class), (SomaGdprDataSource) diConstructor.get(SomaGdprDataSource.class), (SomaLgpdDataSource) diConstructor.get(SomaLgpdDataSource.class));
    }
}
