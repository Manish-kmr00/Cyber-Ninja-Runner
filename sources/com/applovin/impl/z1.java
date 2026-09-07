package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.internal.partials.AppLovinVideoBridge;
import com.safedk.android.internal.special.SpecialsBridge;
import com.safedk.android.utils.Logger;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes9.dex */
public class z1 extends v1 implements AppLovinCommunicatorSubscriber {
    private final a2 M;
    private MediaPlayer N;
    private final View O;
    protected final AppLovinVideoView P;
    protected final com.applovin.impl.a Q;
    protected final com.applovin.impl.adview.g R;
    protected i0 S;
    protected final ImageView T;
    protected com.applovin.impl.adview.l U;
    protected final ProgressBar V;
    protected ProgressBar W;
    protected ImageView X;
    private final e Y;
    private final d Z;
    private final Handler a0;
    private final Handler b0;
    protected final a1 c0;
    protected final a1 d0;
    private final boolean e0;
    protected boolean f0;
    protected long g0;
    private int h0;
    private int i0;
    protected boolean j0;
    private boolean k0;
    private final AtomicBoolean l0;
    private final AtomicBoolean m0;
    private long n0;
    private long o0;

    class a implements a1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f768a;

        a(int i) {
            this.f768a = i;
        }

        @Override // com.applovin.impl.a1.b
        public void a() {
            z1 z1Var = z1.this;
            if (z1Var.S != null) {
                long seconds = ((long) this.f768a) - TimeUnit.MILLISECONDS.toSeconds(z1Var.P.getCurrentPosition());
                if (seconds <= 0) {
                    z1.this.v = true;
                } else if (z1.this.P()) {
                    z1.this.S.setProgress((int) seconds);
                }
            }
        }

