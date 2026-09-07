package com.five_corp.ad.internal.movie;

import android.view.Surface;

/* JADX INFO: loaded from: classes8.dex */
public final class H implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1430a;
    public final /* synthetic */ Surface b;

    public H(L l, Surface surface) {
        this.f1430a = l;
        this.b = surface;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.five_corp.ad.internal.movie.L, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1430a.a(this.b);
    }
}
