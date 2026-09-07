package com.five_corp.ad.internal.movie.partialcache.mediacodec;

import android.media.MediaCodec;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaCodec f1486a;
    public final /* synthetic */ int b;
    public final /* synthetic */ h c;

    public e(h hVar, MediaCodec mediaCodec, int i) {
        this.c = hVar;
        this.f1486a = mediaCodec;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.d != 2) {
            return;
        }
        try {
            ByteBuffer inputBuffer = this.f1486a.getInputBuffer(this.b);
            if (inputBuffer == null) {
                return;
            }
            h hVar = this.c;
            a aVar = new a(this.b, inputBuffer);
            if (hVar.f1489a.a(hVar, aVar)) {
                return;
            }
            hVar.b.postDelayed(new d(hVar, aVar), 100L);
        } catch (Exception e) {
            this.c.a(new o(p.X4, null, e, null));
        }
    }
}
