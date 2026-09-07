package com.five_corp.ad.internal.cache;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1342a;
    public final /* synthetic */ Bitmap b;

    public h(e eVar, Bitmap bitmap) {
        this.f1342a = eVar;
        this.b = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1342a.a(this.b);
    }
}
