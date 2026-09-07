package com.yandex.mobile.ads.instream.exoplayer;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yandex.div.core.timer.TimerController;
import com.yandex.mobile.ads.impl.an0;
import com.yandex.mobile.ads.impl.cb;
import com.yandex.mobile.ads.impl.cm2;
import com.yandex.mobile.ads.impl.dm2;
import com.yandex.mobile.ads.impl.gl1;
import com.yandex.mobile.ads.impl.in2;
import com.yandex.mobile.ads.impl.wm2;
import com.yandex.mobile.ads.instream.InstreamAdRequestConfiguration;
import com.yandex.mobile.ads.video.playback.VideoAdPlaybackListener;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "This AdsLoader version is deprecated, use YandexAdsLoader from com.yandex.mobile.ads.instream.media3 package", replaceWith = @ReplaceWith(expression = "YandexMedia3AdsLoader", imports = {"com.yandex.mobile.ads.instream.media3.YandexMedia3AdsLoader"}))
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0017\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u00020\u00042\n\u0010\u0013\u001a\u00020\u0011\"\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010 \u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010#J'\u0010&\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0012H\u0016¢\u0006\u0004\b&\u0010'J/\u0010*\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+¨\u00063"}, d2 = {"Lcom/yandex/mobile/ads/instream/exoplayer/YandexAdsLoader;", "Lcom/yandex/mobile/ads/impl/gl1;", "Landroid/view/ViewGroup;", "adViewGroup", "", "requestAds", "(Landroid/view/ViewGroup;)V", "Lcom/yandex/mobile/ads/video/playback/VideoAdPlaybackListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setVideoAdPlaybackListener", "(Lcom/yandex/mobile/ads/video/playback/VideoAdPlaybackListener;)V", "Lcom/google/android/exoplayer2/Player;", "player", "setPlayer", "(Lcom/google/android/exoplayer2/Player;)V", "release", "()V", "", "", "contentTypes", "setSupportedContentTypes", "([I)V", "Lcom/google/android/exoplayer2/source/ads/AdsMediaSource;", "adsMediaSource", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "adTagDataSpec", "", "adPlaybackId", "Lcom/google/android/exoplayer2/ui/AdViewProvider;", "adViewProvider", "Lcom/google/android/exoplayer2/source/ads/AdsLoader$EventListener;", "eventListener", "start", "(Lcom/google/android/exoplayer2/source/ads/AdsMediaSource;Lcom/google/android/exoplayer2/upstream/DataSpec;Ljava/lang/Object;Lcom/google/android/exoplayer2/ui/AdViewProvider;Lcom/google/android/exoplayer2/source/ads/AdsLoader$EventListener;)V", TimerController.STOP_COMMAND, "(Lcom/google/android/exoplayer2/source/ads/AdsMediaSource;Lcom/google/android/exoplayer2/source/ads/AdsLoader$EventListener;)V", "adGroupIndex", "adIndexInAdGroup", "handlePrepareComplete", "(Lcom/google/android/exoplayer2/source/ads/AdsMediaSource;II)V", "Ljava/io/IOException;", "exception", "handlePrepareError", "(Lcom/google/android/exoplayer2/source/ads/AdsMediaSource;IILjava/io/IOException;)V", "Landroid/content/Context;", "context", "Lcom/yandex/mobile/ads/instream/InstreamAdRequestConfiguration;", "requestConfiguration", "<init>", "(Landroid/content/Context;Lcom/yandex/mobile/ads/instream/InstreamAdRequestConfiguration;)V", "a", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class YandexAdsLoader extends gl1 {
    public static final String AD_TAG_URI = "yandex://ad_tag";
    private final an0 b;
    private final dm2 c;

    public YandexAdsLoader(Context context, InstreamAdRequestConfiguration requestConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        this.b = new cb(context, new wm2(context), new cm2(requestConfiguration)).a();
        this.c = new dm2();
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void handlePrepareComplete(AdsMediaSource adsMediaSource, int adGroupIndex, int adIndexInAdGroup) {
        Intrinsics.checkNotNullParameter(adsMediaSource, "adsMediaSource");
        this.b.a(adGroupIndex, adIndexInAdGroup);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void handlePrepareError(AdsMediaSource adsMediaSource, int adGroupIndex, int adIndexInAdGroup, IOException exception) {
        Intrinsics.checkNotNullParameter(adsMediaSource, "adsMediaSource");
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.b.a(adGroupIndex, adIndexInAdGroup, exception);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void release() {
        this.b.a();
    }

    public final void requestAds(ViewGroup adViewGroup) {
        this.b.a(adViewGroup, CollectionsKt.emptyList());
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void setPlayer(Player player) {
        this.b.a(player);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void setSupportedContentTypes(int... contentTypes) {
        Intrinsics.checkNotNullParameter(contentTypes, "contentTypes");
    }

    public final void setVideoAdPlaybackListener(VideoAdPlaybackListener listener) {
        this.b.a(listener != null ? new in2(listener, this.c) : null);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void start(AdsMediaSource adsMediaSource, DataSpec adTagDataSpec, Object adPlaybackId, AdViewProvider adViewProvider, AdsLoader.EventListener eventListener) {
        Intrinsics.checkNotNullParameter(adsMediaSource, "adsMediaSource");
        Intrinsics.checkNotNullParameter(adTagDataSpec, "adTagDataSpec");
        Intrinsics.checkNotNullParameter(adPlaybackId, "adPlaybackId");
        Intrinsics.checkNotNullParameter(adViewProvider, "adViewProvider");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.b.a(eventListener, adViewProvider, adPlaybackId);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader
    public void stop(AdsMediaSource adsMediaSource, AdsLoader.EventListener eventListener) {
        Intrinsics.checkNotNullParameter(adsMediaSource, "adsMediaSource");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.b.b();
    }
}
