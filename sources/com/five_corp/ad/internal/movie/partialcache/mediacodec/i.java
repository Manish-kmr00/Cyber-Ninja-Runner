package com.five_corp.ad.internal.movie.partialcache.mediacodec;

import android.media.MediaCodec;

/* JADX INFO: loaded from: classes13.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1490a;
    public final MediaCodec.BufferInfo b;

    public i(int i, MediaCodec.BufferInfo bufferInfo) {
        this.f1490a = i;
        this.b = bufferInfo;
    }

    public final long a() {
        return this.b.presentationTimeUs;
    }

    public final boolean b() {
        return this.b.size == 0;
    }
}
