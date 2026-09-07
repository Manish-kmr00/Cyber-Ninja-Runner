package com.smaato.sdk.video.framework;

import android.app.Application;
import android.content.Context;
import android.util.Xml;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.CoreDiNames;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.framework.SimpleModuleInterface;
import com.smaato.sdk.core.framework.VisibilityPrivateConfig;
import com.smaato.sdk.core.injections.CoreModuleInterface;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.video.Md5Digester;
import com.smaato.sdk.core.mvvm.model.video.VideoResourceCache;
import com.smaato.sdk.core.mvvm.view.VideoAdContentViewCreator;
import com.smaato.sdk.core.mvvm.viewmodel.VastObjectChecker;
import com.smaato.sdk.core.network.UrlCreator;
import com.smaato.sdk.core.remoteconfig.ButtonConfigurations;
import com.smaato.sdk.core.remoteconfig.global.ConfigProperties;
import com.smaato.sdk.core.remoteconfig.global.GenericConfigProvider;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.webview.BaseWebChromeClient;
import com.smaato.sdk.core.webview.BaseWebViewClient;
import com.smaato.sdk.video.ad.VastErrorTrackerCreator;
import com.smaato.sdk.video.ad.VastObjectCheckerImpl;
import com.smaato.sdk.video.ad.VideoAdContentViewCreatorImpl;
import com.smaato.sdk.video.ad.VideoAdViewFactory;
import com.smaato.sdk.video.vast.browser.VastWebComponentSecurityPolicy;
import com.smaato.sdk.video.vast.buildlight.InLineAdContainerPicker;
import com.smaato.sdk.video.vast.buildlight.InLineChecker;
import com.smaato.sdk.video.vast.buildlight.VastCompanionPicker;
import com.smaato.sdk.video.vast.buildlight.VastCompanionScenarioMapper;
import com.smaato.sdk.video.vast.buildlight.VastCompanionScenarioMerger;
import com.smaato.sdk.video.vast.buildlight.VastIconScenarioMapper;
import com.smaato.sdk.video.vast.buildlight.VastIconScenarioPicker;
import com.smaato.sdk.video.vast.buildlight.VastLinearMediaFilePicker;
import com.smaato.sdk.video.vast.buildlight.VastMediaFileScenarioMapper;
import com.smaato.sdk.video.vast.buildlight.VastMediaFileScenarioMerger;
import com.smaato.sdk.video.vast.buildlight.VastMediaFileScenarioWrapperMapper;
import com.smaato.sdk.video.vast.buildlight.VastScenarioCreativeDataMapper;
import com.smaato.sdk.video.vast.buildlight.VastScenarioMapper;
import com.smaato.sdk.video.vast.buildlight.VastScenarioPicker;
import com.smaato.sdk.video.vast.buildlight.VastScenarioWrapperMapper;
import com.smaato.sdk.video.vast.buildlight.VastScenarioWrapperMerger;
import com.smaato.sdk.video.vast.buildlight.VastTreeBuilder;
import com.smaato.sdk.video.vast.buildlight.VastWrapperCompanionScenarioPicker;
import com.smaato.sdk.video.vast.buildlight.VideoClicksMerger;
import com.smaato.sdk.video.vast.buildlight.ViewableImpressionMerger;
import com.smaato.sdk.video.vast.buildlight.WrapperAdContainerPicker;
import com.smaato.sdk.video.vast.buildlight.WrapperLoader;
import com.smaato.sdk.video.vast.buildlight.WrapperResolver;
import com.smaato.sdk.video.vast.config.DefaultWrapperResolverConfig;
import com.smaato.sdk.video.vast.config.WrapperResolverConfig;
import com.smaato.sdk.video.vast.parser.RegistryXmlParser;
import com.smaato.sdk.video.vast.parser.RegistryXmlParserFactory;
import com.smaato.sdk.video.vast.parser.VastResponseParser;
import com.smaato.sdk.video.vast.tracking.macro.DiMacros;
import com.smaato.sdk.video.vast.tracking.macro.MacrosInjectorProviderFunction;
import com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer;
import com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerCreator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes7.dex */
public class VideoModuleInterface implements SimpleModuleInterface {
    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String version() {
        return "22.7.2";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String moduleDiName() {
        return VideoDiNames.MODULE_DI_NAME;
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public DiRegistry moduleDiRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda22
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5712xb31f3466((DiRegistry) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$moduleDiRegistry$1$com-smaato-sdk-video-framework-VideoModuleInterface, reason: not valid java name */
    /* synthetic */ void m5712xb31f3466(DiRegistry diRegistry) {
        diRegistry.addFrom(buildDefaultConfigs());
        diRegistry.registerFactory(moduleDiName(), XmlPullParser.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda23
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return Xml.newPullParser();
            }
        });
        diRegistry.registerSingletonFactory(RegistryXmlParser.class, new RegistryXmlParserFactory());
        diRegistry.addFrom(buildUtilityRegistry());
        diRegistry.addFrom(buildVastDiRegistry());
        diRegistry.addFrom(DiPlayerLayer.createRegistry());
        diRegistry.addFrom(DiMacros.createRegistry());
        diRegistry.addFrom(buildVideoViewRegistry());
    }

    private static DiRegistry buildDefaultConfigs() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda21
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((DiRegistry) obj).registerFactory("WRAPPER_RESOLVER_CONFIG", WrapperResolverConfig.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda41
                    @Override // com.smaato.sdk.core.di.ClassFactory
                    /* JADX INFO: renamed from: get */
                    public final Object get2(DiConstructor diConstructor) {
                        return VideoModuleInterface.lambda$buildDefaultConfigs$2(diConstructor);
                    }
                });
            }
        });
    }

    static /* synthetic */ WrapperResolverConfig lambda$buildDefaultConfigs$2(DiConstructor diConstructor) {
        return new DefaultWrapperResolverConfig();
    }

    public boolean isFormatSupported(AdFormat adFormat) {
        return adFormat == AdFormat.VIDEO;
    }

    private DiRegistry buildUtilityRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5707x4b37e0b6((DiRegistry) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$buildUtilityRegistry$4$com-smaato-sdk-video-framework-VideoModuleInterface, reason: not valid java name */
    /* synthetic */ void m5707x4b37e0b6(DiRegistry diRegistry) {
        diRegistry.addFrom(buildVisibilityConfigBuilderRegistry());
    }

    private DiRegistry buildVideoViewRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda39
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                VideoModuleInterface.lambda$buildVideoViewRegistry$8((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$buildVideoViewRegistry$8(DiRegistry diRegistry) {
        diRegistry.registerFactory(VideoAdViewFactory.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda24
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVideoViewRegistry$5(diConstructor);
            }
        });
        diRegistry.registerFactory(VideoAdContentViewCreator.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda25
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVideoViewRegistry$6(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(VastObjectChecker.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda26
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVideoViewRegistry$7(diConstructor);
            }
        });
    }

    static /* synthetic */ VideoAdViewFactory lambda$buildVideoViewRegistry$5(DiConstructor diConstructor) {
        return new VideoAdViewFactory((Logger) diConstructor.get(Logger.class), (VastErrorTrackerCreator) diConstructor.get(VastErrorTrackerCreator.class), (VastVideoPlayerCreator) diConstructor.get(VastVideoPlayerCreator.class), (Application) diConstructor.get(Application.class));
    }

    static /* synthetic */ VideoAdContentViewCreator lambda$buildVideoViewRegistry$6(DiConstructor diConstructor) {
        return new VideoAdContentViewCreatorImpl((VideoAdViewFactory) diConstructor.get(VideoAdViewFactory.class), (VastErrorTrackerCreator) diConstructor.get(VastErrorTrackerCreator.class), (ButtonConfigurations) diConstructor.get(ButtonConfigurations.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ VastObjectChecker lambda$buildVideoViewRegistry$7(DiConstructor diConstructor) {
        return new VastObjectCheckerImpl((VastErrorTrackerCreator) diConstructor.get(VastErrorTrackerCreator.class), (Logger) diConstructor.get(Logger.class));
    }

    private DiRegistry buildVastWebComponentRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5710xc1f84d10((DiRegistry) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$buildVastWebComponentRegistry$12$com-smaato-sdk-video-framework-VideoModuleInterface, reason: not valid java name */
    /* synthetic */ void m5710xc1f84d10(DiRegistry diRegistry) {
        diRegistry.registerFactory(VastWebComponentSecurityPolicy.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda30
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastWebComponentRegistry$9(diConstructor);
            }
        });
        diRegistry.registerFactory(moduleDiName(), BaseWebViewClient.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda31
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastWebComponentRegistry$10(diConstructor);
            }
        });
        diRegistry.registerFactory(moduleDiName(), BaseWebChromeClient.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda32
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastWebComponentRegistry$11(diConstructor);
            }
        });
    }

    static /* synthetic */ VastWebComponentSecurityPolicy lambda$buildVastWebComponentRegistry$9(DiConstructor diConstructor) {
        return new VastWebComponentSecurityPolicy((Logger) diConstructor.get(Logger.class), CoreDiNames.SOMA_API_URL, (UrlCreator) diConstructor.get(UrlCreator.class), (Boolean) diConstructor.get(CoreDiNames.NAME_HTTPS_ONLY, Boolean.class));
    }

    static /* synthetic */ BaseWebViewClient lambda$buildVastWebComponentRegistry$10(DiConstructor diConstructor) {
        return new BaseWebViewClient();
    }

    static /* synthetic */ BaseWebChromeClient lambda$buildVastWebComponentRegistry$11(DiConstructor diConstructor) {
        return new BaseWebChromeClient();
    }

    private DiRegistry buildVisibilityConfigBuilderRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda40
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5711xee23d282((DiRegistry) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$buildVisibilityConfigBuilderRegistry$14$com-smaato-sdk-video-framework-VideoModuleInterface, reason: not valid java name */
    /* synthetic */ void m5711xee23d282(DiRegistry diRegistry) {
        diRegistry.registerFactory(moduleDiName(), VisibilityPrivateConfig.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda43
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVisibilityConfigBuilderRegistry$13(diConstructor);
            }
        });
    }

    static /* synthetic */ VisibilityPrivateConfig lambda$buildVisibilityConfigBuilderRegistry$13(DiConstructor diConstructor) {
        ConfigProperties configProperties = ((GenericConfigProvider) diConstructor.get(GenericConfigProvider.class)).getConfiguration().getConfigProperties();
        double dDoubleValue = configProperties.getVastAdVisibilityRatio().doubleValue();
        return new VisibilityPrivateConfig.Builder().visibilityRatio(dDoubleValue).visibilityTimeMillis(configProperties.getVastAdVisibilityTimeMillis().longValue()).build();
    }

    private DiRegistry buildVastMediaFilesMapperRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$31((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$buildVastMediaFilesMapperRegistry$31(DiRegistry diRegistry) {
        diRegistry.registerFactory(VideoClicksMerger.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$15(diConstructor);
            }
        });
        diRegistry.registerFactory(VastMediaFileScenarioMerger.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$16(diConstructor);
            }
        });
        diRegistry.registerFactory(VastWrapperCompanionScenarioPicker.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$17(diConstructor);
            }
        });
        diRegistry.registerFactory(ViewableImpressionMerger.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$18(diConstructor);
            }
        });
        diRegistry.registerFactory(VastCompanionScenarioMerger.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda14
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$19(diConstructor);
            }
        });
        diRegistry.registerFactory(VastScenarioWrapperMerger.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$20(diConstructor);
            }
        });
        diRegistry.registerFactory(VastLinearMediaFilePicker.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$21(diConstructor);
            }
        });
        diRegistry.registerFactory(VastCompanionPicker.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda17
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$22(diConstructor);
            }
        });
        diRegistry.registerFactory(VastCompanionScenarioMapper.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda18
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$23(diConstructor);
            }
        });
        diRegistry.registerFactory(VastIconScenarioMapper.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda19
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$24(diConstructor);
            }
        });
        diRegistry.registerFactory(VastIconScenarioPicker.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$25(diConstructor);
            }
        });
        diRegistry.registerFactory(VastMediaFileScenarioMapper.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$26(diConstructor);
            }
        });
        diRegistry.registerFactory(VastScenarioCreativeDataMapper.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$27(diConstructor);
            }
        });
        diRegistry.registerFactory(VastScenarioMapper.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$28(diConstructor);
            }
        });
        diRegistry.registerFactory(VastMediaFileScenarioWrapperMapper.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$29(diConstructor);
            }
        });
        diRegistry.registerFactory(VastScenarioWrapperMapper.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastMediaFilesMapperRegistry$30(diConstructor);
            }
        });
    }

    static /* synthetic */ VideoClicksMerger lambda$buildVastMediaFilesMapperRegistry$15(DiConstructor diConstructor) {
        return new VideoClicksMerger();
    }

    static /* synthetic */ VastMediaFileScenarioMerger lambda$buildVastMediaFilesMapperRegistry$16(DiConstructor diConstructor) {
        return new VastMediaFileScenarioMerger((VideoClicksMerger) diConstructor.get(VideoClicksMerger.class));
    }

    static /* synthetic */ VastWrapperCompanionScenarioPicker lambda$buildVastMediaFilesMapperRegistry$17(DiConstructor diConstructor) {
        return new VastWrapperCompanionScenarioPicker();
    }

    static /* synthetic */ ViewableImpressionMerger lambda$buildVastMediaFilesMapperRegistry$18(DiConstructor diConstructor) {
        return new ViewableImpressionMerger();
    }

    static /* synthetic */ VastCompanionScenarioMerger lambda$buildVastMediaFilesMapperRegistry$19(DiConstructor diConstructor) {
        return new VastCompanionScenarioMerger();
    }

    static /* synthetic */ VastScenarioWrapperMerger lambda$buildVastMediaFilesMapperRegistry$20(DiConstructor diConstructor) {
        return new VastScenarioWrapperMerger((VastMediaFileScenarioMerger) diConstructor.get(VastMediaFileScenarioMerger.class), (VastWrapperCompanionScenarioPicker) diConstructor.get(VastWrapperCompanionScenarioPicker.class), (VastCompanionScenarioMerger) diConstructor.get(VastCompanionScenarioMerger.class), (ViewableImpressionMerger) diConstructor.get(ViewableImpressionMerger.class));
    }

    static /* synthetic */ VastLinearMediaFilePicker lambda$buildVastMediaFilesMapperRegistry$21(DiConstructor diConstructor) {
        return new VastLinearMediaFilePicker();
    }

    static /* synthetic */ VastCompanionPicker lambda$buildVastMediaFilesMapperRegistry$22(DiConstructor diConstructor) {
        return new VastCompanionPicker();
    }

    static /* synthetic */ VastCompanionScenarioMapper lambda$buildVastMediaFilesMapperRegistry$23(DiConstructor diConstructor) {
        return new VastCompanionScenarioMapper();
    }

    static /* synthetic */ VastIconScenarioMapper lambda$buildVastMediaFilesMapperRegistry$24(DiConstructor diConstructor) {
        return new VastIconScenarioMapper();
    }

    static /* synthetic */ VastIconScenarioPicker lambda$buildVastMediaFilesMapperRegistry$25(DiConstructor diConstructor) {
        return new VastIconScenarioPicker((VastIconScenarioMapper) diConstructor.get(VastIconScenarioMapper.class));
    }

    static /* synthetic */ VastMediaFileScenarioMapper lambda$buildVastMediaFilesMapperRegistry$26(DiConstructor diConstructor) {
        return new VastMediaFileScenarioMapper((VastIconScenarioPicker) diConstructor.get(VastIconScenarioPicker.class));
    }

    static /* synthetic */ VastScenarioCreativeDataMapper lambda$buildVastMediaFilesMapperRegistry$27(DiConstructor diConstructor) {
        return new VastScenarioCreativeDataMapper();
    }

    static /* synthetic */ VastScenarioMapper lambda$buildVastMediaFilesMapperRegistry$28(DiConstructor diConstructor) {
        return new VastScenarioMapper((VastLinearMediaFilePicker) diConstructor.get(VastLinearMediaFilePicker.class), (VastCompanionPicker) diConstructor.get(VastCompanionPicker.class), (VastCompanionScenarioMapper) diConstructor.get(VastCompanionScenarioMapper.class), (VastMediaFileScenarioMapper) diConstructor.get(VastMediaFileScenarioMapper.class), (VastScenarioCreativeDataMapper) diConstructor.get(VastScenarioCreativeDataMapper.class));
    }

    static /* synthetic */ VastMediaFileScenarioWrapperMapper lambda$buildVastMediaFilesMapperRegistry$29(DiConstructor diConstructor) {
        return new VastMediaFileScenarioWrapperMapper((VastIconScenarioPicker) diConstructor.get(VastIconScenarioPicker.class));
    }

    static /* synthetic */ VastScenarioWrapperMapper lambda$buildVastMediaFilesMapperRegistry$30(DiConstructor diConstructor) {
        return new VastScenarioWrapperMapper((VastCompanionPicker) diConstructor.get(VastCompanionPicker.class), (VastCompanionScenarioMapper) diConstructor.get(VastCompanionScenarioMapper.class), (VastMediaFileScenarioWrapperMapper) diConstructor.get(VastMediaFileScenarioWrapperMapper.class), (VastScenarioCreativeDataMapper) diConstructor.get(VastScenarioCreativeDataMapper.class));
    }

    private DiRegistry buildVastScenarioPickerRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda20
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                VideoModuleInterface.lambda$buildVastScenarioPickerRegistry$35((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$buildVastScenarioPickerRegistry$35(DiRegistry diRegistry) {
        diRegistry.registerFactory(InLineAdContainerPicker.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda27
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastScenarioPickerRegistry$32(diConstructor);
            }
        });
        diRegistry.registerFactory(WrapperAdContainerPicker.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda28
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastScenarioPickerRegistry$33(diConstructor);
            }
        });
        diRegistry.registerFactory(VastScenarioPicker.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda29
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastScenarioPickerRegistry$34(diConstructor);
            }
        });
    }

    static /* synthetic */ InLineAdContainerPicker lambda$buildVastScenarioPickerRegistry$32(DiConstructor diConstructor) {
        return new InLineAdContainerPicker();
    }

    static /* synthetic */ WrapperAdContainerPicker lambda$buildVastScenarioPickerRegistry$33(DiConstructor diConstructor) {
        return new WrapperAdContainerPicker();
    }

    static /* synthetic */ VastScenarioPicker lambda$buildVastScenarioPickerRegistry$34(DiConstructor diConstructor) {
        return new VastScenarioPicker((InLineAdContainerPicker) diConstructor.get(InLineAdContainerPicker.class), (WrapperAdContainerPicker) diConstructor.get(WrapperAdContainerPicker.class), (VastScenarioWrapperMerger) diConstructor.get(VastScenarioWrapperMerger.class), (VastScenarioMapper) diConstructor.get(VastScenarioMapper.class), (VastScenarioWrapperMapper) diConstructor.get(VastScenarioWrapperMapper.class));
    }

    private DiRegistry buildVastTreeResultBuilderRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda33
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5709x44118518((DiRegistry) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$buildVastTreeResultBuilderRegistry$39$com-smaato-sdk-video-framework-VideoModuleInterface, reason: not valid java name */
    /* synthetic */ void m5709x44118518(DiRegistry diRegistry) {
        diRegistry.registerFactory(VastTreeBuilder.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda45
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastTreeResultBuilderRegistry$36(diConstructor);
            }
        });
        diRegistry.registerFactory(VastResponseParser.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda46
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastTreeResultBuilderRegistry$37(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(VideoResourceCache.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildVastTreeResultBuilderRegistry$38(diConstructor);
            }
        });
        diRegistry.addFrom(buildWrapperResolverRegistry());
    }

    static /* synthetic */ VastTreeBuilder lambda$buildVastTreeResultBuilderRegistry$36(DiConstructor diConstructor) {
        return new VastTreeBuilder((VastResponseParser) diConstructor.get(VastResponseParser.class), (WrapperResolver) diConstructor.get(WrapperResolver.class));
    }

    static /* synthetic */ VastResponseParser lambda$buildVastTreeResultBuilderRegistry$37(DiConstructor diConstructor) {
        return new VastResponseParser((RegistryXmlParser) diConstructor.get(RegistryXmlParser.class));
    }

    static /* synthetic */ VideoResourceCache lambda$buildVastTreeResultBuilderRegistry$38(DiConstructor diConstructor) {
        return new VideoResourceCache((SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), (Context) diConstructor.get(Application.class), (Md5Digester) diConstructor.get(Md5Digester.class), (Logger) diConstructor.get(Logger.class));
    }

    private DiRegistry buildWrapperResolverRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda34
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                VideoModuleInterface.lambda$buildWrapperResolverRegistry$43((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$buildWrapperResolverRegistry$43(DiRegistry diRegistry) {
        diRegistry.registerFactory(WrapperResolver.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda35
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildWrapperResolverRegistry$40(diConstructor);
            }
        });
        diRegistry.registerFactory(WrapperLoader.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda36
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildWrapperResolverRegistry$41(diConstructor);
            }
        });
        diRegistry.registerFactory(InLineChecker.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda37
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return VideoModuleInterface.lambda$buildWrapperResolverRegistry$42(diConstructor);
            }
        });
    }

    static /* synthetic */ WrapperResolver lambda$buildWrapperResolverRegistry$40(DiConstructor diConstructor) {
        return new WrapperResolver(((WrapperResolverConfig) diConstructor.get("WRAPPER_RESOLVER_CONFIG", WrapperResolverConfig.class)).getMaxDepth(), (WrapperLoader) diConstructor.get(WrapperLoader.class), (InLineChecker) diConstructor.get(InLineChecker.class), (WrapperAdContainerPicker) diConstructor.get(WrapperAdContainerPicker.class));
    }

    static /* synthetic */ WrapperLoader lambda$buildWrapperResolverRegistry$41(DiConstructor diConstructor) {
        return new WrapperLoader((VastResponseParser) diConstructor.get(VastResponseParser.class), CoreModuleInterface.getDefaultHttpClient(diConstructor));
    }

    static /* synthetic */ InLineChecker lambda$buildWrapperResolverRegistry$42(DiConstructor diConstructor) {
        return new InLineChecker();
    }

    private DiRegistry buildVastDiRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda38
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5708x1d5e27b3((DiRegistry) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$buildVastDiRegistry$44$com-smaato-sdk-video-framework-VideoModuleInterface, reason: not valid java name */
    /* synthetic */ void m5708x1d5e27b3(DiRegistry diRegistry) {
        diRegistry.addFrom(buildErrorTrackerDiRegistry());
        diRegistry.addFrom(buildVastWebComponentRegistry());
        diRegistry.addFrom(buildVastMediaFilesMapperRegistry());
        diRegistry.addFrom(buildVastScenarioPickerRegistry());
        diRegistry.addFrom(buildVastTreeResultBuilderRegistry());
    }

    public DiRegistry buildErrorTrackerDiRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda44
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((DiRegistry) obj).registerFactory(VastErrorTrackerCreator.class, new ClassFactory() { // from class: com.smaato.sdk.video.framework.VideoModuleInterface$$ExternalSyntheticLambda42
                    @Override // com.smaato.sdk.core.di.ClassFactory
                    /* JADX INFO: renamed from: get */
                    public final Object get2(DiConstructor diConstructor) {
                        return VideoModuleInterface.lambda$buildErrorTrackerDiRegistry$45(diConstructor);
                    }
                });
            }
        });
    }

    static /* synthetic */ VastErrorTrackerCreator lambda$buildErrorTrackerDiRegistry$45(DiConstructor diConstructor) {
        return new VastErrorTrackerCreator((Logger) diConstructor.get(Logger.class), (SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), (MacrosInjectorProviderFunction) diConstructor.get(MacrosInjectorProviderFunction.class));
    }

    public String toString() {
        return "VideoModuleInterface{supportedFormat: " + AdFormat.VIDEO + "}";
    }
}
