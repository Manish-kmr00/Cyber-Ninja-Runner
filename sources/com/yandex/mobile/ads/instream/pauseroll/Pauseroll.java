package com.yandex.mobile.ads.instream.pauseroll;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yandex.mobile.ads.instream.InstreamAdBreak;
import com.yandex.mobile.ads.instream.InstreamAdBreakEventListener;
import com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayer;
import com.yandex.mobile.ads.instream.player.ad.InstreamAdView;
import com.yandex.mobile.ads.video.playback.VideoAdPlaybackListener;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0007H&J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0014H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/yandex/mobile/ads/instream/pauseroll/Pauseroll;", "", "instreamAdBreak", "Lcom/yandex/mobile/ads/instream/InstreamAdBreak;", "getInstreamAdBreak", "()Lcom/yandex/mobile/ads/instream/InstreamAdBreak;", "invalidate", "", "pause", "play", "instreamAdView", "Lcom/yandex/mobile/ads/instream/player/ad/InstreamAdView;", "prepare", "instreamAdPlayer", "Lcom/yandex/mobile/ads/instream/player/ad/InstreamAdPlayer;", "resume", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yandex/mobile/ads/instream/InstreamAdBreakEventListener;", "setVideoAdPlaybackListener", "Lcom/yandex/mobile/ads/video/playback/VideoAdPlaybackListener;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface Pauseroll {
    InstreamAdBreak getInstreamAdBreak();

    void invalidate();

    void pause();

    void play(InstreamAdView instreamAdView);

    void prepare(InstreamAdPlayer instreamAdPlayer);

    void resume();

    void setListener(InstreamAdBreakEventListener listener);

    void setVideoAdPlaybackListener(VideoAdPlaybackListener listener);
}
