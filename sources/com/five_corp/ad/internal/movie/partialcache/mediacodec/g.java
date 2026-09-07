package com.five_corp.ad.internal.movie.partialcache.mediacodec;

import android.media.MediaFormat;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaFormat f1488a;
    public final /* synthetic */ h b;

    public g(h hVar, MediaFormat mediaFormat) {
        this.b = hVar;
        this.f1488a = mediaFormat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.b;
        if (hVar.d != 2) {
            return;
        }
        hVar.f1489a.a(hVar, this.f1488a);
    }
}
