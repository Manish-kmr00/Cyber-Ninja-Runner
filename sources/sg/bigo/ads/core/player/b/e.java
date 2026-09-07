package sg.bigo.ads.core.player.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.json.b9;
import java.util.HashMap;
import java.util.Objects;
import sg.bigo.ads.R;
import sg.bigo.ads.common.o;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.AdImageView;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends f implements c.a {
    private boolean A;
    private boolean B;
    private boolean C;
    private int D;
    private boolean E;
    private int F;
    private boolean G;
    private long H;
    private String I;
    private String J;
    private boolean K;
    private boolean L;
    private View M;
    private b N;
    private final TextureView.SurfaceTextureListener O;
    private final View.OnClickListener P;
    private Runnable Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13704a;
    private int g;
    private int h;
    private g i;
    private ImageView j;
    private ImageView k;
    private AdImageView l;
    private String m;
    private ProgressBar n;
    private View o;
    private c p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private long v;
    private Runnable w;
    private Runnable x;
    private boolean y;
    private boolean z;

    public e(Context context, int i, int i2, sg.bigo.ads.api.c.b bVar, sg.bigo.ads.core.a.a aVar) {
        super(context, bVar, aVar);
        this.p = new c();
        this.q = 0;
        this.r = 0;
        this.s = true;
        this.y = false;
        this.z = false;
        this.A = true;
        this.B = false;
        this.C = false;
        this.E = false;
        this.H = 0L;
        this.I = "";
        this.J = "";
        this.K = true;
        this.L = false;
        TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: sg.bigo.ads.core.player.b.e.1
            private long b = SystemClock.elapsedRealtime();

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i4) {
                sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onSurfaceTextureAvailable");
                sg.bigo.ads.common.n.d.a(e.this.x);
                e.this.a(13, SystemClock.elapsedRealtime() - this.b, 0);
                e.this.H = SystemClock.elapsedRealtime();
                e.this.p.a(new Surface(surfaceTexture));
                if (e.this.e != null && e.this.e.aY()) {
                    e.this.p.a(e.this.m);
                    e.d(e.this);
                    return;
                }
                sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "real video is not ready, begin to load backup image");
                if (e.this.e == null || e.this.e.bg() == null) {
                    e.g(e.this);
                    return;
                }
                Pair<Bitmap, String> pairBg = e.this.e.bg();
                if (pairBg != null) {
                    e.this.a(pairBg.first);
                    if (e.this.N != null) {
                        e.this.N.a((Bitmap) pairBg.first);
                    }
                }
                e.this.u();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                sg.bigo.ads.common.t.a.b("VideoPlayView", "onSurfaceTextureDestroyed");
                e.this.d(false);
                c cVar = e.this.p;
                try {
                    if (!c.h.get()) {
                        cVar.f13697a.reset();
                    }
                    sg.bigo.ads.common.n.d.a(cVar.g);
                } catch (IllegalStateException e) {
                    if (cVar.c != null) {
                        cVar.c.a(11, Log.getStackTraceString(e), cVar.i);
                    }
                    sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "reset IllegalStateException");
                }
                cVar.f = false;
                cVar.e = false;
                if (!e.this.t) {
                    e.i(e.this);
                    if (e.this.q > 0) {
                        e eVar = e.this;
                        eVar.r = eVar.q;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i4) {
                sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onSurfaceTextureSizeChanged");
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.O = surfaceTextureListener;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: sg.bigo.ads.core.player.b.e.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (view.getId()) {
                    case 200011:
                        e.this.o();
                        break;
                    case 200012:
                        if (!e.this.G || !e.this.C) {
                            e.this.t();
                        }
                        break;
                }
            }
        };
        this.P = onClickListener;
        this.f13704a = 0;
        this.Q = new Runnable() { // from class: sg.bigo.ads.core.player.b.e.5
            @Override // java.lang.Runnable
            public final void run() {
                if (e.this.k != null) {
                    e.this.k.setVisibility(8);
                }
            }
        };
        this.J = aVar != null ? aVar.aS() : "";
        if (aVar != null && aVar.bl() != null) {
            this.I = aVar.bl().b;
        }
        u();
        this.v = bVar.f;
        this.t = bVar.e;
        this.g = i;
        this.h = i2;
        int i3 = bVar.f13096a;
        this.u = bVar.b;
        this.i = new g(this.c, i, i2, i3);
        u.a(this.i, this, null, -1);
        this.i.setSurfaceTextureListener(surfaceTextureListener);
        if (this.e != null && this.e.x() != 2 && w()) {
            sg.bigo.ads.common.n.d.a(this.x);
            if (this.x == null) {
                this.x = new Runnable() { // from class: sg.bigo.ads.core.player.b.e.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.v();
                        sg.bigo.ads.core.d.b.a(e.this.e, e.this.e != null ? e.this.e.aJ() : "", 13, "onSurfaceTextureAvailable not called", 0);
                        e.this.a("AdVideoTooLate", new int[]{10311});
                    }
                };
            }
            sg.bigo.ads.common.n.d.a(2, this.x, this.v);
        }
        if (!bVar.g && this.e != null && !TextUtils.isEmpty(this.e.aM())) {
            a(o.b(getContext().getApplicationContext(), this.e.aM()));
        }
        this.s = this.p.a(bVar.d);
        if (!bVar.c) {
            int iB = sg.bigo.ads.common.utils.a.b(this.c, R.dimen.bigo_ad_volume_padding);
            ImageView imageView = new ImageView(this.c);
            this.j = imageView;
            imageView.setId(200011);
            this.j.setOnClickListener(onClickListener);
            this.j.setPadding(iB, iB, iB, iB);
            this.j.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.c, this.s ? R.drawable.bigo_ad_ic_media_mute : R.drawable.bigo_ad_ic_media_unmute));
            int iB2 = sg.bigo.ads.common.utils.a.b(this.c, R.dimen.bigo_ad_volume_size) + (iB * 2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iB2, iB2, 85);
            layoutParams.rightMargin = iB;
            layoutParams.bottomMargin = iB;
            this.j.setVisibility(0);
            u.a(this.j, this, layoutParams, -1);
        }
        boolean z = this.e != null && this.e.aN();
        this.G = z;
        if (z) {
            x();
        }
        int iB3 = sg.bigo.ads.common.utils.a.b(this.c, R.dimen.bigo_ad_replay_size);
        if (this.e != null && this.e.x() == 2 && sg.bigo.ads.api.c.b.b() > 0) {
            iB3 = sg.bigo.ads.common.utils.e.a(this.c, sg.bigo.ads.api.c.b.b());
        }
        ImageView imageView2 = new ImageView(this.c);
        this.k = imageView2;
        imageView2.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.c, R.drawable.bigo_ad_ic_media_play));
        this.k.setVisibility(this.t ? 0 : 8);
        u.a(this.k, this, new FrameLayout.LayoutParams(iB3, iB3, 17), -1);
        this.p.c = this;
        setId(200012);
        setOnClickListener(onClickListener);
        b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, long j, int i2) {
        sg.bigo.ads.core.d.b.a(this.e, this.e != null ? this.e.aJ() : "", i, j, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> void a(T t) {
        if (t == 0) {
            return;
        }
        if (this.l == null) {
            AdImageView adImageView = new AdImageView(this.c);
            this.l = adImageView;
            adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        u.a(this.l, this, new FrameLayout.LayoutParams(-1, -1, 17), -1);
        boolean z = false;
        if (t instanceof String) {
            String str = (String) t;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.l.setVisibility(0);
            AdImageView adImageView2 = this.l;
            if (this.e != null && this.e.al()) {
                z = true;
            }
            adImageView2.a(str, z);
            return;
        }
        if (t instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) t;
            this.l.setVisibility(0);
            this.l.setImageBitmap(bitmap);
            ImageView imageView = this.j;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            this.i.f13713a = bitmap.getWidth();
            this.i.b = bitmap.getHeight();
            this.i.requestLayout();
        }
    }

    static /* synthetic */ void d(e eVar) {
        if (eVar.w()) {
            sg.bigo.ads.common.n.d.a(eVar.w);
            if (eVar.w == null) {
                eVar.w = new Runnable() { // from class: sg.bigo.ads.core.player.b.e.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.v();
                        e.this.a("AdVideoTooLate", new int[]{10107});
                    }
                };
            }
            sg.bigo.ads.common.n.d.a(2, eVar.w, eVar.v);
        }
    }

    static /* synthetic */ void g(e eVar) {
        if (eVar.o == null) {
            eVar.o = sg.bigo.ads.common.utils.a.a(eVar.getContext(), R.layout.bigo_ad_default_loading_layout, null, false);
        }
        View view = eVar.o;
        if (view != null) {
            u.a(view, eVar, new FrameLayout.LayoutParams(-2, -2, 17), -1);
            eVar.o.setVisibility(0);
        }
    }

    static /* synthetic */ boolean i(e eVar) {
        eVar.z = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        sg.bigo.ads.core.a.a aVar;
        int i;
        if (this.e == null) {
            return;
        }
        Pair<Bitmap, String> pairBg = this.e.bg();
        if (this.e.aY()) {
            aVar = this.e;
            i = 0;
        } else if (pairBg == null) {
            aVar = this.e;
            i = 5;
        } else {
            if (!Objects.equals(pairBg.second, this.I)) {
                if (Objects.equals(pairBg.second, this.J)) {
                    this.e.j(2);
                    return;
                }
                return;
            }
            aVar = this.e;
            i = 1;
        }
        aVar.j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.p.d();
        this.p.e();
    }

    private boolean w() {
        return this.v > 0;
    }

    private void x() {
        Context context = getContext();
        ProgressBar progressBar = new ProgressBar(context);
        this.n = progressBar;
        progressBar.setBackgroundColor(sg.bigo.ads.common.utils.a.c(context, android.R.color.transparent));
        s.a(context, this.n, R.drawable.bigo_ad_progressbar_white);
        this.n.setVisibility(8);
        u.a(this.n, this, new FrameLayout.LayoutParams(-2, -2, 17), -1);
    }

    private void y() {
        if (this.n == null) {
            x();
        }
        this.n.setVisibility(8);
    }

    private void z() {
        if (this.o == null) {
            this.o = sg.bigo.ads.common.utils.a.a(getContext(), R.layout.bigo_ad_default_loading_layout, null, false);
        }
        View view = this.o;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // sg.bigo.ads.api.c.a
    public final void a() {
        if (this.p.e && this.p.b()) {
            this.y = false;
            if (this.G) {
                y();
            }
            this.E = false;
            sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "pauseAd called");
        }
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void a(int i, String str, int i2) {
        sg.bigo.ads.core.d.b.a(this.e, this.e != null ? this.e.aJ() : "", i, str, i2);
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void a(MediaPlayer mediaPlayer, int i) {
        sg.bigo.ads.common.n.d.a(this.w);
        y();
        z();
        boolean z = this.g == 0 && this.h == 0;
        this.g = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.h = videoHeight;
        if (this.L || (z && this.g > 0 && videoHeight > 0)) {
            this.i.f13713a = this.g;
            this.i.b = this.h;
            this.i.requestLayout();
        }
        new HashMap();
        if (this.H > 0) {
            a(10, SystemClock.elapsedRealtime() - this.H, i);
            this.H = 0L;
        }
        if (this.K) {
            b(18);
        }
        if (this.y || w()) {
            this.y = false;
            b();
        } else {
            if (this.z || this.t) {
                return;
            }
            d(true);
        }
    }

    @Override // sg.bigo.ads.core.player.b.f
    public final void a(boolean z) {
        super.a(z);
        this.z = false;
        if (!this.p.e) {
            sg.bigo.ads.common.t.a.b("VideoPlayView", "incorrect status, the player is not prepared".concat(z ? " wating to play" : ", start ad failed"));
            this.y = z;
            int i = this.f13704a;
            if (i < 8) {
                int i2 = i + 1;
                this.f13704a = i2;
                if (i2 == 8) {
                    sg.bigo.ads.core.d.b.a(this.e, 3003, 10107, "Not prepared, src path = " + this.m);
                    return;
                }
                return;
            }
            return;
        }
        if (!sg.bigo.ads.common.aa.b.a(getContext().getApplicationContext())) {
            sg.bigo.ads.common.t.a.b("VideoPlayView", "screen is off, start ad cancel");
            return;
        }
        if (this.p.a()) {
            this.F = getAdDuration();
            if (this.e != null) {
                this.e.j(0);
            }
        }
        AdImageView adImageView = this.l;
        if (adImageView != null) {
            adImageView.setVisibility(8);
        }
        this.k.setVisibility(8);
        d(true);
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final boolean a(int i) {
        sg.bigo.ads.common.t.a.a("VideoPlayView", "onInfo called, whatInfo = ".concat(String.valueOf(i)));
        if (i == 3) {
            sg.bigo.ads.common.t.a.a("VideoPlayView", "player pushed first video frame for rendering, video started");
            AdImageView adImageView = this.l;
            if (adImageView != null) {
                adImageView.setVisibility(8);
            }
            ImageView imageView = this.j;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
        return false;
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final boolean a(int i, int i2) {
        if (i == 100) {
            this.p.e();
            this.p = new c();
        }
        sg.bigo.ads.common.t.a.a(2, "VideoPlayView", "An error occurred during the video playback: ".concat(String.valueOf(i)));
        a("AdError", new int[]{i, i2});
        if (i == -38) {
            sg.bigo.ads.common.t.a.a(0, "VideoPlayView", "onError code = -38, now reset status and init again.Range=" + this.q);
            this.p.a(this.m);
            return true;
        }
        sg.bigo.ads.common.t.a.a(0, "VideoPlayView", "onError code = " + i + ", now reset status and init again.Range=" + this.q);
        if (this.p.c() != 0 || this.p.i >= 3) {
            return true;
        }
        this.p.b(15);
        return true;
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final void b() {
        if (this.z || this.t) {
            sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "tryStartAd, video is completed play, unregister it from list");
            d(false);
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "try start play video ad");
            a(false);
        }
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final boolean c() {
        return this.s;
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final void d() {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "destroy player");
        d(false);
        v();
        setOnEventListener(null);
        this.n = null;
        sg.bigo.ads.common.n.d.a(this.w);
    }

    @Override // sg.bigo.ads.core.player.b.f
    public final boolean e() {
        return this.p.e;
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void e_() {
        a("AdVideoStart", (int[]) null);
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void f() {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onPlay");
        this.t = false;
        int i = this.r;
        if (i > 0) {
            this.p.a(i);
            this.r = -1;
        }
        a("AdVideoPlaying", (int[]) null);
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void g() {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", b9.h.t0);
        a("AdVideoPaused", (int[]) null);
    }

    public final int getAdDuration() {
        return this.p.f();
    }

    public final int getAdRemainingTime() {
        return this.p.c();
    }

    public final ImageView getCoverView() {
        return this.l;
    }

    public final int getCurrentPos() {
        return this.q;
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final int getPlayStatus() {
        return this.p.d;
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void h() {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onStop");
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void i() {
        String str;
        int adRemainingTime = getAdRemainingTime();
        if (this.G && (str = this.m) != null && !str.startsWith("file:")) {
            if (this.D == adRemainingTime) {
                if (!this.E) {
                    if (this.n == null) {
                        x();
                    }
                    this.n.setVisibility(0);
                    sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onBuffering");
                    this.C = true;
                    a("AdVideoBuffering", (int[]) null);
                }
                this.E = true;
            } else {
                if (this.E) {
                    y();
                    sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onBuffered");
                    this.C = false;
                    a("AdVideoBuffered", (int[]) null);
                }
                this.E = false;
            }
            this.D = adRemainingTime;
        }
        if (this.F <= 0) {
            int adDuration = getAdDuration();
            this.F = adDuration;
            if (adDuration <= 0) {
                return;
            }
        }
        int i = this.F;
        if (adRemainingTime > i) {
            adRemainingTime = i;
        }
        this.q = adRemainingTime;
        a("AdRemainingTimeChange", new int[]{adRemainingTime, i, (int) ((adRemainingTime * 100.0f) / i)});
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void j() {
        this.t = true;
        AdImageView adImageView = this.l;
        if (adImageView != null) {
            adImageView.setVisibility(0);
        }
        this.k.setVisibility(this.u ? 8 : 0);
        this.k.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.c, R.drawable.bigo_ad_ic_media_play));
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onCompletion play");
        d(false);
        a("AdVideoComplete", (int[]) null);
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void k() {
        a("AdSizeChange", (int[]) null);
    }

    public final void l() {
        g gVar;
        if (this.e == null || (gVar = this.i) == null || !gVar.isAvailable() || this.L || this.e.bg() == null || this.e.ba()) {
            return;
        }
        Bitmap bitmap = (Bitmap) this.e.bg().first;
        this.L = true;
        z();
        a(bitmap);
        c cVar = this.p;
        a("AdBackupImgReady", new int[]{(cVar == null || TextUtils.isEmpty(cVar.b)) ? 0 : 1});
    }

    public final void m() {
        g gVar;
        if (this.e == null || (gVar = this.i) == null || this.L || !gVar.isAvailable() || this.e.ba()) {
            return;
        }
        this.L = true;
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "real video is download success, update media player datasource:  " + this.e.c(getContext()));
        this.p.a(this.e.c(getContext().getApplicationContext()));
    }

    @Override // sg.bigo.ads.core.player.b.f
    public final boolean n() {
        return this.K;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onDetachedFromWindow called");
        d(false);
        this.n = null;
    }

    @Override // android.view.View
    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onVisibilityChanged visibility != VISIBLE");
            d(false);
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onVisibilityChanged visibility == VISIBLE");
            d(true);
        }
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onWindowVisibilityChanged: ".concat(String.valueOf(i)));
        View view = this.M;
        if (view != null) {
            if (i == 0) {
                u.b(view);
                u.a(this.i, this, null, 0);
            } else {
                u.b(this.i);
                u.a(this.M, this, new FrameLayout.LayoutParams(this.g, this.h), 0);
            }
        }
    }

    public final void setIVideoPlayerViewListener(b bVar) {
        this.N = bVar;
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final void setMute(boolean z) {
        if (this.s == z) {
            this.A = false;
            return;
        }
        this.s = this.p.a(z);
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.c, this.s ? R.drawable.bigo_ad_ic_media_mute : R.drawable.bigo_ad_ic_media_unmute));
        }
        if (!this.A && !this.B) {
            a("AdVolumeChange", new int[]{this.s ? 0 : 100});
        } else {
            this.A = false;
            this.B = false;
        }
    }

    public final void setPlayInfo$505cff1c(String str) {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "setPlayInfo path=" + str + ",position=0");
        this.m = str;
        this.q = 0;
    }

    public final void setSeekPos(int i) {
        this.r = i;
    }

    @Override // sg.bigo.ads.core.player.b.f
    public final void setStatPrepareEventOnce(boolean z) {
        this.K = z;
    }
}
