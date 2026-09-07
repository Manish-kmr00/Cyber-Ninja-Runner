package com.smaato.sdk.video.vast.vastplayer;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.linkhandler.LinkHandler;
import com.smaato.sdk.core.log.DiLogLayer;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.utils.AnimationHelper;
import com.smaato.sdk.video.utils.EventValidator;
import com.smaato.sdk.video.vast.browser.VastWebComponentSecurityPolicy;
import com.smaato.sdk.video.vast.tracking.VastBeaconTrackerCreator;
import com.smaato.sdk.video.vast.tracking.VastEventTrackerCreator;
import com.smaato.sdk.video.vast.tracking.macro.MacrosInjectorProviderFunction;
import com.smaato.sdk.video.vast.utils.VastScenarioResourceDataConverter;
import com.smaato.sdk.video.vast.vastplayer.system.SystemMediaPlayerActionValidatorFactory;
import com.smaato.sdk.video.vast.vastplayer.system.SystemMediaPlayerCreator;
import com.smaato.sdk.video.vast.vastplayer.system.SystemMediaPlayerStateMachineFactory;
import com.smaato.sdk.video.vast.vastplayer.system.SystemMediaPlayerTransitionValidatorFactory;
import com.smaato.sdk.video.vast.widget.SurfaceViewVideoPlayerViewFactory;
import com.smaato.sdk.video.vast.widget.VideoPlayerViewFactory;
import com.smaato.sdk.video.vast.widget.companion.CompanionErrorCodeStrategy;
import com.smaato.sdk.video.vast.widget.companion.CompanionPresenterFactory;
import com.smaato.sdk.video.vast.widget.icon.IconErrorCodeStrategy;
import com.smaato.sdk.video.vast.widget.icon.IconPresenterFactory;

/* JADX INFO: loaded from: classes12.dex */
public final class DiPlayerLayer {
    public static DiRegistry createRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiPlayerLayer.lambda$createRegistry$0((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$createRegistry$0(DiRegistry diRegistry) {
        diRegistry.addFrom(buildVastTrackersCreatorRegistry());
        diRegistry.addFrom(buildVastVideoPlayerCreatorRegistry());
        diRegistry.addFrom(buildSystemMediaPlayerRegistry());
    }

    private static DiRegistry buildVastTrackersCreatorRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda18
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiPlayerLayer.lambda$buildVastTrackersCreatorRegistry$3((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$buildVastTrackersCreatorRegistry$3(DiRegistry diRegistry) {
        diRegistry.registerFactory(VastEventTrackerCreator.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildVastTrackersCreatorRegistry$1(diConstructor);
            }
        });
        diRegistry.registerFactory(VastBeaconTrackerCreator.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildVastTrackersCreatorRegistry$2(diConstructor);
            }
        });
    }

    static /* synthetic */ VastEventTrackerCreator lambda$buildVastTrackersCreatorRegistry$1(DiConstructor diConstructor) {
        return new VastEventTrackerCreator(DiLogLayer.getLoggerFrom(diConstructor), (SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), (MacrosInjectorProviderFunction) diConstructor.get(MacrosInjectorProviderFunction.class));
    }

    static /* synthetic */ VastBeaconTrackerCreator lambda$buildVastTrackersCreatorRegistry$2(DiConstructor diConstructor) {
        return new VastBeaconTrackerCreator(DiLogLayer.getLoggerFrom(diConstructor), (SimpleHttpClient) diConstructor.get(SimpleHttpClient.class), (MacrosInjectorProviderFunction) diConstructor.get(MacrosInjectorProviderFunction.class));
    }

