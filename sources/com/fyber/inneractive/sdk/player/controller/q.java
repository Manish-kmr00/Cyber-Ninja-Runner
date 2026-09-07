package com.fyber.inneractive.sdk.player.controller;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public abstract class q implements com.fyber.inneractive.sdk.player.mediaplayer.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1963a;
    public x d;
    public com.fyber.inneractive.sdk.player.c f;
    public boolean g;
    public final Handler i;
    public TextureView j;
    public SurfaceTexture k;
    public Surface l;
    public i m;
    public boolean o;
    public com.fyber.inneractive.sdk.player.enums.b e = com.fyber.inneractive.sdk.player.enums.b.Idle;
    public boolean n = false;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public com.fyber.inneractive.sdk.player.h h = new com.fyber.inneractive.sdk.player.h(this);

    public q(Context context) {
        this.f1963a = context.getApplicationContext();
        this.i = new Handler(context.getMainLooper());
        a(true);
    }

    public abstract void a(int i, boolean z);

    public abstract void a(Surface surface);

    public abstract void a(String str, int i);

    public abstract void a(boolean z);

    public abstract int b();

    public abstract void b(boolean z);

    public abstract int c();

    public final void c(boolean z) {
        com.fyber.inneractive.sdk.measurement.g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.f;
        if (cVar == null || (gVar = cVar.f1938a.e) == null) {
            return;
        }
        if (z) {
            if (gVar.c == null || !gVar.d) {
                return;
            }
            IAlog.a("%s mute", "OMVideo");
            try {
                gVar.c.volumeChange(0.0f);
                return;
            } catch (Throwable th) {
                gVar.a(th);
                return;
            }
        }
        if (gVar.c == null || !gVar.d) {
            return;
        }
        IAlog.a("%s unMute", "OMVideo");
        try {
            gVar.c.volumeChange(1.0f);
        } catch (Throwable th2) {
            gVar.a(th2);
        }
    }

    public abstract String d();

    public abstract void d(boolean z);

    public abstract int e();

    public abstract int f();

    public abstract boolean g();

    public boolean h() {
        return this.e == com.fyber.inneractive.sdk.player.enums.b.Playing;
    }

    public abstract void i();

    public abstract void j();

    public final void k() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        com.fyber.inneractive.sdk.player.h hVar = this.h;
        if (hVar == null || (scheduledThreadPoolExecutor = hVar.b) == null) {
            return;
        }
        scheduledThreadPoolExecutor.shutdownNow();
        hVar.b = null;
    }

    public void a() {
        IAlog.a("%sdestroy started", IAlog.a(this));
        k();
        this.h = null;
        AbstractC3256u.a(this.j);
        this.j = null;
        SurfaceTexture surfaceTexture = this.k;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.k = null;
        }
        Surface surface = this.l;
        if (surface != null) {
            surface.release();
            this.l = null;
        }
        this.i.removeCallbacksAndMessages(null);
        this.b.clear();
        this.f = null;
        this.g = true;
        IAlog.a("%sdestroy finished", IAlog.a(this));
    }

    public final void a(TextureView textureView) {
        TextureView textureView2 = this.j;
        if (textureView2 != textureView) {
            if (textureView2 != null) {
                textureView2.setSurfaceTextureListener(null);
            }
            this.j = textureView;
            if (textureView != null) {
                i iVar = this.m;
                if (iVar == null) {
                    iVar = new i(this);
                    this.m = iVar;
                }
                textureView.setSurfaceTextureListener(iVar);
            }
            if (this.k != null) {
                IAlog.a("%scalling setSurfaceTexture with cached texture", IAlog.a(this));
                if (this.j.getSurfaceTexture() != null && this.j.getSurfaceTexture().equals(this.k)) {
                    IAlog.a("%scalling setSurfaceTexture with cached texture failed", IAlog.a(this));
                } else {
                    IAlog.a("%scalling setSurfaceTexture with cached texture success", IAlog.a(this));
                    this.j.setSurfaceTexture(this.k);
                }
            }
        }
    }

    public static void a(q qVar, SurfaceTexture surfaceTexture) {
        boolean zEquals = surfaceTexture.equals(qVar.k);
        SurfaceTexture surfaceTexture2 = qVar.k;
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        qVar.k = surfaceTexture;
        Surface surface = qVar.l;
        if (surface == null || !zEquals) {
            if (surface != null) {
                surface.release();
            }
            qVar.l = new Surface(qVar.k);
        }
        qVar.a(qVar.l);
    }

    public void a(int i) {
        this.i.post(new l(this, i));
    }

    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        if (bVar == this.e) {
            return;
        }
        this.e = bVar;
        if (bVar == com.fyber.inneractive.sdk.player.enums.b.Playing) {
            com.fyber.inneractive.sdk.player.h hVar = this.h;
            if (hVar != null && hVar.b == null) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
                hVar.b = scheduledThreadPoolExecutor;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(hVar.c, 100, 1000, TimeUnit.MILLISECONDS);
            }
        } else if (bVar == com.fyber.inneractive.sdk.player.enums.b.Paused || bVar == com.fyber.inneractive.sdk.player.enums.b.Idle || bVar == com.fyber.inneractive.sdk.player.enums.b.Completed) {
            k();
        }
        this.i.post(new m(this, bVar));
    }
}
