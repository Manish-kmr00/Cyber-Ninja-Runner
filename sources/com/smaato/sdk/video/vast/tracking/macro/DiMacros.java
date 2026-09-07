package com.smaato.sdk.video.vast.tracking.macro;

import android.app.Application;
import android.content.Context;
import com.smaato.sdk.core.SdkConfiguration;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.RequestInfoProvider;
import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.gdpr.SomaGdprDataSource;
import com.smaato.sdk.core.util.Size;
import com.smaato.sdk.core.util.UIUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.utils.DateFormatUtils;
import com.smaato.sdk.video.utils.RandomUtils;
import com.smaato.sdk.video.utils.UriUtils;
import com.smaato.sdk.video.vast.model.VastScenario;

/* JADX INFO: loaded from: classes3.dex */
public final class DiMacros {

    /* JADX INFO: Access modifiers changed from: private */
    interface AdBreakInfoMacrosProvider extends NullableArgumentFunction<VastScenario, AdBreakInfoMacros> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface PlayerStateInfoMacrosProvider extends NullableArgumentFunction<VastScenario, PlayerStateInfoMacros> {
    }

    public static DiRegistry createRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiMacros.lambda$createRegistry$17((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$createRegistry$17(DiRegistry diRegistry) {
        diRegistry.registerFactory(MacrosInjectorProviderFunction.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda17
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$1(diConstructor);
            }
        });
        diRegistry.registerFactory(UriUtils.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda21
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$2(diConstructor);
            }
        });
        diRegistry.registerFactory(DateFormatUtils.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$3(diConstructor);
            }
        });
        diRegistry.registerFactory(RandomUtils.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$4(diConstructor);
            }
        });
        diRegistry.registerFactory(AdBreakInfoMacrosProvider.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$6(diConstructor);
            }
        });
        diRegistry.registerFactory(CapabilitiesInfoMacro.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$7(diConstructor);
            }
        });
        diRegistry.registerFactory(ClientInfoMacros.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$8(diConstructor);
            }
        });
        diRegistry.registerFactory(GenericMacros.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$9(diConstructor);
            }
        });
        diRegistry.registerFactory(PlayerStateInfoMacrosProvider.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$12(diConstructor);
            }
        });
        diRegistry.registerFactory(PublisherInfoMacro.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$13(diConstructor);
            }
        });
        diRegistry.registerFactory(RegulationInfoMacros.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda18
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$14(diConstructor);
            }
        });
        diRegistry.registerFactory(VerificationInfoMacros.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda19
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$15(diConstructor);
            }
        });
        diRegistry.registerFactory(ErrorInfoMacros.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda20
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiMacros.lambda$createRegistry$16(diConstructor);
            }
        });
        diRegistry.addFrom(provideClientInfoMacros());
    }

    static /* synthetic */ MacroInjector lambda$createRegistry$0(DiConstructor diConstructor, VastScenario vastScenario) {
        return new MacroInjector((UriUtils) diConstructor.get(UriUtils.class), ((AdBreakInfoMacrosProvider) diConstructor.get(AdBreakInfoMacrosProvider.class)).apply(vastScenario), (CapabilitiesInfoMacro) diConstructor.get(CapabilitiesInfoMacro.class), (ClientInfoMacros) diConstructor.get(ClientInfoMacros.class), (GenericMacros) diConstructor.get(GenericMacros.class), ((PlayerStateInfoMacrosProvider) diConstructor.get(PlayerStateInfoMacrosProvider.class)).apply(vastScenario), (PublisherInfoMacro) diConstructor.get(PublisherInfoMacro.class), (RegulationInfoMacros) diConstructor.get(RegulationInfoMacros.class), (VerificationInfoMacros) diConstructor.get(VerificationInfoMacros.class), (ClickInfoMacros) diConstructor.get(ClickInfoMacros.class), (ErrorInfoMacros) diConstructor.get(ErrorInfoMacros.class));
    }

    static /* synthetic */ MacrosInjectorProviderFunction lambda$createRegistry$1(final DiConstructor diConstructor) {
        return new MacrosInjectorProviderFunction() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.video.vast.tracking.macro.NullableArgumentFunction
            public final MacroInjector apply(VastScenario vastScenario) {
                return DiMacros.lambda$createRegistry$0(diConstructor, vastScenario);
            }
        };
    }

    static /* synthetic */ UriUtils lambda$createRegistry$2(DiConstructor diConstructor) {
        return new UriUtils();
    }

    static /* synthetic */ DateFormatUtils lambda$createRegistry$3(DiConstructor diConstructor) {
        return new DateFormatUtils();
    }

    static /* synthetic */ RandomUtils lambda$createRegistry$4(DiConstructor diConstructor) {
        return new RandomUtils();
    }

    static /* synthetic */ AdBreakInfoMacros lambda$createRegistry$5(DiConstructor diConstructor, VastScenario vastScenario) {
        return new AdBreakInfoMacros((DateFormatUtils) diConstructor.get(DateFormatUtils.class), vastScenario, vastScenario == null ? null : vastScenario.vastMediaFileScenario.vastScenarioCreativeData.universalAdId);
    }

    static /* synthetic */ AdBreakInfoMacrosProvider lambda$createRegistry$6(final DiConstructor diConstructor) {
        return new AdBreakInfoMacrosProvider() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.video.vast.tracking.macro.NullableArgumentFunction
            public final AdBreakInfoMacros apply(VastScenario vastScenario) {
                return DiMacros.lambda$createRegistry$5(diConstructor, vastScenario);
            }
        };
    }

    static /* synthetic */ CapabilitiesInfoMacro lambda$createRegistry$7(DiConstructor diConstructor) {
        return new CapabilitiesInfoMacro();
    }

    static /* synthetic */ ClientInfoMacros lambda$createRegistry$8(DiConstructor diConstructor) {
        return new ClientInfoMacros((DataCollector) diConstructor.get(DataCollector.class), (RequestInfoProvider) diConstructor.get(RequestInfoProvider.class), (SdkConfiguration) diConstructor.get(SdkConfiguration.class));
    }

    static /* synthetic */ GenericMacros lambda$createRegistry$9(DiConstructor diConstructor) {
        return new GenericMacros((DateFormatUtils) diConstructor.get(DateFormatUtils.class), (RandomUtils) diConstructor.get(RandomUtils.class));
    }

    static /* synthetic */ PlayerStateInfoMacros lambda$createRegistry$11(final DiConstructor diConstructor, VastScenario vastScenario) {
        return new PlayerStateInfoMacros(new PlayerStateInfoMacros.ScreenSizeProvider() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.core.util.fi.Supplier
            public final Size get() {
                return UIUtils.getDisplaySizeInDp((Context) diConstructor.get(Application.class));
            }
        }, (DateFormatUtils) diConstructor.get(DateFormatUtils.class), vastScenario == null ? null : vastScenario.vastMediaFileScenario.mediaFile.url, vastScenario != null ? vastScenario.adServingId : null);
    }

    static /* synthetic */ PlayerStateInfoMacrosProvider lambda$createRegistry$12(final DiConstructor diConstructor) {
        return new PlayerStateInfoMacrosProvider() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.video.vast.tracking.macro.NullableArgumentFunction
            public final PlayerStateInfoMacros apply(VastScenario vastScenario) {
                return DiMacros.lambda$createRegistry$11(diConstructor, vastScenario);
            }
        };
    }

    static /* synthetic */ PublisherInfoMacro lambda$createRegistry$13(DiConstructor diConstructor) {
        return new PublisherInfoMacro((DataCollector) diConstructor.get(DataCollector.class));
    }

    static /* synthetic */ RegulationInfoMacros lambda$createRegistry$14(DiConstructor diConstructor) {
        return new RegulationInfoMacros((SomaGdprDataSource) diConstructor.get(SomaGdprDataSource.class), (DataCollector) diConstructor.get(DataCollector.class), new RegulationInfoMacros.CoppaProvider() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.util.fi.Supplier
            public final Boolean get() {
                return Boolean.valueOf(SmaatoSdk.getCoppa());
            }
        });
    }

    static /* synthetic */ VerificationInfoMacros lambda$createRegistry$15(DiConstructor diConstructor) {
        return new VerificationInfoMacros();
    }

    static /* synthetic */ ErrorInfoMacros lambda$createRegistry$16(DiConstructor diConstructor) {
        return new ErrorInfoMacros();
    }

    private static DiRegistry provideClientInfoMacros() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda14
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((DiRegistry) obj).registerFactory(ClickInfoMacros.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda0
                    @Override // com.smaato.sdk.core.di.ClassFactory
                    /* JADX INFO: renamed from: get */
                    public final Object get2(DiConstructor diConstructor) {
                        return DiMacros.lambda$provideClientInfoMacros$19(diConstructor);
                    }
                });
            }
        });
    }

    static /* synthetic */ ClickInfoMacros lambda$provideClientInfoMacros$19(final DiConstructor diConstructor) {
        return new ClickInfoMacros(new ClickInfoMacros.PxToDpConverter() { // from class: com.smaato.sdk.video.vast.tracking.macro.DiMacros$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.util.fi.Function
            public final Integer apply(Float f) {
                return Integer.valueOf(UIUtils.pxToDp((Context) diConstructor.get(Application.class), f.floatValue()));
            }
        });
    }
}
