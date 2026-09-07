package com.five_corp.ad.internal.movie;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;
import com.safedk.android.internal.special.SpecialsBridge;

/* JADX INFO: loaded from: classes8.dex */
public final class M implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.logger.a f1434a;
    public final Object b;
    public SurfaceTexture c;
    public Surface d;
    public Object e;
    public Handler f;
    public boolean g;

    public M(TextureView textureView, com.five_corp.ad.internal.logger.a aVar) {
        System.identityHashCode(this);
        this.b = new Object();
        this.g = false;
        this.f1434a = aVar;
        textureView.setSurfaceTextureListener(this);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.five_corp.ad.internal.movie.L, java.lang.Object] */
    public final void a() {
        synchronized (this.b) {
            Surface surface = this.d;
            if (surface == null) {
                return;
            }
            this.d = null;
            ?? r2 = this.e;
            Handler handler = this.f;
            if (r2 == 0 || handler == null) {
                SpecialsBridge.surfaceRelease(surface);
            } else {
                handler.post(new I(r2, surface));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.five_corp.ad.internal.movie.L, java.lang.Object] */
    public final void b() {
        synchronized (this.b) {
            Surface surface = this.d;
            if (surface != null) {
                this.g = false;
            } else if (this.c == null) {
                this.g = true;
                return;
            } else {
                this.g = false;
                surface = new Surface(this.c);
                this.d = surface;
            }
            ?? r2 = this.e;
            Handler handler = this.f;
            if (r2 == 0 || handler == null) {
                return;
            }
            handler.post(new H(r2, surface));
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.five_corp.ad.internal.movie.L, java.lang.Object] */
    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface;
        boolean z;
        ?? r0;
        Handler handler;
        try {
            synchronized (this.b) {
                this.c = surfaceTexture;
                surface = new Surface(surfaceTexture);
                this.d = surface;
                z = this.g;
                this.g = false;
                r0 = this.e;
                handler = this.f;
            }
            if (r0 == 0 || handler == null || !z) {
                return;
            }
            handler.post(new J(r0, surface));
        } catch (Throwable th) {
            this.f1434a.a(th);
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.five_corp.ad.internal.movie.L, java.lang.Object] */
    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        try {
            synchronized (this.b) {
                if (this.c != surfaceTexture) {
                    return true;
                }
                this.c = null;
                Surface surface = this.d;
                if (surface == null) {
                    return true;
                }
                this.d = null;
                ?? r2 = this.e;
                Handler handler = this.f;
                if (r2 == 0 || handler == null) {
                    return true;
                }
                handler.post(new K(r2, surface, surfaceTexture));
                return false;
            }
        } catch (Throwable th) {
            this.f1434a.a(th);
            return true;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
