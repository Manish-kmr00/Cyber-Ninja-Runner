package com.five_corp.ad.internal.movie;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.safedk.android.internal.special.SpecialsBridge;

/* JADX INFO: loaded from: classes8.dex */
public final class K implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1433a;
    public final /* synthetic */ Surface b;
    public final /* synthetic */ SurfaceTexture c;

    public K(L l, Surface surface, SurfaceTexture surfaceTexture) {
        this.f1433a = l;
        this.b = surface;
        this.c = surfaceTexture;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.five_corp.ad.internal.movie.L, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1433a.c();
        SpecialsBridge.surfaceRelease(this.b);
        this.c.release();
    }
}
