package com.five_corp.ad.internal.movie.partialcache.mediacodec;

import android.media.MediaCodec;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1487a;
    public final /* synthetic */ MediaCodec.BufferInfo b;
    public final /* synthetic */ h c;

    public f(h hVar, int i, MediaCodec.BufferInfo bufferInfo) {
        this.c = hVar;
        this.f1487a = i;
        this.b = bufferInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.c;
        if (hVar.d != 2) {
            return;
        }
        hVar.f1489a.a(hVar, new i(this.f1487a, this.b));
    }
}
