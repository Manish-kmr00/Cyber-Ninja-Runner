package sg.bigo.ads.core.player.b;

import android.media.MediaPlayer;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes5.dex */
public final class c implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    static final AtomicBoolean h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MediaPlayer f13697a;
    String b;
    a c;
    boolean e;
    boolean f;
    private Surface j;
    private long k;
    private boolean m;
    int d = 0;
    final Runnable g = new Runnable() { // from class: sg.bigo.ads.core.player.b.c.1
        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.c != null) {
                c.this.c.i();
            }
            if (c.this.d == 3 || c.this.d == 4 || c.this.d == 5) {
                return;
            }
            sg.bigo.ads.common.n.d.a(2, c.this.g, 500L);
        }
    };
    private boolean l = false;
    int i = 0;

    public interface a {
        void a(int i, String str, int i2);

        void a(MediaPlayer mediaPlayer, int i);

        boolean a(int i);

        boolean a(int i, int i2);

        void e_();

        void f();

        void g();

        void h();

        void i();

        void j();

        void k();
    }

    public c() {
        this.m = false;
        this.m = i.f13093a.n().a(3);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        try {
            if (!this.f) {
                sg.bigo.ads.common.t.a.b("MediaPlayerWrapper", "Surface is not available, setDataSource cancel");
                return false;
            }
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "player setDataSource, path = ".concat(String.valueOf(str)));
            this.f13697a.reset();
            this.f13697a.setDataSource(str);
            return true;
        } catch (Exception e) {
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "Player setDataSource failed");
            if (this.c != null) {
                if (h()) {
                    sg.bigo.ads.common.t.a.b("MediaPlayerWrapper", "setDataSource called onError");
                    this.c.a(1, -1004);
                }
                this.c.a(9, Log.getStackTraceString(e), this.i);
            }
            b(9);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f13697a = new MediaPlayer();
        h.set(false);
        this.f13697a.setOnCompletionListener(this);
        this.f13697a.setOnErrorListener(this);
        this.f13697a.setOnInfoListener(this);
        this.f13697a.setOnPreparedListener(this);
        this.f13697a.setOnVideoSizeChangedListener(this);
        this.f13697a.setOnBufferingUpdateListener(this);
    }

    private boolean h() {
        return !this.m || this.i >= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        try {
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "prepareAsync");
            this.k = SystemClock.elapsedRealtime();
            this.f13697a.prepareAsync();
            return true;
        } catch (Exception e) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(10, Log.getStackTraceString(e), this.i);
            }
            b(10);
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "Player prepareAsync failed");
            return false;
        }
    }

    public final void a(Surface surface) {
        try {
            this.j = surface;
            this.f13697a.setSurface(surface);
            this.f = true;
        } catch (Exception e) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(12, Log.getStackTraceString(e), this.i);
            }
            b(12);
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "setSurface IllegalStateException");
        }
    }

    public final void a(final String str) {
        if (q.a((CharSequence) str)) {
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "invalidate file path, set data source failed");
        } else {
            this.b = str;
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.b.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.b(str)) {
                        c.this.i();
                    }
                }
            });
        }
    }

    public final boolean a() {
        try {
            if (this.e && this.f) {
                if (this.f13697a.isPlaying()) {
                    sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "startAd but is playing, return.");
                    return true;
                }
                this.f13697a.start();
                if (!this.l) {
                    this.l = true;
                    a aVar = this.c;
                    if (aVar != null) {
                        aVar.e_();
                    }
                }
                this.d = 2;
                sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "startAd play called ");
                sg.bigo.ads.common.n.d.a(this.g);
                sg.bigo.ads.common.n.d.a(2, this.g);
                a aVar2 = this.c;
                if (aVar2 != null) {
                    aVar2.f();
                }
                return true;
            }
            sg.bigo.ads.common.t.a.b("MediaPlayerWrapper", "Surface is not available or player unprepared, do start play cancel");
            return false;
        } catch (IllegalStateException e) {
            a aVar3 = this.c;
            if (aVar3 != null) {
                aVar3.a(3, Log.getStackTraceString(e), this.i);
            }
            sg.bigo.ads.common.t.a.a(1, "MediaPlayerWrapper", "Failed to play video: " + e.getMessage());
            return false;
        }
    }

    public final boolean a(int i) {
        try {
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "seekTo : ".concat(String.valueOf(i)));
            this.f13697a.seekTo(i);
            return true;
        } catch (IllegalStateException e) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(1, Log.getStackTraceString(e), this.i);
            }
            sg.bigo.ads.common.t.a.a(1, "MediaPlayerWrapper", "The video failed to seek:" + e.getMessage());
            return false;
        }
    }

    public final boolean a(boolean z) {
        try {
            if (z) {
                this.f13697a.setVolume(0.0f, 0.0f);
            } else {
                this.f13697a.setVolume(1.0f, 1.0f);
            }
        } catch (IllegalStateException e) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(14, Log.getStackTraceString(e), this.i);
            }
            sg.bigo.ads.common.t.a.a(1, "MediaPlayerWrapper", "The video failed to set volume: " + e.getMessage());
        }
        return z;
    }

    public final void b(final int i) {
        if (!this.m) {
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "createMediaPlayerWhenException switch is off");
            return;
        }
        int i2 = this.i;
        if (i2 >= 3) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(i, "retry times has reached limit", i2);
            }
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "createMediaPlayer times reach the limit(3 times), stop creating");
            return;
        }
        this.i = i2 + 1;
        sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "start to create mediaPlayer, retry time: " + this.i);
        e();
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.core.player.b.c.3
            @Override // java.lang.Runnable
            public final void run() {
                c.this.g();
                int i3 = i;
                if (i3 != 9 && i3 != 10) {
                    if (i3 == 12) {
                        c cVar = c.this;
                        cVar.a(cVar.j);
                        return;
                    } else if (i3 != 15) {
                        return;
                    }
                }
                c cVar2 = c.this;
                cVar2.a(cVar2.j);
                c cVar3 = c.this;
                cVar3.a(cVar3.b);
            }
        });
    }

    public final boolean b() {
        try {
            this.f13697a.pause();
            sg.bigo.ads.common.n.d.a(this.g);
            this.d = 3;
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "pauseAd play");
            a aVar = this.c;
            if (aVar != null) {
                aVar.g();
            }
            return true;
        } catch (IllegalStateException e) {
            a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.a(4, Log.getStackTraceString(e), this.i);
            }
            sg.bigo.ads.common.t.a.a(1, "MediaPlayerWrapper", "Failed to pause video: " + e.getMessage());
            return false;
        }
    }

    public final int c() {
        try {
            if (this.e) {
                return this.f13697a.getCurrentPosition();
            }
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "getCurrentPosition failed，not initialize or release already");
            return 0;
        } catch (IllegalStateException e) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(5, Log.getStackTraceString(e), this.i);
            }
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "getCurrentPosition IllegalStateException");
            return 0;
        }
    }

    public final boolean d() {
        try {
            this.f13697a.stop();
            sg.bigo.ads.common.n.d.a(this.g);
            this.d = 4;
            sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "stop play");
            a aVar = this.c;
            if (aVar != null) {
                aVar.h();
            }
            return true;
        } catch (IllegalStateException e) {
            a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.a(6, Log.getStackTraceString(e), this.i);
            }
            sg.bigo.ads.common.t.a.a(1, "MediaPlayerWrapper", "Failed to stop video: " + e.getMessage());
            return false;
        }
    }

    public final void e() {
        try {
            this.f13697a.release();
            h.set(true);
            sg.bigo.ads.common.n.d.a(this.g);
        } catch (IllegalStateException e) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(7, Log.getStackTraceString(e), this.i);
            }
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "player release IllegalStateException");
        }
        this.d = 0;
        this.e = false;
        sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "player release called");
    }

    public final int f() {
        try {
            if (this.e) {
                return this.f13697a.getDuration();
            }
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "getDuration failed，not initialize or release already");
            return 0;
        } catch (IllegalStateException e) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(8, Log.getStackTraceString(e), this.i);
            }
            sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "getDuration IllegalStateException");
            return 0;
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "onBufferingUpdate percent = ".concat(String.valueOf(i)));
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        sg.bigo.ads.common.n.d.a(this.g);
        a aVar = this.c;
        if (aVar != null) {
            this.d = 5;
            aVar.j();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        a aVar;
        if (h() && (aVar = this.c) != null) {
            return aVar.a(i, i2);
        }
        sg.bigo.ads.common.n.d.a(this.g);
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a(i);
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (!this.f) {
            sg.bigo.ads.common.t.a.b("MediaPlayerWrapper", "Surface is not available, do prepare cancel");
            return;
        }
        this.d = 1;
        this.e = true;
        sg.bigo.ads.common.t.a.a(0, 3, "MediaPlayerWrapper", "onPrepared called cost = " + (SystemClock.elapsedRealtime() - this.k));
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(mediaPlayer, this.i);
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.k();
        }
    }
}