    private static DiRegistry buildVastVideoPlayerCreatorRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiPlayerLayer.lambda$buildVastVideoPlayerCreatorRegistry$13((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$buildVastVideoPlayerCreatorRegistry$13(DiRegistry diRegistry) {
        diRegistry.registerFactory(VastVideoPlayerCreator.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildVastVideoPlayerCreatorRegistry$4(diConstructor);
            }
        });
        diRegistry.registerFactory(VastVideoPlayerModelFactory.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildVastVideoPlayerCreatorRegistry$5(diConstructor);
            }
        });
        diRegistry.registerFactory(VastVideoPlayerViewFactory.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildVastVideoPlayerCreatorRegistry$6(diConstructor);
            }
        });
        diRegistry.registerFactory(VideoPlayerViewFactory.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildVastVideoPlayerCreatorRegistry$7(diConstructor);
            }
        });
        diRegistry.registerFactory(VastVideoPlayerPresenterFactory.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildVastVideoPlayerCreatorRegistry$8(diConstructor);
            }
        });
        diRegistry.registerFactory(VastVideoPlayerStateMachineFactory.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildVastVideoPlayerCreatorRegistry$9(diConstructor);
            }
        });
        diRegistry.registerFactory(VideoPlayerPresenterFactory.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildVastVideoPlayerCreatorRegistry$10(diConstructor);
            }
        });
        diRegistry.registerFactory(VideoPlayerPreparer.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildVastVideoPlayerCreatorRegistry$11(diConstructor);
            }
        });
        diRegistry.registerFactory(VastScenarioResourceDataConverter.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda14
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildVastVideoPlayerCreatorRegistry$12(diConstructor);
            }
        });
        diRegistry.addFrom(buildRepeatableActionRegistry());
        diRegistry.addFrom(buildIconPresenterFactoryRegistry());
        diRegistry.addFrom(buildCompanionPresenterFactoryRegistry());
    }

    static /* synthetic */ VastVideoPlayerCreator lambda$buildVastVideoPlayerCreatorRegistry$4(DiConstructor diConstructor) {
        return new VastVideoPlayerCreator((VastVideoPlayerViewFactory) diConstructor.get(VastVideoPlayerViewFactory.class), (VastVideoPlayerModelFactory) diConstructor.get(VastVideoPlayerModelFactory.class), (VastVideoPlayerPresenterFactory) diConstructor.get(VastVideoPlayerPresenterFactory.class));
    }

    static /* synthetic */ VastVideoPlayerModelFactory lambda$buildVastVideoPlayerCreatorRegistry$5(DiConstructor diConstructor) {
        return new VastVideoPlayerModelFactory((LinkHandler) diConstructor.get(LinkHandler.class), (VastEventTrackerCreator) diConstructor.get(VastEventTrackerCreator.class), (VastBeaconTrackerCreator) diConstructor.get(VastBeaconTrackerCreator.class), true);
    }

    static /* synthetic */ VastVideoPlayerViewFactory lambda$buildVastVideoPlayerCreatorRegistry$6(DiConstructor diConstructor) {
        return new VastVideoPlayerViewFactory();
    }

    static /* synthetic */ VideoPlayerViewFactory lambda$buildVastVideoPlayerCreatorRegistry$7(DiConstructor diConstructor) {
        return new SurfaceViewVideoPlayerViewFactory();
    }

    static /* synthetic */ VastVideoPlayerPresenterFactory lambda$buildVastVideoPlayerCreatorRegistry$8(DiConstructor diConstructor) {
        return new VastVideoPlayerPresenterFactory((VideoPlayerPresenterFactory) diConstructor.get(VideoPlayerPresenterFactory.class), (CompanionPresenterFactory) diConstructor.get(CompanionPresenterFactory.class), (IconPresenterFactory) diConstructor.get(IconPresenterFactory.class), (VastVideoPlayerStateMachineFactory) diConstructor.get(VastVideoPlayerStateMachineFactory.class));
    }

    static /* synthetic */ VastVideoPlayerStateMachineFactory lambda$buildVastVideoPlayerCreatorRegistry$9(DiConstructor diConstructor) {
        return new VastVideoPlayerStateMachineFactory(VastPlayerState.SHOW_VIDEO);
    }

    static /* synthetic */ VideoPlayerPresenterFactory lambda$buildVastVideoPlayerCreatorRegistry$10(DiConstructor diConstructor) {
        return new VideoPlayerPresenterFactory((VideoPlayerPreparer) diConstructor.get(VideoPlayerPreparer.class), (RepeatableActionFactory) diConstructor.get(RepeatableActionFactory.class), true);
    }

    static /* synthetic */ VideoPlayerPreparer lambda$buildVastVideoPlayerCreatorRegistry$11(DiConstructor diConstructor) {
        return new VideoPlayerPreparer((VideoPlayerCreator) diConstructor.get(VideoPlayerCreator.class));
    }

    static /* synthetic */ VastScenarioResourceDataConverter lambda$buildVastVideoPlayerCreatorRegistry$12(DiConstructor diConstructor) {
        return new VastScenarioResourceDataConverter();
    }

    private static DiRegistry buildCompanionPresenterFactoryRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda23
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiPlayerLayer.lambda$buildCompanionPresenterFactoryRegistry$16((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$buildCompanionPresenterFactoryRegistry$16(DiRegistry diRegistry) {
        diRegistry.registerFactory(CompanionErrorCodeStrategy.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda21
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildCompanionPresenterFactoryRegistry$14(diConstructor);
            }
        });
        diRegistry.registerFactory(CompanionPresenterFactory.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda22
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildCompanionPresenterFactoryRegistry$15(diConstructor);
            }
        });
    }

    static /* synthetic */ CompanionErrorCodeStrategy lambda$buildCompanionPresenterFactoryRegistry$14(DiConstructor diConstructor) {
        return new CompanionErrorCodeStrategy();
    }

    static /* synthetic */ CompanionPresenterFactory lambda$buildCompanionPresenterFactoryRegistry$15(DiConstructor diConstructor) {
        return new CompanionPresenterFactory((VastScenarioResourceDataConverter) diConstructor.get(VastScenarioResourceDataConverter.class), (VastWebComponentSecurityPolicy) diConstructor.get(VastWebComponentSecurityPolicy.class), (CompanionErrorCodeStrategy) diConstructor.get(CompanionErrorCodeStrategy.class));
    }

    private static DiRegistry buildIconPresenterFactoryRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda17
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiPlayerLayer.lambda$buildIconPresenterFactoryRegistry$20((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$buildIconPresenterFactoryRegistry$20(DiRegistry diRegistry) {
        diRegistry.registerFactory(IconErrorCodeStrategy.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildIconPresenterFactoryRegistry$17(diConstructor);
            }
        });
        diRegistry.registerFactory(IconPresenterFactory.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda19
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildIconPresenterFactoryRegistry$18(diConstructor);
            }
        });
        diRegistry.registerFactory("ICON_ANIMATION_HELPER", AnimationHelper.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda20
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildIconPresenterFactoryRegistry$19(diConstructor);
            }
        });
    }

    static /* synthetic */ IconErrorCodeStrategy lambda$buildIconPresenterFactoryRegistry$17(DiConstructor diConstructor) {
        return new IconErrorCodeStrategy();
    }

    static /* synthetic */ IconPresenterFactory lambda$buildIconPresenterFactoryRegistry$18(DiConstructor diConstructor) {
        return new IconPresenterFactory((VastScenarioResourceDataConverter) diConstructor.get(VastScenarioResourceDataConverter.class), (VastWebComponentSecurityPolicy) diConstructor.get(VastWebComponentSecurityPolicy.class), (AnimationHelper) diConstructor.get("ICON_ANIMATION_HELPER", AnimationHelper.class), (IconErrorCodeStrategy) diConstructor.get(IconErrorCodeStrategy.class));
    }

    static /* synthetic */ AnimationHelper lambda$buildIconPresenterFactoryRegistry$19(DiConstructor diConstructor) {
        return new AnimationHelper(300L);
    }

    private static DiRegistry buildRepeatableActionRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((DiRegistry) obj).registerFactory(RepeatableActionFactory.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda3
                    @Override // com.smaato.sdk.core.di.ClassFactory
                    /* JADX INFO: renamed from: get */
                    public final Object get2(DiConstructor diConstructor) {
                        return DiPlayerLayer.lambda$buildRepeatableActionRegistry$21(diConstructor);
                    }
                });
            }
        });
    }

    static /* synthetic */ RepeatableActionFactory lambda$buildRepeatableActionRegistry$21(DiConstructor diConstructor) {
        return new RepeatableActionFactory(Threads.newUiHandler());
    }

    private static DiRegistry buildSystemMediaPlayerRegistry() {
        final String str = "VideoModuleInterfaceSystemMediaPlayerActionValidator";
        final String str2 = "VideoModuleInterfaceSystemMediaPlayerTransitionValidator";
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiPlayerLayer.lambda$buildSystemMediaPlayerRegistry$26(str, str2, (DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$buildSystemMediaPlayerRegistry$26(final String str, final String str2, DiRegistry diRegistry) {
        diRegistry.registerFactory(MediaPlayer.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda24
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildSystemMediaPlayerRegistry$23(diConstructor);
            }
        });
        diRegistry.registerFactory(VideoPlayerCreator.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda25
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildSystemMediaPlayerRegistry$24(str, str2, diConstructor);
            }
        });
        diRegistry.registerFactory(SystemMediaPlayerStateMachineFactory.class, new ClassFactory() { // from class: com.smaato.sdk.video.vast.vastplayer.DiPlayerLayer$$ExternalSyntheticLambda26
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiPlayerLayer.lambda$buildSystemMediaPlayerRegistry$25(diConstructor);
            }
        });
        diRegistry.registerFactory(str, EventValidator.class, new SystemMediaPlayerActionValidatorFactory());
        diRegistry.registerFactory(str2, EventValidator.class, new SystemMediaPlayerTransitionValidatorFactory());
    }

    static /* synthetic */ MediaPlayer lambda$buildSystemMediaPlayerRegistry$23(DiConstructor diConstructor) {
        return new MediaPlayer();
    }

    static /* synthetic */ VideoPlayerCreator lambda$buildSystemMediaPlayerRegistry$24(String str, String str2, DiConstructor diConstructor) {
        return new SystemMediaPlayerCreator((Context) diConstructor.get(Application.class), (SystemMediaPlayerStateMachineFactory) diConstructor.get(SystemMediaPlayerStateMachineFactory.class), (EventValidator) diConstructor.get(str, EventValidator.class), (EventValidator) diConstructor.get(str2, EventValidator.class), (MediaPlayer) diConstructor.get(MediaPlayer.class), (AudioManager) ((Application) diConstructor.get(Application.class)).getSystemService("audio"));
    }

    static /* synthetic */ SystemMediaPlayerStateMachineFactory lambda$buildSystemMediaPlayerRegistry$25(DiConstructor diConstructor) {
        return new SystemMediaPlayerStateMachineFactory(MediaPlayerState.IDLE);
    }
}