        @Override // com.applovin.impl.a1.b
        public boolean b() {
            return z1.this.P();
        }
    }

    class b implements a1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Integer f769a;

        b(Integer num) {
            this.f769a = num;
        }

        @Override // com.applovin.impl.a1.b
        public void a() {
            z1 z1Var = z1.this;
            if (z1Var.j0) {
                z1Var.V.setVisibility(8);
            } else {
                z1.this.V.setProgress((int) ((z1Var.P.getCurrentPosition() / z1.this.g0) * this.f769a.intValue()));
            }
        }

        @Override // com.applovin.impl.a1.b
        public boolean b() {
            return !z1.this.j0;
        }
    }

    class c implements a1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f770a;
        final /* synthetic */ Integer b;
        final /* synthetic */ Long c;

        c(long j, Integer num, Long l) {
            this.f770a = j;
            this.b = num;
            this.c = l;
        }

        @Override // com.applovin.impl.a1.b
        public void a() {
            z1.this.W.setProgress((int) ((z1.this.r / this.f770a) * this.b.intValue()));
            z1.this.r += this.c.longValue();
        }

        @Override // com.applovin.impl.a1.b
        public boolean b() {
            return z1.this.r < this.f770a;
        }
    }

    private class d implements j8.a {
        private d() {
        }

        @Override // com.applovin.impl.j8.a
        public void a(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.o oVar = z1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                z1.this.c.a("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            z1.this.a("video_button");
        }

        @Override // com.applovin.impl.j8.a
        public void b(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.o oVar = z1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                z1.this.c.a("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            z1.this.a(lVar.getAndClearLastClickEvent(), (Bundle) null);
        }

        @Override // com.applovin.impl.j8.a
        public void c(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.o oVar = z1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                z1.this.c.a("AppLovinFullscreenActivity", "Fully Watched from video button...");
            }
            z1.this.J = true;
        }

        @Override // com.applovin.impl.j8.a
        public void d(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.o oVar = z1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                z1.this.c.a("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            z1.this.S();
        }

        /* synthetic */ d(z1 z1Var, a aVar) {
            this();
        }

        @Override // com.applovin.impl.j8.a
        public void a(com.applovin.impl.adview.l lVar, Bundle bundle) {
            com.applovin.impl.sdk.o oVar = z1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                z1.this.c.a("AppLovinFullscreenActivity", "Attempting to launch Direct Download from video button...");
            }
            z1.this.a(lVar.getAndClearLastClickEvent(), bundle);
        }

        @Override // com.applovin.impl.j8.a
        public void b(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.o oVar = z1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                z1.this.c.a("AppLovinFullscreenActivity", "Attempting to report a template error from video button...");
            }
            h7.c(uri, z1.this.i.getController().g(), z1.this.b);
        }

        @Override // com.applovin.impl.j8.a
        public void a(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.o oVar = z1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                z1.this.c.a("AppLovinFullscreenActivity", "Attempting to load a url from video button...");
            }
            h7.a(uri, z1.this.i.getController(), z1.this.b);
        }
    }

    private class e implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnCompletionListener, AppLovinTouchToClickListener.OnClickListener {
        private e() {
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, MotionEvent motionEvent) {
            z1.this.a(motionEvent, (Bundle) null);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/impl/z1$e;->onCompletion(Landroid/media/MediaPlayer;)V");
            CreativeInfoManager.onVideoCompleted(com.safedk.android.utils.h.f8160a, mediaPlayer, "media-player");
            safedk_z1$e_onCompletion_e6a5a5fc757e49a1985ae17d382b9869(mediaPlayer);
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            z1.this.g("Video view error (" + i + StringUtils.COMMA + i2 + ")");
            AppLovinVideoBridge.VideoViewPlay(z1.this.P);
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            com.applovin.impl.sdk.o oVar = z1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                z1.this.c.a("AppLovinFullscreenActivity", "MediaPlayer Info: (" + i + ", " + i2 + ")");
            }
            if (i == 701) {
                z1.this.Q();
                return false;
            }
            if (i != 3) {
                if (i != 702) {
                    return false;
                }
                z1.this.D();
                return false;
            }
            z1.this.c0.b();
            z1 z1Var = z1.this;
            if (z1Var.R != null) {
                z1Var.O();
            }
            z1.this.D();
            return false;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            z1.this.N = mediaPlayer;
            mediaPlayer.setOnInfoListener(z1.this.Y);
            mediaPlayer.setOnErrorListener(z1.this.Y);
            float f = !z1.this.f0 ? 1 : 0;
            mediaPlayer.setVolume(f, f);
            z1.this.u = (int) TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getDuration());
            z1.this.d(mediaPlayer.getDuration());
            z1.this.N();
            com.applovin.impl.sdk.o oVar = z1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                z1.this.c.a("AppLovinFullscreenActivity", "MediaPlayer prepared: " + z1.this.N);
            }
        }

        public void safedk_z1$e_onCompletion_e6a5a5fc757e49a1985ae17d382b9869(MediaPlayer p0) {
            com.applovin.impl.sdk.o oVar = z1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                z1.this.c.a("AppLovinFullscreenActivity", "Video completed");
            }
            z1.this.k0 = true;
            z1 z1Var = z1.this;
            if (!z1Var.t) {
                z1Var.R();
            } else if (z1Var.g()) {
                z1.this.z();
            }
        }

        /* synthetic */ e(z1 z1Var, a aVar) {
            this();
        }
    }

    private class f implements View.OnClickListener {
        private f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z1 z1Var = z1.this;
            if (view == z1Var.R) {
                z1Var.S();
                return;
            }
            if (view == z1Var.T) {
                z1Var.T();
                return;
            }
            com.applovin.impl.sdk.o oVar = z1Var.c;
            if (com.applovin.impl.sdk.o.a()) {
                z1.this.c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }

        /* synthetic */ f(z1 z1Var, a aVar) {
            this();
        }
    }

    public z1(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.k kVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.M = new a2(this.f715a, this.d, this.b);
        a aVar = null;
        this.X = null;
        e eVar = new e(this, aVar);
        this.Y = eVar;
        d dVar = new d(this, aVar);
        this.Z = dVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.a0 = handler;
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.b0 = handler2;
        a1 a1Var = new a1(handler, this.b);
        this.c0 = a1Var;
        this.d0 = new a1(handler2, this.b);
        boolean zO0 = this.f715a.O0();
        this.e0 = zO0;
        this.f0 = k7.e(this.b);
        this.i0 = -1;
        this.l0 = new AtomicBoolean();
        this.m0 = new AtomicBoolean();
        this.n0 = -2L;
        this.o0 = 0L;
        if (!bVar.hasVideoUrl()) {
            throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
        }
        AppLovinVideoView appLovinVideoView = new AppLovinVideoView(activity);
        this.P = appLovinVideoView;
        appLovinVideoView.setOnPreparedListener(eVar);
        appLovinVideoView.setOnCompletionListener(eVar);
        appLovinVideoView.setOnErrorListener(eVar);
        bVar.h().putString("video_view_address", b8.a(appLovinVideoView));
        View view = new View(activity);
        this.O = view;
        boolean z = false;
        view.setBackgroundColor(Color.argb(254, 0, 0, 0));
        if (((Boolean) kVar.a(v4.k1)).booleanValue()) {
            view.setOnTouchListener(new AppLovinTouchToClickListener(kVar, v4.h0, activity, eVar));
        } else {
            appLovinVideoView.setOnTouchListener(new AppLovinTouchToClickListener(kVar, v4.h0, activity, eVar));
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.z1$$ExternalSyntheticLambda9
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return z1.a(view2, motionEvent);
                }
            });
        }
        f fVar = new f(this, aVar);
        if (bVar.n0() >= 0) {
            com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.e0(), activity);
            this.R = gVar;
            gVar.setVisibility(8);
            gVar.setOnClickListener(fVar);
        } else {
            this.R = null;
        }
        if (a(this.f0, kVar)) {
            ImageView imageView = new ImageView(activity);
            this.T = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(fVar);
            e(this.f0);
        } else {
            this.T = null;
        }
        String strK0 = bVar.k0();
        if (com.applovin.impl.sdk.utils.StringUtils.isValidString(strK0)) {
            j8 j8Var = new j8(kVar);
            j8Var.a(new WeakReference(dVar));
            com.applovin.impl.adview.l lVar = new com.applovin.impl.adview.l(bVar.j0(), bVar, j8Var, activity);
            this.U = lVar;
            lVar.a(strK0);
        } else {
            this.U = null;
        }
        if (zO0) {
            com.applovin.impl.a aVar2 = new com.applovin.impl.a(activity, ((Integer) kVar.a(v4.i2)).intValue(), R.attr.progressBarStyleLarge);
            this.Q = aVar2;
            aVar2.setColor(Color.parseColor("#75FFFFFF"));
            aVar2.setBackgroundColor(Color.parseColor("#00000000"));
            aVar2.setVisibility(8);
            AppLovinCommunicator.getInstance(activity).subscribe(this, "video_caching_failed");
        } else {
            this.Q = null;
        }
        int iB = b();
        if (((Boolean) kVar.a(v4.S1)).booleanValue() && iB > 0) {
            z = true;
        }
        if (this.S == null && z) {
            this.S = new i0(activity);
            int iT = bVar.t();
            this.S.setTextColor(iT);
            this.S.setTextSize(((Integer) kVar.a(v4.R1)).intValue());
            this.S.setFinishedStrokeColor(iT);
            this.S.setFinishedStrokeWidth(((Integer) kVar.a(v4.Q1)).intValue());
            this.S.setMax(iB);
            this.S.setProgress(iB);
            a1Var.a("COUNTDOWN_CLOCK", TimeUnit.SECONDS.toMillis(1L), new a(iB));
        }
        if (!bVar.u0()) {
            this.V = null;
            return;
        }
        Long l = (Long) kVar.a(v4.f2);
        Integer num = (Integer) kVar.a(v4.g2);
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleHorizontal);
        this.V = progressBar;
        a(progressBar, bVar.t0(), num.intValue());
        a1Var.a("PROGRESS_BAR", l.longValue(), new b(num));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        com.applovin.impl.a aVar = this.Q;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        com.applovin.impl.a aVar = this.Q;
        if (aVar != null) {
            aVar.a();
            final com.applovin.impl.a aVar2 = this.Q;
            Objects.requireNonNull(aVar2);
            a(new Runnable() { // from class: com.applovin.impl.z1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    aVar2.b();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        this.n0 = -1L;
        this.o0 = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        com.applovin.impl.a aVar = this.Q;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        this.q = SystemClock.elapsedRealtime();
    }

    private void L() {
        com.applovin.impl.adview.l lVar;
        a8 a8VarL0 = this.f715a.l0();
        if (a8VarL0 == null || !a8VarL0.j() || this.j0 || (lVar = this.U) == null) {
            return;
        }
        final boolean z = lVar.getVisibility() == 4;
        final long jH = a8VarL0.h();
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.z1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(z, jH);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.j0) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.k("AppLovinFullscreenActivity", "Skip video resume - postitial shown");
                return;
            }
            return;
        }
        if (this.b.n0().isApplicationPaused()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.k("AppLovinFullscreenActivity", "Skip video resume - app paused");
            }
        } else {
            if (this.i0 < 0) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a("AppLovinFullscreenActivity", "Invalid last video position");
                    return;
                }
                return;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a("AppLovinFullscreenActivity", "Resuming video at position " + this.i0 + "ms for MediaPlayer: " + this.N);
            }
            this.P.seekTo(this.i0);
            AppLovinVideoBridge.VideoViewPlay(this.P);
            this.c0.b();
            this.i0 = -1;
            a(new Runnable() { // from class: com.applovin.impl.z1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.H();
                }
            }, 250L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.m0.compareAndSet(false, true)) {
            a(this.R, this.f715a.n0(), new Runnable() { // from class: com.applovin.impl.z1$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.I();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    private void e(boolean z) {
        if (o0.e()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.d.getDrawable(z ? com.applovin.sdk.R.drawable.applovin_ic_unmute_to_mute : com.applovin.sdk.R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.T.setScaleType(ImageView.ScaleType.FIT_XY);
                this.T.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        ImageViewUtils.setImageUri(this.T, z ? this.f715a.Q() : this.f715a.i0(), this.b);
    }

    private void f(boolean z) {
        this.h0 = B();
        if (z) {
            this.P.pause();
        } else {
            AppLovinVideoBridge.VideoViewStop(this.P);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(String str) {
        l8.a(this.U, str, "AppLovinFullscreenActivity", this.b);
    }

    protected int B() {
        long currentPosition = this.P.getCurrentPosition();
        if (this.k0) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((currentPosition / this.g0) * 100.0f) : this.h0;
    }

    public void C() {
        this.y++;
        if (this.f715a.E()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a("AppLovinFullscreenActivity", "Dismissing ad on video skip...");
            }
            a("video_skip");
        } else {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a("AppLovinFullscreenActivity", "Skipping video...");
            }
            R();
        }
    }

    protected void D() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.z1$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.G();
            }
        });
    }

    protected boolean E() {
        if (this.J && this.f715a.n1()) {
            return true;
        }
        return F();
    }

    protected boolean F() {
        return B() >= this.f715a.p0();
    }

    protected void N() {
        long jZ;
        long millis;
        if (this.f715a.Y() >= 0 || this.f715a.Z() >= 0) {
            if (this.f715a.Y() >= 0) {
                jZ = this.f715a.Y();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.f715a;
                long j = this.g0;
                long j2 = j > 0 ? j : 0L;
                if (aVar.j1()) {
                    int iT1 = (int) ((com.applovin.impl.sdk.ad.a) this.f715a).t1();
                    if (iT1 > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iT1);
                    } else {
                        int iS = (int) aVar.s();
                        if (iS > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iS);
                        }
                    }
                    j2 += millis;
                }
                jZ = (long) (j2 * (((double) this.f715a.Z()) / 100.0d));
            }
            c(jZ);
        }
    }

    protected boolean P() {
        return (this.v || this.j0 || !this.P.isPlaying()) ? false : true;
    }

    protected void Q() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.z1$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.J();
            }
        });
    }

    public void R() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Showing postitial...");
        }
        f(this.f715a.q1());
        long jW = this.f715a.W();
        if (jW > 0) {
            this.r = 0L;
            Long l = (Long) this.b.a(v4.n2);
            Integer num = (Integer) this.b.a(v4.q2);
            ProgressBar progressBar = new ProgressBar(this.d, null, R.attr.progressBarStyleHorizontal);
            this.W = progressBar;
            a(progressBar, this.f715a.V(), num.intValue());
            this.d0.a("POSTITIAL_PROGRESS_BAR", l.longValue(), new c(jW, num, l));
            this.d0.b();
        }
        this.M.a(this.k, this.j, this.i, this.W);
        a("javascript:al_onPoststitialShow(" + this.y + StringUtils.COMMA + this.z + ");", this.f715a.H());
        if (this.k != null) {
            if (this.f715a.s() >= 0) {
                a(this.k, this.f715a.s(), new Runnable() { // from class: com.applovin.impl.z1$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.K();
                    }
                });
            } else {
                this.k.setVisibility(0);
            }
        }
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.g gVar = this.k;
        if (gVar != null) {
            arrayList.add(new e4(gVar, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        com.applovin.impl.adview.k kVar = this.j;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.j;
            arrayList.add(new e4(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        ProgressBar progressBar2 = this.W;
        if (progressBar2 != null) {
            arrayList.add(new e4(progressBar2, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        this.f715a.getAdEventTracker().b(this.i, arrayList);
        o();
        this.j0 = true;
    }

    public void S() {
        this.n0 = SystemClock.elapsedRealtime() - this.o0;
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.n0 + "ms");
        }
        C();
    }

    protected void T() {
        MediaPlayer mediaPlayer = this.N;
        if (mediaPlayer == null) {
            return;
        }
        try {
            float f2 = this.f0 ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f2, f2);
            boolean z = !this.f0;
            this.f0 = z;
            e(z);
            a(this.f0, 0L);
        } catch (Throwable unused) {
        }
    }

    protected void d(long j) {
        this.g0 = j;
    }

    protected void g(String str) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.f715a);
        }
        if (this.l0.compareAndSet(false, true)) {
            if (((Boolean) this.b.a(v4.O0)).booleanValue()) {
                this.b.H().d(this.f715a, com.applovin.impl.sdk.k.o());
            }
            AppLovinAdDisplayListener appLovinAdDisplayListener = this.F;
            if (appLovinAdDisplayListener instanceof k2) {
                ((k2) appLovinAdDisplayListener).onAdDisplayFailed(str);
            }
            String str2 = this.f715a instanceof l7 ? "handleVastVideoError" : "handleVideoError";
            this.b.E().a(str2, str, this.f715a);
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("source", str2);
            CollectionUtils.putStringIfValid("error_message", str, mapHashMap);
            this.b.g().a(c2.s, this.f715a, mapHashMap);
            a("media_error");
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "FullscreenVideoAdPresenter";
    }

    @Override // com.applovin.impl.v1
    protected void l() {
        super.a(B(), this.e0, E(), this.n0);
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            if (messageData.getLong(CreativeInfo.c) == this.f715a.getAdIdNumber() && this.e0) {
                int i = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string == null && !r0.a(i)) || this.k0 || this.P.isPlaying()) {
                    return;
                }
                g("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
            }
        }
    }

    @Override // com.applovin.impl.v1
    public void q() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "Destroying video components");
        }
        try {
            if (((Boolean) this.b.a(v4.j6)).booleanValue()) {
                l8.b(this.U);
                this.U = null;
            }
            if (this.e0) {
                AppLovinCommunicator.getInstance(this.d).unsubscribe(this, "video_caching_failed");
            }
            AppLovinVideoView appLovinVideoView = this.P;
            if (appLovinVideoView != null) {
                appLovinVideoView.pause();
                AppLovinVideoBridge.VideoViewStop(this.P);
            }
            MediaPlayer mediaPlayer = this.N;
            if (mediaPlayer != null) {
                AppLovinVideoBridge.MediaPlayerRelease(mediaPlayer);
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("AppLovinFullscreenActivity", "Unable to destroy presenter", th);
        }
        super.q();
    }

    @Override // com.applovin.impl.v1
    public void u() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Pausing video");
        }
        this.i0 = this.P.getCurrentPosition();
        this.P.pause();
        this.c0.c();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Paused video at position " + this.i0 + "ms");
        }
    }

    @Override // com.applovin.impl.v1
    public void v() {
        a((ViewGroup) null);
    }

    @Override // com.applovin.impl.v1
    protected void z() {
        this.M.a(this.l);
        this.q = SystemClock.elapsedRealtime();
    }

    @Override // com.applovin.impl.v1
    public void b(boolean z) {
        super.b(z);
        if (z) {
            b(0L);
            if (this.j0) {
                this.d0.b();
                return;
            }
            return;
        }
        if (this.j0) {
            this.d0.c();
        } else {
            u();
        }
    }

    @Override // com.applovin.impl.v1
    public void d() {
        super.d();
        z();
    }

    @Override // com.applovin.impl.v1
    public void a(ViewGroup viewGroup) {
        String str;
        this.M.a(this.T, this.R, this.U, this.Q, this.V, this.S, this.P, this.O, this.i, this.j, this.X, viewGroup);
        if (o0.h() && (str = this.b.o0().getExtraParameters().get("audio_focus_request")) != null) {
            this.P.setAudioFocusRequest(Integer.parseInt(str));
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (((Boolean) this.b.a(v4.L5)).booleanValue() || !a(!this.e0)) {
            AppLovinVideoBridge.VideoViewSetVideoUri(this.P, this.f715a.v0());
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            com.applovin.impl.adview.k kVar = this.j;
            if (kVar != null) {
                kVar.b();
            }
            AppLovinVideoBridge.VideoViewPlay(this.P);
            if (this.e0) {
                Q();
            }
            SpecialsBridge.appLovinAdViewRenderAd(this.i, this.f715a);
            if (this.R != null) {
                this.b.r0().a(new p6(this.b, "scheduleSkipButton", new Runnable() { // from class: com.applovin.impl.z1$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.O();
                    }
                }), b6.b.TIMEOUT, this.f715a.o0(), true);
            }
            super.c(this.f0);
        }
    }

    @Override // com.applovin.impl.v1
    public void e() {
        super.e();
        this.M.a(this.U);
        this.M.a((View) this.R);
        if (!g() || this.j0) {
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z, long j) {
        if (z) {
            b8.a(this.U, j, (Runnable) null);
        } else {
            b8.b(this.U, j, null);
        }
    }

    @Override // com.applovin.impl.v1
    public void b(long j) {
        a(new Runnable() { // from class: com.applovin.impl.z1$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.M();
            }
        }, j);
    }

    @Override // com.applovin.impl.v1
    protected void a(final String str, long j) {
        super.a(str, j);
        if (this.U == null || j < 0 || !com.applovin.impl.sdk.utils.StringUtils.isValidString(str)) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.z1$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.h(str);
            }
        }, j);
    }

    private void a(ProgressBar progressBar, int i, int i2) {
        progressBar.setMax(i2);
        progressBar.setPadding(0, 0, 0, 0);
        if (o0.e()) {
            progressBar.setProgressTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // com.applovin.impl.v1
    public void a(String str) {
        this.c0.a();
        this.d0.a();
        this.a0.removeCallbacksAndMessages(null);
        this.b0.removeCallbacksAndMessages(null);
        if (!((Boolean) this.b.a(v4.D6)).booleanValue()) {
            com.applovin.impl.sdk.ad.b bVar = this.f715a;
            if (bVar != null) {
                bVar.a(str);
            }
            l();
        }
        super.a(str);
    }

    protected void a(MotionEvent motionEvent, Bundle bundle) {
        Context context;
        if (this.f715a.N0()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a("AppLovinFullscreenActivity", "Clicking through video");
            }
            Uri uriM0 = this.f715a.m0();
            if (uriM0 != null) {
                if (!((Boolean) this.b.a(v4.x)).booleanValue() || (context = this.d) == null) {
                    AppLovinAdView appLovinAdView = this.i;
                    context = appLovinAdView != null ? appLovinAdView.getContext() : com.applovin.impl.sdk.k.o();
                }
                this.b.k().trackAndLaunchVideoClick(this.f715a, uriM0, motionEvent, bundle, this, context);
                q2.a(this.E, this.f715a);
                this.z++;
                return;
            }
            return;
        }
        L();
    }

    private static boolean a(boolean z, com.applovin.impl.sdk.k kVar) {
        if (!((Boolean) kVar.a(v4.X1)).booleanValue()) {
            return false;
        }
        if (!((Boolean) kVar.a(v4.Y1)).booleanValue() || z) {
            return true;
        }
        return ((Boolean) kVar.a(v4.a2)).booleanValue();
    }
}
