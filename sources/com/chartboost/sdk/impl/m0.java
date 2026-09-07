package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.yandex.div.core.timer.TimerController;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005Bc\u0012\u0006\u0010L\u001a\u00020K\u0012\b\b\u0002\u0010N\u001a\u00020M\u0012\u0006\u00109\u001a\u000207\u0012\u0006\u0010<\u001a\u00020:\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010=\u0012\u0006\u0010P\u001a\u00020O\u0012$\u0010S\u001a \u0012\u0006\u0012\u0004\u0018\u00010=\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020D0Qj\u0002`R¢\u0006\u0004\bT\u0010UJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\u000f\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ\u000f\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u000fJ\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\f\u0010 J\u0017\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J/\u0010&\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b(\u0010$J\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u001dH\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\u000fJ\u0015\u00101\u001a\u0004\u0018\u000100*\u00020\tH\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u000bH\u0002¢\u0006\u0004\b3\u0010\u000fJ\u000f\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0004\b4\u0010\u000fJ\u000f\u00105\u001a\u00020\u000bH\u0002¢\u0006\u0004\b5\u0010\u000fJ\u000f\u00106\u001a\u00020\u000bH\u0002¢\u0006\u0004\b6\u0010\u000fJ#\u00101\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001dH\u0002¢\u0006\u0004\b1\u0010 R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010;R\u0016\u0010?\u001a\u0004\u0018\u00010=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010>R\u001b\u0010C\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010A\u001a\u0004\b1\u0010BR\u001b\u0010G\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010A\u001a\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010HR\u0016\u0010J\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010H¨\u0006V"}, d2 = {"Lcom/chartboost/sdk/impl/m0;", "Lcom/chartboost/sdk/impl/p0;", "Landroid/view/SurfaceHolder$Callback;", "Lcom/google/android/exoplayer2/Player$Listener;", "Lcom/chartboost/sdk/impl/nb$b;", "Lcom/chartboost/sdk/impl/l1;", "", "d", "()J", "Lcom/chartboost/sdk/impl/gb;", "asset", "", "a", "(Lcom/chartboost/sdk/impl/gb;)V", "play", "()V", "", "isPlaying", "onIsPlayingChanged", "(Z)V", "pause", TimerController.STOP_COMMAND, InneractiveMediationDefs.GENDER_FEMALE, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "h", "()Z", "", "g", "()F", "", "width", "height", "(II)V", "Landroid/view/SurfaceHolder;", "holder", "surfaceCreated", "(Landroid/view/SurfaceHolder;)V", "format", "surfaceChanged", "(Landroid/view/SurfaceHolder;III)V", "surfaceDestroyed", "playbackState", "onPlaybackStateChanged", "(I)V", "Lcom/google/android/exoplayer2/PlaybackException;", "error", "onPlayerError", "(Lcom/google/android/exoplayer2/PlaybackException;)V", "Lcom/google/android/exoplayer2/MediaItem;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/chartboost/sdk/impl/gb;)Lcom/google/android/exoplayer2/MediaItem;", CampaignEx.JSON_KEY_AD_K, "l", "j", "i", "Lcom/chartboost/sdk/impl/y4;", "Lcom/chartboost/sdk/impl/y4;", "exoPlayerMediaItemFactory", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceView;", "surfaceView", "Lcom/chartboost/sdk/impl/q0;", "Lcom/chartboost/sdk/impl/q0;", "callback", "Lcom/google/android/exoplayer2/ExoPlayer;", "Lkotlin/Lazy;", "()Lcom/google/android/exoplayer2/ExoPlayer;", "exoPlayer", "Lcom/chartboost/sdk/impl/nb;", "e", "()Lcom/chartboost/sdk/impl/nb;", "videoProgressScheduler", "Z", "wasMediaStartedForTheFirstTime", "isComingFromBackground", "Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/v4;", "exoPlayerFactory", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lkotlin/Function3;", "Lcom/chartboost/sdk/internal/video/player/scheduler/VideoProgressSchedulerFactory;", "videoProgressFactory", "<init>", "(Landroid/content/Context;Lcom/chartboost/sdk/impl/v4;Lcom/chartboost/sdk/impl/y4;Landroid/view/SurfaceView;Lcom/chartboost/sdk/impl/q0;Lcom/chartboost/sdk/impl/sa;Lkotlin/jvm/functions/Function3;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class m0 implements p0, SurfaceHolder.Callback, Player.Listener, nb.b, l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final y4 exoPlayerMediaItemFactory;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final SurfaceView surfaceView;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final q0 callback;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy exoPlayer;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Lazy videoProgressScheduler;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public boolean wasMediaStartedForTheFirstTime;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public boolean isComingFromBackground;

    public m0(Context context, v4 exoPlayerFactory, y4 exoPlayerMediaItemFactory, SurfaceView surfaceView, q0 q0Var, sa uiPoster, Function3<? super q0, ? super nb.b, ? super sa, ? extends nb> videoProgressFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(exoPlayerFactory, "exoPlayerFactory");
        Intrinsics.checkNotNullParameter(exoPlayerMediaItemFactory, "exoPlayerMediaItemFactory");
        Intrinsics.checkNotNullParameter(surfaceView, "surfaceView");
        Intrinsics.checkNotNullParameter(uiPoster, "uiPoster");
        Intrinsics.checkNotNullParameter(videoProgressFactory, "videoProgressFactory");
        this.exoPlayerMediaItemFactory = exoPlayerMediaItemFactory;
        this.surfaceView = surfaceView;
        this.callback = q0Var;
        this.exoPlayer = LazyKt.lazy(new a(exoPlayerFactory, this));
        this.videoProgressScheduler = LazyKt.lazy(new b(videoProgressFactory, this, uiPoster));
    }

    @Override // com.chartboost.sdk.impl.l9
    public void a(int width, int height) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayerError(PlaybackException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        b7.b("ExoPlayer error", error);
        stop();
        q0 q0Var = this.callback;
        if (q0Var != null) {
            String message = error.getMessage();
            if (message == null) {
                message = "No error message from ExoPlayer";
            }
            q0Var.a(message);
        }
    }

    @Override // com.chartboost.sdk.impl.p0
    public void play() {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/m0;->play()V");
        CreativeInfoManager.onVideoStart(com.safedk.android.utils.h.c, this, "chartboost exo-player");
        safedk_m0_play_b94a1e96f511877fb46f5e99a75a96fe();
    }

    @Override // com.chartboost.sdk.impl.p0
    public void stop() {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/m0;->stop()V");
        CreativeInfoManager.onVideoCompleted(com.safedk.android.utils.h.c, "chartboost exo-player");
        safedk_m0_stop_b9623f52dd614cc25ff5cb56ae2a27df();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        b7.a("surfaceCreated()", (Throwable) null, 2, (Object) null);
        if (this.isComingFromBackground) {
            play();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        b7.a("surfaceDestroyed()", (Throwable) null, 2, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0037  */
    @Override // com.chartboost.sdk.impl.p0
    public void a(gb asset) {
        Unit unit;
        Intrinsics.checkNotNullParameter(asset, "asset");
        b7.a("asset() - asset: " + asset, (Throwable) null, 2, (Object) null);
        MediaItem mediaItemB = b(asset);
        if (mediaItemB != null) {
            ExoPlayer exoPlayerB = b();
            exoPlayerB.addMediaItem(mediaItemB);
            exoPlayerB.prepare();
            SurfaceHolder holder = this.surfaceView.getHolder();
            if (holder != null) {
                holder.addCallback(this);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            q0 q0Var = this.callback;
            if (q0Var != null) {
                q0Var.a("Error retrieving media item");
            }
            b7.b("Error retrieving media item", null, 2, null);
        }
        this.wasMediaStartedForTheFirstTime = false;
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/google/android/exoplayer2/ExoPlayer;", "a", "()Lcom/google/android/exoplayer2/ExoPlayer;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<ExoPlayer> {
        public final /* synthetic */ v4 b;
        public final /* synthetic */ m0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v4 v4Var, m0 m0Var) {
            super(0);
            this.b = v4Var;
            this.c = m0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ExoPlayer invoke() {
            ExoPlayer exoPlayerA = this.b.a();
            exoPlayerA.addListener(this.c);
            return exoPlayerA;
        }
    }

    public final ExoPlayer b() {
        return (ExoPlayer) this.exoPlayer.getValue();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/nb;", "a", "()Lcom/chartboost/sdk/impl/nb;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<nb> {
        public final /* synthetic */ Function3<q0, nb.b, sa, nb> b;
        public final /* synthetic */ m0 c;
        public final /* synthetic */ sa d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Function3<? super q0, ? super nb.b, ? super sa, ? extends nb> function3, m0 m0Var, sa saVar) {
            super(0);
            this.b = function3;
            this.c = m0Var;
            this.d = saVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final nb invoke() {
            return this.b.invoke(this.c.callback, this.c, this.d);
        }
    }

    public final nb e() {
        return (nb) this.videoProgressScheduler.getValue();
    }

    @Override // com.chartboost.sdk.impl.nb.b
    public long d() {
        return b().getCurrentPosition();
    }

    public /* synthetic */ m0(Context context, v4 v4Var, y4 y4Var, SurfaceView surfaceView, q0 q0Var, sa saVar, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new v4(context, null, null, null, 14, null) : v4Var, y4Var, surfaceView, (i & 16) != 0 ? null : q0Var, saVar, function3);
    }

    public void safedk_m0_play_b94a1e96f511877fb46f5e99a75a96fe() {
        b7.a("play()", (Throwable) null, 2, (Object) null);
        b().setVideoSurfaceView(this.surfaceView);
        b().play();
        this.isComingFromBackground = false;
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onIsPlayingChanged(boolean isPlaying) {
        b7.a("onIsPlayingChanged() - isPlaying: " + isPlaying, (Throwable) null, 2, (Object) null);
        if (isPlaying) {
            this.wasMediaStartedForTheFirstTime = true;
            q0 q0Var = this.callback;
            if (q0Var != null) {
                q0Var.b();
            }
            k();
            return;
        }
        l();
    }

    @Override // com.chartboost.sdk.impl.p0
    public void pause() {
        b7.a("pause()", (Throwable) null, 2, (Object) null);
        b().pause();
    }

    public void safedk_m0_stop_b9623f52dd614cc25ff5cb56ae2a27df() {
        b7.a("stop()", (Throwable) null, 2, (Object) null);
        if (b().isPlaying()) {
            b().stop();
        }
        b().release();
    }

    public final void k() {
        nb.a.a(e(), 0L, 1, null);
    }

    public final void l() {
        e().a();
    }

    @Override // com.chartboost.sdk.impl.p0
    public void f() {
        b().setVolume(0.0f);
    }

    @Override // com.chartboost.sdk.impl.p0
    public void c() {
        b().setVolume(1.0f);
    }

    @Override // com.chartboost.sdk.impl.p0
    /* JADX INFO: renamed from: h, reason: from getter */
    public boolean getWasMediaStartedForTheFirstTime() {
        return this.wasMediaStartedForTheFirstTime;
    }

    @Override // com.chartboost.sdk.impl.p0
    /* JADX INFO: renamed from: g */
    public float getMediaPlayerVolume() {
        return b().getVolume();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlaybackStateChanged(int playbackState) {
        b7.a("onPlaybackStateChanged() - playbackState: " + n0.b(playbackState), (Throwable) null, 2, (Object) null);
        if (playbackState == 2) {
            q0 q0Var = this.callback;
            if (q0Var != null) {
                q0Var.a();
                return;
            }
            return;
        }
        if (playbackState == 3) {
            j();
        } else {
            if (playbackState != 4) {
                return;
            }
            i();
        }
    }

    public final void j() {
        a(this, 0, 0, 3, null);
        q0 q0Var = this.callback;
        if (q0Var != null) {
            q0Var.c();
        }
        q0 q0Var2 = this.callback;
        if (q0Var2 != null) {
            q0Var2.b(b().getDuration());
        }
    }

    public final void i() {
        stop();
        l();
        q0 q0Var = this.callback;
        if (q0Var != null) {
            q0Var.d();
        }
    }

    public final void b(int width, int height) {
        ub.a(this.surfaceView, a5.b(b()), a5.a(b()), width, height);
    }

    public static /* synthetic */ void a(m0 m0Var, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = m0Var.surfaceView.getWidth();
        }
        if ((i3 & 2) != 0) {
            i2 = m0Var.surfaceView.getHeight();
        }
        m0Var.b(i, i2);
    }

    public final MediaItem b(gb gbVar) {
        MediaItem mediaItemA = this.exoPlayerMediaItemFactory.a(gbVar);
        b7.a("VideoAsset.toMediaItem() - " + mediaItemA, (Throwable) null, 2, (Object) null);
        return mediaItemA;
    }

    @Override // com.chartboost.sdk.impl.l1
    public void a() {
        this.isComingFromBackground = true;
    }
}
