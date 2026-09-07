package com.smaato.sdk.video.vast.vastplayer;

import android.content.Context;
import android.view.View;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.model.Verification;
import com.smaato.sdk.video.vast.widget.VastVideoAdPlayerView;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class VastVideoPlayer {
    private final VastVideoPlayerPresenter vastVideoPlayerPresenter;
    private final VastVideoPlayerViewFactory vastVideoPlayerViewFactory;

    public interface EventListener {
        void onAdClick();

        void onAdError();

        void onClose();

        void onCompanionShown();

        void onComplete();

        void onFirstQuartile();

        void onMidPoint();

        void onMute();

        void onPaused();

        void onResumed();

        void onSkipped();

        void onStart(float f, float f2);

        void onThirdQuartile();

        void onUnmute();

        void onVideoImpression();
    }

    VastVideoPlayer(VastVideoPlayerPresenter vastVideoPlayerPresenter, VastVideoPlayerViewFactory vastVideoPlayerViewFactory) {
        this.vastVideoPlayerPresenter = (VastVideoPlayerPresenter) Objects.requireNonNull(vastVideoPlayerPresenter);
        this.vastVideoPlayerViewFactory = (VastVideoPlayerViewFactory) Objects.requireNonNull(vastVideoPlayerViewFactory);
    }

    public VastVideoAdPlayerView getNewVideoPlayerView(Context context, List<Verification> list) {
        Objects.requireNonNull(context);
        final VastVideoAdPlayerView vastVideoPlayerView = this.vastVideoPlayerViewFactory.getVastVideoPlayerView(context, list);
        vastVideoPlayerView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayer.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                VastVideoPlayer.this.vastVideoPlayerPresenter.attachView(vastVideoPlayerView);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                view.removeOnAttachStateChangeListener(this);
                VastVideoPlayer.this.vastVideoPlayerPresenter.detachView();
            }
        });
        return vastVideoPlayerView;
    }

    public void setEventListener(EventListener eventListener) {
        this.vastVideoPlayerPresenter.getVideoPlayerModel().setEventListener(eventListener);
    }

    public void loaded() {
        this.vastVideoPlayerPresenter.loaded();
    }

    public void pause() {
        this.vastVideoPlayerPresenter.pause();
    }

    public void resume() {
        this.vastVideoPlayerPresenter.resume();
    }

    public void onCloseClicked() {
        this.vastVideoPlayerPresenter.onCloseClicked();
    }
}
