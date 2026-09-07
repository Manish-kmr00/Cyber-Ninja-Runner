package com.five_corp.ad.internal.movie.partialcache.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.five_corp.ad.internal.movie.partialcache.v1;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes13.dex */
public final class h extends MediaCodec.Callback implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1489a;
    public final Handler b;
    public final MediaCodec c;
    public int d;

    public h(MediaCodec mediaCodec, b bVar, Looper looper) {
        System.identityHashCode(this);
        this.c = mediaCodec;
        this.f1489a = bVar;
        this.b = new Handler(looper);
        this.d = 1;
    }

    public final ByteBuffer a(int i) {
        try {
            return this.c.getOutputBuffer(i);
        } catch (Exception e) {
            a(new o(p.Z4, null, e, null));
            return null;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        a(new o(p.W4, "DiagnosticInfo: " + codecException.getDiagnosticInfo() + ", error code: " + codecException.getErrorCode() + ", isRecoverable: " + codecException.isRecoverable() + ", isTransient: " + codecException.isTransient(), codecException, null));
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        this.b.post(new e(this, mediaCodec, i));
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        this.b.post(new f(this, i, bufferInfo));
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        this.b.post(new g(this, mediaFormat));
    }

    public final void a(o oVar) {
        if (this.d == 4) {
            return;
        }
        this.d = 4;
        this.f1489a.a(oVar);
    }

    public final void a(a aVar, v1 v1Var, int i) {
        if (this.d != 2) {
            return;
        }
        try {
            this.c.queueInputBuffer(aVar.f1484a, 0, i, v1Var.d, v1Var.e);
        } catch (Exception e) {
            a(new o(p.Y4, null, e, null));
        }
    }

    public final void a() {
        if (this.d == 3) {
            return;
        }
        this.d = 3;
        this.c.release();
        this.b.removeCallbacksAndMessages(null);
    }

    public final void a(i iVar, boolean z) {
        if (this.d != 2) {
            return;
        }
        try {
            this.c.releaseOutputBuffer(iVar.f1490a, z);
        } catch (Exception e) {
            a(new o(p.a5, null, e, null));
        }
    }

    public final void a(MediaFormat mediaFormat, Surface surface) {
        if (this.d != 1) {
            return;
        }
        this.c.setCallback(this);
        try {
            this.c.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            try {
                this.c.start();
                this.d = 2;
            } catch (Exception e) {
                a(new o(p.V4, null, e, null));
            }
        } catch (Exception e2) {
            a(new o(p.U4, null, e2, null));
        }
    }
}
