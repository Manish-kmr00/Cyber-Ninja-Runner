package com.smaato.sdk.video.vast.vastplayer;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate;
import com.smaato.sdk.core.util.Either;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.ad.VideoAdViewFactory;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.VastScenario;
import com.smaato.sdk.video.vast.tracking.VastErrorTracker;
import com.smaato.sdk.video.vast.widget.companion.CompanionPresenterFactory;
import com.smaato.sdk.video.vast.widget.icon.IconPresenterFactory;

/* JADX INFO: loaded from: classes12.dex */
class VastVideoPlayerPresenterFactory {
    private final CompanionPresenterFactory companionPresenterFactory;
    private final IconPresenterFactory iconPresenterFactory;
    private final VastVideoPlayerStateMachineFactory vastVideoPlayerStateMachineFactory;
    private final VideoPlayerPresenterFactory videoPlayerPresenterFactory;

    VastVideoPlayerPresenterFactory(VideoPlayerPresenterFactory videoPlayerPresenterFactory, CompanionPresenterFactory companionPresenterFactory, IconPresenterFactory iconPresenterFactory, VastVideoPlayerStateMachineFactory vastVideoPlayerStateMachineFactory) {
        this.videoPlayerPresenterFactory = (VideoPlayerPresenterFactory) Objects.requireNonNull(videoPlayerPresenterFactory);
        this.companionPresenterFactory = (CompanionPresenterFactory) Objects.requireNonNull(companionPresenterFactory);
        this.iconPresenterFactory = (IconPresenterFactory) Objects.requireNonNull(iconPresenterFactory);
        this.vastVideoPlayerStateMachineFactory = (VastVideoPlayerStateMachineFactory) Objects.requireNonNull(vastVideoPlayerStateMachineFactory);
    }

    void createVideoPlayerPresenter(final Logger logger, final VastScenario vastScenario, final VastVideoPlayerModel vastVideoPlayerModel, VastErrorTracker vastErrorTracker, final NonNullConsumer<Either<VastVideoPlayerPresenter, Exception>> nonNullConsumer, VideoSettings videoSettings, VideoAdViewFactory.VideoPlayerListener videoPlayerListener, Consumer<SmaatoSdkViewDelegate.VideoActivityLifecycleListener> consumer) {
        Objects.requireNonNull(logger);
        Objects.requireNonNull(vastVideoPlayerModel);
        Objects.requireNonNull(nonNullConsumer);
        this.videoPlayerPresenterFactory.createVideoPlayerPresenter(logger, vastScenario.vastMediaFileScenario, vastErrorTracker, new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenterFactory$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                this.f$0.m5738x6708c7f5(logger, vastScenario, vastVideoPlayerModel, nonNullConsumer, (Either) obj);
            }
        }, videoSettings, videoPlayerListener, consumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onVideoPlayerPresenterResult, reason: merged with bridge method [inline-methods] */
    public void m5738x6708c7f5(Logger logger, VastScenario vastScenario, VastVideoPlayerModel vastVideoPlayerModel, Either either, NonNullConsumer nonNullConsumer) {
        Exception exc = (Exception) either.right();
        if (exc != null) {
            nonNullConsumer.accept(Either.right(exc));
            return;
        }
        VideoPlayerPresenter videoPlayerPresenter = (VideoPlayerPresenter) Objects.requireNonNull((VideoPlayerPresenter) either.left());
        nonNullConsumer.accept(Either.left(new VastVideoPlayerPresenter(logger, vastVideoPlayerModel, this.companionPresenterFactory.create(logger, vastScenario), this.iconPresenterFactory.create(logger, vastScenario.vastMediaFileScenario), videoPlayerPresenter, this.vastVideoPlayerStateMachineFactory.create(vastScenario))));
    }
}
