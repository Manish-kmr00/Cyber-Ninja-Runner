package com.five_corp.ad.internal.movie;

import android.view.Surface;
import com.safedk.android.internal.special.SpecialsBridge;

/* JADX INFO: loaded from: classes8.dex */
public final class I implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1431a;
    public final /* synthetic */ Surface b;

    public I(L l, Surface surface) {
        this.f1431a = l;
        this.b = surface;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.five_corp.ad.internal.movie.L, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1431a.c();
        SpecialsBridge.surfaceRelease(this.b);
    }
}
