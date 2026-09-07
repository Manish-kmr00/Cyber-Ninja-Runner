package com.yandex.mobile.ads.instream;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yandex.mobile.ads.impl.a82;
import com.yandex.mobile.ads.impl.ct;
import com.yandex.mobile.ads.impl.dl1;
import com.yandex.mobile.ads.impl.dm2;
import com.yandex.mobile.ads.impl.in2;
import com.yandex.mobile.ads.impl.jt;
import com.yandex.mobile.ads.impl.kn2;
import com.yandex.mobile.ads.impl.wm2;
import com.yandex.mobile.ads.impl.xl2;
import com.yandex.mobile.ads.impl.zl2;
import com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayer;
import com.yandex.mobile.ads.instream.player.ad.InstreamAdView;
import com.yandex.mobile.ads.instream.player.content.VideoPlayer;
import com.yandex.mobile.ads.video.playback.VideoAdPlaybackListener;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\tJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/yandex/mobile/ads/instream/InstreamAdBinder;", "Lcom/yandex/mobile/ads/impl/dl1;", "Lcom/yandex/mobile/ads/impl/a82;", "Lcom/yandex/mobile/ads/instream/player/ad/InstreamAdView;", "instreamAdView", "", "bind", "(Lcom/yandex/mobile/ads/instream/player/ad/InstreamAdView;)V", "invalidateVideoPlayer", "()V", "invalidateAdPlayer", "Lcom/yandex/mobile/ads/instream/InstreamAdListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setInstreamAdListener", "(Lcom/yandex/mobile/ads/instream/InstreamAdListener;)V", "unbind", "prepareAd", "Lcom/yandex/mobile/ads/video/playback/VideoAdPlaybackListener;", "setVideoAdPlaybackListener", "(Lcom/yandex/mobile/ads/video/playback/VideoAdPlaybackListener;)V", "Landroid/content/Context;", "context", "Lcom/yandex/mobile/ads/instream/InstreamAd;", "instreamAd", "Lcom/yandex/mobile/ads/instream/player/ad/InstreamAdPlayer;", "instreamAdPlayer", "Lcom/yandex/mobile/ads/instream/player/content/VideoPlayer;", "videoPlayer", "<init>", "(Landroid/content/Context;Lcom/yandex/mobile/ads/instream/InstreamAd;Lcom/yandex/mobile/ads/instream/player/ad/InstreamAdPlayer;Lcom/yandex/mobile/ads/instream/player/content/VideoPlayer;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class InstreamAdBinder extends dl1 implements a82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dm2 f10870a;
    private final ct b;

    public InstreamAdBinder(Context context, InstreamAd instreamAd, InstreamAdPlayer instreamAdPlayer, VideoPlayer videoPlayer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instreamAd, "instreamAd");
        Intrinsics.checkNotNullParameter(instreamAdPlayer, "instreamAdPlayer");
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        wm2 wm2Var = new wm2(context);
        dm2 dm2Var = new dm2();
        this.f10870a = dm2Var;
        this.b = new ct(context, wm2Var, jt.a(instreamAd), new zl2(instreamAdPlayer, dm2Var), new kn2(videoPlayer));
    }

    public final void bind(InstreamAdView instreamAdView) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        this.b.a(instreamAdView, CollectionsKt.emptyList());
    }

    @Override // com.yandex.mobile.ads.impl.a82
    public void invalidateAdPlayer() {
        this.b.invalidateAdPlayer();
    }

    public final void invalidateVideoPlayer() {
        this.b.a();
    }

    public final void prepareAd() {
        this.b.b();
    }

    public final void setInstreamAdListener(InstreamAdListener listener) {
        this.b.a(listener != null ? new xl2(listener) : null);
    }

    public final void setVideoAdPlaybackListener(VideoAdPlaybackListener listener) {
        this.b.a(listener != null ? new in2(listener, this.f10870a) : null);
    }

    public final void unbind() {
        this.b.e();
    }
}
