package com.yandex.mobile.ads.impl;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import io.bidmachine.iab.vast.tags.VastTagName;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
final class gh implements cv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f9003a;
    private final ih b;
    private final hh c;
    private final boolean d;
    private boolean e;
    private int f;

    public static final class a implements cv0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m32<HandlerThread> f9004a;
        private final m32<HandlerThread> b;

        public a(final int i) {
            this(new m32() { // from class: com.yandex.mobile.ads.impl.gh$a$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.m32
                public final Object get() {
                    return gh.a.a(i);
                }
            }, new m32() { // from class: com.yandex.mobile.ads.impl.gh$a$$ExternalSyntheticLambda1
                @Override // com.yandex.mobile.ads.impl.m32
                public final Object get() {
                    return gh.a.b(i);
                }
            });
        }

        a(m32 m32Var, m32 m32Var2) {
            this.f9004a = m32Var;
            this.b = m32Var2;
        }

        @Override // com.yandex.mobile.ads.impl.cv0.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final gh a(cv0.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            String str = aVar.f8643a.f9037a;
            gh ghVar = null;
            try {
                n52.a("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    gh ghVar2 = new gh(mediaCodecCreateByCodecName, this.f9004a.get(), this.b.get(), false);
                    try {
                        n52.a();
                        ghVar2.a(aVar.b, aVar.d, aVar.e);
                        return ghVar2;
                    } catch (Exception e) {
                        e = e;
                        ghVar = ghVar2;
                        if (ghVar != null) {
                            ghVar.release();
                        } else if (mediaCodecCreateByCodecName != null) {
                            mediaCodecCreateByCodecName.release();
                        }
                        throw e;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                mediaCodecCreateByCodecName = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static HandlerThread a(int i) {
            StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecAsyncAdapter:");
            if (i == 1) {
                sb.append("Audio");
            } else if (i == 2) {
                sb.append(VastTagName.VIDEO);
            } else {
                sb.append("Unknown(").append(i).append(")");
            }
            return new HandlerThread(sb.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static HandlerThread b(int i) {
            StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecQueueingThread:");
            if (i == 1) {
                sb.append("Audio");
            } else if (i == 2) {
                sb.append(VastTagName.VIDEO);
            } else {
                sb.append("Unknown(").append(i).append(")");
            }
            return new HandlerThread(sb.toString());
        }
    }

    private gh(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z) {
        this.f9003a = mediaCodec;
        this.b = new ih(handlerThread);
        this.c = new hh(mediaCodec, handlerThread2);
        this.d = z;
        this.f = 0;
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final int b() {
        return this.b.a();
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final int a(MediaCodec.BufferInfo bufferInfo) {
        return this.b.a(bufferInfo);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final ByteBuffer c(int i) {
        return this.f9003a.getOutputBuffer(i);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void flush() {
        this.c.a();
        this.f9003a.flush();
        this.b.b();
        this.f9003a.start();
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void release() {
        try {
            if (this.f == 1) {
                this.c.c();
                this.b.e();
            }
            this.f = 2;
        } finally {
            if (!this.e) {
                this.f9003a.release();
                this.e = true;
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final MediaFormat a() {
        return this.b.c();
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final ByteBuffer b(int i) {
        return this.f9003a.getInputBuffer(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto) {
        this.b.a(this.f9003a);
        n52.a("configureCodec");
        this.f9003a.configure(mediaFormat, surface, mediaCrypto, 0);
        n52.a();
        this.c.d();
        n52.a("startCodec");
        this.f9003a.start();
        n52.a();
        this.f = 1;
    }

    private void c() {
        if (this.d) {
            try {
                this.c.e();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(cv0.c cVar, MediaCodec mediaCodec, long j, long j2) {
        cVar.a(j);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(int i, int i2, long j, int i3) {
        this.c.a(i, i2, j, i3);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(int i, dv dvVar, long j) {
        this.c.a(i, dvVar, j);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(int i, long j) {
        this.f9003a.releaseOutputBuffer(i, j);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(boolean z, int i) {
        this.f9003a.releaseOutputBuffer(i, z);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(final cv0.c cVar, Handler handler) {
        c();
        this.f9003a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.yandex.mobile.ads.impl.gh$$ExternalSyntheticLambda0
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                this.f$0.a(cVar, mediaCodec, j, j2);
            }
        }, handler);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(Surface surface) {
        c();
        this.f9003a.setOutputSurface(surface);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(Bundle bundle) {
        c();
        this.f9003a.setParameters(bundle);
    }

    @Override // com.yandex.mobile.ads.impl.cv0
    public final void a(int i) {
        c();
        this.f9003a.setVideoScalingMode(i);
    }
}
