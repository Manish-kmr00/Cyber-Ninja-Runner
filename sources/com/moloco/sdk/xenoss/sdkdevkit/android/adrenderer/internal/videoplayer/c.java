package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.content.Context;
import android.os.Looper;
import android.view.InflateException;
import androidx.lifecycle.Lifecycle;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7117a;
    public final boolean b;
    public final i c;
    public final String d;
    public final CoroutineScope e;
    public final MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i> f;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i> g;
    public final MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a> h;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a> i;
    public final MutableStateFlow<l> j;
    public final StateFlow<l> k;
    public final StyledPlayerView l;
    public String m;
    public boolean n;
    public final Looper o;
    public ExoPlayer p;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b q;
    public boolean r;
    public final d s;
    public final SimplifiedExoPlayerLifecycleHandler t;
    public long u;
    public Job v;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.SimplifiedExoPlayer$1", f = "SimplifiedExoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7118a;
        public /* synthetic */ Object b;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a aVar, Continuation<? super Unit> continuation) {
            return ((a) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = c.this.new a(continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7118a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a) this.b).e()) {
                c.this.J();
            } else {
                Job job = c.this.v;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExoPlayer f7119a;
        public final /* synthetic */ C0689c b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ExoPlayer exoPlayer, C0689c c0689c) {
            super(1);
            this.f7119a = exoPlayer;
            this.b = c0689c;
        }

        public final void a(Throwable th) {
            this.f7119a.removeListener(this.b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c$c, reason: collision with other inner class name */
    public static final class C0689c implements Player.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f7120a;
        public final /* synthetic */ ExoPlayer b;
        public final /* synthetic */ CancellableContinuation<Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        public C0689c(int i, ExoPlayer exoPlayer, CancellableContinuation<? super Unit> cancellableContinuation) {
            this.f7120a = i;
            this.b = exoPlayer;
            this.c = cancellableContinuation;
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlaybackStateChanged(int i) {
            if (i == this.f7120a) {
                this.b.removeListener(this);
                CancellableContinuation<Unit> cancellableContinuation = this.c;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m7904constructorimpl(Unit.INSTANCE));
            }
        }
    }

    public static final class d implements Player.Listener {
        public d() {
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onIsPlayingChanged(boolean z) {
            super.onIsPlayingChanged(z);
            ExoPlayer exoPlayerL = c.this.l();
            long duration = exoPlayerL != null ? exoPlayerL.getDuration() : 0L;
            ExoPlayer exoPlayerL2 = c.this.l();
            c.this.h.setValue(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a(z, true, duration - (exoPlayerL2 != null ? exoPlayerL2.getCurrentPosition() : 0L) > 0));
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlaybackStateChanged(int i) {
            super.onPlaybackStateChanged(i);
            if (i == 4) {
                c cVar = c.this;
                ExoPlayer exoPlayerL = c.this.l();
                cVar.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.a(exoPlayerL != null ? exoPlayerL.getDuration() : 1L));
                c.this.I();
            }
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlayerError(PlaybackException error) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b bVar;
            Intrinsics.checkNotNullParameter(error, "error");
            super.onPlayerError(error);
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.error$default(molocoLogger, c.this.d, "Exoplayer error (streaming enabled = " + c.this.b + ')', error, false, 8, null);
            if (c.this.b && (bVar = c.this.q) != null && bVar.a()) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i) c.this.f.getValue();
                if ((iVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.a) || (iVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.c)) {
                    MolocoLogger.info$default(molocoLogger, c.this.d, "Ignoring exoplayer streaming error as the user has viewed some of the ad already", null, false, 12, null);
                    return;
                } else if ((iVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.d) || Intrinsics.areEqual(iVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.b.b)) {
                    MolocoLogger.info$default(molocoLogger, c.this.d, "Exoplayer streaming failed before any playback started, so report that as error", null, false, 12, null);
                }
            }
            c.this.j.setValue(l.VAST_AD_EXOPLAYER_VIDEO_LAYER_ERROR);
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function0<Unit> {
        public e(Object obj) {
            super(0, obj, c.class, "initOrResumeExoPlayer", "initOrResumeExoPlayer()V", 0);
        }

        public final void a() {
            ((c) this.receiver).B();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class f extends FunctionReferenceImpl implements Function0<Unit> {
        public f(Object obj) {
            super(0, obj, c.class, "disposeExoPlayer", "disposeExoPlayer()V", 0);
        }

        public final void a() {
            ((c) this.receiver).j();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.SimplifiedExoPlayer$startPlaybackProgressJob$1", f = "SimplifiedExoPlayer.kt", i = {}, l = {328}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7122a;

        public g(Continuation<? super g> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new g(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7122a;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            do {
                ExoPlayer exoPlayerL = c.this.l();
                if (exoPlayerL != null) {
                    c.this.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.c(exoPlayerL.getCurrentPosition(), exoPlayerL.getDuration()));
                }
                this.f7122a = 1;
            } while (DelayKt.delay(500L, this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }

    public c(Context context, boolean z, i mediaCacheRepository, Lifecycle lifecycle) {
        StyledPlayerView styledPlayerView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaCacheRepository, "mediaCacheRepository");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.f7117a = context;
        this.b = z;
        this.c = mediaCacheRepository;
        this.d = "SimplifiedExoPlayer";
        this.e = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i> MutableStateFlow = StateFlowKt.MutableStateFlow(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.b.b);
        this.f = MutableStateFlow;
        this.g = MutableStateFlow;
        MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a(false, false, false, 6, null));
        this.h = MutableStateFlow2;
        this.i = MutableStateFlow2;
        MutableStateFlow<l> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this.j = MutableStateFlow3;
        this.k = MutableStateFlow3;
        try {
            styledPlayerView = new StyledPlayerView(context);
            styledPlayerView.setUseController(false);
        } catch (InflateException e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.d, "ExoPlayerView could not be instantiated.", e2, false, 8, null);
            this.j.setValue(l.VAST_AD_EXOPLAYER_STYLED_PLAYER_VIEW_INFLATE_EXCEPTION_ERROR);
            styledPlayerView = null;
        }
        this.l = styledPlayerView;
        this.o = Looper.getMainLooper();
        FlowKt.launchIn(FlowKt.onEach(isPlaying(), new a(null)), this.e);
        this.s = new d();
        this.t = new SimplifiedExoPlayerLifecycleHandler(lifecycle, new e(this), new f(this));
    }

    public static /* synthetic */ void A() {
    }

    public static /* synthetic */ void n() {
    }

    public static /* synthetic */ void y() {
    }

    public final void B() {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.d, "Init exo player", null, false, 12, null);
        StyledPlayerView styledPlayerViewM = M();
        if (styledPlayerViewM == null) {
            return;
        }
        if (this.p == null) {
            ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(this.f7117a).setLooper(this.o).setPauseAtEndOfMediaItems(true).build();
            Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "Builder(context)\n       …\n                .build()");
            styledPlayerViewM.setPlayer(exoPlayerBuild);
            this.p = exoPlayerBuild;
            exoPlayerBuild.setPlayWhenReady(false);
            exoPlayerBuild.addListener(this.s);
            b(exoPlayerBuild);
            if (Intrinsics.areEqual(o().getValue(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.b.b)) {
                b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.d(exoPlayerBuild.getDuration()));
            }
        }
        styledPlayerViewM.onResume();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
    public boolean D() {
        return this.n;
    }

    public final void I() {
        this.r = false;
        this.u = 0L;
    }

    public final void J() {
        Job job = this.v;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.v = BuildersKt__Builders_commonKt.launch$default(this.e, null, null, new g(null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.e, null, 1, null);
        this.t.destroy();
        j();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
    public StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a> isPlaying() {
        return this.i;
    }

    public final ExoPlayer l() {
        return this.p;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
    public String m() {
        return this.m;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
    public StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i> o() {
        return this.g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public StyledPlayerView M() {
        return this.l;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
    public void pause() {
        this.r = false;
        ExoPlayer exoPlayer = this.p;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
    public void play() {
        this.r = true;
        ExoPlayer exoPlayer = this.p;
        if (exoPlayer != null) {
            exoPlayer.play();
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
    public void seekTo(long j) {
        this.u = j;
        ExoPlayer exoPlayer = this.p;
        if (exoPlayer != null) {
            exoPlayer.seekTo(j);
        }
    }

    public final boolean t() {
        return this.r;
    }

    public final void b(ExoPlayer exoPlayer) {
        a(exoPlayer, D());
        a(exoPlayer, m());
        exoPlayer.seekTo(this.u);
        if (this.r) {
            exoPlayer.play();
        } else {
            exoPlayer.pause();
        }
    }

    public final void c(ExoPlayer exoPlayer) {
        this.u = exoPlayer.getCurrentPosition();
    }

    public final void d(ExoPlayer exoPlayer) {
        this.p = exoPlayer;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
    public StateFlow<l> e() {
        return this.k;
    }

    public final void j() {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.d, "Disposing exo player", null, false, 12, null);
        StyledPlayerView styledPlayerViewM = M();
        if (styledPlayerViewM != null) {
            styledPlayerViewM.onPause();
            styledPlayerViewM.setPlayer(null);
        }
        ExoPlayer exoPlayer = this.p;
        long duration = exoPlayer != null ? exoPlayer.getDuration() : 0L;
        ExoPlayer exoPlayer2 = this.p;
        boolean z = duration - (exoPlayer2 != null ? exoPlayer2.getCurrentPosition() : 0L) > 0;
        ExoPlayer exoPlayer3 = this.p;
        if (exoPlayer3 != null) {
            c(exoPlayer3);
            exoPlayer3.removeListener(this.s);
            exoPlayer3.release();
        }
        this.p = null;
        this.h.setValue(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a(false, false, z));
    }

    public final void e(boolean z) {
        this.r = z;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
    public void a(String str) {
        this.m = str;
        ExoPlayer exoPlayer = this.p;
        if (exoPlayer != null) {
            a(exoPlayer, str);
        }
        I();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
    public void a(boolean z) {
        this.n = z;
        ExoPlayer exoPlayer = this.p;
        if (exoPlayer == null) {
            return;
        }
        a(exoPlayer, z);
    }

    public final void b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar) {
        this.f.setValue(iVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
    public Object a(Continuation<? super Unit> continuation) {
        Object objA;
        ExoPlayer exoPlayer = this.p;
        return (exoPlayer == null || (objA = a(exoPlayer, 3, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objA;
    }

    public final boolean a(ExoPlayer exoPlayer) {
        return exoPlayer.getVolume() == 0.0f;
    }

    public final void a(ExoPlayer exoPlayer, boolean z) {
        exoPlayer.setVolume(z ? 0.0f : 1.0f);
    }

    public final void a(ExoPlayer exoPlayer, final String str) {
        if (str == null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.d, "URI Source is empty", null, false, 12, null);
            return;
        }
        try {
            if (this.b) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.d, "Streaming is enabled", null, false, 12, null);
                DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(new DataSource.Factory() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c$$ExternalSyntheticLambda0
                    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
                    public final DataSource createDataSource() {
                        return c.a(str, this);
                    }
                });
                MediaItem mediaItemFromUri = MediaItem.fromUri(str);
                Intrinsics.checkNotNullExpressionValue(mediaItemFromUri, "fromUri(uriSource)");
                exoPlayer.setMediaSource(defaultMediaSourceFactory.createMediaSource(mediaItemFromUri));
            } else {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.d, "Streaming is disabled", null, false, 12, null);
                exoPlayer.setMediaItem(MediaItem.fromUri(str));
            }
            exoPlayer.prepare();
        } catch (Exception e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.d, "ExoPlayer setMediaItem exception", e2, false, 8, null);
            this.j.setValue(l.VAST_AD_EXOPLAYER_SET_MEDIA_ITEM_EXCEPTION_ERROR);
        }
    }

    public static final DataSource a(String str, c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b bVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b(str, this$0.c);
        this$0.q = bVar;
        return bVar;
    }

    public final Object a(ExoPlayer exoPlayer, int i, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        C0689c c0689c = new C0689c(i, exoPlayer, cancellableContinuationImpl);
        exoPlayer.addListener(c0689c);
        cancellableContinuationImpl.invokeOnCancellation(new b(exoPlayer, c0689c));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
