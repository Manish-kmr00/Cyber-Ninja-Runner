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

/* JADX INFO: loaded from: classes12.dex */
public class VastVideoPlayerCreator {
    private final VastVideoPlayerModelFactory vastVideoPlayerModelFactory;
    private final VastVideoPlayerPresenterFactory vastVideoPlayerPresenterFactory;
    private final VastVideoPlayerViewFactory vastVideoPlayerViewFactory;

    VastVideoPlayerCreator(VastVideoPlayerViewFactory vastVideoPlayerViewFactory, VastVideoPlayerModelFactory vastVideoPlayerModelFactory, VastVideoPlayerPresenterFactory vastVideoPlayerPresenterFactory) {
        this.vastVideoPlayerViewFactory = (VastVideoPlayerViewFactory) Objects.requireNonNull(vastVideoPlayerViewFactory);
        this.vastVideoPlayerModelFactory = (VastVideoPlayerModelFactory) Objects.requireNonNull(vastVideoPlayerModelFactory);
        this.vastVideoPlayerPresenterFactory = (VastVideoPlayerPresenterFactory) Objects.requireNonNull(vastVideoPlayerPresenterFactory);
    }

    public void createVastVideoPlayer(final Logger logger, VastScenario vastScenario, VastErrorTracker vastErrorTracker, final NonNullConsumer<Either<VastVideoPlayer, Exception>> nonNullConsumer, VideoSettings videoSettings, VideoAdViewFactory.VideoPlayerListener videoPlayerListener, Consumer<SmaatoSdkViewDelegate.VideoActivityLifecycleListener> consumer) {
        Objects.requireNonNull(logger);
        Objects.requireNonNull(vastScenario);
        Objects.requireNonNull(vastErrorTracker);
        Objects.requireNonNull(nonNullConsumer);
        this.vastVideoPlayerPresenterFactory.createVideoPlayerPresenter(logger, vastScenario, this.vastVideoPlayerModelFactory.createVastVideoPlayerModel(logger, vastScenario, vastErrorTracker, videoSettings.isVideoClickable, videoPlayerListener), vastErrorTracker, new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerCreator$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                this.f$0.m5730xe684534b(logger, nonNullConsumer, (Either) obj);
            }
        }, videoSettings, videoPlayerListener, consumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onVideoPlayerPresenterResult, reason: merged with bridge method [inline-methods] */
    public void m5730xe684534b(Logger logger, Either either, NonNullConsumer nonNullConsumer) {
        Exception exc = (Exception) either.right();
        if (exc != null) {
            nonNullConsumer.accept(Either.right(exc));
        } else {
            nonNullConsumer.accept(Either.left(new VastVideoPlayer((VastVideoPlayerPresenter) Objects.requireNonNull((VastVideoPlayerPresenter) either.left()), this.vastVideoPlayerViewFactory)));
        }
    }
}
