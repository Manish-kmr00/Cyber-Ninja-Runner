package com.yandex.mobile.ads.impl;

import android.view.TextureView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f70 implements oa1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k60 f8872a;
    private final ww0 b;
    private final ef2 c;
    private final na1 d;
    private final of2 e;
    private final a f;
    private final w60 g;
    private gb1 h;
    private qc2 i;
    private boolean j;
    private boolean k;

    private final class a implements di1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8873a;
        private boolean b;
        private boolean c;

        @Override // com.yandex.mobile.ads.impl.di1.b
        public final void b(j60 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.f8873a = false;
            f70.this.g.b();
            f70.this.f8872a.stop();
            f70.this.c.a(error.getMessage());
            qc2 qc2Var = f70.this.i;
            jc2 jc2Var = f70.this.h;
            if (qc2Var == null || jc2Var == null) {
                return;
            }
            f70.this.d.getClass();
            qc2Var.a(jc2Var, na1.a(error));
        }

        @Override // com.yandex.mobile.ads.impl.di1.b
        public final void onPlaybackStateChanged(int i) {
            if (i == 2) {
                this.b = true;
                qc2 qc2Var = f70.this.i;
                jc2 jc2Var = f70.this.h;
                if (qc2Var == null || jc2Var == null) {
                    return;
                }
                qc2Var.f(jc2Var);
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                this.f8873a = false;
                qc2 qc2Var2 = f70.this.i;
                jc2 jc2Var2 = f70.this.h;
                if (qc2Var2 == null || jc2Var2 == null) {
                    return;
                }
                qc2Var2.a(jc2Var2);
                return;
            }
            f70.this.g.b();
            qc2 qc2Var3 = f70.this.i;
            jc2 jc2Var3 = f70.this.h;
            if (qc2Var3 != null && jc2Var3 != null) {
                qc2Var3.d(jc2Var3);
            }
            if (this.b) {
                this.b = false;
                qc2 qc2Var4 = f70.this.i;
                jc2 jc2Var4 = f70.this.h;
                if (qc2Var4 == null || jc2Var4 == null) {
                    return;
                }
                qc2Var4.c(jc2Var4);
            }
        }

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.di1.b
        public final void onIsPlayingChanged(boolean z) {
            if (z) {
                if (!this.f8873a) {
                    qc2 qc2Var = f70.this.i;
                    jc2 jc2Var = f70.this.h;
                    if (qc2Var == null || jc2Var == null) {
                        return;
                    }
                    this.f8873a = true;
                    qc2Var.h(jc2Var);
                    return;
                }
                if (this.c) {
                    this.c = false;
                    qc2 qc2Var2 = f70.this.i;
                    jc2 jc2Var2 = f70.this.h;
                    if (qc2Var2 == null || jc2Var2 == null) {
                        return;
                    }
                    qc2Var2.g(jc2Var2);
                    return;
                }
                return;
            }
            if (this.b) {
                return;
            }
            this.c = true;
            qc2 qc2Var3 = f70.this.i;
            jc2 jc2Var3 = f70.this.h;
            if (qc2Var3 == null || jc2Var3 == null) {
                return;
            }
            qc2Var3.b(jc2Var3);
        }
    }

    public f70(k60 exoPlayer, ww0 mediaSourceProvider, ef2 playerEventsReporter, na1 videoAdPlayerErrorConverter, of2 videoScaleController) {
        Intrinsics.checkNotNullParameter(exoPlayer, "exoPlayer");
        Intrinsics.checkNotNullParameter(mediaSourceProvider, "mediaSourceProvider");
        Intrinsics.checkNotNullParameter(playerEventsReporter, "playerEventsReporter");
        Intrinsics.checkNotNullParameter(videoAdPlayerErrorConverter, "videoAdPlayerErrorConverter");
        Intrinsics.checkNotNullParameter(videoScaleController, "videoScaleController");
        this.f8872a = exoPlayer;
        this.b = mediaSourceProvider;
        this.c = playerEventsReporter;
        this.d = videoAdPlayerErrorConverter;
        this.e = videoScaleController;
        a aVar = new a();
        this.f = aVar;
        this.g = new w60(aVar);
        exoPlayer.b(aVar);
        exoPlayer.b(videoScaleController);
        e6.a(this);
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final void pauseAd() {
        if (this.j) {
            return;
        }
        this.f8872a.setPlayWhenReady(false);
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final void resumeAd() {
        if (this.j || this.k) {
            return;
        }
        this.f8872a.setPlayWhenReady(true);
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final void setVolume(float f) {
        if (this.j) {
            return;
        }
        this.f8872a.setVolume(f);
        qc2 qc2Var = this.i;
        gb1 gb1Var = this.h;
        if (qc2Var == null || gb1Var == null) {
            return;
        }
        qc2Var.a(gb1Var, f);
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final void a(pc2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (this.j) {
            return;
        }
        this.j = true;
        this.k = false;
        this.g.b();
        this.f8872a.setVideoTextureView(null);
        this.e.a((TextureView) null);
        this.f8872a.a(this.f);
        this.f8872a.a(this.e);
        this.f8872a.release();
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final void c() {
        if (!this.j) {
            this.f8872a.setPlayWhenReady(true);
        }
        if (this.k) {
            pauseAd();
        }
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final void a(gb1 playbackInfo) {
        Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        this.h = playbackInfo;
        if (this.j) {
            return;
        }
        cm1 cm1VarA = this.b.a(playbackInfo);
        this.f8872a.setPlayWhenReady(false);
        this.f8872a.a(cm1VarA);
        this.f8872a.prepare();
        this.g.a();
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final float getVolume() {
        return this.f8872a.getVolume();
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final boolean e() {
        return this.j;
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final long getAdPosition() {
        return this.f8872a.getCurrentPosition();
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final boolean isPlayingAd() {
        return ((qk) this.f8872a).b();
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final long b() {
        return this.f8872a.getDuration();
    }

    @Override // com.yandex.mobile.ads.impl.fc0
    public final void f() {
        this.k = true;
        pauseAd();
    }

    @Override // com.yandex.mobile.ads.impl.fc0
    public final void d() {
        this.k = false;
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final void a(qc2 qc2Var) {
        this.i = qc2Var;
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final void a(TextureView textureView) {
        if (this.j) {
            return;
        }
        this.e.a(textureView);
        this.f8872a.setVideoTextureView(textureView);
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final void a(qf2 qf2Var) {
        if (this.j) {
            return;
        }
        this.e.a(qf2Var);
    }

    @Override // com.yandex.mobile.ads.impl.oa1
    public final void a() {
        if (this.j) {
            return;
        }
        qc2 qc2Var = this.i;
        gb1 gb1Var = this.h;
        if (qc2Var != null && gb1Var != null) {
            qc2Var.e(gb1Var);
        }
        this.j = true;
        this.k = false;
        this.g.b();
        this.f8872a.setVideoTextureView(null);
        this.e.a((TextureView) null);
        this.f8872a.a(this.f);
        this.f8872a.a(this.e);
        this.f8872a.release();
    }
}
