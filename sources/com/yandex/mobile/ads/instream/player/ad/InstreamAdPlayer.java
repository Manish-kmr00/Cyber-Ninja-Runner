package com.yandex.mobile.ads.instream.player.ad;

import com.yandex.mobile.ads.video.playback.model.VideoAd;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\bH&J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0018"}, d2 = {"Lcom/yandex/mobile/ads/instream/player/ad/InstreamAdPlayer;", "", "getAdDuration", "", "videoAd", "Lcom/yandex/mobile/ads/video/playback/model/VideoAd;", "getAdPosition", "getVolume", "", "isPlayingAd", "", "pauseAd", "", "playAd", "prepareAd", "releaseAd", "resumeAd", "setInstreamAdPlayerListener", "instreamAdPlayerListener", "Lcom/yandex/mobile/ads/instream/player/ad/InstreamAdPlayerListener;", "setVolume", "volume", "skipAd", "stopAd", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface InstreamAdPlayer {
    long getAdDuration(VideoAd videoAd);

    long getAdPosition(VideoAd videoAd);

    float getVolume(VideoAd videoAd);

    boolean isPlayingAd(VideoAd videoAd);

    void pauseAd(VideoAd videoAd);

    void playAd(VideoAd videoAd);

    void prepareAd(VideoAd videoAd);

    void releaseAd(VideoAd videoAd);

    void resumeAd(VideoAd videoAd);

    void setInstreamAdPlayerListener(InstreamAdPlayerListener instreamAdPlayerListener);

    void setVolume(VideoAd videoAd, float volume);

    void skipAd(VideoAd videoAd);

    void stopAd(VideoAd videoAd);
}
