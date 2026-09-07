package com.yandex.mobile.ads.impl;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes11.dex */
public final class q32 implements cv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f9979a;
    private ByteBuffer[] b;
    private ByteBuffer[] c;

    public static class a implements cv0.b {
        protected static MediaCodec b(cv0.a aVar) throws IOException {
            aVar.f8643a.getClass();
            String str = aVar.f8643a.f9037a;
            n52.a("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            n52.a();
            return mediaCodecCreateByCodecName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.yandex.mobile.ads.impl.q32-IA] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // com.yandex.mobile.ads.impl.cv0.b
        public final cv0 a(cv0.a aVar) throws Throwable {
            MediaCodec mediaCodec = 0;
            mediaCodec = 0;
            try {
                MediaCodec mediaCodecB = b(aVar);
                try {
                    n52.a("configureCodec");
                    mediaCodecB.configure(aVar.b, aVar.d, aVar.e, 0);
                    n52.a();
                    n52.a("startCodec");
                    mediaCodecB.start();
                    n52.a();
                    return new q32(mediaCodecB);
                } catch (IOException | RuntimeException e) {
                    e = e;
                    mediaCodec = mediaCodecB;
                    if (mediaCodec != 0) {
                        mediaCodec.release();
                    }
                    throw e;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (RuntimeException e3) {
                e = e3;
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final ByteBuffer c(int i) {
        return x82.f10629a >= 21 ? this.f9979a.getOutputBuffer(i) : this.c[i];
    }

    private q32(MediaCodec mediaCodec) {
        this.f9979a = mediaCodec;
        if (x82.f10629a < 21) {
            this.b = mediaCodec.getInputBuffers();
            this.c = mediaCodec.getOutputBuffers();
        }
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final int b() {
        return this.f9979a.dequeueInputBuffer(0L);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final ByteBuffer b(int i) {
        if (x82.f10629a >= 21) {
            return this.f9979a.getInputBuffer(i);
        }
        return this.b[i];
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final int a(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.f9979a.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && x82.f10629a < 21) {
                this.c = this.f9979a.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void flush() {
        this.f9979a.flush();
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void release() {
        this.b = null;
        this.c = null;
        this.f9979a.release();
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final MediaFormat a() {
        return this.f9979a.getOutputFormat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(cv0.c cVar, MediaCodec mediaCodec, long j, long j2) {
        cVar.a(j);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(int i, int i2, long j, int i3) {
        this.f9979a.queueInputBuffer(i, 0, i2, j, i3);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(int i, dv dvVar, long j) {
        this.f9979a.queueSecureInputBuffer(i, 0, dvVar.a(), j, 0);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(int i, long j) {
        this.f9979a.releaseOutputBuffer(i, j);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(boolean z, int i) {
        this.f9979a.releaseOutputBuffer(i, z);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(final cv0.c cVar, Handler handler) {
        this.f9979a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.yandex.mobile.ads.impl.q32$$ExternalSyntheticLambda0
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                this.f$0.a(cVar, mediaCodec, j, j2);
            }
        }, handler);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(Surface surface) {
        this.f9979a.setOutputSurface(surface);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(Bundle bundle) {
        this.f9979a.setParameters(bundle);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(int i) {
        this.f9979a.setVideoScalingMode(i);
    }
}
