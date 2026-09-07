package com.chartboost.sdk.impl;

import android.media.MediaPlayer;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.ChartboostVideoBridge;
import com.safedk.android.utils.Logger;
import com.yandex.div.core.timer.TimerController;
import java.io.FileDescriptor;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005BÏ\u0001\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010'\u0012\b\u00108\u001a\u0004\u0018\u000106\u0012\b\u0010;\u001a\u0004\u0018\u000109\u0012\u0006\u0010>\u001a\u00020<\u0012$\u0010i\u001a \u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020^0gj\u0002`h\u0012f\u0010K\u001ab\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(C\u0012\u0013\u0012\u00110D¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(E\u0012\u0015\u0012\u0013\u0018\u00010F¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020H0?j\u0002`I\u0012\b\b\u0002\u0010E\u001a\u00020D\u0012\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bj\u0010kJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u001c\u0010\u000fJ\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\bJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\bJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\bJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u000fJ\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0001¢\u0006\u0004\b\u0018\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0001¢\u0006\u0004\b*\u0010\bJ\r\u0010+\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J/\u00101\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,2\u0006\u00100\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b3\u0010/R\u0018\u00105\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00107R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010=Rt\u0010K\u001ab\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(C\u0012\u0013\u0012\u00110D¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(E\u0012\u0015\u0012\u0013\u0018\u00010F¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020H0?j\u0002`I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010JR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010LR\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010MR\u0016\u0010O\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010NR\u0016\u0010Q\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010PR\u0016\u0010R\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010PR\u0016\u0010S\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010PR\u0016\u0010T\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010PR\u0016\u0010U\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010PR\u0018\u0010W\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010PR\u0016\u0010f\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010e¨\u0006l"}, d2 = {"Lcom/chartboost/sdk/impl/o0;", "Lcom/chartboost/sdk/impl/p0;", "Landroid/view/SurfaceHolder$Callback;", "Lcom/chartboost/sdk/impl/nb$b;", "Lcom/chartboost/sdk/impl/ib$b;", "Lcom/chartboost/sdk/impl/l1;", "", "l", "()V", "i", "o", "", "width", "height", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(II)V", CampaignEx.JSON_KEY_AD_K, "j", "m", "", "d", "()J", "Lcom/chartboost/sdk/impl/gb;", "asset", "a", "(Lcom/chartboost/sdk/impl/gb;)V", "what", "extra", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "play", "pause", TimerController.STOP_COMMAND, "", "h", "()Z", InneractiveMediationDefs.GENDER_FEMALE, "", "g", "()F", "Landroid/media/MediaPlayer;", CampaignEx.JSON_KEY_AD_MP, "(Landroid/media/MediaPlayer;)V", "n", "e", "Landroid/view/SurfaceHolder;", "holder", "surfaceCreated", "(Landroid/view/SurfaceHolder;)V", "format", "surfaceChanged", "(Landroid/view/SurfaceHolder;III)V", "surfaceDestroyed", "Landroid/media/MediaPlayer;", "mediaPlayer", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceView;", "surface", "Lcom/chartboost/sdk/impl/q0;", "Lcom/chartboost/sdk/impl/q0;", "callback", "Lcom/chartboost/sdk/impl/sa;", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "videoAsset", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/ib;", "Lcom/chartboost/sdk/internal/video/player/mediaplayer/VideoBufferFactory;", "Lkotlin/jvm/functions/Function4;", "videoBufferFactory", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lcom/chartboost/sdk/impl/f5;", "J", "videoPosition", "Z", "isPrepared", "isStarted", "isPaused", "isBuffering", "isComingFromBackground", "Landroid/view/SurfaceHolder;", "surfaceHolder", "Lcom/chartboost/sdk/impl/u8;", "Lcom/chartboost/sdk/impl/u8;", "randomAccessVideoFile", "p", "Lcom/chartboost/sdk/impl/ib;", "buffer", "Lcom/chartboost/sdk/impl/nb;", CampaignEx.JSON_KEY_AD_Q, "Lcom/chartboost/sdk/impl/nb;", "videoProgressScheduler", "r", "wasMediaStartedForTheFirstTime", "s", "F", "mediaPlayerVolume", "Lkotlin/Function3;", "Lcom/chartboost/sdk/internal/video/player/scheduler/VideoProgressSchedulerFactory;", "videoProgressFactory", "<init>", "(Landroid/media/MediaPlayer;Landroid/view/SurfaceView;Lcom/chartboost/sdk/impl/q0;Lcom/chartboost/sdk/impl/sa;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function4;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/chartboost/sdk/impl/f5;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class o0 implements p0, SurfaceHolder.Callback, nb.b, ib.b, l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public MediaPlayer mediaPlayer;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public SurfaceView surface;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public q0 callback;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final sa uiPoster;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Function4<gb, ib.b, CoroutineDispatcher, f5, ib> videoBufferFactory;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final CoroutineDispatcher coroutineDispatcher;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final f5 fileCache;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public long videoPosition;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public boolean isPrepared;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public boolean isStarted;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public boolean isPaused;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public boolean isBuffering;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public boolean isComingFromBackground;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public SurfaceHolder surfaceHolder;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public u8 randomAccessVideoFile;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public ib buffer;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final nb videoProgressScheduler;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public boolean wasMediaStartedForTheFirstTime;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public float mediaPlayerVolume;

    /* JADX WARN: Multi-variable type inference failed */
    public o0(MediaPlayer mediaPlayer, SurfaceView surfaceView, q0 q0Var, sa uiPoster, Function3<? super q0, ? super nb.b, ? super sa, ? extends nb> videoProgressFactory, Function4<? super gb, ? super ib.b, ? super CoroutineDispatcher, ? super f5, ib> videoBufferFactory, CoroutineDispatcher coroutineDispatcher, f5 fileCache) {
        Intrinsics.checkNotNullParameter(uiPoster, "uiPoster");
        Intrinsics.checkNotNullParameter(videoProgressFactory, "videoProgressFactory");
        Intrinsics.checkNotNullParameter(videoBufferFactory, "videoBufferFactory");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        this.mediaPlayer = mediaPlayer;
        this.surface = surfaceView;
        this.callback = q0Var;
        this.uiPoster = uiPoster;
        this.videoBufferFactory = videoBufferFactory;
        this.coroutineDispatcher = coroutineDispatcher;
        this.fileCache = fileCache;
        this.surfaceHolder = surfaceView != null ? surfaceView.getHolder() : null;
        this.videoProgressScheduler = videoProgressFactory.invoke(this.callback, this, uiPoster);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0040  */
    /* JADX WARN: Code duplicated, block: B:14:0x0044  */
    @Override // com.chartboost.sdk.impl.p0
    public void a(gb asset) {
        q0 q0Var;
        Intrinsics.checkNotNullParameter(asset, "asset");
        Unit unit = null;
        b7.a("asset() - asset: " + asset, (Throwable) null, 2, (Object) null);
        if (this.mediaPlayer != null) {
            ib ibVarInvoke = this.videoBufferFactory.invoke(asset, this, this.coroutineDispatcher, this.fileCache);
            this.buffer = ibVarInvoke;
            this.randomAccessVideoFile = ibVarInvoke != null ? ibVarInvoke.d() : null;
            SurfaceHolder surfaceHolder = this.surfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.addCallback(this);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                q0Var = this.callback;
                if (q0Var != null) {
                    q0Var.a("Missing media player during startMediaPlayer");
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        } else {
            q0Var = this.callback;
            if (q0Var != null) {
                q0Var.a("Missing media player during startMediaPlayer");
                Unit unit3 = Unit.INSTANCE;
            }
        }
        this.wasMediaStartedForTheFirstTime = false;
    }

    @Override // com.chartboost.sdk.impl.p0
    public void play() {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/o0;->play()V");
        CreativeInfoManager.onVideoStart(com.safedk.android.utils.h.c, this, "chartboost exo-player");
        safedk_o0_play_2a144ff3163d9a9963418e725e1f88a1();
    }

    @Override // com.chartboost.sdk.impl.p0
    public void stop() throws IOException {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/o0;->stop()V");
        CreativeInfoManager.onVideoCompleted(com.safedk.android.utils.h.c, "chartboost exo-player");
        safedk_o0_stop_c8821d54b4c21c022e948a69763afbdb();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.isPaused) {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(holder);
            }
            play();
            return;
        }
        try {
            m();
            l();
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.prepareAsync();
            }
            MediaPlayer mediaPlayer3 = this.mediaPlayer;
            if (mediaPlayer3 != null) {
                mediaPlayer3.setDisplay(holder);
            }
        } catch (Exception e) {
            b7.b("SurfaceCreated exception", e);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(null);
        }
    }

    @Override // com.chartboost.sdk.impl.nb.b
    public long d() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            return 0L;
        }
        long currentPosition = mediaPlayer.getCurrentPosition();
        this.videoPosition = currentPosition;
        return currentPosition;
    }

    public final void c(int what, int extra) {
        b7.b("MediaPlayer error: " + ("error: " + what + " extra: " + extra), null, 2, null);
        if (this.isPrepared) {
            e();
        }
    }

    public /* synthetic */ o0(MediaPlayer mediaPlayer, SurfaceView surfaceView, q0 q0Var, sa saVar, Function3 function3, Function4 function4, CoroutineDispatcher coroutineDispatcher, f5 f5Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new MediaPlayer() : mediaPlayer, surfaceView, q0Var, saVar, function3, function4, (i & 64) != 0 ? Dispatchers.getMain() : coroutineDispatcher, f5Var);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0018 A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:9:0x000f, B:17:0x0027, B:12:0x0018, B:14:0x001c), top: B:26:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x001c A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:9:0x000f, B:17:0x0027, B:12:0x0018, B:14:0x001c), top: B:26:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0024  */
    public final void l() {
        q0 q0Var;
        Unit unit;
        FileDescriptor fd;
        Unit unit2 = null;
        try {
            u8 u8Var = this.randomAccessVideoFile;
            if (u8Var == null || (fd = u8Var.getFd()) == null) {
                q0Var = this.callback;
                if (q0Var != null) {
                    q0Var.a("Missing video asset");
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
            } else {
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    ChartboostVideoBridge.MediaPlayerSetDataSource(mediaPlayer, fd);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    q0Var = this.callback;
                    if (q0Var != null) {
                        q0Var.a("Missing video asset");
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                }
            }
            if (unit == null) {
                b7.b("MediaPlayer missing callback on error", null, 2, null);
            }
        } catch (IOException e) {
            q0 q0Var2 = this.callback;
            if (q0Var2 != null) {
                q0Var2.a(e.toString());
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                b7.b("MediaPlayer missing callback on IOException", e);
            }
        }
    }

    public void safedk_o0_play_2a144ff3163d9a9963418e725e1f88a1() {
        b7.a("play()", (Throwable) null, 2, (Object) null);
        if (this.isPrepared && !this.isStarted) {
            o();
        }
        this.isStarted = true;
        this.isPaused = this.isComingFromBackground;
        this.isComingFromBackground = false;
    }

    @Override // com.chartboost.sdk.impl.p0
    public void pause() {
        b7.a("pause()", (Throwable) null, 2, (Object) null);
        if (this.isPrepared && this.isStarted) {
            ib ibVar = this.buffer;
            if (ibVar != null) {
                ibVar.e();
            }
            j();
            try {
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    ChartboostVideoBridge.MediaPlayerPause(mediaPlayer);
                }
            } catch (Exception e) {
                q0 q0Var = this.callback;
                if (q0Var != null) {
                    q0Var.a(e.toString());
                }
            }
            this.videoPosition = d();
            this.isStarted = false;
            this.isPaused = true;
        }
    }

    public void safedk_o0_stop_c8821d54b4c21c022e948a69763afbdb() throws IOException {
        b7.a("stop()", (Throwable) null, 2, (Object) null);
        if (this.isPrepared) {
            ib ibVar = this.buffer;
            if (ibVar != null) {
                ibVar.e();
            }
            this.buffer = null;
            this.videoPosition = 0L;
            j();
            try {
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    ChartboostVideoBridge.MediaPlayerStop(mediaPlayer);
                }
            } catch (Exception e) {
                q0 q0Var = this.callback;
                if (q0Var != null) {
                    q0Var.a(e.toString());
                }
            }
            this.isStarted = false;
            this.isPaused = false;
            u8 u8Var = this.randomAccessVideoFile;
            if (u8Var != null) {
                u8Var.a();
            }
            this.randomAccessVideoFile = null;
            i();
        }
    }

    @Override // com.chartboost.sdk.impl.p0
    /* JADX INFO: renamed from: h, reason: from getter */
    public boolean getWasMediaStartedForTheFirstTime() {
        return this.wasMediaStartedForTheFirstTime;
    }

    @Override // com.chartboost.sdk.impl.p0
    public void f() {
        this.mediaPlayerVolume = 0.0f;
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        }
    }

    @Override // com.chartboost.sdk.impl.p0
    /* JADX INFO: renamed from: g, reason: from getter */
    public float getMediaPlayerVolume() {
        return this.mediaPlayerVolume;
    }

    public final void i() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            ChartboostVideoBridge.MediaPlayerRelease(mediaPlayer);
        }
        this.callback = null;
        this.mediaPlayer = null;
        this.surfaceHolder = null;
        this.surface = null;
        this.buffer = null;
    }

    @Override // com.chartboost.sdk.impl.l1
    public void a() {
        this.isComingFromBackground = true;
    }

    public final void a(MediaPlayer mp) {
        Intrinsics.checkNotNullParameter(mp, "mp");
        this.isBuffering = false;
        int duration = mp.getDuration();
        SurfaceView surfaceView = this.surface;
        int width = surfaceView != null ? surfaceView.getWidth() : 0;
        SurfaceView surfaceView2 = this.surface;
        b(width, surfaceView2 != null ? surfaceView2.getHeight() : 0);
        q0 q0Var = this.callback;
        if (q0Var != null) {
            q0Var.b(duration);
        }
        this.isPrepared = true;
        ib ibVar = this.buffer;
        if (ibVar != null) {
            ibVar.a(duration);
        }
        if (this.isStarted) {
            n();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Unit> {
        public a(Object obj) {
            super(0, obj, o0.class, "startMediaPlayer", "startMediaPlayer$ChartboostMonetization_9_8_3_productionRelease()V", 0);
        }

        public final void a() {
            ((o0) this.receiver).n();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public final void o() {
        this.uiPoster.a(500L, new a(this));
    }

    public final void n() {
        Unit unit;
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            try {
                ChartboostVideoBridge.MediaPlayerStart(mediaPlayer);
                this.wasMediaStartedForTheFirstTime = true;
                k();
                q0 q0Var = this.callback;
                if (q0Var != null) {
                    q0Var.b();
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    mediaPlayer.seekTo(this.videoPosition, 3);
                } else {
                    mediaPlayer.seekTo((int) this.videoPosition);
                }
                unit = Unit.INSTANCE;
            } catch (IllegalStateException e) {
                q0 q0Var2 = this.callback;
                if (q0Var2 != null) {
                    q0Var2.a(e.toString());
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
            }
            if (unit != null) {
                return;
            }
        }
        q0 q0Var3 = this.callback;
        if (q0Var3 != null) {
            q0Var3.a("Missing video player during startVideoPlayer");
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final void e() {
        if (!this.isStarted || this.isBuffering) {
            return;
        }
        ib ibVar = this.buffer;
        if (ibVar != null) {
            ibVar.a();
        }
        this.isBuffering = false;
        q0 q0Var = this.callback;
        if (q0Var != null) {
            q0Var.a();
        }
        pause();
        ib ibVar2 = this.buffer;
        if (ibVar2 != null) {
            ibVar2.c();
        }
    }

    @Override // com.chartboost.sdk.impl.p0
    public void c() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    private final void b(int width, int height) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        SurfaceView surfaceView = this.surface;
        int videoHeight = mediaPlayer != null ? mediaPlayer.getVideoHeight() : 1;
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        ub.a(surfaceView, mediaPlayer2 != null ? mediaPlayer2.getVideoWidth() : 1, videoHeight, width, height);
    }

    public final void k() {
        nb.a.a(this.videoProgressScheduler, 0L, 1, null);
    }

    public final void j() {
        this.videoProgressScheduler.a();
    }

    public final void m() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.chartboost.sdk.impl.o0$$ExternalSyntheticLambda0
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer2) {
                    this.f$0.a(mediaPlayer2);
                }
            });
            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.chartboost.sdk.impl.o0$$ExternalSyntheticLambda1
                @Override // android.media.MediaPlayer.OnInfoListener
                public final boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                    return o0.a(this.f$0, mediaPlayer2, i, i2);
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.chartboost.sdk.impl.o0$$ExternalSyntheticLambda2
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer2) {
                    Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/o0$$ExternalSyntheticLambda2;->onCompletion(Landroid/media/MediaPlayer;)V");
                    CreativeInfoManager.onVideoCompleted(com.safedk.android.utils.h.c, mediaPlayer2, "media-player");
                    safedk_o0$$ExternalSyntheticLambda2_onCompletion_9701ec8f85d764bf11f1814a49d48941(mediaPlayer2);
                }

                public void safedk_o0$$ExternalSyntheticLambda2_onCompletion_9701ec8f85d764bf11f1814a49d48941(MediaPlayer p0) {
                    o0.a(this.f$0, p0);
                }
            });
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.chartboost.sdk.impl.o0$$ExternalSyntheticLambda3
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                    return o0.b(this.f$0, mediaPlayer2, i, i2);
                }
            });
        }
    }

    @Override // com.chartboost.sdk.impl.ib.b
    public void b() {
        this.isStarted = true;
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        l();
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.prepareAsync();
        }
        q0 q0Var = this.callback;
        if (q0Var != null) {
            q0Var.c();
        }
    }

    public static final boolean b(o0 this$0, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c(i, i2);
        return true;
    }

    @Override // com.chartboost.sdk.impl.l9
    public void a(int width, int height) {
        b(height, width);
    }

    public static final boolean a(o0 this$0, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((i != 805 && i != 804) || i2 != -1004) {
            return true;
        }
        this$0.e();
        return true;
    }

    public static final void a(o0 this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.videoPosition >= ((double) mediaPlayer.getDuration()) - (((double) mediaPlayer.getDuration()) * 0.05d)) {
            q0 q0Var = this$0.callback;
            if (q0Var != null) {
                q0Var.d();
                return;
            }
            return;
        }
        this$0.e();
    }
}
