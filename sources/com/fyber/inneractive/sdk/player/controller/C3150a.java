package com.fyber.inneractive.sdk.player.controller;

import android.content.Context;
import android.view.Surface;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.controller.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3150a extends q {
    public com.fyber.inneractive.sdk.player.mediaplayer.p p;
    public int q;
    public final int r;
    public int s;
    public boolean t;

    public C3150a(Context context) {
        super(context);
        this.q = 0;
        this.r = 2;
        this.s = 0;
        this.t = false;
        IAlog.a("Creating IAAndroidMediaPlayerController", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a() {
        com.fyber.inneractive.sdk.player.mediaplayer.p pVar = this.p;
        if (pVar != null) {
            pVar.reset();
            this.p.release();
            this.p = null;
        }
        super.a();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void b(boolean z) {
        c(true);
        if (g() && this.n) {
            return;
        }
        this.n = z;
        com.fyber.inneractive.sdk.player.mediaplayer.p pVar = this.p;
        if (pVar != null) {
            pVar.d();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final int c() {
        com.fyber.inneractive.sdk.player.mediaplayer.p pVar = this.p;
        if (pVar != null) {
            return pVar.r;
        }
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void d(boolean z) {
        c(false);
        if (g() || !this.n) {
            this.n = z;
            com.fyber.inneractive.sdk.player.mediaplayer.p pVar = this.p;
            if (pVar != null) {
                IAlog.a("%s unmute", pVar.b());
                pVar.d = false;
                if (pVar.a()) {
                    pVar.a(new com.fyber.inneractive.sdk.player.mediaplayer.m(pVar));
                } else {
                    IAlog.a("%s unmute called when player is not ready!", pVar.b());
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final int e() {
        com.fyber.inneractive.sdk.player.mediaplayer.p pVar = this.p;
        if (pVar != null) {
            return pVar.t;
        }
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final int f() {
        com.fyber.inneractive.sdk.player.mediaplayer.p pVar = this.p;
        if (pVar != null) {
            return pVar.s;
        }
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final boolean g() {
        com.fyber.inneractive.sdk.player.mediaplayer.p pVar = this.p;
        if (pVar != null) {
            return pVar.d;
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void i() {
        com.fyber.inneractive.sdk.player.mediaplayer.p pVar = this.p;
        if (pVar != null) {
            pVar.pause();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void j() {
        com.fyber.inneractive.sdk.player.mediaplayer.p pVar = this.p;
        if (pVar != null) {
            pVar.start();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a(int i, boolean z) {
        com.fyber.inneractive.sdk.player.mediaplayer.p pVar = this.p;
        if (pVar != null) {
            IAlog.a("%s seek to called with = %d mPlayAfterSeek = %s", pVar.b(), Integer.valueOf(i), Boolean.valueOf(z));
            if (!pVar.a()) {
                IAlog.a("%s seek called when player is not ready!", pVar.b());
                return;
            }
            com.fyber.inneractive.sdk.player.enums.b bVar = pVar.b;
            com.fyber.inneractive.sdk.player.enums.b bVar2 = com.fyber.inneractive.sdk.player.enums.b.Seeking;
            if (bVar == bVar2) {
                IAlog.a("%s seek called when player is already seeking!", pVar.b());
                return;
            }
            pVar.a(bVar2);
            pVar.c = z;
            pVar.a(new com.fyber.inneractive.sdk.player.mediaplayer.j(pVar, i));
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final int b() {
        com.fyber.inneractive.sdk.player.mediaplayer.p pVar = this.p;
        if (pVar != null) {
            return pVar.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final String d() {
        return "media";
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a(Surface surface) {
        com.fyber.inneractive.sdk.player.mediaplayer.p pVar = this.p;
        if (pVar != null) {
            pVar.setSurface(surface);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a(boolean z) {
        if (this.p == null) {
            IAlog.a("MediaPlayerController: creating media player", new Object[0]);
            this.p = new com.fyber.inneractive.sdk.player.mediaplayer.p(this.f1963a, this, this.i);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a(String str, int i) {
        this.p.a(str);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a(int i) {
        this.i.post(new l(this, i));
        if (i >= c()) {
            a(com.fyber.inneractive.sdk.player.enums.b.Completed);
        } else if (i == this.q) {
            IAlog.a("%sVideo is stuck! Progress doesn't change", IAlog.a(this));
            int i2 = this.s + 1;
            this.s = i2;
            if (i2 == this.r) {
                a(com.fyber.inneractive.sdk.player.enums.b.Buffering);
                this.t = true;
            }
        } else if (this.t) {
            IAlog.a("%sVideo progress was stuck! but now it goes forward. Remove buffering state", IAlog.a(this));
            a(com.fyber.inneractive.sdk.player.enums.b.Playing);
            this.s = 0;
            this.t = false;
        }
        this.q = i;
    }
}
