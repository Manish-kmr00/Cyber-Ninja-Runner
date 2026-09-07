package com.five_corp.ad.internal.movie;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.LINEVideoBridge;
import com.safedk.android.utils.Logger;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public final class E implements G, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.view.E f1429a;
    public final com.five_corp.ad.internal.cache.o b;
    public final com.five_corp.ad.internal.view.B c;
    public final M d;
    public final Handler e;
    public int g;
    public MediaPlayer h;
    public boolean j;
    public int k;
    public int l;
    public final Object f = new Object();
    public int i = 0;

    public E(com.five_corp.ad.internal.view.E e, com.five_corp.ad.internal.cache.o oVar, com.five_corp.ad.internal.view.B b, TextureView textureView, com.five_corp.ad.internal.logger.a aVar) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.e = handler;
        this.f1429a = e;
        this.b = oVar;
        this.c = b;
        M m = new M(textureView, aVar);
        this.d = m;
        synchronized (m.b) {
            m.g = false;
            m.e = this;
            m.f = handler;
        }
        this.k = 0;
        this.j = true;
        this.g = 1;
        this.l = 0;
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final int a() {
        synchronized (this.f) {
            if (this.g != 7) {
                return this.i;
            }
            return this.h.getCurrentPosition();
        }
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void b() {
        synchronized (this.f) {
            if (this.g == 10) {
                return;
            }
            this.i = 0;
            this.g = 1;
            release();
            prepare();
        }
    }

    @Override // com.five_corp.ad.internal.movie.L
    public final void c() {
        release();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        Logger.d("LINE|SafeDK: Execution> Lcom/five_corp/ad/internal/movie/E;->onCompletion(Landroid/media/MediaPlayer;)V");
        CreativeInfoManager.onVideoCompleted("com.five_corp.ad", mediaPlayer, "media-player");
        safedk_E_onCompletion_409e81be46579913634b87bb3c63385e(mediaPlayer);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        int i3;
        if (i == -38 && i2 == 0 && (i3 = this.l) < 3) {
            this.l = i3 + 1;
            release();
            prepare();
        } else {
            this.e.post(new y(this, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.l0, String.format("what: %d, extra: %d, retry: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.l)), null, null)));
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002d  */
    /* JADX WARN: Code duplicated, block: B:19:0x0030  */
    /* JADX WARN: Code duplicated, block: B:22:0x0036  */
    /* JADX WARN: Code duplicated, block: B:23:0x0046 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0048  */
    /* JADX WARN: Code duplicated, block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        int i;
        int i2;
        float f;
        int duration = mediaPlayer.getDuration();
        synchronized (this.f) {
            this.k = duration;
            this.h = mediaPlayer;
            boolean z = this.j;
            int iA = com.five_corp.ad.e.a(this.g);
            if (iA != 0) {
                switch (iA) {
                    case 2:
                        i = 8;
                        this.g = i;
                        i2 = this.g;
                        mediaPlayer.seekTo(this.i);
                        if (z) {
                            f = 1.0f;
                        } else {
                            f = 0.0f;
                        }
                        mediaPlayer.setVolume(f, f);
                        if (i2 == 7) {
                            LINEVideoBridge.MediaPlayerStart(mediaPlayer);
                            com.five_corp.ad.internal.view.B b = this.c;
                            b.e.post(new com.five_corp.ad.internal.view.w(b));
                            return;
                        } else {
                            if (i2 == 8) {
                                this.e.post(new z(this));
                                return;
                            }
                            return;
                        }
                    case 3:
                        return;
                    case 4:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        break;
                    case 5:
                        i = 7;
                        this.g = i;
                        i2 = this.g;
                        mediaPlayer.seekTo(this.i);
                        if (z) {
                            f = 1.0f;
                        } else {
                            f = 0.0f;
                        }
                        mediaPlayer.setVolume(f, f);
                        if (i2 == 7) {
                            LINEVideoBridge.MediaPlayerStart(mediaPlayer);
                            com.five_corp.ad.internal.view.B b2 = this.c;
                            b2.e.post(new com.five_corp.ad.internal.view.w(b2));
                            return;
                        } else {
                            if (i2 == 8) {
                                this.e.post(new z(this));
                                return;
                            }
                            return;
                        }
                    default:
                        i2 = this.g;
                        mediaPlayer.seekTo(this.i);
                        if (z) {
                            f = 1.0f;
                        } else {
                            f = 0.0f;
                        }
                        mediaPlayer.setVolume(f, f);
                        if (i2 == 7) {
                            LINEVideoBridge.MediaPlayerStart(mediaPlayer);
                            com.five_corp.ad.internal.view.B b3 = this.c;
                            b3.e.post(new com.five_corp.ad.internal.view.w(b3));
                            return;
                        } else {
                            if (i2 == 8) {
                                this.e.post(new z(this));
                                return;
                            }
                            return;
                        }
                }
            }
            D.a(this.g);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // com.five_corp.ad.internal.movie.G
    public final void pause() {
        int i;
        int i2;
        synchronized (this.f) {
            MediaPlayer mediaPlayer = this.h;
            int iA = com.five_corp.ad.e.a(this.g);
            if (iA != 0) {
                switch (iA) {
                    case 3:
                    case 7:
                    case 8:
                    case 9:
                        break;
                    case 4:
                    case 5:
                        i = 4;
                        this.g = i;
                        i2 = this.g;
                        if (i2 == 8) {
                            this.i = mediaPlayer.getCurrentPosition();
                            LINEVideoBridge.MediaPlayerPause(mediaPlayer);
                        }
                        com.five_corp.ad.internal.view.B b = this.c;
                        b.e.post(new com.five_corp.ad.internal.view.x(b));
                        this.e.post(new C(this));
                        return;
                    case 6:
                        i = 8;
                        this.g = i;
                        i2 = this.g;
                        if (i2 == 8) {
                            this.i = mediaPlayer.getCurrentPosition();
                            LINEVideoBridge.MediaPlayerPause(mediaPlayer);
                        }
                        com.five_corp.ad.internal.view.B b2 = this.c;
                        b2.e.post(new com.five_corp.ad.internal.view.x(b2));
                        this.e.post(new C(this));
                        return;
                    default:
                        i2 = this.g;
                        if (i2 == 8) {
                            this.i = mediaPlayer.getCurrentPosition();
                            LINEVideoBridge.MediaPlayerPause(mediaPlayer);
                        }
                        com.five_corp.ad.internal.view.B b3 = this.c;
                        b3.e.post(new com.five_corp.ad.internal.view.x(b3));
                        this.e.post(new C(this));
                        return;
                }
            }
        }
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void prepare() {
        synchronized (this.f) {
            int i = this.g;
            if (i != 1) {
                D.a(i);
            } else {
                this.g = 2;
                this.d.b();
            }
        }
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void release() {
        Logger.d("LINE|SafeDK: Execution> Lcom/five_corp/ad/internal/movie/E;->release()V");
        CreativeInfoManager.onVideoCompleted("com.five_corp.ad", "line exo-player");
        safedk_E_release_2450be4a323d93c97d3d853809551bb2();
    }

    public void safedk_E_onCompletion_409e81be46579913634b87bb3c63385e(MediaPlayer p0) {
        synchronized (this.f) {
            this.i = this.k;
            this.g = 9;
        }
        com.five_corp.ad.internal.view.B b = this.c;
        b.e.post(new com.five_corp.ad.internal.view.y(b));
        this.d.a();
        this.e.post(new A(this));
    }

    public void safedk_E_release_2450be4a323d93c97d3d853809551bb2() {
        MediaPlayer mediaPlayer;
        int i;
        int i2;
        synchronized (this.f) {
            mediaPlayer = this.h;
            i = this.g;
            this.h = null;
            switch (com.five_corp.ad.e.a(i)) {
                case 1:
                case 2:
                    i2 = 2;
                    this.g = i2;
                    break;
                case 3:
                case 7:
                    i2 = 4;
                    this.g = i2;
                    break;
                case 4:
                case 5:
                case 6:
                    i2 = 5;
                    this.g = i2;
                    break;
            }
        }
        if (mediaPlayer == null) {
            return;
        }
        int currentPosition = i == 7 ? mediaPlayer.getCurrentPosition() : 0;
        LINEVideoBridge.MediaPlayerSetSurface(mediaPlayer, null);
        mediaPlayer.reset();
        LINEVideoBridge.MediaPlayerRelease(mediaPlayer);
        if (i == 7) {
            synchronized (this.f) {
                this.i = currentPosition;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x001f  */
    /* JADX WARN: Code duplicated, block: B:18:0x002f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0031  */
    /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
    public void safedk_E_start_19a09ccbbc54639d91695a8f34cdca1d() {
        int i;
        int i2;
        synchronized (this.f) {
            MediaPlayer mediaPlayer = this.h;
            int iA = com.five_corp.ad.e.a(this.g);
            if (iA != 0) {
                switch (iA) {
                    case 3:
                        i = 5;
                        this.g = i;
                        i2 = this.g;
                        if (i2 == 5) {
                            this.d.b();
                            this.e.post(new B(this));
                            return;
                        } else {
                            if (i2 == 7) {
                                LINEVideoBridge.MediaPlayerStart(mediaPlayer);
                                com.five_corp.ad.internal.view.B b = this.c;
                                b.e.post(new com.five_corp.ad.internal.view.w(b));
                                this.e.post(new B(this));
                                return;
                            }
                            return;
                        }
                    case 4:
                    case 5:
                    case 6:
                        return;
                    case 7:
                        i = 7;
                        this.g = i;
                        i2 = this.g;
                        if (i2 == 5) {
                            this.d.b();
                            this.e.post(new B(this));
                            return;
                        } else {
                            if (i2 == 7) {
                                LINEVideoBridge.MediaPlayerStart(mediaPlayer);
                                com.five_corp.ad.internal.view.B b2 = this.c;
                                b2.e.post(new com.five_corp.ad.internal.view.w(b2));
                                this.e.post(new B(this));
                                return;
                            }
                            return;
                        }
                    case 8:
                    case 9:
                        break;
                    default:
                        i2 = this.g;
                        if (i2 == 5) {
                            this.d.b();
                            this.e.post(new B(this));
                            return;
                        } else {
                            if (i2 == 7) {
                                LINEVideoBridge.MediaPlayerStart(mediaPlayer);
                                com.five_corp.ad.internal.view.B b3 = this.c;
                                b3.e.post(new com.five_corp.ad.internal.view.w(b3));
                                this.e.post(new B(this));
                                return;
                            }
                            return;
                        }
                }
            }
            D.a(this.g);
        }
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void start() {
        Logger.d("LINE|SafeDK: Execution> Lcom/five_corp/ad/internal/movie/E;->start()V");
        CreativeInfoManager.onVideoStart("com.five_corp.ad", this, "line exo-player");
        safedk_E_start_19a09ccbbc54639d91695a8f34cdca1d();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0041 A[Catch: IllegalStateException -> 0x006b, IOException -> 0x007e, TryCatch #4 {IOException -> 0x007e, IllegalStateException -> 0x006b, blocks: (B:17:0x0023, B:19:0x0041, B:21:0x0055, B:22:0x0063, B:28:0x006a), top: B:41:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0055 A[Catch: IllegalStateException -> 0x006b, IOException -> 0x007e, TryCatch #4 {IOException -> 0x007e, IllegalStateException -> 0x006b, blocks: (B:17:0x0023, B:19:0x0041, B:21:0x0055, B:22:0x0063, B:28:0x006a), top: B:41:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.five_corp.ad.internal.movie.L
    public final void a(Surface surface) {
        MediaPlayer mediaPlayer;
        com.five_corp.ad.internal.util.g gVarE;
        synchronized (this.f) {
            this.h = null;
            int i = 6;
            switch (com.five_corp.ad.e.a(this.g)) {
                case 0:
                case 3:
                case 8:
                case 9:
                    return;
                case 1:
                case 2:
                    i = 3;
                    this.g = i;
                    try {
                        mediaPlayer = new MediaPlayer();
                        LINEVideoBridge.MediaPlayerSetSurface(mediaPlayer, surface);
                        mediaPlayer.setOnInfoListener(this);
                        mediaPlayer.setOnPreparedListener(this);
                        mediaPlayer.setOnCompletionListener(this);
                        mediaPlayer.setOnErrorListener(this);
                        gVarE = this.b.e();
                        if (!gVarE.f1560a) {
                            this.e.post(new y(this, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.o0, null, null, gVarE.b)));
                            return;
                        }
                        LINEVideoBridge.MediaPlayerSetDataSource(mediaPlayer, this.b.c());
                        mediaPlayer.prepareAsync();
                        synchronized (this.f) {
                            this.h = mediaPlayer;
                            break;
                        }
                        return;
                    } catch (IOException e) {
                        this.e.post(new y(this, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.j0, null, e, null)));
                        return;
                    } catch (IllegalStateException e2) {
                        this.e.post(new y(this, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.k0, null, e2, null)));
                        return;
                    }
                case 4:
                    this.g = i;
                    mediaPlayer = new MediaPlayer();
                    LINEVideoBridge.MediaPlayerSetSurface(mediaPlayer, surface);
                    mediaPlayer.setOnInfoListener(this);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.setOnCompletionListener(this);
                    mediaPlayer.setOnErrorListener(this);
                    gVarE = this.b.e();
                    if (!gVarE.f1560a) {
                        this.e.post(new y(this, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.o0, null, null, gVarE.b)));
                        return;
                    }
                    LINEVideoBridge.MediaPlayerSetDataSource(mediaPlayer, this.b.c());
                    mediaPlayer.prepareAsync();
                    synchronized (this.f) {
                        this.h = mediaPlayer;
                        return;
                    }
                case 5:
                case 6:
                    D.a(this.g);
                    this.g = i;
                    mediaPlayer = new MediaPlayer();
                    LINEVideoBridge.MediaPlayerSetSurface(mediaPlayer, surface);
                    mediaPlayer.setOnInfoListener(this);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.setOnCompletionListener(this);
                    mediaPlayer.setOnErrorListener(this);
                    gVarE = this.b.e();
                    if (!gVarE.f1560a) {
                        this.e.post(new y(this, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.o0, null, null, gVarE.b)));
                        return;
                    }
                    LINEVideoBridge.MediaPlayerSetDataSource(mediaPlayer, this.b.c());
                    mediaPlayer.prepareAsync();
                    synchronized (this.f) {
                        this.h = mediaPlayer;
                        return;
                    }
                case 7:
                    this.g = 4;
                    return;
                default:
                    mediaPlayer = new MediaPlayer();
                    LINEVideoBridge.MediaPlayerSetSurface(mediaPlayer, surface);
                    mediaPlayer.setOnInfoListener(this);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.setOnCompletionListener(this);
                    mediaPlayer.setOnErrorListener(this);
                    gVarE = this.b.e();
                    if (!gVarE.f1560a) {
                        this.e.post(new y(this, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.o0, null, null, gVarE.b)));
                        return;
                    }
                    LINEVideoBridge.MediaPlayerSetDataSource(mediaPlayer, this.b.c());
                    mediaPlayer.prepareAsync();
                    synchronized (this.f) {
                        this.h = mediaPlayer;
                        return;
                    }
            }
        }
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void a(boolean z) {
        synchronized (this.f) {
            MediaPlayer mediaPlayer = this.h;
            this.j = z;
            int i = this.g;
            if (i == 8 || i == 7) {
                float f = z ? 1.0f : 0.0f;
                mediaPlayer.setVolume(f, f);
            }
        }
    }
}
