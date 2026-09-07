package io.bidmachine.media3.exoplayer.source.ads;

import io.bidmachine.media3.common.AdPlaybackState;
import io.bidmachine.media3.common.AdViewProvider;
import io.bidmachine.media3.common.MediaItem;
import io.bidmachine.media3.common.Player;
import io.bidmachine.media3.datasource.DataSpec;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public interface AdsLoader {

    public interface EventListener {
        default void onAdClicked() {
        }

        default void onAdLoadError(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec) {
        }

        default void onAdPlaybackState(AdPlaybackState adPlaybackState) {
        }

        default void onAdTapped() {
        }
    }

    public interface Provider {
        AdsLoader getAdsLoader(MediaItem.AdsConfiguration adsConfiguration);
    }

    void handlePrepareComplete(AdsMediaSource adsMediaSource, int i, int i2);

    void handlePrepareError(AdsMediaSource adsMediaSource, int i, int i2, IOException iOException);

    void release();

    void setPlayer(Player player);

    void setSupportedContentTypes(int... iArr);

    void start(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, EventListener eventListener);

    void stop(AdsMediaSource adsMediaSource, EventListener eventListener);
}
